package io.resourcepool.hvsz.controllers;

import io.resourcepool.hvsz.persistance.models.GameStatus;
import io.resourcepool.hvsz.service.ResourceServiceImpl;
import io.resourcepool.hvsz.service.StatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Cron {

    @Autowired
    private StatusServiceImpl statusService;

    @Autowired
    private ResourceServiceImpl resourceService;

    @Scheduled(fixedRate = 60000)
    public void doSomething() {

        GameStatus status = statusService.get(1L);
        if (status.getStarted() && status.getTimeLeft() > 0) {
            status.setTimeLeft(status.getTimeLeft() - 1);
            statusService.add(status, 1L);
            resourceService.decreaseSafezones(-1);
        }
    }
}
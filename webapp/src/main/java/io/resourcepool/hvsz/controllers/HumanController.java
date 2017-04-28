package io.resourcepool.hvsz.controllers;

import io.resourcepool.hvsz.persistance.models.Zone;
import io.resourcepool.hvsz.persistance.models.ZoneResource;
import io.resourcepool.hvsz.service.HumanService;
import io.resourcepool.hvsz.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HumanController {

    @Autowired
    HumanService humanService;
    @Autowired
    ResourceService resourceService;

    /**
     * Get the human page.
     *
     * @param newLife String
     * @param model   Model
     * @return String (human)
     */
    @GetMapping("/human")
    public String human(@RequestParam(value = "newlife", required = false) String newLife, Model model) {
        if (newLife != null) {
            Integer lifeToken = humanService.newLife();
            if (lifeToken != -1) {
                model.addAttribute("newlife", "New life for you <3  token: " + lifeToken);
            } else {
                model.addAttribute("newlife", "Sorry no more life ;-(");
            }
        }
        return "human";
    }

    /**
     * Interface for select a safe zone.
     *
     * @param model Model
     * @return String (safe-zone vue)
     */
    @GetMapping("/human/zone")
    public String selectZone(Model model) {
        List<ZoneResource> zones = resourceService.getAllZoneResource();
        model.addAttribute("zones", zones);
        return "zone";
    }

    /**
     * Interface for select a safe zone.
     *
     * @param model Model
     * @param id    the zone we want to access
     * @param type  the type of zone
     * @return String (safe-zone vue)
     */
    @PostMapping("/human/zone")
    public String displayZone(
            @RequestParam(value = "id") String id,
            @RequestParam(value = "type") String type,
            Model model) {

        Zone zone;
        if (type.equals("safezone")) {
            zone = resourceService.getSafeZone(id);
            model.addAttribute("zone", zone);
            return "safe-zone";
        } else {
            zone = resourceService.getSupplyZone(Integer.parseInt(id));
            model.addAttribute("zone", zone);
            return "supply-zone";
        }
    }
}

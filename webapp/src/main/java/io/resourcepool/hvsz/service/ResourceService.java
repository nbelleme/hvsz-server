package io.resourcepool.hvsz.service;

import io.resourcepool.hvsz.persistance.models.SafeZone;
import io.resourcepool.hvsz.persistance.models.SupplyZone;
import io.resourcepool.hvsz.persistance.models.ZoneResource;

import java.util.ArrayList;
import java.util.List;

public interface ResourceService {

    /**
     * Take resources on a supply zone.
     * @param supplyZone the supply zone where we take resources.
     * @param amount number max of resources we want to take.
     * @return the number of resources taken.
     */
    int get(SupplyZone supplyZone, int amount);

    /**
     * Take resources on a supply zone.
     * @param idSupplyZone the id of the supply zone where we take resources.
     * @param amount number max of resources we want to take.
     * @return the number of resources taken.
     */
    int get(int idSupplyZone, int amount);


    /**
     * Decrease an amount on all safezones.
     * @param amount of resource de decrease all Safe Zone
     */
    void decreaseSafezones(int amount);

    /**
     * Get the correponding safe zone.
     * @param safeId the id of the safe zone
     * @return the SafeZone
     */
    SafeZone getSafeZone(int safeId);

    /**
     * Return all the Safe Zone.
     * @return a list of safe zone
     */
    List<SafeZone> getAllSafeZone();

    /**
     * Get the correponding supply zone.
     * @param supplyId the id of the supply zone
     * @return the SupplyZone
     */
    SupplyZone getSupplyZone(int supplyId);

    /**
     * Return all the Supply Zone.
     * @return a list of supply zone
     */
    List<SupplyZone> getAllSupplyZone();

    /**
     * Return all the Safe Zone and Supply Zone.
     * @return a list of ZoneResource
     */
    List<ZoneResource> getAllZoneResource();

    /**
     ** Drop resources on a safe zone by id.
     * @param safeZoneId the safe zone id where we drop resources.
     * @param amount qte
     * @param id life id
     * @return dropped amount
     */
    int dropById(int safeZoneId, int amount, int id);

    /**
     * set supply zones.
     * @param zones .
     */
    void setSupplyZones(ArrayList<SupplyZone> zones);

    /**
     * set safes zones.
     * @param zones .
     */
    void setSafeZones(ArrayList<SafeZone> zones);
}

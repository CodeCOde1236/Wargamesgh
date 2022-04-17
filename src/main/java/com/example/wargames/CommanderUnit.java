package com.example.wargames;

public class CommanderUnit extends CavalryUnit{
    /**
     * Constructor
     *
     * @param name   Name of the unit
     * @param health Health of the unit
     * @param armour The protection the unit has
     * @param attack The ability to damage
     */
    public CommanderUnit(String name, int health, int armour, int attack) {
        super(name, health, armour, attack);
    }

    public CommanderUnit(String name, int health) {
        super(name, health, 15, 25);
    }
}

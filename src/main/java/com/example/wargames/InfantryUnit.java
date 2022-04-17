package com.example.wargames;

public class InfantryUnit extends Unit{


    /**
     * Constructor
     *
     * @param name   Name of the unit
     * @param health Health of the unit
     * @param armour The protection the unit has
     * @param attack The ability to damage
     */
    public InfantryUnit(String name, int health, int armour, int attack) {
        super(name, health, armour, attack);
    }

    public InfantryUnit(String name, int health) {
        super(name, health, 10, 15);
    }

    @Override
    public int getAttackBonus() {
        return 2;
    }

    @Override
    public int getResistBonus() {
        return 1;
    }
}

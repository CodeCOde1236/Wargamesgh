package com.example.wargames;

public class RangedUnit extends Unit{

    int resistValue;
    /**
     * Constructor
     *
     * @param name   Name of the unit
     * @param health Health of the unit
     * @param armour The protection the unit has
     * @param attack The ability to damage
     */
    public RangedUnit(String name, int health, int armour, int attack) {
        super(name, health, armour, attack);
        resistValue = 10;
    }

    public RangedUnit(String name, int health) {
        super(name, health, 8, 15);
        resistValue = 10;
    }

    @Override
    public int getAttackBonus() {
        return 3;
    }

    @Override
    public int getResistBonus() {
        if(resistValue > 2){
            resistValue -= 2;
        }
        return resistValue;
    }
}

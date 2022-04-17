package com.example.wargames;

public class CavalryUnit extends Unit {

    boolean firstAttack;
    /**
     * Constructor
     *
     * @param name   Name of the unit
     * @param health Health of the unit
     * @param armour The protection the unit has
     * @param attack The ability to damage
     */
    public CavalryUnit(String name, int health, int armour, int attack) {
        super(name, health, armour, attack);
        firstAttack = true;
    }

    public CavalryUnit(String name, int health) {
        super(name, health, 12, 20);
        firstAttack = true;
    }

    @Override
    public int getAttackBonus() {
        int currentAttack = 2;
        if(firstAttack){
            currentAttack = 6;
            firstAttack = false;
        }
        return currentAttack;
    }

    @Override
    public int getResistBonus() {
        return 1;
    }
}

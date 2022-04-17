public abstract class Unit {

    private String name;
    private int health;
    private int armour;
    private int attack;

    /**
     * Constructor
     * @param name Name of the unit
     * @param health Health of the unit
     * @param armour The protection the unit has
     * @param attack The ability to damage
     */
    public Unit(String name, int health, int armour, int attack) {
        this.name = name;
        this.health = health;
        this.armour = armour;
        this.attack = attack;
    }

    /**
     * The method used for attacking other units
     * @param opponent The attacked unit
     */
    public void attack(Unit opponent){
        opponent.setHealth(opponent.getHealth() - (this.getAttack() + this.getAttackBonus()) + opponent.getArmour() + opponent.getResistBonus());
    }


    public void setHealth(int newHealth){
        health = newHealth;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getArmour() {
        return armour;
    }

    public int getAttack() {
        return attack;
    }

    public abstract int getAttackBonus();
    public abstract int getResistBonus();

    /**
     * Returns overview of unit
     * @return
     */
    @Override
    public String toString() {
        return "Unit{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", armour=" + armour +
                ", attack=" + attack +
                '}';
    }
}

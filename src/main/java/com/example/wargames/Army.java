package com.example.wargames;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

public class Army {

    private String name;
    private List<Unit> units;

    public Army(String name, List<Unit> units) {
        this.name = name;
        this.units = units;
    }

    public Army(String name) {
        this.name = name;
        this.units = new ArrayList<>();
    }

    public void add(Unit unit){
        units.add(unit);
    }

    public void addAll(List<Unit> newUnits){
        units.addAll(newUnits);
    }

    public void remove(Unit unit){
        units.remove(unit);
    }

    /**
     * Checks if the army has remaining units
     * @return True if army has units, else false
     */
    public boolean hasUnits(){
        boolean returnVal = false;
        if(units.size() > 0){
            returnVal = true;
        }
        return returnVal;
    }

    public Unit getRandom(){
        Random random = new Random();
        return units.get(random.nextInt(units.size()));
    }

    public String getName() {
        return name;
    }

    public List<Unit> getAllUnits() {
        return units;
    }


    public List<Unit> getInfantryUnits(){
        return units.stream().filter(p -> p instanceof InfantryUnit).collect(Collectors.toList());
    }

    public List<Unit> getCavalryUnits(){
        CavalryUnit cavalry = new CavalryUnit("Cavalry", 15);
        return units.stream().filter(p -> p.getClass().equals(cavalry.getClass())).collect(Collectors.toList());
    }

    public List<Unit> getRangedUnits(){
        return units.stream().filter(p -> p instanceof RangedUnit).collect(Collectors.toList());
    }

    public List<Unit> getCommanderUnits(){
        return units.stream().filter(p -> p instanceof CommanderUnit ).collect(Collectors.toList());
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Army army = (Army) o;
        return name.equals(army.name) && units.equals(army.units);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, units);
    }

    @Override
    public String toString() {
        return "Army{" +
                "name='" + name + '\'' +
                ", units=" + units +
                '}';
    }
}

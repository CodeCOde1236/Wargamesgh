package com.example.wargames;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UnitFactory {

    final private String name;
    private List<Unit> unitList;

    public UnitFactory(String name){

        this.name = name;
        unitList = new ArrayList<Unit>();
    }

    public Unit createUnit(String type, String name, int health){
        Unit newUnit = null;
        if(type.equals("CavalryUnit")){
            newUnit = new CavalryUnit(name, health);
        }
        if(type.equals("CommanderUnit")){
            newUnit = new CommanderUnit(name, health);
        }
        if(type.equals("InfantryUnit")){
            newUnit = new InfantryUnit(name, health);
        }
        if(type.equals("RangedUnit")){
            newUnit = new RangedUnit(name, health);
        }

        unitList.add(newUnit);

        return newUnit;
    }

    public List<Unit> unitSearch(String type, String name, int health){

        List<Unit> searchRes = new ArrayList<Unit>();

        for (Unit unit : unitList) {
            searchRes.add(unit);
        }

        searchRes = searchRes.stream().filter(p -> p instanceof CavalryUnit ).filter(n -> n.getName().equals(name)).filter(h -> h.getHealth() == health).collect(Collectors.toList());

        if(type.equals("CavalryUnit")){
            searchRes = searchRes.stream().filter(p -> p instanceof CavalryUnit ).collect(Collectors.toList());
        }
        if(type.equals("CommanderUnit")){
            searchRes = unitList.stream().filter(p -> p instanceof CommanderUnit ).collect(Collectors.toList());
        }
        if(type.equals("InfantryUnit")){
            searchRes = unitList.stream().filter(p -> p instanceof InfantryUnit ).collect(Collectors.toList());
        }
        if(type.equals("RangedUnit")){
            searchRes = unitList.stream().filter(p -> p instanceof RangedUnit ).collect(Collectors.toList());
        }

        return searchRes;
    }

}

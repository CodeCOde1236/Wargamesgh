package com.example.wargames;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Battle {
    Army armyOne;
    Army armyTwo;

    public Battle(Army armyOne, Army armyTwo) {
        this.armyOne = armyOne;
        this.armyTwo = armyTwo;
    }

    public Army simulate(){
        Army winner;
        int turnCount = 1;
        Random random = new Random();
        while(armyOne.getAllUnits().size() > 0 || armyTwo.getAllUnits().size() > 0){

            Unit armyOneUnit = armyOne.getRandom();
            Unit armyTwoUnit = armyTwo.getRandom();

            if(turnCount%2 == 0){
                armyOneUnit.attack(armyTwoUnit);
                if(armyTwoUnit.getHealth() <= 0){
                    armyTwo.remove(armyTwoUnit);
                }
            }
            else{
                armyTwoUnit.attack(armyOneUnit);
            }
            turnCount++;
        }
        if(armyOne.getAllUnits().size() > 0){
            winner = armyOne;
        }
        else{
            winner = armyTwo;
        }
        return winner;
    }

    @Override
    public String toString(){
        return armyOne.toString() + armyTwo.toString();
    }

}

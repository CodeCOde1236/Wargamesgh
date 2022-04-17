package com.example.wargames;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArmyTest {

    @Nested
    class Add {
        @Nested
        class Positive {
            @Test
            void addNewUnit() {
                Army armyOne = new Army("newArmy");
                RangedUnit archers = new RangedUnit("archers", 30);
                armyOne.add(archers);

                List<Unit> testList = new ArrayList<Unit>();
                testList.add(archers);

                Assertions.assertEquals(armyOne.getAllUnits(), testList);

            }

        }
    }

    @Nested
    class AddAll {
        @Nested
        class Positive {

            @Test
            void addNewUnitsOfSameType() {
                Army armyOne = new Army("newArmy");
                RangedUnit archersOne = new RangedUnit("archersOne", 30);
                RangedUnit archersTwo = new RangedUnit("archersTwo", 30);
                RangedUnit archersThree = new RangedUnit("archersThree", 30);
                armyOne.add(archersOne);
                armyOne.add(archersTwo);
                armyOne.add(archersThree);

                List<Unit> testList = new ArrayList<Unit>();
                testList.add(archersOne);
                testList.add(archersTwo);
                testList.add(archersThree);

                Assertions.assertEquals(armyOne.getAllUnits(), testList);


            }

            @Test
            void addNewUnitsOfMixedType() {
                Army armyOne = new Army("newArmy");
                RangedUnit unitOne = new RangedUnit("unitOne", 30);
                InfantryUnit unitTwo = new InfantryUnit("unitTwo", 30);
                CommanderUnit unitThree = new CommanderUnit("unitThree", 30);
                armyOne.add(unitOne);
                armyOne.add(unitTwo);
                armyOne.add(unitThree);

                List<Unit> testList = new ArrayList<Unit>();
                testList.add(unitOne);
                testList.add(unitTwo);
                testList.add(unitThree);

                Assertions.assertEquals(armyOne.getAllUnits(), testList);

            }

        }
    }

    @Nested
    class Remove {
        @Nested
        class Positive {
            @Test
            void removeLastUnit() {
                Army armyOne = new Army("newArmy");
                RangedUnit archers = new RangedUnit("archers", 30);
                armyOne.add(archers);
                armyOne.remove(archers);

                List<Unit> testList = new ArrayList<Unit>();

                Assertions.assertEquals(armyOne.getAllUnits(), testList);
            }

            @Test
            void removeUnitFromNonEmptyList() {
                Army armyOne = new Army("newArmy");
                RangedUnit archersOne = new RangedUnit("archersOne", 30);
                RangedUnit archersTwo = new RangedUnit("archersTwo", 30);
                RangedUnit archersThree = new RangedUnit("archersThree", 30);
                armyOne.add(archersOne);
                armyOne.add(archersTwo);
                armyOne.add(archersThree);

                armyOne.remove(archersThree);

                List<Unit> testList = new ArrayList<Unit>();
                testList.add(archersOne);
                testList.add(archersTwo);

                Assertions.assertEquals(armyOne.getAllUnits(), testList);
            }

        }
    }

    @Nested
    class HasUnits {
        @Nested
        class Positive {
            @Test
            void verifyThatThereAreNoUnits() {
                Army armyOne = new Army("newArmy");
                Assertions.assertFalse(armyOne.hasUnits());
            }

        }

        @Nested
        class Negative {
            @Test
            void testMethodWhenThereAreUnits() {
                Army armyOne = new Army("newArmy");
                RangedUnit archers = new RangedUnit("archers", 30);
                armyOne.add(archers);

                List<Unit> testList = new ArrayList<Unit>();
                testList.add(archers);

                Assertions.assertTrue(armyOne.hasUnits());
            }
        }
    }


    @Nested
    class getUnits {
        @Nested
        class Positive {
            @Test
            void getInfantryUnitsWhenOnlyInfantry() {
                Army armyOne = new Army("newArmy");
                InfantryUnit infantryOne = new InfantryUnit("One", 30);
                InfantryUnit infantryTwo = new InfantryUnit("Two", 30);
                InfantryUnit infantryThree = new InfantryUnit("Three", 30);
                armyOne.add(infantryOne);
                armyOne.add(infantryTwo);
                armyOne.add(infantryThree);


                List<Unit> testList = new ArrayList<Unit>();
                testList.add(infantryOne);
                testList.add(infantryTwo);
                testList.add(infantryThree);

                Assertions.assertEquals(armyOne.getInfantryUnits(), testList);

            }

            @Test
            void getInfantryUnitsWhenMixed() {
                Army armyOne = new Army("newArmy");
                InfantryUnit one = new InfantryUnit("One", 30);
                RangedUnit two = new RangedUnit("Two", 30);
                CommanderUnit three = new CommanderUnit("Three", 30);
                InfantryUnit four = new InfantryUnit("Four", 30);
                InfantryUnit five = new InfantryUnit("Five", 30);
                CavalryUnit six = new CavalryUnit("six", 30);

                armyOne.addAll(List.of(one, two, three, four, five, six));


                List<Unit> testList = List.of(one, four, five);

                Assertions.assertEquals(armyOne.getInfantryUnits(), testList);

            }

            @Test
            void getRangedUnitsWhenOnlyRanged() {
                Army armyOne = new Army("newArmy");
                RangedUnit one = new RangedUnit("One", 30);
                RangedUnit two = new RangedUnit("Two", 30);
                RangedUnit three = new RangedUnit("Three", 30);
                armyOne.addAll(List.of(one, two, three));


                List<Unit> testList = List.of(one, two, three);

                Assertions.assertEquals(armyOne.getRangedUnits(), testList);

            }

            @Test
            void getRangedUnitsWhenMixed() {
                Army armyOne = new Army("newArmy");
                RangedUnit one = new RangedUnit("One", 30);
                InfantryUnit two = new InfantryUnit("Two", 30);
                CommanderUnit three = new CommanderUnit("Three", 30);
                RangedUnit four = new RangedUnit("Four", 30);
                RangedUnit five = new RangedUnit("Five", 30);
                CavalryUnit six = new CavalryUnit("six", 30);

                armyOne.addAll(List.of(one, two, three, four, five, six));


                List<Unit> testList = List.of(one, four, five);

                Assertions.assertEquals(armyOne.getRangedUnits(), testList);

            }

            @Test
            void getCommanderUnitsWhenOnlyCommander() {
                Army armyOne = new Army("newArmy");
                CommanderUnit one = new CommanderUnit("One", 30);
                CommanderUnit two = new CommanderUnit("Two", 30);
                CommanderUnit three = new CommanderUnit("Three", 30);
                armyOne.addAll(List.of(one, two, three));


                List<Unit> testList = List.of(one, two, three);

                Assertions.assertEquals(armyOne.getCommanderUnits(), testList);

            }

            @Test
            void getCommanderUnitsWhenMixed() {
                Army armyOne = new Army("newArmy");
                CommanderUnit one = new CommanderUnit("One", 30);
                InfantryUnit two = new InfantryUnit("Two", 30);
                CommanderUnit three = new CommanderUnit("Three", 30);
                RangedUnit four = new RangedUnit("Four", 30);
                CommanderUnit five = new CommanderUnit("Five", 30);
                CavalryUnit six = new CavalryUnit("six", 30);

                armyOne.addAll(List.of(one, two, three, four, five, six));


                List<Unit> testList = List.of(one, three, five);

                Assertions.assertEquals(armyOne.getCommanderUnits(), testList);

            }

            @Test
            void getCavalryUnitsWhenOnlyCavalry() {
                Army armyOne = new Army("newArmy");
                CavalryUnit one = new CavalryUnit("One", 30);
                CavalryUnit two = new CavalryUnit("Two", 30);
                CavalryUnit three = new CavalryUnit("Three", 30);
                armyOne.addAll(List.of(one, two, three));


                List<Unit> testList = List.of(one, two, three);

                Assertions.assertEquals(armyOne.getCavalryUnits(), testList);

            }

            @Test
            void getCavalryUnitsWhenMixed() {
                Army armyOne = new Army("newArmy");
                CavalryUnit one = new CavalryUnit("One", 30);
                CavalryUnit two = new CavalryUnit("Two", 30);
                CommanderUnit three = new CommanderUnit("Three", 30);
                RangedUnit four = new RangedUnit("Four", 30);
                RangedUnit five = new RangedUnit("Five", 30);
                CavalryUnit six = new CavalryUnit("six", 30);

                armyOne.addAll(List.of(one, two, three, four, five, six));


                List<Unit> testList = List.of(one, two, six);

                Assertions.assertEquals(armyOne.getCavalryUnits(), testList);

            }

        }
    }

}
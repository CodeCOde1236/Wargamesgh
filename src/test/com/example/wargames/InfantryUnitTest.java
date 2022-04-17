package com.example.wargames;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

class InfantryUnitTest {

    @Nested
    public class getAttackBonus{
        @Nested
        class Positive{
            @Test
            void getAttackBonus() {
                InfantryUnit infantry = new InfantryUnit("Infantry", 30);
                Assertions.assertEquals(infantry.getAttackBonus(), 2);
                Assertions.assertEquals(infantry.getAttackBonus(), 2);

            }


        }
    }
    @Nested
    public class getResistBonus{
        @Nested
        class Positive{
            @Test
            void getResistBonus() {
                CavalryUnit cavalry = new CavalryUnit("Caval", 30);
                Assertions.assertEquals(cavalry.getResistBonus(), 1);
                Assertions.assertEquals(cavalry.getResistBonus(), 1);
            }
        }
    }


}
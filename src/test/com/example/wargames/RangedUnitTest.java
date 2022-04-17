package com.example.wargames;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

class RangedUnitTest {

    @Nested
    public class getAttackBonus{
        @Nested
        class Positive{
            @Test
            void getAttackBonus() {
                RangedUnit archers = new RangedUnit("archers", 30);
                Assertions.assertEquals(archers.getAttackBonus(), 3);
                Assertions.assertEquals(archers.getAttackBonus(), 3);

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
                RangedUnit archers = new RangedUnit("archers", 30);
                Assertions.assertEquals(archers.getResistBonus(), 8);
                Assertions.assertEquals(archers.getResistBonus(), 6);
                Assertions.assertEquals(archers.getResistBonus(), 4);
                Assertions.assertEquals(archers.getResistBonus(), 2);
                Assertions.assertEquals(archers.getResistBonus(), 2);
                Assertions.assertEquals(archers.getResistBonus(), 2);
            }
        }
    }


}
package com.example.wargames;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import static org.junit.jupiter.api.Assertions.*;


class CavalryUnitTest {
    @Nested
    public class getAttackBonus{
        @Nested
        class Positive{
            @Test
            void getAttackBonus() {
                CavalryUnit cavalry = new CavalryUnit("Caval", 30);
                Assertions.assertEquals(cavalry.getAttackBonus(), 6);
                Assertions.assertEquals(cavalry.getAttackBonus(), 2);
                Assertions.assertEquals(cavalry.getAttackBonus(), 2);

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
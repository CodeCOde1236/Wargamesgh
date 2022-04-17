package com.example.wargames;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

class UnitTest {


    @Nested
    public class setHealth{
        @Nested
        class Positive{
            @Test
            void setHealthToLess() {
                Unit archers = new RangedUnit("archers", 30);
                archers.setHealth(15);

                Assertions.assertEquals(archers.getHealth(), 15);
            }

            @Test
            void setHealthToMore() {
                Unit archers = new RangedUnit("archers", 30);
                archers.setHealth(45);

                Assertions.assertEquals(archers.getHealth(), 45);
            }

        }
    }

    @Nested
    public class attack{
        @Nested
        class Positive{
            @Test
            void attackUnitWithMoreHealth() {
                Unit cavalry = new CavalryUnit("Caval", 30);
                Unit archers = new RangedUnit("archers", 45);

                cavalry.attack(archers);

                Assertions.assertEquals(archers.getHealth(), 35);

            }

            @Test
            void attackUnitWithLessHealth() {
                CavalryUnit cavalry = new CavalryUnit("Caval", 30);
                RangedUnit archers = new RangedUnit("archers", 25);

                cavalry.attack(archers);

                Assertions.assertEquals(archers.getHealth(), 15);
            }


        }
    }
}
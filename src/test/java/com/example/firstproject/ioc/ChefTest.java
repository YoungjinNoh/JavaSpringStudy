package com.example.firstproject.ioc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChefTest {

    @Autowired
    IngredientFactory ingredientFactory;

    @Autowired
    Chef chef;

    @Test
    void cookPolkcutlet(){
        //IngredientFactory ingredientFactory=new IngredientFactory();

        //Chef chef=new Chef(ingredientFactory);

        String food=chef.cook("polkcutlet");

        String expected="good polkcutlet cooking";

        assertEquals(expected,food);
        System.out.println(food);
    }

    @Test
    void cookStake(){
        //IngredientFactory ingredientFactory=new IngredientFactory();

        //Chef chef=new Chef(ingredientFactory);

        String food=chef.cook("stake");

        String expected="fuck stake cooking";

        assertEquals(expected,food);
        System.out.println(food);
    }

    @Test
    void cookChicken(){
        //IngredientFactory ingredientFactory=new IngredientFactory();

        //Chef chef=new Chef(ingredientFactory);

        String food=chef.cook("chicken");

        String expected="delicious chicken cooking";

        assertEquals(expected,food);
        System.out.println(food);
    }
}
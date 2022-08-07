package com.example.firstproject.ioc;

import org.springframework.stereotype.Component;

@Component// first object is created by this class, then save object to ioc controller
public class IngredientFactory {
    public Ingredient get(String menu) {
        switch(menu){
            case "polkcutlet":
                return new Pork("good");
            case "stake":
                return new Beef("fuck");
            case "chicken":
                return new Chicken("delicious");
            default:
                return null;
        }
    }
}

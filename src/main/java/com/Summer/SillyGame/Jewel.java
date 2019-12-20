package com.Summer.SillyGame;


import com.almasb.fxgl.entity.Entities;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.CollidableComponent;

public class Jewel extends Entity {
    String color;
    Entity jewel;

    public Jewel(String color, com.almasb.fxgl.entity.GameWorld gameWorld) {
        super();
        this.color = color;
        int x = getNum();
        int y = getNum();
        this.jewel = Entities.builder()
                .type(BasicGameApp.EntityType.JEWEL)
                .at(x, y)
                .viewFromTextureWithBBox(getPng(color))
                .with(new CollidableComponent(true))
                .buildAndAttach(gameWorld);
    }

    public String getPng(String color) {
        String png = null;
        if (color ==  "red") {
            png = "red_jewel.png";
        }
        else if (color == "blue") {
            png = "blue_jewel.png";
        }
        else if (color == "green"){
            png = "green_jewel.png";
        }
        else if (color == "purple"){
            png  = "purple_jewel.png";
        }
        return png;
    }

    private int getNum() {
        int num = (int)(Math.random() * 1000);
        while (num > 575) {
            num = (int)(Math.random() * 1000);
        }
        return num;
    }

}

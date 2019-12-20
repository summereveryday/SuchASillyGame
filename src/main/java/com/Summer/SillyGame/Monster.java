package com.Summer.SillyGame;

import com.almasb.fxgl.entity.Entities;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.CollidableComponent;

public class Monster extends Person {
    Entity monster;

    public Monster(com.almasb.fxgl.entity.GameWorld gameWorld) {
        super();
        this.hp = 30;
        this.monster = Entities.builder()
                .type(BasicGameApp.EntityType.MONSTER)
                .at(0, 0)
                .viewFromTextureWithBBox("monster.gif")
                .with(new CollidableComponent(true))
                .buildAndAttach(gameWorld);
    }

    private int getNum() {
        int num = (int)(Math.random() * 1000);
        while (num > 575) {
            num = (int)(Math.random() * 1000);
        }
        return num;
    }

    @Override
    public int loseHP(int damage) {
        return super.loseHP(damage);
    }

    @Override
    public int gainHP(int regeneration) {
        return super.gainHP(regeneration);
    }

    @Override
    public void attack() {
        super.attack();
    }

    @Override
    public void move(Entity player) {
        double playerx = player.getX();
        double playery = player.getY();
        double monsterx = monster.getX();
        double monstery = monster.getY();

        double newXOption1 = playerx - (monsterx + 5);
        double newXOption2 = playerx - (monsterx - 5);

        double newYOption1 = playery - (monstery + 5);
        double newYOption2 = playery - (monstery - 5);

        if (newXOption1 < newXOption2) {
            monster.translateX(+5);
        }
        else {
            monster.translateX(-5);
        }

        if (newYOption1 < newYOption2) {
            monster.translateY(+5);
        }
        else {
            monster.translateY(-5);
        }
    }

    @Override
    public void spawn() {
        super.spawn();
    }
}

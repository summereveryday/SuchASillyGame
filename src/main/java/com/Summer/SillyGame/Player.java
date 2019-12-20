package com.Summer.SillyGame;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.entity.Entities;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.settings.GameSettings;
import com.almasb.fxgl.physics.CollisionHandler;

public class Player extends Person {
    int jewelCount;
    boolean weapon;
    Entity player;

    public Player(com.almasb.fxgl.entity.GameWorld gameWorld) {
        super();
        this.jewelCount = 0;
        this.weapon = false;
        this.hp = 30;
        this.player = Entities.builder()
                .type(BasicGameApp.EntityType.PLAYER)
                .at(300, 300)
                .viewFromTextureWithBBox("hero_walk.gif")
                .with(new CollidableComponent(true))
                .buildAndAttach(gameWorld);
    }

    public void getJewel(Entity jewel) {
        jewel.removeFromWorld();
        this.jewelCount += 1;
        FXGL.getGameState().increment("jewelCount", +1);
    }

    public int getJewelCount() {
        return this.jewelCount;
    }

    public void getMonsterWound(Entity player, int damage){
        this.loseHP(damage);
        FXGL.getGameState().increment("playerHP", -damage);
        if (this.hp < 1){
            player.removeFromWorld();
        }
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
    public int getHP() {
        return super.getHP();
    }

    @Override
    public void attack() {
        super.attack();
    }

    @Override
    public void move() {
        super.move();
    }

    @Override
    public void spawn() {
        super.spawn();
    }
}

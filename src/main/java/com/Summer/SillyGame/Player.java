package com.Summer.SillyGame;

//import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entities;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.GameWorld;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.component.Required;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.util.Duration;


//import static com.almasb.fxgl.dsl.FXGL.image;
//import static com.almasb.fxgl.dsl.FXGL.runOnce;

public class Player extends Person {
    int jewelCount;
    boolean weapon;
    Entity player;
//    private Entities.EntityBuilder player;

    public Player(com.almasb.fxgl.entity.GameWorld gameWorld) {
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

    public void getJewel() {
        this.jewelCount += 1;
    }

    public int getJewelCount() {
        return this.jewelCount;
    }

    public int getHP() {
        return this.hp;
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
    public void move() {
        super.move();
    }

    @Override
    public void spawn() {
        super.spawn();
    }

    public void moveLeft() {
        this.setScaleX(-5);
    }
}

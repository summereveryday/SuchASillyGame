package com.Summer.SillyGame;


import com.almasb.fxgl.entity.Entities;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.component.Required;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.util.Duration;

public abstract class Person extends Entity {
//    private PhysicsComponent physics;
    int hp;

    public Person() {
        this.hp = 0;
    }

    public int loseHP(int damage) {
        this.hp = this.hp - damage;
        return this.hp;
    }

    public int gainHP(int regeneration) {
        this.hp = this.hp + regeneration;
        return this.hp;
    }

    public void attack() {}

    public void move() {}

    public void spawn() {}
}

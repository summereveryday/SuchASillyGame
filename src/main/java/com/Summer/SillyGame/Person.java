package com.Summer.SillyGame;


import com.almasb.fxgl.entity.Entity;

public abstract class Person extends Entity {
    int hp;

    public Person() {
        // void
    }

    public int loseHP(int damage) {
        this.hp = this.hp - damage;
        return this.hp;
    }

    public int gainHP(int regeneration) {
        this.hp = this.hp + regeneration;
        return this.hp;
    }

    public int getHP(){
        return this.hp;
    }

    public void attack() {}

    public void move(Entity entity) {}

    public void spawn() {}
}

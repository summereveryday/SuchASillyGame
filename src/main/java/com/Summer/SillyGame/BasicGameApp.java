package com.Summer.SillyGame;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.entity.Entities;
import com.almasb.fxgl.settings.GameSettings;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.physics.CollisionHandler;
import com.almasb.fxgl.texture.Texture;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import java.util.Map;

public class BasicGameApp extends GameApplication {
    @Override
    protected void initSettings(GameSettings settings){
        settings.setHeight(600);
        settings.setTitle("What a Silly Game");
        settings.setVersion("0.1");
    }

    public enum EntityType {
        PLAYER, JEWEL
    }

    @Override
    protected void initInput() {
        Input input = getInput();

        input.addAction(new UserAction("Move Right") {
            @Override
            protected void onAction() {
                player.translateX(5); // move right 5 pixels
            }
        }, KeyCode.D);

        input.addAction(new UserAction("Move Left") {
            @Override
            protected void onAction() {
                player.translateX(-5); // move left 5 pixels
            }
        }, KeyCode.A);

        input.addAction(new UserAction("Move Up") {
            @Override
            protected void onAction() {
                player.translateY(-5); // move up 5 pixels
            }
        }, KeyCode.W);

        input.addAction(new UserAction("Move Down") {
            @Override
            protected void onAction() {
                player.translateY(5); // move down 5 pixels
            }
        }, KeyCode.S);
    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("pixelsMoved", 0);
    }

    private Entity player, red_jewel, blue_jewel, purple_jewel, green_jewel;

    @Override
    protected void initGame() {
        player = Entities.builder()
                .type(EntityType.PLAYER)
                .at(300, 300)
                .viewFromTextureWithBBox("hero_walk.gif")
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        red_jewel = Entities.builder()
                .type(EntityType.JEWEL)
                .at(575, 300)
                .viewFromTextureWithBBox("red_jewel.png")
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        blue_jewel = Entities.builder()
                .type(EntityType.JEWEL)
                .at(10, 300)
                .viewFromTexture("blue_jewel.png")
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        purple_jewel = Entities.builder()
                .type(EntityType.JEWEL)
                .at(300, 575)
                .viewFromTexture("purple_jewel.png")
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());


        green_jewel = Entities.builder()
                .type(EntityType.JEWEL)
                .at(300, 10)
                .viewFromTexture("green_jewel.png")
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());
    }

    @Override
    protected void initPhysics() {
        getPhysicsWorld().addCollisionHandler(new CollisionHandler(EntityType.PLAYER, EntityType.JEWEL) {

            // order of types is the same as passed into the constructor
            @Override
            protected void onCollisionBegin(Entity player, Entity red_jewel) {
                red_jewel.removeFromWorld();
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}

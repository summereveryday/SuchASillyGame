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
                player.player.translateX(5); // move right 5 pixels
            }
        }, KeyCode.D);

        input.addAction(new UserAction("Move Left") {
            @Override
            protected void onAction() {
                player.player.translateX(-5); // move left 5 pixels
            }
        }, KeyCode.A);

        input.addAction(new UserAction("Move Up") {
            @Override
            protected void onAction() {

                player.player.translateY(-5); // move up 5 pixels
            }
        }, KeyCode.W);

        input.addAction(new UserAction("Move Down") {
            @Override
            protected void onAction() {
                player.player.translateY(5); // move down 5 pixels
            }
        }, KeyCode.S);
    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("pixelsMoved", 0);
    }

    private Player player;
    private Jewel red_jewel, blue_jewel, purple_jewel, green_jewel;

    @Override
    protected void initGame() {
        player = new Player(getGameWorld());

        red_jewel = new Jewel("red", getGameWorld());
        blue_jewel = new Jewel("blue", getGameWorld());
        purple_jewel = new Jewel("purple", getGameWorld());
        green_jewel = new Jewel("green", getGameWorld());
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

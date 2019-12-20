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
    public enum EntityType {
        PLAYER, JEWEL
    }

    private Player player1;
    private Jewel red_jewel, blue_jewel, purple_jewel, green_jewel;

    @Override
    protected void initSettings(GameSettings settings){
        settings.setHeight(600);
        settings.setTitle("What a Silly Game");
        settings.setVersion("1.0");
    }

    @Override
    protected void initGame() {
        player1 = new Player(getGameWorld());

        red_jewel = new Jewel("red", getGameWorld());
        blue_jewel = new Jewel("blue", getGameWorld());
        purple_jewel = new Jewel("purple", getGameWorld());
        green_jewel = new Jewel("green", getGameWorld());
    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("jewelCount", 0);
        vars.put("playerHP", 30);
    }

    @Override
    protected void initUI() {
        Text jewelText = new Text();
        jewelText.setTranslateX(50); // x = 50
        jewelText.setTranslateY(100); // y = 100

        jewelText.textProperty().bind(getGameState().intProperty("jewelCount").asString());
        getGameScene().addUINode(jewelText); // add to the scene graph
    }

    @Override
    protected void initInput() {
        Input input = getInput();

        input.addAction(new UserAction("Move Right") {
            @Override
            protected void onAction() {
                player1.player.translateX(5); // move right 5 pixels
            }
        }, KeyCode.D);

        input.addAction(new UserAction("Move Left") {
            @Override
            protected void onAction() {
                player1.player.translateX(-5); // move left 5 pixels
            }
        }, KeyCode.A);

        input.addAction(new UserAction("Move Up") {
            @Override
            protected void onAction() {

                player1.player.translateY(-5); // move up 5 pixels
            }
        }, KeyCode.W);

        input.addAction(new UserAction("Move Down") {
            @Override
            protected void onAction() {
                player1.player.translateY(5); // move down 5 pixels
            }
        }, KeyCode.S);
    }

    @Override
    protected void initPhysics() {
        getPhysicsWorld().addCollisionHandler(new CollisionHandler(EntityType.PLAYER, EntityType.JEWEL) {

            // order of types is the same as passed into the constructor
            @Override
            protected void onCollisionBegin(Entity player, Entity jewel) {
                jewel.removeFromWorld();
                player1.getJewel();
                getGameState().increment("jewelCount", +1);
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}

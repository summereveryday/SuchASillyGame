// Summer Daily
// Java Final Project

// Welcome to my game. Move using 'w', 'a', 's', and 'd'. Get the gems. Don't get hit by the monster. Good luck!"


package com.Summer.SillyGame;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.settings.GameSettings;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.physics.CollisionHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class BasicGameApp extends GameApplication {
    public enum EntityType {
        PLAYER, JEWEL, MONSTER
    }

    private Player player1;
    private Jewel red_jewel, blue_jewel, purple_jewel, green_jewel;
    private Monster monster;

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

        monster = new Monster(getGameWorld());

        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                monster.move(player1.player);
            }
        }, 0, 100);
    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("jewelCount", 0);
        vars.put("playerHP", 0);
    }

    @Override
    protected void initUI() {
        Text jewelText = new Text();
        Text hpText = new Text();
        jewelText.setTranslateX(50);
        jewelText.setTranslateY(100);
        hpText.setTranslateX(50);
        hpText.setTranslateY(115);

        getGameState().increment("playerHP", +player1.getHP());

        jewelText.textProperty().bind(getGameState().intProperty("jewelCount").asString());
        hpText.textProperty().bind(getGameState().intProperty("playerHP").asString());
        getGameScene().addUINode(jewelText); // add to the scene graph
        getGameScene().addUINode(hpText);
    }

    @Override
    protected void initInput() {
        Input input = getInput();

        input.addAction(new UserAction("Move Right") { @Override protected void onAction() {
            player1.player.translateX(5);
        } }, KeyCode.D);

        input.addAction(new UserAction("Move Left") { @Override protected void onAction() {
            player1.player.translateX(-5);
        } }, KeyCode.A);

        input.addAction(new UserAction("Move Up") { @Override protected void onAction() {
            player1.player.translateY(-5);
        } }, KeyCode.W);

        input.addAction(new UserAction("Move Down") { @Override protected void onAction() {
            player1.player.translateY(5);
        } }, KeyCode.S);

        input.addAction(new UserAction("Attack") { @Override protected void onAction() {
            player1.attack();
        } }, KeyCode.ENTER);
    }

    @Override
    protected void initPhysics() {
        getPhysicsWorld().addCollisionHandler(new CollisionHandler(EntityType.PLAYER, EntityType.JEWEL) {
            @Override
            protected void onCollisionBegin(Entity player, Entity jewel) {
                player1.getJewel(jewel);
            }
        });

        getPhysicsWorld().addCollisionHandler(new CollisionHandler(EntityType.PLAYER, EntityType.MONSTER) {
            @Override
            protected void onCollisionBegin(Entity player, Entity monster) {
                player1.getMonsterWound(player,10);
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
package com.mygdx.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class MyGameInputProcessor extends InputAdapter {
    private ArcherController archerController;
    private ArrowController arrowController;

    public MyGameInputProcessor(ArcherController archerController, ArrowController arrowController) {
        this.archerController = archerController;
        this.arrowController = arrowController;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.SPACE) {
            // Dispara uma flecha na posição do arqueiro
            arrowController.shoot(archerController.getX(), archerController.getY());
            return true;
        }
        return false;
    }
}

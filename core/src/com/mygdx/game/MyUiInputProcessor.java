package com.mygdx.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class MyUiInputProcessor implements InputProcessor {


    public boolean keyWPress = false;
    public boolean keySPress = false;

    private CoyoteController coyote;
    private ChickenController galinha;

    public MyUiInputProcessor(CoyoteController coyote, ChickenController galinha) {
        this.coyote = coyote;
        this.galinha = galinha;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.SPACE) {
            galinha.shoot(coyote.getX(), coyote.getY());
            return true;
        }
        if (keycode == Input.Keys.S) {
            keySPress = true;
        }
        if (keycode == Input.Keys.W) {
            keyWPress = true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.S) {
            keySPress = false;
        }
        if (keycode == Input.Keys.W) {
            keyWPress = false;
        }
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchCancelled(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;
    }

    @Override
    public boolean scrolled(float v, float v1) {
        return false;
    }
}

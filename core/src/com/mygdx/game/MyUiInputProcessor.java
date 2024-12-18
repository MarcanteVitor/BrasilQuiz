package com.mygdx.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class MyUiInputProcessor implements InputProcessor {


    public boolean keyAPress = false;
    public boolean keyDPress = false;

    public MyUiInputProcessor() {}

    @Override
    public boolean keyDown(int keycode) {

        if (keycode == Input.Keys.A) {
            keyAPress = true;
        }
        if (keycode == Input.Keys.D) {
            keyDPress = true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.A) {
            keyAPress = false;
        }
        if (keycode == Input.Keys.D) {
            keyDPress = false;
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

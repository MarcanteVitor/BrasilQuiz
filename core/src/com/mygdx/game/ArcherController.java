package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;

public class ArcherController {
    private Texture archerTexture;
    private float x, y;

    public ArcherController() {
        archerTexture = Assets.manager.get(Assets.ARCHER_TEXTURE);
        x = 2;
        y = 275;
    }

    public void render(SpriteBatch batch) {
        batch.draw(archerTexture, x, y);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void dispose() {
        archerTexture.dispose();
    }
}

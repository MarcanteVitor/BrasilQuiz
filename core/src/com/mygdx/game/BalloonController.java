package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;

public class BalloonController {
    private Texture balloonTexture;
    private float x, y, speed;

    public BalloonController() {
        balloonTexture = Assets.manager.get(Assets.GALINHA_TEXTURE);
        x = 200;
        y = 0;
        speed = 75;
    }

    public void update(float deltaTime) {
        y += speed * deltaTime;

        if (y > Gdx.graphics.getHeight()) {
            y = 0;
        }
    }

    public void render(SpriteBatch batch) {
        for(int i = 0; i < 6; i++) {
            batch.draw(balloonTexture, (x + (i * 50)), (y + (i * 42)));
        }
    }

    public void dispose() {
        balloonTexture.dispose();
    }
}

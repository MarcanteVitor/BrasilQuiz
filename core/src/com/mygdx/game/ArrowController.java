package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.Gdx;

public class ArrowController {
    private Texture arrowTexture;
    private Array<Arrow> arrows;

    public ArrowController() {
        arrowTexture = Assets.manager.get(Assets.FLECHA_TEXTURE);
        arrows = new Array<>();
    }

    public void shoot(float startX, float startY) {
        arrows.add(new Arrow(startX, startY));
    }

    public void update(float deltaTime) {
        for (Arrow arrow : arrows) {
            arrow.x += 300 * deltaTime;

            if (arrow.x > Gdx.graphics.getWidth()) {
                arrows.removeValue(arrow, true);
            }
        }
    }

    public void render(SpriteBatch batch) {
        for (Arrow arrow : arrows) {
            batch.draw(arrowTexture, arrow.x, arrow.y);
        }
    }

    public void dispose() {
        arrowTexture.dispose();
    }

    private static class Arrow {
        float x, y;
        Arrow(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }
}

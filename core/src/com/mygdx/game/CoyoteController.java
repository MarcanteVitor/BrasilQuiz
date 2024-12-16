package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CoyoteController extends GenericController {

    public CoyoteController() {
        this.setTexture(Assets.manager.get(Assets.ARQUEIRO_TEXTURE));
        this.setX(2);
        this.setY(275);
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(getTexture(), getX(), getY());
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}

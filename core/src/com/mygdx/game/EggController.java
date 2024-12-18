package com.mygdx.game;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EggController extends GenericController {

    public EggController(float x, float y) {
        this.setX(x);
        this.setY(y);
        this.setHeight(32);
        this.setWidth(32);
        this.setTexture(Assets.manager.get(Assets.OVO_TEXTURE));
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(getTexture(), getX(), getY(), getWidth(), getHeight());
    }

    public void update(float deltaTime) {
        setY(getY() - 200 * deltaTime);
    }

    public boolean isOutOfBounds() {
        return getY() + getHeight() < 0;
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}

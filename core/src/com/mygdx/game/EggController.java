package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class EggController extends GenericController {
    private Rectangle rectangle;

    public EggController(float x, float y, Texture texture) {
        this.setTexture(texture);
        this.rectangle = new Rectangle(x, y, 32, 32);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(getTexture(), rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    public void update(float deltaTime) {
        rectangle.y -= 200 * deltaTime;
    }

    public boolean isOutOfBounds() {
        return rectangle.y + rectangle.height < 0;
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}

package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.Gdx;

public class ChickenController extends GenericController {

    private Array<EggController> eggs;

    public ChickenController() {
        this.setTexture(Assets.manager.get(Assets.GALINHA_TEXTURE));
        this.setY(Gdx.graphics.getHeight() - 100);
        this.setHeight(64);
        this.setWidth(64);
        eggs = new Array<>();
    }

    public void shoot() {
        eggs.add(new EggController(this.getX(), this.getY()));
    }

//    public void update(float deltaTime) {
//        for (EggController egg : eggs) {
//            egg.setX(egg.getX() + 300 * deltaTime);
//
//            if (egg.getX() > Gdx.graphics.getWidth()) {
//                eggs.removeValue(egg, true);
//            }
//        }
//    }

    public void render(SpriteBatch batch) {

        batch.draw(getTexture(), getX(), getY(),getWidth(),getHeight());

        for (EggController egg : this.getEggs()) {
            egg.render(batch);
        }
    }

    public Array<EggController> getEggs() {
        return eggs;
    }

    public void setEggs(Array<EggController> eggs) {
        this.eggs = eggs;
    }

    @Override
    public void dispose() {
        for (EggController egg : this.getEggs()) {
            egg.dispose();
        }
        super.dispose();
    }
}

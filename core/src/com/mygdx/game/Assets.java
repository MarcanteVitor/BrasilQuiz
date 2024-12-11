package com.mygdx.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class Assets {
    public static final AssetManager manager = new AssetManager();

    public static final String ARCHER_TEXTURE = "archer.png";
    public static final String BALLOON_TEXTURE = "balao.png";
    public static final String ARROW_TEXTURE = "arrow.png";

    public static void load() {
        manager.load(ARCHER_TEXTURE, Texture.class);
        manager.load(BALLOON_TEXTURE, Texture.class);
        manager.load(ARROW_TEXTURE, Texture.class);
    }

    public static void dispose() {
        manager.dispose();
    }
}

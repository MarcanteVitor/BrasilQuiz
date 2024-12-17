package com.mygdx.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class Assets {
    public static final AssetManager manager = new AssetManager();

    public static final String RAPOSO_TEXTURE = "raposo.png";
    public static final String BACKGROUND_TEXTURE = "background.jpg";
    public static final String GALINHA_TEXTURE = "galinha.png";
    public static final String OVO_TEXTURE = "ovo.png";

    public static void load() {
        manager.load(RAPOSO_TEXTURE, Texture.class);
        manager.load(BACKGROUND_TEXTURE, Texture.class);
        manager.load(GALINHA_TEXTURE, Texture.class);
        manager.load(OVO_TEXTURE, Texture.class);
    }

    public static void dispose() {
        manager.dispose();
    }
}

package com.mygdx.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class Assets {
    public static final AssetManager manager = new AssetManager();

    public static final String ARQUEIRO_TEXTURE = "archer.png";
    public static final String BALAO_TEXTURE = "balao.png";
    public static final String FLECHA_TEXTURE = "arrow.png";
    public static final String BACKGROUND_TEXTURE = "background.jpg";
    public static final String GALINHA_TEXTURE = "galinha.png";
    public static final String OVO_TEXTURE = "ovo.png";

    public static void load() {
        manager.load(ARQUEIRO_TEXTURE, Texture.class);
        manager.load(BALAO_TEXTURE, Texture.class);
        manager.load(FLECHA_TEXTURE, Texture.class);
        manager.load(BACKGROUND_TEXTURE, Texture.class);
        manager.load(GALINHA_TEXTURE, Texture.class);
        manager.load(OVO_TEXTURE, Texture.class);
    }

    public static void dispose() {
        manager.dispose();
    }
}

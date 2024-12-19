package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

class MenuScreen implements Screen {

    private final MyGdxGame game;
    private BitmapFont font;

    public MenuScreen(MyGdxGame game) {
        this.game = game;
        font = new BitmapFont();
        //PAUSA A RENDERIZACAO ATUTOMATICA E FAZ UMA RENDERIZACAO MANUAL UMA VEZ
        Gdx.graphics.setContinuousRendering(false);
        Gdx.graphics.requestRendering();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().begin();
        font.draw(game.getBatch(), "Bem-vindo ao Jogo DO RAPOSO!", Gdx.graphics.getWidth() / 2f - 115, Gdx.graphics.getHeight() / 2f + 40);
        font.draw(game.getBatch(), "Pressione ENTER para começar", Gdx.graphics.getWidth() / 2f - 110, Gdx.graphics.getHeight() / 2f);
        game.getBatch().end();

        if ( game.inputProcessor.keyEnterPress) {

            game.setScreen(new GameScreen(game));
        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }
    @Override
    public void dispose() {
        font.dispose();
    }
}
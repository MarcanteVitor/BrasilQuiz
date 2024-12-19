package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class MyGdxGame extends Game {

	private SpriteBatch batch;
	MyUiInputProcessor inputProcessor;

	@Override
	public void create() {
		batch = new SpriteBatch();

		inputProcessor = new MyUiInputProcessor();
		InputMultiplexer multiplexer = new InputMultiplexer();
		multiplexer.addProcessor(inputProcessor);
		Gdx.input.setInputProcessor(multiplexer);

		//PAUSA A RENDERIZACAO CONTINUA
		Gdx.graphics.setContinuousRendering(false);
		//INICIA A RENDERIZACAO CONTINUA
		Gdx.graphics.requestRendering();
		this.setScreen(new MenuScreen(this));


	}

	@Override
	public void render() {
		//VAI RENDERIZAR A TELA ATIVA
		super.render();
	}

	@Override
	public void dispose() {
		batch.dispose();
		super.dispose();
	}

	public SpriteBatch getBatch() {
		return batch;
	}
}
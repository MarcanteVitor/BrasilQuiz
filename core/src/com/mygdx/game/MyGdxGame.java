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

import java.util.ArrayList;

public class MyGdxGame extends ApplicationAdapter {


	private MyUiInputProcessor inputProcessor;
	private SpriteBatch batch;
	private CoyoteController coyote;
	private Array<ChickenController> chickens;
	private long lastEggTime;
	private BitmapFont font;
	private int score;
	// Temporizador
	private static final float GAME_DURATION = 60f; // 60 segundos
	private float timeRemaining;
	private boolean gameEnded;

	//Create
	@Override
	public void create() {
		//Aqui ele carrega os assetss e trava a te terminar o mesmo
		Assets.load();
		Assets.manager.finishLoading();
		Assets.showMusic();
		// pega os batch
		batch = new SpriteBatch();

		inputProcessor = new MyUiInputProcessor();
		InputMultiplexer multiplexer = new InputMultiplexer();
		multiplexer.addProcessor(inputProcessor);
		Gdx.input.setInputProcessor(multiplexer);

		initialize();
	}


	private void initialize() {
		// onde faz toda a inicialização dos valores do jogo
		coyote = new CoyoteController();

		this.chickens = new Array<>();

		for (int i = 0; i < 4; i++) {
			ChickenController chicken = new ChickenController();
			chicken.setX(i * 150 + 50);
			this.chickens.add(chicken);
		}

		// score e timer todo: precisa ajustar
		font = new BitmapFont();
		score = 0;
		timeRemaining = GAME_DURATION; // Define o tempo inicial
		gameEnded = false;
	}

	private void spawnEgg() {

		//pega uma galinha aleatoria e faz ela "botar um ovo"
		ChickenController chicken = chickens.random();
		chicken.shoot();
		lastEggTime = TimeUtils.nanoTime();
	}

	@Override
	public void render() {
		// limpa antes de tudo
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// fica mudando o timer
		if (!gameEnded) {
			timeRemaining -= Gdx.graphics.getDeltaTime();
			if (timeRemaining <= 0) {
				gameEnded = true;
				timeRemaining = 0;
			}
		}

		// funções pra desenha a tela
		batch.begin();
		batch.draw((Texture) Assets.manager.get(Assets.BACKGROUND_TEXTURE),
				0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		if (!gameEnded) {
			//  galinhas
			for (ChickenController chicken : chickens) {
				chicken.render(batch);
			}

			// raposo
			coyote.render(batch);

			//  score e timer
			drawTextWithBackground("Score: " + score, 10, Gdx.graphics.getHeight() - 10);
			drawTextWithBackground("Time: " + (int) timeRemaining, 10, Gdx.graphics.getHeight() - 40);
		} else {
			// placar
			drawTextWithBackground("Game Over!", Gdx.graphics.getWidth() / 2f - 70, Gdx.graphics.getHeight() / 2f + 20);
			drawTextWithBackground("Final Score: " + score, Gdx.graphics.getWidth() / 2f - 90, Gdx.graphics.getHeight() / 2f - 10);
			drawTextWithBackground("Press 'R' to Restart", Gdx.graphics.getWidth() / 2f - 110, Gdx.graphics.getHeight() / 2f - 40);

			// pega a tecla clicada
			if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
				initialize();
			}
		}

		batch.end();

		// movimento do personagem e pegar ovo/adicionar na cesta/raposo
		if (!gameEnded) {
			coyote.update(Gdx.graphics.getDeltaTime(), inputProcessor.keyAPress,inputProcessor.keyDPress);

			for(ChickenController chicken : chickens){
				int cont = 0;
				for (EggController egg : chicken.getEggs()) {
					egg.update(Gdx.graphics.getDeltaTime());

					if (verificaColisao(egg,this.coyote)) {
						chicken.getEggs().removeIndex(cont);
						score++;

						//PLAY NO SOM TODO: ta com deley
						egg.getEggCatchSound().play();//1.0f volume
					}

					if (egg.isOutOfBounds()) {
						chicken.getEggs().removeIndex(cont);
					}
					cont++;
				}
			}


			if (TimeUtils.nanoTime() - lastEggTime > 1_000_000_000) {
				spawnEgg();
			}
		}
	}

	// fundo preto para os textos
	private void drawTextWithBackground(String text, float x, float y) {
		batch.setColor(Color.BLACK);
		batch.draw((Texture) Assets.manager.get(Assets.BACKGROUND_TEXTURE), x - 5, y - 20, 200, 25);
		batch.setColor(Color.WHITE);
		font.setColor(Color.WHITE);
		font.draw(batch, text, x, y);
	}

	//dispose de tudo
	@Override
	public void dispose() {
		batch.dispose();
		Assets.dispose();
		font.dispose();
		for (ChickenController chicken : this.chickens) {
			chicken.dispose();
		}
	}

	public boolean verificaColisao(Colisao obj1, Colisao obj2) {
		return obj1.getX() < obj2.getX() + obj2.getWidth() &&
				obj1.getX() + obj1.getWidth() > obj2.getX() &&
				obj1.getY() < obj2.getY() + obj2.getHeight() &&
				obj1.getY() + obj1.getHeight() > obj2.getY();
	}
}

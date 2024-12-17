package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class MyGdxGame extends ApplicationAdapter {


	//cria as instancias
	private ChickenController galinha;
	private CoyoteController coyote;
	private MyUiInputProcessor inputProcessor;
	private SpriteBatch batch;
	private Rectangle basket;
	private Array<EggController> eggs;
	private Array<Rectangle> chickens;
	private long lastEggTime;
	private BitmapFont font;
	private int score;
	private Sound eggCatchSound;

	// Temporizador
	private static final float GAME_DURATION = 60f; // 60 segundos
	private float timeRemaining;
	private boolean gameEnded;

	//Create
	@Override
	public void create() {
		Assets.load();
		Assets.manager.finishLoading();

		// pega os batch
		batch = new SpriteBatch();
		coyote = new CoyoteController();
		galinha = new ChickenController();

		inputProcessor = new MyUiInputProcessor(coyote, galinha);
		InputMultiplexer multiplexer = new InputMultiplexer();
		multiplexer.addProcessor(inputProcessor);
		Gdx.input.setInputProcessor(multiplexer);

		// usado para o som
		eggCatchSound = Gdx.audio.newSound(Gdx.files.internal("egg_catch.mp3"));

		initialize();
	}


	private void initialize() {
		// onde faz toda a inicialização dos valores do jogo
		basket = new Rectangle();
		basket.x = Gdx.graphics.getWidth() / 2f - 64 / 2f;
		basket.y = 20;
		basket.width = 64;
		basket.height = 64;

		// cria as galinhas
		chickens = new Array<>();
		for (int i = 0; i < 5; i++) {
			Rectangle chicken = new Rectangle();
			chicken.x = i * 150 + 50;
			chicken.y = Gdx.graphics.getHeight() - 100;
			chicken.width = 64;
			chicken.height = 64;
			chickens.add(chicken);
		}

		// array de ovo vazio
		eggs = new Array<>();
		spawnEgg();

		// score e timer
		font = new BitmapFont();
		score = 0;
		timeRemaining = GAME_DURATION; // Define o tempo inicial
		gameEnded = false;
	}

	private void spawnEgg() {
		//pega uma galinha aleatoria e faz ela "botar um ovo"
		Rectangle chicken = chickens.random();
		EggController egg = new EggController(
				chicken.x + chicken.width / 2 - 16,
				chicken.y - 16,
				Assets.manager.get(Assets.OVO_TEXTURE)
		);
		// depois coloca o ovo no array de ovos
		eggs.add(egg);
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
		batch.draw((Texture) Assets.manager.get(Assets.BACKGROUND_TEXTURE), 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		if (!gameEnded) {
			//  galinhas
			for (Rectangle chicken : chickens) {
				batch.draw((Texture) Assets.manager.get(Assets.GALINHA_TEXTURE), chicken.x, chicken.y);
			}

			// ovos
			for (EggController egg : eggs) {
				egg.render(batch);
			}

			// cesta/raposo
			batch.draw((Texture) Assets.manager.get(Assets.RAPOSO_TEXTURE), basket.x, basket.y);

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

			if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
				basket.x -= 450 * Gdx.graphics.getDeltaTime();
			}
			if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
				basket.x += 450 * Gdx.graphics.getDeltaTime();
			}


			if (basket.x < 0) basket.x = 0;
			if (basket.x > Gdx.graphics.getWidth() - basket.width) basket.x = Gdx.graphics.getWidth() - basket.width;

			for (int i = 0; i < eggs.size; i++) {
				EggController egg = eggs.get(i);
				egg.update(Gdx.graphics.getDeltaTime());

				if (egg.getRectangle().overlaps(basket)) {
					eggs.removeIndex(i);
					score++;
					eggCatchSound.play(); // chamada do som tem que ser aqui
				}

				if (egg.isOutOfBounds()) {
					eggs.removeIndex(i);
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
		eggCatchSound.dispose();
		for (EggController egg : eggs) {
			egg.dispose();
		}
	}
}

package com.mygdx.game;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture backgroundTexture;
	private Texture chickenTexture;
	private Texture eggTexture;
	private Texture basketTexture;
	private Rectangle basket;
	private Array<Rectangle> eggs;
	private long lastEggTime;
	private BitmapFont font;
	private int score;

	@Override
	public void create() {
		batch = new SpriteBatch();

		// Load textures
		backgroundTexture = new Texture("background.jpg"); // Background image
		chickenTexture = new Texture("galinha.png"); // Placeholder for chicken
		eggTexture = new Texture("ovo.png"); // Placeholder for egg
		basketTexture = new Texture("balao.png"); // Placeholder for basket

		// Initialize basket
		basket = new Rectangle();
		basket.x = Gdx.graphics.getWidth() / 2f - 64 / 2f;
		basket.y = 20;
		basket.width = 64;
		basket.height = 64;

		// Initialize eggs array
		eggs = new Array<>();
		spawnEgg();

		// Initialize font and score
		font = new BitmapFont();
		score = 0;
	}

	private void spawnEgg() {
		Rectangle egg = new Rectangle();
		egg.x = MathUtils.random(0, Gdx.graphics.getWidth() - 32);
		egg.y = Gdx.graphics.getHeight();
		egg.width = 32;
		egg.height = 32;
		eggs.add(egg);
		lastEggTime = TimeUtils.nanoTime();
	}

	@Override
	public void render() {
		// Clear screen
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// Draw objects
		batch.begin();

		// Draw background
		batch.draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		// Draw chickens
		for (int i = 0; i < 5; i++) {
			batch.draw(chickenTexture, i * 150 + 50, Gdx.graphics.getHeight() - 100);
		}

		// Draw eggs
		for (Rectangle egg : eggs) {
			batch.draw(eggTexture, egg.x, egg.y);
		}

		// Draw basket
		batch.draw(basketTexture, basket.x, basket.y);

		// Draw score
		font.draw(batch, "Score: " + score, 10, Gdx.graphics.getHeight() - 10);

		batch.end();

		// Basket movement
		if (Gdx.input.isTouched()) {
			basket.x = Gdx.input.getX() - basket.width / 2f;
		}

		// Keep basket within screen bounds
		if (basket.x < 0) basket.x = 0;
		if (basket.x > Gdx.graphics.getWidth() - basket.width) basket.x = Gdx.graphics.getWidth() - basket.width;

		// Update egg positions
		for (int i = 0; i < eggs.size; i++) {
			Rectangle egg = eggs.get(i);
			egg.y -= 200 * Gdx.graphics.getDeltaTime();

			// Check if egg hits the basket
			if (egg.overlaps(basket)) {
				eggs.removeIndex(i);
				score++;
			}

			// Remove egg if it goes off-screen
			if (egg.y + egg.height < 0) {
				eggs.removeIndex(i);
			}
		}

		// Spawn new eggs
		if (TimeUtils.nanoTime() - lastEggTime > 1_000_000_000) {
			spawnEgg();
		}
	}

	@Override
	public void dispose() {
		batch.dispose();
		backgroundTexture.dispose();
		chickenTexture.dispose();
		eggTexture.dispose();
		basketTexture.dispose();
		font.dispose();
	}
}

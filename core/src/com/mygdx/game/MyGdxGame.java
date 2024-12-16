package com.mygdx.game;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class MyGdxGame extends ApplicationAdapter {

	private ArrowController arrow;
	private CoyoteController coyote;
	private MyUiInputProcessor inputProcessor;
	private SpriteBatch batch;
	private Rectangle basket;
	private Array<EggController> eggs;
	private Array<Rectangle> chickens;
	private long lastEggTime;
	private BitmapFont font;
	private int score;

	@Override
	public void create() {
		Assets.load();
		Assets.manager.finishLoading();

		batch = new SpriteBatch();
		coyote = new CoyoteController();
		arrow = new ArrowController();

		inputProcessor = new MyUiInputProcessor(coyote, arrow);
		InputMultiplexer multiplexer = new InputMultiplexer();
		multiplexer.addProcessor(inputProcessor);
		Gdx.input.setInputProcessor(multiplexer);

		// Initialize basket
		basket = new Rectangle();
		basket.x = Gdx.graphics.getWidth() / 2f - 64 / 2f;
		basket.y = 20;
		basket.width = 64;
		basket.height = 64;

		// Initialize chickens array
		chickens = new Array<>();
		for (int i = 0; i < 5; i++) {
			Rectangle chicken = new Rectangle();
			chicken.x = i * 150 + 50;
			chicken.y = Gdx.graphics.getHeight() - 100;
			chicken.width = 64;
			chicken.height = 64;
			chickens.add(chicken);
		}

		// Initialize eggs array
		eggs = new Array<>();
		spawnEgg();

		// Initialize font and score
		font = new BitmapFont();
		score = 0;
	}

	private void spawnEgg() {
		// Choose a random chicken to drop the egg
		Rectangle chicken = chickens.random();
		EggController egg = new EggController(
				chicken.x + chicken.width / 2 - 16,
				chicken.y - 16,
				Assets.manager.get(Assets.OVO_TEXTURE)
		);
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
		batch.draw((Texture) Assets.manager.get(Assets.BACKGROUND_TEXTURE), 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		// Draw chickens
		for (Rectangle chicken : chickens) {
			batch.draw((Texture) Assets.manager.get(Assets.GALINHA_TEXTURE), chicken.x, chicken.y);
		}

		// Draw eggs
		for (EggController egg : eggs) {
			egg.render(batch);
		}

		// Draw basket
		batch.draw((Texture) Assets.manager.get(Assets.BALAO_TEXTURE), basket.x, basket.y);

		// Draw score
		font.draw(batch, "Score: " + score, 10, Gdx.graphics.getHeight() - 10);

		batch.end();

		// Basket movement
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			basket.x -= 450 * Gdx.graphics.getDeltaTime();
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			basket.x += 450 * Gdx.graphics.getDeltaTime();
		}

		// Keep basket within screen bounds
		if (basket.x < 0) basket.x = 0;
		if (basket.x > Gdx.graphics.getWidth() - basket.width) basket.x = Gdx.graphics.getWidth() - basket.width;

		// Update egg positions
		for (int i = 0; i < eggs.size; i++) {
			EggController egg = eggs.get(i);
			egg.update(Gdx.graphics.getDeltaTime());

			// Check if egg hits the basket
			if (egg.getRectangle().overlaps(basket)) {
				eggs.removeIndex(i);
				score++;
			}

			// Remove egg if it goes off-screen
			if (egg.isOutOfBounds()) {
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
		Assets.dispose();
		font.dispose();
		for (EggController egg : eggs) {
			egg.dispose();
		}
	}
}
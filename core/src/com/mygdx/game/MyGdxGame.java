package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.models.Pergunta;
import com.mygdx.game.utils.PerguntaList;
import com.mygdx.game.utils.PerguntaManager;

import javax.crypto.spec.PSource;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private BalloonController balloonController;
	private ArcherController archerController;
	private ArrowController arrowController;

	private PerguntaList perguntaList;
	private PerguntaManager perguntaManager;

	@Override
	public void create() {
		Assets.load();
		Assets.manager.finishLoading(); // Aguarda o carregamento dos assets

		batch = new SpriteBatch();
		balloonController = new BalloonController();
		archerController = new ArcherController();
		arrowController = new ArrowController();

		InputMultiplexer multiplexer = new InputMultiplexer();
		multiplexer.addProcessor(new MyGameInputProcessor(archerController, arrowController));
		Gdx.input.setInputProcessor(multiplexer);
	}

	@Override
	public void render() {
		float deltaTime = Gdx.graphics.getDeltaTime();

		Pergunta perguntaEscolhida = perguntaManager.getPerguntaAleatoria();
		System.out.println("Pergunta selecionada: " + perguntaEscolhida.getTexto()  + " - " + perguntaEscolhida.getResposta());
		// Atualizações
		balloonController.update(deltaTime);
		arrowController.update(deltaTime);

		ScreenUtils.clear(0, 1, 0, 1);

		// Renderização
		batch.begin();
		balloonController.render(batch);
		archerController.render(batch);
		arrowController.render(batch);
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		Assets.dispose(); // Descarrega todos os assets
	}
}

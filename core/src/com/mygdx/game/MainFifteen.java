package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.handlers.GameServicesHandler;
import com.mygdx.game.handlers.RequestHandler;
import com.mygdx.game.screens.MainMenuScreen;
import com.mygdx.game.screens.Screens;

public class MainFifteen extends Game {

	public final GameServicesHandler gameServiceHandler;
	public final RequestHandler reqHandler;

	public MainFifteen(RequestHandler reqHandler, GameServicesHandler gameServiceHandler) {
		this.reqHandler = reqHandler;
		this.gameServiceHandler = gameServiceHandler;
	}

	public Stage stage;
	public SpriteBatch batcher;

	@Override
	public void create() {
		stage = new Stage(new StretchViewport(Screens.SCREEN_WIDTH, Screens.SCREEN_HEIGHT));

		batcher = new SpriteBatch();
		Assets.load();

		if (Settings.didBuyNoAds)
			reqHandler.removeAds();

		setScreen(new MainMenuScreen(this));
	}

}
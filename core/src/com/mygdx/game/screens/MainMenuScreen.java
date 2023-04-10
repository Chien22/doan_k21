package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.Assets;
import com.mygdx.game.MainFifteen;
import com.mygdx.game.Settings;
import com.mygdx.game.game.GameScreen;

public class MainMenuScreen extends Screens {

	Image imgTitulo;
	Label lbPlay;
	Label lbHelp;
	Label lbMore;
	Button btMusica;
	Button btSonido;

	public MainMenuScreen(final MainFifteen game) {
		super(game);
		imgTitulo = new Image(Assets.titulo);
		imgTitulo.setPosition(SCREEN_WIDTH / 2f - imgTitulo.getWidth() / 2f, 630);

		lbPlay = new Label("Play", Assets.labelStyleGrande);
		lbPlay.setPosition(SCREEN_WIDTH / 2f - lbPlay.getWidth() / 2f, 450);
		addEfectoPress(lbPlay);
		lbPlay.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				changeScreenWithFadeOut(GameScreen.class, game);
			};
		});

		// Help
		lbHelp = new Label("Help", Assets.labelStyleGrande);
		lbHelp.setPosition(SCREEN_WIDTH / 2f - lbHelp.getWidth() / 2f, 350);
		addEfectoPress(lbHelp);
		lbHelp.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				changeScreenWithFadeOut(HelpScreen.class, game);
			};
		});
		btMusica = new Button(Assets.styleButtonMusica);
		btMusica.setPosition(5, 5);
		btMusica.setChecked(!Settings.isMusicOn);
		Gdx.app.log("Musica", Settings.isMusicOn + "");
		btMusica.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Settings.isMusicOn = !Settings.isMusicOn;
				btMusica.setChecked(!Settings.isMusicOn);
				if (Settings.isMusicOn)
					Assets.playMusic();
				else
					Assets.pauseMusic();

			}
		});

		btSonido = new Button(Assets.styleButtonSonido);
		btSonido.setPosition(75, 5);
		btSonido.setChecked(!Settings.isSoundOn);
		btSonido.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Settings.isSoundOn = !Settings.isSoundOn;
				btSonido.setChecked(!Settings.isSoundOn);
			}
		});

		stage.addActor(imgTitulo);
		stage.addActor(lbPlay);
		stage.addActor(lbHelp);
		stage.addActor(btMusica);
		stage.addActor(btSonido);

	}

	@Override
	public void update(float delta) {

	}

	@Override
	public void draw(float delta) {
		batcher.begin();
		batcher.draw(Assets.fondo, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		batcher.end();

	}

	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Keys.ESCAPE || keycode == Keys.BACK)
			Gdx.app.exit();
		return true;

	}
}

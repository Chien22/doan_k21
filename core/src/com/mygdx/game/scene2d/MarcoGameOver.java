package com.mygdx.game.scene2d;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.Assets;
import com.mygdx.game.Settings;
import com.mygdx.game.screens.MainMenuScreen;
import com.mygdx.game.screens.Screens;

public class MarcoGameOver extends Group {

	Screens screen;

	public MarcoGameOver(final Screens screen, int time, int moves) {
		this.screen = screen;
		setSize(420, 450);
		setOrigin(getWidth() / 2f, getHeight() / 2f);
		setPosition(Screens.SCREEN_WIDTH / 2f - getWidth() / 2f, 260);
		setScale(.5f);

		Image background = new Image(Assets.fondoPuntuaciones);
		background.setSize(getWidth(), getHeight());
		addActor(background);

		Label lbCongratulations = new Label("Congratulations!", Assets.labelStyleGrande);
		lbCongratulations.setAlignment(Align.center);
		lbCongratulations.setFontScale(.50f);
		lbCongratulations.setPosition(getWidth() / 2f - lbCongratulations.getWidth() / 2f, 365);
		addActor(lbCongratulations);

		final Table scoreTable = new Table();
		scoreTable.setSize(getWidth(), 180);
		scoreTable.setY(170);
		scoreTable.padLeft(15).padRight(15);
		// scoreTable.debug();

		// ACTUAL TIME
		Label lbTime = new Label("Time", Assets.labelStyleChico);
		lbTime.setAlignment(Align.left);

		Label lblNumTime = new Label(time + "s", Assets.labelStyleChico);
		lblNumTime.setAlignment(Align.right);

		// BEST TIME
		Label lbBestTime = new Label("Best time", Assets.labelStyleChico);
		lbBestTime.setAlignment(Align.left);

		Label lblNumBestTime = new Label(Settings.bestTime + "s", Assets.labelStyleChico);
		lblNumBestTime.setAlignment(Align.right);

		// ACTUAL MOVES
		Label lbMoves = new Label("Moves", Assets.labelStyleChico);
		lbMoves.setAlignment(Align.left);

		Label lbNumMoves = new Label(moves + "", Assets.labelStyleChico);
		lbNumMoves.setAlignment(Align.right);
		// lbNumMoves.setFontScale(.75f);

		// BEST MOVES
		Label lbBestMoves = new Label("Best moves", Assets.labelStyleChico);
		lbBestMoves.setAlignment(Align.left);

		Label lbBestNumMoves = new Label(Settings.bestMoves + "", Assets.labelStyleChico);
		lbBestNumMoves.setAlignment(Align.right);

		scoreTable.add(lbTime).left();
		scoreTable.add(lblNumTime).right().expand();

		scoreTable.row();
		scoreTable.add(lbBestTime).left();
		scoreTable.add(lblNumBestTime).right().expand();

		scoreTable.row();
		scoreTable.add(lbMoves).left();
		scoreTable.add(lbNumMoves).right().expand();

		scoreTable.row();
		scoreTable.add(lbBestMoves).left();
		scoreTable.add(lbBestNumMoves).right().expand();

//		

		final Label lbMainMenu = new Label("Main menu", Assets.labelStyleGrande);
		lbMainMenu.setWidth(getWidth() - 10);
		lbMainMenu.setFontScale(.75f);
		lbMainMenu.setPosition(getWidth() / 2f - lbMainMenu.getWidth() / 2f, 30);
		lbMainMenu.setWrap(true);
		lbMainMenu.setAlignment(Align.center);
		screen.addEfectoPress(lbMainMenu);
		lbMainMenu.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				screen.changeScreenWithFadeOut(MainMenuScreen.class, screen.game);
			}
		});

		addAction(Actions.sequence(Actions.scaleTo(1, 1, .2f), Actions.run(new Runnable() {

			@Override
			public void run() {
				addActor(scoreTable);
				addActor(lbMainMenu);
			}
		})));

	}
}

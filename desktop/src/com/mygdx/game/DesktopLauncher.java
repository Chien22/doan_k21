package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.game.handlers.GoogleGameServicesHandler;
import com.mygdx.game.handlers.RequestHandler;

public class DesktopLauncher {
	public static void main(String[] args) {
		Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();

		new Lwjgl3Application(new MainFifteen(handler, gameHandler), cfg);
	}

	static RequestHandler handler = new RequestHandler() {

		@Override
		public void showRater() {
			// TODO Auto-generated method stub

		}

		@Override
		public void showMoreGames() {
			// TODO Auto-generated method stub

		}

		@Override
		public void showInterstitial() {
			// TODO Auto-generated method stub

		}

		@Override
		public void showFacebook() {
			// TODO Auto-generated method stub

		}

		@Override
		public void showAdBanner() {
			// TODO Auto-generated method stub

		}

		@Override
		public void shareOnTwitter(String mensaje) {
			// TODO Auto-generated method stub

		}

		@Override
		public void shareOnFacebook(String mensaje) {
			// TODO Auto-generated method stub

		}

		@Override
		public void restorePurchases() {
			// TODO Auto-generated method stub

		}

		@Override
		public void removeAds() {
			// TODO Auto-generated method stub

		}

		@Override
		public void hideAdBanner() {
			// TODO Auto-generated method stub

		}

		@Override
		public void buyNoAds() {
			// TODO Auto-generated method stub

		}
	};

	static GoogleGameServicesHandler gameHandler = new GoogleGameServicesHandler() {

		@Override
		public void unlockAchievement(String achievementId) {
			// TODO Auto-generated method stub

		}

		@Override
		public void submitScore(long score, String leaderboard) {
			// TODO Auto-generated method stub

		}

		@Override
		public void signOut() {
			// TODO Auto-generated method stub

		}

		@Override
		public void signIn() {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean isSignedIn() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void getLeaderboard() {
			// TODO Auto-generated method stub

		}

		@Override
		public void getAchievements() {
			// TODO Auto-generated method stub

		}
	};
}

package com.mygdx.game.handlers;

public interface GameServicesHandler {
	public void submitScore(long score, String leaderboard);
	public void unlockAchievement(String achievementId);
	public void getLeaderboard();
	public void getAchievements();
	public boolean isSignedIn();
	public void signIn();
	public void signOut();

}

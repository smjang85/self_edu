package mock;

public class Game {
	GameNumGen gameNumGen;
	GameLevel gameLevel;
	
	public Game(GameNumGen gameNumGen) {
		this.gameNumGen = gameNumGen;
	}
	
	public void init(GameLevel gameLevel) {
		gameNumGen.generate(gameLevel);
	}
}

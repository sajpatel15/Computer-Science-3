
public class Driver {
	public static void main(String[] args) {
		TowerGame game = new TowerGame(3);
		game.moveDisk(2, 1);
		game.moveDisk(2, 1);
		game.moveDisk(2, 1);
		game.showTowerStates();
	}
}

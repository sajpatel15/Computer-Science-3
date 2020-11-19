public class TowerGame {
	
	private StackLinked<Integer>[] tower; 
	
	public TowerGame(int n) {

		// create three stacks
		tower = new StackLinked[3];
		for (int i = 0; i < 3; i++){
			tower[i] = new StackLinked<Integer>();
		}
		for (int d = n; d > 0; d--){
			
			tower[1].push(new Integer(d)); 
		}
		
	}

	public void showTowerStates() {
		
		System.out.print("Tower One: ");
		tower[0].print();
		System.out.print("Tower Two: ");
		tower[1].print();
		System.out.print("Tower Three: ");
		tower[2].print();
	}
	
	public void moveDisk(int towerFrom, int towerTo)
	{
		if(towerFrom <=0 ||towerTo<=0|| towerFrom >3 || towerTo>3)
		{
			throw new IllegalArgumentException("That Tower Does Not Exist");
		}
		if(tower[towerFrom-1].size()<=0)
		{
			throw new IllegalStateException("That Tower is Empty");
		}
		int temp = tower[towerFrom-1].pop();
		tower[towerTo-1].push(temp);
		
	}

	
}
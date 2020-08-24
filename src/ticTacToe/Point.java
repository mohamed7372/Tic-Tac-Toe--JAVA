package ticTacToeAi;

public class Point {
	private int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Point() {
		this(0, 0);
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public boolean isEmpty(char arr[][], int i, int j) {
    	if (arr[i][j] == ' ') {
    		return true;
    	}
    	return false;
    }
	public boolean verifierPoint(char arr[][], Player player, boolean affMsg) {
		if (x == 0 || y == 0) {
			System.out.println("You should enter numbers!");
    		return true;
		}
    	else if (x > 3 || x < 1 || y > 3 || y < 1) {
    		System.out.println("Coordinates should be from 1 to 3!");
			return true;
		}
		else {
			int i, j;
	    	j = x - 1;
	    	
	    	i = y - 1 + 2;
	    	if (y == 2) {
	    		i++;
	    	}
	    	else  if (y == 3) {
	    		i += 2;
	    	}
	    	// verify if empty this case or not
	    	if (isEmpty(arr, i % 3, j % 3)) {
	    		arr[i % 3][j % 3] = player.getPlayer();
	    		return false;
	    	}
	    	else {
	    		if (affMsg)
	    			System.out.println("This cell is occupied! Choose another one!");
	    		return true;
	    	}
		}
	}
}
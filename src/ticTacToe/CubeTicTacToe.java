package ticTacToeAi;


public class CubeTicTacToe {
	char[][] arr = {{' ', ' ', ' '},
					{' ', ' ', ' '},
					{' ', ' ', ' '}};

	public void setValueRealAt(int x,int y, Player player) {
		arr[x][y] = player.getPlayer();
	}
	public void setValueAt(int x, int y, Player player) {
		Point p = new Point(x, y);
		arr[p.getX()][p.getY()] = player.getPlayer();
	}
	public void affCube() {
		System.out.println("---------");
		for (int i = 0; i < arr.length; i++) {
			System.out.println("| " + arr[i][0] + " " + arr[i][1] + " " + arr[i][2] + " |");
		}
		System.out.println("---------");
	}
	public String winnerEtat() {
		// trier row
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][0] != ' ' && arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2])
				return arr[i][0] + " wins";
		}
		// trier colone
		for (int i = 0; i < arr.length; i++) {
			if (arr[0][i] != ' ' && arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i])
				return arr[0][i] + " wins";
		}
		// diagonale primaire and secondaire
		if (arr[0][0] != ' ' && arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2]) 
			return arr[0][0] + " wins";
		else if (arr[0][2] != ' ' && arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0])
			return arr[0][2] + " wins";
		// draw all case 
		int nbr = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == ' ') {
					nbr++;
				}
			}
		}
		if (nbr == 0) {
			return "Draw";
		}
		return "Game not finished";
	}
	public int[] caseEmpty(char player) {
		int pos = 0;
		// for row
		for (int i = 0; i < arr.length; i++) {
			if (((arr[i][0] == player && arr[i][0] == arr[i][1]) && arr[i][2] == ' ' && arr[i][0] != ' ') ||
					((arr[i][0] == player && arr[i][0] == arr[i][2]) && arr[i][1] == ' ' && arr[i][0] != ' ') ||
					((arr[i][1] == player && arr[i][1] == arr[i][2]) && arr[i][0] == ' ' && arr[i][1] != ' ')) {
				for (int j = 0; j < arr.length; j++) {
					if(arr[i][j] == ' ') {
						pos = j;
					}
				}
				return new int[] {i, pos};
			}
		}
		// for colone
		for (int i = 0; i < arr.length; i++) {
			if ((arr[0][i] == player && arr[0][i] == arr[1][i]) && arr[2][i] == ' '  && arr[0][i] != ' '||
					(arr[0][i] == player && arr[0][i] == arr[2][i]) && arr[1][i] == ' '  && arr[0][i] != ' '||
					(arr[1][i] == player && arr[1][i] == arr[2][i]) && arr[0][i] == ' ' && arr[1][i] != ' ') {
				for (int j = 0; j < arr.length; j++) {
					if(arr[j][i] == ' ') {
						pos = j;
					}
				}
				return new int[] {pos, i};
			}
		}
		// for diagonale primaire
		if ((arr[0][0] == player && arr[0][0] == arr[1][1]) && arr[2][2] == ' ' && arr[0][0] != ' ' ||
				(arr[0][0] == player && arr[0][0] == arr[2][2]) && arr[1][1] == ' ' && arr[0][0] != ' ' ||
				(arr[1][1] == player && arr[1][1] == arr[2][2]) && arr[0][0] == ' ' && arr[1][1] != ' ') {
			for (int j = 0; j < arr.length; j++) {
				if(arr[j][j] == ' ') {
					pos = j;
				}
			}
			return new int[] {pos, pos};
		}
		// for diagonale secondaire
		if ((arr[0][2] == player && arr[0][2] == arr[1][1]) && arr[2][0] == ' ' && arr[0][2] != ' ' ||
				(arr[0][2] == player && arr[0][2] == arr[2][0]) && arr[1][1] == ' ' && arr[0][2] != ' ' ||
				(arr[1][1] == player && arr[1][1] == arr[2][0]) && arr[0][2] == ' '&& arr[1][1] != ' ' ) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[j][2 - j] == ' ') {
					pos = j;	
				}
			}
			return new int[] {pos, 2 - pos};
		}
		return new int[] {-1, -1};
	}
}

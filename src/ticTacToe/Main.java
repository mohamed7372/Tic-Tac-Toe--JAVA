package ticTacToe;

import java.util.Scanner;

public class Main {
	final static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
        char arr[][] = fillCube();
        affCube(arr);
        playAllGame(arr);
    }
	
    static char[][] fillCube() {
    	char arr[][] = new char[3][3];
        for (int i = 0; i < arr.length; i++) {
        	for (int j = 0; j < arr.length; j++) {
        		arr[i][j] = '_';
			}
		}
        return arr;
    }
    static void affCube(char arr[][]) {
        System.out.println("---------");
        for (int i = 0; i < arr.length; i++) {
        	System.out.println("| " + arr[i][0] + " " + arr[i][1] + " " + arr[i][2] + " |");
		}
        System.out.println("---------");
    } 
    static String winnerEtat(char arr[][]) {
    	int nbr = 0, nbrO = 0, nbrX = 0, pos = 0;
    	// verify if nbr X different to nbr O (that's mean this game not fair)
    	for (int i = 0; i < arr.length; i++) {
    		for (int j = 0; j < arr.length; j++) {
    			if (arr[i][j] == 'O') {
    				nbrO++;
    			}
    			else if (arr[i][j] == 'X') {
    				nbrX++;
    			}
			}
 		}
    	if ((nbrO - nbrX >= 2) || (nbrX - nbrO >= 2)) {
    		return "Impossible";
    	}
    	// if we find two winners
    	for (int i = 0; i < arr.length; i++) {
			if (arr[i][0] != '_' && arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2]) {
				nbr++;
				pos = i;
			}
		}
		if (nbr == 1){
			return arr[pos][0] + " wins";
		}
    	for (int i = 0; i < arr.length; i++) {
			if (arr[0][i] != '_' && arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i]) {
				nbr++;
				pos = i;
			}
		}
		if (nbr == 1){
			return arr[0][pos] + " wins";
		}
		if (nbr >= 2) {
			return "Impossible 2";
		}
    	// diagonale
		if (arr[0][0] != '_' && arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2]) {
			return arr[0][0] + " wins";
		}
		else if (arr[0][2] != '_' && arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0]){
			return arr[0][2] + " wins";
		}
		// draw all case 
    	nbr = 0;
    	for (int i = 0; i < arr.length; i++) {
    		for (int j = 0; j < arr.length; j++) {
    			if (arr[i][j] == '_') {
    				nbr++;
    			}
    		}
		}
    	if (nbr == 0) {
    		return "Draw";
    	}
    	
    	return "Game not finished";
    }
    static boolean isEmpty(char arr[][], int i, int j) {
    	if (arr[i][j] == '_') {
    		return true;
    	}
    	return false;
    }
    static char[][] playGame(char arr[][], char player) {
    	System.out.print("Enter the coordinates: ");
    	int posX = 0, posY = 0;
    	posX = scanner.nextInt();
        posY = scanner.nextInt();
        if (posX > 3 || posX < 1 || posY > 3 || posY < 1) {
    		System.out.println("Coordinates should be from 1 to 3!");
    		playGame(arr, player);
    	}
    	else {
    		int i, j;
        	j = posX - 1;
        	
        	i = posY - 1 + 2;
        	if (posY == 2) {
        		i++;
        	}
        	else  if (posY == 3) {
        		i += 2;
        	}
        	// verify if empty this case or not
        	if (isEmpty(arr, i % 3, j % 3)) {
        		arr[i % 3][j % 3] = player;
        		return arr;
        	}
        	else {
        		System.out.println("This cell is occupied! Choose another one!");
        		playGame(arr, player);
        	}
    	}
    	return arr;
    }
    static void playAllGame(char arr[][]) {
    	int i = 0;
        char player;
        while (winnerEtat(arr).equalsIgnoreCase("Game not finished")) {
        	if (i % 2 == 0) {
        		player = 'X';
        	}
        	else {
        		player = 'O';
        	}
        	arr = playGame(arr , player);
            affCube(arr);
            i++;
        	if (winnerEtat(arr).equalsIgnoreCase("X wins") || winnerEtat(arr).equalsIgnoreCase("O wins")) {
        		System.out.println(winnerEtat(arr));
        		break;
        	}
        	else if (winnerEtat(arr).equalsIgnoreCase("Draw")) {
        		System.out.println(winnerEtat(arr));
        		break;
        	}
        }
    } 
}
package ticTacToeAi;

import java.util.Random;
import java.util.Scanner;

public class Main {
	final static Scanner scanner = new Scanner(System.in);
	final static Random random = new Random();
	
	public static void main(String[] args) {
		modePlay();
	}
	
	// mode : easy, medium,
	static void modePlay() {
		int fin = 0;
		do {
			System.out.print("Input command: ");
			String mode = scanner.nextLine();
			
			switch (mode) {
			case "start user user":
				playUserUser();
				break;
			
			case "start easy easy":
				playEasyEasy();
				break;
			case "start easy user":
				playEasyUser();
				break;
			case "start user easy":
				playUserEasy();
				break;
				
			case "start medium medium":
				playMediumMedium();
				break;
			case "start user medium":
				playUserMedium();
				break;
			case "start medium user":
				playMediumUser();
				break;
				
			case "start easy medium":
                playEasyMedium();
                break;
            case "start medium easy":
                playMediumEasy();
                break;
				
			case "exit":
				fin = 1;
				break;
			default:
				System.out.println("Bad parameters!");
				break;
			}
			System.out.println();
		}while (fin == 0);
	}
	static int convertir(String pos) {
    	switch (pos) {
		case "1":
			return 1;
		case "2":
			return 2;
		case "3":
			return 3;
		case "4":
			return 4;
		case "5":
			return 5;
		case "6":
			return 6;
		case "7":
			return 7;
		case "8":
			return 8;
		case "9":
			return 9;
		default:
			return 0;
		}
    }
	
	// user playing
	static void playUser(CubeTicTacToe p, Player player) {
    	String s;
		System.out.print("Enter the coordinates: ");
		s = scanner.nextLine();
		int posX = convertir(s.substring(0,1));
		int posY = convertir(s.substring(2,3));
		
		Point pnt = new Point(posX, posY);
		if(pnt.verifierPoint(p.arr, player, true))
			playUser(p, player);
	}
	// easy computer playing
	static void playEasy(CubeTicTacToe p, Player player) {
		int posX = random.nextInt(3) + 1;
		int posY = random.nextInt(3) + 1;
		
		Point pnt = new Point(posX, posY);
		if(pnt.verifierPoint(p.arr, player, false))
			playEasy(p, player);
	}
	// medium computer playing
	static void playMedium(CubeTicTacToe p, Player player) {
		int[] res = p.caseEmpty(player.getPlayer());
		
		char ch = player == Player.X ? 'O' : 'X';
		int[] res2 = p.caseEmpty(ch);
		if (res[0] != -1) {
			p.setValueRealAt(res[0], res[1], player);
		}
		else if (res2[0] != -1) {
			p.setValueRealAt(res2[0], res2[1], player);
		}
		else {
			Point pnt = null;
			do {
				int posX = random.nextInt(3) + 1;
				int posY = random.nextInt(3) + 1;
				
				pnt = new Point(posX, posY);
			}while(pnt.verifierPoint(p.arr, player, false));
		}
	}
	
	// user vs user
	static void playUserUser() {
		CubeTicTacToe p = new CubeTicTacToe();
		p.affCube();
		boolean turn = true;
		while(true) {
			Player player = turn ? Player.X : Player.O; 
    		playUser(p, player);
    		p.affCube();
    		turn = !turn;
        	if (p.winnerEtat().equals("Draw") || p.winnerEtat().substring(2, 6).equals("wins")) 
        		break;
		}
        System.out.println(p.winnerEtat());
	}
	
	// user vs easy, easy vs easy
	static void playUserEasy() {
		CubeTicTacToe p = new CubeTicTacToe();
		p.affCube();
		boolean turn = true;
		while(true) {
			if (turn)
				playUser(p, Player.X);
			else {
				System.out.println("Making move level \"easy\"");
				playEasy(p, Player.O);
			}
    		p.affCube();
    		turn = !turn;
        	if (p.winnerEtat().equals("Draw") || p.winnerEtat().substring(2, 6).equals("wins")) 
        		break;
		}
        System.out.println(p.winnerEtat());
	}
	static void playEasyUser() {
		CubeTicTacToe p = new CubeTicTacToe();
		p.affCube();
		boolean turn = true;
		while(true) {
			if (turn) {
				System.out.println("Making move level \"easy\"");
				playEasy(p, Player.X);
			}
			else 
				playUser(p, Player.O);
    		p.affCube();
    		turn = !turn;
        	if (p.winnerEtat().equals("Draw") || p.winnerEtat().substring(2, 6).equals("wins")) 
        		break;
		}
        System.out.println(p.winnerEtat());
	}
	static void playEasyEasy() {
		CubeTicTacToe p = new CubeTicTacToe();
		p.affCube();
		boolean turn = true;
		while(true) {
			if (turn) {
				System.out.println("Making move level \"easy\"");
				playEasy(p, Player.X);
			}
			else {
				System.out.println("Making move level \"easy\"");
				playEasy(p, Player.O);
			}
    		p.affCube();
    		turn = !turn;
        	if (p.winnerEtat().equals("Draw") || p.winnerEtat().substring(2, 6).equals("wins")) 
        		break;
		}
        System.out.println(p.winnerEtat());
	}
	
	// user vs medium, medium vs medium
	static void playUserMedium() {
		CubeTicTacToe p = new CubeTicTacToe();
		p.affCube();
		boolean turn = true;
		while(true) {
			if (turn)
				playUser(p, Player.X);
			else {
				System.out.println("Making move level \"medium\"");
				playMedium(p, Player.O);
			}
    		p.affCube();
    		turn = !turn;
        	if (p.winnerEtat().equals("Draw") || p.winnerEtat().substring(2, 6).equals("wins")) 
        		break;
		}
        System.out.println(p.winnerEtat());
	}
	static void playMediumUser() {
		CubeTicTacToe p = new CubeTicTacToe();
		p.affCube();
		boolean turn = true;
		while(true) {
			if (turn) {
				System.out.println("Making move level \"medium\"");
				playMedium(p, Player.X);
			}
			else 
				playUser(p, Player.O);
    		p.affCube();
    		turn = !turn;
        	if (p.winnerEtat().equals("Draw") || p.winnerEtat().substring(2, 6).equals("wins")) 
        		break;
		}
        System.out.println(p.winnerEtat());
	}
	static void playMediumMedium() {
		CubeTicTacToe p = new CubeTicTacToe();
		p.affCube();
		boolean turn = true;
		while(true) {
			if (turn) {
				System.out.println("Making move level \"medium\"");
				playMedium(p, Player.X);
			}
			else {
				System.out.println("Making move level \"medium\"");
				playMedium(p, Player.O);
			}
    		p.affCube();
    		turn = !turn;
        	if (p.winnerEtat().equals("Draw") || p.winnerEtat().substring(2, 6).equals("wins")) 
        		break;
		}
        System.out.println(p.winnerEtat());
	}
	
	// easy, medium
	static void playMediumEasy() {
		CubeTicTacToe p = new CubeTicTacToe();
		p.affCube();
		boolean turn = true;
		while(true) {
			if (turn) {
				System.out.println("Making move level \"medium\"");
				playMedium(p, Player.X);
			}
			else {
				System.out.println("Making move level \"easy\"");
				playEasy(p, Player.O);
			}
    		p.affCube();
    		turn = !turn;
        	if (p.winnerEtat().equals("Draw") || p.winnerEtat().substring(2, 6).equals("wins")) 
        		break;
		}
        System.out.println(p.winnerEtat());
	}
	static void playEasyMedium() {
		CubeTicTacToe p = new CubeTicTacToe();
		p.affCube();
		boolean turn = true;
		while(true) {
			if (turn) {
				System.out.println("Making move level \"easy\"");
				playEasy(p, Player.X);
			}
			else {
				System.out.println("Making move level \"Medium\"");
				playMedium(p, Player.O);
			}
    		p.affCube();
    		turn = !turn;
        	if (p.winnerEtat().equals("Draw") || p.winnerEtat().substring(2, 6).equals("wins")) 
        		break;
		}
        System.out.println(p.winnerEtat());
	}
}

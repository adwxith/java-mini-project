import java.util.*;

public class tictactoe {

	static String[] pos;
	static String turn;


	static String Winner()
	{
		for (int a = 0; a < 8; a++) {
			String line = null;
			switch (a) {
			case 0:
				line = pos[0] + pos[1] + pos[2];
				break;
			case 1:
				line = pos[3] + pos[4] + pos[5];
				break;
			case 2:
				line = pos[6] + pos[7] + pos[8];
				break;
			case 3:
				line = pos[0] + pos[3] + pos[6];
				break;
			case 4:
				line = pos[1] + pos[4] + pos[7];
				break;
			case 5:
				line = pos[2] + pos[5] + pos[8];
				break;
			case 6:
				line = pos[0] + pos[4] + pos[8];
				break;
			case 7:
				line = pos[2] + pos[4] + pos[6];
				break;
			}
			if (line.equals("XXX")) {
				return "X";
			}
			else if (line.equals("OOO")) {
				return "O";
			}
		}
		for (int a = 0; a < 9; a++) {
			if (Arrays.asList(pos).contains(
					String.valueOf(a + 1))) {
				break;
			}
			else if (a == 8) {
				return "draw";
			}
		}

		System.out.println(
			turn + " Enter the Position :");
		return null;
	}
	

	static void printpos()
	{
		System.out.println("| " + pos[0] + " | "
						+ pos[1] + " | " + pos[2]
						+ " |"+ '\n' );

		System.out.println("| " + pos[3] + " | "
						+ pos[4] + " | " + pos[5]
						+ " |"+ '\n' );
		System.out.println("| " + pos[6] + " | "
						+ pos[7] + " | " + pos[8]
						+ " |"+ '\n' );
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		pos = new String[9];
		turn = "X";
		String winner = null;

		for (int a = 0; a < 9; a++) {
			pos[a] = String.valueOf(a + 1);
		}

		System.out.println(" Tic Tac Toe by adwaith "+  '\n' );
		printpos();

		System.out.println(
			"X Enter the Position :");

		while (winner == null) {
			int numInput;
		
	
			try {
				numInput = in.nextInt();
				if (!(numInput > 0 && numInput <= 9)) {
					System.out.println(
						"Invalid input; re-enter position:");
					continue;
				}
			}
			catch (InputMismatchException e) {
				System.out.println(
					"Invalid input; re-enter positionr:");
				continue;
			}
			

			if (pos[numInput - 1].equals(
					String.valueOf(numInput))) {
				pos[numInput - 1] = turn;

				if (turn.equals("X")) {
					turn = "O";
				}
				else {
					turn = "X";
				}

				printpos();
				winner = Winner();
			}
			else {
				System.out.println(
					"position already taken; re-enter position:");
			}
		}
	
		if (winner.equalsIgnoreCase("draw")) {
			System.out.println(
				" noobs , its a DRAW");
		}
		else {
			System.out.println(
				"Congratulations! " + winner
				+ "'s have won!");
		}
	in.close();
	}
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


//pgn-extract --output input.pgn -Wlalg  -C -N -V --notags /home/danish-shark/Downloads/December1.pgn

public class Main {
	private static double[] count = new double[32];
	private static boolean[] temp = new boolean[32];
	private static String[] startingPositions = {"a2","b2","c2","d2","e2","f2","g2","h2",
			"a1","b1","c1","d1","e1","f1","g1","h1",
			"a7","b7","c7","d7","e7","f7","g7","h7",
			"a8","b8","c8","d8","e8","f8","g8","h8"};

	public static void main(String[] args) throws FileNotFoundException {
		long startTime = System.currentTimeMillis();
		Scanner input = new Scanner(new File("/home/danish-shark/workspace/ChessSurvivalAnalysis/src/input.pgn"));
		input.useDelimiter("\n\n");
		double i=0,prev=0,cur=0;
		Engine engine = new Engine();
		System.out.print("Analysing games ");
		while(input.hasNext()){
			i++;
			temp = engine.newGame(input.next().replaceAll("\n"," ").split("[0-9]+[.][ ]*"));
			for(int j=0;j<32;j++)
				if(temp[j])
					count[j]++;
			engine.reset();
			cur = i;
			if((cur-prev) > 27500){
				System.out.print(".");
				prev = cur;
			}
		}
		System.out.println(" ");
		System.out.println("Done!");
		System.out.println("Total games analysed :  " + (int)i);
		System.out.println("Time taken : " + ((System.currentTimeMillis()-startTime)/1000.0) + " seconds");	
		System.out.println("The survival rates are : ");
		System.out.println("Starting Square " + " Survival Rate");
		Piece[] piece = new Piece[32];
		for(int j=0;j<32;j++)
			piece[j] = new Piece(startingPositions[j],(Math.round((count[j]/i)*100 * 100.0) / 100.0));
		Arrays.sort(piece, 0, piece.length);
		for(int j=0;j<32;j++)
			System.out.println("     " + piece[j].getPos() + "             " + piece[j].getChance() + "%");
		input.close();
	}
}
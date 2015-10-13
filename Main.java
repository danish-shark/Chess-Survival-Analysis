import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static double[] count = new double[32];
	private static boolean[] temp = new boolean[32];
	private static String[] pieceNames = {"White Pawn(a2)","White Pawn(b2)","White Pawn(c2)","White Pawn(d2)","White Pawn(e2)","White Pawn(f2)","White Pawn(g2)","White Pawn(h2)",
										"White Rook(a1)","White Knight(b1)","White Bishop(c1)","White Queen(d1)","White King(e1)","White Bishop(f1)","White Knight(g1)","White Rook(h1)",
										"Black Pawn(a7)","Black Pawn(b7)","Black Pawn(c7)","Black Pawn(d7)","Black Pawn(e7)","Black Pawn(f7)","Black Pawn(g7)","Black Pawn(h7)",
										"Black Rook(a8)","Black Knight(b8)","Black Bishop(c8)","Black Queen(d8)","Black King(e8)","Black Bishop(f8)","Black Knight(g8)","Black Rook(h8)"};
	
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		BufferedReader ip = new BufferedReader(new FileReader("/home/danish-shark/workspace/ChessSurvivalAnalysis/input.pgn"));
		String newstr="",linetwo=null,lineone=null;
		double i=0,prev=0,cur=0;
		Engine engine = new Engine();
		System.out.print("Analysing games ");
		while((linetwo = ip.readLine()) !=null){
			newstr="";lineone=linetwo;
			while((lineone = ip.readLine()) !=null){
				if(lineone.length()>0){
					int beg=lineone.length() < 4 ? 0 : (lineone.length()-4),end=lineone.length();
					char lastChar = lineone.charAt(end-1);
					if(lineone.substring(beg,end).contains("-")
							|| lastChar == '*'){
						newstr = newstr + lineone;
						break;
					}
					newstr = newstr + lineone + (lastChar != ' ' ? " " : "");
				}
			}
			i++;
			if(newstr.length() > 1)
				temp = engine.newGame(newstr.split("[0-9]+[.][ ]*"));
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
			piece[j] = new Piece(pieceNames[j],(Math.round((count[j]/i)*100 * 100.0) / 100.0));
		Arrays.sort(piece, 0, piece.length);
		for(int j=0;j<32;j++)
			System.out.printf("%-20s %.2f%%\n", piece[j].getPos(), piece[j].getChance());
		ip.close();
	}
}
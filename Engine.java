/*
 * numbering scheme - white pawns from left to right - 0-7 
 * 	  white rook left - 8
 * 	  white knight left - 9
 * 	  white bishop left - 10
 * 	  white queen - 11
 * 	  white king - 12
 * 	  white bishop right - 13
 * 	  white knight right - 14
 * 	  white rook right - 15
 * same scheme for black pieces from 16-31
 */


public class Engine {
	private boolean[] isAlive = new boolean[32];
	private int[][] board = new int[8][8];
	int moveCount=0;
	Engine(){
		reset();
	}
	
	public void makeMove(String move){
		int startX = move.charAt(0) - 97;
		int startY = move.charAt(1) - 49;
		int destX = move.charAt(2) - 97;
		int destY = move.charAt(3) - 49;
		//normal move
		if(board[7-destY][destX]==0){
			board[7-destY][destX] = board[7-startY][startX];
			board[7-startY][startX] = 0;
		}
		//capture
		else{
			isAlive[board[7-destY][destX]-1] = false;
			board[7-destY][destX] = board[7-startY][startX];
			board[7-startY][startX] = 0;
		}
		//castling
		if((board[7-destY][destX]==13 || board[7-destY][destX]==29) && Math.abs(startX-destX) > 1){
			if(destX-startX<0){
				board[7-destY][destX+1] = board[7-destY][0];
				board[7-destY][0] = 0;
			}
			else{
				board[7-destY][destX-1] = board[7-destY][7];
				board[7-destY][7]=0;
			}
		}
	}
	
	public void runGame(String arg[]){
		String whiteMove,blackMove,curMove;
		for(int j=1;j<arg.length-1;j++){
			curMove = arg[j].trim();
			whiteMove = curMove.substring(0, curMove.indexOf(" "));
			makeMove(whiteMove);
			blackMove = curMove.substring(curMove.indexOf(" ")).trim();
			makeMove(blackMove);
		}
		curMove = arg[arg.length-1];
		if(curMove.equalsIgnoreCase("1-0") || curMove.equalsIgnoreCase("0-1") || curMove.equalsIgnoreCase("1/2-1/2"))
			return;
		whiteMove = curMove.substring(0, curMove.indexOf(" "));
		if(whiteMove.contains("-") || whiteMove.contains("*"))
			return;
		makeMove(whiteMove);
		if(curMove.length()-whiteMove.length() > 2){
			blackMove = curMove.substring(curMove.indexOf(" ")).trim();
			if(blackMove.contains("-") || blackMove.contains("*"))
				return;
			makeMove(blackMove);
		}
	}
	
	public void showBoard(){
		int numberOfSpaces = new Integer(32).toString().length();
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(board[i][j]!=0)
					System.out.print(board[i][j] + " ");
				else
					System.out.print("-" +" ");
				int temp = (new Integer(board[i][j]).toString().length());
				for(int k=0;k<numberOfSpaces-temp;k++)
					System.out.print(" ");
			}
			System.out.println(" ");
		}
	}
	
	public void reset(){
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
				board[i][j] = 0;
		for(int i=0;i<8;i++){
			board[6][i] = i+1;
		}
		for(int i=0;i<8;i++){
			board[7][i] = i+9;
		}
		for(int i=0;i<8;i++){
			board[1][i] = i+17;
		}
		for(int i=0;i<8;i++){
			board[0][i] = i+25;
		}
		for(int i=0;i<isAlive.length;i++)
			isAlive[i] = true;
	}
	public boolean[] newGame(String[] input){
		this.runGame(input);
		return isAlive;
	}
	public static void main(String[] args) throws InterruptedException {
		Engine engine = new Engine();
		String input = "1. c2c4 c7c6 2. b2b3 d7d5 3. c1b2 c8f5 4. g1f3 e7e6 5. d2d3 h7h6 6. b1d2 g8f6 7. g2g3 f8c5 8. f1g2 e8g8 9. e1g1 b8d7 10. d1e1 f5h7 11. e2e4 a7a5 12. e4e5 f6e8 13. d3d4 c5b4 14. e1e3 e8c7 15. a2a3 b4e7 16. c4c5 b7b6 17. b3b4 d8b8 18. b2c3 c7b5 19. f1c1 b8b7 20. g2f1 d7b8 21. d2b3 a5a4 22. b3d2 b8a6 23. c5b6 b7b6 24. c3b2 a6b8 25. h2h4 b8d7 26. g3g4 a8e8 27. g4g5 h6h5 28. f1e2 h7f5 29. f3e1 g7g6 30. d2f1 b6b7 31. f1g3 g8g7 32. e1g2 f8h8 33. e3f4 e7d8 34. g2e3 d8b6 35. g3f5+ g6f5 36. e3g2 d7f8 37. c1d1 f8g6 38. f4e3 e8c8 39. d1d3 g7f8 40. a1d1 f8e7 41. e2f3 h8h7 42. e3e2 c8h8 43. e2c2 h8a8 44. g1h2 e7d7 45. h2h3 b7a7 46. f3e2 a8c8 47. f2f4 d7e7 48. c2d2 e7f8 49. g2e1 f8g7 50. e1f3 g6e7 51. f3h2 g7g6 52. h2f1 c8h8 53. f1g3 a7a8 54. e2f3 a8a7 55. g3e2 g6g7 56. d2c2 a7a6 57. b2c1 a6a7 58. c1e3 g7g6 59. e2g3 a7a6 60. d1d2 a6a7 61. g3h1 g6g7 62. h1f2 a7a6 63. f2d1 e7g6 64. h3g3 h8a8 65. d1b2 h7h8 66. f3d1 a6b7 67. c2c1 a8a6 68. b2a4 h8a8 69. a4b6 b7b6 70. d2a2 a6a4 71. c1b2 a8a6 72. d1h5 b6a7 73. e3c1 g6e7 74. h5d1 e7c8 75. d1a4 a6a4 76. g3h2 c8b6 77. h4h5 b6c4 78. b2g2 a7e7 79. g5g6 g7h8 80. g6g7+ h8g8 81. h5h6 a4a8 82. h6h7+ 1-0";
		//String input = "1. e2e3 d7d5 2. f2f4 c7c5 3. b2b3 b8c6 4. c1b2 g8f6 5. g1f3 e7e6 6. f1b5 c8d7 7. e1g1 f8d6 8. b1c3 a7a6 9. b5c6 d7c6 10. f3e5 h7h5 11. e5c6 b7c6 12. c3a4 h5h4 13. b2e5 h4h3 14. g2g3 h8h6 15. d1f3 d8c7 16. a4c5 d6e5 17. f4e5 c7e5 18. f3f4 e5f4 19. f1f4 e6e5 20. f4a4 f6d7 21. a4a6 a8a6 22. c5a6 e5e4 23. d2d4 e4d3 24. c2d3 d7e5 25. d3d4 e5g4 26. a6c5 h6f6 27. c5d3 g4e3 28. a1e1 f6e6 29. d3f4 e6e7 30. f4h3 e3c2 31. e1e7+ e8e7 32. g1f2 c2d4 33. f2e3 c6c5 34. h3g1 e7d6 35. g1f3 d4c6 36. a2a3 f7f5 37. e3d3 d5d4 38. h2h4 g7g6 39. d3e2 d6d5 40. e2d3 c6a5 41. f3d2 a5b3 42. d2b3 c5c4+ 43. d3c2 c4b3+ 44. c2b3 d5e4 45. b3c2 e4e3 46. c2d1 e3f3 47. a3a4 f3g3 48. a4a5 f5f4 49. a5a6 f4f3 50. a6a7 f3f2 51. d1e2 d4d3+ 52. e2d2 f2f1Q 53. a7a8Q f1g2+ 54. a8g2+ g3g2 55. d2d3 g2g3 56. d3e3 g3h4 57. e3f3 g6g5 58. f3g2 h4g4 59. g2h2 g4f3 60. h2h3 g5g4+ 61. h3h2 f3f2 62. h2h1 f2g3 63. h1g1 g3h3 0-1";
		String arg[] = input.split("[0-9]+[.][ ]");
		System.out.println("board before the game");
		engine.showBoard();
		System.out.println("running game");
		engine.runGame(arg);
		engine.showBoard();
		for(int i=0;i<32;i++)
			System.out.println((i+1) + " : " + engine.isAlive[i]);
	}
}
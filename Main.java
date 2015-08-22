
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


//http://chess-db.com/public/game.jsp?id=3800024.1000268.9577216.28885

/*
 * [Event "Spanish Championship Division Honor"]
[Site "?"]
[Date "2015.08.21"]
[Round "?"]
[White "Granda Zuniga, Julio E"]
[Black "Van Wely, Loek"]
[Result "1-0"]
[WhiteElo "2663"]
[BlackElo "2654"]
[ECO "A11"]

1. c2c4 c7c6 2. b2b3 d7d5 3. Bc1b2 Bc8f5 4. Ng1f3 e7e6 5. d2d3 h7h6 6.
Nb1d2 Ng8f6 7. g2g3 Bf8c5 8. Bf1g2 e8g8 9. e1g1 Nb8d7 10. Qd1e1 Bf5h7 11.
e2e4 a7a5 12. e4e5 Nf6e8 13. d3d4 Bc5b4 14. Qe1e3 Ne8c7 15. a2a3 Bb4e7 16.
c4c5 b7b6 17. b3b4 Qd8b8 18. Bb2c3 Nc7b5 19. Rf1c1 Qb8b7 20. Bg2f1 Nd7b8
21. Nd2b3 a5a4 22. Nb3d2 Nb8a6 23. c5b6 Qb7b6 24. Bc3b2 Na6b8 25. h2h4
Nb8d7 26. g3g4 Ra8e8 27. g4g5 h6h5 28. Bf1e2 Bh7f5 29. Nf3e1 g7g6 30. Nd2f1
Qb6b7 31. Nf1g3 Kg8g7 32. Ne1g2 Rf8h8 33. Qe3f4 Be7d8 34. Ng2e3 Bd8b6 35.
Ng3f5+ g6f5 36. Ne3g2 Nd7f8 37. Rc1d1 Nf8g6 38. Qf4e3 Re8c8 39. Rd1d3 Kg7f8
40. Ra1d1 Kf8e7 41. Be2f3 Rh8h7 42. Qe3e2 Rc8h8 43. Qe2c2 Rh8a8 44. Kg1h2
Ke7d7 45. Kh2h3 Qb7a7 46. Bf3e2 Ra8c8 47. f2f4 Kd7e7 48. Qc2d2 Ke7f8 49.
Ng2e1 Kf8g7 50. Ne1f3 Ng6e7 51. Nf3h2 Kg7g6 52. Nh2f1 Rc8h8 53. Nf1g3 Qa7a8
54. Be2f3 Qa8a7 55. Ng3e2 Kg6g7 56. Qd2c2 Qa7a6 57. Bb2c1 Qa6a7 58. Bc1e3
Kg7g6 59. Ne2g3 Qa7a6 60. Rd1d2 Qa6a7 61. Ng3h1 Kg6g7 62. Nh1f2 Qa7a6 63.
Nf2d1 Ne7g6 64. Kh3g3 Rh8a8 65. Nd1b2 Rh7h8 66. Bf3d1 Qa6b7 67. Qc2c1 Ra8a6
68. Nb2a4 Rh8a8 69. Na4b6 Qb7b6 70. Rd2a2 Ra6a4 71. Qc1b2 Ra8a6 72. Bd1h5
Qb6a7 73. Be3c1 Ng6e7 74. Bh5d1 Ne7c8 75. Bd1a4 Ra6a4 76. Kg3h2 Nc8b6 77.
h4h5 Nb6c4 78. Qb2g2 Qa7e7 79. g5g6 Kg7h8 80. g6g7+ Kh8g8 81. h5h6 Ra4a8
82. h6h7+ 1-0

Granda Zuniga, Julio E - Van Wely, Loek Spanish Championship Division Honor ? 2015.08.21 

 */
public class Main {
	private static Piece[] piece = new Piece[32];
	private String[] startingPositions = {"a2","b2","c2","d2","e2","f2","g2","h2",
										"a1","b1","c1","d1","e1","f1","g1","h1",
										"a7","b7","c7","d7","e7","f7","g7","h7",
										"a8","b8","c8","d8","e8","f8","g8","h8"};
	Main(){
		for(int i=0;i<32;i++){
			piece[i] = new Piece(true,startingPositions[i]);
		}
	}
	
	public void runGame(String arg[]){
		//String tempBlackRook,tempBlackKnight,tempBlackBishop,tempWhiteRook,tempWhiteKnight,tempWhiteBishop;
		for(int j=0;j<arg.length;j++){
			if(arg[j].length()==0)
				continue;
			String curMove = arg[j].trim();
			System.out.println(curMove);
			String whiteMove = curMove.substring(0, curMove.indexOf(" "));
			String blackMove = curMove.substring(curMove.indexOf(" ")).trim();
			System.out.println("processing white move " + whiteMove);
			for(int i=0;i<16;i++){
				if(piece[i].getPosition().equalsIgnoreCase(whiteMove)){
					
				}
			}
			System.out.println("processing black move " + blackMove);
			for(int i=16;i<32;i++){
				if(piece[i].getPosition().equalsIgnoreCase(blackMove)){
					
				}
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Main main = new Main();
		String input = "1. c2c4 c7c6 2. b2b3 d7d5 3. Bc1b2 Bc8f5 4. Ng1f3 e7e6 5. d2d3 h7h6 6. Nb1d2 Ng8f6 7. g2g3 Bf8c5 8. Bf1g2 e8g8 9. e1g1 Nb8d7 10. Qd1e1 Bf5h7 11. e2e4 a7a5 12. e4e5 Nf6e8 13. d3d4 Bc5b4 14. Qe1e3 Ne8c7 15. a2a3 Bb4e7 16. c4c5 b7b6 17. b3b4 Qd8b8 18. Bb2c3 Nc7b5 19. Rf1c1 Qb8b7 20. Bg2f1 Nd7b8 21. Nd2b3 a5a4 22. Nb3d2 Nb8a6 23. c5b6 Qb7b6 24. Bc3b2 Na6b8 25. h2h4 Nb8d7 26. g3g4 Ra8e8 27. g4g5 h6h5 28. Bf1e2 Bh7f5 29. Nf3e1 g7g6 30. Nd2f1 Qb6b7 31. Nf1g3 Kg8g7 32. Ne1g2 Rf8h8 33. Qe3f4 Be7d8 34. Ng2e3 Bd8b6 35. Ng3f5+ g6f5 36. Ne3g2 Nd7f8 37. Rc1d1 Nf8g6 38. Qf4e3 Re8c8 39. Rd1d3 Kg7f8 40. Ra1d1 Kf8e7 41. Be2f3 Rh8h7 42. Qe3e2 Rc8h8 43. Qe2c2 Rh8a8 44. Kg1h2 Ke7d7 45. Kh2h3 Qb7a7 46. Bf3e2 Ra8c8 47. f2f4 Kd7e7 48. Qc2d2 Ke7f8 49. Ng2e1 Kf8g7 50. Ne1f3 Ng6e7 51. Nf3h2 Kg7g6 52. Nh2f1 Rc8h8 53. Nf1g3 Qa7a8 54. Be2f3 Qa8a7 55. Ng3e2 Kg6g7 56. Qd2c2 Qa7a6 57. Bb2c1 Qa6a7 58. Bc1e3 Kg7g6 59. Ne2g3 Qa7a6 60. Rd1d2 Qa6a7 61. Ng3h1 Kg6g7 62. Nh1f2 Qa7a6 63. Nf2d1 Ne7g6 64. Kh3g3 Rh8a8 65. Nd1b2 Rh7h8 66. Bf3d1 Qa6b7 67. Qc2c1 Ra8a6 68. Nb2a4 Rh8a8 69. Na4b6 Qb7b6 70. Rd2a2 Ra6a4 71. Qc1b2 Ra8a6 72. Bd1h5 Qb6a7 73. Be3c1 Ng6e7 74. Bh5d1 Ne7c8 75. Bd1a4 Ra6a4 76. Kg3h2 Nc8b6 77. h4h5 Nb6c4 78. Qb2g2 Qa7e7 79. g5g6 Kg7h8 80. g6g7+ Kh8g8 81. h5h6 Ra4a8 82. h6h7+ 1-0";
		String arg[] = input.split("[0-9]+[.][ ]");
		main.runGame(arg);
	}

}
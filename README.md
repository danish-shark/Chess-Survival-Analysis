# Chess-Survival-Analysis
To analyse the survival probability of chess pieces given a database of pgn files
Both players are GMs or Elo 2500+; games played anytime (also before players won the title)

PGN file taken from : http://chess-db.com/public/downloads/download.jsp?c=1

We need to convert the pgn from standard algebraic notation (SAN) to long algebraic notation (LAN) which is easier to work with. We also need to get rid of any extra annotations etc. We use pgn-extract for this.

Installing pgn-extract

apt-get install pgn-extract

Pre Processing file

pgn-extract --output <output filename> -Wlalg  -C -N -V --notags <input file>


The results obtained are as follows - 

Starting Square  Survival Rate

White King(e1)       100.00%

Black King(e8)       100.00%

White Pawn(h2)       75.26%

Black Pawn(h7)       72.69%

White Pawn(g2)       71.13%

Black Pawn(g7)       68.17%

White Pawn(a2)       65.02%

White Pawn(f2)       64.07%

Black Pawn(a7)       63.54%

Black Pawn(f7)       62.29%

White Pawn(b2)       59.08%

White Rook(h1)       57.82%

White Rook(a1)       56.20%

Black Rook(h8)       56.10%

Black Rook(a8)       55.69%

Black Pawn(b7)       54.28%

White Queen(d1)      49.65%

Black Queen(d8)      48.43%

Black Pawn(e7)       42.73%

White Pawn(e2)       39.57%

White Bishop(f1)     39.39%

White Pawn(c2)       37.45%

Black Bishop(f8)     37.05%

Black Bishop(c8)     35.16%

White Bishop(c1)     34.94%

Black Pawn(c7)       31.50%

Black Knight(b8)     31.38%

White Knight(g1)     30.32%

Black Pawn(d7)       29.16%

White Knight(b1)     29.15%

Black Knight(g8)     28.68%

White Pawn(d2)       23.02%


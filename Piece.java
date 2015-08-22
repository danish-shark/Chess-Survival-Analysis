public class Piece{
	private boolean alive;
	private String position;
	
	public Piece(boolean alive, String position) {
		this.alive = alive;
		this.position = position;
	}
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
}
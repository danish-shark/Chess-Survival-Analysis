
public class Piece implements Comparable<Piece>{
	String pos;
	Double chance;
	
	public Piece(String pos, double chance) {
		super();
		this.pos = pos;
		this.chance = chance;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public Double getChance() {
		return chance;
	}
	public void setChance(double chance) {
		this.chance = chance;
	}
	@Override
	public int compareTo(Piece arg0) {
		return -1*this.getChance().compareTo(arg0.getChance());
	}
}

package Day14;
public class Reindeer {
	private String name;
	private int rate;
	private int time;
	private int cooldown;
	private int points;
	
	public Reindeer(String name, int rate, int time, int cooldown) {
		this.name = name;
		this.rate = rate;
		this.time = time;
		this.cooldown = cooldown;
		this.points = 0;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getRate() {
		return this.rate;
	}
	
	public int getTime() {
		return this.time;
	}
	
	public int getCooldown() {
		return this.cooldown;
	}
	
	public void addPoint() {
	  this.points++;
	}
	
	public int getPoints() {
	  return this.points;
	}
}
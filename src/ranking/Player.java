package ranking;

public class Player implements Comparable<Player> {
	private int time;
	private String name;

	public Player(int time, String name) {
		super();
		this.time = time;
		this.name = name;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Player o) {

		return this.time - o.time;

	}

	@Override
	public String toString() {

		return time + "√Î\t" + name;
	}

}

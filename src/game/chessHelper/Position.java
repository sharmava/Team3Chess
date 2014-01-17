package game.chessHelper;

public class Position implements Comparable {

	private int xCoord;
	private int yCoord;

	private Position(int xCoord, int yCoord) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}

	public static Position createPosition(int xCoord, int yCoord) {
		if ((xCoord >= 1) && (xCoord <= 8) && (yCoord >= 1) && (yCoord <= 8)) {
			return new Position(xCoord, yCoord);
		}
		return null;
	}

	public int getXCoord() {
		return this.xCoord;
	}

	public int getYCoord() {
		return this.yCoord;
	}

	public boolean equals(Object o) {
		if (!(o instanceof Position)) {
			return false;
		}
		Position p = (Position) o;
		return (p.getXCoord() == getXCoord()) && (p.getYCoord() == getYCoord());
	}

	public int hashCode() {
		return this.xCoord * this.yCoord;
	}

	public String toString() {
		return "Position (" + this.xCoord + ", " + this.yCoord + ")";
	}

	public int compareTo(Object object) {
		Position otherPosition = (Position) object;
		if (getXCoord() == otherPosition.getXCoord()) {
			return getYCoord() - otherPosition.getYCoord();
		}
		return getXCoord() - otherPosition.getXCoord();
	}
}

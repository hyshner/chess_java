package boardGame;

public class Position {
	
	private int raw;
	private int column;
	
	public Position() {
	}

	public Position(int raw, int column) {
		this.raw = raw;
		this.column = column;
	}

	public int getRaw() {
		return raw;
	}

	public void setRaw(int raw) {
		this.raw = raw;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
	
	public void setPosition() {
		
	}
	@Override
	public String toString () {
		return raw + ", " + column; 
	}
	

}

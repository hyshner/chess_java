package boardGame;

public class Board {
	
	private int raws;
	private int columns;
	
	public Board() {
	}

	public Board(int raws, int columns) {
		this.raws = raws;
		this.columns = columns;
	}

	public int getRaws() {
		return raws;
	}

	public void setRaws(int raws) {
		this.raws = raws;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	

}

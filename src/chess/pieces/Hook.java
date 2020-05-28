package chess.pieces;

import boardGame.Board;
import chess.ChessPiece;
import chess.Color;

public class Hook extends ChessPiece {

	public Hook(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "H";
	}
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		return mat;
	}

}

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

}

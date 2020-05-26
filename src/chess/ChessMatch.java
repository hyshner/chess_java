package chess;

import boardGame.Board;
import boardGame.Piece;
import chess.pieces.Hook;
import chess.pieces.King;

public class ChessMatch {
	
	private Board board;

	public ChessMatch() {
		board = new Board(8,8);
		initialSetup();
	}
	
	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		
		for(int i=0; i< board.getRows(); i++ ) {
			for(int j=0; j< board.getColumns(); j++) {
				mat [i][j]= (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}
	
	public void placeNewPiece(char column, int row, Piece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());; 
	}
	
	public void initialSetup() {
		placeNewPiece( 'a',8 , new Hook(board, Color.WHITE) );
		placeNewPiece( 'h',8 , new Hook(board, Color.WHITE) );
		placeNewPiece( 'e',8 , new King(board, Color.WHITE) );
		
		
		placeNewPiece( 'a',1 , new Hook(board, Color.BLACK) );
		placeNewPiece( 'h',1 , new Hook(board, Color.BLACK) );
		placeNewPiece( 'd',1 , new King(board, Color.BLACK) );
	}
}

package chess;

import java.util.ArrayList;
import java.util.List;

import boardGame.Board;
import boardGame.Piece;
import boardGame.Position;
import chess.pieces.Hook;
import chess.pieces.King;

public class ChessMatch {
	
	private Board board;
	private Color currentPlayer;
	private int turn;
	
	private List<Piece> piecesOnTheBoard = new ArrayList<>();
	private List<Piece> capturedPieces = new ArrayList<>();
	
	

	public Color getCurrentPlayer() {
		return currentPlayer;
	}


	public int getTurn() {
		return turn;
	}


	public ChessMatch() {
		board = new Board(8,8);
		turn = 1;
		currentPlayer = Color.WHITE;
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
	
	public boolean[][] possibleMoves(ChessPosition sourcePosition){
		Position position = sourcePosition.toPosition();
		validateSourcePosition(position);
		return board.piece(position).possibleMoves();
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePos, ChessPosition targetPos) {
		Position source = sourcePos.toPosition();
		Position target = targetPos.toPosition();
		validateSourcePosition(source);
		validateTargetPosition(source, target);
		Piece capturedPiece = makeMove(source, target);
		nextTurn();
		return (ChessPiece) (capturedPiece);
	}
	
	public Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		if (capturedPiece != null) {
			piecesOnTheBoard.remove(capturedPiece);
			capturedPieces.add(capturedPiece);
		}
		return capturedPiece;
	}
	
	public void validateSourcePosition(Position position) {
		if(!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece in this place");
		}
		
		if(currentPlayer != ((ChessPiece)board.piece(position)).getColor()){
			throw new ChessException("There piece does not belongs to you");
		}
		
		if(!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves to this piece");
		}
	}
	
	public void validateTargetPosition(Position source, Position target) {
		if(!board.piece(source).possibleMove(target)) {
			throw new ChessException("The chosen piece can not move to the destination");
		}
	}
	
	private void nextTurn() {
		if (Color.BLACK == currentPlayer) turn++;
		
		
		currentPlayer = (currentPlayer == Color.WHITE)? Color.BLACK : Color.WHITE;
	}
	
	public void placeNewPiece(char column, int row, Piece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
		piecesOnTheBoard.add(piece);
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

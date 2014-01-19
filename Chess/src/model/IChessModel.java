package model;

import java.util.List;

public interface IChessModel {

	ChessModel.Player getActivePlayer();

	ChessPiece getPiece(int i, int j);

	void movePiece(int i, int j, ChessPiece piece) throws GameException;

	List<ChessPiece> getAllPieces();

	boolean isCheck(ChessPiece piece, ChessPiece movedPiece);
	
	boolean validMove(int column, int row, ChessPiece selectedPiece);

}

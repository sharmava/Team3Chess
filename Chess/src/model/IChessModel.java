package model;

import java.util.List;

import model.ChessModel.Player;

public interface IChessModel {

	ChessModel.Player getActivePlayer();
	
	 void setActivePlayer(Player activePlayer);
	 
	 void togglePlayer();

	ChessPiece getPiece(int i, int j);

	void movePiece(int i, int j, ChessPiece piece) throws GameException;

	List<ChessPiece> getAllPieces();

	boolean isCheck(ChessPiece piece, ChessPiece movedPiece);
	
	boolean validMove(int column, int row, ChessPiece selectedPiece);

	boolean validateCoordinates(int i, int j);

}

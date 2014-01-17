package model;

import model.ChessModel.PieceType;
import model.ChessModel.Player;

public class Bishop extends ChessPiece {

	public Bishop(int column, int row, Player owner) {
		super(column, row, owner);
		type = PieceType.BISHOP;
	}

}

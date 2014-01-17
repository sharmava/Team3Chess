package model;

import model.ChessModel.PieceType;
import model.ChessModel.Player;

public class King extends ChessPiece {

	public King(int column, int row, Player owner) {
		super(column, row, owner);
		type = PieceType.KING;
	}

}

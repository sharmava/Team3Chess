package model;

import model.ChessModel.PieceType;
import model.ChessModel.Player;

public class Knight extends ChessPiece {

	public Knight(int column, int row, Player owner) {
		super(column, row, owner);
		type = PieceType.KNIGHT;
	}

}

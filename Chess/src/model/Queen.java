package model;

import model.ChessModel.PieceType;
import model.ChessModel.Player;

public class Queen extends ChessPiece {

	public Queen(int column, int row, Player owner) {
		super(column, row, owner);
		type = PieceType.QUEEN;
	}

}

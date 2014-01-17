package model;

import model.ChessModel.PieceType;
import model.ChessModel.Player;

public class Rook extends ChessPiece {

	public Rook(int column, int row, Player owner) {
		super(column, row, owner);
		type = PieceType.ROOK;
	}

}

package model;

import java.util.ArrayList;
import java.util.List;

import model.ChessModel.PieceType;
import model.ChessModel.Player;

public class Knight extends ChessPiece {

	private int[] topLongLeft;
	private int[] topShortleft;
	private int[] topLongRight;
	private int[] topShortRight;
	private int[] downLongLeft;
	private int[] downShortLeft;
	private int[] downLongRight;
	private int[] downShortRight;

	public Knight(int column, int row, Player owner) {
		super(column, row, owner);
		type = PieceType.KNIGHT;

		topLongLeft = new int[] { -1, 2 };
		topShortleft = new int[] { -2, 1 };
		topLongRight = new int[] { 1, 2 };
		topShortRight = new int[] { 2, 1 };
		downLongLeft = new int[] { -1, -2 };
		downShortLeft = new int[] { -2, -1 };
		downLongRight = new int[] { 1, -2 };
		downShortRight = new int[] { 2, -1 };
	}

	@Override
	public List<int[]> getMoves(IChessModel model) {
		List<int[]> moves = new ArrayList<int[]>();
		int[] pos;

		// if in starting position
		pos = moveDesination(topLongLeft);
		if (model.validateCoordinates(pos[0], pos[1])
				&& ((model.getPiece(pos[0], pos[1]) == null) || (model
						.getPiece(pos[0], pos[1]) != null && model.getPiece(
						pos[0], pos[1]).owner() != owner())))
			moves.add(pos);

		pos = moveDesination(topShortleft);
		if (model.validateCoordinates(pos[0], pos[1])
				&& ((model.getPiece(pos[0], pos[1]) == null) || (model
						.getPiece(pos[0], pos[1]) != null && model.getPiece(
						pos[0], pos[1]).owner() != owner())))
			moves.add(pos);

		pos = moveDesination(topLongRight);
		if (model.validateCoordinates(pos[0], pos[1])
				&& ((model.getPiece(pos[0], pos[1]) == null) || (model
						.getPiece(pos[0], pos[1]) != null && model.getPiece(
						pos[0], pos[1]).owner() != owner())))
			moves.add(pos);

		pos = moveDesination(topShortRight);
		if (model.validateCoordinates(pos[0], pos[1])
				&& ((model.getPiece(pos[0], pos[1]) == null) || (model
						.getPiece(pos[0], pos[1]) != null && model.getPiece(
						pos[0], pos[1]).owner() != owner())))
			moves.add(pos);

		pos = moveDesination(downLongLeft);
		if (model.validateCoordinates(pos[0], pos[1])
				&& ((model.getPiece(pos[0], pos[1]) == null) || (model
						.getPiece(pos[0], pos[1]) != null && model.getPiece(
						pos[0], pos[1]).owner() != owner())))
			moves.add(pos);

		pos = moveDesination(downShortLeft);
		if (model.validateCoordinates(pos[0], pos[1])
				&& ((model.getPiece(pos[0], pos[1]) == null) || (model
						.getPiece(pos[0], pos[1]) != null && model.getPiece(
						pos[0], pos[1]).owner() != owner())))
			moves.add(pos);

		pos = moveDesination(downLongRight);
		if (model.validateCoordinates(pos[0], pos[1])
				&& ((model.getPiece(pos[0], pos[1]) == null) || (model
						.getPiece(pos[0], pos[1]) != null && model.getPiece(
						pos[0], pos[1]).owner() != owner())))
			moves.add(pos);

		pos = moveDesination(downShortRight);
		if (model.validateCoordinates(pos[0], pos[1])
				&& ((model.getPiece(pos[0], pos[1]) == null) || (model
						.getPiece(pos[0], pos[1]) != null && model.getPiece(
						pos[0], pos[1]).owner() != owner())))
			moves.add(pos);

		return moves;
	}

	private int[] moveDesination(int[] move) {
		if (owner() == Player.WHITE)
			return new int[] { column + move[0], row + move[1] };
		else
			return new int[] { column - move[0], row - move[1] };
	}

}

package model;

import java.util.ArrayList;
import java.util.List;

import model.ChessModel.PieceType;
import model.ChessModel.Player;

public class King extends ChessPiece {

	private int[] moveFront;
	private int[] moveBack;
	private int[] moveLeft;
	private int[] moveRight;
	private int[] moveLeftTopDiagonal;
	private int[] moveRightTopDiagonal;
	private int[] moveLeftBottomDiagonal;
	private int[] moveRightBottomDiagonal;

	public King(int column, int row, Player owner) {
		super(column, row, owner);
		type = PieceType.KING;

		moveFront = new int[] { 0, 1 };
		moveBack = new int[] { 0, -1 };
		moveLeft = new int[] { -1, 0 };
		moveRight = new int[] { 1, 0 };
		moveLeftTopDiagonal = new int[] { -1, 1 };
		moveRightTopDiagonal = new int[] { 1, 1 };
		moveLeftBottomDiagonal = new int[] { -1, -1 };
		moveRightBottomDiagonal = new int[] { 1, -1 };
	}

	@Override
	public List<int[]> getMoves(IChessModel model) {
		List<int[]> moves = new ArrayList<int[]>();
		int[] pos;

		pos = moveDesination(moveFront);
		if (model.validateCoordinates(pos[0], pos[1])
				&& ((model.getPiece(pos[0], pos[1]) == null) || (model
						.getPiece(pos[0], pos[1]) != null && model.getPiece(
						pos[0], pos[1]).owner() != owner())))
			moves.add(pos);

		pos = moveDesination(moveBack);
		if (model.validateCoordinates(pos[0], pos[1])
				&& ((model.getPiece(pos[0], pos[1]) == null) || (model
						.getPiece(pos[0], pos[1]) != null && model.getPiece(
						pos[0], pos[1]).owner() != owner())))
			moves.add(pos);

		pos = moveDesination(moveLeft);
		if (model.validateCoordinates(pos[0], pos[1])
				&& ((model.getPiece(pos[0], pos[1]) == null) || (model
						.getPiece(pos[0], pos[1]) != null && model.getPiece(
						pos[0], pos[1]).owner() != owner())))
			moves.add(pos);

		pos = moveDesination(moveRight);
		if (model.validateCoordinates(pos[0], pos[1])
				&& ((model.getPiece(pos[0], pos[1]) == null) || (model
						.getPiece(pos[0], pos[1]) != null && model.getPiece(
						pos[0], pos[1]).owner() != owner())))
			moves.add(pos);

		pos = moveDesination(moveLeftTopDiagonal);
		if (model.validateCoordinates(pos[0], pos[1])
				&& ((model.getPiece(pos[0], pos[1]) == null) || (model
						.getPiece(pos[0], pos[1]) != null && model.getPiece(
						pos[0], pos[1]).owner() != owner())))
			moves.add(pos);

		pos = moveDesination(moveLeftBottomDiagonal);
		if (model.validateCoordinates(pos[0], pos[1])
				&& ((model.getPiece(pos[0], pos[1]) == null) || (model
						.getPiece(pos[0], pos[1]) != null && model.getPiece(
						pos[0], pos[1]).owner() != owner())))
			moves.add(pos);

		pos = moveDesination(moveRightTopDiagonal);
		if (model.validateCoordinates(pos[0], pos[1])
				&& ((model.getPiece(pos[0], pos[1]) == null) || (model
						.getPiece(pos[0], pos[1]) != null && model.getPiece(
						pos[0], pos[1]).owner() != owner())))
			moves.add(pos);

		pos = moveDesination(moveRightBottomDiagonal);
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

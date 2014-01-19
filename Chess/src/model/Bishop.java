package model;

import java.util.ArrayList;
import java.util.List;

import model.ChessModel.PieceType;
import model.ChessModel.Player;

public class Bishop extends ChessPiece {

	private int[] leftTopDiagonal;
	private int[] rightTopDiagonal;
	private int[] leftDownDiagonal;
	private int[] rightDownDiagonal;

	public Bishop(int column, int row, Player owner) {
		super(column, row, owner);
		type = PieceType.BISHOP;

		leftTopDiagonal = new int[2];
		rightTopDiagonal = new int[2];
		leftDownDiagonal = new int[2];
		rightDownDiagonal = new int[2];

	}

	public List<int[]> getMoves(ChessModel model) {
		List<int[]> moves = new ArrayList<int[]>();
		int[] pos;

		for (int i = 1; i <= 7; i++) {
			leftTopDiagonal[0] = -i;
			leftTopDiagonal[1] = i;

			rightTopDiagonal[0] = i;
			rightTopDiagonal[1] = i;

			leftDownDiagonal[0] = -i;
			leftDownDiagonal[1] = -i;

			rightDownDiagonal[0] = i;
			rightDownDiagonal[1] = -i;

			pos = moveDesination(leftTopDiagonal);
			if (model.validateCoordinates(pos[0], pos[1])
					&& ((model.getPiece(pos[0], pos[1]) == null) || (model
							.getPiece(pos[0], pos[1]) != null && model
							.getPiece(pos[0], pos[1]).owner() != owner())))
				moves.add(pos);

			pos = moveDesination(rightTopDiagonal);
			if (model.validateCoordinates(pos[0], pos[1])
					&& ((model.getPiece(pos[0], pos[1]) == null) || (model
							.getPiece(pos[0], pos[1]) != null && model
							.getPiece(pos[0], pos[1]).owner() != owner())))
				moves.add(pos);

			pos = moveDesination(leftDownDiagonal);
			if (model.validateCoordinates(pos[0], pos[1])
					&& ((model.getPiece(pos[0], pos[1]) == null) || (model
							.getPiece(pos[0], pos[1]) != null && model
							.getPiece(pos[0], pos[1]).owner() != owner())))
				moves.add(pos);

			pos = moveDesination(rightDownDiagonal);
			if (model.validateCoordinates(pos[0], pos[1])
					&& ((model.getPiece(pos[0], pos[1]) == null) || (model
							.getPiece(pos[0], pos[1]) != null && model
							.getPiece(pos[0], pos[1]).owner() != owner())))
				moves.add(pos);

		}

		return moves;
	}

	private int[] moveDesination(int[] move) {
		if (owner() == Player.WHITE)
			return new int[] { column + move[0], row + move[1] };
		else
			return new int[] { column - move[0], row - move[1] };
	}

}

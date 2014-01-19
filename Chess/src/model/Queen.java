package model;

import java.util.ArrayList;
import java.util.List;

import model.ChessModel.PieceType;
import model.ChessModel.Player;

public class Queen extends ChessPiece {

	private int[] moveTop;
	private int[] moveDown;
	private int[] moveLeft;
	private int[] moveRight;
	private int[] leftTopDiagonal;
	private int[] rightTopDiagonal;
	private int[] leftDownDiagonal;
	private int[] rightDownDiagonal;

	public Queen(int column, int row, Player owner) {
		super(column, row, owner);
		type = PieceType.QUEEN;
		moveTop = new int[2];
		moveDown = new int[2];
		moveLeft = new int[2];
		moveRight = new int[2];
		leftTopDiagonal = new int[2];
		rightTopDiagonal = new int[2];
		leftDownDiagonal = new int[2];
		rightDownDiagonal = new int[2];
	}

	public List<int[]> getMoves(ChessModel model) {
		List<int[]> moves = new ArrayList<int[]>();
		int[] pos;

		boolean leftTopFlag = true;
		boolean rightTopFlag = true;
		boolean leftDownFlag = true;
		boolean rightDownFlag = true;

		boolean moveTopFlag = true;
		boolean moveDownFlag = true;
		boolean moveLeftFlag = true;
		boolean moveRightFlag = true;

		for (int i = 1; i <= 7; i++) {
			moveTop[0] = 0;
			moveTop[1] = i;

			moveDown[0] = 0;
			moveDown[1] = -i;

			moveLeft[0] = -i;
			moveLeft[1] = 0;

			moveRight[0] = i;
			moveRight[1] = 0;

			leftTopDiagonal[0] = -i;
			leftTopDiagonal[1] = i;

			rightTopDiagonal[0] = i;
			rightTopDiagonal[1] = i;

			leftDownDiagonal[0] = -i;
			leftDownDiagonal[1] = -i;

			rightDownDiagonal[0] = i;
			rightDownDiagonal[1] = -i;

			if (moveLeftFlag) {

				pos = moveDesination(moveLeft);

				if (model.validateCoordinates(pos[0], pos[1])
						&& model.getPiece(pos[0], pos[1]) != null)
					moveLeftFlag = false;

				if (model.validateCoordinates(pos[0], pos[1])
						&& ((model.getPiece(pos[0], pos[1]) == null) || (model
								.getPiece(pos[0], pos[1]) != null && model
								.getPiece(pos[0], pos[1]).owner() != owner())))
					moves.add(pos);
			}

			if (moveRightFlag) {

				pos = moveDesination(moveRight);

				if (model.validateCoordinates(pos[0], pos[1])
						&& model.getPiece(pos[0], pos[1]) != null)
					moveRightFlag = false;

				if (model.validateCoordinates(pos[0], pos[1])
						&& ((model.getPiece(pos[0], pos[1]) == null) || (model
								.getPiece(pos[0], pos[1]) != null && model
								.getPiece(pos[0], pos[1]).owner() != owner())))
					moves.add(pos);
			}

			if (moveTopFlag) {

				pos = moveDesination(moveTop);

				if (model.validateCoordinates(pos[0], pos[1])
						&& model.getPiece(pos[0], pos[1]) != null)
					moveTopFlag = false;
				if (model.validateCoordinates(pos[0], pos[1])
						&& ((model.getPiece(pos[0], pos[1]) == null) || (model
								.getPiece(pos[0], pos[1]) != null && model
								.getPiece(pos[0], pos[1]).owner() != owner())))
					moves.add(pos);
			}

			if (moveDownFlag) {

				pos = moveDesination(moveDown);

				if (model.validateCoordinates(pos[0], pos[1])
						&& model.getPiece(pos[0], pos[1]) != null)
					moveDownFlag = false;

				if (model.validateCoordinates(pos[0], pos[1])
						&& ((model.getPiece(pos[0], pos[1]) == null) || (model
								.getPiece(pos[0], pos[1]) != null && model
								.getPiece(pos[0], pos[1]).owner() != owner())))
					moves.add(pos);
			}

			if (leftTopFlag) {

				pos = moveDesination(leftTopDiagonal);
				if (model.validateCoordinates(pos[0], pos[1])
						&& model.getPiece(pos[0], pos[1]) != null)
					leftTopFlag = false;
				if (model.validateCoordinates(pos[0], pos[1])
						&& ((model.getPiece(pos[0], pos[1]) == null) || (model
								.getPiece(pos[0], pos[1]) != null && model
								.getPiece(pos[0], pos[1]).owner() != owner())))
					moves.add(pos);

			}

			if (rightTopFlag) {
				pos = moveDesination(rightTopDiagonal);
				if (model.validateCoordinates(pos[0], pos[1])
						&& model.getPiece(pos[0], pos[1]) != null)
					rightTopFlag = false;
				if (model.validateCoordinates(pos[0], pos[1])
						&& ((model.getPiece(pos[0], pos[1]) == null) || (model
								.getPiece(pos[0], pos[1]) != null && model
								.getPiece(pos[0], pos[1]).owner() != owner())))
					moves.add(pos);

			}

			if (leftDownFlag) {

				pos = moveDesination(leftDownDiagonal);
				if (model.validateCoordinates(pos[0], pos[1])
						&& model.getPiece(pos[0], pos[1]) != null)
					leftDownFlag = false;
				if (model.validateCoordinates(pos[0], pos[1])
						&& ((model.getPiece(pos[0], pos[1]) == null) || (model
								.getPiece(pos[0], pos[1]) != null && model
								.getPiece(pos[0], pos[1]).owner() != owner())))
					moves.add(pos);
			}

			if (rightDownFlag) {

				pos = moveDesination(rightDownDiagonal);
				if (model.validateCoordinates(pos[0], pos[1])
						&& model.getPiece(pos[0], pos[1]) != null)
					rightDownFlag = false;
				if (model.validateCoordinates(pos[0], pos[1])
						&& ((model.getPiece(pos[0], pos[1]) == null) || (model
								.getPiece(pos[0], pos[1]) != null && model
								.getPiece(pos[0], pos[1]).owner() != owner())))
					moves.add(pos);
			}

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

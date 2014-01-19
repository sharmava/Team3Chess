package model;

import java.util.List;

import model.ChessModel.PieceType;
import model.ChessModel.Player;

public abstract class ChessPiece {

	private Player owner;
	protected int column;
	protected int row;
	protected PieceType type;
	

	protected int startRow;
	protected int startColumn;

	public ChessPiece(int column, int row, Player owner) {
		this.column = column;
		this.row = row;
		this.owner = owner;
		startColumn = column;
		startRow = row;
	}

	public List<int[]> getMoves(ChessModel model) {
		return null;
	}

	public int row() {
		return row;
	}

	public int column() {
		return column;
	}

	public void setRow(int row2) {
		row = row2;
	}

	public void setColumn(int column2) {
		column = column2;
	}

	public Player owner() {
		return owner;
	}

	public PieceType type() {
		return type;
	}
	
	
}

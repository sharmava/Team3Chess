package model;

import java.util.List;
import java.util.Stack;

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

	public List<int[]> getMoves(IChessModel model) {
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
	
	private Boolean isDead = false;
	/**
	 * @return the isDead
	 */
	public Boolean getIsDead() {
		return isDead;
	}

	/**
	 * @param isDead the isDead to set
	 */
	public void setIsDead(Boolean isDead) {
		this.isDead = isDead;
	}

	
	private Stack<int []> moves;
	private Stack<int []> redoMoves;
	
	public void storeMove(int row, int column){
		
		if(this.moves == null)
		{
			this.moves = new Stack<int []>();
		}
		
		moves.push(new int[]{row,column});
		
	}
	

	public void saveRedoMove(int row, int column){
		
		if(this.redoMoves == null)
		{
			this.redoMoves = new Stack<int []>();
		}
		
		redoMoves.push(new int[]{row,column});
		
	}
	
	public int[] getPreviousMove(){
		
		if(this.moves == null)
		{//when no move is made
			return null;
		}
		else if(this.moves.isEmpty())
		{//when stack has collapsed
			return null;
		}
		else
		{
			int[] prevMove = this.moves.pop();
			return prevMove;
		}
	}
	
	
    public int[] getRedoMove(){
		
		if(this.redoMoves == null)
		{//when no move is made
			return null;
		}
		else if(this.redoMoves.isEmpty())
		{//when stack has collapsed
			return null;
		}
		else
		{
			int[] redoMove = this.redoMoves.pop();
			return redoMove;
		}
	}
	
	
	
}

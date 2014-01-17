package model;

import java.util.ArrayList;
import java.util.List;

import model.ChessModel.PieceType;
import model.ChessModel.Player;

public class Pawn extends ChessPiece 
{
	private int[] basicMove;
	private int[] startMove;
	private int[] attackMoveLeft;
	private int[] attackMoveRight;
	
	public Pawn(int column, int row, Player owner) {
		super(column, row, owner);
		type = PieceType.PAWN;
		
		basicMove = new int[]{0,1};
		startMove = new int[]{0,2};
		attackMoveLeft = new int[]{-1,1};
		attackMoveRight = new int[]{1,1};
	}
	
	@Override
	public List<int[]> getMoves(ChessModel model) 
	{
		List<int[]> moves = new ArrayList<int[]>();
		int[] pos;
		
		//if in starting position
		if(row == startRow && column == startColumn)
		{
			pos = moveDesination(startMove);
			if(model.validateCoordinates(pos[0],pos[1]) && model.getPiece(pos[0], pos[1]) == null)
				moves.add(pos);
		}
		
		pos = moveDesination(basicMove);
		if(model.validateCoordinates(pos[0],pos[1]) && model.getPiece(pos[0], pos[1]) == null)
			moves.add(pos);
		
		pos = moveDesination(attackMoveLeft); 
		if(model.validateCoordinates(pos[0],pos[1]) && model.getPiece(pos[0], pos[1]) != null && model.getPiece(pos[0], pos[1]).owner() != owner())
			moves.add(pos);
		
		pos = moveDesination(attackMoveRight); 
		if(model.validateCoordinates(pos[0],pos[1]) && model.getPiece(pos[0], pos[1]) != null && model.getPiece(pos[0], pos[1]).owner() != owner())
			moves.add(pos);
		
		return moves;
	}
	
	private int[] moveDesination(int[] move)
	{
		if(owner() == Player.WHITE)
			return new int[]{column+move[0],row+move[1]};
		else
			return new int[]{column-move[0],row-move[1]};
	}

}

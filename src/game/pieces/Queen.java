package game.pieces;

import game.chessHelper.Position;

public class Queen extends Pieces{

	public Queen(Pieces.Color color, Position position){
		  this.name = (color.getName() + "Queen");
		}
	
}

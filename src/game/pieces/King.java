package game.pieces;

import game.chessHelper.Position;

public class King extends Pieces{

	public King(Pieces.Color color, Position position){
		  this.name = (color.getName() + "King");
		}
	
}

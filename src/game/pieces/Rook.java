package game.pieces;

import game.chessHelper.Position;

public class Rook extends Pieces{
	
public Rook(Pieces.Color color, Position position){
  this.name = (color.getName() + "Rook");
}

}

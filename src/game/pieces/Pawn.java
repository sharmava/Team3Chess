package game.pieces;

import game.chessHelper.Position;

public class Pawn extends Pieces{
public Pawn(Pieces.Color colour, Position position){
		 //super(color, position);
		 this.name = (colour.getName() + "Pawn");
		 }
}
package game.pieces;

import game.chessHelper.Position;

public class Pieces {
	String name;
	Color color;
	Position position;

	public static enum Color {
		WHITE("White"), BLACK("Black");
		private String name;

		private Color(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}
	}
	
	public  static final Pieces createChessPiece(String name, Color color, Position position)
	  {
	    if (name.equals("Pawn")) {
	      return new Pawn(color, position);
	    }
	    if (name.equals("Rook")) {
	      return new Rook(color, position);
	    }
	    if (name.equals("Knight")) {
	      return new Knight(color, position);
	    }
	    if (name.equals("Bishop")) {
	      return new Bishop(color, position);
	    }
	    if (name.equals("Queen")) {
	      return new Queen(color, position);
	    }
	    if (name.equals("King")) {
	      return new King(color, position);
	    }
	
	    return null;
	  }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
}

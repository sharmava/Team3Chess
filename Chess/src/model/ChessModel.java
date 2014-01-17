package model;

import java.util.ArrayList;
import java.util.List;

public class ChessModel implements IChessModel {

	public enum Player {WHITE, BLACK}
	public enum PieceType {BISHOP,KING,KNIGHT,PAWN,QUEEN,ROOK};
	
	private Player activePlayer;
	private static final int WIDTH = 8;
	private static final int HEIGHT = 8;
	
	private ChessPiece[] board;
	
	public ChessModel()
	{
		activePlayer = Player.WHITE;
		board = new ChessPiece[WIDTH*HEIGHT];
		
		addPiece(new Rook(0,0,Player.WHITE));
		addPiece(new Knight(1,0,Player.WHITE));
		addPiece(new Bishop(2,0,Player.WHITE));
		addPiece(new Queen(3,0,Player.WHITE));
		addPiece(new King(4,0,Player.WHITE));
		addPiece(new Bishop(5,0,Player.WHITE));
		addPiece(new Knight(6,0,Player.WHITE));
		addPiece(new Rook(7,0,Player.WHITE));
		addPiece(new Pawn(0,1,Player.WHITE));
		addPiece(new Pawn(1,1,Player.WHITE));
		addPiece(new Pawn(2,1,Player.WHITE));
		addPiece(new Pawn(3,1,Player.WHITE));
		addPiece(new Pawn(4,1,Player.WHITE));
		addPiece(new Pawn(5,1,Player.WHITE));
		addPiece(new Pawn(6,1,Player.WHITE));
		addPiece(new Pawn(7,1,Player.WHITE));
		
		addPiece(new Rook(0,7,Player.BLACK));
		addPiece(new Knight(1,7,Player.BLACK));
		addPiece(new Bishop(2,7,Player.BLACK));
		addPiece(new Queen(3,7,Player.BLACK));
		addPiece(new King(4,7,Player.BLACK));
		addPiece(new Bishop(5,7,Player.BLACK));
		addPiece(new Knight(6,7,Player.BLACK));
		addPiece(new Rook(7,7,Player.BLACK));
		addPiece(new Pawn(0,6,Player.BLACK));
		addPiece(new Pawn(1,6,Player.BLACK));
		addPiece(new Pawn(2,6,Player.BLACK));
		addPiece(new Pawn(3,6,Player.BLACK));
		addPiece(new Pawn(4,6,Player.BLACK));
		addPiece(new Pawn(5,6,Player.BLACK));
		addPiece(new Pawn(6,6,Player.BLACK));
		addPiece(new Pawn(7,6,Player.BLACK));
	}

	@Override
	public Player getActivePlayer() 
	{
		return activePlayer;
	}

	@Override
	public ChessPiece getPiece(int column, int row) 
	{
		if(!validateCoordinates(row,column))
			throw new IllegalArgumentException("Row or column index out of bounds of board.");
		
		return board[row*WIDTH + column];
	}
	
	private void addPiece(ChessPiece piece)
	{
		board[piece.row()*WIDTH + piece.column()] = piece;
	}

	@Override
	public void movePiece(int column, int row, ChessPiece piece) throws GameException 
	{
		if(piece.owner() != activePlayer)
			throw new GameException("Cannot move piece not belonging to active player.");
		
		if(validMove(column,row,piece))
		{
			removePiece(piece);
			piece.setRow(row);
			piece.setColumn(column);
			addPiece(piece);
			if(activePlayer == Player.WHITE)
				activePlayer = Player.BLACK;
			else
				activePlayer = Player.WHITE;
		}
		else
			throw new GameException("Cannot move piece to the given position");
	}

	@Override
	public boolean validMove(int column, int row, ChessPiece piece) 
	{
		List<int[]> moves = piece.getMoves(this);
		for(int[] move : moves)
			if(move[0] == column && move[1] == row)
				return true;
		return false;
	}

	private void removePiece(ChessPiece piece) 
	{
		for(int i = 0; i < board.length; i++)
			if(board[i] == piece)
				board[i] = null;
	}

	public boolean validateCoordinates(int column, int row)
	{
		return !(row < 0 || row >= HEIGHT || column < 0 || column >= WIDTH);
	}

	@Override
	public List<ChessPiece> getAllPieces() 
	{
		List<ChessPiece> pieces = new ArrayList<ChessPiece>();

		for(int i = 0; i < board.length; i++)
			if(board[i] != null)
				pieces.add(board[i]);
		return pieces;
	}

}

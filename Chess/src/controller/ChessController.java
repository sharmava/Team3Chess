package controller;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

import model.ChessModel;
import model.ChessModel.PieceType;
import model.ChessModel.Player;
import model.ChessPiece;
import model.IChessModel;
import view.IChessView;

public class ChessController implements IChessController {
	private IChessView view;
	private IChessModel model;
	private ChessPiece selectedPiece;

	public ChessController(IChessView view, IChessModel model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void clickSquare(int column, int row) {
		ChessPiece piece = model.getPiece(column, row);

		if (selectedPiece != null) {
			if (piece == selectedPiece)
			{
				selectedPiece = null;
				removeHighlights();
			}
			else if (piece == null || piece.owner() != model.getActivePlayer()) {
				if (model.validMove(column, row, selectedPiece)) {
					try {
						//save the position if it is an elimination scenario
						ChessPiece eliminatedPiece = model.getPiece(column, row);
						if(eliminatedPiece != null)
						{
							eliminatedPiece.setIsDead(true);
							saveMove(row, column,eliminatedPiece);
						}
						int[] startPos = new int[]{selectedPiece.row(), selectedPiece.column()};
						view.removeImage(selectedPiece.column(),
								selectedPiece.row());
						view.setImage(column, row, selectedPiece.type(),
								model.getActivePlayer());

						model.movePiece(column, row, selectedPiece);
						//saves the present move
						saveMove(startPos[0],startPos[1],selectedPiece);
						ChessPiece king = null;
						List<ChessPiece> pieces = model.getAllPieces();
						for (ChessPiece piece1 : pieces) {

							if (piece1.type().name() == "KING"
									&& model.getActivePlayer() == piece1
											.owner()) {
								king = piece1;
								break;
							}
							
						removeHighlights();

						}

						if (model.isCheck(king, selectedPiece))
							System.out.println("Check");

					} catch (Exception e) {
						throw new IllegalArgumentException("Move was invalid");
					}
				}
			} else if (piece.owner() == model.getActivePlayer())
			{
				selectedPiece = piece;
				removeHighlights();
				addHighlights(piece);
			}
		} else if (piece == null)
			return;
		else if (piece.owner() == model.getActivePlayer())
		{
			selectedPiece = piece;
			addHighlights(piece);
		}
	}

	private void removeHighlights() 
	{
		view.removeHighlights();
	}

	private void addHighlights(ChessPiece piece) 
	{
		view.highlightPiece(piece.column(),piece.row());
		view.highlightMoves(piece.getMoves(model));
	}

	@Override
	public ChessPiece getSelectedPiece() {
		return selectedPiece;
	}

	@Override
	public void start() {
		view.start();

		for (ChessPiece piece : model.getAllPieces())
			view.setImage(piece.column(), piece.row(), piece.type(),
					piece.owner());
	}

	
	//implementation of undo functionality -- what about redo?
	Stack<ChessPiece> moveshistory;
	Stack<ChessPiece> redoMoveHistory;
	
	private void saveMove(int row, int column,ChessPiece piece)
	{
		if(this.moveshistory == null)
		{
			this.moveshistory = new Stack<ChessPiece>();
		}
		
		this.moveshistory.push(piece);
		piece.storeMove(row, column);
	}
	

	private void saveRedoMove(ChessPiece piece)
	{
		if(this.redoMoveHistory == null)
		{
			this.redoMoveHistory = new Stack<ChessPiece>();
		}
		
		this.redoMoveHistory.push(piece);
		//piece.storeMove(row, column);
	}
	
	private ChessPiece getPreviouslyMovedPiece()
	{
		if(this.moveshistory == null)
		{//when no move is made
			return null;
		}
		else if(this.moveshistory.isEmpty())
		{//when stack has collapsed
			return null;
		}
		else
		{
			ChessPiece lastMovedPiece = this.moveshistory.pop();
			saveRedoMove(lastMovedPiece);
			return lastMovedPiece;
		}
	}
	

	private ChessPiece getRedoPiece()
	{
		if(this.redoMoveHistory == null)
		{//when no move is made
			return null;
		}
		else if(this.redoMoveHistory.isEmpty())
		{//when stack has collapsed
			return null;
		}
		else
		{
			return this.redoMoveHistory.pop();
			
		}
	}
	
	public void undoMove()
	{
		//check if any moves were made...throw an exception if no moves were made!?? 
		ChessPiece lastMovedPiece = getPreviouslyMovedPiece();
		if(lastMovedPiece != null)
		{
			int[] prevPosition = lastMovedPiece.getPreviousMove();
			if(prevPosition != null)
			{
				//interchange the active player..so that after undo it will be reversed
				//in the elimination scenario this toggle shouldn't happen.
				if(!lastMovedPiece.getIsDead())
				{
					if(model.getActivePlayer() == Player.WHITE)
						((ChessModel) model).setActivePlayer(Player.BLACK);
					else
						((ChessModel) model).setActivePlayer(Player.WHITE);
				}
				else
					lastMovedPiece.setIsDead(false);
				
				//save the present move in redomove stack of the piece
				lastMovedPiece.saveRedoMove(lastMovedPiece.row(), lastMovedPiece.column());
				
				view.removeImage(lastMovedPiece.column(), lastMovedPiece.row());
				view.setImage(prevPosition[1], prevPosition[0], lastMovedPiece.type(), lastMovedPiece.owner());//   model.getActivePlayer());
				((ChessModel) model).makeMove(prevPosition[1], prevPosition[0], lastMovedPiece);
					
			}
		}
		
	}
	
	public void redoMove()
	{
		
		this.selectedPiece = getRedoPiece();
		if(selectedPiece != null)
		{
			int[] moveto = selectedPiece.getRedoMove();
			if(moveto != null)
			{
				if(model.getActivePlayer() != selectedPiece.owner())
					((ChessModel) model).setActivePlayer(selectedPiece.owner());
				clickSquare(moveto[1], moveto[0]);
			}
		}
	}
	
}

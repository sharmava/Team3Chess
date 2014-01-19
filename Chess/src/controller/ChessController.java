package controller;

import java.util.ArrayList;
import java.util.List;

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
				selectedPiece = null;
			else if (piece == null || piece.owner() != model.getActivePlayer()) {
				if (model.validMove(column, row, selectedPiece)) {
					try {
						view.removeImage(selectedPiece.column(),
								selectedPiece.row());
						view.setImage(column, row, selectedPiece.type(),
								model.getActivePlayer());

						model.movePiece(column, row, selectedPiece);

						ChessPiece king = null;
						List<ChessPiece> pieces = model.getAllPieces();
						for (ChessPiece piece1 : pieces) {

							if (piece1.type().name() == "KING"
									&& model.getActivePlayer() == piece1
											.owner()) {
								king = piece1;
								break;
							}

						}

						if (model.isCheck(king, selectedPiece))
							System.out.println("Check");

					} catch (Exception e) {
						throw new IllegalArgumentException("Move was invalid");
					}
				}
			} else if (piece.owner() == model.getActivePlayer())
				selectedPiece = piece;
		} else if (piece == null)
			return;
		else if (piece.owner() == model.getActivePlayer())
			selectedPiece = piece;
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

}

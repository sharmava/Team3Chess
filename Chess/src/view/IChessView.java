package view;

import java.util.List;

import controller.IChessController;
import model.ChessModel.PieceType;
import model.ChessModel.Player;

public interface IChessView {

	void start();

	void setImage(int column, int row, PieceType piece, Player white);

	void setController(IChessController controller);

	void removeImage(int column, int row);

	void highlightPiece(int column, int row);

	void highlightMoves(List<int[]> moves);

	void removeHighlights();

}

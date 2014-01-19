import java.awt.EventQueue;

import model.ChessModel;
import model.IChessModel;
import view.ChessView;
import view.IChessView;
import controller.ChessController;
import controller.IChessController;

public class Chess {
	public static void main(String[] args) {
		final IChessView view = new ChessView();
		IChessModel model = new ChessModel();
		final IChessController controller = new ChessController(view, model);
		view.setController(controller);

		controller.start();
	}
}

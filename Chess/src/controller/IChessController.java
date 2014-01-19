package controller;

import model.ChessPiece;

public interface IChessController 
{

	void clickSquare(int i, int j);

	ChessPiece getSelectedPiece();

	void start();

}

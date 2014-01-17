package game.viewTier;

import game.chessHelper.Position;
import game.pieces.Pieces;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class ChessBoard extends JFrame {
	
	private ChessBoard chessBoard;
	private JPanel contentPanel = new JPanel();
	private JPanel gridJPanel = new JPanel();
	private JToolBar soleJToolBar = new JToolBar();
	private JButton newGameButton = new JButton("New game");
	private JLabel checkNotifier = new JLabel("Check");
	private JButton[][] chessSquareArray = new JButton[8][8];
	private boolean allowUndoOverride;
	private Map<Position, Pieces> chessPieces;

	public ChessBoard() {
		this.chessBoard = this;
		setSize(700, 700);
		setContentPane(this.contentPanel);
		setDefaultCloseOperation(3);
		setTitle("Play Chess");

		this.contentPanel.setLayout(new BorderLayout());
		initializeGridJPanel();
		this.contentPanel.add(this.gridJPanel, "Center");
		initializeSoleJToolBar();
		this.contentPanel.add(this.soleJToolBar, "South");

		initializeChessSquareArray();
		setVisible(true);
	}
	
//	public static void main(String [] args){
//		ChessBoard ch = new ChessBoard();
//		ch.initialiseBoard();
//	}


	public void initialiseBoard() {
		this.chessPieces = new HashMap();
		addInitialSixteenPieces();
		Set<Position> positionSet = this.chessPieces.keySet();
		for (Position position : positionSet) {
			Pieces cp = (Pieces) this.chessPieces
					.get(position);
			paintBoardSquare(cp.getName(), position);
		}
	}
	
	public void resetAllBoardSquarecolors() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				JButton square = this.chessSquareArray[i][j];
				if (square.getName().charAt(0) == 'g') {
					square.setBackground(Color.GRAY);
				} else {
					square.setBackground(Color.WHITE);
				}
			}
		}
	}

	private void initializeGridJPanel() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.setRows(8);
		gridLayout.setColumns(8);
		this.gridJPanel.setLayout(gridLayout);
	}

	private void initializeSoleJToolBar() {
		this.soleJToolBar.setOrientation(0);
		this.soleJToolBar
				.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		this.soleJToolBar.setFloatable(false);
		this.soleJToolBar.add(this.newGameButton);
		this.soleJToolBar.add(new JToolBar.Separator());
		this.soleJToolBar.add(new JToolBar.Separator());
		this.soleJToolBar.
		add(new JToolBar.Separator());
		this.soleJToolBar.add(new JToolBar.Separator());
		this.checkNotifier.setForeground(Color.RED);
		this.checkNotifier.setVisible(false);
		this.soleJToolBar.add(this.checkNotifier);
	}

	private void initializeChessSquareArray() {
		boolean bool1 = false;
		boolean bool2 = false;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				this.chessSquareArray[i][j] = new JButton(" ");//JLabel((Icon) null, 0);
				this.chessSquareArray[i][j].setOpaque(true);
				if ((bool1 ^ bool2)) {
					this.chessSquareArray[i][j].setBackground(Color.darkGray);
					this.chessSquareArray[i][j].setName("gray" + i + j);
				} else {
					this.chessSquareArray[i][j].setBackground(Color.WHITE);
					this.chessSquareArray[i][j].setName("white" + i + j);
				}
				this.gridJPanel.add(this.chessSquareArray[i][j]);
				bool2 = bool2 != true;
				
				
			}
			bool1 = bool1 != true;
		}
	}



private void addInitialSixteenPieces() {
		Pieces.Color color = null;
		int xCoord = 0;
		int yCoord = 0;
		for (int i = 1; i <= 2; i++) {
			color = i == 1 ? Pieces.Color.WHITE
					: Pieces.Color.BLACK;
			yCoord = i == 1 ? 2 : 7;
			for (xCoord = 1; xCoord <= 8; xCoord++) {
				Position position = Position.createPosition(xCoord, yCoord);
				setPieceAtPosition(position,Pieces.createChessPiece("Pawn", color,	position));
			}
		}
		for (int i = 1; i <= 2; i++) {
			color = i == 1 ? Pieces.Color.WHITE
					: Pieces.Color.BLACK;
			yCoord = i == 1 ? 1 : 8;
			for (xCoord = 1; xCoord <= 8; xCoord++) {
				Position position = Position.createPosition(xCoord, yCoord);
				switch (xCoord) {
				case 1:
				case 8:
					setPieceAtPosition(position,
							Pieces.createChessPiece("Rook", color,
									position));
					break;
				case 2:
				case 7:
					setPieceAtPosition(position,
							Pieces.createChessPiece("Knight",
									color, position));
					break;
				case 3:
				case 6:
					setPieceAtPosition(position,
							Pieces.createChessPiece("Bishop",
									color, position));
					break;
				case 4:
					setPieceAtPosition(position,
							Pieces.createChessPiece("Queen",
									color, position));
					break;
				case 5:
					setPieceAtPosition(position,
							Pieces.createChessPiece("King", color,
									position));
				}
			}
		}
	}
//
	private void paintBoardSquare(String pieceName, Position position) {
		InputStream inIcon = ClassLoader.getSystemResourceAsStream(pieceName+ ".gif");
		assert (inIcon != null) : "inIcon should not be null.";
		BufferedImage imgIcon = null;
		try {
			imgIcon = ImageIO.read(inIcon);
		} catch (Exception e) {
			System.out.println("Error: Could not locate \"" + pieceName	+ ".gif\" in the current folder.");
		}
		pieceToChessArraySquare(position).setIcon(new ImageIcon(imgIcon));
	}

	public void setPieceAtPosition(Position position,Pieces newPiece) {
		assert (position != null);
		assert (newPiece != null);
		assert (position.equals(newPiece.getPosition())) : ("position = "
				+ position + ", and newPiece.getPosition() = " + newPiece.getPosition());

		this.chessPieces.put(position, newPiece);
	}

	public JButton pieceToChessArraySquare(Position position) {
		int z = position.getXCoord();
		int xCoord = position.getYCoord();
		int yCoord = z;
		xCoord--;
		yCoord--;
		xCoord = 7 - xCoord;
		return this.chessSquareArray[xCoord][yCoord];
	}

}


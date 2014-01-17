package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import controller.IChessController;
import model.ChessModel.PieceType;
import model.ChessModel.Player;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ChessView implements IChessView 
{

	public JFrame frame;
	private IChessController controller;
	private static final int WIDTH = 8;
	private static final int HEIGHT = 8;
	
	private JPanel contentPanel = new JPanel();
	private JPanel gridJPanel = new JPanel();
	private JToolBar soleJToolBar = new JToolBar();
	private JButton newGameButton = new JButton("New game");
	private JLabel checkNotifier = new JLabel("Check");
	
	private Map<PieceType,ImageIcon> whitePieceImages;
	private Map<PieceType,ImageIcon> blackPieceImages;
	
	private JButton[] buttons;
	
	public void start()
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ChessView() 
	{
		buttons = new JButton[HEIGHT*WIDTH];
		
		whitePieceImages = new HashMap<PieceType,ImageIcon>();
		whitePieceImages.put(PieceType.BISHOP,new ImageIcon(ChessView.class.getResource("/images/WhiteBishop.gif")));
		whitePieceImages.put(PieceType.KING,new ImageIcon(ChessView.class.getResource("/images/WhiteKing.gif")));
		whitePieceImages.put(PieceType.KNIGHT,new ImageIcon(ChessView.class.getResource("/images/WhiteKnight.gif")));
		whitePieceImages.put(PieceType.PAWN,new ImageIcon(ChessView.class.getResource("/images/WhitePawn.gif")));
		whitePieceImages.put(PieceType.QUEEN,new ImageIcon(ChessView.class.getResource("/images/WhiteQueen.gif")));
		whitePieceImages.put(PieceType.ROOK,new ImageIcon(ChessView.class.getResource("/images/WhiteRook.gif")));
		
		blackPieceImages = new HashMap<PieceType,ImageIcon>();
		blackPieceImages.put(PieceType.BISHOP,new ImageIcon(ChessView.class.getResource("/images/BlackBishop.gif")));
		blackPieceImages.put(PieceType.KING,new ImageIcon(ChessView.class.getResource("/images/BlackKing.gif")));
		blackPieceImages.put(PieceType.KNIGHT,new ImageIcon(ChessView.class.getResource("/images/BlackKnight.gif")));
		blackPieceImages.put(PieceType.PAWN,new ImageIcon(ChessView.class.getResource("/images/BlackPawn.gif")));
		blackPieceImages.put(PieceType.QUEEN,new ImageIcon(ChessView.class.getResource("/images/BlackQueen.gif")));
		blackPieceImages.put(PieceType.ROOK,new ImageIcon(ChessView.class.getResource("/images/BlackRook.gif")));
		
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 800);
		frame.setTitle("Play Chess!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(this.contentPanel);
		
		contentPanel.setLayout(new BorderLayout());
		initializeGridJPanel();
		contentPanel.add(gridJPanel, "Center");
		initializeSoleJToolBar();
		contentPanel.add(soleJToolBar, "South");
		
		for(int i = 0; i < buttons.length; i++)
		{
			ChessButton button = new ChessButton("");
			gridJPanel.add(button);
			buttons[i] = button;
			button.column = i%WIDTH;
			button.row = i/WIDTH;
			button.setOpaque(true);
			button.setBackground(Color.darkGray);
			if((button.row + button.column)%2 == 0)
				button.setBackground(Color.white);
			
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int column = ((ChessButton) arg0.getComponent()).column;
					int row = ((ChessButton) arg0.getComponent()).row;
					row = WIDTH - row - 1;
					controller.clickSquare(column, row);
				}
			});
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

	@Override
	public void setImage(int column, int row, PieceType piece, Player player) 
	{
		row = WIDTH - row - 1;
		JButton button = buttons[row*WIDTH + column];
		if(player == Player.WHITE)
			button.setIcon(whitePieceImages.get(piece));
		else
			button.setIcon(blackPieceImages.get(piece));
	}
	
	@Override
	public void removeImage(int column, int row)
	{
		row = WIDTH - row - 1;
		JButton button = buttons[row*WIDTH + column];
		button.setIcon(null);
		button.revalidate();
	}

	@Override
	public void setController(IChessController controller) 
	{
		this.controller = controller;
		
	}
	
	

}

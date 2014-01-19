import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CheckTest extends JFrame {
	public CheckTest() {
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(8, 8, 0, 0));
		
		
		JButton button = new JButton("");
		panel.add(button);
		
		JButton btnNewButton_6 = new JButton("New button");
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_14 = new JButton("New button");
		panel.add(btnNewButton_14);
		
		JButton btnNewButton_8 = new JButton("New button");
		panel.add(btnNewButton_8);
		
		JButton button_1 = new JButton("New button");
		panel.add(button_1);
		
		JButton btnNewButton_3 = new JButton("New button");
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnNewButton_2 = new JButton("New button");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		panel.add(btnNewButton_5);
		panel.add(btnNewButton);
		
		JButton btnNewButton_10 = new JButton("New button");
		panel.add(btnNewButton_10);
		
		JButton btnNewButton_7 = new JButton("New button");
		panel.add(btnNewButton_7);
		
		JButton btnNewButton_12 = new JButton("New button");
		panel.add(btnNewButton_12);
		
		JButton btnNewButton_9 = new JButton("New button");
		panel.add(btnNewButton_9);
		
		JButton btnNewButton_11 = new JButton("New button");
		panel.add(btnNewButton_11);
		
		JButton btnNewButton_13 = new JButton("New button");
		panel.add(btnNewButton_13);
	}

	public static void  start()
	{
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(10, 20, 100, 200);
	
		JButton b1 = new JButton();
		frame.getContentPane().add(b1);
	}
	
	public static void main(String args[])
	{
		start();
	}
}

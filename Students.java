import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Students extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Students frame = new Students();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Students() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(7, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(371, 369, -229, -198);
		contentPane.add(scrollPane_1);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add a=new Add();
				a.setVisible(true);
				dispose();
			}
			
		});
		btnNewButton.setBounds(209, 84, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update u=new Update();
				u.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(209, 142, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Display");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Display d=new Display();
				d.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(209, 199, 85, 21);
		contentPane.add(btnNewButton_3);
		
	
	}
}

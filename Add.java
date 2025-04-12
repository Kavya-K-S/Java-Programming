import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*
;public class Add extends JFrame {

	private JPanel contentPane;
	private JTextField sid;
	private JTextField sname;
	private JTextField scourse;
	private JTextField smarks;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add frame = new Add();
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
	public Add() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		sid = new JTextField();
		sid.setBounds(180, 73, 96, 19);
		contentPane.add(sid);
		sid.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(54, 76, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(54, 122, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("course");
		lblNewLabel_2.setBounds(54, 167, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Marks");
		lblNewLabel_3.setBounds(54, 215, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		sname = new JTextField();
		sname.setBounds(180, 119, 96, 19);
		contentPane.add(sname);
		sname.setColumns(10);
		
		scourse = new JTextField();
		scourse.setBounds(180, 164, 96, 19);
		contentPane.add(scourse);
		scourse.setColumns(10);
		
		smarks = new JTextField();
		smarks.setBounds(180, 212, 96, 19);
		contentPane.add(smarks);
		smarks.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=sname.getText();
				String id=sid.getText();
				String course=scourse.getText();
				String marks=smarks.getText();
				//jOptionPane.showMessageDialog()
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Exam","root","");
					PreparedStatement ps=conn.prepareStatement("insert into students values (?,?,?,?)");
					ps.setString(1, id);
					ps.setString(2, name);
					ps.setString(3, course);
					ps.setString(4, marks);
					int rs=ps.executeUpdate();
					if(rs>0) {
						JOptionPane.showMessageDialog(null,"Added successfully!");
						Students s=new Students();
						s.setVisible(true);
						dispose();
					}
					else {
						
						JOptionPane.showMessageDialog(null,"Could not add");
					}
					
						
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(54, 261, 85, 21);
		contentPane.add(btnNewButton);
	}

}

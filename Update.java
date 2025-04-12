import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class Update extends JFrame {

	private JPanel contentPane;
	private JTextField srollno;
	private JTextField sname;
	private JTextField scourse;
	private JTextField marks;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update frame = new update();
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
	public Update() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("rollno");
		lblNewLabel.setBounds(73, 10, 45, 13);
		contentPane.add(lblNewLabel);
		
		srollno = new JTextField();
		srollno.setBounds(128, 7, 96, 19);
		contentPane.add(srollno);
		srollno.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(73, 48, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		sname = new JTextField();
		sname.setColumns(10);
		sname.setBounds(128, 48, 96, 19);
		contentPane.add(sname);
		
		JLabel lblNewLabel_2 = new JLabel("Course");
		lblNewLabel_2.setBounds(73, 85, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		scourse = new JTextField();
		scourse.setBounds(128, 85, 96, 19);
		contentPane.add(scourse);
		scourse.setColumns(10);
		
		marks = new JTextField();
		marks.setBounds(128, 114, 96, 19);
		contentPane.add(marks);
		marks.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Marks");
		lblNewLabel_3.setBounds(61, 117, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Exam","root","");
					PreparedStatement ps=conn.prepareStatement("update students set marks=? where roll=?");
					String roll=srollno.getText();
					String name=sname.getText();
					String course=scourse.getText();
					String mark=marks.getText();
					ps.setString(1, mark);
					ps.setString(2, roll);
					int row=ps.executeUpdate();
					if(row>0) {
						JOptionPane.showMessageDialog(null,"updated Succesfully");
					}
					else {
						JOptionPane.showMessageDialog(null, "Student not found");
					}
                  //  C:\Users\Kavya KS\eclipse-workspace\JAVAproject\src\JAVAproject\Swing\Add.java
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(375, 47, 380, 247);
					contentPane.add(scrollPane);
					
					table = new JTable();
					scrollPane.setViewportView(table);
					table.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Roll No", "Name", "Course", "Marks"
						}
					));
					Statement st=conn.createStatement();
					ResultSet rs=st.executeQuery("Select * from Students");
					DefaultTableModel model=(DefaultTableModel)table.getModel();
					while(rs.next()) {
						String troll=rs.getString("roll");
						String tname=rs.getString("name");
						String tcourse=rs.getString("course");
						String tmarks=rs.getString("marks");
						model.addRow(new Object[] {troll,tname,tcourse,tmarks} );
					}
					
				} catch (SQLException | ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(128, 160, 85, 21);
		contentPane.add(btnNewButton);
		
		
	}
}

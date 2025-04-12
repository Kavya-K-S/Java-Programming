import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.sql.*;

public class Display extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display frame = new Display();
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
	public Display() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(82, 73, 258, 132);
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
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Exam","root","");
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("Select * from students");
		    DefaultTableModel model=(DefaultTableModel)table.getModel();
			//model.setColumnIdentifiers(new String[] {"Roll No", "Name", "Course", "Marks"});
			while(rs.next()) {
				String roll=rs.getString("roll");
				String name=rs.getString("name");
				String course=rs.getString("course");
				String marks=rs.getString("marks");
				model.addRow(new Object[] {roll,name,course,marks} );
			}
			
			table.setModel(model);
		}
		
		
		catch(Exception ex) {
			System.out.println(ex);
		}
	}

}


package signin_and_signup;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import java.awt.TextField;

public class signin_page extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	static signin_page frame ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new signin_page();
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
	public signin_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(53, 80, 154, 33);
		contentPane.add(lblNewLabel);
		
		t1 = new JTextField();
		t1.setBounds(279, 73, 229, 40);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBounds(279, 170, 229, 40);
		contentPane.add(t2);
		t2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(53, 166, 154, 33);
		contentPane.add(lblNewLabel_1);
		
		final JButton b = new JButton("SignIn");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1=t1.getText();
				String s2=t2.getText();
				//boolean p=Pattern.matches("[A-Za-z0-9][]",s2);
				
				
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sandeep","root","root");
					java.sql.Statement sta=con.createStatement();
					String Query="select * from signup where uname='"+s1+"' and "+"password='"+s2+"' ";//name='"+s1+"' and "+"password='"+s2+"' "
					ResultSet rs=sta.executeQuery(Query);
					if(rs.next()) {
						JOptionPane.showMessageDialog(b,"Sucessfully logged in");
					}
					else {
						JOptionPane.showMessageDialog(b,"Click signup page");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		b.setFont(new Font("Tahoma", Font.PLAIN, 32));
		b.setBounds(186, 291, 176, 55);
		contentPane.add(b);
		
		JButton btnNewButton_1 = new JButton("SignUp");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signup_page p=new signup_page();
				p.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBackground(new Color(240, 240, 240));
		btnNewButton_1.setBounds(273, 381, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Don't have an account ?");
		lblNewLabel_3.setBounds(147, 383, 144, 18);
		contentPane.add(lblNewLabel_3);
	}
}

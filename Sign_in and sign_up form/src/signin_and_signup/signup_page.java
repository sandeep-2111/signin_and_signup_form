package signin_and_signup;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import javax.swing.JTextPane;

public class signup_page extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField t2;
	private JTextField t1;
	private JTextField txtAlreadyHaveA;
	static signup_page frame;
	static JLabel l;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new signup_page();
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
	public signup_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 472);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(85, 87, 178, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PassWord");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(89, 176, 161, 46);
		contentPane.add(lblNewLabel_1);
		
		t2 = new JTextField();
		t2.setBounds(300, 176, 243, 46);
		contentPane.add(t2);
		t2.setColumns(10);
		
		t1 = new JTextField();
		t1.setBounds(300, 79, 243, 43);
		contentPane.add(t1);
		t1.setColumns(10);
		
		final JButton bt = new JButton("SignUp");
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1=t1.getText();
				String s2=t2.getText();
			
				try {
					java.sql.Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sandeep","root","root");
					String query="select * from signup where uname='"+s1+"'and "+"password='"+s2+"' ";
					
					java.sql.Statement s=con.createStatement();
					ResultSet rs=s.executeQuery(query);
					if(rs.next()) {
						JOptionPane.showMessageDialog(bt,"the specified name already exists try another");
					}
					else {
						String Query="insert into signup values('"+s1+"','"+s2+"')";
						s.execute(Query);
						JOptionPane.showMessageDialog(bt,"sucessfully registered");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(bt,"duplicate username");
				}
			}
		});
		bt.setFont(new Font("Tahoma", Font.PLAIN, 32));
		bt.setBounds(216, 320, 151, 57);
		contentPane.add(bt);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(220, 249, 0, 20);
		contentPane.add(textPane);
		
		txtAlreadyHaveA = new JTextField();
		txtAlreadyHaveA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtAlreadyHaveA.setText("Already have an account !");
		txtAlreadyHaveA.setBackground(new Color(192, 192, 192));
		txtAlreadyHaveA.setForeground(new Color(0, 0, 0));
		txtAlreadyHaveA.setBounds(142, 261, 183, 35);
		contentPane.add(txtAlreadyHaveA);
		txtAlreadyHaveA.setColumns(10);
		
		JButton btnNewButton = new JButton("SignIn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 signin_page p=new signin_page();
				 p.setVisible(true);
				 frame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(335, 268, 89, 23);
		contentPane.add(btnNewButton);
		
		l = new JLabel("Should contain @$&");
		l.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l.setBounds(335, 233, 178, 24);
		contentPane.add(l);
	}
}

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;

public class Login extends JFrame {
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblWrongPasswordOr =null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setBackground(Color.PINK);
		getContentPane().setBackground(new Color(245, 255, 250));
		getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("User Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(92, 74, 107, 20);
		getContentPane().add(lblName);
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setBounds(251, 70, 86, 24);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(92, 129, 85, 14);
		getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(Color.WHITE);
		passwordField.setBounds(251, 125, 86, 24);
		getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		String s = "1";
		String s1 = "1";
		JFrame jframe = this;
		lblWrongPasswordOr = new JLabel("Wrong User Name or password ");
		btnLogin.addActionListener(new ActionListener(){

		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(
				textField.getText().equals(s) &&passwordField.getText().equals(s1) 
				
				){
					jframe.setVisible(false);
					 
					
					Home home=new Home();
					home.setVisible(true);
					jframe.dispose();
				}
				else{
					
					lblWrongPasswordOr.setVisible(true);
					 
			}
		}
			
			
			
		});
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setBackground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLogin.setBounds(150, 209, 151, 31);
		getContentPane().add(btnLogin);
		
		lblWrongPasswordOr .setVisible(false);
		JButton btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
//				int pane= JOptionPane.showConfirmDialog(new JButton(),"Are you sure you want to reset Password?" );
//				if(pane==0){
//					JOptionPane.showMessageDialog( new JButton(), "Your password has been sent to your email.");
//				}
				
			}
			
		});
		btnForgotPassword.setBackground(new Color(255, 255, 255));
		btnForgotPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnForgotPassword.setBounds(150, 251, 151, 31);
		getContentPane().add(btnForgotPassword);
		
		
		lblWrongPasswordOr.setForeground(new Color(255, 51, 51));
		lblWrongPasswordOr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWrongPasswordOr.setBounds(131, 169, 222, 14);
		getContentPane().add(lblWrongPasswordOr);
		this.setTitle("Login Window");
		this.setSize(420, 350);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
 
	}

}

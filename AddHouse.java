import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;

public class AddHouse extends JPanel {
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField;
	//private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_7;
	private int Bill = 0;
	private int Day;
	private int year =2016; 
	private int month=4;
	private String Team_Leader;
	
	

	/**
	 * Create the panel.
	 */
	public AddHouse() {
		textField_1 = new JTextField("");
		textField_1.setBounds(484, 74, 152, 28);
		add(textField_1);
		textField_1.setColumns(10);
		
		
		JLabel lblWrongInput = new JLabel("Wrong Input:");
		lblWrongInput.setVisible(false);
		
		textField = new JTextField("");
		textField.setBounds(202, 74, 152, 28);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(90, 74, 66, 26);
		add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("CNIC");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(398, 74, 66, 24);
		add(lblEmail);
		
		JLabel lblCellNo = new JLabel("Streat Name");
		lblCellNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCellNo.setBounds(90, 134, 102, 26);
		add(lblCellNo);
		
		textField_2 = new JTextField("");
		textField_2.setBounds(202, 135, 152, 28);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblHouseNo = new JLabel("House No.");
		lblHouseNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHouseNo.setBounds(398, 134, 80, 26);
		add(lblHouseNo);
		
		textField_5 = new JTextField("1");
		textField_5.setBounds(266, 342, 42, 28);
		add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblPaedOnline = new JLabel("No. of small windows:\r\n");
		lblPaedOnline.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPaedOnline.setBounds(90, 269, 166, 28);
		add(lblPaedOnline);
		
		JButton btnSave = new JButton("Save");
		Connection conn = Search.connect();
		btnSave.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String s =textField.getText();
				String s1 =textField_1.getText();
				String s2 = textField_2.getText();
				String s3 = textField_3.getText();
				
				System.out.println("agea"+"  "+s+" "+s1+" "+s2+" "+s3);
				if((s1.length()>0 && Pattern.compile("[0-9]{13}").matcher(s1).matches()) || (s3.length()>0 && Pattern.compile("[0-9]+").matcher(s3).matches())){
				int num = Integer.parseInt(s3);
					String quer = "use dps_project";
					PreparedStatement pst;
					try {
						pst = conn.prepareStatement(quer);
						pst.executeUpdate();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String a = "insert into window_cleaner values(";
					String query=a+"'"+s+"','"+s1+"',"+num+",'"+s2+"',"+"'..','..','..','..','"+Bill+"$',"+Day+","+month+","+year+",'"+Team_Leader+"')";
					try {
						 
						pst = conn.prepareStatement(query);
						 pst.executeUpdate();
					
					
			
					} catch (SQLException b) {
						// TODO Auto-generated catch block
						b.printStackTrace();
					}
				}
			}
				
			
		});
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSave.setBounds(422, 588, 113, 39);
		add(btnSave);
		
		JLabel lblRegister = new JLabel("Personal info:");
		lblRegister.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRegister.setBounds(90, 30, 127, 30);
	
		add(lblRegister);
	
		
		
		setLayout(null);
		this.setBackground(Color.WHITE);
		
		textField_3 = new JTextField();
		textField_3.setBounds(484, 134, 152, 28);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblBillwindow = new JLabel("No. of large windows:\r\n");
		lblBillwindow.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBillwindow.setBounds(90, 342, 166, 24);
		add(lblBillwindow);
		
		JLabel lblEnterAmount = new JLabel("Bill per window:");
		lblEnterAmount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnterAmount.setBounds(422, 269, 127, 28);
		add(lblEnterAmount);
		
		JTextField textField_6 = new JTextField();
		textField_6.setText("5");
		textField_6.setBounds(594, 271, 42, 28);
		add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblSizeInches = new JLabel("(Size 50*50 inches or less)");
		lblSizeInches.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSizeInches.setBounds(90, 293, 166, 24);
		add(lblSizeInches);
		
		textField_4 = new JTextField();
		textField_4.setText("1");
		textField_4.setBounds(266, 271, 42, 28);
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblEnterAmount_1 = new JLabel("Bill per window:");
		lblEnterAmount_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnterAmount_1.setBounds(422, 341, 127, 26);
		add(lblEnterAmount_1);
		
		textField_7 = new JTextField();
		textField_7.setText("10");
		textField_7.setBounds(594, 342, 42, 28);
		add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblSizeOf = new JLabel("(Size of 50*50 or greater)");
		lblSizeOf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSizeOf.setBounds(90, 362, 166, 26);
		add(lblSizeOf);
		
		JLabel label = new JLabel("$");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(559, 347, 25, 14);
		add(label);
		
		JLabel label_1 = new JLabel("$");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(559, 276, 25, 14);
		add(label_1);
		
		JLabel lblWindowsInfo = new JLabel("Windows info:");
		lblWindowsInfo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblWindowsInfo.setBounds(90, 216, 166, 17);
		add(lblWindowsInfo);
		
		JLabel lblOurBillIs = new JLabel();
		lblOurBillIs.setVisible(false);
		lblOurBillIs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOurBillIs.setBounds(422, 422, 188, 39);
		add(lblOurBillIs);
		
		JButton btnGenerateBill = new JButton("Generate Bill");
		btnGenerateBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int small = Integer.parseInt(textField_4.getText())*Integer.parseInt(textField_6.getText());
				
				int big  = Integer.parseInt(textField_5.getText())*Integer.parseInt(textField_7.getText());
				
				Bill=small+big;
				lblOurBillIs.setText("your bill is: $"+Bill);
				lblOurBillIs.setVisible(true);
				
			}
		});
		btnGenerateBill.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGenerateBill.setBounds(195, 422, 113, 39);
		add(btnGenerateBill);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Schedule\r\n");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = "Use y2016";
				String s1="select * from April where day=1 && (visit_1='F' || visit_2='F' || visit_3='F')";
				
				
				
				PreparedStatement pst;
				try {
					pst = conn.prepareStatement(s);
					pst.executeQuery();
					pst = conn.prepareStatement(s1);
					ResultSet rs =pst.executeQuery();
					while(rs.next()){
						//System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
						if(rs.getString(3).equals("F")){
							Day=Integer.parseInt(rs.getString(6));
							Team_Leader = rs.getString(2);
							String a = "update April set visit_1='B' where Team_Leader = '"+rs.getString(2)+"' && Day ="+rs.getString(6) ;
							pst = conn.prepareStatement(a);
							pst.executeUpdate();
							rdbtnNewRadioButton.setEnabled(false);
							break;
						}
						else if(rs.getString(4).equals("F")){
							Day=Integer.parseInt(rs.getString(6));
							Team_Leader = rs.getString(2);
							String a = "update April set visit_2='B' where Team_Leader = '"+rs.getString(2)+"' && Day ="+rs.getString(6) ;
							pst = conn.prepareStatement(a);
							pst.executeUpdate();
							rdbtnNewRadioButton.setEnabled(false);
							break;
						}
						else if (rs.getString(5).equals("F")){
							Day=Integer.parseInt(rs.getString(6));
							Team_Leader = rs.getString(2);
							String a = "update April set visit_3='B' where Team_Leader = '"+rs.getString(2)+"' && Day ="+rs.getString(6) ;
							pst = conn.prepareStatement(a);
							pst.executeUpdate();
							rdbtnNewRadioButton.setEnabled(false);
							break;
						}
						
					}
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton.setBounds(199, 494, 109, 39);
		add(rdbtnNewRadioButton);
		
		
		lblWrongInput.setBackground(Color.RED);
		lblWrongInput.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblWrongInput.setBounds(90, 181, 127, 24);
		add(lblWrongInput);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"4-Weeks", "8-Weeks"}));
		comboBox.setBounds(422, 494, 113, 39);
		add(comboBox);
		
		

	}
}

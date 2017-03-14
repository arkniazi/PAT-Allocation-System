import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;

import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingUtilities;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import javax.swing.JMenuItem;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;



public class Home extends JFrame {
	private JTextField textField_4;
	private JTable table;
	public JTabbedPane tabbedPane;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Home() {
		
		Connection conn = Search.connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		
		tabbedPane.setBorder(null);
		tabbedPane.setForeground(SystemColor.textHighlight);
		tabbedPane.setBackground(new Color(205, 255, 204));
		tabbedPane.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(0, 0, 1000, 680);
		
		getContentPane().add(tabbedPane);
		
		getContentPane().setBackground(new Color(120, 159, 179));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 255, 250));
		tabbedPane.addTab("", new ImageIcon("DPS_projec1\\..\\Home-chota.png"), panel, "Home");
		panel.setLayout(null);
		
		JLabel lblNote = new JLabel("Sticky Notes");
		lblNote.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNote.setBounds(466, 326, 148, 21);
		panel.add(lblNote);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblStatus.setBounds(10, 104, 115, 26);
		panel.add(lblStatus);
		
		JLabel lblClock = new JLabel("Clock");
		lblClock.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblClock.setBounds(48, 563, 80, 21);
		panel.add(lblClock);
		
		textField = new JTextField("");
		textField.setBackground(new Color(245, 255, 250));
		textField.setFont(new Font("Tahoma", Font.ITALIC, 16));
		textField.setBounds(48, 595, 80, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblReminder = new JLabel("Reminders");
		lblReminder.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblReminder.setBounds(466, 104, 127, 26);
		panel.add(lblReminder);
		
		JTextArea txtrRoundStarts = new JTextArea();
		txtrRoundStarts.setFont(new Font("Arial Unicode MS", Font.BOLD, 18));
		txtrRoundStarts.setBounds(466, 141, 329, 159);
		panel.add(txtrRoundStarts);
		txtrRoundStarts.setText("Round_2 starts : 10:30\r\nTeam_2  shifts : 11:00");
		txtrRoundStarts.setBackground(new Color(255, 255, 255));
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 18));
		
		try {
			Scanner scan = new Scanner(new File("Note.txt"));
			String s="";
			while(scan.hasNextLine()){
				 s=s+"\n"+scan.nextLine();
				textArea_1.setText(s);
			}
			scan.close();
		} catch (IOException e2) {
			
		}
		
		textArea_1.addCaretListener(new CaretListener() {
			
			@Override
			public void caretUpdate(CaretEvent e) {
				
				FileWriter write;
				try {
					String s = textArea_1.getText();
					write = new FileWriter(new File("Note.txt"));
					write.write(s);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String s=textField_4.getText();
				
				
			}
		});
		textArea_1.setBounds(466, 370, 327, 159);
		panel.add(textArea_1);
		textArea_1.setBackground(new Color(255, 255, 255));
		
		JTextArea txtrNoOfHouses = new JTextArea();
		txtrNoOfHouses.setFont(new Font("Arial Unicode MS", Font.BOLD, 18));
		txtrNoOfHouses.setBounds(10, 141, 446, 388);
		panel.add(txtrNoOfHouses);
		txtrNoOfHouses.setText("Houses attended :   \r\nHouses not attended :   \r\nHouses paid but not attended  : \r\nPayments completed :   \r\nPayments remaining :   \r\nTeams busy :   \r\nTeams free :   \r\nTotal earning in april :   \t\t  ");
		
		JButton btnProfile = new JButton("");
		btnProfile.setToolTipText("Profile");
		

		JMenuItem profile = new JMenuItem("Profile");
		JMenuItem logout = new JMenuItem("Logout");
		JPopupMenu popProfile  = new JPopupMenu();
		popProfile.add(profile);
		popProfile.add(logout);
		
		btnProfile.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent a) {
				if(SwingUtilities.isRightMouseButton(a)){
					popProfile.show(a.getComponent(), a.getX(), a.getY());					
				}	
			}		
			public void mouseEntered(MouseEvent arg0) {	}
			public void mouseExited(MouseEvent a){ }
			public void mousePressed(MouseEvent arg0) { }
			public void mouseReleased(MouseEvent arg0) { }
			
		});
		
		JFrame home = this;
		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Login().setVisible(true);;
				home.dispose();
				
			}
		});
		
		btnProfile.setOpaque(false);

		btnProfile.setIcon(new ImageIcon("DPS_projec1\\..\\photo.jpg"));
		btnProfile.setBounds(715, 25, 80, 82);
		panel.add(btnProfile);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 255, 250));
		tabbedPane.addTab("", new ImageIcon("DPS_projec1\\..\\edit-chota.png"), panel_2, "Search and Edit data");
		panel_2.setLayout(null);
		
		JButton btnSearchB = new JButton("Search");
		btnSearchB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		
		JLabel lblWrongHouseNo = new JLabel("Please enter an integer!");
		JComboBox comboBox = new JComboBox();
		lblWrongHouseNo.setVisible(false);
		btnSearchB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				lblWrongHouseNo.setVisible(false);
					try {
						ResultSet rs = null;
						if(comboBox.getSelectedItem().toString().equals("House_No") && !Pattern.compile("[0-9]+").matcher(textField_4.getText()).matches()){
							lblWrongHouseNo.setVisible(true);
						}						
						else if(comboBox.getSelectedItem().toString().equals("Show All"))
						{
							String s = "Select * from window_cleaner";
							PreparedStatement pst = conn.prepareStatement(s);
							 rs = pst.executeQuery();
							 //table.setModel(DbUtils.resultSetToTableModel(rs));
						}
						else{
							String query ="select * from window_cleaner where "+comboBox.getSelectedItem().toString()+"= "+"'"+textField_4.getText()+"'";
							PreparedStatement pst = conn.prepareStatement(query);
							rs = pst.executeQuery();	
						//	table.setModel(DbUtils.resultSetToTableModel(rs));
					
						}						
					} catch (SQLException e) {
						
						e.printStackTrace();
				}
				
			}
			 
		});
		btnSearchB.setBounds(198, 25, 77, 31);
		panel_2.add(btnSearchB);
		
		textField_4 = new JTextField("");
		textField_4.setBounds(285, 26, 113, 30);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(new Color(245, 255, 250));
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(10, 98, 830, 575);
		panel_2.add(scrollPane);
		
		table = new JTable( );
		
		JMenuItem save = new JMenuItem("Save");
		JMenuItem delete = new JMenuItem("Delete");
		JPopupMenu pop  = new JPopupMenu();
		pop.add(save);
		pop.add(delete);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent a) {
				if(SwingUtilities.isRightMouseButton(a)){
					pop.show(a.getComponent(), a.getX(), a.getY());
					
				}
			}
		});
		
		
		
		save.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int col = table.getSelectedColumn();
				int row = table.getSelectedRow();
				
				
				String s = "update window_cleaner set "+table.getColumnName(col)+"="+
						"'"+table.getValueAt(row, col)+"'"
								+ " where House_No="+table.getValueAt(row,2 ) +"&& Streat_Name=" +"'"+table.getValueAt(row, 3)+"'";
			
				
				try {
					
					Statement pst = conn.createStatement();
					pst.executeUpdate(s);
					//pst.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
	//	table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	
		
		scrollPane.setViewportView(table);
		  
		
		table.setSurrendersFocusOnKeystroke(true);
		
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		
		lblWrongHouseNo.setForeground(Color.RED);
		lblWrongHouseNo.setBackground(Color.WHITE);
		lblWrongHouseNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWrongHouseNo.setBounds(251, 67, 177, 20);
		panel_2.add(lblWrongHouseNo);
		
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Name", "CNIC", "House_No", "Streat_Name", "Round", "Show All"}));
		comboBox.setBounds(487, 25, 93, 31);
		panel_2.add(comboBox);
		
		JLabel lblSearchB = new JLabel("Search by");
		lblSearchB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSearchB.setBounds(408, 25, 69, 31);
		panel_2.add(lblSearchB);
		AddHouse addHouse = new AddHouse();
		addHouse.setBackground(new Color(245, 255, 250));
		tabbedPane.addTab("", new ImageIcon("DPS_projec1\\..\\add-chota.png"), addHouse, "Add Customer");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(240, 255, 255));
		tabbedPane.addTab("", new ImageIcon(" DPS_projec1\\..\\schedule-chota.png"),new Schedule(), "Schedule");
		panel_4.setLayout(new BorderLayout(0, 0));

		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(245, 255, 250));
		tabbedPane.addTab("", new ImageIcon("DPS_projec1\\..\\help-chota.png"), panel_3, "Help\r\n");
		panel_3.setLayout(null);
		
		
		
		this.setSize(new Dimension(1000, 700));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Dukhi Window Cleaning Software");
		
		 
	}
	
	public void addText(String s){
		
		s.split(" ");
		this.repaint();
	}
}

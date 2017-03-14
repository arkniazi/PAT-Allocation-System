import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Teams extends JDialog {

	private JPanel contentPane;
	int c=1;
	private JButton[] bTeams = new JButton[16];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teams frame = new Teams();
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
	public Teams() {
		
		Connection conn = Search.connect();
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 592, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4,4));
		
		int i=1;
	
		for(int a =0;a<bTeams.length;a++){
			if(i<16){
			bTeams[a]= new JButton(""+i);
			bTeams[a].setBackground(Color.green);
			
					String s0="use y2016";
					String s="select * from april where Team_ID="+i+"&& Day= 1";
					PreparedStatement pst;
					try {
						pst = conn.prepareStatement(s0);
						pst.executeQuery();
						pst = conn.prepareStatement(s);
						ResultSet rs=pst.executeQuery();
						
						while(rs.next()){
						//	System.out.println(rs.getString(2).equals("B") || rs.getString(3).equals("B") || rs.getString(4).equals("B"));
							if(rs.getString(2).equals("B") || rs.getString(3).equals("B") || rs.getString(4).equals("B") ){
								
								
								
							//	System.out.println(Integer.parseInt(rs.getString(1)));
								bTeams[i-1].setBackground(Color.RED);
							}
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					panel.add(bTeams[a]);
				}		
			
			else
			{
				bTeams[a]= new JButton("Add Team");
				panel.add(bTeams[a]);
			}
			i++; 
		}
		
		
		
	}

}

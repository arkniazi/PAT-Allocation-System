import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Schedule extends JPanel {

	private JButton[] barr = new JButton[42];
	private String [] arr = new String[42];

	private int Month=4;
	private int year=2016;
	
	private JPanel panel;
	String[] months = {
			"",                             
			"January", "February", "March",
			"April", "May", "June",
			"July", "August", "September",
			"October", "November", "December"
	};

	
	@SuppressWarnings("static-access")
	public Schedule() {
		setBackground(new Color(224, 255, 255));
		setSize(new Dimension(1000, 700));
		this.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton(months[Month]+"/"+year);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 28));
		this.add(btnNewButton, BorderLayout.NORTH);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setIcon(new ImageIcon("DPS_projec1\\..\\Back.png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		this.add(btnNewButton_1, BorderLayout.WEST);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Month==1){
					year--;
					Month=12;
				}
				else
					Month--;
			//	System.out.println(Month+" "+year);
				btnNewButton.setText(months[Month]+" "+year);
				addButtons(Month,year);
			}
		});
		
		
		JButton btnNewButton_2 = new JButton("\r\n");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setIcon(new ImageIcon("DPS_projec1\\..\\forward.jpg"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Month==12){
					year++;
					Month=1;
				}
				else
					Month++;
			
				btnNewButton.setText(months[Month]+" "+year);
				addButtons(Month,year);
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 28));
		this.add(btnNewButton_2, BorderLayout.EAST);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		this.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(6,7));
		
		calendar(Month,year);
		int i=0;
	
		for(String a: arr){
			barr[i] =new JButton("");
			barr[i].setEnabled(false);
			if(a!=""){
				barr[i].setText(a);
				barr[i].setEnabled(true);
				barr[i].setBackground(Color.YELLOW);
			}
			
			panel.add(barr[i]);
		//	System.out.println(i);
			barr[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Teams team = new Teams();
					team.setVisible(true);
					team.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
					
				}
			});
			i++;
		}
	

	}
	
	public void addButtons(int M,int y){
		calendar(M,y);
		
		int i=0;
		for(String a: arr){
			barr[i].setText("");
			barr[i].setEnabled(false);
			barr[i].setBackground(Color.white);
			
			if(!a.equals(""))
			{
				barr[i].setText(a);
				barr[i].setEnabled(true);
				barr[i].setBackground(Color.yellow);
			}
			//barr[i].setEnabled(true);
			//System.out.println(M+" "+y+" "+a+"p");
		i++;
			
		}
	}
	
	
	
	 public int day(int M, int D, int Y) {
	        int y = Y - (14 - M) / 12;
	        int x = y + y/4 - y/100 + y/400;
	        int m = M + 12 * ((14 - M) / 12) - 2;
	        int d = (D + x + (31*m)/12) % 7;
	        return d;
	    }

	    // return true if the given year is a leap year
	    public boolean isLeapYear(int year) {
	        if  ((year % 4 == 0) && (year % 100 != 0)) return true;
	        if  (year % 400 == 0) return true;
	        return false;
	    }

	    public void calendar(int M,int  Y) {
	    	
	    	
	    	for(int i=0;i<arr.length;i++)
	    		arr[i]="";
	        // months[i] = name of month i

	        // days[i] = number of days in month i
	        int[] days = {
	            0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
	        };

	        // check for leap year
	        if (M == 2 && isLeapYear(Y)) days[M] = 29;


	        // starting day
	        int d = day(M, 1, Y);
	       
	   
	        for (int i = 0; i < d; i++)
	        	{
	        	//System.out.print("   ");
	        	arr[i]="";
	        	}
	        d--;
	        for (int i = 1; i <= days[M]; i++) {
	        		arr[d+i]=""+i;
	            
	        }
	        
	       
}
	
	public static void main(String []a){
		
		new Schedule().setVisible(true);;
	}

}

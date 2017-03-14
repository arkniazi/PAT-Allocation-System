import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Questions extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblWhatIsYour_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Questions frame = new Questions();
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
	public Questions() {
		setTitle("Security Questions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 448);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWhatsTheName = new JLabel("Who was your childhood hero?");
		lblWhatsTheName.setBounds(139, 47, 260, 30);
		contentPane.add(lblWhatsTheName);
		
		textField = new JTextField();
		textField.setBounds(139, 104, 260, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblWhatIsYour = new JLabel("What is your lover's birthplace?");
		lblWhatIsYour.setBounds(139, 170, 260, 14);
		contentPane.add(lblWhatIsYour);
		
		textField_1 = new JTextField();
		textField_1.setBounds(139, 213, 260, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblWhatIsYour_1 = new JLabel("What is your lover's cell No.?");
		lblWhatIsYour_1.setBounds(139, 274, 226, 14);
		contentPane.add(lblWhatIsYour_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(139, 309, 260, 30);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(237, 369, 89, 30);
		contentPane.add(btnNewButton);
	}
}

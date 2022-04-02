import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class InsertCar extends JFrame {

	// global variables declarations
	private JFrame frame;
	private JPanel panel;
	private JPanel contentPane;
	private int xMouse;
	private int yMouse;
	private JTextField Title;
	private CustomInputField OwnerLastName;
	private CustomInputField OwnerFirstName;
	private CustomInputField OwnerAddress;
	private CustomInputField OwnerCarType;
	private CustomInputField TotalToPay;
	private CustomInputField Payed;
	final String LASTNAME = "Owner Last Name";
	final String FIRSTNAME = "Owner First Name";
	final String ADDRESS = "Owner Address";
	final String CARTYPE = "Owner Car Type";
	final String TOTPAY = "Total To Pay";
	final String PAYED = "Payed";
	private JTextArea ErrorField;
	final String[] FILLERS = { LASTNAME, FIRSTNAME, ADDRESS, CARTYPE, TOTPAY, PAYED };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertCar frame = new InsertCar();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InsertCar() {
		// Create a new frame
		frame = new JFrame();
		// remove the top bar
		frame.setUndecorated(true);
		// define the frame
		frame.setBounds(100, 100, 500, 500);
		// set icon image
		ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("IconCar.jpg"));
		frame.setIconImage(logo.getImage());
		// set position to middle of the screen
		frame.setLocationRelativeTo(null);
		// get mouse position when clicked ( relative to window)
		frame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});

		// get mouse position when dragged (relative to screen) and update frame postion
		frame.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				frame.setBounds(x - xMouse, y - yMouse, 500, 500);
			}
		});

		// ******************
		// JPanel definition
		// ******************

		// Create a new panel
		panel = new JPanel();
		// Set background color to black
		panel.setBackground(new Color(0, 0, 0));
		// set panel position
		panel.setBounds(0, 0, 800, 500);
		// add panel to frame
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		// **********************************
		// JLabel minimize button definition
		// **********************************

		// Create a new JLabel
		JLabel lbl_btn_minimize = new JLabel("");
		// remove border
		lbl_btn_minimize.setBorder(null);
		// set position
		lbl_btn_minimize.setBounds(437, 11, 26, 24);
		// get image
		Image img3 = (new ImageIcon(getClass().getClassLoader().getResource("MinimizeIcon.png"))).getImage();
		// rescale image
		Image imagescale3 = img3.getScaledInstance(lbl_btn_minimize.getWidth(), lbl_btn_minimize.getHeight(),
				Image.SCALE_SMOOTH);
		// set button image
		ImageIcon scaledIcon3 = new ImageIcon(imagescale3);
		lbl_btn_minimize.setIcon(scaledIcon3);
		// add to panel
		panel.add(lbl_btn_minimize);

		// when clicked, minimize frame
		lbl_btn_minimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(frame.ICONIFIED);
			}
		});

		// *******************************
		// JLabel close button definition
		// *******************************

		// Create a new JLabel
		JLabel lbl_btn_close = new JLabel("");
		// remove border
		lbl_btn_close.setBorder(null);
		// set position
		lbl_btn_close.setBounds(464, 11, 26, 24);
		// get image
		Image img2 = (new ImageIcon(getClass().getClassLoader().getResource("CloseIcon.png"))).getImage();
		// rescale image
		Image imagescale2 = img2.getScaledInstance(lbl_btn_close.getWidth(), lbl_btn_close.getHeight(),
				Image.SCALE_SMOOTH);
		// set button image
		ImageIcon scaledIcon2 = new ImageIcon(imagescale2);
		lbl_btn_close.setIcon(scaledIcon2);
		// add to panel
		panel.add(lbl_btn_close);

		// when clicked, pop-u window to confirm if you want to exit or no
		lbl_btn_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Custom button text
				Object[] options = { "Yes", "No" };
				int n = JOptionPane.showOptionDialog(frame, "Do you want to quit?", "Exit",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
				if (n == 0) {
					frame.dispose();
				}
			}
		});

		// *******************************
		// JTextField OwnerLastName definition
		// *******************************

		// Create a new JTextField
		OwnerLastName = new CustomInputField(LASTNAME);
		OwnerLastName.addFocusListener(OwnerLastName);
		// set position
		OwnerLastName.setBounds(70, 80, 360, 30);
		// add to panel
		panel.add(OwnerLastName);

		// ***********************
		// Separator 0 definition
		// ***********************

		JSeparator separator_0 = new JSeparator();
		separator_0.setBounds(70, 110, 360, 2);
		panel.add(separator_0);

		// *******************************
		// JTextField OwnerFirstName definition
		// *******************************

		// Create a new JTextField
		OwnerFirstName = new CustomInputField(FIRSTNAME);
		OwnerFirstName.addFocusListener(OwnerFirstName);
		// Set text format
		// set position
		OwnerFirstName.setBounds(70, 120, 360, 30);
		// add to panel
		panel.add(OwnerFirstName);

		// ***********************
		// Separator 1 definition
		// ***********************

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(70, 150, 360, 2);
		panel.add(separator_1);

		// *******************************
		// JTextField OwnerAddress definition
		// *******************************

		// Create a new JTextField
		OwnerAddress = new CustomInputField(ADDRESS);
		OwnerAddress.addFocusListener(OwnerAddress);
		// set position
		OwnerAddress.setBounds(70, 160, 360, 30);
		// add to panel
		panel.add(OwnerAddress);

		// ***********************
		// Separator 2 definition
		// ***********************

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(70, 190, 360, 2);
		panel.add(separator_2);

		// *******************************
		// JTextField OwnerCarType definition
		// *******************************

		// Create a new JTextField
		OwnerCarType = new CustomInputField(CARTYPE);
		OwnerCarType.addFocusListener(OwnerCarType);
		// set position
		OwnerCarType.setBounds(70, 200, 360, 30);
		// add to panel
		panel.add(OwnerCarType);

		// ***********************
		// Separator 3 definition
		// ***********************

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(70, 230, 360, 2);
		panel.add(separator_3);

		// *******************************
		// JTextField TotalToPay definition
		// *******************************

		// Create a new JTextField
		TotalToPay = new CustomInputField(TOTPAY);
		TotalToPay.addFocusListener(TotalToPay);
		// set position
		TotalToPay.setBounds(70, 240, 360, 30);
		// add to panel
		panel.add(TotalToPay);

		// ***********************
		// Separator 4 definition
		// ***********************

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(70, 270, 360, 2);
		panel.add(separator_4);

		// *******************************
		// JTextField Payed definition
		// *******************************

		// Create a new JTextField
		Payed = new CustomInputField(PAYED);
		Payed.addFocusListener(Payed);
		// set position
		Payed.setBounds(70, 280, 360, 30);
		// add to panel
		panel.add(Payed);

		// ***********************
		// Separator 5 definition
		// ***********************

		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(70, 310, 360, 2);
		panel.add(separator_5);

		// *******************************
		// JLabel insert button definition
		// *******************************

		// Create a new JLabel
		JLabel lbl_btn_Insert = new JLabel("");
		// remove border
		lbl_btn_Insert.setBorder(null);
		// set position
		lbl_btn_Insert.setBounds(186, 410, 128, 46);
		// get button image
		Image img = (new ImageIcon(getClass().getClassLoader().getResource("Insert_button.png"))).getImage();
		// rescale button image
		Image imagescale = img.getScaledInstance(lbl_btn_Insert.getWidth(), lbl_btn_Insert.getHeight(),
				Image.SCALE_SMOOTH);
		// set button image
		ImageIcon scaledIcon = new ImageIcon(imagescale);
		lbl_btn_Insert.setIcon(scaledIcon);
		// add to panel
		panel.add(lbl_btn_Insert);

		lbl_btn_Insert.addMouseListener(new MouseAdapter() {
			// when clicked, call InsertTreatmnt method
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					CustomInputField[] InputFieldsArray = { OwnerLastName, OwnerFirstName, OwnerAddress, OwnerCarType,
							TotalToPay, Payed };

					String[] InputForInsert = { OwnerLastName.getText(), OwnerFirstName.getText(),
							OwnerAddress.getText(), OwnerCarType.getText(), TotalToPay.getText(), Payed.getText() };

					// Check fields values
					int errorIndicator = CheckFields(InputFieldsArray);

					if (errorIndicator == 0) {
						int return1 = Functions.insertCarInspector(InputForInsert);
						if (return1 == 1) {
							ErrorField.setForeground(new Color(0, 255, 0));
							panel.setBackground(new Color(0, 255, 0));
							ErrorField.setText("New Record inserted!");
							for (int i = 0; i < InputFieldsArray.length; i++) {
								InputFieldsArray[i].setText(FILLERS[i]);
							}
						} else {
							ErrorField.setText(
									"Insertion error! Please contact IT support, indicating the values you tried to insert. ");
						}
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			// when pressed, change icon to pressed button
			@Override
			public void mousePressed(MouseEvent e) {
				// get button image
				Image img = (new ImageIcon(getClass().getClassLoader().getResource("Insert_button2.png"))).getImage();
				// rescale button image
				Image imagescale = img.getScaledInstance(lbl_btn_Insert.getWidth(), lbl_btn_Insert.getHeight(),
						Image.SCALE_SMOOTH);
				// set button image
				ImageIcon scaledIcon = new ImageIcon(imagescale);
				lbl_btn_Insert.setIcon(scaledIcon);
			}

			// when released, change icon to normal button
			@Override
			public void mouseReleased(MouseEvent e) {
				// get button image
				Image img = (new ImageIcon(getClass().getClassLoader().getResource("Insert_button.png"))).getImage();
				// rescale button image
				Image imagescale = img.getScaledInstance(lbl_btn_Insert.getWidth(), lbl_btn_Insert.getHeight(),
						Image.SCALE_SMOOTH);
				// set button image
				ImageIcon scaledIcon = new ImageIcon(imagescale);
				lbl_btn_Insert.setIcon(scaledIcon);
			}
		});

		// ***************************
		// Title Insert New Car
		// ***************************

		// Create a new JTextField
		Title = new JTextField();
		// Set text format
		Title.setForeground(new Color(0, 0, 0));
		Title.setFont(new Font("Lucida Bright", Font.BOLD | Font.ITALIC, 24));
		Title.setText("Insert New Car");
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setBorder(null);
		Title.setOpaque(false);
		Title.setEditable(false);
		frame.setVisible(true);
		// set position
		Title.setBounds(150, 20, 200, 36);
		// add to panel
		panel.add(Title);

		// ********************************
		// JTextArea ErrorField definition
		// ********************************

		// Create a new JTextArea
		ErrorField = new JTextArea();
		ErrorField.setWrapStyleWord(true);
		ErrorField.setLineWrap(true);
		// Set ErrorField format
		ErrorField.setEditable(false);
		ErrorField.setBorder(null);
		ErrorField.setOpaque(false);
		ErrorField.setFont(new Font("Perpetua Titling MT", Font.BOLD, 16));
		ErrorField.setForeground(new Color(204, 51, 51));
		// set position
		ErrorField.setBounds(70, 333, 360, 66);
		ErrorField.setColumns(10);
		panel.add(ErrorField);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 480, 478);
		panel.add(panel_1);

	}

	protected int CheckFields(InsertCar.CustomInputField[] InputFieldsArray) {
		// TODO Auto-generated method stub

		// initialize parameters
		int errorIndicator = 0;
		ErrorField.setText("");
		for (int i = 0; i < InputFieldsArray.length; i++) {
			InputFieldsArray[i].setForeground(new Color(0, 0, 0));
		}

		// check if all fields are filled
		for (int i = 0; i < InputFieldsArray.length; i++) {
			if (InputFieldsArray[i].getText().equals(FILLERS[i])) {
				InputFieldsArray[i].setForeground(new Color(255, 0, 0));
				errorIndicator = 1;
				ErrorField.setText("Please fill all the fields!");
			}
		}

		// check if owner last name is alphabetic
		if (errorIndicator == 0) {
			if (!OwnerLastName.getText().matches("^\\p{L}+(?: \\p{L}+)*$")) {
				InputFieldsArray[0].setForeground(new Color(255, 0, 0));
				ErrorField.setText("Owner Last Name should contain only letters!");
				errorIndicator = 1;
			}
		}
		// check if owner first name is alphabetic
		if (errorIndicator == 0) {
			if (!OwnerFirstName.getText().matches("^\\p{L}+(?: \\p{L}+)*$")) {
				InputFieldsArray[1].setForeground(new Color(255, 0, 0));
				ErrorField.setText("Owner First Name should contain only letters!");
				errorIndicator = 1;
			}
		}
		// check if owner address is alphanumeric
		if (errorIndicator == 0) {
			if (!OwnerAddress.getText().matches("^\\s*[\\da-zA-Z][\\da-zA-Z\\s]*$")) {
				InputFieldsArray[2].setForeground(new Color(255, 0, 0));
				ErrorField.setText("Owner address should contain only letters and digits!");
				errorIndicator = 1;
			}
		}
		// check if car type is alphanumeric
		if (errorIndicator == 0) {
			if (!OwnerCarType.getText().matches("^\\s*[\\da-zA-Z][\\da-zA-Z\\s]*$")) {
				InputFieldsArray[3].setForeground(new Color(255, 0, 0));
				ErrorField.setText("Owner car type should contain only letters and digits!");
				errorIndicator = 1;
			}
		}
		// check if "total to pay' is double
		if (errorIndicator == 0) {
			if (!TotalToPay.getText().matches(
					"[\\x00-\\x20]*[+-]?(NaN|Infinity|((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*")) {
				InputFieldsArray[4].setForeground(new Color(255, 0, 0));
				ErrorField.setText("Total To Pay should be a valid number! (use point for decimals)");
				errorIndicator = 1;
			}
		}
		// check if "Payed' is double
		if (errorIndicator == 0) {
			if (!Payed.getText().matches(
					"[\\x00-\\x20]*[+-]?(NaN|Infinity|((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*")) {
				InputFieldsArray[5].setForeground(new Color(255, 0, 0));
				ErrorField.setText("Payed should be a valid number! (use point for decimals)");
				errorIndicator = 1;
			}
		}
		if (errorIndicator == 1) {
			ErrorField.setForeground(new Color(255, 0, 0));
			panel.setBackground(new Color(255, 0, 0));
		}
		return errorIndicator;
	}

	public class CustomInputField extends JTextField implements FocusListener {
		private String name;

		public CustomInputField(String name) {
			this.name = name;
			// Set text format
			this.setText(name);
			this.setForeground(new Color(128, 128, 128));
			this.setFont(new Font("Tahoma", Font.BOLD, 14));
			this.setBorder(null);
			this.setOpaque(false);
		}

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			if (this.getText().equals(name)) {
				this.setText("");
				this.setForeground(new Color(0, 0, 0));
			}
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			if (this.getText().equals("")) {
				this.setText(name);
				this.setForeground(new Color(128, 128, 128));
			}
		}
	}
}

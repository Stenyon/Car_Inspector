import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login {

	// global variables declarations

	private JFrame frame;
	private JPanel panel;
	private JTextField lblUsername;
	private JTextField txtEnterUsername;
	private JTextField lblPassword;
	private JPasswordField txtEnterPassword;
	private JTextArea ErrorField;
	private int xMouse;
	private int yMouse;

//	___  ___      _       
//	|  \/  |     (_)      
//	| .  . | __ _ _ _ __  
//	| |\/| |/ _` | | '_ \ 
//	| |  | | (_| | | | | |
//	\_|  |_/\__,_|_|_| |_|

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// ******************
		// Frame definition
		// ******************

		// Create a new frame
		frame = new JFrame();
		// remove the top bar
		frame.setUndecorated(true);
		// define the frame
		frame.setBounds(100, 100, 800, 500);
		// set icon image
		ImageIcon logo = new ImageIcon(".\\img\\IconCar.jpg");
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
				frame.setBounds(x - xMouse, y - yMouse, 800, 500);
			}
		});

		// ******************
		// JPanel definition
		// ******************

		// Create a new panel
		panel = new JPanel();
		// Set background color to blue
		panel.setBackground(new Color(0, 191, 255));
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
		lbl_btn_minimize.setBounds(738, 11, 26, 24);
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
		lbl_btn_close.setBounds(764, 11, 26, 24);
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
					System.exit(0);
				}
			}
		});

		// ***************************
		// Label username definition
		// ***************************

		// Create a new JTextField
		lblUsername = new JTextField();
		// Set text format
		lblUsername.setForeground(new Color(0, 0, 0));
		lblUsername.setFont(new Font("Lucida Bright", Font.BOLD | Font.ITALIC, 24));
		lblUsername.setText("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setBorder(null);
		lblUsername.setOpaque(false);
		lblUsername.setEditable(false);
		// set position
		lblUsername.setBounds(338, 80, 220, 40);
		// add to panel
		panel.add(lblUsername);

		// *******************************
		// JTextField username definition
		// *******************************

		// Create a new JTextField
		txtEnterUsername = new JTextField();
		// Set text format
		txtEnterUsername.setForeground(new Color(128, 128, 128));
		txtEnterUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtEnterUsername.setText("Enter Username");
		txtEnterUsername.setBorder(null);
		txtEnterUsername.setOpaque(false);
		// set position
		txtEnterUsername.setBounds(338, 131, 336, 30);
		// add to panel
		panel.add(txtEnterUsername);

		// add the option to call loginTreatmnt method (the login button) by pressing
		// keyboard key "enter"
		txtEnterUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					loginTreatmnt();
				}
			}
		});

		// when click, remove the generic text "Enter Username" + change field font
		// color
		txtEnterUsername.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtEnterUsername.getText().equals("Enter Username")) {
					txtEnterUsername.setText("");
					txtEnterUsername.setForeground(new Color(0, 0, 0));
				}
			}
		});

		// when release, add the generic text "Enter Username" + change field font color
		// if no Username was provided
		txtEnterUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtEnterUsername.getText().equals("")) {
					txtEnterUsername.setText("Enter Username");
					txtEnterUsername.setForeground(new Color(128, 128, 128));
				}
			}
		});

		// ***********************
		// Separator 0 definition
		// ***********************

		JSeparator separator_0 = new JSeparator();
		separator_0.setBounds(338, 159, 336, 2);
		panel.add(separator_0);

		// ***************************
		// Label Username definition
		// ***************************

		// Create a new JTextField
		lblPassword = new JTextField();
		// Set text format
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Lucida Bright", Font.BOLD | Font.ITALIC, 24));
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setText("Password");
		lblPassword.setBorder(null);
		lblPassword.setOpaque(false);
		lblPassword.setEditable(false);
		// set position
		lblPassword.setBounds(338, 192, 220, 40);
		// add to panel
		panel.add(lblPassword);

		// ***********************************
		// JPasswordField Password definition
		// ***********************************

		// Create a new JPasswordField
		txtEnterPassword = new JPasswordField();
		// Set text format
		txtEnterPassword.setText("Enter Password");
		txtEnterPassword.setCaretColor(Color.BLACK);
		txtEnterPassword.setDisabledTextColor(Color.BLACK);
		txtEnterPassword.setSelectionColor(Color.LIGHT_GRAY);
		txtEnterPassword.setForeground(Color.DARK_GRAY);
		txtEnterPassword.setBorder(null);
		txtEnterPassword.setOpaque(false);
		// set position
		txtEnterPassword.setBounds(337, 240, 336, 30);
		// add to panel
		panel.add(txtEnterPassword);

		// add the option to call loginTreatmnt method (the login button) by pressing
		// keyboard key "enter"
		txtEnterPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					loginTreatmnt();
				}
			}
		});
		// when click, remove the generic text "Enter Password" + change field font
		// color
		txtEnterPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if ((new String(txtEnterPassword.getPassword())).equals("Enter Password")) {
					txtEnterPassword.setText("");
					txtEnterPassword.setForeground(new Color(0, 0, 0));
				}
			}
		});
		// when release, add the generic text "Enter Password" + change field font color
		// if no Password was provided
		txtEnterPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if ((new String(txtEnterPassword.getPassword())).equals("")) {
					txtEnterPassword.setText("Enter Password");
					txtEnterPassword.setForeground(new Color(128, 128, 128));
				}
			}
		});

		// ***********************
		// Separator 1 definition
		// ***********************

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(338, 270, 336, 2);
		panel.add(separator_1);

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
		ErrorField.setBounds(337, 419, 434, 56);
		ErrorField.setColumns(10);
		panel.add(ErrorField);

		// *******************************
		// JLabel login button definition
		// *******************************

		// Create a new JLabel
		JLabel lbl_btn_Login = new JLabel("");
		// remove border
		lbl_btn_Login.setBorder(null);
		// set position
		lbl_btn_Login.setBounds(474, 335, 128, 70);
		// get button image
		Image img = (new ImageIcon(getClass().getClassLoader().getResource("LoginButton.png"))).getImage();

		// rescale button image
		Image imagescale = img.getScaledInstance(lbl_btn_Login.getWidth(), lbl_btn_Login.getHeight(),
				Image.SCALE_SMOOTH);
		// set button image
		ImageIcon scaledIcon = new ImageIcon(imagescale);
		lbl_btn_Login.setIcon(scaledIcon);
		// add to panel
		panel.add(lbl_btn_Login);

		lbl_btn_Login.addMouseListener(new MouseAdapter() {
			// when clicked, call loginTreatmnt method
			@Override
			public void mouseClicked(MouseEvent e) {
				loginTreatmnt();
			}

			// when pressed, change icon to pressed button
			@Override
			public void mousePressed(MouseEvent e) {
				// get button image
				Image img = (new ImageIcon(getClass().getClassLoader().getResource("LoginButton2.png"))).getImage();
				// rescale button image
				Image imagescale = img.getScaledInstance(lbl_btn_Login.getWidth(), lbl_btn_Login.getHeight(),
						Image.SCALE_SMOOTH);
				// set button image
				ImageIcon scaledIcon = new ImageIcon(imagescale);
				lbl_btn_Login.setIcon(scaledIcon);
			}

			// when released, change icon to normal button
			@Override
			public void mouseReleased(MouseEvent e) {
				// get button image
				Image img = (new ImageIcon(getClass().getClassLoader().getResource("LoginButton.png"))).getImage();

				// rescale button image
				Image imagescale = img.getScaledInstance(lbl_btn_Login.getWidth(), lbl_btn_Login.getHeight(),
						Image.SCALE_SMOOTH);
				// set button image
				ImageIcon scaledIcon = new ImageIcon(imagescale);
				lbl_btn_Login.setIcon(scaledIcon);
			}
		});

		// ***************************************
		// JLabel "Car Inspector" text definition
		// ***************************************

		// Create a new JLabel
		JLabel lblCar = new JLabel("Car Inspector");
		// Set text format
		lblCar.setForeground(new Color(135, 206, 250));
		lblCar.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 24));
		lblCar.setHorizontalAlignment(SwingConstants.CENTER);
		// set position
		lblCar.setBounds(40, 80, 220, 40);
		// add to panel
		panel.add(lblCar);

		// *****************************
		// JLabel RightLabel definition
		// *****************************

		// Create a new JLabel
		JLabel RightLabel = new JLabel("");
		// Set JLabel format
		RightLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("LoginRight.png")));
		// set position
		RightLabel.setBounds(305, 11, 485, 478);
		// add to panel
		panel.add(RightLabel);

		// ****************************
		// JLabel LeftLabel definition
		// ****************************

		// Create a new JLabel
		JLabel LeftLabel = new JLabel("Enter Username");
		// Set JLabel format
		LeftLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LeftLabel.setBorder(null);
		LeftLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("LoginLeft.png")));
		// set position
		LeftLabel.setBounds(10, 11, 300, 478);
		// add to panel
		panel.add(LeftLabel);

	}

	public void loginTreatmnt() {
		// get userName and userPassword values from Frame
		String userName = txtEnterUsername.getText();
		String userPassword = new String(txtEnterPassword.getPassword());
		// check if the username and password was filled
		if ((userName.equals("Enter Username")) || (userName.equals("")) || userPassword.equals("Enter Password")
				|| userPassword.equals("")) {
			ErrorField.setText("Please fill username and password fields!");
			// Set background color to RED
			panel.setBackground(new Color(255, 0, 0));

		} else {
			try {
				// call the database to verify the authenticity of the user
				// returnCode = 0 --> user + password OK --> get next frame
				// returnCode = 1 --> incorrect user
				// returnCode = 2 --> incorrect password
				// returnCode = 3 --> account is blocked
				int[] UserCheck = Functions.userCheck(userName, userPassword);
				int returnCode = UserCheck[0];
				int attemptsLeft = 5 - UserCheck[1];
				int waitTimpLeft = UserCheck[1];
				switch (returnCode) {
				case 0:
					MainScreen MainScreen = new MainScreen();
					frame.setVisible(false);
					break;
				case 1:
					ErrorField.setText("Error! Incorrect username!");
					// Set background color to RED
					panel.setBackground(new Color(255, 0, 0));
					break;
				case 2:
					if (attemptsLeft > 0) {
						ErrorField.setText("Error! Incorrect password! you have " + attemptsLeft + " more attempts");
					} else {
						ErrorField.setText("Error! Incorrect password! Your account is suspended!");
					}
					// Set background color to RED
					panel.setBackground(new Color(255, 0, 0));
					break;
				case 3:
					ErrorField.setText("Error! Your account is blocked! \nPlease contact your supervisor or wait "
							+ waitTimpLeft + " seconds");
					// Set background color to RED
					panel.setBackground(new Color(255, 0, 0));
					break;
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}

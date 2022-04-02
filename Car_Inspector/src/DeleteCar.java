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

public class DeleteCar extends JFrame {

	// global variables declarations
	private JFrame frame;
	private JFrame frame1;
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
	private CustomInputField CarID;
	final String CARID = "Car ID";
	final String LASTNAME = "Owner Last Name";
	final String FIRSTNAME = "Owner First Name";
	final String ADDRESS = "Owner Address";
	final String CARTYPE = "Owner Car Type";
	final String TOTPAY = "Total To Pay";
	final String PAYED = "Payed";
	private JTextArea ErrorField;
	final String[] FILLERS = { LASTNAME, FIRSTNAME, ADDRESS, CARTYPE, TOTPAY, PAYED };
	private JTextField textField;
	private JTextField textField_1;
	int CarIdErrorIndicator = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteCar frame = new DeleteCar();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DeleteCar() {
		// Create a new frame
		frame = new JFrame();
		// remove the top bar
		frame.setUndecorated(true);
		// define the frame
		frame.setBounds(100, 100, 500, 550);
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
				frame.setBounds(x - xMouse, y - yMouse, 500, 550);
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
		panel.setBounds(0, 0, 800, 550);
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
		// JTextField CarID definition
		// *******************************

		CarID = new CustomInputField("Please insert here the Car ID");
		CarID.setForeground(new Color(0, 0, 0));
		CarID.setEditable(true);
		CarID.addFocusListener(CarID);
		// set position
		CarID.setBounds(120, 480, 260, 30);
		CarID.setHorizontalAlignment(SwingConstants.CENTER);
		// add to panel
		panel.add(CarID);

		// ***********************
		// Separator 6 definition
		// ***********************

		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(120, 510, 260, 2);
		panel.add(separator_6);

		CustomInputField[] DBFields = { OwnerLastName, OwnerFirstName, OwnerAddress, OwnerCarType, TotalToPay, Payed,
				CarID };

		// *******************************
		// JLabel FindId button definition
		// *******************************

		// Create a new JLabel
		JLabel lbl_btn_FindID = new JLabel("");
		// remove border
		lbl_btn_FindID.setBorder(null);
		// set position
		lbl_btn_FindID.setBounds(111, 410, 128, 46);
		// get button image
		Image img4 = (new ImageIcon(getClass().getClassLoader().getResource("FindID_button.png"))).getImage();
		// rescale button image
		Image imagescale4 = img4.getScaledInstance(lbl_btn_FindID.getWidth(), lbl_btn_FindID.getHeight(),
				Image.SCALE_SMOOTH);
		// set button image
		ImageIcon scaledIcon4 = new ImageIcon(imagescale4);
		lbl_btn_FindID.setIcon(scaledIcon4);
		// add to panel
		panel.add(lbl_btn_FindID);

		lbl_btn_FindID.addMouseListener(new MouseAdapter() {
			// when clicked, call InsertTreatmnt method
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					// search CarId in database
					// CarIdErrorIndicator[0] = 0 --> CarID present in DB
					// CarIdErrorIndicator[0] = 1 --> CarID absent in DB
					// CarIdErrorIndicator[0] = 9 --> Contact IT support
					String[] DatabaseReturnValues = Functions.SearchCarId(CarID.getText());
					CarIdErrorIndicator = Integer.parseInt(DatabaseReturnValues[0]);
					for (int i = 0; i < DBFields.length - 1; i++) {
						DBFields[i].setText(FILLERS[i]);
						DBFields[i].setEditable(false);
						DBFields[i].setForeground(new Color(128, 128, 128));
					}

					if (DatabaseReturnValues[0].equals("0")) {
						for (int i = 0; i < DBFields.length - 1; i++) {
							DBFields[i].setText(DatabaseReturnValues[i + 1]);
							DBFields[i].setForeground(new Color(0, 0, 0));
						}
						ErrorField.setText("See above the informations for CarId : " + CarID.getText());
						ErrorField.setForeground(new Color(0, 128, 0));
					} else if (DatabaseReturnValues[0].equals("1")) {
						if (CarID.getText().equals("Please insert here the Car ID")) {
							ErrorField.setText("Please fill the CarID field from below!");
						} else {
							ErrorField.setText("The CarID " + CarID.getText()
									+ " dosen't exist in database. Please insert a valid CarID! ");
						}
						ErrorField.setForeground(new Color(204, 51, 51));
					} else {
						ErrorField.setText(
								"Selection error! Please contact IT support, indicating the CarID values you tried to search. ");
						ErrorField.setForeground(new Color(204, 51, 51));
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					ErrorField.setText(
							"Selection error! Please contact IT support, indicating the CarID values you tried to search. ");
					ErrorField.setForeground(new Color(204, 51, 51));
				}
			}

			// when pressed, change icon to pressed button
			@Override
			public void mousePressed(MouseEvent e) {
				// get button image
				Image img = (new ImageIcon(getClass().getClassLoader().getResource("FindID_button2.png"))).getImage();
				// rescale button image
				Image imagescale = img.getScaledInstance(lbl_btn_FindID.getWidth(), lbl_btn_FindID.getHeight(),
						Image.SCALE_SMOOTH);
				// set button image
				ImageIcon scaledIcon = new ImageIcon(imagescale);
				lbl_btn_FindID.setIcon(scaledIcon);
			}

			// when released, change icon to normal button
			@Override
			public void mouseReleased(MouseEvent e) {
				// get button image
				Image img = (new ImageIcon(getClass().getClassLoader().getResource("FindID_button.png"))).getImage();
				// rescale button image
				Image imagescale = img.getScaledInstance(lbl_btn_FindID.getWidth(), lbl_btn_FindID.getHeight(),
						Image.SCALE_SMOOTH);
				// set button image
				ImageIcon scaledIcon = new ImageIcon(imagescale);
				lbl_btn_FindID.setIcon(scaledIcon);
			}
		});

		// *******************************
		// JLabel Delete button definition
		// *******************************

		// Create a new JLabel
		JLabel lbl_btn_Delete = new JLabel("");
		// remove border
		lbl_btn_Delete.setBorder(null);
		// set position
		lbl_btn_Delete.setBounds(253, 410, 128, 46);
		// get button image
		Image img = (new ImageIcon(getClass().getClassLoader().getResource("Delete_button.png"))).getImage();
		// rescale button image
		Image imagescale = img.getScaledInstance(lbl_btn_Delete.getWidth(), lbl_btn_Delete.getHeight(),
				Image.SCALE_SMOOTH);
		// set button image
		ImageIcon scaledIcon = new ImageIcon(imagescale);
		lbl_btn_Delete.setIcon(scaledIcon);
		// add to panel
		panel.add(lbl_btn_Delete);

		lbl_btn_Delete.addMouseListener(new MouseAdapter() {
			// when clicked, call UpdateTreatmnt method
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					// check if the select of CarId was succesfuly done
					if (CarIdErrorIndicator == 0) {
						int n = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete this record?",
								"Update Check", JOptionPane.YES_NO_OPTION);
						if (n == JOptionPane.YES_OPTION) {
							int return1 = Functions.DeleteCarInspector(DBFields[6]);
							if (return1 == 0) {
								ErrorField.setForeground(new Color(0, 255, 0));
								panel.setBackground(new Color(0, 255, 0));
								ErrorField.setText("Record Deleted!");
								for (int i = 0; i < DBFields.length - 1; i++) {
									DBFields[i].setText(FILLERS[i]);
								}
							} else {
								ErrorField.setText(
										"Delete error! Please contact IT support, indicating the values you tried to insert. ");
							}
						}
					} else {
						ErrorField.setText("Please find a valid CarID!");
						ErrorField.setForeground(new Color(204, 51, 51));
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
				Image img = (new ImageIcon(getClass().getClassLoader().getResource("Delete_button2.png"))).getImage();
				// rescale button image
				Image imagescale = img.getScaledInstance(lbl_btn_Delete.getWidth(), lbl_btn_Delete.getHeight(),
						Image.SCALE_SMOOTH);
				// set button image
				ImageIcon scaledIcon = new ImageIcon(imagescale);
				lbl_btn_Delete.setIcon(scaledIcon);
			}

			// when released, change icon to normal button
			@Override
			public void mouseReleased(MouseEvent e) {
				// get button image
				Image img = (new ImageIcon(getClass().getClassLoader().getResource("Delete_button.png"))).getImage();
				// rescale button image
				Image imagescale = img.getScaledInstance(lbl_btn_Delete.getWidth(), lbl_btn_Delete.getHeight(),
						Image.SCALE_SMOOTH);
				// set button image
				ImageIcon scaledIcon = new ImageIcon(imagescale);
				lbl_btn_Delete.setIcon(scaledIcon);
			}
		});

		// ***************************
		// Title Delete Car
		// ***************************

		// Create a new JTextField
		Title = new JTextField();
		// Set text format
		Title.setForeground(new Color(0, 0, 0));
		Title.setFont(new Font("Lucida Bright", Font.BOLD | Font.ITALIC, 24));
		Title.setText("Delete Car");
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
		ErrorField.setFont(new Font("Myanmar Text", Font.BOLD, 16));
		ErrorField.setForeground(new Color(204, 51, 51));
		// set position
		ErrorField.setBounds(70, 333, 360, 66);
		ErrorField.setColumns(10);
		panel.add(ErrorField);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 480, 528);
		panel.add(panel_1);

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
			this.setEditable(false);
		}

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			if (this.isEditable()) {
				if (this.getText().equals(name)) {
					this.setText("");
					this.setForeground(new Color(0, 0, 0));
				}
			}
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			if (this.getText().equals("")) {
				this.setText(name);
				if (!this.getText().equals("Please insert here the Car ID")) {
					this.setForeground(new Color(128, 128, 128));
				}
			}
		}
	}
}

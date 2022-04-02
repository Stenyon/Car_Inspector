import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainScreen extends JFrame {

	// global variables declarations
	private JFrame frame;
	private JPanel panel;
	private JTextField TitleCarInspector;
	private JTable table;
	private int xMouse;
	private int yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainScreen() {
		// ******************
		// Frame definition
		// ******************

		// Create a new frame
		frame = new JFrame();
		// remove the top bar
		frame.setUndecorated(true);
		// define the frame
		frame.setBounds(10, 10, 1200, 600);
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
				frame.setBounds(x - xMouse, y - yMouse, 1200, 600);
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

		// ************************************
		// JLabel Insert Car button definition
		// ************************************

		// Create a new JLabel
		JLabel lbl_btn_Insert = new JLabel("");
		// remove border
		lbl_btn_Insert.setBorder(null);
		// set position
		lbl_btn_Insert.setBounds(49, 58, 170, 70);
		// get button image
		Image img1 = (new ImageIcon(getClass().getClassLoader().getResource("Insert new car.png"))).getImage();
		// rescale button image
		Image imagescale1 = img1.getScaledInstance(lbl_btn_Insert.getWidth(), lbl_btn_Insert.getHeight(),
				Image.SCALE_SMOOTH);
		// set button image
		ImageIcon scaledIcon1 = new ImageIcon(imagescale1);
		lbl_btn_Insert.setIcon(scaledIcon1);
		// add to panel
		panel.add(lbl_btn_Insert);

		lbl_btn_Insert.addMouseListener(new MouseAdapter() {
			// when clicked, call InsertTreatmnt method
			@Override
			public void mouseClicked(MouseEvent e) {
				new InsertCar();
			}

			// when pressed, change icon to pressed button
			@Override
			public void mousePressed(MouseEvent e) {
				// get button image
				Image img = (new ImageIcon(getClass().getClassLoader().getResource("Insert new car pressed.png"))).getImage();
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
				Image img = (new ImageIcon(getClass().getClassLoader().getResource("Insert new car.png"))).getImage();
				// rescale button image
				Image imagescale = img.getScaledInstance(lbl_btn_Insert.getWidth(), lbl_btn_Insert.getHeight(),
						Image.SCALE_SMOOTH);
				// set button image
				ImageIcon scaledIcon = new ImageIcon(imagescale);
				lbl_btn_Insert.setIcon(scaledIcon);
			}
		});

		// ************************************
		// JLabel Update Car button definition
		// ************************************

		// Create a new JLabel
		JLabel lbl_btn_Update = new JLabel("");
		// remove border
		lbl_btn_Update.setBorder(null);
		// set position
		lbl_btn_Update.setBounds(49, 158, 170, 70);
		// get button image
		Image img2 = (new ImageIcon(getClass().getClassLoader().getResource("Update car.png"))).getImage();
		// rescale button image
		Image imagescale2 = img2.getScaledInstance(lbl_btn_Update.getWidth(), lbl_btn_Update.getHeight(),
				Image.SCALE_SMOOTH);
		// set button image
		ImageIcon scaledIcon2 = new ImageIcon(imagescale2);
		lbl_btn_Update.setIcon(scaledIcon2);
		// add to panel
		panel.add(lbl_btn_Update);

		lbl_btn_Update.addMouseListener(new MouseAdapter() {
			// when clicked, call InsertTreatmnt method
			@Override
			public void mouseClicked(MouseEvent e) {
				new UpdateCar();
			}

			// when pressed, change icon to pressed button
			@Override
			public void mousePressed(MouseEvent e) {
				// get button image
				Image img = (new ImageIcon(getClass().getClassLoader().getResource("Update car pressed.png"))).getImage();
				// rescale button image
				Image imagescale = img.getScaledInstance(lbl_btn_Update.getWidth(), lbl_btn_Update.getHeight(),
						Image.SCALE_SMOOTH);
				// set button image
				ImageIcon scaledIcon = new ImageIcon(imagescale);
				lbl_btn_Update.setIcon(scaledIcon);
			}

			// when released, change icon to normal button
			@Override
			public void mouseReleased(MouseEvent e) {
				// get button image
				Image img = (new ImageIcon(getClass().getClassLoader().getResource("Update car.png"))).getImage();
				// rescale button image
				Image imagescale = img.getScaledInstance(lbl_btn_Update.getWidth(), lbl_btn_Update.getHeight(),
						Image.SCALE_SMOOTH);
				// set button image
				ImageIcon scaledIcon = new ImageIcon(imagescale);
				lbl_btn_Update.setIcon(scaledIcon);
			}
		});
		// ************************************
		// JLabel Delete Car button definition
		// ************************************

		// Create a new JLabel
		JLabel lbl_btn_Delete = new JLabel("");
		// remove border
		lbl_btn_Delete.setBorder(null);
		// set position
		lbl_btn_Delete.setBounds(49, 258, 170, 70);
		// get button image
		Image img3 = (new ImageIcon(getClass().getClassLoader().getResource("Delete car.png"))).getImage();
		// rescale button image
		Image imagescale3 = img3.getScaledInstance(lbl_btn_Delete.getWidth(), lbl_btn_Delete.getHeight(),
				Image.SCALE_SMOOTH);
		// set button image
		ImageIcon scaledIcon3 = new ImageIcon(imagescale3);
		lbl_btn_Delete.setIcon(scaledIcon3);
		// add to panel
		panel.add(lbl_btn_Delete);

		lbl_btn_Delete.addMouseListener(new MouseAdapter() {
			// when clicked, call InsertTreatmnt method
			@Override
			public void mouseClicked(MouseEvent e) {
				new DeleteCar();
			}

			// when pressed, change icon to pressed button
			@Override
			public void mousePressed(MouseEvent e) {
				// get button image
				Image img = (new ImageIcon(getClass().getClassLoader().getResource("Delete car pressed.png"))).getImage();
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
				Image img = (new ImageIcon(getClass().getClassLoader().getResource("Delete car.png"))).getImage();
				// rescale button image
				Image imagescale = img.getScaledInstance(lbl_btn_Delete.getWidth(), lbl_btn_Delete.getHeight(),
						Image.SCALE_SMOOTH);
				// set button image
				ImageIcon scaledIcon = new ImageIcon(imagescale);
				lbl_btn_Delete.setIcon(scaledIcon);
			}
		});
		// ************************************
		// JLabel Refresh button definition
		// ************************************

		// Create a new JLabel
		JLabel lbl_btn_Refresh = new JLabel("");
		// remove border
		lbl_btn_Refresh.setBorder(null);
		// set position
		lbl_btn_Refresh.setBounds(49, 458, 170, 70);
		// get button image
		Image img6 = (new ImageIcon(getClass().getClassLoader().getResource("Refresh.png"))).getImage();
		// rescale button image
		Image imagescale6 = img6.getScaledInstance(lbl_btn_Refresh.getWidth(), lbl_btn_Refresh.getHeight(),
				Image.SCALE_SMOOTH);
		// set button image
		ImageIcon scaledIcon6 = new ImageIcon(imagescale6);
		lbl_btn_Refresh.setIcon(scaledIcon6);
		// add to panel
		panel.add(lbl_btn_Refresh);

		lbl_btn_Refresh.addMouseListener(new MouseAdapter() {
			// when clicked, call InsertTreatmnt method
			@Override
			public void mouseClicked(MouseEvent e) {
				refreshTable();
			}

			// when pressed, change icon to pressed button
			@Override
			public void mousePressed(MouseEvent e) {
				// get button image
				Image img = (new ImageIcon(getClass().getClassLoader().getResource("Refresh_pressed.png"))).getImage();
				// rescale button image
				Image imagescale = img.getScaledInstance(lbl_btn_Refresh.getWidth(), lbl_btn_Refresh.getHeight(),
						Image.SCALE_SMOOTH);
				// set button image
				ImageIcon scaledIcon = new ImageIcon(imagescale);
				lbl_btn_Refresh.setIcon(scaledIcon);
			}

			// when released, change icon to normal button
			@Override
			public void mouseReleased(MouseEvent e) {
				// get button image
				Image img = (new ImageIcon(getClass().getClassLoader().getResource("Refresh.png"))).getImage();
				// rescale button image
				Image imagescale = img.getScaledInstance(lbl_btn_Refresh.getWidth(), lbl_btn_Refresh.getHeight(),
						Image.SCALE_SMOOTH);
				// set button image
				ImageIcon scaledIcon = new ImageIcon(imagescale);
				lbl_btn_Refresh.setIcon(scaledIcon);
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
		lbl_btn_close.setBounds(1164, 11, 26, 24);
		// get image
		Image img4 = (new ImageIcon(getClass().getClassLoader().getResource("CloseIcon.png"))).getImage();
		// rescale image
		Image imagescale4 = img4.getScaledInstance(lbl_btn_close.getWidth(), lbl_btn_close.getHeight(),
				Image.SCALE_SMOOTH);
		// set button image
		ImageIcon scaledIcon4 = new ImageIcon(imagescale4);
		lbl_btn_close.setIcon(scaledIcon4);
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

		// **********************************
		// JLabel minimize button definition
		// **********************************

		// Create a new JLabel
		JLabel lbl_btn_minimize = new JLabel("");
		// remove border
		lbl_btn_minimize.setBorder(null);
		// set position
		lbl_btn_minimize.setBounds(1138, 11, 26, 24);
		// get image
		Image img5 = (new ImageIcon(getClass().getClassLoader().getResource("MinimizeIcon.png"))).getImage();
		// rescale image
		Image imagescale5 = img5.getScaledInstance(lbl_btn_minimize.getWidth(), lbl_btn_minimize.getHeight(),
				Image.SCALE_SMOOTH);
		// set button image
		ImageIcon scaledIcon5 = new ImageIcon(imagescale5);
		lbl_btn_minimize.setIcon(scaledIcon5);
		// add to panel
		panel.add(lbl_btn_minimize);

		// when clicked, minimize frame
		lbl_btn_minimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(frame.ICONIFIED);
			}
		});
		// ***************************
		// Title CarInspector
		// ***************************

		// Create a new JTextField
		TitleCarInspector = new JTextField();
		// Set text format
		TitleCarInspector.setForeground(new Color(0, 0, 0));
		TitleCarInspector.setFont(new Font("Lucida Bright", Font.BOLD | Font.ITALIC, 24));
		TitleCarInspector.setText("Car Inspector");
		TitleCarInspector.setHorizontalAlignment(SwingConstants.CENTER);
		TitleCarInspector.setBorder(null);
		TitleCarInspector.setOpaque(false);
		TitleCarInspector.setEditable(false);
		// set position
		TitleCarInspector.setBounds(500, 11, 200, 36);
		// add to panel
		panel.add(TitleCarInspector);

		// ***************************
		// Scroll Pane (right pane)
		// ***************************

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(270, 51, 920, 538);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		refreshTable();
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 51, 250, 538);
		panel.add(panel_1);

		frame.setVisible(true);

	}

	public void refreshTable() {
		// connect To Database

		Connection con;
		DefaultTableModel model = (new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		model.addColumn("Car ID");
		model.addColumn("Last Name");
		model.addColumn("First Name");
		model.addColumn("Address");
		model.addColumn("Car Type");
		model.addColumn("Total To Pay");
		model.addColumn("Payed");
		model.addColumn("DateCre");
		try {
			con = Functions.connectDatabase();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM CarInspector");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				model.addRow(new Object[] { result.getInt("CarID"), result.getString("OwnerLastName"),
						result.getString("OwnerFirstName"), result.getString("OwnerAddress"),
						result.getString("OwnerCarType"), result.getFloat("TotalToPay"), result.getFloat("Payed"),
						result.getString("DateCre") });

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Connection Error");
			e.printStackTrace();
		}
		// define query
		table.setModel(model);
		table.setAutoResizeMode(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
		table.getColumnModel().getColumn(3).setPreferredWidth(250);
		table.getColumnModel().getColumn(4).setPreferredWidth(135);
		table.getColumnModel().getColumn(5).setPreferredWidth(75);
		table.getColumnModel().getColumn(6).setPreferredWidth(65);
		table.getColumnModel().getColumn(7).setPreferredWidth(127);
	}
}

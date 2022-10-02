package MySQL;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class USER_PASS extends JFrame implements ActionListener {
	static File file;
	private JPanel contentPane;
	private JTextField ust;
	private JPasswordField passt;
	JButton reg, log;
	static JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new USER_PASS();
					frame.setTitle("Login Page");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public USER_PASS() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel user = new JLabel("Username : ");
		user.setFont(new Font("Tahoma", Font.PLAIN, 13));
		user.setBounds(68, 63, 72, 20);
		contentPane.add(user);

		JLabel pass = new JLabel("Password  : ");
		pass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pass.setBounds(68, 108, 72, 20);
		contentPane.add(pass);

		ust = new JTextField();
		ust.setBounds(203, 57, 158, 26);
		contentPane.add(ust);
		ust.setColumns(10);

		passt = new JPasswordField();
		passt.setColumns(10);
		passt.setBounds(203, 106, 158, 27);
		contentPane.add(passt);

		log = new JButton("login");
		log.setFont(new Font("Sitka Small", Font.ITALIC, 10));
		log.setBounds(94, 186, 85, 21);
		contentPane.add(log);

		reg = new JButton("Register");
		reg.setFont(new Font("Sitka Small", Font.ITALIC, 10));
		reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		reg.setBounds(225, 186, 85, 21);
		contentPane.add(reg);
		JLabel lblNewLabel = new JLabel("Login Page");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(121, 10, 139, 28);
		contentPane.add(lblNewLabel);
		log.addActionListener(this);
		reg.addActionListener(this);
		File file = new File("src\\file\\pass.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == reg) {
			try {
				frame.dispose();
				register register = new register();
				register.setVisible(true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == log) {
			boolean ok=true;
			try {
				String user = ust.getText();
				String pass = passt.getText();
				file = new File("src\\file\\pass.txt");
				if (!file.exists()) {
					file.createNewFile();
				}
				Scanner sc = new Scanner(file);
				sc.useDelimiter("[,\n]");
				while (sc.hasNext()) {
					String nameString = sc.next();
					String usereString = sc.next();
					String passString = sc.next();
					if (usereString.equals(user) && passString.equals(pass)) {
						frame.dispose();
						GUI s = new GUI();
						s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						s.setTitle("Student Management");
						s.setBounds(10, 20, 800, 700);
						s.setVisible(true);
						ok=false;
					}
				}
				if(ok) {
					JOptionPane.showMessageDialog(null, "Invalid info....");
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}

		}
	}
}

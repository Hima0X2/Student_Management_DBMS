package MySQL;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class register extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField namet;
	private JTextField ust;
	JButton create;
	private JTextField passt;
	private JLabel pass_1;
	private JLabel log;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register frame = new register();
					frame.setTitle("Registration Page");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public register() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel user = new JLabel("Name        : ");
		user.setFont(new Font("Tahoma", Font.PLAIN, 13));
		user.setBounds(68, 58, 85, 20);
		contentPane.add(user);

		JLabel pass = new JLabel("Username  : ");
		pass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pass.setBounds(68, 108, 85, 20);
		contentPane.add(pass);

		namet = new JTextField();
		namet.setBounds(203, 57, 158, 26);
		contentPane.add(namet);
		namet.setColumns(10);

		ust = new JTextField();
		ust.setColumns(10);
		ust.setBounds(203, 106, 158, 27);
		contentPane.add(ust);

		create = new JButton("Create");
		create.setFont(new Font("Sitka Small", Font.ITALIC, 10));
		create.setBounds(160, 217, 85, 21);
		contentPane.add(create);
		JLabel lblNewLabel = new JLabel("Register Page");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(121, 10, 139, 28);
		contentPane.add(lblNewLabel);

		passt = new JTextField();
		passt.setColumns(10);
		passt.setBounds(203, 154, 158, 27);
		contentPane.add(passt);

		pass_1 = new JLabel("Password  : ");
		pass_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pass_1.setBounds(68, 156, 72, 20);
		contentPane.add(pass_1);
		create.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == create) {
			try {
				String name = namet.getText();
				String user = ust.getText();
				String pass = passt.getText();
				if (name.equals("") || user.equals("") || pass.equals("")) {
					JOptionPane.showMessageDialog(null, "Plz fill up all the information");
				} else {
					File file = new File("src\\file\\pass.txt");
					FileWriter myWriter = new FileWriter(file, true);
					myWriter.write(name + "," + user + "," + pass + "\n");
					myWriter.close();
					JOptionPane.showMessageDialog(null, "Created Successfully..");
					this.dispose();
					USER_PASS frame = new USER_PASS();
					frame.setTitle("Login Page");
					frame.setVisible(true);
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}

package MySQL;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class GUI extends JFrame implements ActionListener {
	String[] cols = {"ID", "Name", "Roll", "GPA", "Number" };
	static String[] rows = new String[5];
	JLabel gpa, roll, name, number,id;
	JTextField idt,gpat, rollt, namet, numbert;
	JButton add, dlt, upd, cls, exp,imp;
	JTable table;
	JScrollPane pane;
	static DefaultTableModel model;
	GUI() {
		rows[0] = "";
		rows[1] = "";
		rows[2] = "";
		rows[3] = "";
		Container c = this.getContentPane();
		c.setLayout(null);
		//c.setBackground(Color.white);
		Font f = new Font("Arial", Font.BOLD, 15);
		JLabel label = new JLabel("Student Management System");
		label.setFont(f);
		label.setBounds(140, 10, 250, 50);
		c.add(label);
		id = new JLabel("ID");
		id.setBounds(10, 80, 140, 30);
		c.add(id);
		idt = new JTextField();
		idt.setBounds(110, 80, 200, 30);
		c.add(idt);
		name = new JLabel("Name");
		name.setBounds(10, 80+50, 140, 30);
		c.add(name);
		namet = new JTextField();
		namet.setBounds(110, 80+50, 200, 30);
		c.add(namet);
		roll = new JLabel("Roll");
		roll.setBounds(10, 130+50, 140, 30);
		c.add(roll);
		rollt = new JTextField();
		rollt.setBounds(110, 130+50, 200, 30);
		c.add(rollt);
		gpa = new JLabel("GPA");
		gpa.setBounds(10, 180+50, 140, 30);
		c.add(gpa);
		gpat = new JTextField();
		gpat.setBounds(110, 180+50, 200, 30);
		c.add(gpat);
		number = new JLabel("Number");
		number.setBounds(10, 230+50, 140, 30);
		c.add(number);
		numbert = new JTextField();
		numbert.setBounds(110, 230+50, 200, 30);
		c.add(numbert);
		add = new JButton("ADD");
		add.setBounds(400, 80, 100, 30);
		c.add(add);
		dlt = new JButton("DELETE");
		dlt.setBounds(400, 130, 100, 30);
		c.add(dlt);
		upd = new JButton("UPDATE");
		upd.setBounds(400, 180, 100, 30);
		c.add(upd);
		cls = new JButton("CLEAR");
		cls.setBounds(400, 230, 100, 30);
		c.add(cls);
		exp = new JButton("Export");
		exp.setBounds(200, 320, 100, 30);
		c.add(exp);
		imp = new JButton("Import");
		imp.setBounds(400, 320, 100, 30);
		c.add(imp);
		table = new JTable();
		model = new DefaultTableModel();
		model.setColumnIdentifiers(cols);
		table.setModel(model);
		table.setSelectionBackground(Color.black);
		table.setSelectionForeground(Color.white);
		table.setRowHeight(30);
		JScrollPane pane = new JScrollPane(table);
		pane.setBackground(Color.black);
		pane.setBounds(8, 360, 740, 265);
		c.add(pane);
		imp.addActionListener(this);
		exp.addActionListener(this);
		add.addActionListener(this);
		cls.addActionListener(this);
		dlt.addActionListener(this);
		upd.addActionListener(this);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				int number = table.getSelectedRow();
				String idString=model.getValueAt(number, 0).toString();
				String nameString = model.getValueAt(number, 1).toString();
				String rollString = model.getValueAt(number, 2).toString();
				String gpaString = model.getValueAt(number, 3).toString();
				String numberString = model.getValueAt(number, 4).toString();
				idt.setText(idString);
				namet.setText(nameString);
				rollt.setText(rollString);
				gpat.setText(gpaString);
				numbert.setText(numberString);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {
			rows[0]=idt.getText();
			rows[1] = namet.getText();
			rows[2] = rollt.getText();
			rows[3] = gpat.getText();
			rows[4] = numbert.getText();
			if (rows[0] == "" || rows[1] == "" || rows[2] == "" || rows[3] == ""||rows[4]=="") {
				JOptionPane.showMessageDialog(null, "Something went wrong.");
			} else {
				Student s = new Student(Integer.parseInt(rows[0]),Integer.parseInt(rows[2]), rows[1], Integer.parseInt(rows[4]), Double.parseDouble(rows[3]));
				if (Database.insertStudenttoDB(s)) {
					model.addRow(rows);
					JOptionPane.showMessageDialog(null, "student is added successfully....");
					idt.setText("");
					namet.setText("");
					rollt.setText("");
					gpat.setText("");
					numbert.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Something went wrong.Try again...");
				}
			}
		} else if (e.getSource() == cls) {
			idt.setText("");
			namet.setText("");
			rollt.setText("");
			gpat.setText("");
			numbert.setText("");
		} else if (e.getSource() == dlt) {
			int numberofrow = table.getSelectedRow();
			if (numberofrow >= 0) {
				//System.out.println(rollt.getText());
				int id = Integer.parseInt(idt.getText());
				if (Database.deleteStudenttoDB(id)) {
					model.removeRow(numberofrow);
					JOptionPane.showMessageDialog(null, "Deleted successfully....");
					idt.setText("");
					namet.setText("");
					rollt.setText("");
					gpat.setText("");
					numbert.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Something went wrong.Try again...");
				}
			} else {
				JOptionPane.showMessageDialog(null, "No row has been selected or No row Exist");
			}
		} 
		else if (e.getSource() == upd) {
			int number = table.getSelectedRow();
			String idString=idt.getText();
			String nameString = namet.getText();
			String rollString = rollt.getText();
			String gpaString = gpat.getText();
			String numberString = numbert.getText();
			Student s=new Student(Integer.parseInt(idString),Integer.parseInt(rollString), nameString, Integer.parseInt(numberString), Double.parseDouble(gpaString));
			model.setValueAt(nameString, number, 1);
			model.setValueAt(rollString, number, 2);
			model.setValueAt(gpaString, number, 3);
			model.setValueAt(numberString, number,4);
			model.setValueAt(idString, number, 0);
			if (Database.update(s)) {
				JOptionPane.showMessageDialog(null, "Record is updated successfully....");
				idt.setText("");
				namet.setText("");
				rollt.setText("");
				gpat.setText("");
				numbert.setText("");
			} else {
				System.out.println(s);
				JOptionPane.showMessageDialog(null, "Something went wrong.Try again...");
			}
		} else if (e.getSource() == exp) {
			JFileChooser fchoose = new JFileChooser();
			int option = fchoose.showSaveDialog(GUI.this);
			if (option == JFileChooser.APPROVE_OPTION) {
				String name = fchoose.getSelectedFile().getName();
				String path = fchoose.getSelectedFile().getParentFile().getPath();
				String file = path + "\\" + name + ".xls";
				export(table, new File(file));
			}
		}
		else if (e.getSource() == imp) {
			ArrayList a=new ArrayList<>();
			Database.Import();
		}
	}

	public void export(JTable table, File file) {
		try {
			TableModel m = table.getModel();
			FileWriter fw = new FileWriter(file);

			for (int i = 0; i < m.getColumnCount(); i++) {
				fw.write(m.getColumnName(i) + "\t");
			}

			fw.write("\n");

			for (int i = 0; i < m.getRowCount(); i++) {
				for (int j = 0; j < m.getColumnCount(); j++) {
					fw.write(m.getValueAt(i, j).toString() + "\t");
				}
				fw.write("\n");
			}

			fw.close();
			System.out.println("Export Successfully....");
			System.exit(0);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) throws Exception {
		GUI s = new GUI();
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		s.setTitle("Student Management");
		s.setBounds(10, 20, 800, 700);
		s.setVisible(true);
	}
}

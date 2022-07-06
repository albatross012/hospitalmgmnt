import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Prescription {
	Prescriptionform pf = new Prescriptionform();
}

class Prescriptionform extends JFrame implements ActionListener{
JTextField	tf1 = new JTextField();
JTextField	tf2 = new JTextField();
JTextField	tf3 = new JTextField();
JTextField	tf4 = new JTextField();
JButton b=new JButton("ENTER");
JButton b1=new JButton("BACK");
public Prescriptionform( ) {
JLabel l1,l2,l3,l4;
l1 = new JLabel("Prescription ID");
l2 = new JLabel("Patient ID");
l3 = new JLabel("Medicines");
l4 = new JLabel("Dose");
l1.setBounds(50,100,200, 40);
l2.setBounds(50,150,200, 40);
l3.setBounds(50,200,200, 40);
l4.setBounds(50,250,200, 40); 
tf1.setBounds(140,100,200, 40);
tf2.setBounds(140,150,200, 40);
tf3.setBounds(140,200,200, 40);		
tf4.setBounds(140,250,200, 40);	
b.setBounds(140,300,100, 40);
b1.setBounds(250,300,100,40);
add(l1);
add(tf1);
add(l2);
add(tf2);
add(l3);
add(tf3);
add(l4);
add(tf4);
add(b);
add(b1);	
setSize(400,500);
b.addActionListener(this);
b1.addActionListener(this);
setLayout(null); 
setVisible(true);
}
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==b)
		
	{
		try {
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","midhun");
			PreparedStatement Pstatement=connection.prepareStatement("insert into pres(pr_id,p_id,medicines,dose) values(?,?,?,?) ");
			Pstatement.setString(1,tf1.getText());
			Pstatement.setString(2,tf2.getText());
			Pstatement.setString(3,tf3.getText());
			Pstatement.setString(4,tf4.getText());
			Pstatement.executeUpdate();
			JOptionPane.showMessageDialog(null,"Data Added Successfully");
		} catch (SQLException e1)
		{ 
			JOptionPane.showMessageDialog(null, e1);
		}
		if(e.getSource()==b1)
		{

			dispose();
		}
	}
	new Homeform();
	dispose();
}
}


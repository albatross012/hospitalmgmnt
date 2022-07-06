import javax.swing.*;  
import java.awt.event.*;  
import java.sql.*;


public class Doctor  {
	
Doctorform df = new Doctorform();

}
class Doctorform extends JFrame implements ActionListener{
JTextField tf1 = new JTextField();
JTextField tf2 = new JTextField();
JTextField tf3 = new JTextField();
JButton b= new JButton("ENTER");
JButton b1=new JButton("BACK");
public Doctorform( ) {
JLabel l1,l2,l3;
l1 = new JLabel("Doctor ID");
l2 = new JLabel("NAME");
l3 = new JLabel("SPECIALIZATION");
l1.setBounds(50,100,200, 40);
l2.setBounds(50,150,200, 40);
l3.setBounds(10,200,200, 40);
b.setBounds(130,250,100, 40);
b1.setBounds(250,250,100, 40);
add(l1);
add(tf1);
add(l2);
add(tf2);
add(l3);
add(tf3);
add(b);
add(b1);
tf1.setBounds(130,100,200, 40);
tf2.setBounds(130,150,200, 40);
tf3.setBounds(130,200,200, 40);				
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
			PreparedStatement Pstatement=connection.prepareStatement("insert into doctor(d_id,name,specialization) values(?,?,?) ");
			Pstatement.setString(1,tf1.getText());
			Pstatement.setString(2,tf2.getText());
			Pstatement.setString(3,tf3.getText());
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
	new Home();
	dispose();
}
}
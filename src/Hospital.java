import javax.swing.*;  
import java.awt.event.*;  
import java.sql.*;

public class Hospital {  
public static void main(String[] args) {  
Hospitalform hf = new Hospitalform();
}  
}

class Hospitalform extends JFrame implements ActionListener{
JTextField	tf1 = new JTextField();
JTextField	tf2 = new JPasswordField();
JButton b=new JButton("LOGIN");
JButton b1=new JButton("RESET");
public Hospitalform() {
JLabel l1,l2,l3,l4;
l1 = new JLabel("Username");
l2 = new JLabel("Password");
l3 = new JLabel("HOSPITAL MANAGEMENT SYSTEM") ;
l4 = new JLabel("Login Page");
l1.setBounds(50,100,200, 40);
l2.setBounds(50,150,200, 40);
l3.setBounds(75,10,300,60);
l4.setBounds(150,50,200,40);
b.setBounds(130,200,75,40);
b1.setBounds(250,200,75,40);
tf1.setBounds(130,100,200,40);
tf2.setBounds(130,150,200,40);
add(b); 
add(b1);
add(l1);
add(tf1);
add(l2);
add(l3);
add(l4);
add(tf2);
setSize(400,500);
setLayout(null); 
b.addActionListener(this);
b1.addActionListener(this);
setVisible(true);
}
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==b)
		
	{
		try {
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","midhun");
			Statement stmt = connection.createStatement();
            String query = "select * from login where user='" + tf1.getText()
                    + "' and password='" + tf2.getText() + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next())
            {
                System.out.println("Username" + rs.getString("user"));

                JOptionPane.showMessageDialog(null, "Login Successful !");
                new Homeform();
        		dispose();
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "            Login Failed!!! \n incorrect username or password");
            }
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "INVALID ENTRY");

        }
	
    }
    if(e.getSource()== b1)
		{
		
			tf1.setText("");
			tf2.setText("");
		}
}
}


	

import java.awt.BorderLayout;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Patient {
	Pateintform pf = new Pateintform();
}
class Pateintform extends JFrame implements ActionListener{
	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JTextField tf3 = new JTextField();
	JTextField tf4 = new JTextField();
	JTextField tf5 = new JTextField();
	JTextField tf6 = new JTextField();
	JTextField tf7 = new JTextField();
	JButton b=new JButton("ENTER");
	JButton b1=new JButton("VIEW");
	JButton b2=new JButton("BACK");
public Pateintform() {
JLabel l1,l2,l3,l4,l5,l6,l7;
l1 = new JLabel("Patient ID");
l2 = new JLabel("Name");
l3 = new JLabel("Age");
l4 = new JLabel("Gender");
l5 = new JLabel("Blood Group");
l6 = new JLabel("Prs.ID");
l7 = new JLabel("Phone no");
l1.setBounds(50,50,200, 40);
l2.setBounds(50,100,200, 40);
l3.setBounds(50,150,200, 40);
l4.setBounds(50,200,200, 40);
l5.setBounds(50,250,200, 40);
l6.setBounds(50,300,200, 40);
l7.setBounds(50,350,200, 40);

b.setBounds(130,400,90, 30);
b1.setBounds(250,400,90,30);
b2.setBounds(200,440,90,30);
b.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e)
	{
		new Homeform();
		dispose();
	}
});
add(l1);
add(tf1);
add(l2);
add(tf2);
add(l3);
add(tf3);
add(l4);
add(tf4);
add(l5);
add(tf5);
add(l6);
add(tf6);
add(l7);
add(tf7);
add(b);
add(b1);
add(b2);
tf1.setBounds(130,50,200, 40);
tf2.setBounds(130,100,200, 40);
tf3.setBounds(130,150,200, 40);		
tf4.setBounds(130,200,200, 40);		
tf5.setBounds(130,250,200, 40);
tf6.setBounds(130,300,200, 40);		
tf7.setBounds(130,350,200, 40);		
setSize(400,500);
b.addActionListener(this);
b1.addActionListener(this);
b2.addActionListener(this);
setLayout(null); 
setVisible(true);
}
String [] columnNames= {"pid","name","gender","bg","pr_id","ph"};
public void  showdetails()
{
JFrame frame1 = new JFrame("PATIENT DETAILS");
frame1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

frame1.setLayout(new BorderLayout());

DefaultTableModel model = new DefaultTableModel();

model.setColumnIdentifiers(columnNames);

JTable table = new JTable();

table.setModel(model);

table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

table.setFillsViewportHeight(true);

JScrollPane scroll = new JScrollPane(table);

scroll.setHorizontalScrollBarPolicy(

        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

scroll.setVerticalScrollBarPolicy(

        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
try {

    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "midhun");
    PreparedStatement Pstatement = connection.prepareStatement("select * from patient");
    ResultSet rs = Pstatement.executeQuery();

    int i = 0;

    while (rs.next()) {

        

        model.addRow(new Object[] {
                rs.getString("p_id"), rs.getString("name"), rs.getString("gender"),
                rs.getString("bg"), rs.getString("pr_id"), rs.getString("phno"),
        });

        i++;

    }

    if (i < 1) {

        JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);

    }

    if (i == 1) {

        System.out.println(i + " Record Found");

    } else {

        System.out.println(i + " Records Found");

    }

} catch (Exception e) {

    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

}

frame1.add(scroll);

frame1.setVisible(true);

frame1.setSize(1000, 600);

}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b)
			
		{
			try {
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","midhun");
				PreparedStatement Pstatement=connection.prepareStatement("insert into patient(p_id,name,age,gender,bg,pr_id,phno) values(?,?,?,?,?,?,?) ");
				Pstatement.setString(1,tf1.getText());
				Pstatement.setString(2,tf2.getText());
				Pstatement.setString(3,tf3.getText());
				Pstatement.setString(4,tf4.getText());
				Pstatement.setString(5,tf5.getText());
				Pstatement.setString(6,tf6.getText());
				Pstatement.setString(7,tf7.getText());
				Pstatement.executeUpdate();
				JOptionPane.showMessageDialog(null,"Data Added Successfully");
			} catch (SQLException e1)
			{ 
				JOptionPane.showMessageDialog(null, "INVALID ENTRY");
			}
		}
		if(e.getSource()==b1)
		{

			showdetails();
		}
		if(e.getSource()==b2)
		{
			
			dispose();

		}
		
		new Homeform();
		dispose();

	}
	}
	

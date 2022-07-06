import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
import java.lang.Exception;
public class Home {
   Homeform HF1 = new Homeform();
}
class Homeform extends JFrame{
	public Homeform() {
		JButton b0 = new JButton(" DOCTOR ");
		JButton b1=new JButton("APPOINTMENT");    
	    JButton b2=new JButton("PATIENT");    
	    JButton b3=new JButton("BILL");    
	    JButton b4=new JButton("PRESCRIPTION");    
	    JButton b5=new JButton("TEST");
		b0.setBounds(130,200,100, 40);
		add(b0);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		b0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				new Doctorform();
				dispose();
			}
		});
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				new Appointment();
				dispose();
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				new Pateintform();
				dispose();
			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				new Billform();
				dispose();
			}
		});

		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				new Prescriptionform();
				dispose();
			}
		});

		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				new Testform();
				dispose();
			}
		});
		setSize(400,500);
		setLayout(new FlowLayout()); 
		setVisible(true);
	}
	
}
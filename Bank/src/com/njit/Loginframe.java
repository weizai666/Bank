package com.njit;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Loginframe extends JFrame {
private JTextField username;
private JPasswordField password;
private JButton login,register;
public Loginframe()
{
	super();
	this.setSize(300,200);
	this.setTitle("µÇÂ¼");
	this.setLocationRelativeTo(getOwner());
	Container cont=getContentPane();
	cont.setLayout(new GridLayout(3,2));
	cont.add(new JLabel("username"));
	username=new JTextField(10);
	cont.add(username);
	cont.add(new JLabel("password"));
	password=new JPasswordField(20);
	cont.add(password);
	login=new JButton("µÇÂ¼");
	register=new JButton("ÍË³ö");
	cont.add(login); 
	cont.add(register);
	login.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent evt)
		{
			String pass=new String(password.getPassword());
			if(username.getText().equals("sa")&&pass.equals("sa"))
			{
				Base hello=new Base();
				hello.setVisible(true);
				dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "error");
			}
		}
	});
	this.setVisible(true);
}
public static void main(String args[])
{
new Loginframe();
}
}

package com.njit;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.event.*;

import db.db;
public class Cunqu extends JFrame implements ActionListener,CaretListener
{
	private JButton cun;
	private JButton qu;
	private String inputstr;
	private String outputstr;
	private String user;
	private JTextField j;
	public Cunqu()
	{
		super("��ȡ��");
		this.setBounds(300, 240, 360, 120);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(new GridLayout(2,2));
		j=new JTextField();
		cun=new JButton("���");
		qu=new JButton("ȡ��");
		this.getContentPane().add(new JLabel("��/ȡ�˻���"));
		this.getContentPane().add(j);		
		this.getContentPane().add(cun);
		this.getContentPane().add(qu);
		j.addCaretListener(this);
		qu.addActionListener(this);
		cun.addActionListener(this);
		caretUpdate(null);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ev) 
	{
		if(ev.getSource()==cun)
		{
			int index=0,count;
			 inputstr=JOptionPane.showInputDialog(this, "������","");
//			 System.out.println(inputstr);
			 db dbcon=new db();
			 Information p=new Information();
			 if(p.table.getCellEditor()!=null)
				 p.table.getCellEditor().stopCellEditing();
			 try
			 {
				 String sql="update info set balance=? where CardNo=?";
				 PreparedStatement presta=dbcon.PreparedStatement(sql);
	
						 presta.setDouble(1, Double.parseDouble(inputstr)+Chaxun.search(j.getText()));
						 presta.setString(2,j.getText());
						 presta.executeUpdate();

				 JOptionPane.showMessageDialog(null,"���ɹ�");
				 dispose();
				 Information i=new Information();
				 i.setVisible(true);
			 }
			 catch(SQLException sqle) {System.out.println(sqle.toString());}
		}
		if(ev.getSource()==qu)
		{
			 inputstr=JOptionPane.showInputDialog(this, "������","");
//			 System.out.println(inputstr);
			 db dbcon=new db();
			 Information p=new Information();
			 if(p.table.getCellEditor()!=null)
				 p.table.getCellEditor().stopCellEditing();
			 try
			 {
				 String sql="update info set balance=? where CardNo=?";
				 PreparedStatement presta=dbcon.PreparedStatement(sql);
	
						 presta.setDouble(1, -Double.parseDouble(inputstr)+Chaxun.search(j.getText()));
						 presta.setString(2,j.getText());
						 presta.executeUpdate();

				 JOptionPane.showMessageDialog(null,"ȡ��ɹ�");
				 dispose();
				 Information i=new Information();
				 i.setVisible(true);
			 }
			 catch(SQLException sqle) {System.out.println(sqle.toString());}
		}
	}
	public static void main(String[] args)
	{
		Cunqu w=new Cunqu();
	}
	@Override
	public void caretUpdate(CaretEvent ev) 
	{
		user=j.getText();
//		System.out.println(user);
	}
}

package com.njit;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.event.*;

import db.db;
public class Zhuxiao extends JFrame implements ActionListener
{
	private JButton queding,quxiao;
	private JTextField j;
	public Zhuxiao()
	{
		super("注销");
		this.setBounds(240, 360, 300, 150);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(new FlowLayout());
		queding=new JButton("确定");
		quxiao=new JButton("取消");
		j=new JTextField(20);
		this.getContentPane().add(new JLabel("输入卡号"));
		this.getContentPane().add(j);
		this.getContentPane().add(queding);
		this.getContentPane().add(quxiao);
		this.setVisible(true);
		queding.addActionListener(this);
		quxiao.addActionListener(this);
	}
	public static void main(String[] args)
	{
		new Zhuxiao();
	}
	@Override
	public void actionPerformed(ActionEvent ev) 
	{
		if(ev.getSource()==queding)
		{
			db dbcon=new db();
			 Information p=new Information();
			 if(p.table.getCellEditor()!=null)
				 p.table.getCellEditor().stopCellEditing();
			 try
			 {
				 String sql="update info set balance=?,statementt='注销' where CardNo=?";
				 PreparedStatement presta=dbcon.PreparedStatement(sql);
	
						 presta.setDouble(1, 0);
					//	 presta.setString(2, "注销");
						 presta.setString(2,j.getText());
						 presta.executeUpdate();

				 JOptionPane.showMessageDialog(null,"注销成功");
				 dispose();
				 Information i=new Information();
				 i.setVisible(true);
			 }
			 catch(SQLException sqle) {System.out.println(sqle.toString());}
		}
	}
}

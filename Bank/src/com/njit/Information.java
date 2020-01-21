package com.njit;
import java.awt.*;
import javax.swing.*;

import db.db;

import java.awt.event.*;
import java.sql.*;

import entity.Info;
import java.util.ArrayList;
public class Information extends JFrame {
public JTable table;
public MyTableModel tablemodel;
private JButton b1;
private JButton b2;
private JButton b3;
private JToolBar tool;
public Information()
{
	this.setSize(600,300);
	this.setTitle("员工信息");
	this.setLocationRelativeTo(getOwner());
	tablemodel=getModel();
	table=new JTable(tablemodel);
	table.setPreferredScrollableViewportSize(new Dimension(500,250));
	JScrollPane scroll=new JScrollPane(table);
	getContentPane().add(scroll,BorderLayout.CENTER);
//	b1=new JButton(new ImageIcon("ico\\WRITER.GIF"));
//	b1.setToolTipText("添加");
//	b1.setFocusable(false);
//	b1.setHorizontalTextPosition(SwingConstants.CENTER);
//	b1.setVerticalTextPosition(SwingConstants.CENTER);
//	b2=new JButton();
//	b2.setIcon(new ImageIcon("ico\\UPDATE.GIF"));
//	b2.setToolTipText("修改");
//	b2.setFocusable(false);
//	b2.setHorizontalTextPosition(SwingConstants.CENTER);
//	b2.setVerticalTextPosition(SwingConstants.CENTER);
//	b3=new JButton();
//	b3.setIcon(new ImageIcon("ico\\DELETE.GIF"));
//	b3.setToolTipText("删除");
//	b3.setFocusable(false);
//	b3.setHorizontalTextPosition(SwingConstants.CENTER);
//	b3.setVerticalTextPosition(SwingConstants.CENTER);
//	tool=new JToolBar();
//	tool.add(b1);
//	tool.add(b2);
//	tool.add(b3);
//	tool.setRollover(true);
//	getContentPane().add(tool, BorderLayout.NORTH);
//	b1.addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent e)
//		{
//			Kaihu k=new Kaihu();
//			dispose();
//		}
//	});
}
private MyTableModel getModel()
{
	MyTableModel tableModel=new MyTableModel();
	db dbcon;
	try
	{
		dbcon=new db();
		ResultSet rs=dbcon.excuteQuery("Select* from info");
		ResultSetMetaData rsmd=rs.getMetaData();
		int Column=rsmd.getColumnCount();
		int i;
		for(i=1;i<=Column;i++)
			tableModel.addColumn(rsmd.getColumnName(i));
		ArrayList<Info> v=new ArrayList<Info>();
		while(rs.next())
		{
			Info Info=new Info();
			Info.setCardNo(rs.getString("CardNo"));
			Info.setName(rs.getString("Name"));
			Info.setSex(rs.getString("Sex"));
			Info.setIdentityNo(rs.getString("IdentityNo"));
			Info.setPassword(rs.getString("pasword"));
			Info.setSdate(rs.getDate("Sdate"));
			Info.setLocation(rs.getString("location"));
			Info.setStatementt(rs.getString("statementt"));
			Info.setBalance(rs.getDouble("balance"));
			v.add(Info);
		}
		rs.close();
		for(i=0;i<v.size();i++)
		{
			tableModel.addRow(new Object[]{v.get(i).getCardNo(),v.get(i).getName(),v.get(i).getSex(),v.get(i).getIdentityNo(),v.get(i).getPassword(),v.get(i).getSdate(),v.get(i).getLocation(),v.get(i).getStatementt(),v.get(i).getBalance()});
		}
		dbcon.closeConn();
	}
	catch(SQLException sqle)
	{ 
		System.out.println(sqle.toString());
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	return tableModel;
}
public static void main(String[] args)
{
	Information w=new Information();
	w.setVisible(true);
}
}
package com.njit;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.event.*;

import db.db;
public class Kaihu extends JFrame implements ActionListener
{
	private JTextField[] tx;
	private JButton queding;
	private JButton quxiao;
	public Kaihu()
	{
		super("开户");
		this.tx=new JTextField[8];
		this.setBounds(360,140,300,500);
		this.getContentPane().setLayout(new GridLayout(9,2));
		for(int i=0;i<tx.length;i++)
			tx[i]=new JTextField(50);
		this.getContentPane().add(new JLabel("卡号"));
		this.getContentPane().add(tx[0]);
		this.getContentPane().add(new JLabel("姓名"));
		this.getContentPane().add(tx[1]);
		this.getContentPane().add(new JLabel("性别"));
		this.getContentPane().add(tx[2]);
		this.getContentPane().add(new JLabel("身份证号"));
		this.getContentPane().add(tx[3]);
		this.getContentPane().add(new JLabel("密码"));
		this.getContentPane().add(tx[4]);
		this.getContentPane().add(new JLabel("开户日期"));
		this.getContentPane().add(tx[5]);
		this.getContentPane().add(new JLabel("开户地址"));
		this.getContentPane().add(tx[6]);
		this.getContentPane().add(new JLabel("开户金额"));
		this.getContentPane().add(tx[7]);
		queding=new JButton("确定");
		quxiao=new JButton("取消");
		this.setVisible(true);
		this.getContentPane().add(queding);
		this.getContentPane().add(quxiao);
		queding.addActionListener(this);
	}
	public static void main(String[] args)
	{
		new Kaihu();
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==queding)
		{
			db dbcon=new db();
			try
			{
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				String sql="insert into info values(?,?,?,?,?,?,?,?,?)";
				PreparedStatement prestate=dbcon.PreparedStatement(sql);
				prestate.setString(1,tx[0].getText());
				prestate.setString(2,tx[1].getText());
				prestate.setString(3,tx[2].getText());
				prestate.setString(4,tx[3].getText());
				prestate.setString(5,tx[4].getText());
				try {
					prestate.setDate(6,new Date(sdf.parse(tx[5].getText()).getTime()));
				} catch (ParseException e1) {System.out.println("ssss");
				}

				prestate.setString(7,tx[6].getText());
				prestate.setString(8,"激活");
				prestate.setDouble(9,Double.parseDouble(tx[7].getText()));
				prestate.executeUpdate();
				JOptionPane.showMessageDialog(null,"开户成功");
				dispose();
				Information isel=new Information();
				isel.setVisible(true);
			}
			catch(SQLException ex) {System.out.println(ex.toString());}
		}
	}
}

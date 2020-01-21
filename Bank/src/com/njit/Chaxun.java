package com.njit;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;

import db.db;
import entity.Info;
import entity.TransInfo;
public class Chaxun extends JFrame implements ActionListener
{
	private JTextField[] j;
	private JButton queding;
	private JButton quxiao;
	private JRadioButton yue;
	private JRadioButton jilu;
	private double money;
	public Chaxun()
	{
		super("查询");
		j=new JTextField[4];
		this.setBounds(240, 360, 300, 150);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(new GridLayout(5,2));
		for(int i=0;i<j.length;i++)
			j[i]=new JTextField(50);
		this.getContentPane().add(new JLabel("卡号"));
		this.getContentPane().add(j[0]);
		yue=new JRadioButton("余额");
		this.getContentPane().add(yue);
		this.getContentPane().add(j[1]);
		j[1].setEditable(false);
		jilu=new JRadioButton("记录");
		this.getContentPane().add(jilu);
		this.getContentPane().add(j[2]);
		j[2].setEditable(false);
		j[3].setEditable(false);
		this.getContentPane().add(new JLabel("日期"));
		this.getContentPane().add(j[3]);
		queding=new JButton("确定");
		quxiao=new JButton("取消");
		this.getContentPane().add(queding);
		this.getContentPane().add(quxiao);
		yue.addActionListener(this);
		jilu.addActionListener(this);
		queding.addActionListener(this);
		quxiao.addActionListener(this);
		this.setVisible(true);
	}
	public static void main(String[] args)
	{
		new Chaxun();
//		System.out.println(Chaxun.search("6212264301018076008"));
	}
	@Override
	public void actionPerformed(ActionEvent ev) 
	{
		if(ev.getSource()==yue)
		{
			jilu.setSelected(false);
			j[3].setEditable(false);
		}
		if(ev.getSource()==jilu)
		{
			yue.setSelected(false);
			j[3].setEditable(true);
		}
		if(ev.getSource()==queding&&jilu.isSelected())
		{
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			yue.setSelected(false);
			j[3].setEditable(true);
			try
			{
			db dbcon=new db();
			ResultSet rs=dbcon.excuteQuery("Select* from transInfo");
			int i;
			ArrayList<TransInfo> v=new ArrayList<TransInfo>();

			while(rs.next())
			{
				TransInfo transInfo=new TransInfo();
				transInfo.setCardNo(rs.getString("CardNo"));
				transInfo.setTranstype(rs.getString("transType"));
				transInfo.setTransmoney(rs.getString("transMoney"));
				transInfo.setTransdate(rs.getDate("transDate"));
				v.add(transInfo);
			}
			rs.close();
			for(i=0;i<v.size();i++)
			{
//				System.out.println(v.get(i).getCardNo());
//				System.out.println(v.get(i).getTransdate());
				Date ss=v.get(i).getTransdate();
				String s=ss.toString().trim();
//				System.out.println(s);
				String no=v.get(i).getCardNo().trim();
				if(s.equals(j[3].getText())&&no.equals(j[0].getText()))
					j[2].setText(v.get(i).getTranstype()+"  "+v.get(i).getTransmoney());
			}
			dbcon.closeConn();
		}
			catch(SQLException ex) {System.out.println("err");
			}
		}
		if(ev.getSource()==queding&&yue.isSelected())
		{
			
			try
			{
			db dbcon=new db();
			ResultSet rs=dbcon.excuteQuery("Select* from info");
			int i;
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
//			Object[] obj=new Object[v.size()];
			rs.close();
			for(i=0;i<v.size();i++)
			{
			//	obj[i]=new Object[]{v.get(i).getCardNo(),v.get(i).getName(),v.get(i).getSex(),v.get(i).getIdentityNo(),v.get(i).getPassword(),v.get(i).getSdate(),v.get(i).getLocation(),v.get(i).getStatementt(),v.get(i).getBalance()};
				if(v.get(i).getCardNo().trim().equals(j[0].getText().trim()))

				money=v.get(i).getBalance();
				j[1].setText(Double.toString(money));
//				break;
			}
			dbcon.closeConn();
			}
			catch(SQLException ex) {System.out.println("ygygyg");}
		}
		if(ev.getSource()==quxiao)
			dispose();
	}
	public static double search(String CardNo)
	{
		double m=0.0;
		try
		{
		db dbcon=new db();
		ResultSet rs=dbcon.excuteQuery("Select* from info");
		int i;
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
//		Object[] obj=new Object[v.size()];
		rs.close();
		for(i=0;i<v.size();i++)
		{
		//	obj[i]=new Object[]{v.get(i).getCardNo(),v.get(i).getName(),v.get(i).getSex(),v.get(i).getIdentityNo(),v.get(i).getPassword(),v.get(i).getSdate(),v.get(i).getLocation(),v.get(i).getStatementt(),v.get(i).getBalance()};
			if(v.get(i).getCardNo().trim().equals(CardNo))

			m=v.get(i).getBalance();
//			break;
		}
		dbcon.closeConn();
		}
		catch(SQLException ex) {System.out.println("ygygyg");}
		return m;
	}
}

package com.njit;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import db.db;

import java.sql.*;
public class Personadd extends JFrame 
{
	private JTextField userid,username;
	private JRadioButton sexfemale,sexmale;
	private JPanel sex,birth;
	private JTextField year,dept;
	private JComboBox month,day,prof;
	private JButton ok,cancel;
	public Personadd()
	{
		super();
		this.setSize(350,300);
		this.setTitle("Login");
		this.setLocationRelativeTo(getOwner());
		Container cont=getContentPane();
		cont.setLayout(new GridLayout(7,2));
		cont.add(new JLabel("员工号"));
		userid=new JTextField(10);
		cont.add(userid);
		cont.add(new JLabel("姓名"));
		username=new JTextField(10);
		cont.add(username);
		cont.add(new JLabel("性别"));
		sexmale=new JRadioButton("男",true);
		sexfemale=new JRadioButton("女");
		ButtonGroup bg=new ButtonGroup();
		bg.add(sexmale);
		bg.add(sexfemale);
		sex=new JPanel(new GridLayout(1,2));
		sex.add(sexmale);
		sex.add(sexfemale);
		cont.add(sex);
		cont.add(new JLabel("出生日期"));
		year=new JTextField(4);
		month=new JComboBox();
		int i;
		for(i=1;i<=12;i++)
			month.addItem(i);
		birth=new JPanel();
		birth.add(year);
		birth.add(new JLabel("-"));
		birth.add(month);
		birth.add(new JLabel("-"));
		birth.add(day);
		cont.add(birth);
		cont.add(new JLabel("职称"));
		prof=new JComboBox();
		prof.addItem("初级");
		prof.addItem("中级");
		prof.addItem("高级");
		cont.add(prof);
		cont.add(new JLabel("部门"));
		dept=new JTextField(10);
		cont.add(dept);
	}
}

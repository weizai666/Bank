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
		cont.add(new JLabel("Ա����"));
		userid=new JTextField(10);
		cont.add(userid);
		cont.add(new JLabel("����"));
		username=new JTextField(10);
		cont.add(username);
		cont.add(new JLabel("�Ա�"));
		sexmale=new JRadioButton("��",true);
		sexfemale=new JRadioButton("Ů");
		ButtonGroup bg=new ButtonGroup();
		bg.add(sexmale);
		bg.add(sexfemale);
		sex=new JPanel(new GridLayout(1,2));
		sex.add(sexmale);
		sex.add(sexfemale);
		cont.add(sex);
		cont.add(new JLabel("��������"));
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
		cont.add(new JLabel("ְ��"));
		prof=new JComboBox();
		prof.addItem("����");
		prof.addItem("�м�");
		prof.addItem("�߼�");
		cont.add(prof);
		cont.add(new JLabel("����"));
		dept=new JTextField(10);
		cont.add(dept);
	}
}

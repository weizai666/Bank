package com.njit;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Base extends JFrame implements ActionListener
{
//	private JMenuItem m25;
	private JButton[] but=new JButton[5];
	private Information per;
public Base()
{
	super();
	this.setSize(400,300);
	this.setTitle("����");
	this.setLocationRelativeTo(getOwner());
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.getContentPane().setLayout(new GridLayout(3,2));
    but[0]=new JButton("����");
    but[1]=new JButton("��ȡ��");
    but[2]=new JButton("ת��");
    but[3]=new JButton("��ѯ");
    but[4]=new JButton("ע��");
    for(int i=0;i<but.length;i++)
    	this.add(but[i]);
    for(int i=0;i<but.length;i++)
    	but[i].addActionListener(this);
	this.setVisible(true);
}
public static void main(String args[])
{
	new Base();
}
@Override
public void actionPerformed(ActionEvent ev) {
	if(ev.getSource()==but[0])
		new Kaihu();
	if(ev.getSource()==but[1])
		new Cunqu();
	if(ev.getSource()==but[2])
		new Zhuanzhang();
	if(ev.getSource()==but[3])
		new Chaxun();
	if(ev.getSource()==but[4])
		new Zhuxiao();
	
	}
}

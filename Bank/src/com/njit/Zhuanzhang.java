package com.njit;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.event.*;

import db.db;
public class Zhuanzhang extends JFrame implements ActionListener
{
	private JTextField[] tx;
	private JButton queding;
	private JButton quxiao;
	public Zhuanzhang()
	{
		super("ת��");
		this.tx=new JTextField[6];
		this.setBounds(360,140,300,500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(new GridLayout(7,2));
		for(int i=0;i<tx.length;i++)
			tx[i]=new JTextField();
		this.getContentPane().add(new JLabel("ת�˿���"));
		this.getContentPane().add(tx[0]);
		this.getContentPane().add(new JLabel("��ת����"));
		this.getContentPane().add(tx[1]);
//		this.getContentPane().add(new JLabel("��ת������"));
//		this.getContentPane().add(tx[2]);
		this.getContentPane().add(new JLabel("ת��"));
		this.getContentPane().add(tx[3]);
		tx[4].setEditable(false);
		this.getContentPane().add(new JLabel("������"));
		this.getContentPane().add(tx[4]);
		this.getContentPane().add(new JLabel("��ת�����"));
		this.getContentPane().add(tx[5]);
		tx[5].setEditable(false);
		queding=new JButton("ȷ��");
		quxiao=new JButton("ȡ��");
		this.setVisible(true);
		this.getContentPane().add(queding);
		this.getContentPane().add(quxiao);
		queding.addActionListener(this);
		quxiao.addActionListener(this);
	}
	public static void main(String[] args)
	{
		new Zhuanzhang();
	}
	@Override
	public void actionPerformed(ActionEvent ev) 
	{
		if(ev.getSource()==queding)
		{
			double money1=Chaxun.search(tx[0].getText());
			double money2=Chaxun.search(tx[1].getText());
			double temp=Double.parseDouble(tx[3].getText());
			tx[5].setText(Double.toString(money2));
			tx[4].setText(Double.toString(temp*0.05));
			money1=money1-temp-temp*0.05;
			money2+=temp;
			db dbcon=new db();
			 Information p=new Information();
			 if(p.table.getCellEditor()!=null)
				 p.table.getCellEditor().stopCellEditing();
			 try
			 {
				 String sql="update info set balance=? where CardNo=?";
				 PreparedStatement presta=dbcon.PreparedStatement(sql);
	
						 presta.setDouble(1, money1);
						 presta.setString(2,tx[0].getText());
						 presta.executeUpdate();
						 String sql2="update info set balance=? where CardNo=?";
						 PreparedStatement presta2=dbcon.PreparedStatement(sql2);
			
								 presta2.setDouble(1, money2);
								 presta2.setString(2,tx[1].getText());
								 presta2.executeUpdate();

				 JOptionPane.showMessageDialog(null,"ת�˳ɹ�");
				 dispose();
				 Information i=new Information();
				 i.setVisible(true);
			 }
			 catch(SQLException sqle) {System.out.println(sqle.toString());}
		}
	}
}

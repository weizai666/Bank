package com.njit;

import java.util.ArrayList;
import javax.swing.table.*;

public class MyTableModel extends DefaultTableModel {
private ArrayList<Integer>editedIndex=new ArrayList<Integer>();
public MyTableModel()
{
	super();
}
public boolean isCellEditable(int row,int column)
{
	if(column==0)
		return false;
	else
		return true;
}
public void setValueAt(Object aValue,int row,int column)
{
	super.setValueAt(aValue,row,column);
	int i,count=editedIndex.size();
	if(count==0)
		editedIndex.add(row);
	else
	{
		for(i=0;i<count;i++)
		{
			if(editedIndex.get(i).intValue()>row)
			{
				editedIndex.add(i+1,row);
				break;
			}
		}
			if(i>=count)
				editedIndex.add(row);
	}

}
public ArrayList<Integer> getEditedIndex()
{
	return editedIndex;
}
}

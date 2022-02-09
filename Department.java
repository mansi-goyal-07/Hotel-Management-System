

package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Department extends JFrame implements ActionListener {
    
    
    JButton b1,b2;
    JTable t1;
    
    Department()
    {
    
      
        t1 = new JTable();
        t1.setBounds(0,50,700,350);
        add(t1);
        
        b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(180,400,120,30);
        add(b1);
        b1.addActionListener(this);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(380,400,120,30);
        add(b2);
        b2.addActionListener(this);
        
        JLabel l3 = new JLabel("Department");
        l3.setBounds(150,10,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Budget");
        l4.setBounds(480,10,100,20);
        add(l4);
      
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(300,130,700,500);
        setVisible(true);

    }
    
    public void actionPerformed(ActionEvent ae)
    {
    if(ae.getSource()==b1)
    {
    try
    {
    String str = "select * from department ";
    conn con = new conn();
    ResultSet rs = con.s.executeQuery(str);
    t1.setModel(DbUtils.resultSetToTableModel(rs));
    
    }
    catch(Exception e)
    {
    }
    }
    else if(ae.getSource()==b2)
    {
    new Reception();
    setVisible(false);
    
    }
    }
    public static void main(String[] args)
    {
    new Department();
    }
    
}

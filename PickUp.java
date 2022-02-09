
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class PickUp extends JFrame implements ActionListener {
    
    Choice c1;
  
    JButton b1,b2;
    JTable t1;
    
    PickUp()
    {
    
        JLabel l1 = new JLabel("PickUp Service");
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        l1.setBounds(400,30,200,30);
        l1.setForeground(Color.BLUE);
        add(l1);
        
        JLabel l2 = new JLabel("Type of Car");
        l2.setBounds(50,100,100,20);
        add(l2);
        
       c1 = new Choice();
       try
       {
       conn con = new conn();
       ResultSet rs = con.s.executeQuery("select * from driver");
       while(rs.next())
       {
       c1.add(rs.getString("brand"));
       }
       }
       catch(Exception e)
       {}
       c1.setBounds(150,100,200,25);
       add(c1);
      
        
        t1 = new JTable();
        t1.setBounds(0,180,1000,250);
        add(t1);
        
        b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(300,450,120,30);
        add(b1);
        b1.addActionListener(this);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(500,450,120,30);
        add(b2);
        b2.addActionListener(this);
        
        JLabel l3 = new JLabel("Name");
        l3.setBounds(50,160,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Age");
        l4.setBounds(200,160,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Gender");
        l5.setBounds(340,160,100,20);
        add(l5);
        
        JLabel l6 = new JLabel("Company");
        l6.setBounds(470,160,100,20);
        add(l6);
        
        JLabel l7 = new JLabel("Brand");
        l7.setBounds(620,160,100,20);
        add(l7);
        
          JLabel l8 = new JLabel("Availability");
        l8.setBounds(750,160,100,20);
        add(l8);
        
          JLabel l9 = new JLabel("Location");
        l9.setBounds(890,160,100,20);
        add(l9);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(150,130,1000,550);
        setVisible(true);

    }
    
    public void actionPerformed(ActionEvent ae)
    {
    if(ae.getSource()==b1)
    {
    try
    {
    String str = "select * from driver where brand = '"+c1.getSelectedItem()+"' ";
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
    new PickUp();
    }
    
}

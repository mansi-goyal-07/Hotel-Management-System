
package hotel.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener {
    
    JTable t1;
    JButton b1,b2;
    
    
    public CustomerInfo()
    {
     t1 = new JTable();
     t1.setBounds(0,40,1000,400);
     add(t1);
     
     JLabel l1 = new JLabel("Document Type");
     l1.setBounds(20,10,120,20);
     add(l1);
     
       JLabel l2 = new JLabel("Number");
     l2.setBounds(160,10,70,20);
     add(l2);
     
     
       JLabel l3 = new JLabel("Name");
     l3.setBounds(290,10,70,20);
     add(l3);
     
         JLabel l4 = new JLabel("Gender");
     l4.setBounds(420,10,70,20);
     add(l4);

         JLabel l5 = new JLabel("Country");
     l5.setBounds(540,10,70,20);
     add(l5);
     
        JLabel l6 = new JLabel("Room Number");
     l6.setBounds(640,10,120,20);
     add(l6);
     
        JLabel l7 = new JLabel("Status");
     l7.setBounds(790,10,70,20);
     add(l7);
     
        JLabel l8 = new JLabel("Deposit");
     l8.setBounds(900,10,70,20);
     add(l8);
     
     
     b1 = new JButton("Load Data");
     b1.setBounds(350,450,120,30);
     b1.setBackground(Color.BLACK);
     b1.setForeground(Color.WHITE);
     add(b1);
     b1.addActionListener(this);
     
     b2 = new JButton("Back");
     b2.setBounds(500,450,120,30);
     b2.setBackground(Color.BLACK);
     b2.setForeground(Color.WHITE);
     add(b2);
     b2.addActionListener(this);
     
     getContentPane().setBackground(Color.WHITE);
     setLayout(null);
     setBounds(150,130,1000,530);
     setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae)
    {
    if(ae.getSource()==b1)
    {
    try
    {
        conn con = new conn();
        String str = "select * from customer";
        ResultSet rs = con.s.executeQuery(str);
        
        t1.setModel(DbUtils.resultSetToTableModel(rs));
        
        
     
    }
    catch(Exception e)
    {}
    }
    else if(ae.getSource()==b2)
    {
      new Reception();
      this.setVisible(false);
    
    }
    
    }
    
    public static void main(String args[])
    {
    
    new CustomerInfo();
    }
    
}

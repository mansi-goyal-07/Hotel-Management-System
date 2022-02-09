
package hotel.management.system;

import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class AllRooms extends JFrame implements ActionListener{
    
    JTable t1;
    JButton b1,b2;
    
    public AllRooms()
    {
    t1 = new JTable();
    t1.setBounds(0,40,500,400);
    add(t1);
    
     b1 = new JButton("Load Data");
     b1.setBounds(100,450,120,30);
     b1.setBackground(Color.BLACK);
     b1.setForeground(Color.WHITE);
     add(b1);
     b1.addActionListener(this);
     
     b2 = new JButton("Back");
     b2.setBounds(250,450,120,30);
     b2.setBackground(Color.BLACK);
     b2.setForeground(Color.WHITE);
     add(b2);
     b2.addActionListener(this);
     
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eight.jpg"));
     Image i2 = i1.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
     ImageIcon i3 = new ImageIcon(i2);
     JLabel icon = new JLabel(i3);
     icon.setBounds(500,40,500,400);
     add(icon);
     
     JLabel l1 = new JLabel("Room Number");
     l1.setBounds(10,10,100,30);
     add(l1);
     
      JLabel l2 = new JLabel("Availability");
     l2.setBounds(120,10,100,30);
     add(l2);
     
      JLabel l3 = new JLabel("Status");
     l3.setBounds(230,10,100,30);
     add(l3);
     
      
      JLabel l4 = new JLabel("Price");
     l4.setBounds(340,10,80,30);
     add(l4);
     
     
       JLabel l5 = new JLabel("Bed Type");
     l5.setBounds(420,10,100,30);
     add(l5);
     
     
     
    
    setLayout(null);
   setBounds(150,130,1000,530);
   getContentPane().setBackground(Color.WHITE);
    setVisible(true);    
    }
    
    public void actionPerformed(ActionEvent ae)
    {
    
    if(ae.getSource()==b1)
    {
     try
    {
        conn con = new conn();
        String str = "select * from room";
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
    
    public static void main(String[] args)
    {
    new AllRooms();
    
    }
    
}

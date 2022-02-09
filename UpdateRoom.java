/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateRoom extends JFrame implements ActionListener{
    
    Choice c1;
    JTextField t1,t2,t3;
    JButton b1,b2,b3;
    
    public UpdateRoom()
    {
     setBounds(200,150,900,450);
     getContentPane().setBackground(Color.WHITE);
     
     JLabel l1 = new JLabel("Update Room Status");
     l1.setBounds(30,20,250,30);
     l1.setFont(new Font("Tahoma",Font.PLAIN,25));
     l1.setForeground(Color.blue);
     add(l1);
     
     JLabel l2 = new JLabel("Guest Id");
     l2.setBounds(30,80,120,30);
     add(l2);
     
     c1 = new Choice();
     try
     {
     conn con = new conn();
     ResultSet rs = con.s.executeQuery("Select * from customer");
     while(rs.next())
     {
         c1.add(rs.getString("number"));
     
     }
     c1.setBounds(200,80,150,25);
     add(c1);
     
     }
     catch(Exception e)
     {
     
     }
     
      JLabel l3 = new JLabel("Room Number");
     l3.setBounds(30,130,120,30);
     add(l3);
     
     t1 = new JTextField();
     t1.setBounds(200,130,150,25);
     add(t1);
     
      JLabel l4 = new JLabel("Availablity");
     l4.setBounds(30,180,120,30);
     add(l4);
     
      t2 = new JTextField();
     t2.setBounds(200,180,150,25);
     add(t2);
     
      JLabel l5 = new JLabel("Cleaning Status");
     l5.setBounds(30,230,120,30);
     add(l5);
     
      t3 = new JTextField();
     t3.setBounds(200,230,150,25);
     add(t3);
     
     b1 = new JButton("Check");
     b1.setBackground(Color.BLACK);
     b1.setForeground(Color.WHITE);
     b1.setBounds(150,300,120,30);
     add(b1);
     b1.addActionListener(this);
     
       b2 = new JButton("Update");
     b2.setBackground(Color.BLACK);
     b2.setForeground(Color.WHITE);
     b2.setBounds(50,350,120,30);
     add(b2);
      b2.addActionListener(this);
     
       b3 = new JButton("Back");
     b3.setBackground(Color.BLACK);
     b3.setForeground(Color.WHITE);
     b3.setBounds(250,350,120,30);
     add(b3);
      b3.addActionListener(this);
     
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/seventh.jpg"));
     Image i2 = i1.getImage().getScaledInstance(450,300,Image.SCALE_DEFAULT);
     ImageIcon i3 = new ImageIcon(i2);
     JLabel l6 = new JLabel(i3);
     l6.setBounds(400,50,450,300);
     add(l6);
     
     
     setLayout(null);
     setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae)
    {
    
    if(ae.getSource()==b1)
    {
      String s1 = c1.getSelectedItem();
      String room = null;
      conn con = new conn();
      try{
      ResultSet rs = con.s.executeQuery("select * from customer where number = '"+s1+"'");
     
      while(rs.next())
      {
      t1.setText(rs.getString("room_number"));
      room = rs.getString("room_number");
    
      
      }
      
       ResultSet rs2 = con.s.executeQuery("Select * from room where room_number = '"+room+"'");
       while(rs2.next())
       {
       t2.setText(rs2.getString("availability"));
       t3.setText(rs2.getString("clean_status"));
       }
       
        
      }
      catch(Exception e)
      {
      }
      
    }
    else if(ae.getSource()==b2)
    {
    try
    {
    conn con = new conn();
    String room = t1.getText();
    String available = t2.getText();
    String status = t3.getText();
    String str = "Update room set availability = '"+available+"',clean_status = '"+status+"' where room_number = '"+room+"'";
    con.s.executeUpdate(str);
    JOptionPane.showMessageDialog(null,"Room Updated successfully");
    new Reception();
    this.setVisible(false);
    }
    catch(Exception e)
    {
    
    }
    
    }
    else
    {
    new Reception();
    this.setVisible(false);
    
    }
    
    }
    
    public static void main(String args[])
    {
    
    
    new UpdateRoom();
    
    }
    
}

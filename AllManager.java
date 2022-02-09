
package hotel.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;

public class AllManager extends JFrame implements ActionListener {
    
    JTable t1;
    JButton b1,b2;
    
    
    public AllManager()
    {
     t1 = new JTable();
     t1.setBounds(0,40,1000,400);
     add(t1);
     
     JLabel l1 = new JLabel("Name");
     l1.setBounds(40,10,70,20);
     add(l1);
     
       JLabel l2 = new JLabel("Age");
     l2.setBounds(170,10,70,20);
     add(l2);
     
     
       JLabel l3 = new JLabel("Gender");
     l3.setBounds(290,10,70,20);
     add(l3);
     
         JLabel l4 = new JLabel("Department");
     l4.setBounds(400,10,70,20);
     add(l4);

         JLabel l5 = new JLabel("Salary");
     l5.setBounds(540,10,70,20);
     add(l5);
     
        JLabel l6 = new JLabel("Phone");
     l6.setBounds(660,10,70,20);
     add(l6);
     
        JLabel l7 = new JLabel("Aadhar");
     l7.setBounds(780,10,70,20);
     add(l7);
     
        JLabel l8 = new JLabel("Email");
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
        String str = "select * from employee where job = 'manager'";
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
    
    new AllManager();
    }
    
}

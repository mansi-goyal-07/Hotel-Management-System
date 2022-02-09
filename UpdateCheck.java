
package hotel.management.system;

import java.awt.*;
import java.awt.Font;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCheck  extends JFrame implements ActionListener{
    
    JButton b1,b2,b3;
    Choice c1;
    JTextField t1,t2,t3,t4,t5;
    UpdateCheck()
    {
    JLabel l1 = new JLabel("Check-in Details");
    l1.setFont(new Font("Tahoma",Font.PLAIN,20));
    l1.setForeground(Color.BLUE);  
    l1.setBounds(100,30,200,30);
    add(l1);
    
     JLabel l2 = new JLabel("Customer-Id");
    l2.setBounds(30,80,150,30);
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
    }
    catch(Exception e)
    {}
    c1.setBounds(200,80,150,30);
    add(c1);
    
      JLabel l3 = new JLabel("Room Number");
    l3.setBounds(30,120,200,30);
    add(l3);
    
    t1 = new JTextField();
    t1.setBounds(200,120,150,30);
    add(t1);
    
      JLabel l4 = new JLabel("Name");
    l4.setBounds(30,160,200,30);
    add(l4);
    
     t2 = new JTextField();
    t2.setBounds(200,160,150,30);
    add(t2);
    
    JLabel l5 = new JLabel("Check-In");
    l5.setBounds(30,200,200,30);
    add(l5);
    
     t3 = new JTextField();
    t3.setBounds(200,200,150,30);
    add(t3);
    
    JLabel l6 = new JLabel("Amount Paid");
    l6.setBounds(30,240,200,30);
    add(l6);
    
     t4 = new JTextField();
    t4.setBounds(200,240,150,30);
    add(t4);
    
    JLabel l7 = new JLabel("Pending Amount");
    l7.setBounds(30,280,200,30);
    add(l7);
    
     t5 = new JTextField();
    t5.setBounds(200,280,150,30);
    add(t5);
    
    b1 = new JButton("Check");
    b1.setBackground(Color.BLACK);
    b1.setForeground(Color.WHITE);
    b1.setBounds(150,330,110,30);
    add(b1);
    b1.addActionListener(this);
    
     b2 = new JButton("Update");
    b2.setBackground(Color.BLACK);
    b2.setForeground(Color.WHITE);
    b2.setBounds(30,330,110,30);
    add(b2);
    b2.addActionListener(this);
    
     b3 = new JButton("Back");
    b3.setBackground(Color.BLACK);
    b3.setForeground(Color.WHITE);
    b3.setBounds(270,330,110,30);
    add(b3);
    b3.addActionListener(this);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/nine.jpg"));
    JLabel l9 = new JLabel(i1);
    l9.setBounds(400,5,500,400);
    add(l9);
    
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    setBounds(160,150,980,450);
    setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae)
    {
    if(ae.getSource()==b1)
    {
        String room = null;
        String deposit = null;
        int amountpaid;
        String price = null;
    try
    {
        conn con = new conn();
        String id = c1.getSelectedItem();
        String str = "select * from customer where number = '"+id+"'";
        ResultSet rs = con.s.executeQuery(str);
        while(rs.next())
        {
            room = rs.getString("room_number");
            deposit = rs.getString("deposit");
            t1.setText(rs.getString("room_number"));
            t2.setText(rs.getString("name"));
            t3.setText(rs.getString("status"));
            t4.setText(rs.getString("deposit"));
           
        }
        
        ResultSet rs2 = con.s.executeQuery("select * from room where room_number = '"+room+"'");
        while(rs2.next())
        {
        price = rs2.getString("price");
        amountpaid = Integer.parseInt(price)-Integer.parseInt(deposit);
        t5.setText(Integer.toString(amountpaid));
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
            
            String s1 = c1.getSelectedItem();
            String s2 = t1.getText();
            String s3 = t2.getText();
            String s4 = t3.getText();
            String s5 = t4.getText();
            
            con.s.executeUpdate("update customer set room_number = '"+s2+"', name = '"+s3+"',status = '"+s4+"',deposit = '"+s5+"' where number = '"+s1+"' ");
            
            JOptionPane.showMessageDialog(null,"Data Updated Successfully");
            new Reception();
            setVisible(false);
        
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
    
    public static void main(String[] args)
    {
    
    new UpdateCheck();
    }
    
}

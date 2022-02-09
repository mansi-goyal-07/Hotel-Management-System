
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class CheckOut extends JFrame implements ActionListener{
    
    Choice c1;
    JTextField  t1;
    JButton b1,b2,b3;
    
    CheckOut()
    {
    setBounds(200,150,800,350);
    
    JLabel l1 = new JLabel("Check-Out");
    l1.setFont(new Font("Tahoma",Font.PLAIN,20));
    l1.setForeground(Color.BLUE);
    l1.setBounds(100,20,100,30);
    add(l1);
    
    JLabel l2 = new JLabel("Customer Id");
    l2.setBounds(30,80,100,30);
    add(l2);
    
    c1 = new Choice();
    try
    {
    conn con = new conn();
    ResultSet rs = con.s.executeQuery("select * from customer");
    while(rs.next())
    {
    c1.add(rs.getString("number"));
    
    }
    
    }
    catch(Exception e)
    {}
    
    c1.setBounds(150,85,150,30);
    add(c1);
    
    JLabel l3 = new JLabel("Room Number");
    l3.setBounds(30,130,100,30);
    add(l3);
    
    t1 = new JTextField();
    t1.setBounds(150,130,150,30);
    add(t1);
    
    b1 = new JButton("CheckOut");
    b1.setBackground(Color.BLACK);
    b1.setForeground(Color.WHITE);
    b1.setBounds(30,200,120,30);
    add(b1);
    b1.addActionListener(this);
    
     b2 = new JButton("Back");
    b2.setBackground(Color.BLACK);
    b2.setForeground(Color.WHITE);
    b2.setBounds(170,200,120,30);
    add(b2);
     b2.addActionListener(this);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.png"));
    Image i2 = i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    b3 = new JButton(i3);
    b3.setBounds(310,85,20,20);
    add(b3);
     b3.addActionListener(this);
    
     
    ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/sixth.jpg"));
    Image i5 = i4.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
    ImageIcon i6 = new ImageIcon(i5);
    JLabel l4 = new JLabel(i6);
    l4.setBounds(350,0,400,250);
    add(l4);
    
    
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    setVisible(true);
        
    
    }
    public void actionPerformed(ActionEvent ae)
    {
    if(ae.getSource()==b1)
    {
        String id = c1.getSelectedItem();
        String room = t1.getText();
        String str = "Delete from customer where number = '"+id+"'";
        String str2 = "Update room set availability = 'Available' where room_number = '"+room+"'";
        conn con = new conn();
        try
        {
        con.s.executeUpdate(str);
        con.s.executeUpdate(str2);
        JOptionPane.showMessageDialog(null,"Checkout Done");
        new Reception();
        setVisible(false);
        }
        catch(Exception e)
        {}
        
    
    }
    else if(ae.getSource()==b2)
    {
    new Reception();
    setVisible(false);
    }
    else if(ae.getSource()==b3)
    {
    try{
    String id = c1.getSelectedItem();
    conn con = new conn();
    ResultSet rs = con.s.executeQuery("select * from customer where number = '"+id+"'");
    while(rs.next())
    {
    t1.setText(rs.getString("room_number"));
    }
        }
        catch(Exception e)
        {
        
        }
    }
    
    }
    public static void main(String[] args)
    {
    
    new CheckOut();
    
    }
    
}

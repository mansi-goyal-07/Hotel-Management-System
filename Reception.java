
package hotel.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
public class Reception extends JFrame implements ActionListener {
    
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
    public Reception()
    {
        b1 = new JButton("New Customer Form");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(10,30,200,30);
        add(b1);
        b1.addActionListener(this);
        
         b2 = new JButton("Room");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(10,70,200,30);
        add(b2);
         b2.addActionListener(this);
        
         b3 = new JButton("Department");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(10,110,200,30);
        add(b3);
         b3.addActionListener(this);
         
         b4 = new JButton("All Employee Info");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setBounds(10,150,200,30);
        add(b4);
         b4.addActionListener(this);
         
         b5 = new JButton("Customer Info");
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setBounds(10,190,200,30);
        add(b5);
         b5.addActionListener(this);
         
         b6 = new JButton("Manager Info");
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        b6.setBounds(10,230,200,30);
        add(b6);
         b6.addActionListener(this);
         
         b7 = new JButton("Check Out");
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        b7.setBounds(10,270,200,30);
        add(b7);
         b7.addActionListener(this);
         
         b8 = new JButton("Update Check Status");
        b8.setBackground(Color.BLACK);
        b8.setForeground(Color.WHITE);
        b8.setBounds(10,310,200,30);
        add(b8);
         b8.addActionListener(this);
         
         b9 = new JButton("Update Room Status");
        b9.setBackground(Color.BLACK);
        b9.setForeground(Color.WHITE);
        b9.setBounds(10,350,200,30);
        add(b9);
         b9.addActionListener(this);
         
         b10 = new JButton("Pick Up Service");
        b10.setBackground(Color.BLACK);
        b10.setForeground(Color.WHITE);
        b10.setBounds(10,390,200,30);
        add(b10);
         b10.addActionListener(this);
         
         b11 = new JButton("Search Room");
        b11.setBackground(Color.BLACK);
        b11.setForeground(Color.WHITE);
        b11.setBounds(10,430,200,30);
        add(b11);
         b11.addActionListener(this);
         
         b12 = new JButton("Logout");
        b12.setBackground(Color.BLACK);
        b12.setForeground(Color.WHITE);
        b12.setBounds(10,470,200,30);
        add(b12);
         b12.addActionListener(this);
         
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/fourth.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(230,30,500,470);
        add(l1);
        setLayout(null);
      setBounds(250,130,800,550);
      setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
    if(ae.getSource()== b1)
    {
    new AddCustomer();
    this.setVisible(false);
    }
    else  if(ae.getSource()== b2)
    {
    new AllRooms();
    this.setVisible(false);
    }
     else  if(ae.getSource()== b3)
    {
    new Department();
    setVisible(false);
    }
     else  if(ae.getSource()== b4)
    {
    new AllEmployee();
    this.setVisible(false);
    }
     else  if(ae.getSource()== b5)
    {
    new CustomerInfo();
    this.setVisible(false);
    }
     else  if(ae.getSource()== b6)
    {
    new AllManager();
    this.setVisible(false);
    }
     else  if(ae.getSource()== b7)
    {
    new CheckOut();
    setVisible(false);
    }
     else  if(ae.getSource()== b8)
    {
    new UpdateCheck();
    setVisible(false);
    }
     else  if(ae.getSource()== b9)
    {
    new UpdateRoom();
    this.setVisible(false);
    }
     else  if(ae.getSource()== b10)
    {
    new PickUp();
    setVisible(false);
    }
     else  if(ae.getSource()== b11)
    {
    new SearchRoom();
    setVisible(false);
    }
     else  if(ae.getSource()== b12)
    {
        
    setVisible(false);
    System.exit(0);
    }
   
    
    
    
    
    }
     
    public static void main(String[] args)
    {
    new Reception();
    
    }
}

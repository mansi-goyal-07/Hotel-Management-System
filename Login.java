
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JLabel l1,l2;
    JTextField t1;
    JPasswordField p1;
    JButton b1,b2;
    
    public Login()
    {
    setBounds(350,200,530,280);
    l1 = new JLabel("Username");
    l1.setBounds(30,20,100,30);
    add(l1);
    l2 = new JLabel("Password");
    l2.setBounds(30,70,100,30);
    add(l2);
    t1 = new JTextField();
    t1.setBounds(140,25,150,25);
    add(t1);
    p1 = new JPasswordField();
    p1.setBounds(140,75,150,25);
    add(p1);
    b1 = new JButton("Login");
    b1.setBackground(Color.BLACK);
    b1.setForeground(Color.WHITE);
    b1.setBounds(30,140,110,30);
    add(b1);
    b1.addActionListener(this);
      b2 = new JButton("Cancel");
    b2.setBackground(Color.BLACK);
    b2.setForeground(Color.WHITE);
    b2.setBounds(170,140,110,30);
    add(b2);
    b2.addActionListener(this);    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/second.jpg"));
    Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel l3 = new JLabel(i3);
    l3.setBounds(320,6,200,200);
    add(l3);
    getContentPane().setBackground(Color.WHITE);
    this.setLayout(null);
    setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent e)
    {
    if(e.getSource()== b1)
    {
    String username = t1.getText();
    String password = p1.getText();
    conn con = new conn();
    
    String sql = "Select * from login where username = '"+username+"' and password = '"+password+"'  ";
    try{
   ResultSet rs =  con.s.executeQuery(sql);
   if(rs.next())
   {
  
   this.setVisible(false);
   new Dashboard();
   }
   else
   {
   JOptionPane.showMessageDialog(null,"Invalid Username or Password");
   this.setVisible(false);
   
   }
    }
    
    catch(Exception ae){
    
    System.out.println(ae);
    }
            
    
    }
    if(e.getSource()== b2)
    {
    
    System.exit(0);
    }
    
    }
    
    public static void main(String args[])
    {
    
    new Login();
    
    
    }
    
    
    
}

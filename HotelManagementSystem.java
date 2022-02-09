/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {
    
    JButton b1;
     public HotelManagementSystem()
     {
     
     
     setExtendedState(JFrame.MAXIMIZED_BOTH);
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/first.jpg"));
     Image i2 = i1.getImage().getScaledInstance(1300,680,Image.SCALE_DEFAULT);
     ImageIcon i3 = new ImageIcon(i2);
     JLabel l1 = new JLabel(i3);
     l1.setBounds(0,0,1300,680);
     add(l1);
     JLabel l2 = new JLabel("Hotel Management System");
     l2.setBounds(40,560,1000,100);
     l2.setForeground(Color.YELLOW);
     l2.setFont(new Font("serif",Font.PLAIN,60));
     l1.add(l2);
     b1 = new JButton("Next");
     b1.setBounds(1000,600,150,40);
     b1.setForeground(Color.BLACK);
     b1.setBackground(Color.WHITE);
     b1.addActionListener(this);
     l1.add(b1);     
     
    
     setLayout(null);
     setVisible(true);
     while(true)
     {
     l2.setVisible(false);
     try
     {
         Thread.sleep(500);
     }
     catch(Exception e){}
     
     l2.setVisible(true);
     try
     {
         Thread.sleep(500);
     }
     catch(Exception e){}
     
     }
     
     }
     
     public void actionPerformed(ActionEvent ae)
     {
         this.setVisible(false);
         new Login();
     }

    public static void main(String[] args) {
        
        
      new HotelManagementSystem();
        
    }
    
}

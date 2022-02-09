
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener {

    JButton b1,b2;
    JTextField t1,t2;
    JComboBox c1,c2,c3;
    
public AddRooms()
{
    setBounds(250,130,800,450);
    getContentPane().setBackground(Color.WHITE);
    
    JLabel l1 = new JLabel("Add Rooms");
    l1.setBounds(150,20,100,20);
    l1.setFont(new Font("Tahoma",Font.BOLD,18));
    add(l1);
    
    JLabel room = new JLabel("Room Number");
    room.setBounds(60,70,120,30);
    room.setFont(new Font("Tahoma",Font.PLAIN,16));
    add(room);
    
     t1 = new JTextField();
     t1.setBounds(200,70,150,30);
     add(t1);
     
     JLabel available = new JLabel("Available");
    available.setBounds(60,120,120,30);
    available.setFont(new Font("Tahoma",Font.PLAIN,16));
    add(available);
    
   
    c1 = new JComboBox(new String[] {"Available","Occupied"});
    c1.setBounds(200,120,150,30);
    c1.setBackground(Color.WHITE);
    add(c1);
    
     JLabel status  = new JLabel("Cleaning Status");
    status.setBounds(60,170,120,30);
    status.setFont(new Font("Tahoma",Font.PLAIN,16));
    add(status);
    
    
    c2 = new JComboBox(new String[] {"Clean","Dirty"});
    c2.setBounds(200,170,150,30);
     c2.setBackground(Color.WHITE);
    add(c2);
    
     JLabel price = new JLabel("Price");
    price.setBounds(60,220,120,30);
    price.setFont(new Font("Tahoma",Font.PLAIN,16));
    add(price);
    
    
     t2 = new JTextField();
     t2.setBounds(200,220,150,30);
     add(t2);
     
     JLabel type = new JLabel("Bed Type");
    type.setBounds(60,270,120,30);
    type.setFont(new Font("Tahoma",Font.PLAIN,16));
    add(type);
    
      
    c3 = new JComboBox(new String[] {"Single Bed","Double Bed"});
    c3.setBounds(200,270,150,30);
     c3.setBackground(Color.WHITE);
    add(c3);
    
    b1 = new JButton("Add Room");
    b1.setBounds(60,330,130,30);
    b1.setBackground(Color.BLACK);
    b1.setForeground(Color.WHITE);
    add(b1);
    b1.addActionListener(this);
    
      b2 = new JButton("Cancel");
    b2.setBounds(220,330,130,30);
    b2.setBackground(Color.BLACK);
    b2.setForeground(Color.WHITE);
    add(b2);
    b2.addActionListener(this);
    
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/twelve.jpg"));
    Image i2 = i1.getImage().getScaledInstance(600,330, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel l2 = new JLabel(i3);
    l2.setBounds(380,30,380,330);
    add(l2);
    setLayout(null);
    setVisible(true);

}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
String room = t1.getText();
String available = c1.getSelectedItem().toString();
String status = c2.getSelectedItem().toString();
String price = t2.getText();
String type = c3.getSelectedItem().toString();

conn con = new conn();

try
{
  String sql = "Insert into room values('"+room+"','"+available+"','"+status+"','"+price+"','"+type+"')";
  con.s.executeUpdate(sql);
  JOptionPane.showMessageDialog(null,"Room Added");
  this.setVisible(false);
}
catch(Exception e)
{
}
}

if(ae.getSource()==b2)
{
this.setVisible(false);

}


}

public static void main(String args[])
{
new AddRooms();

}
        
    
}

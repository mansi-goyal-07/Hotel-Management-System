
package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener{
    
    JTextField t1,t2,t3,t4,t5;
    JRadioButton r1,r2;
    JComboBox c1;
    JButton b1,b2;
    public AddDriver()
    {
        getContentPane().setBackground(Color.WHITE);
        JLabel title = new JLabel("Add Driver");
        title.setBounds(150,10,150,30);
        title.setFont(new Font("Tahoma",Font.BOLD,18));
        add(title);
    JLabel name = new JLabel("Name");
    name.setBounds(60,70,100,30);
    name.setFont(new Font("Tahoma",Font.PLAIN,17));
    add(name);
    
    t1 = new JTextField();
    t1.setBounds(200,70,150,30);
    add(t1);
    
     JLabel age = new JLabel("Age");
    age.setBounds(60,120,100,30);
    age.setFont(new Font("Tahoma",Font.PLAIN,17));
    add(age);
    
     
    t2 = new JTextField();
    t2.setBounds(200,120,150,30);
    add(t2);
    
     JLabel gender = new JLabel("Gender");
    gender.setBounds(60,170,100,30);
    gender.setFont(new Font("Tahoma",Font.PLAIN,17));
    add(gender);
    
     r1 = new JRadioButton("Male");
    r1.setBounds(200,170,70,30);
    r1.setFont(new Font("Tahoma",Font.PLAIN,17));
    r1.setBackground(Color.WHITE);
    add(r1);
     r2 = new JRadioButton("Female");
    r2.setBounds(280,170,90,30);
    r2.setFont(new Font("Tahoma",Font.PLAIN,17));
    r2.setBackground(Color.WHITE);
    add(r2);
    ButtonGroup bg = new ButtonGroup();
    bg.add(r1);
    bg.add(r2);
    
     JLabel car = new JLabel("Car Company");
    car.setBounds(60,220,100,30);
    car.setFont(new Font("Tahoma",Font.PLAIN,17));
    add(car);
    
      
    t3 = new JTextField();
    t3.setBounds(200,220,150,30);
    add(t3);
    
    
    
     JLabel model = new JLabel("Car Model");
    model.setBounds(60,270,100,30);
    model.setFont(new Font("Tahoma",Font.PLAIN,17));
    add(model);
    
      
    t4 = new JTextField();
    t4.setBounds(200,270,150,30);
    add(t4);
    
     JLabel available = new JLabel("Available");
    available.setBounds(60,320,100,30);
    available.setFont(new Font("Tahoma",Font.PLAIN,17));
    add(available);
    
    
    c1 = new JComboBox(new String[] {"Available","Busy"});
    c1.setBounds(200,320,150,30);
    c1.setBackground(Color.WHITE);
    add(c1);
    
     JLabel location = new JLabel("Location");
    location.setBounds(60,370,100,30);
    location.setFont(new Font("Tahoma",Font.PLAIN,17));
    add(location);
    
      
    t5 = new JTextField();
    t5.setBounds(200,370,150,30);
    add(t5);
    
      b1 = new JButton("Add Driver");
    b1.setBounds(60,420,130,30);
    b1.setBackground(Color.BLACK);
    b1.setForeground(Color.WHITE);
    add(b1);
    b1.addActionListener(this);
    
      b2 = new JButton("Cancel");
    b2.setBounds(220,420,130,30);
    b2.setBackground(Color.BLACK);
    b2.setForeground(Color.WHITE);
    add(b2);
    b2.addActionListener(this);
  
  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eleven.jpg"));
    Image i2 = i1.getImage().getScaledInstance(400,330, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel l2 = new JLabel(i3);
    l2.setBounds(380,70,400,330);
    add(l2);
    
    setLayout(null);
    setBounds(240,130,820,520);
    setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
    if(ae.getSource()==b1)
    {
    conn con = new conn();
    
    String name = t1.getText();
    String age = t2.getText();
     
    String gender = null;
    if(r1.isSelected())
    {
        gender = "Male";
    
    }
    else if(r2.isSelected())
    {
    gender = "Female";
    }
    
    String car = t3.getText();
    String model = t4.getText();
    String available = c1.getSelectedItem().toString();
    String location = t5.getText();
    
    String sql = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+car+"','"+model+"','"+available+"','"+location+"')";
    try
    {
    con.s.executeUpdate(sql);
     JOptionPane.showMessageDialog(null,"New Driver Added");
     this.setVisible(false);
    }
    catch(Exception e)
    {}
        
    }
    else if(ae.getSource()==b2)
    {
    
    setVisible(false);
    }
    
    
    }
    
    public static void main(String args[])
    {
    new AddDriver();
    
    }
    
}

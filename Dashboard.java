
package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Dashboard extends JFrame implements ActionListener{
    
    
    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1,i2,i3,i4;
    public Dashboard()
    {
    
    mb = new JMenuBar();
    mb.setBounds(0,0,1300,30);
    add(mb);
    m1 = new JMenu("Hotel Management");
    m1.setForeground(Color.RED);
    mb.add(m1);
    m2 = new JMenu("Admin");
    m2.setForeground(Color.BLUE);
    mb.add(m2);
    
    i1 = new JMenuItem("Reception");
    m1.add(i1);
    i1.addActionListener(this);
    
     i2 = new JMenuItem("Add Employee");
    m2.add(i2);
      i2.addActionListener(this);
    
     i3 = new JMenuItem("Add Room");
    m2.add(i3);
      i3.addActionListener(this);
    
     i4 = new JMenuItem("Add Driver");
    m2.add(i4);
      i4.addActionListener(this);
    
    ImageIcon im1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/third.jpg"));
    Image im2 = im1.getImage().getScaledInstance(1300, 650, Image.SCALE_DEFAULT);
    ImageIcon im3 = new ImageIcon(im2);
    JLabel l1 = new JLabel(im3);
    l1.setBounds(0,30,1300,650);
    add(l1);
    
    JLabel l2 = new JLabel("THE TAJ GROUP WELCOMES YOU");
    l2.setBounds(350,20,1000,50);
    l2.setForeground(Color.WHITE);
    l2.setFont(new Font("Tahoma",Font.PLAIN,40));
    l1.add(l2);
    
    
    setLayout(null);
    setBounds(0,0,1300,680);
     setExtendedState(JFrame.MAXIMIZED_BOTH);
    setVisible(true);
    
    
    }
    
    public void actionPerformed(ActionEvent ae)
    {
    if(ae.getActionCommand().equals("Add Employee"))
    {
    new AddEmployee();
    }
    else if(ae.getActionCommand().equals("Add Room"))
    {
    new AddRooms();
    }
    else if(ae.getActionCommand().equals("Add Driver"))
    {
    
    new AddDriver();
    }
    else if(ae.getActionCommand().equals("Reception"))
    {
    new Reception();
    
    }
    }
    
    public static void main(String[] args)
    {
    new Dashboard();
    
    }
    
}

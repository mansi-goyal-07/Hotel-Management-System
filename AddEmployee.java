
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddEmployee extends JFrame implements ActionListener {
    
    JTextField t1,t2,t3,t4,t5,t6;
    JRadioButton r1,r2;
    JComboBox c1;
    JButton b1;
    
    public AddEmployee()
    {
    setBounds(250,130,800,520);
    
    getContentPane().setBackground(Color.WHITE);
    JLabel name = new JLabel("NAME");
    name.setBounds(60,30,50,30);
    name.setFont(new Font("Tahoma",Font.PLAIN,17));
    add(name);
    t1 = new JTextField();
    t1.setBounds(150,30,160,30);
    add(t1);
    
     JLabel age = new JLabel("AGE");
    age.setBounds(60,80,50,30);
    age.setFont(new Font("Tahoma",Font.PLAIN,17));
    add(age);
    t2 = new JTextField();
    t2.setBounds(150,80,160,30);
    add(t2);
    
     JLabel gender = new JLabel("GENDER");
    gender.setBounds(60,130,70,30);
    gender.setFont(new Font("Tahoma",Font.PLAIN,17));
    add(gender);
    
    r1 = new JRadioButton("Male");
    r1.setBounds(150,130,70,30);
    r1.setFont(new Font("Tahoma",Font.PLAIN,17));
    r1.setBackground(Color.WHITE);
    add(r1);
     r2 = new JRadioButton("Female");
    r2.setBounds(230,130,90,30);
    r2.setFont(new Font("Tahoma",Font.PLAIN,17));
    r2.setBackground(Color.WHITE);
    add(r2);
    ButtonGroup bg = new ButtonGroup();
    bg.add(r1);
    bg.add(r2);
    
    
      JLabel job= new JLabel("JOB");
    job.setBounds(60,180,50,30);
    job.setFont(new Font("Tahoma",Font.PLAIN,17));
    add(job);
    
    String str[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
    c1 = new JComboBox(str);
    c1.setBounds(150,180,160,30);
    c1.setBackground(Color.WHITE);
    add(c1);
    
     JLabel salary= new JLabel("SALARY");
    salary.setBounds(60,230,70,30);
    salary.setFont(new Font("Tahoma",Font.PLAIN,17));
    add(salary);
     t3 = new JTextField();
    t3.setBounds(150,230,160,30);
    add(t3);
    
     
    JLabel phone= new JLabel("PHONE");
    phone.setBounds(60,280,70,30);
    phone.setFont(new Font("Tahoma",Font.PLAIN,17));
    add(phone);
    t4 = new JTextField();
    t4.setBounds(150,280,160,30);
    add(t4);
    
      JLabel adhar= new JLabel("ADHAR");
    adhar.setBounds(60,330,70,30);
    adhar.setFont(new Font("Tahoma",Font.PLAIN,17));
    add(adhar);
     t5 = new JTextField();
    t5.setBounds(150,330,160,30);
    add(t5);
    
    JLabel email= new JLabel("EMAIL");
    email.setBounds(60,380,70,30);
    email.setFont(new Font("Tahoma",Font.PLAIN,17));
    add(email);
    t6 = new JTextField();
    t6.setBounds(150,380,160,30);
    add(t6);
    
    b1 = new JButton("Submit");
    b1.setBackground(Color.BLACK);
    b1.setForeground(Color.WHITE);
    b1.setBounds(150,430,160,30);
    add(b1);
    b1.addActionListener(this);
    
    JLabel l2 = new JLabel("Add Employee Details");
    l2.setForeground(Color.BLUE);
    l2.setBounds(410,20,400,50);
    l2.setFont(new Font("Tahoma",Font.PLAIN,30));
    add(l2);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tenth.jpg"));
    Image i2 = i1.getImage().getScaledInstance(500,450,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel l1 = new JLabel(i3);
    l1.setBounds(320,80,500,460);
    add(l1);
    
    setLayout(null);
    setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae)
    {
    String name = t1.getText();
    String age = t2.getText();
    String salary = t3.getText();
    String phone = t4.getText();
    String adhar = t5.getText();
    String email = t6.getText();
    
    String gender = null;
    if(r1.isSelected())
    {
        gender = "Male";
    
    }
    else if(r2.isSelected())
    {
    gender = "Female";
    }
    
    String job = c1.getSelectedItem().toString();
    
    conn con = new conn();
    
    String sql = "insert into employee values ('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+adhar+"','"+email+"')";
    try
    {
       con.s.executeUpdate(sql);
       JOptionPane.showMessageDialog(null,"New Employee Added");
       this.setVisible(false);
    
    }
    catch(Exception e){}
    
    }
    public static void main(String args[])
            
    {
    new AddEmployee();
    
    
    }
    
}

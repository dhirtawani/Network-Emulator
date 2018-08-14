import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.text.*;
import java.util.concurrent.TimeUnit;

public class Ping2 extends JFrame implements ActionListener
{
	static long start,stop,te;
	static int diff;
	static JTextField addr,number;
	static JButton submit;
	static JLabel label,num;
	static JRadioButton firstButton,secondButton,thirdButton;
    	static ButtonGroup group;
	static JTextArea a,n;

	Ping2()
    {	
	a=new JTextArea("This ping command option will resolve, if possible, the hostname of an IP address target.");
	n=new JTextArea("This option sets the number of ICMP Echo Requests to send, from 1 to 4294967295. The ping command will send 3 by default if -n isn't used.");

	a.setLineWrap(true);
	a.setWrapStyleWord(true);

	n.setLineWrap(true);
	n.setWrapStyleWord(true);
	
	label=new JLabel("Enter Your URL/IP");
	num=new JLabel("Enter Number of packets");
	addr=new JTextField(40);
	number=new JTextField(40);
	submit=new JButton("SUBMIT");

	firstButton = new JRadioButton("-a");
	firstButton.setActionCommand("-a");

	secondButton = new JRadioButton("-n"); 
	secondButton.setActionCommand("-n");

	thirdButton = new JRadioButton("default");
	thirdButton.setActionCommand("default");
	
	 group = new ButtonGroup();
   	 group.add(firstButton);
    	 group.add(secondButton);
	 group.add(thirdButton);
	setVisible(true);
	
	firstButton.addActionListener(this);
	secondButton.addActionListener(this);
	thirdButton.addActionListener(this);
	submit.addActionListener(this);
	setSize(600,600);
	setLayout(new GridLayout(10,1,5,5));
	add(firstButton);
	add(a);
	add(secondButton);
	add(n);
	add(thirdButton);
	add(label);
	add(addr);
	add(num);
	add(number);
	add(submit);
    }
	

	public void actionPerformed(ActionEvent ae)
	{ 
	if(ae.getSource()==submit)
	{
	String choice = group.getSelection().getActionCommand();
	if(choice.compareTo("-a")==0)
	{Ping1a();}
	else if(choice.compareTo("-n")==0)
	{Ping1n();}
	else if(choice.compareTo("default")==0)
	{Ping1();}
	
	}
	}

	
	public void Ping1a()
	{
	try
        {
	start=System.nanoTime(); 
	String domainName = addr.getText();
	//System.out.println(domainName);//
	String command = "cmd /c start cmd.exe /k ping -a " + domainName;
   	Process child = Runtime.getRuntime().exec(command);
	stop=System.nanoTime();
	te=stop-start;
	System.out.println("Execution Time in nano seconds for ping:" + te);
        }
        catch (Exception e)
        {
            System.out.println("HEY Buddy ! U r Doing Something Wrong ");
            e.printStackTrace();
        }
	}
	
	public void Ping1n()
	{
	try
        {
	start=System.nanoTime();
	String domainName = addr.getText();
	String Num = number.getText();
	String temp =" ";
	System.out.println(temp);
	String command = "cmd /c start cmd.exe /k ping -n " + Num + temp + domainName;
   	Process child = Runtime.getRuntime().exec(command);
	stop=System.nanoTime();
	te=stop-start;
	System.out.println("Execution Time in nano seconds for ping:" + te);
        }
        catch (Exception e)
        {
            System.out.println("HEY Buddy ! U r Doing Something Wrong ");
            e.printStackTrace();
        }
	
	}

	public void Ping1()
	{
	try
        { 
	start=System.nanoTime();
	String domainName = addr.getText();
	//System.out.println(domainName);//
	String command = "cmd /c start cmd.exe /k ping -n 3 " + domainName;
   	Process child = Runtime.getRuntime().exec(command);
	stop=System.nanoTime();
	te=stop-start;
	System.out.println("Execution Time in nano seconds for ping:" + te);
        }
        catch (Exception e)
        {
            System.out.println("HEY Buddy ! U r Doing Something Wrong ");
            e.printStackTrace();
        }

	}
	public static void main(String args[])
	{new Ping2();}
}
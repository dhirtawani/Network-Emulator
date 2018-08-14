import java.util.concurrent.TimeUnit;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.text.*;
class Tracert extends JFrame implements ActionListener
{
	static JTextField addr,number;
	static JButton submit;
	static JLabel label,num;
	static JRadioButton firstButton,secondButton;
	static long start,stop,te;
	static ButtonGroup group;
	static int diff;
	static JTextArea d,h;
    Tracert()
    {
	d=new JTextArea("This option prevents tracert from resolving IP addresses to hostnames, often resulting in much faster results.");
	h=new JTextArea("This tracert option specifies the maximum number of hops in the search for the target. If you do not specify MaxHops, and a target has not been found by 30 hops, tracert will stop looking.");

	d.setLineWrap(true);
	d.setWrapStyleWord(true);
	
	h.setLineWrap(true);
	h.setWrapStyleWord(true);

	label=new JLabel("Enter Your URL/IP");
	num=new JLabel("Enter the no of hops:");
	addr=new JTextField(40);
	number=new JTextField(40);
	submit=new JButton("SUBMIT");

	firstButton = new JRadioButton("-d");
	firstButton.setActionCommand("-d");

	secondButton = new JRadioButton("-h"); 
	secondButton.setActionCommand("-h");
	
	 group = new ButtonGroup();
   	 group.add(firstButton);
    	 group.add(secondButton);
	setVisible(true);
	
	firstButton.addActionListener(this);
	secondButton.addActionListener(this);
	submit.addActionListener(this);
	setSize(600,600);
	setLayout(new GridLayout(10,1,5,5));
	add(firstButton);
	add(d);
	add(secondButton);
	add(h);
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
	if(choice.compareTo("-d")==0)
	{Ping1a();}
	else if(choice.compareTo("-h")==0)
	{Ping1n();}
	}
	}

        public void Ping1a()
	{
	try
        {
	start=System.nanoTime(); 
	String domainName = addr.getText();
	//System.out.println(domainName);//
	String command = "cmd /c start cmd.exe /k tracert -d " + domainName;
   	Process child = Runtime.getRuntime().exec(command);
	stop=System.nanoTime();
	te=stop-start;
	System.out.println("Execution Time in nano seconds for tracert:" + te);
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
	String command = "cmd /c start cmd.exe /k tracert -h " + Num + temp + domainName;
   	Process child = Runtime.getRuntime().exec(command);
	stop=System.nanoTime();
	te=stop-start;
	System.out.println("Execution Time in nano seconds for tracert:" + te);
        }
        catch (Exception e)
        {
            System.out.println("HEY Buddy ! U r Doing Something Wrong ");
            e.printStackTrace();
        }
	}
    	
	public static void main(String args[])
	{new Tracert();}
}
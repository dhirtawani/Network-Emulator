import java.util.concurrent.TimeUnit;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.text.*;

class Netstat extends JFrame implements ActionListener
{
	static long start,stop,te;
	static int diff;
	static JRadioButton firstButton,secondButton;
    	static ButtonGroup group;
	static JButton submit;
	static JTextArea r,y;
	
    Netstat()
    {
	r=new JTextArea("Execute netstat with -r to show the IP routing table. This is the same as using the route command to execute route print.");
	y=new JTextArea("The -y switch can be used to show the TCP connection template for all connection. You cannot use -y with any other netstat option.");
	submit=new JButton("SUBMIT");

	r.setLineWrap(true);
	r.setWrapStyleWord(true);

	y.setLineWrap(true);
	y.setWrapStyleWord(true);

	firstButton = new JRadioButton("-r");
	firstButton.setActionCommand("-r");

	secondButton = new JRadioButton("-y"); 
	secondButton.setActionCommand("-y");

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
	add(r);
	add(secondButton);
	add(y);
	add(submit);
   }



	
	public void actionPerformed(ActionEvent ae)
	{ 
	if(ae.getSource()==submit)
	{
	String choice = group.getSelection().getActionCommand();
	if(choice.compareTo("-r")==0)
	{Ping1a();}
	else if(choice.compareTo("-y")==0)
	{Ping1n();}
	
	}
	}

	public void Ping1a()
	{
        try
        { 
	start=System.nanoTime();
         Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"netstat -r\"");
        stop=System.nanoTime();
	te=stop-start;
	System.out.println("Execution Time in nano seconds for netstat:" + te);
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
         Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"netstat -y\"");
        stop=System.nanoTime();
	te=stop-start;
	System.out.println("Execution Time in nano seconds for netstat:" + te);
	}
        catch (Exception e)
        {
            System.out.println("HEY Buddy ! U r Doing Something Wrong ");
            e.printStackTrace();
        }
   	}

	public static void main(String args[])
	{new Netstat();}
}
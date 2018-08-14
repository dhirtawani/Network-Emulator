import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.text.*;
import java.util.concurrent.TimeUnit;

class IpConfig extends JFrame implements ActionListener
{
	static long start,stop,te;
	static int diff;
	static JRadioButton firstButton,secondButton;
    	static ButtonGroup group;
	static JButton submit;
	static JTextArea all,disp;
    IpConfig()
    {
	all=new JTextArea("This option displays the same IP addressing information for each adapter as the default option. Additionally, it displays DNS and WINS settings for each adapter.");
	disp=new JTextArea("These options access a local DNS cache that Windows maintains. The /displaydns option prints the contents of the cache, and the /flushdns option erases the contents.");

	all.setLineWrap(true);
	all.setWrapStyleWord(true);

	disp.setLineWrap(true);
	disp.setWrapStyleWord(true);	

	firstButton = new JRadioButton("/all");
	firstButton.setActionCommand("/all");
	submit=new JButton("SUBMIT");
	
	secondButton = new JRadioButton("/displaydns"); 
	secondButton.setActionCommand("/displaydns");
	
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
	add(all);
	add(secondButton);
	add(disp);
	add(submit);
   }

	public void actionPerformed(ActionEvent ae)
	{ 
	if(ae.getSource()==submit)
	{
	String choice = group.getSelection().getActionCommand();
	if(choice.compareTo("/all")==0)
	{Ping1a();}
	else if(choice.compareTo("/displaydns")==0)
	{Ping1n();}
	}
	}
	
	public void Ping1a()
	{
        try
        { 
	start=System.nanoTime();
         Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"ipconfig /all\"");
	stop=System.nanoTime();
	te=stop-start;
	System.out.println("Execution Time in nano seconds for ipconfig:" + te);
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
         Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"ipconfig /displaydns\"");
	stop=System.nanoTime();
	te=stop-start;
	System.out.println("Execution Time in nano seconds for ipconfig:" + te);
        }
        catch (Exception e)
        {
            System.out.println("HEY Buddy ! U r Doing Something Wrong ");
            e.printStackTrace();
        }
    	}	

	public static void main(String args[])
	{new IpConfig();}
}
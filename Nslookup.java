import java.util.concurrent.TimeUnit;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.text.*;
class Nslookup extends JFrame implements ActionListener
{
	static JTextField addr;
	static JButton submit;
	static JLabel label;
	static long start,stop,te;
    Nslookup()
    {

	label=new JLabel("Enter Your URL/IP");
	addr=new JTextField(40);
	submit=new JButton("SUBMIT");
	setVisible(true);
	
	submit.addActionListener(this);
	setSize(600,600);
	setLayout(new GridLayout(10,1,5,5));
	add(label);
	add(addr);
	add(submit);
    }
	
	public void actionPerformed(ActionEvent ae)
	{ 
	if(ae.getSource()==submit)
	{Ping1a();}
	}

        public void Ping1a()
	{
	try
        {
	start=System.nanoTime(); 
	String domainName = addr.getText();
	//System.out.println(domainName);//
	String command = "cmd /c start cmd.exe /k nslookup " + domainName;
   	Process child = Runtime.getRuntime().exec(command);
	stop=System.nanoTime();
	te=stop-start;
	System.out.println("Execution Time in nano seconds for nslookup:" + te);
        }
        catch (Exception e)
        {
            System.out.println("HEY Buddy ! U r Doing Something Wrong ");
            e.printStackTrace();
        }
	}

    	
	public static void main(String args[])
	{new Nslookup();}
}
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.text.*;

public class Emulator extends JFrame implements ActionListener
{
static JButton ping,tracert,netstat,nslookup,ipconfig; 
static JTextArea lping,ltracert,lnetstat,lnslookup,lipconfig;

Emulator()
{
lping=new JTextArea("The ping command is a Command Prompt command used to test the ability of the source computer to reach a specified destination computer. The ping command is usually used as a simple way to verify that a computer can communicate over the network with another computer or network device.");

ltracert=new JTextArea("The tracert command is a Command Prompt command that's used to show several details about the path that a packet takes from the computer or device you're on to whatever destination you specify.");

lnetstat=new JTextArea("The netstat command is a Command Prompt command used to display very detailed information about how your computer is communicating with other computers or network devices.");

lnslookup=new JTextArea("nslookup (which stands for name server lookup) is a network utility program used to obtain information about internet servers. As its name suggests, it finds name server information for domains by querying the Domain Name System (DNS).");

lipconfig=new JTextArea("ipconfig is a command line utility available on all versions of Microsoft Windows starting with Windows NT. ipconfig is designed to be run from the Windows command prompt. This utility allows you to get the IP address information of a Windows computer.");

lping.setLineWrap(true);
lping.setWrapStyleWord(true);

ltracert.setLineWrap(true);
ltracert.setWrapStyleWord(true);

lnetstat.setLineWrap(true);
lnetstat.setWrapStyleWord(true);

lnslookup.setLineWrap(true);
lnslookup.setWrapStyleWord(true);

lipconfig.setLineWrap(true);
lipconfig.setWrapStyleWord(true);
  
ping= new JButton("PING");
tracert= new JButton("TRACERT");
netstat= new JButton("NETSTAT");
nslookup= new JButton("NSLOOKUP");
ipconfig= new JButton("IPCONFIG");
setVisible(true);

ping.addActionListener(this);
netstat.addActionListener(this);
tracert.addActionListener(this);
nslookup.addActionListener(this);
ipconfig.addActionListener(this);

setSize(600,600);

setLayout(new GridLayout(10,1,5,5));
add(ping);
add(lping);
add(netstat);
add(lnetstat);
add(tracert);
add(ltracert);
add(nslookup);
add(lnslookup);
add(ipconfig);
add(lipconfig);
}

public void actionPerformed(ActionEvent ae)
{ 
if(ae.getSource()==ping)
{
new Ping2();
}

if(ae.getSource()==netstat)
{
new Netstat();
}
if(ae.getSource()==tracert)
{
new Tracert();
}
if(ae.getSource()==nslookup)
{
new Nslookup();
}
if(ae.getSource()==ipconfig)
{
new IpConfig();
}

}


public static void main(String q[])
{ Emulator bk=new Emulator();}
}
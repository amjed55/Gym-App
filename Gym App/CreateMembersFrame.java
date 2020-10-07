import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.io.*;
import java.util.*;

public class CreateMembersFrame extends JFrame{
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 700;
    private static final int FEILD_SIZE = 20;
    
    private JButton     create = new JButton("Create");
    private JTextField  nameTF = new JTextField(FEILD_SIZE);
    private JLabel      name = new JLabel("Name: ");
    private JTextField  emailTF = new JTextField(FEILD_SIZE);
    private JLabel      email = new JLabel("Email: ");
    private JTextField  numberTF = new JTextField(FEILD_SIZE);
    private JLabel  number = new JLabel("Phone Number: ");
    private JTextField  addressTF = new JTextField(FEILD_SIZE);
    private JLabel  address = new JLabel("Address: ");
    private JTextField  ECNTF = new JTextField(FEILD_SIZE);
    private JLabel  ECN = new JLabel("Emergency Contact Name: ");
    private JTextField  ECPTF = new JTextField(FEILD_SIZE);
    private JLabel  ECP = new JLabel("Emergency Contact Phone Number: ");
    private JPanel wholePnl = new JPanel(new FlowLayout());//Whole panel
    
    private JButton     back = new JButton("Back");
    private boolean emailCond = true;
    
    
    CreateMembersFrame(){
        setTitle("Create Members");
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setVisible(true);
        JPanel namePnl = new JPanel(new FlowLayout());
        JPanel emailPnl = new JPanel(new FlowLayout());
        JPanel numberPnl = new JPanel(new FlowLayout());
        JPanel addressPnl = new JPanel(new FlowLayout());
        JPanel ECNPnl = new JPanel(new FlowLayout());
        JPanel ECPPnl = new JPanel(new FlowLayout());
        wholePnl.setLayout(new GridLayout(7, 1));
        namePnl.add(name);
        namePnl.add(nameTF);
        emailPnl.add(email);
        emailPnl.add(emailTF);
        numberPnl.add(number);
        numberPnl.add(numberTF);
        addressPnl.add(address);
        addressPnl.add(addressTF);
        ECNPnl.add(ECN);
        ECNPnl.add(ECNTF);
        ECPPnl.add(ECP);
        ECPPnl.add(ECPTF);
        
        wholePnl.add(namePnl);
        wholePnl.add(emailPnl);
        wholePnl.add(numberPnl);
        wholePnl.add(addressPnl);
        wholePnl.add(ECNPnl);
        wholePnl.add(ECPPnl);
        wholePnl.add(create);
        wholePnl.add(back);
        add(wholePnl, BorderLayout.CENTER);
        
        ActionListener listener = new createButtonListener();
        create.addActionListener(listener);
        listener = new backButtonListener();
        back.addActionListener(listener);
    }
    
     class backButtonListener implements ActionListener {  
          public void actionPerformed(ActionEvent event) {
              MemberMangagmentFrame memMng = new MemberMangagmentFrame();
              memMng.setVisible(true);
              CreateMembersFrame.super.dispose();
            }
        }
    
    class createButtonListener implements ActionListener {  
          public void actionPerformed(ActionEvent event) {
             Scanner sc = new Scanner(System.in);
             String name = nameTF.getText() ;
             String email = emailTF.getText();
             String pNum = numberTF.getText();
             String address = addressTF.getText();
             String eCN = ECNTF.getText();
             String eCP = ECPTF.getText();
	     Members member = new Members(name, email, pNum, address, eCN, eCP, 0.00);
	     String fullLine = email;
	     
    try 
    {
    File file = new File("MembersLog.txt");
    if (!file.exists()){throw new FileNotFoundException();}
    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) 
    {
      String line = scanner.nextLine();
      if(line.equals(email)) 
      { 
       System.out.println("Email in use.");
       emailCond = false;
       break;
      }
    }
    
    if(emailCond)
    {
        Main.allMems.add(member);
         try {
            
        BufferedWriter out = new BufferedWriter(new FileWriter("MembersLog.txt",true));
         {
               // out.write("First Name    " + "Last Name    " + "Phone Number    " + "Street Address    " + "Email Address    " + "Emergency Contact Name    "+ "Emergency Contact Phone    " + "\n");
              
               // out.write(firstName +" "+ lastName+ "    " + phoneNumber +"    " + email + "    " + address + "    " + eCN + "    " + eCP + "    "  + "\n");
                out.write(fullLine);
               out.newLine();
            }
            System.out.println("User saved in log");
            out.close();
        } catch (IOException e) {};
    }
    
} catch(FileNotFoundException e) {
    System.out.println("File not found");
}
	     
	      }
	   }
}
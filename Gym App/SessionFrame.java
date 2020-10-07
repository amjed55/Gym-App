import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JFormattedTextField;
import java.io.*;
import java.util.*;

public class SessionFrame extends JFrame{
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 700;
	private static final int FEILD_SIZE = 10;
	
	private JButton		create = new JButton("Create");
	private JButton		back = new JButton("Back");
	private JTextField	coachTF = new JTextField(FEILD_SIZE);
	private JLabel		coach = new JLabel("Coach: ");
	private JTextField	dateTF = new JTextField(FEILD_SIZE);
	private JLabel		date = new JLabel("Date: ");
	private JTextField	timeTF = new JTextField(FEILD_SIZE);
	private JLabel		time = new JLabel("Time: ");
	private JTextField	costTF = new JTextField(FEILD_SIZE);
	private JLabel		cost = new JLabel("Cost: ");
	private JTextField	durationTF = new JTextField(FEILD_SIZE);
	private JLabel		duration = new JLabel("Duration: ");
	private JTextArea	descriptionTA = new JTextArea();
	private JLabel		description = new JLabel("Description:");
	
	SessionFrame(){
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setTitle("Create a Session");
		setVisible(true);
		JPanel wholePnl = new JPanel(new FlowLayout());//Whole panel
		JPanel couchpnl = new JPanel(new FlowLayout());//couch panel
		JPanel datepnl = new JPanel(new FlowLayout());//date panel
		JPanel timepnl = new JPanel(new FlowLayout());//time panel
		JPanel costpnl = new JPanel(new FlowLayout());//cost panel
		JPanel durationpnl = new JPanel(new FlowLayout());//duration panel
		JPanel buttons = new JPanel(new FlowLayout());//Buttons panel
		buttons.setLayout(new GridLayout(1, 2));
		buttons.add(create);
		buttons.add(back);
		JPanel des = new JPanel();
		des.setLayout(new GridLayout(3, 1));
		des.add(description);
		des.add(descriptionTA);
		des.add(buttons);
		des.add(create);
		wholePnl.setLayout(new GridLayout(6, 1));
		couchpnl.add(coach);
		couchpnl.add(coachTF);
		datepnl.add(date);
		datepnl.add(dateTF);
		timepnl.add(time);
		timepnl.add(timeTF);
		costpnl.add(cost);
		costpnl.add(costTF);
		durationpnl.add(duration);
		durationpnl.add(durationTF);
		wholePnl.add(couchpnl);
		wholePnl.add(datepnl);
		wholePnl.add(timepnl);
		wholePnl.add(costpnl);
		wholePnl.add(durationpnl);
		wholePnl.add(des);
		add(wholePnl, BorderLayout.CENTER);
		ActionListener listener = new createButtonListener();
                create.addActionListener(listener);
                listener = new backButtonListener();
		back.addActionListener(listener);
	}
	
	 class createButtonListener implements ActionListener {  
          public void actionPerformed(ActionEvent event) {
             Scanner sc = new Scanner(System.in);
             String coach = coachTF.getText() ;
             String date = dateTF.getText();
             String time = timeTF.getText();
             DecimalFormat df = new DecimalFormat("#.##");
             Double cost = Double.valueOf(costTF.getText());
             String dur = durationTF.getText();
             String desc = descriptionTA.getText();
	     Session session = new Session(date, time, dur, desc, cost, coach);
	     Main.allSess.add(session);
	     
	      }
	   }
	   
	   class backButtonListener implements ActionListener {  
        public void actionPerformed(ActionEvent event) {
        	MenuFrame mf = new MenuFrame();
        	mf.setVisible(true);
            SessionFrame.super.dispose();
        }
    }
}

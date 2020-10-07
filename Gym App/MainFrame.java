import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 500;
	private static final int BORDER_WIDTH = 5;
	private static final int BORDER_HEIGHT = 5;
	
	private JButton	member = new JButton("Member");
	private JButton	coach = new JButton("Coach");
	private JButton	treasurer = new JButton("Treasurer");
	private JLabel who = new JLabel("Select user type.");
	private JPanel main = new JPanel();
	
	public MainFrame(){
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setTitle("Select User Type");
		setVisible(true);
		main.setLayout(new GridLayout(4, 1));
		who.setFont(new java.awt.Font("Consolas", 1, 17));
		main.add(who);
		main.add(treasurer);
		main.add(coach);
		main.add(member);
		main.setVisible(true);
		
		ActionListener listener = new treasurerButtonListener();
		treasurer.addActionListener(listener);
		listener = new coachButtonListener();
		coach.addActionListener(listener);
		coach.setEnabled(false);
		listener = new memberButtonListener();
		member.addActionListener(listener);
		member.setEnabled(false);
		
		add(main, BorderLayout.CENTER);
		getRootPane().setBorder(BorderFactory.createMatteBorder(BORDER_HEIGHT, BORDER_WIDTH, BORDER_HEIGHT, BORDER_WIDTH, Color.GRAY));
	}
	
	class treasurerButtonListener implements ActionListener {  
	      public void actionPerformed(ActionEvent event) {
	    	  MenuFrame t = new MenuFrame();
	    	  t.setVisible(true);
	    	  MainFrame.super.dispose();
	      }
	   }

	class coachButtonListener implements ActionListener {  
	      public void actionPerformed(ActionEvent event) {
	          //not implemented
	      }
	   }
	
	class memberButtonListener implements ActionListener {  
	      public void actionPerformed(ActionEvent event) {
	          //not implemented
	      }
	   }

	
	
}
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GeneralSessionFrame extends JFrame{
	private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 200;
    private JButton     createSes = new JButton("Create Session");
    private JButton     addSes = new JButton("Add Session");
    
    GeneralSessionFrame(){
    	setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setTitle("Session");
        setVisible(true);
        JPanel p = new JPanel();
        p.add(createSes);
        p.add(addSes);
        add(p);
        ActionListener listener = new createButtonListener();
        createSes.addActionListener(listener);
        listener = new addButtonListener();
        addSes.addActionListener(listener);
    }
    
    class createButtonListener implements ActionListener {  
        public void actionPerformed(ActionEvent event) {
      	  SessionFrame s = new SessionFrame();
          s.setVisible(true);
          GeneralSessionFrame.super.dispose();
        }
     }
    class addButtonListener implements ActionListener {  
        public void actionPerformed(ActionEvent event) {
        	SessionViewerFrame s = new SessionViewerFrame();
        	s.setVisible(true);
        	GeneralSessionFrame.super.dispose();
        }
     }
    
}

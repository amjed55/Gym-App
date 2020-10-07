import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuFrame extends JFrame{
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 200;
    
    private JButton     session = new JButton("Manage Sessions");
    private JButton     manMemb = new JButton("Manage Members");
    private JButton     back = new JButton("Back");
    private JLabel      choices = new JLabel("Choose");
    
    MenuFrame(){
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setTitle("Main Menu");
        setVisible(true);
        JPanel pnl = new JPanel(new FlowLayout());//panel
        JPanel btmpnl = new JPanel(new FlowLayout());//bottom panel
        JPanel toppnl = new JPanel(new FlowLayout());//top panel
        pnl.setLayout(new GridLayout(2, 1));
        toppnl.add(choices);
        btmpnl.add(Box.createHorizontalStrut(10));
        btmpnl.add(session);
        btmpnl.add(Box.createHorizontalStrut(10));
        btmpnl.add(manMemb);
        btmpnl.add(Box.createHorizontalStrut(10));
        btmpnl.add(back);
        btmpnl.add(Box.createHorizontalStrut(10));
        pnl.add(toppnl);
        pnl.add(btmpnl);
        add(pnl, BorderLayout.CENTER);
        
        ActionListener listener = new sessionButtonListener();
        session.addActionListener(listener);
        listener = new manMembButtonListener();
        manMemb.addActionListener(listener);
        listener = new backButtonListener();
        back.addActionListener(listener);
    }
    
    class sessionButtonListener implements ActionListener {  
          public void actionPerformed(ActionEvent event) {
              GeneralSessionFrame s = new GeneralSessionFrame();
              s.setVisible(true);
              MenuFrame.super.dispose();
          }
       }
    
    class manMembButtonListener implements ActionListener {  
          public void actionPerformed(ActionEvent event) {
              MemberMangagmentFrame m = new MemberMangagmentFrame();
              m.setVisible(true);
              MenuFrame.super.dispose();
          }
       }
       
    class backButtonListener implements ActionListener {  
          public void actionPerformed(ActionEvent event) {
              MainFrame main = new MainFrame();
              main.setVisible(true);
              MenuFrame.super.dispose();
          }
       }
       
}

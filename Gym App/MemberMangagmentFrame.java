import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MemberMangagmentFrame extends JFrame{
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 200;
    private static final int SEPERATION_HEIGHT = 20;
    
    private JButton     createMem = new JButton("Create Members");
    private JButton     sortMem = new JButton("Members List");
    private JButton     back = new JButton("Back");
    
    MemberMangagmentFrame(){
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setTitle("Members");
        setVisible(true);
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.X_AXIS));
        myPanel.add(Box.createVerticalStrut(SEPERATION_HEIGHT));
        myPanel.add(createMem);
        myPanel.add(Box.createVerticalStrut(SEPERATION_HEIGHT));
        myPanel.add(sortMem);
        myPanel.add(back);
        myPanel.add(Box.createVerticalStrut(SEPERATION_HEIGHT));
        add(myPanel, BorderLayout.CENTER);
        
        ActionListener listener = new backButtonListener();
        back.addActionListener(listener);
        listener = new createMemButtonListener();
        createMem.addActionListener(listener);
        listener = new sortMemButtonListener();
        sortMem.addActionListener(listener);
    }
    
    class createMemButtonListener implements ActionListener {  
          public void actionPerformed(ActionEvent event) {
              CreateMembersFrame membersFrame = new CreateMembersFrame();
              membersFrame.setVisible(true);
              MemberMangagmentFrame.super.dispose();
          }
       }
    
    class sortMemButtonListener implements ActionListener 
    {  
          public void actionPerformed(ActionEvent event) {
              SortMembersFrame sort = new SortMembersFrame();
              sort.setVisible(true);
              MemberMangagmentFrame.super.dispose();
          }
       }
       
       class backButtonListener implements ActionListener {  
          public void actionPerformed(ActionEvent event) {
              MenuFrame menu = new MenuFrame();
              menu.setVisible(true);
              MemberMangagmentFrame.super.dispose();
          }
       }
}
 
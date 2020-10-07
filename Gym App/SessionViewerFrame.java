import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class SessionViewerFrame extends JFrame{
    private static final int FRAME_WIDTH = 1000;
    private static final int FRAME_HEIGHT = 500;
    private String[] columns = {"Coach","Date", "Time", "Description","Cost"};
    public Object [][] data = new Object [100][6];
    JTable table = new JTable(data, columns);
    JPanel top = new JPanel();
    JPanel btm = new JPanel();
    JButton add = new JButton("Add");
    JButton rmv = new JButton("Remove");
    JButton back = new JButton("Back");
        private int sessSize = Main.allSess.size();
    
    SessionViewerFrame(){
        setTitle("Sessions List");
        setLayout(new GridLayout(2, 1));
        table.setRowSelectionInterval(0,0);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        top.add(table, BorderLayout.NORTH);
        table.setPreferredScrollableViewportSize(new Dimension(FRAME_WIDTH*9/10,FRAME_HEIGHT*9/10));
        table.setFillsViewportHeight(true);
        JScrollPane sp = new JScrollPane(table);
        top.add(sp);
        btm.add(add);
        btm.add(rmv);
        btm.add(back);
        add(top);
        add(btm, BorderLayout.CENTER);
        ActionListener listener = new addButtonListener();
        add.addActionListener(listener);
        listener = new rmvButtonListener();
        rmv.addActionListener(listener);
        listener = new backButtonListener();
        back.addActionListener(listener);
        
        for (int i=0; i< sessSize;i++)
        {
            data[i][0] = Main.allSess.get(i).getDate();
            data[i][1] = Main.allSess.get(i).getTime();
            data[i][2] = Main.allSess.get(i).getDuration();
            data[i][3] = Main.allSess.get(i).getDescription();
            data[i][4] = Main.allSess.get(i).getCost();
            data[i][5] = Main.allSess.get(i).getCoach();
        }               
    }
    class addButtonListener implements ActionListener {  
        public void actionPerformed(ActionEvent event) {
            System.out.println("Add Session");
        }
     }
    class rmvButtonListener implements ActionListener {  
        public void actionPerformed(ActionEvent event) {
            System.out.println("Remove Session");
          }
    }
    class backButtonListener implements ActionListener {  
        public void actionPerformed(ActionEvent event) {
            MenuFrame main = new MenuFrame();
            main.setVisible(true);
            SessionViewerFrame.super.dispose();
          }
    }
}
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;
import javax.swing.*;
import javax.swing.text.*;
import java.text.*;
import java.util.Locale;


public class SortMembersFrame extends JFrame{
    JButton add = new JButton("Pay");
    JButton sub = new JButton("Add debt");
    JButton back = new JButton("Back");
    private static final int FRAME_WIDTH = 1000;
    private static final int FRAME_HEIGHT = 500;
    private String[] columns = {"Name","Email","Number","Address","ECN","ECP","Amount Paid"};
    private JTextField txtFld = new JTextField(10);
    
    JPanel buttonPnl = new JPanel();
    public Object [][] data = new Object [200][7];
    private int memSize = Main.allMems.size();
        
    JTable table = new JTable(data, columns);
    SortMembersFrame(){
        setTitle("Members List");
        table.setRowSelectionInterval(0,0);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        for (int i=0; i< memSize;i++)
        {
            data[i][0] = Main.allMems.get(i).getName();
            data[i][1] = Main.allMems.get(i).getEmail();
            data[i][2] = Main.allMems.get(i).getNumber();
            data[i][3] = Main.allMems.get(i).getAddress();
            data[i][4] = Main.allMems.get(i).getECN();
            data[i][5] = Main.allMems.get(i).getECPN();
            data[i][6] = Main.allMems.get(i).getDebt();
        }
        buttonPnl.add(txtFld);
        
        buttonPnl.add(add);
        buttonPnl.add(sub);
        buttonPnl.add(back);
        setLayout(new FlowLayout());
        table.setPreferredScrollableViewportSize(new Dimension(FRAME_WIDTH*9/10,FRAME_HEIGHT*9/10));
        table.setFillsViewportHeight(true);
        JScrollPane sp = new JScrollPane(table);
        setLayout(new GridLayout(2, 1));
        add(sp);
        add(buttonPnl, BorderLayout.SOUTH);
        ActionListener listener = new addButtonListener();
        add.addActionListener(listener);
        listener = new backButtonListener();
        back.addActionListener(listener);
        listener = new subButtonListener();
        sub.addActionListener(listener);
       
    }
    
    class addButtonListener implements ActionListener 
   {  
          public void actionPerformed(ActionEvent event) {
              int row = table.getSelectedRow();
              double payAmt =  Double.parseDouble(txtFld.getText());
              DecimalFormat df = new DecimalFormat("#.##");
              Main.allMems.get(row).addDebt(Double.valueOf(df.format(payAmt)));
              table.getModel().setValueAt(Main.allMems.get(row).getDebt(), row, 6);

          }
       }
       class subButtonListener implements ActionListener {  
          public void actionPerformed(ActionEvent event) {
              int row = table.getSelectedRow();
              double payAmt =  Double.parseDouble(txtFld.getText());
              DecimalFormat df = new DecimalFormat("#.##");
              Main.allMems.get(row).addPayment(Double.valueOf(df.format(payAmt)));
              table.getModel().setValueAt(Main.allMems.get(row).getDebt(), row, 6);

          }
       }
    class backButtonListener implements ActionListener {  
        public void actionPerformed(ActionEvent event) {
        	MemberMangagmentFrame manMemb = new MemberMangagmentFrame();
        	manMemb.setVisible(true);
            SortMembersFrame.super.dispose();
            }
  }
}
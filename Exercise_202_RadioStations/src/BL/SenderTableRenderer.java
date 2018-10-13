package BL;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

public class SenderTableRenderer implements TableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Sender s = (Sender) value;
        JLabel label = new JLabel("", SwingConstants.CENTER);
        label.setOpaque(true);
        
        label.setFont(new Font("Arial", Font.ITALIC, 14));
        
        if(isSelected){
            label.setBackground(Color.black);
            label.setForeground(Color.WHITE);
        }
        else{
            label.setForeground(Color.LIGHT_GRAY);
            if(s.getBand().equals("AM")){
                label.setBackground(Color.BLUE);
            }
            else{
                label.setBackground(Color.RED);
            }
        }
        
        switch(column){
            case 0: label.setText(s.getName()); break;
            case 1: label.setText(s.getFrequenz()+ ""); break;
            case 2: label.setText(s.getBand()); break;
        }
        return label;
    }
}

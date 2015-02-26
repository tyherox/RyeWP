import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by 의현 on 2015-02-17.
 */

public class SubMenu extends JPanel {

    private JPanel bPLace1;
    private JPanel bPLace2;
    private JButton button_1;
    private JButton button_2;
    Dimension parent;

    public SubMenu(Dimension d,Dimension p){
        System.out.println(p.width);
        parent = p;
        setBackground(Color.DARK_GRAY);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setFocusable(false);

        bPLace1 = new JPanel();
        bPLace1.setBackground(Color.LIGHT_GRAY);
        add(bPLace1);
        bPLace1.setLayout(new BorderLayout(0, 0));

        button_1 = new JButton("New button");
        button_1.setContentAreaFilled(false);
        bPLace1.add(button_1, BorderLayout.CENTER);
        //button_1.setBorder(BorderFactory.createEmptyBorder());
        button_1.setContentAreaFilled(false);

        bPLace2 = new JPanel();
        bPLace2.setBackground(Color.LIGHT_GRAY);
        add(bPLace2);
        bPLace2.setLayout(new BorderLayout(0, 0));

        button_2 = new JButton("New button");
        button_2.setContentAreaFilled(false);
        bPLace2.add(button_2, BorderLayout.CENTER);
        //button_2.setBorder(BorderFactory.createEmptyBorder());
        button_2.setContentAreaFilled(false);

        button_1.setFocusable(false);
        button_2.setFocusable(false);
        setBounds(0, 0, d.width, d.height);
        setVisible(false);
    }

    public void callMenu(int x, int y, String text)
    {
        JLabel one = new JLabel("Add " + text + " to dictionary");
        int oneWidth = one.getFontMetrics(one.getFont()).stringWidth(one.getText());
        JLabel two = new JLabel("Remove " + text + " from dictionary");
        button_1.setText(one.getText());
        button_2.setText(two.getText());

        setBounds(x, y, oneWidth * 2, getHeight());
    }
}

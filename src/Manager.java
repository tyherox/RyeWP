import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by 의현 on 2015-02-24.
 */
public class Manager extends JPanel {

    int width,xP;
    static Manager holder;
    boolean extended = false;
    static JPanel menu;
    BPanel start;
    JPanel project;
    JPanel revisons;
    Color test = new Color(78, 81, 106);

    public Manager() {
        holder = this;
        setLayout(null);
        setBackground(Color.DARK_GRAY);

        menu  = new JPanel();
        menu.setLayout(null);
        menu.setBackground(Color.DARK_GRAY);
        menu.setBackground(test);
        menu.setFocusable(false);
        add(menu);

        start = new BPanel("/Images/dragger.png");
        start.setFocusable(false);
        start.setBackground(test);
        add(start);

    }

    public void setMenu(int x, int width){
        menu.setBounds(x,0,width,1200);
        menu.setBackground(Color.DARK_GRAY);
    }

    public static void clearMenu(){
        Manager killer = holder;
        killer.killMenu();
    }

    public void killMenu(){
        setBounds(xP, 0, width, getHeight());
        menu.setBounds(0,0,0,0);
        menu.setBackground(Color.DARK_GRAY);
        extended = false;
    }

    public void initializeMenu(){

        width = getWidth();
        xP = getX();
        final int w = getWidth();
        final int h = getHeight();
        final int X = getX();
        final int Y = getY();

        final int area = (int)(w*11);

        start.setBounds(0, 0, w, h);
        start.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (extended == false) {
                    setBounds(X - area, getY(), w + area, getHeight());
                    setMenu(w, area);
                    JToolBox.killAnimation();
                    extended = true;
                } else if (extended == true) {
                    clearMenu();
                }
            }

            public void filler() {

            }
        });

        project = new JPanel();
        project.setBackground(test);
        project.setBounds(0, 0, (int) (w * 11.5), h / 2);
        project.setOpaque(false);
        project.setLayout(null);
        menu.add(project);
        Project();
    }

    public void Project() {

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, getHeight()/10, project.getWidth(), project.getHeight()/10*9);
        scrollPane.setBorder(null);
        scrollPane.setOpaque(false);
        project.add(scrollPane);

        JLabel titleProject = new JLabel("Project Name");
        titleProject.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        titleProject.setBounds((int) (project.getWidth()/2.5),getHeight()/20,project.getWidth(),project.getHeight()/10);
        project.add(titleProject);

        JList list = new JList();
        list.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        DefaultListModel listModel = new DefaultListModel();
        list.setBorder(null);
        list.setFocusable(false);
        scrollPane.setViewportView(list);
        list.setModel(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        listModel.addElement("  This is a test file");
        listModel.addElement("  Is this what it would look like?");
        listModel.addElement("  Science fair test");
        listModel.addElement("  History test guide");
        listModel.addElement("  This is great stuff");
        listModel.addElement("  I find this appalling");

    }
}

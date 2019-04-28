import twooter.*;
import javax.swing.*;
import java.awt.Color;


public class Messages_Panel extends App{

    //Components of Message Panel
    private static JPanel MESSAGES_PANEL = new JPanel();
    private static JLabel MESSAGES_LABEL_AREA = new JLabel("Label");
    
    //Bools
    
    //Message Panel Dimensions
    private static int MESSAGES_PANEL_WIDTH, MESSAGES_PANEL_HEIGHT, MESSAGES_PANEL_X_POSITION, MESSAGES_PANEL_Y_POSITION;
    public void addMessagesPanel(){
        MESSAGES_PANEL_WIDTH = (frameWidth / 2);
        MESSAGES_PANEL_HEIGHT = ((frameHeight / 4) * 3);
        MESSAGES_PANEL_X_POSITION = 10;
        MESSAGES_PANEL_Y_POSITION = 10;

        mainFrame.add(MESSAGES_PANEL);
        MESSAGES_PANEL.setBounds(MESSAGES_PANEL_X_POSITION, MESSAGES_PANEL_Y_POSITION, MESSAGES_PANEL_WIDTH, MESSAGES_PANEL_HEIGHT);
        MESSAGES_PANEL.setLayout(null);

        MESSAGES_PANEL.add(MESSAGES_LABEL_AREA);

        MESSAGES_LABEL_AREA.setBounds(0, 0, MESSAGES_PANEL_WIDTH, MESSAGES_PANEL_HEIGHT);
        MESSAGES_LABEL_AREA.setBackground(Color.gray);
        MESSAGES_LABEL_AREA.setOpaque(true);

        //Debug
        System.out.println("addMessagesPanel()");
    }

    public void removeMessagesPanel(){
        mainFrame.remove(MESSAGES_PANEL);

        //Debug
        System.out.println("removeMessagesPanel()");
    }
}
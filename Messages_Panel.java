import twooter.*;
import javax.swing.*;
import java.awt.Color;


public class Messages_Panel extends App{

    //Components of Message Panel
    private static JPanel MESSAGES_PANEL = new JPanel();
    private static JLabel WRITE_MESSAGE_LABEL = new JLabel();
    private static JTextArea WRITE_MESSAGE_AREA = new JTextArea();
    private static JScrollPane WRITE_MESSAGE_AREA_SCROLLPANE = new JScrollPane(WRITE_MESSAGE_AREA, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
    //Bools
    
    //Message Panel Dimensions
    private static int MESSAGES_PANEL_WIDTH, MESSAGES_PANEL_HEIGHT, MESSAGES_PANEL_X_POSITION, MESSAGES_PANEL_Y_POSITION;
    private static int WRITE_MESSAGE_AREA_WIDTH, WRITE_MESSAGE_AREA_HEIGHT, WRITE_MESSAGE_AREA_X_POSITION, WRITE_MESSAGE_AREA_Y_POSITION;
    public void addMessagesPanel(){
        //MESSAGES_PANEL Dimensions
        MESSAGES_PANEL_WIDTH = ((frameWidth / 5) * 4);
        MESSAGES_PANEL_HEIGHT = (frameHeight - 100);
        MESSAGES_PANEL_X_POSITION = 10;
        MESSAGES_PANEL_Y_POSITION = 10;

        //WRITE_MESSAGE_AREA Dimensions
        WRITE_MESSAGE_AREA_WIDTH = 420;
        WRITE_MESSAGE_AREA_HEIGHT = 100;
        WRITE_MESSAGE_AREA_X_POSITION = (MESSAGES_PANEL_WIDTH / 2) + 100;
        WRITE_MESSAGE_AREA_Y_POSITION = MESSAGES_PANEL_Y_POSITION + 300;

        mainFrame.add(MESSAGES_PANEL);
        MESSAGES_PANEL.setBounds(MESSAGES_PANEL_X_POSITION, MESSAGES_PANEL_Y_POSITION, MESSAGES_PANEL_WIDTH, MESSAGES_PANEL_HEIGHT);
        MESSAGES_PANEL.setLayout(null);

        //WRITE_MESSAGE_LABEL
        MESSAGES_PANEL.add(WRITE_MESSAGE_LABEL);
        WRITE_MESSAGE_LABEL.setBounds(WRITE_MESSAGE_AREA_X_POSITION - 8, WRITE_MESSAGE_AREA_Y_POSITION - 30, 200, 15);
        WRITE_MESSAGE_LABEL.setText("Your twoot...");
        WRITE_MESSAGE_LABEL.setFont(WRITE_MESSAGE_LABEL.getFont().deriveFont(14.0f)); //Set font size float 14

        //WRITE_MESSAGE_AREA
        mainFrame.add(WRITE_MESSAGE_AREA_SCROLLPANE);
        WRITE_MESSAGE_AREA_SCROLLPANE.setBounds(WRITE_MESSAGE_AREA_X_POSITION, WRITE_MESSAGE_AREA_Y_POSITION, WRITE_MESSAGE_AREA_WIDTH, WRITE_MESSAGE_AREA_HEIGHT);
        WRITE_MESSAGE_AREA.setWrapStyleWord(true);
        WRITE_MESSAGE_AREA.setLineWrap(true);
    }

    public void removeMessagesPanel(){
        mainFrame.remove(MESSAGES_PANEL);
        mainFrame.revalidate();
    }
}
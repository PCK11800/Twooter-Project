import twooter.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.Color;


public class Messages_Panel extends App{

    //Components of Message Panel
    private static JPanel MESSAGES_PANEL = new JPanel();
    private static JLabel WRITE_MESSAGE_LABEL = new JLabel();
    private static JTextArea WRITE_MESSAGE_AREA = new JTextArea();
    private static JButton SEND_MESSAGE_BUTTON = new JButton("Twoot");
    private static JTextArea SHOW_MESSAGE_AREA = new JTextArea();
        //ScrollPanes
        private static JScrollPane WRITE_MESSAGE_AREA_SCROLLPANE = new JScrollPane(WRITE_MESSAGE_AREA, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        private static JScrollPane SHOW_MESSAGE_AREA_SCROLLPANE = new JScrollPane(SHOW_MESSAGE_AREA, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
    //Bools
    
    //Message Panel Dimensions
    private static int MESSAGES_PANEL_WIDTH, MESSAGES_PANEL_HEIGHT, MESSAGES_PANEL_X_POSITION, MESSAGES_PANEL_Y_POSITION;
    private static int WRITE_MESSAGE_AREA_WIDTH, WRITE_MESSAGE_AREA_HEIGHT, WRITE_MESSAGE_AREA_X_POSITION, WRITE_MESSAGE_AREA_Y_POSITION;
    private static int SHOW_MESSAGE_AREA_WIDTH, SHOW_MESSAGE_AREA_HEIGHT, SHOW_MESSAGE_AREA_X_POSITION, SHOW_MESSAGE_AREA_Y_POSITION;
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

        //SHOW_MESSAGE_AREA Dimensions
        SHOW_MESSAGE_AREA_WIDTH = 420;
        SHOW_MESSAGE_AREA_HEIGHT = 700;
        SHOW_MESSAGE_AREA_X_POSITION = 10;
        SHOW_MESSAGE_AREA_Y_POSITION = 10;

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
        WRITE_MESSAGE_AREA.setText("FIX THIS DAMN BUG");
        WRITE_MESSAGE_AREA.setText("");
        WRITE_MESSAGE_AREA.setWrapStyleWord(true);
        WRITE_MESSAGE_AREA.setLineWrap(true);

        //SHOW_MESSAGE_AREA
        mainFrame.add(SHOW_MESSAGE_AREA_SCROLLPANE);
        SHOW_MESSAGE_AREA_SCROLLPANE.setBounds(SHOW_MESSAGE_AREA_X_POSITION, SHOW_MESSAGE_AREA_Y_POSITION, SHOW_MESSAGE_AREA_WIDTH, SHOW_MESSAGE_AREA_HEIGHT);
        //WRITE CODE TO GET MESSAGES AND SET THEM AS TEXT
        
        SHOW_MESSAGE_AREA.setWrapStyleWord(true);
        SHOW_MESSAGE_AREA.setLineWrap(true);
        SHOW_MESSAGE_AREA.setEditable(false);
        SHOW_MESSAGE_AREA.setOpaque(false);
        //Debug
        SHOW_MESSAGE_AREA.setText("DEBUG");

        //SEND_MESSAGE_BUTTON
        MESSAGES_PANEL.add(SEND_MESSAGE_BUTTON);
        SEND_MESSAGE_BUTTON.setBounds((WRITE_MESSAGE_AREA_X_POSITION - 8), (WRITE_MESSAGE_AREA_Y_POSITION + 100), 100, 20);
        SEND_MESSAGE_BUTTON.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                SEND_MESSAGE_BUTTON_ACTION_LISTENER();
            }
        });
        
        //Refresh Specific Components - to fix overlap and flickering - still doesnt work :(
        REFRESH_SPECIFIC_COMPONENTS();
    }

    public void removeMessagesPanel(){
        mainFrame.remove(MESSAGES_PANEL);
        mainFrame.remove(WRITE_MESSAGE_AREA_SCROLLPANE); //This is because MESSAGES_PANEL and SCROLLPANE are seperate entities
        mainFrame.remove(SHOW_MESSAGE_AREA_SCROLLPANE); 
        mainFrame.revalidate();
    }

    private void REFRESH_SPECIFIC_COMPONENTS(){
        WRITE_MESSAGE_AREA_SCROLLPANE.repaint();
        SHOW_MESSAGE_AREA_SCROLLPANE.repaint();
    }

    //SEND_MESSAGE_BUTTON ACTIONLISTENER FUNCTION
    private void SEND_MESSAGE_BUTTON_ACTION_LISTENER(){
        System.out.println("SEND_MESSAGE_BUTTON_ACTION_LISTENER");

        //DO THINGS
    }
}
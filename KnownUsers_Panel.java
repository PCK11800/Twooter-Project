import twooter.*;
import java.io.*;
import javax.swing.*;
import java.awt.Color;

public class KnownUsers_Panel extends App{

    //Components of KnownUsers
    private static JPanel KNOWNUSERS_PANEL = new JPanel();
    private static JTextArea KNOWNUSERS_TEXTAREA = new JTextArea();
    private static JLabel KNOWNUSERS_LABEL = new JLabel("Known Users");
    private static JScrollPane KNOWNUSERS_TEXTAREA_SCROLLPANE = new JScrollPane(KNOWNUSERS_TEXTAREA);
    private static int KNOWNUSERS_TEXTAREA_HEIGHT = 0;
    private static int PER_USERNAME_HEIGHT = 17;

    //Bools

    //KnownUsers Panel Dimensions
    private static int KNOWNUSERS_PANEL_WIDTH, KNOWNUSERS_PANEL_HEIGHT, KNOWNUSERS_PANEL_X_POSITION, KNOWNUSERS_PANEL_Y_POSITION;
    public void addKnownUsers_Panel(){
        KNOWNUSERS_PANEL_WIDTH = ((frameWidth / 4));
        KNOWNUSERS_PANEL_HEIGHT = ((frameHeight - 100));
        KNOWNUSERS_PANEL_X_POSITION = (frameWidth - 150);
        KNOWNUSERS_PANEL_Y_POSITION = 50;

        mainFrame.add(KNOWNUSERS_PANEL);
        mainFrame.add(KNOWNUSERS_TEXTAREA_SCROLLPANE);
        KNOWNUSERS_PANEL.setBounds(KNOWNUSERS_PANEL_X_POSITION, KNOWNUSERS_PANEL_Y_POSITION, KNOWNUSERS_PANEL_WIDTH, KNOWNUSERS_PANEL_HEIGHT);
        KNOWNUSERS_PANEL.setLayout(null);

        KNOWNUSERS_PANEL.add(KNOWNUSERS_LABEL);
        KNOWNUSERS_PANEL.add(KNOWNUSERS_TEXTAREA_SCROLLPANE);

        KNOWNUSERS_LABEL.setBounds(20, 0, 140, 50);
        KNOWNUSERS_LABEL.setFont(KNOWNUSERS_LABEL.getFont().deriveFont(14.0f)); //Set font size float 14

        DETERMINE_TEXTAREA_HEIGHT_FUNCTION();
        KNOWNUSERS_TEXTAREA_SCROLLPANE.setBounds(0, 50, 140, KNOWNUSERS_TEXTAREA_HEIGHT);
        ADD_USERNAMES_TO_KNOWNUSERS_TEXTAREA();
        KNOWNUSERS_TEXTAREA.setEditable(false);
    }

    private void DETERMINE_TEXTAREA_HEIGHT_FUNCTION(){
        int USERNAME_AMOUNT = 0;
        try{
            BufferedReader USERNAME_READER = new BufferedReader(new FileReader("usernames.txt"));
            while (USERNAME_READER.readLine() != null){
                USERNAME_AMOUNT++;
            }
            KNOWNUSERS_TEXTAREA_HEIGHT = (USERNAME_AMOUNT * PER_USERNAME_HEIGHT);
            if (KNOWNUSERS_TEXTAREA_HEIGHT >= (frameHeight - 200)){
                KNOWNUSERS_TEXTAREA_HEIGHT = (frameHeight - 200);
            }
            else{
                KNOWNUSERS_TEXTAREA_HEIGHT = (USERNAME_AMOUNT * PER_USERNAME_HEIGHT);
            }
            USERNAME_READER.close();
        }catch(IOException ex){
            System.out.println("DETERMINE_TEXTAREA_HEIGHT_FUNCTION ERROR");
        }
    }

    public void removeKnownUsers_Panel(){
        mainFrame.remove(KNOWNUSERS_PANEL);
        mainFrame.revalidate();
    }

    private void ADD_USERNAMES_TO_KNOWNUSERS_TEXTAREA(){
        try{
            BufferedReader USERNAME_READER = new BufferedReader(new FileReader("usernames.txt"));
            KNOWNUSERS_TEXTAREA.read(USERNAME_READER, null);
            USERNAME_READER.close();
        }catch(IOException ex){
            System.out.println("ADD_USERNAMES_TO_KNOWNUSERS_TEXTAREA ERROR");
        }
    }
}
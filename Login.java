import twooter.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.Color.*;
import java.util.Scanner;

public class Login extends App{

    /* iniLoginPanel = Creates the Login Panel
       iniLogoutPanel = Creates the Logout Panel 
       RESET_TO_DEFAULT_STATE = Resets all buttons
    */

    //Components of Login Panel
    private static JPanel LOGIN_PANEL = new JPanel();
    private static JTextField USERNAME_TEXTFIELD = new JTextField();
    private static JTextField PASSWORD_TEXTFIELD = new JTextField();
    private static JButton LOGIN_BUTTON = new JButton("Login");
    private static JButton CREATE_ACCOUNT_BUTTON = new JButton("Create Account");
    private static JLabel TWOOTER_LABEL = new JLabel("Twooter");
    private static JLabel LOGIN_INCORRECT_LABEL = new JLabel("Login Credentials Incorrect");

    //Components of Logout Panel
    private static JPanel LOGOUT_PANEL = new JPanel();
    private static JLabel LOGGED_IN_AS_LABEL = new JLabel();
    private static JButton LOGOUT_BUTTON = new JButton("Logout");

    //Bools
    private boolean CORRECT_USERNAME = false;
    private boolean CORRECT_PASSWORD = false;

    //LOGIN_PANEL_MAIN_FUNCTION - REDUNDANT BUT FUCK IT
    public void LOGIN_PANEL_MAIN_FUNCTION(){
        LOGGED_ON_OR_OFF_FUNCTION();
    }
    
    //LoginPanel Dimensions
    private static int LOGIN_PANEL_WIDTH, LOGIN_PANEL_HEIGHT, LOGIN_PANEL_X_POSITION, LOGIN_PANEL_Y_POSITION;
    public void iniLoginPanel(){
        LOGIN_PANEL_WIDTH = (frameWidth / 3);
        LOGIN_PANEL_HEIGHT = (frameHeight / 3);
        LOGIN_PANEL_X_POSITION = LOGIN_PANEL_WIDTH;
        LOGIN_PANEL_Y_POSITION = LOGIN_PANEL_HEIGHT;

        mainFrame.add(LOGIN_PANEL);
        LOGIN_PANEL.setBounds(LOGIN_PANEL_X_POSITION, LOGIN_PANEL_Y_POSITION, LOGIN_PANEL_WIDTH, LOGIN_PANEL_HEIGHT);
        LOGIN_PANEL.setLayout(null);

        LOGIN_PANEL.add(USERNAME_TEXTFIELD);
        LOGIN_PANEL.add(PASSWORD_TEXTFIELD);
        LOGIN_PANEL.add(LOGIN_BUTTON);
        LOGIN_PANEL.add(CREATE_ACCOUNT_BUTTON);
        LOGIN_PANEL.add(TWOOTER_LABEL);

        TWOOTER_LABEL.setBounds(110, -10, 200, 75);
        TWOOTER_LABEL.setFont(TWOOTER_LABEL.getFont().deriveFont(32.0f)); //Set font size float 64
        USERNAME_TEXTFIELD.setBounds(75, 50, 200, 20);
        PASSWORD_TEXTFIELD.setBounds(75, 80, 200, 20);
        LOGIN_BUTTON.setBounds(100, 110, 150, 20);
        CREATE_ACCOUNT_BUTTON.setBounds(100, 140, 150, 20);
        LOGIN_INCORRECT_LABEL.setBounds(100, 170, 150, 20);

        //LOGIN_BUTTON
        LOGIN_BUTTON.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                LOGIN_BUTTON_ACTION_LISTENER();
            }
        });

        //CREATE_ACCOUNT_BUTTON
        CREATE_ACCOUNT_BUTTON.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CREATE_ACCOUNT_BUTTON_ACTION_LISTENER();
            }
        });
    }

    //LOGIN_BUTTON ACTIONLISTENER FUNCTION
    private void LOGIN_BUTTON_ACTION_LISTENER(){
        String INPUTTED_USERNAME = USERNAME_TEXTFIELD.getText();
        String INPUTTED_PASSWORD = PASSWORD_TEXTFIELD.getText();

        try{
            Scanner USERNAME_SCANNER = new Scanner(new File("usernames.txt"));
            Scanner PASSWORD_SCANNER = new Scanner(new File("passwords.txt"));

            while(USERNAME_SCANNER.hasNext()){
                String SCANNED_USERNAME = USERNAME_SCANNER.nextLine();
                if (SCANNED_USERNAME.equals(INPUTTED_USERNAME)){
                    CORRECT_USERNAME = true;
                    inUsername = INPUTTED_USERNAME;
                }
            }

            while(PASSWORD_SCANNER.hasNext()){
                String SCANNED_PASSWORD = PASSWORD_SCANNER.nextLine();
                if (SCANNED_PASSWORD.equals(INPUTTED_PASSWORD)){
                    CORRECT_PASSWORD = true;
                }
            }

            USERNAME_SCANNER.close();
            PASSWORD_SCANNER.close();

        }catch(FileNotFoundException ex){
            System.out.println("usernames.txt or passwords.txt not found");
        }

        //IF USERNAME AND PASSWORD IS CORRECT
        Boolean LOGIN_VALIDATION = LOGIN_VALIDATION_FUNCTION();
        if (LOGIN_VALIDATION == true){
            REMOVE_ALL_LOGIN_PANEL();
            iniLogoutPanel();
            isLoggedOn = true;
            
            //CALL CURRENTLY_LOGGED_ON_FUNCTION
            CURRENTLY_LOGGED_ON_FUNCTION();
        }
        else{
            //Show LOGIN_INCORRECT_LABEL
            LOGIN_PANEL.add(LOGIN_INCORRECT_LABEL);
        }
    }

    //CREATE_ACCOUNT_BUTTON ACTIONLISTENER FUNCTION
    private void CREATE_ACCOUNT_BUTTON_ACTION_LISTENER(){
        String INPUTTED_USERNAME = USERNAME_TEXTFIELD.getText();
        String INPUTTED_PASSWORD = PASSWORD_TEXTFIELD.getText();

        try{
            BufferedWriter OUTPUT_USERNAME = new BufferedWriter(new FileWriter("usernames.txt", true));
            BufferedWriter OUTPUT_PASSWORD = new BufferedWriter(new FileWriter("passwords.txt", true));

            OUTPUT_USERNAME.newLine();
            OUTPUT_PASSWORD.newLine();

            OUTPUT_USERNAME.append(INPUTTED_USERNAME);
            OUTPUT_PASSWORD.append(INPUTTED_PASSWORD);

            OUTPUT_USERNAME.close();
            OUTPUT_PASSWORD.close();

        }catch(IOException ex){
            System.out.println("CREATE_ACCOUNT_BUTTON_ACTION_LISTENER ERROR.");
        }
        CREATE_ACCOUNT_BUTTON.setEnabled(false);
        CREATE_ACCOUNT_BUTTON.setText("Account Created");
    }

    //DETERMINE IF USERNAME AND PASSWORD IS CORRECT
    private boolean LOGIN_VALIDATION_FUNCTION(){
        if (CORRECT_USERNAME == true && CORRECT_PASSWORD == true){
            return true;
        }
        else{
            return false;
        }
    }

    //TO BE CALLED WITH LOGOUT BUTTON
    private void RESET_TO_DEFAULT_STATE(){
        //REENABLE CREATE_ACCOUNT_BUTTON
        CREATE_ACCOUNT_BUTTON.setText("Create Account");
        CREATE_ACCOUNT_BUTTON.setEnabled(true);

        //DISAPPEAR LOGIN_INCORRECT_LABEL
        LOGIN_PANEL.remove(LOGIN_INCORRECT_LABEL);

        //RESET VARIABLES
        inUsername = null;
        CORRECT_USERNAME = false;
        CORRECT_PASSWORD = false;
        isLoggedOn = false;
    }

    //LogoutPanel Dimensions
    private static int LOGOUT_PANEL_WIDTH, LOGOUT_PANEL_HEIGHT, LOGOUT_PANEL_X_POSITION, LOGOUT_PANEL_Y_POSITION;
    public void iniLogoutPanel(){
        LOGOUT_PANEL_WIDTH = 100;
        LOGOUT_PANEL_HEIGHT = 50;
        LOGOUT_PANEL_X_POSITION = (frameWidth -  100);
        LOGOUT_PANEL_Y_POSITION = 0;

        mainFrame.add(LOGOUT_PANEL);
        LOGOUT_PANEL.setBounds(LOGOUT_PANEL_X_POSITION, LOGOUT_PANEL_Y_POSITION, LOGOUT_PANEL_WIDTH, LOGOUT_PANEL_HEIGHT);
        LOGOUT_PANEL.setLayout(null);

        LOGOUT_PANEL.add(LOGGED_IN_AS_LABEL);
        LOGOUT_PANEL.add(LOGOUT_BUTTON);

        LOGGED_IN_AS_LABEL.setBounds(5, 0, 100, 25);
        LOGGED_IN_AS_LABEL.setText(inUsername);
        LOGOUT_BUTTON.setBounds(0, 25, 75, 25);

        //LOGOUT_BUTTON
        LOGOUT_BUTTON.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                LOGOUT_BUTTON_ACTION_LISTENER();
            }
        });
    }

    //LOGOUT_BUTTON_ACTION_LISTENER
    private void LOGOUT_BUTTON_ACTION_LISTENER(){
        RESET_TO_DEFAULT_STATE();
        REMOVE_ALL_LOGOUT_PANEL();
        iniLoginPanel();

        //CALL CURRENTLY_LOGGED_OFF_FUNCTION
        CURRENTLY_LOGGED_OFF_FUNCTION();
    }

    //REMOVE ALL LOGIN PANEL
    private void REMOVE_ALL_LOGIN_PANEL(){
        mainFrame.remove(LOGIN_PANEL);
        mainFrame.repaint();
        LOGOUT_PANEL.repaint();
    }

    //REMOVE ALL LOGOUT PANEL
    private void REMOVE_ALL_LOGOUT_PANEL(){
        mainFrame.remove(LOGOUT_PANEL);
        mainFrame.repaint();
        LOGIN_PANEL.repaint();
    }

    //Function to modify info.txt to indicate user is logged on
    private void CURRENTLY_LOGGED_ON_FUNCTION(){
        try{
            BufferedWriter WRITE_IN_INFO = new BufferedWriter(new FileWriter("info.txt"));
            WRITE_IN_INFO.write("true");
            WRITE_IN_INFO.newLine();
            WRITE_IN_INFO.write(inUsername);
            WRITE_IN_INFO.close();
        }catch(IOException ex){
            System.out.println("CURRENTLY_LOGGED_ON_FUNCTION ERROR");
        }
    }

    //Function to modify info.txt to indicate user is logged off
    private void CURRENTLY_LOGGED_OFF_FUNCTION(){
        try{
            BufferedWriter WRITE_IN_INFO = new BufferedWriter(new FileWriter("info.txt"));
            WRITE_IN_INFO.write("false");
            WRITE_IN_INFO.close();
        }catch(IOException ex){
            System.out.println("CURRENTLY_LOGGED_OFF_FUNCTION ERROR");
        }
    }

    //Determine if currently logged on or logged off
    private void LOGGED_ON_OR_OFF_FUNCTION(){
        try{
            BufferedReader INFO_READER = new BufferedReader(new FileReader("info.txt"));
            String CURRENT_STATE = INFO_READER.readLine();
            String CURRENT_USER = INFO_READER.readLine();
            String TRUE_STRING = "true";

            if(CURRENT_STATE.equals(TRUE_STRING)){
                inUsername = CURRENT_USER;
                isLoggedOn = true;
                INFO_READER.close();
                iniLogoutPanel();
            }
            else{
                INFO_READER.close();
                iniLoginPanel();
            }
        }catch(IOException ex){
            System.out.println("LOGGED_ON_OR_OFF_FUNCTION ERROR");
        }
    }
}
    


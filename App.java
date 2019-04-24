import twooter.*;
import javax.swing.*;

public class App{
    
    static JFrame mainFrame = new JFrame("Twooter!");
    static App app = new App();

    //Check if currently logged on
    static boolean isLoggedOn = false;

    //Logged in Username
    static String inUsername;
    
    //Components
    static Login login = new Login();
    
    //Frame Width & Height
    static int frameWidth = 999;
    static int frameHeight = 801;

    //Create Frame and Panel
    //(Frame Width, Frame Height, Panel Width, Panel Height)
    private void iniApp(int x, int y){
        mainFrame.setSize(x, y);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(null);
        mainFrame.setResizable(false);
    }
    
    public static void main(String[] args){
        app.iniApp(frameWidth, frameHeight);
        login.LOGIN_PANEL_MAIN_FUNCTION();
    }

    
}
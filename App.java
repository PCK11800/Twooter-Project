import twooter.*;
import javax.swing.*;

public class App{
    
    static JFrame mainFrame = new JFrame("Twooter!");
    static App app = new App();
    static TwooterClient twooterClient = new TwooterClient();

    //Check if currently logged on
    static boolean isLoggedOn = false;

    //Logged in Username
    static String inUsername;
    
    //Components
    static Login login = new Login();
    static KnownUsers_Panel knownUsers_Panel = new KnownUsers_Panel();
    
    //Frame Width & Height
    static int frameWidth = 1200;
    static int frameHeight = 800;

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
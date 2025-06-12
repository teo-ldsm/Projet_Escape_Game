import javax.swing.JFrame;

/**
 * The main window (JFrame) for the escape room game.
 * It sets up the window properties and adds the main game panel.
 */
public class GameFrame extends JFrame {

    public GameFrame() {
        setTitle("The Cellar - Escape Room");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Add the main game panel
        add(new GamePanel());

        pack(); // Sizes the frame so that all its contents are at or above their preferred sizes.
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true);
    }
}
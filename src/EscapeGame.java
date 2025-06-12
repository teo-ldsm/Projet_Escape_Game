import javax.swing.SwingUtilities;

/**
 * Main class to launch the Escape Room game.
 * It ensures the GUI is created on the Event Dispatch Thread.
 */
public class EscapeGame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GameFrame();
        });
    }
}
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * The main panel where the game is displayed and interacted with.
 * It handles game state, rendering, and all user input.
 */
public class GamePanel extends JPanel {

    // Final correct code to win the game
    private static final String CORRECT_CODE = "020719999462";

    // Game state variables
    private boolean lightsOn = false;
    private boolean hasFoundNotebook = false;
    private boolean hasFoundUsb = false;

    // Image resources
    private Image currentBackground;
    private Image darkRoomImg, litRoomImg, notebookImg, phoneImg, photoBoxImg, briefcaseImg, medicalRecordImg, newspaperImg;

    // UI Components
    private final JLabel messageLabel;

    // Clickable areas (Hotspots)
    private final Map<String, Rectangle> hotspots = new HashMap<>();

    // Enum to manage which view is currently active
    private enum GameView {
        MAIN_ROOM, NOTEBOOK, PHONE, PHOTO_BOX, BRIEFCASE, LAPTOP, NEWSPAPER
    }
    private GameView currentView = GameView.MAIN_ROOM;

    public GamePanel() {
        // Load all game resources
        loadResources();

        // Set initial background to the dark room
        currentBackground = darkRoomImg;
        setPreferredSize(new Dimension(currentBackground.getWidth(this), currentBackground.getHeight(this)));

        // Define clickable areas for the lit room
        defineHotspots();

        // Setup the text banner at the bottom
        setLayout(new BorderLayout());
        messageLabel = new JLabel("It's pitch black. I need to find a way to turn on the lights.", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Serif", Font.BOLD, 18));
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setOpaque(true);
        messageLabel.setBackground(Color.BLACK);
        add(messageLabel, BorderLayout.SOUTH);

        // Add mouse listener for user interaction
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleMouseClick(e.getPoint());
            }
        });
    }

    /**
     * Loads all images and text files from the resources folder.
     */
    private void loadResources() {
    try {
        // On tente de charger l'image depuis le même dossier que les fichiers .java
        darkRoomImg = ImageIO.read(getClass().getResource("Salle sombre.jpg"));

        if (darkRoomImg == null) {
            // Si ça échoue encore, on affiche un message très clair
            JOptionPane.showMessageDialog(this, "ÉCHEC DU TEST.\nImpossible de trouver 'Salle sombre.jpg' même à côté des fichiers .java.", "Erreur Critique", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        // On charge une image "placeholder" pour les autres pour éviter les erreurs
        litRoomImg = notebookImg = phoneImg = photoBoxImg = briefcaseImg = medicalRecordImg = newspaperImg = new java.awt.image.BufferedImage(10, 10, java.awt.image.BufferedImage.TYPE_INT_RGB);

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Une exception s'est produite lors du chargement de 'Salle sombre.jpg'.\n" + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
    }
    }

    /**
     * Defines the clickable areas on the main lit room image.
     */
    private void defineHotspots() {
        hotspots.put("electrical_box", new Rectangle(40, 160, 130, 240));
        hotspots.put("drawer", new Rectangle(300, 500, 240, 70));
        hotspots.put("sports_bag", new Rectangle(10, 480, 250, 250)); // A conceptual area for the bag if it was visible
        hotspots.put("photo_box", new Rectangle(500, 200, 150, 100));
        hotspots.put("briefcase_location", new Rectangle(500, 350, 150, 100)); // An area on the shelves for the briefcase
        hotspots.put("laptop", new Rectangle(320, 400, 150, 100));
        hotspots.put("newspaper_location", new Rectangle(180, 250, 70, 90)); // The paper on the wall
        hotspots.put("door_keypad", new Rectangle(760, 400, 50, 80));
    }

    /**
     * Main logic handler for mouse clicks.
     * @param point The coordinate of the mouse click.
     */
    private void handleMouseClick(Point point) {
        if (!lightsOn) {
            // Logic for when lights are off
            if (hotspots.get("electrical_box").contains(point)) {
                lightsOn = true;
                currentBackground = litRoomImg;
                messageLabel.setText("You found the switch and turned on the lights. The room is... unsettling.");
                repaint();
            } else {
                messageLabel.setText("It's too dark. That green light on the wall looks promising.");
            }
            return;
        }

        // If we are in a special view (like looking at the phone), any click returns to the main room.
        if (currentView != GameView.MAIN_ROOM) {
            currentView = GameView.MAIN_ROOM;
            currentBackground = litRoomImg;
            messageLabel.setText("You step back and look around the room again.");
            repaint();
            return;
        }

        // Logic for when lights are on and we are in the main room view
        for (Map.Entry<String, Rectangle> entry : hotspots.entrySet()) {
            if (entry.getValue().contains(point)) {
                handleHotspotInteraction(entry.getKey());
                return; // Stop after handling the first clicked hotspot
            }
        }
        // If no hotspot was clicked, give a default message.
        messageLabel.setText("There's nothing of interest there.");
    }

    /**
     * Handles the interaction for a specific hotspot.
     * @param hotspotName The name of the clicked hotspot.
     */
    private void handleHotspotInteraction(String hotspotName) {
        switch (hotspotName) {
            case "drawer":
                hasFoundNotebook = true;
                currentView = GameView.NOTEBOOK;
                currentBackground = notebookImg;
                messageLabel.setText("You found a notebook in the drawer. It seems to be a diary...");
                showNotebookContent();
                break;
            case "sports_bag": // This is a conceptual click since the bag is not visible in the main scene
                currentView = GameView.PHONE;
                currentBackground = phoneImg;
                messageLabel.setText("You found a phone in a sports bag. '9 appels manqués'... Clue 2 is 9.");
                break;
            case "photo_box":
                currentView = GameView.PHOTO_BOX;
                currentBackground = photoBoxImg;
                messageLabel.setText("A box with old tools and a photo dated 02/07/1999. Clue 1 is 02071999.");
                break;
            case "briefcase_location":
                hasFoundUsb = true;
                currentView = GameView.BRIEFCASE;
                currentBackground = briefcaseImg;
                messageLabel.setText("You found a briefcase containing a USB drive.");
                break;
            case "laptop":
                if (hasFoundUsb) {
                    currentView = GameView.LAPTOP;
                    currentBackground = medicalRecordImg;
                    messageLabel.setText("The USB unlocked a medical record. Diagnosis weight: 62 kg. Clue 4 is 62.");
                } else {
                    messageLabel.setText("The laptop seems locked. Maybe there's a device somewhere that can access it.");
                }
                break;
            case "newspaper_location":
                currentView = GameView.NEWSPAPER;
                currentBackground = newspaperImg;
                messageLabel.setText("A newspaper clipping about a car accident at 4:00 AM. Clue 3 is 4.");
                break;
            case "door_keypad":
                checkDoorCode();
                break;
            default:
                messageLabel.setText("There's nothing of interest there.");
                break;
        }
        repaint();
    }

    /**
     * Prompts the user for the door code and checks if it's correct.
     */
    private void checkDoorCode() {
        if (!hasFoundNotebook) {
            JOptionPane.showMessageDialog(this, "The keypad seems dead. I feel like I'm missing the main clue to how this all fits together.", "Locked", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String input = JOptionPane.showInputDialog(this, "Enter the code based on the diary's riddle:", "Enter Code", JOptionPane.PLAIN_MESSAGE);
        if (CORRECT_CODE.equals(input)) {
            JOptionPane.showMessageDialog(this, "The code is correct! The heavy door clicks and swings open. You are free!", "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        } else if (input != null) {
            JOptionPane.showMessageDialog(this, "Incorrect code. The door remains locked.", "Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Displays the content of the kidnapper's diary in a popup window.
     */
    private void showNotebookContent() {
        try (InputStream is = getClass().getResourceAsStream("/resources/textecarnet.txt");
             Scanner scanner = new Scanner(is).useDelimiter("\\A")) {
            String content = scanner.hasNext() ? scanner.next() : "";
            JTextArea textArea = new JTextArea(content);
            textArea.setWrapStyleWord(true);
            textArea.setLineWrap(true);
            textArea.setOpaque(false);
            textArea.setEditable(false);
            textArea.setFocusable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(500, 400));
            JOptionPane.showMessageDialog(this, scrollPane, "The Kidnapper's Diary", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Could not read the notebook's content.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Helper method to load an image from the resources folder.
     * @param fileName The name of the image file.
     * @return The loaded Image object.
     * @throws IOException If the image cannot be found or read.
     */
    private Image loadImage(String fileName) throws IOException {
        InputStream is = getClass().getResourceAsStream("/resources/" + fileName);
        if (is == null) {
            throw new IOException("Cannot find resource: " + fileName);
        }
        return ImageIO.read(is);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the current background image
        if (currentBackground != null) {
            g.drawImage(currentBackground, 0, 0, this);
        }
    }
}
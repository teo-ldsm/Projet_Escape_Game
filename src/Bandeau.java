import javax.swing.*;
import java.awt.*;

public class Bandeau extends JPanel {

    private final JButton boutonUtiliser;
    private final JLabel textBox;
    private final ButtonListener blistener;

    public String[] scrollableText;
    public int scrollableTextIndex = 0;
    public final JButton btnRight = new JButton(">>");
    public final JButton btnLeft = new JButton("<<");

    public Bandeau() {
        // Configuration du b principal
        this.setLayout(new BorderLayout());

        textBox = new JLabel("", SwingConstants.LEFT);
        textBox.setVerticalAlignment(SwingConstants.TOP);
        textBox.setFont(new Font("Arial", Font.BOLD, 15));
        textBox.setForeground(Color.WHITE);
        textBox.setPreferredSize(new Dimension(0, 180)); // Réglage de la hauteur du b
        this.setBackground(Color.BLACK);

        // Ajout du label au nord
        this.add(textBox, BorderLayout.NORTH);

        // Sous-panneau pour les boutons
        JPanel boutonPanel = new JPanel(new GridLayout(1, 3, 10, 10)); // 1 ligne, 3 colonnes, 10 px fenetre'espacement

        // Création des boutons
        JButton boutonPrendre = new JButton("PRENDRE");
        JButton boutonRegarder = new JButton("REGARDER");
        boutonUtiliser = new JButton("UTILISER");

        blistener = new ButtonListener(this);

        for (JButton b : new JButton[]{boutonPrendre, boutonRegarder, boutonUtiliser}) {
            b.setFont(new Font("Arial", Font.BOLD, 20));
            b.setFocusPainted(false);
            b.setForeground(Color.BLACK);
            b.setBackground(Color.WHITE);
            b.addActionListener(blistener);
        }

        boutonPrendre.setActionCommand("prendre");
        boutonRegarder.setActionCommand("regarder");
        boutonUtiliser.setActionCommand("utiliser");

        boutonUtiliser.setEnabled(false);

        // Ajout des boutons au sous-panneau
        boutonPanel.add(boutonPrendre);
        boutonPanel.add(boutonRegarder);
        boutonPanel.add(boutonUtiliser);
        boutonPanel.setBackground(Color.BLACK);

        // Ajout du sous-panneau au bas du b
        this.add(boutonPanel, BorderLayout.SOUTH);
    }

    public void activerBoutonUtiliser() { boutonUtiliser.setEnabled(true); }
    public void desactiverBoutonUtiliser() { boutonUtiliser.setEnabled(false); }

    public void setText(String text) { textBox.setText(text); }

    public void setScrollableText(String[] texts) {

        scrollableText = texts;
        setText(texts[0]);

        btnRight.addActionListener(blistener);
        btnLeft.addActionListener(blistener);

        btnRight.setActionCommand("scrollRight");
        btnLeft.setActionCommand("scrollLeft");

        for (JButton b : new JButton[]{btnLeft, btnRight}) {
            b.setFont(new Font("Arial", Font.BOLD, 20));
            b.setFocusPainted(false);
            b.setForeground(Color.WHITE);
            b.setBackground(Color.BLACK);
        }

        this.add(btnRight, BorderLayout.EAST);
        this.add(btnLeft, BorderLayout.WEST);

        btnLeft.setEnabled(false);


    }

    public void resetScrollableText() {
        this.remove(btnRight);
        this.remove(btnLeft);
    }

}
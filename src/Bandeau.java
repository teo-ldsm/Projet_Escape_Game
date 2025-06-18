import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Bandeau extends JPanel {

    private final Fenetre f;
    
    private final JButton boutonUtiliser;
    private final JButton boutonRegarder;
    private final JButton boutonPrendre;

    private final JTextArea textBox;

    public String[] scrollableText;
    public int scrollableTextIndex = 0;
    public final JButton btnRight = new JButton(">>");
    public final JButton btnLeft = new JButton("<<");

    public Bandeau(Fenetre f) {
        this.f = f;

        this.setLayout(new BorderLayout());

        textBox = new JTextArea("");
        textBox.setEditable(false);
        textBox.setFocusable(false);
        textBox.setLineWrap(true);
        textBox.setWrapStyleWord(true);
        textBox.setOpaque(false);
        textBox.setFont(new Font("Arial", Font.BOLD, 15));
        textBox.setForeground(Color.WHITE);
        textBox.setPreferredSize(new Dimension(0, 180)); // Réglage de la hauteur du bandeau

        this.setBackground(Color.BLACK);

        // Ajout du label au nord
        this.add(textBox, BorderLayout.NORTH);

        // Sous-panneau pour les boutons
        JPanel boutonPanel = new JPanel(new GridLayout(1, 3, 10, 10)); // 1 ligne, 3 colonnes, 10 px d'espacement

        // Création des boutons
        boutonRegarder = new JButton("REGARDER");
        boutonPrendre = new JButton("PRENDRE");
        boutonUtiliser = new JButton("UTILISER");

        for (JButton b : new JButton[]{boutonPrendre, boutonRegarder, boutonUtiliser}) {
            b.setFont(new Font("Arial", Font.BOLD, 20));
            b.setFocusPainted(false);
            b.setForeground(Color.BLACK);
            b.setBackground(Color.WHITE);
            b.addActionListener(f.blistener);
            b.setEnabled(false);
        }

        boutonRegarder.setActionCommand("regarder");
        boutonPrendre.setActionCommand("prendre");
        boutonUtiliser.setActionCommand("utiliser");

//        boutonUtiliser.setEnabled(false);

        // Ajout des boutons au sous-panneau
        boutonPanel.add(boutonRegarder);
        boutonPanel.add(boutonPrendre);
        boutonPanel.add(boutonUtiliser);
        boutonPanel.setBackground(Color.BLACK);

        // Ajout du sous-panneau au bas du b
        this.add(boutonPanel, BorderLayout.SOUTH);
    }

    public void activerBoutonUtiliser(String nomObjet) {
        boutonUtiliser.setEnabled(true);
        boutonUtiliser.setText("UTILISER AVEC " + nomObjet);
    }
    public void activerBoutonUtiliser() { boutonUtiliser.setEnabled(true); }
    public void desactiverBoutonUtiliser() {
        boutonUtiliser.setEnabled(false);
        boutonUtiliser.setText("UTILISER");
    }

    public void activerBoutonRegarder() { boutonRegarder.setEnabled(true); }
    public void desactiverBoutonRegarder() { boutonRegarder.setEnabled(false); }

    public void activerBoutonPrendre() { boutonPrendre.setEnabled(true); }
    public void desactiverBoutonPrendre() { boutonPrendre.setEnabled(false); }

    public void setText(String text) {
        resetScrollableText();
        textBox.setText(text);
    }

    public void setText(String text, boolean reset) {
        if (reset) {
            resetScrollableText();
        }
        textBox.setText(text);
    }

    public void setText(String[] texts) {

        scrollableText = texts;
        textBox.setText(texts[0]);

        btnRight.addActionListener(f.blistener);
        btnLeft.addActionListener(f.blistener);

        btnRight.setActionCommand("scrollRight");
        btnLeft.setActionCommand("scrollLeft");

        for (JButton b : new JButton[]{btnLeft, btnRight}) {
            b.setFont(new Font("Arial", Font.BOLD, 20));
            b.setFocusPainted(false);
            b.setForeground(Color.WHITE);
            b.setBackground(Color.BLACK);
            b.setVisible(true);
            b.setEnabled(true);
        }

        this.add(btnRight, BorderLayout.EAST);
        this.add(btnLeft, BorderLayout.WEST);

        btnLeft.setEnabled(false);


    }

    public void resetScrollableText() {
        this.remove(btnRight);
        this.remove(btnLeft);
        scrollableTextIndex = 0;
        textBox.setText("");
        btnLeft.setEnabled(false);
        btnRight.setEnabled(false);
        btnRight.setVisible(false);
        btnLeft.setVisible(false);
    }

}
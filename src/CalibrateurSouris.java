import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.CountDownLatch;

public class CalibrateurSouris extends JPanel {

    private JLabel cross1; // Croix en haut à gauche

    private final JLabel text;

    private final Fenetre f;

    private Point origine; // Coordonnées du premier clic
    private final CountDownLatch calibrationLatch; // Synchronisation

    public CalibrateurSouris(Fenetre f, CountDownLatch latch) {
        this.calibrationLatch = latch; // Injecter le CountDownLatch
        this.f = f;

        setLayout(null);

        text = new JLabel("Une calibration de la souris est nécéssaire. Cliquez sur la croix rouge pour calibrer");
        text.setBounds(100, 100, 500, 20);

        add(text);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println( "mouseClicked : " + e.getPoint() );
                if (cross1 != null && cross1.isVisible() && cross1.getBounds().contains(e.getPoint())) {
                    origine = e.getPoint();
                    calibrationTerminee();
                }
            }
        });

        setVisible(true);
    }

    public void startCalibration() {


        int xCenter = f.getContentPane().getWidth() / 2;
        int yCenter = (f.getContentPane().getHeight() - f.bandeau.getHeight()) / 2;
        System.out.println( "xCenter = " + xCenter + " yCenter = " + yCenter );

        cross1 = creerCroix(xCenter, yCenter);

        // Ajoute les croix
        add(cross1);

        // Réactualise l'interface après le changement
        revalidate();
        repaint(); // Important pour redessiner correctement
    }

    private JLabel creerCroix(int x, int y) {
        JLabel croix = new JLabel("+");
        croix.setFont(new Font("Arial", Font.BOLD, 24));
        croix.setForeground(Color.RED);
        croix.setBounds(x-10, y-10, 20, 20);
        return croix;
    }

    private void calibrationTerminee() {
        System.out.println("Calibration terminée!");
        System.out.println("Offsets : " + origine);

//        Souris.offsetX = (int) origine.getX();
//        Souris.offsetY = (int) origine.getY();

        calibrationLatch.countDown(); // Notifiez que la calibration est terminée
    }
}
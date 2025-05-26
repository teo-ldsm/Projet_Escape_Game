import javax.swing.*;
import java.awt.*;

public class Bandeau extends JPanel{
    public Bandeau(JFrame f) {
        JLabel l = new JLabel();
        l.setText("Score : 0");
        l.setFont(new Font("Arial", Font.BOLD, 20));
        l.setBounds(0, f.getHeight() - f.getHeight()*20/100, f.getWidth(), f.getHeight()*20/100);
        l.setForeground(Color.WHITE);
        l.setBackground(Color.BLACK);
        
        this.add(l);
        
        
    }
}

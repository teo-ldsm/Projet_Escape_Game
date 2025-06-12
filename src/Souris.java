import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
class Souris extends MouseAdapter {
Fenetre d;
Souris (Fenetre a){
      d= a;
}
public void mouseClicked(MouseEvent m) {
      int x = m.getX();
      int y = m.getY();
      d.click(x, y);
} 
}
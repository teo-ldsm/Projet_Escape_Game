import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    Bandeau b;

    public ButtonListener(Bandeau b) {
        super();
        this.b = b;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {

            case "scrollRight":
                b.setText(b.scrollableText[++b.scrollableTextIndex]);
                if (b.scrollableTextIndex == b.scrollableText.length - 1) {
                    b.btnRight.setEnabled(false);
                }
                b.btnLeft.setEnabled(true);
                break;
            case "scrollLeft":
                b.setText(b.scrollableText[--b.scrollableTextIndex]);
                if (b.scrollableTextIndex == 0) {
                    b.btnLeft.setEnabled(false);
                }
                b.btnRight.setEnabled(true);
        }

    }
}

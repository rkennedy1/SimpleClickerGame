import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

public class Launcher {
	public static void main(String[] args) {
		Game theGame = new Game();
		theGame.setSize(910,645);
		theGame.setVisible(true);
        theGame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        theGame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                theGame.createSaveFile();
                System.exit(1);
            }
        });
	}
}
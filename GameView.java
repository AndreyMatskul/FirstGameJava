package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {

    private Image background;
    private Jason jason;
    private Font font = Font.getFont(Font.SERIF);

    public GameView(World w, int width, int height, Jason s) {
        super(w, width, height);
        background = new ImageIcon("data/dungeonprison.gif").getImage();
            this.jason = s;
        }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }

    /** @Override
    protected void paintForeground(Graphics2D g) {
        super.paintForeground(g);

        g.setColor(Color.ORANGE);
        g.fillRect(0,0, 100,100);
        g.drawRect(0, 0, 100, 100);

        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString("Number of Keys:" + jason.getKeys(), 5, -20);
    }
     **/
}

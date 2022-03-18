package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.JFrame;

public class Game {

    private GameWorld world;

    private GameView view;

    public Game() {

        GameWorld world = new GameWorld();

        view = new GameView(world, 800, 500, world.getJason());
        view.setZoom(18);

        JasonController controller = new JasonController(world.getJason());
        view.addKeyListener(controller);
        view.addMouseListener(new GiveFocus(view));


        final JFrame frame = new JFrame("Dungeon Escape");
        frame.add(view);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);

        //uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 500, 500);

        world.start();
    }

    public static void main(String[] args) {

        new Game();

    }
}

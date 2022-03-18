package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Jason extends Walker {
    private static final Shape JasonShape = new PolygonShape(
            0f, 2.1f,
            1.7f, 0.6f,
            0.9f,-3.3f,
            -1.2f,-3.3f,
            -1.6f, 0.6f);

    private static BodyImage JasonImage =
            new BodyImage("data/IdleHero1.gif", 7f);

    private int JumpCounter;
    private int  keys;

    public Jason (World world) {
        super(world, JasonShape);
        addImage(JasonImage);

        JumpCounter = 0;
        keys = 0;
    }

    public int getJumpCounter(){
        return JumpCounter;
    }

    public void incrementJumpCounter(){
        JumpCounter = getJumpCounter() + 1;
    }

    public void setKeys(int keys){
        this.keys = keys;
    }
    public int getKeys(){
        return keys;
    }

    public void addJasonImage(String s, float v) {
        JasonImage = new BodyImage(s, v);
    }
}
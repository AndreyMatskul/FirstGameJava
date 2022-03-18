package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class GameWorld extends World {

    private Jason jason;
    private Skeleton skeleton;

    public GameWorld() {

        // Ground
        Shape GroundS = new BoxShape(30, 1f); //GroundS = Ground Shape
        StaticBody ground = new StaticBody(this, GroundS);
        ground.setPosition(new Vec2(0f, -12.5f));
        ground.addImage(new BodyImage("./data/floor.png", 2f));
        // Platforms
        Shape PlatformStS = new BoxShape(4, 0.5f);     //PlatformStS = Platform Standard Shape
        StaticBody platform1 = new StaticBody(this, PlatformStS);
        platform1.setPosition(new Vec2(-12, -4f));
        platform1.addImage(new BodyImage("./data/PlatformTest.png", 1f));

        StaticBody platform2 = new StaticBody(this, PlatformStS);
        platform2.setPosition(new Vec2(5, -5f));
        platform2.addImage(new BodyImage("./data/PlatformTest.png", 1f));

        StaticBody platform3 = new StaticBody(this, PlatformStS);
        platform3.setPosition(new Vec2(-2, 4f));
        platform3.addImage(new BodyImage("./data/PlatformTest.png", 1f));

        StaticBody platform4 = new StaticBody(this, PlatformStS);
        platform4.setPosition(new Vec2(12, 4f));
        platform4.addImage(new BodyImage("./data/PlatformTest.png", 1f));
        // Walls

        Shape WallS1 = new BoxShape(1, 10f); //WallS = Wall Shape
        StaticBody wall1 = new StaticBody(this, WallS1);
        wall1.setPosition(new Vec2(-20,6f));
        wall1.addImage(new BodyImage("./data/Wall.png", 19f));

        Shape WallS2 = new BoxShape(2, 15f); //WallS = Wall Shape
        StaticBody wall2 = new StaticBody(this, WallS2);
        wall2.setPosition(new Vec2(23,1f));
        wall2.addImage(new BodyImage("./data/Wall.png", 26f));


       // Main Hero creation and initial position
       jason = new Jason(this);
       jason.setPosition(new Vec2(17, -10));
       KeysPickup pickup = new KeysPickup(jason);
       DoorUnlock unlock = new DoorUnlock(jason);
       jason.addCollisionListener(pickup);
       jason.addCollisionListener(unlock);

       // add more bodies here
       skeleton = new Skeleton(this);
       skeleton.setPosition(new Vec2(-10,-10));
       SkeletonBump bump = new SkeletonBump(skeleton);
       skeleton.addCollisionListener(bump);

       new Keys(this).setPosition(new Vec2(12,5f));
       new Door(this).setPosition(new Vec2(-20,-8f));

    }

    public Jason getJason(){
        return jason;
    }

    public void setJason(Jason jason) {
        this.jason = jason;
    }

}

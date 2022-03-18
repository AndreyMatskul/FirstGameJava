package game;

import city.cs.engine.*;

public class Skeleton extends Walker {

    private static final Shape SkeletonShape = new PolygonShape(
            1.8f, 2f,
            1.8f,-2.3f,
            -1.8f,-2.3f,
            -1.8f, 1.6f);

    private static BodyImage SkeletonImage =
            new BodyImage("data/SkeletonWalk1.gif", 5f);


    public Skeleton(World world) {
        super(world, SkeletonShape);
        addImage(SkeletonImage);
    }


    public void addSkeletonImage(String s, float v) {
        SkeletonImage = new BodyImage(s, v);
    }

}

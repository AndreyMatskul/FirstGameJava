package game;

import city.cs.engine.Body;
import city.cs.engine.BodyImage;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class SkeletonBump implements CollisionListener {

    private Skeleton skeleton;
    public SkeletonBump(Skeleton s){ this.skeleton = s; }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Jason) {
            e.getOtherBody().destroy();
        } else if (e.getOtherBody() instanceof Door) {
            skeleton.startWalking(3);
            skeleton.removeAllImages();
            skeleton.addImage(new BodyImage("data/SkeletonWalk.gif", 5f));
        } else if (e.getOtherBody() instanceof Body) {
            skeleton.startWalking(-3);
            skeleton.removeAllImages();
            skeleton.addImage(new BodyImage("data/SkeletonWalk1.gif", 5f));
        }
    }
}

package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import city.cs.engine.World;

public class KeysPickup implements CollisionListener {

    private Jason jason;
    public KeysPickup(Jason s){
        this.jason = s;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Keys) {
            jason.setKeys(jason.getKeys()+1);
            e.getOtherBody().destroy();
        }
    }
}
package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Keys extends DynamicBody {

    private static final Shape KeyShape = new CircleShape(1);

    private static final BodyImage image =
            new BodyImage("data/key-blue.gif", 5f);

    public Keys(World w) {
        super(w,KeyShape);
        addImage(image);
    }
}

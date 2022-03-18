package game;

import city.cs.engine.*;
import city.cs.engine.Shape;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;

public class Door extends StaticBody {

    Color Blue = new Color(0,0,255);

    private static final Shape DoorShape = new BoxShape(1, 5);

    public Door(World w) {
        super(w,DoorShape);
        setFillColor(Color.blue);
    }
}
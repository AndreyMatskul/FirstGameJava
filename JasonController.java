package game;

import city.cs.engine.Body;
import city.cs.engine.BodyImage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class JasonController implements KeyListener {

    private static final float WALKING_SPEED = 3;

    private Jason jason;
    private int HeroWalkingSpeed = 0;
    private int HeroJumping = 0;

    public JasonController(Jason s){
        jason = s;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_A){
            jason.startWalking(-WALKING_SPEED * 2);
            HeroWalkingSpeed = -1;
            while (HeroJumping == 1){
                jason.removeAllImages();
                jason.addImage(new BodyImage("data/JumpingHero1.png", 7f));
                break;
            }
            while (HeroJumping == 0){
                jason.removeAllImages();
                jason.addImage(new BodyImage("data/RunningHero1.gif", 7f));
                break;
            }
        } else if (code == KeyEvent.VK_D) {
            jason.startWalking(WALKING_SPEED*2);
            HeroWalkingSpeed = 1;
            while (HeroJumping == 1){
                jason.removeAllImages();
                jason.addImage(new BodyImage("data/JumpingHero.png", 7f));
                break;
            }
            while (HeroJumping == 0){
                jason.removeAllImages();
                jason.addImage(new BodyImage("data/RunningHero.gif", 7f));
                break;
            }
        }
        else if (code == KeyEvent.VK_W){
            jason.jump(12);
            jason.incrementJumpCounter();
            HeroJumping = 1;
            while (HeroWalkingSpeed < 0){
                jason.removeAllImages();
                jason.addImage(new BodyImage("data/JumpingHero1.png", 7f));
                break;
            }
            while (HeroWalkingSpeed > 0){
                jason.removeAllImages();
                jason.addImage(new BodyImage("data/JumpingHero.png", 7f));
                break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            jason.stopWalking();
            HeroWalkingSpeed = 0;
            while (HeroJumping == 0){
                jason.removeAllImages();
                jason.addImage(new BodyImage("data/IdleHero1.gif", 7f));
                break;
            }

        } else if (code == KeyEvent.VK_D) {
            jason.stopWalking();
            HeroWalkingSpeed = 0;
            while (HeroJumping == 0){
                jason.removeAllImages();
                jason.addImage(new BodyImage("data/IdleHero.gif", 7f));
                break;
            }

        } else if (code == KeyEvent.VK_W){
            HeroJumping = 0;
            while (HeroWalkingSpeed < 0){
                jason.removeAllImages();
                jason.addImage(new BodyImage("data/FallingHero1.png", 7f));
                break;
            }
            while (HeroWalkingSpeed > 0){
                jason.removeAllImages();
                jason.addImage(new BodyImage("data/FallingHero.png", 7f));
                break;
            }
        }
    }
}
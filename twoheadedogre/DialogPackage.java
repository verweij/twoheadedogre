import greenfoot.*;
import java.util.Random;

/**
 * Dialog package is for storyline dialog.
 * 
 * @author Robin Verweij
 * @version super beta
 */
public class DialogPackage  
{
    /**
     * When dialog plays, set to true. 
     * When dialog is finished, set back to false.
     * This stops the problem of overlaying dialog.
     */
    private boolean dialogPlaying;
    private Random r;
    
    private int currPlayedTime;
    private final int soundPlayTime = 150;
    
    public DialogPackage(Random r)
    {
        this.r = r;
        currPlayedTime = 0;
        dialogPlaying = false;
    }
    
    public void dialogAct() {
        currPlayedTime = (currPlayedTime + 1) % soundPlayTime;
        if (currPlayedTime == 0) {
           dialogPlaying = false;
        }
    }
    
    /**
     * Must pass classType as a string
     *  ex: playDialog("knight",face); for a knight spawning with dialog.
     * Gordo is the face variable, telling us which ogre is being controlled at the moment.
     *  This allows us to switch between dialogs if we so wish.
     */
    public void playDialog(String classType, boolean gordo) {
        // randomly generate a number
        // set dialogPlaying to true
        // play a dialog corresponding to that number
        if (!dialogPlaying && classType.equals("ogre")) {
            if (gordo) {
               dialogPlaying = true;
               String whichOne = Integer.toString(r.nextInt(9));
               Greenfoot.playSound("gordo"+whichOne+".wav");
            }
            else {
               dialogPlaying = true;
               String whichOne = Integer.toString(r.nextInt(8));
               Greenfoot.playSound("omak"+whichOne+".wav");
            }
        }
        else if (!dialogPlaying && (classType.equals("knight") || classType.equals("archer"))) {
            dialogPlaying = true;
            String whichOne = Integer.toString(r.nextInt(7));
            Greenfoot.playSound("human"+whichOne+".wav");
        }
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Face here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Face extends Actor
{
    private boolean face;
    private boolean pushed = false;
   public Face(boolean face){
       this.face = face;
   }
   public void act(){
        processKeys();
    }
   private void processKeys() {
        if(Greenfoot.isKeyDown("control") && !pushed) {
            face = !face;
            pushed = true;
            change();
        } 
        if(!Greenfoot.isKeyDown("control")){
            pushed = false;
        }
    }
   private void change(){
        if (face){
            //Use Dimond
            setImage("karo.png");
        }
        else{
            //Use Club
            setImage("kreuz.png");
        }
    }
}
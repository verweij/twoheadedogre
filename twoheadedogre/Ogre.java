import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Ogre here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ogre extends SoundActor
{
   
    
    /**
     * Act - do whatever the Ogre wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean walking= true;
    private int switchWait =0;
    private Face face;
    
    ImagePackage imgPack;
    
     public Ogre(ImagePackage imgPack, Face face) {
        super(imgPack);
        this.face=face;
        this.imgPack = imgPack;
    }
    
    public void act() 
    {
        if(switchWait<1){
            switchHead();
            switchWait=3;
        }else{
            switchWait--;
        }
        procInput();
        procAI();
        super.act();
    }
    private void procAI (){
        List<Enemy> enemies = getWorld().getObjects(Enemy.class);
        Enemy closest=null;
        int x1=0,x2=0,y1=0,y2=0;
        for (Enemy E: enemies){
            if(closest==null){
                closest=E;
                x2=getX()-closest.getX();
                y2=getY()-closest.getY();
            }
            else{
                x1=getX()-E.getX();
                y1=getY()-E.getY();
                x2=getX()-closest.getX();
                y2=getY()-closest.getY();
                if((x1*x1)+(y1*y1)< (x2*x2)+(y2+y2)){
                    closest=E;
                    x2=getX()-closest.getX();
                    y2=getY()-closest.getY();
                }
            }
        }
        
        if (closest==null){
            return;
        }
        
        if(walking){
            int dir;
            if((x2*x2) <(y2*y2)){
                if(x2>0){
                    currDirection=WEST;
                    dir=WEST;
                }else{
                    currDirection=EAST;
                    dir=EAST;
                }
            }else{
                if(y2>0){
                    currDirection=NORTH;
                    dir=NORTH;
                }else{
                    currDirection=SOUTH;
                    dir=SOUTH;
                }
            }
        }else{
            int x=0;
            int y=0;
            if(x2>0){
                x-=5;
            }else if(x2<0){
                x+=5;
            }
            if(y2>0){
                y-=5;
            }else if(y2<0){
                y+=5;
            }
            setLocation(getX()+x,getY()+y);
        }
    }
    private void switchHead(){
        if (Greenfoot.isKeyDown("s")){
            walking= !walking;
            face.face=walking;
            face.change();
        }
    }
    private void procInput(){
        int x =0;
        int y=0;
        int dir=-1;
        if(Greenfoot.isKeyDown("a") && !walking){
            isAttacking=true;
            
        }
        if(Greenfoot.isKeyDown("left")){
            currDirection=WEST;
            if (walking){
                x-=5;
            }else{
                dir=WEST;
            }
        }
        if(Greenfoot.isKeyDown("right")){
            currDirection=EAST;
            if (walking){
                x+=5;
            }else{
                dir=EAST;
            }
        }
        if(Greenfoot.isKeyDown("up")){
            currDirection=NORTH;
            if (walking){
                y-=5;
            }else{
                dir=NORTH;
            }
        }
        if(Greenfoot.isKeyDown("down")){
            currDirection=SOUTH;
            if (walking){
                y+=5;
            }else{
                dir=SOUTH;
            }
        }
        setLocation(getX()+x,getY()+y);
        
    }
}

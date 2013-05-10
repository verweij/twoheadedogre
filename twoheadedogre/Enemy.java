import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends SoundActor
{

    
    public Enemy(ImagePackage imgPack) {
       super(imgPack);
    }
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }
    protected void checkCollision(){
        java.util.List <Actor> objs= getIntersectingObjects(Actor.class);
        for(Actor obj: objs){
            if (obj instanceof Ogre){
                Ogre O= (Ogre)obj;
                boolean facingOK = false;
                switch (O.currDirection){
                    case NORTH: facingOK =(getY()<O.getY()) ? true: false;
                                break;
                    case SOUTH: facingOK= (getY()>O.getY()) ? true : false;
                                break;
                    case EAST: facingOK=(getX()>O.getX()) ? true : false;
                                break;
                    case WEST: facingOK= (getY()<O.getY()) ? true : false;
                                break;
                }
                if (O.isAttacking && facingOK){
                    ((GrassWorld)getWorld()).BaddieCount--;
                    getWorld().removeObject(this);
                    return;
                }else{
                    int x=0;
                    int y=0;
                    if( getX()< obj.getX()){
                        x-=5;
                    }else if( getX()> obj.getX()){
                        x+=5;
                    }
                    if( getY()< obj.getY()){
                        y-=5;
                    }else if( getY()> obj.getY()){
                        y+=5;
                    }
                    setLocation(getX()+x, getY()+y);
                }
            }else{
                int x=0;
                int y=0;
                if( getX()< obj.getX()){
                    x-=3;
                }else if( getX()> obj.getX()){
                    x+=3;
                }
                if( getY()< obj.getY()){
                    y-=3;
                }else if( getY()> obj.getY()){
                    y+=3;
                }
                setLocation(getX()+x, getY()+y);
            }
        }
    }
}

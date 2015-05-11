package nl.krakie.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Player {

    public int healthMax;
    public int healthCurrent;
    public int currentLevel;
    public float x;
    public float y;
    float hspeed;
    float vspeed;
    int maxHSpeed;
    int maxVSpeed;
    int gravity;
    float accel;
    float decel;
    int jumpSpeed;

    public static boolean jumping = false;

    public boolean grounded;


    public Player(){

        healthMax = 100;
        healthCurrent = 100;
        currentLevel = 0;
        x = 400-32; //Starts the player in de middle of the screen instead of slightly to the right
        y = 0;
        hspeed = 0;
        vspeed = 0;
        maxHSpeed =(int)(0.25*Gdx.graphics.getWidth());
        maxVSpeed =(int) (0.33*Gdx.graphics.getHeight());
        accel = (float)(2.25*maxHSpeed);
        decel = (float)(3.00*maxHSpeed);
        gravity = (int)(0.50*Gdx.graphics.getHeight());
        grounded = true;
        jumpSpeed = (int)(5.00*Gdx.graphics.getHeight());
    }
    public void move(float dTime){

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)||Gdx.input.isKeyPressed(Input.Keys.W)) {
            if(grounded) {
                System.out.println("Jumping now");
                y++;
                vspeed = vspeed + jumpSpeed;

                grounded = false;
            }
            jumping = false;
        }

        if ((Gdx.input.isKeyPressed(Input.Keys.D))&&(Gdx.input.isKeyPressed(Input.Keys.A))) {

                if (hspeed > 0){
                    hspeed = hspeed - (decel*dTime);
                    
                    if (hspeed<0){
                        hspeed=0;
                    }
                 }
                
                else if (hspeed < 0){
                hspeed = hspeed + (decel*dTime);
                
                    if (hspeed>0){
                        hspeed=0;
                }
            }
        }

        else if (Gdx.input.isKeyPressed(Input.Keys.D)){
                
                if (hspeed<0){
                    hspeed =  ( hspeed + (decel*dTime));
                }
                else {
                    hspeed =  ( hspeed + (accel*dTime));
                }
            }
        
        else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                
                if (hspeed>0){
                    hspeed =  (hspeed - (decel*dTime));
                }
                else {
                    hspeed =  (hspeed - (accel*dTime));
                }
            }

        
            
            
            else {
                
              if (hspeed > 0){
                    hspeed = hspeed - (decel*dTime);
                    
                    if (hspeed<0){
                        hspeed=0;
                    }
                 }
                
                else if (hspeed < 0){
                hspeed = hspeed + (decel*dTime);
                
                    if (hspeed>0){
                        hspeed=0;
                }
            }  
            }

        

        if (hspeed > maxHSpeed){
            hspeed = maxHSpeed;
        }
        else if (-hspeed > maxHSpeed){
            hspeed = -maxHSpeed;
        }

        if (vspeed > maxVSpeed){
            vspeed = maxVSpeed;
        }
        else if (-vspeed > maxVSpeed){
            vspeed = -maxVSpeed;
        }

        System.out.println(hspeed*dTime);
        x = (x+hspeed*dTime);
        y = (y+vspeed*dTime);
    }

    public void gravity (float dTime){

        if (!grounded){
            vspeed = vspeed-(gravity*dTime);
        }
        if (y<=0){
            grounded = true;
            y = 0;
        }
    }

    public void update(float dTime){

        move(dTime);
        gravity(dTime);
        }

    
}

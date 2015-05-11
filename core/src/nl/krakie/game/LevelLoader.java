
package nl.krakie.game;

import com.badlogic.gdx.maps.tiled.*;

public class LevelLoader {
    
 
 public TiledMap         tiledMap;
        String[]         levels = new String[2];
        int              currentLevel = 0;
     public void LevelLoader(){
         
         levels[0]="Level0.tmx";
         levels[1]="Level1.tmx";
         
         
     }
     
     public void nextLevel(){
         tiledMap = new TmxMapLoader().load(levels[currentLevel+1]);
         
     }
     
     
}

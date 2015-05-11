package nl.krakie.game;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import nl.krakie.player.Player;

public class Main extends ApplicationAdapter {


    SpriteBatch batch;
	Texture testPlayer;
    public static Player player;
    public OrthographicCamera camera;
    TiledMapRenderer tiledMapRenderer;
    LevelLoader levelLoader;



    public void loadTextures(){

        batch = new SpriteBatch();
        testPlayer = new Texture(Gdx.files.internal("TestSprite.png"));

    }

    public void loadSounds(){

    }

	public void loadAssets(){

        loadTextures();
        loadSounds();

    }
        public void nextLevel(){
            levelLoader.nextLevel();
            tiledMapRenderer = new OrthogonalTiledMapRenderer(levelLoader.tiledMap);
            player.x = 32; 
            player.y = 0;
        }

	@Override
	public void create() {


        loadAssets();
        System.out.println("Game started");
        
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800,480);
        
        levelLoader = new LevelLoader();
       
        tiledMapRenderer = new OrthogonalTiledMapRenderer(levelLoader.tiledMap);
        
        player = new Player();
	}

    public void updateGraphics() {

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
        
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(testPlayer, player.x, player.y);
        batch.end();
    }

    public void updateSound() {
        
    }

    public void updatePlayer() {

        player.update(Gdx.graphics.getDeltaTime());

    }

    public void updateGameLogic(){
        updatePlayer();
    }

    @Override
    public void render() {

        updateGameLogic();

        updateGraphics();

        updateSound();
    }
}

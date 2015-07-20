package com.untitled.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.untitled.game.debug.CameraPanInputController;
import com.untitled.game.topdown.TopDownPlayer;
import com.untitled.game.topdown.tilemap.UntitledTileMap;
import com.untitled.game.topdown.tilemap.UntitledTileMapLoader;
import com.untitled.game.topdown.tilemap.UntitledTileMapRendererWithSprites;

public class GameScreen implements Screen
{
	private Game game;
	private UntitledTileMap map;
	private UntitledTileMapRendererWithSprites renderer;
	private OrthographicCamera camera;
	private TopDownPlayer player;
	
	
	public GameScreen(Game game)
	{
		this.game = game;
	}
	@Override
	public void show()
	{;
		camera = new OrthographicCamera(640,320);
		map = new UntitledTileMapLoader(new InternalFileHandleResolver()).load("test/map_test/testlevel.tmx", "test/highsprite_test-packed/pack.atlas");
		player = new TopDownPlayer(map.getTiledMap());
		map.addSprite(player.playerSprite);
		renderer = new UntitledTileMapRendererWithSprites(map);
		camera.position.x = player.playerSprite.getX();
		camera.position.y = player.playerSprite.getY();
		renderer.setView(camera);
		Gdx.input.setInputProcessor(player.playerController);
	}

	@Override
	public void render(float delta)
	{
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		player.update();
		camera.position.x = player.playerSprite.getX();
		camera.position.y = player.playerSprite.getY();
		camera.update();
		renderer.setView(camera);
		renderer.render();
	}

	@Override
	public void resize(int width, int height)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void pause()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void resume()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void hide()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose()
	{
		// TODO Auto-generated method stub

	}

}

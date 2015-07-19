package com.untitled.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.untitled.game.util.Resource;

public class MenuScreen implements Screen
{
	private Game game;
	public Stage stage;
	private Skin skin;
	
	public MenuScreen(Game game)
	{
		this.game = game;
	}
	
	@Override
	public void show()
	{	
		
		skin = Resource.assetManager.get("test/skin_test/uiskin.json");
		stage = new Stage(new StretchViewport(640, 320));
		TextButton startGame = new TextButton("Start ze Game!",skin);
		startGame.addListener(new ChangeListener() {
			
			@Override
			public void changed(ChangeEvent event, Actor actor)
			{
				game.setScreen(new GameScreen(game));		
			}
		});
		Table table = new Table(skin);
		table.add(startGame);
		table.setFillParent(true);
		stage.addActor(table);
		Gdx.input.setInputProcessor(stage);
		
	}

	@Override
	public void render(float delta)
	{
		stage.draw();
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
		dispose();
	}

	@Override
	public void dispose()
	{
		
	}

}

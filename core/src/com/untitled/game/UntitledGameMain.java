package com.untitled.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.untitled.game.screens.GameScreen;
import com.untitled.game.screens.MenuScreen;
import com.untitled.game.util.Resource;

public class UntitledGameMain extends Game {


	
	@Override
	public void create () {
		Resource.assetManager.load("test/skin_test/uiskin.json",Skin.class);
		Resource.assetManager.finishLoading();
		setScreen(new MenuScreen(this));
	}
}

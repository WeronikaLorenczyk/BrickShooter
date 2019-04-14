package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	private StateHandler stateHandler;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		stateHandler = new StateHandler(batch);
		stateHandler.add(new MenuState(stateHandler));
		//stateHandler.add(new PlayState(stateHandler,new Vector2(0,0),new Vector2(10,10)));
		//img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		///batch.draw(img, 0, 0);;
		batch.begin();
		stateHandler.update(Gdx.graphics.getDeltaTime());
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}
}

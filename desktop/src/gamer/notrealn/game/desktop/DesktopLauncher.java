package gamer.notrealn.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import gamer.notrealn.game.KotlinGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "game";
		config.width = 16 * 64;
        config.height = 9 * 64;
//        config.windowMaximized
		new LwjglApplication(new KotlinGame(), config);
	}
}

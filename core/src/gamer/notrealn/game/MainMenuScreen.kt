package gamer.notrealn.game

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input.Keys
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.utils.ScreenUtils


class MainMenuScreen(private val game: KotlinGame) : Screen {
    private var camera: OrthographicCamera = OrthographicCamera()

    init {
        camera.setToOrtho(false, 800f, 480f)
    }

    override fun show() {
//        TODO("Not yet implemented")
    }

    override fun render(delta: Float) {
        ScreenUtils.clear(0f, 0f, 0f, 1f)

        camera.update()
        game.batch.projectionMatrix = camera.combined

        game.batch.begin()
        game.font.draw(game.batch, "Press enter to start", 100f, 100f)
        game.batch.end()

        if (Gdx.input.isKeyJustPressed(Keys.ENTER)) {
            game.screen = GameScreen(game)
            dispose()
        }
    }

    override fun resize(width: Int, height: Int) {
//        TODO("Not yet implemented")
    }

    override fun pause() {
//        TODO("Not yet implemented")
    }

    override fun resume() {
//        TODO("Not yet implemented")
    }

    override fun hide() {
//        TODO("Not yet implemented")
    }

    override fun dispose() {
//        TODO("Not yet implemented")
    }
}
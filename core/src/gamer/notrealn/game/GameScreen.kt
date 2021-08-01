package gamer.notrealn.game

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.*
import com.badlogic.gdx.utils.ScreenUtils
import com.badlogic.gdx.utils.viewport.FitViewport


class GameScreen(private val game: KotlinGame) : Screen {
    private val width = 16f * 16
    private val height = 9f * 16

    private var camera = OrthographicCamera()
    private var hudCam = OrthographicCamera()
    private var camViewport = FitViewport(width, height, camera)
    private var hudViewport = FitViewport(width, height, hudCam)

    private var world = World(Vector2(0f, -128f), true)
    private var debugRenderer = Box2DDebugRenderer()
    private var player = Player(world)
//    private var playerBody: Body
    private var img = Texture("ohno.png")

    init {
        camera.setToOrtho(false, width, height)
        hudCam.setToOrtho(false, width, height)

        camViewport.update(Gdx.app.graphics.width, Gdx.app.graphics.height, true)
        hudViewport.update(Gdx.app.graphics.width, Gdx.app.graphics.height, true)

        val groundBodyDef = BodyDef()
        groundBodyDef.position.set(Vector2(0f, 8f))
        val groundBody = world.createBody(groundBodyDef)

        val groundBox = PolygonShape()
        groundBox.setAsBox(camera.viewportWidth, 10.0f)
        groundBody.createFixture(groundBox, 0.0f)
        groundBox.dispose()

//        val bodyDef = BodyDef()
//        bodyDef.type = BodyDef.BodyType.DynamicBody
//        bodyDef.position.set(100f, 100f)
//        val body = world.createBody(bodyDef)
//        playerBody = body
//
//        val box = PolygonShape()
//        box.setAsBox(16f, 16f)
//
//        val fixtureDef = FixtureDef()
//        fixtureDef.shape = box
//        fixtureDef.density = 0.1f
//        fixtureDef.friction = 1f
//        body.createFixture(fixtureDef)
//
//        box.dispose()
    }

    override fun show() {
//        TODO("Not yet implemented")
    }

    override fun render(delta: Float) {
        ScreenUtils.clear(0f, 0f, 0f, 1f)
        camera.update()

        debugRenderer.render(world, camera.combined)
        world.step(1 / 60f, 6, 2)

        player.update()
    }

    override fun resize(width: Int, height: Int) {
        camViewport.update(width, height)
        hudViewport.update(width, height, true)
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
        img.dispose()
    }
}
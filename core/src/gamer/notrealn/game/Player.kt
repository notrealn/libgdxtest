package gamer.notrealn.game

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.physics.box2d.*

class Player(gameWorld: World) {
    private var world: World = gameWorld
    var body: Body

    init {
        val bodyDef = BodyDef()
        bodyDef.type = BodyDef.BodyType.DynamicBody
        bodyDef.position.set(100f, 100f)
        val worldBody = world.createBody(bodyDef)
        body = worldBody

        val box = PolygonShape()
        box.setAsBox(16f, 16f)

        val fixtureDef = FixtureDef()
        fixtureDef.shape = box
        fixtureDef.density = 0.1f
        fixtureDef.friction = 1f
        body.createFixture(fixtureDef)

        box.dispose()
    }

    fun update() {
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            body.applyLinearImpulse(-640f, 0f, body.position.x, body.position.y, true)
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            body.applyLinearImpulse(640f, 0f, body.position.x, body.position.y, true)
        }

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            body.applyLinearImpulse(0f, 640f, body.position.x, body.position.y, true)
        }
    }
}
package model

class FakeEngine (var randomSeed: Int): Engine {

    override fun accelerate(): Boolean {
        return randomSeed >= 4
    }
}
package model

data class Car(val name: String) {
    var engine: Engine? = null
    var step = 0

    @Throws(NullPointerException::class)
    fun drive(): Boolean {
        if (engine == null) {
            throw NullPointerException()
        }
        val isAccelerated = engine?.accelerate()
        if (isAccelerated == true) {
            step++
        }
        return isAccelerated ?: false
    }
}
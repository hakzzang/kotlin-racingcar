package model

data class Car(val name: String) {
    var engine: Engine? = null

    @Throws(NullPointerException::class)
    fun drive(): Boolean {
        if (engine == null) {
            throw NullPointerException()
        }
        return engine?.accelerate() ?: false
    }
}
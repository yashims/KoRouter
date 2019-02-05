package me.yashims85.korouter

class History() {

    private val history: MutableList<String> = mutableListOf()
    private var index: Int = -1

    fun push(location: String): String {
        if (history.size > 0 && history[index] == location) {
            return history[index]
        }

        index++

        if (history.lastIndex < index) {
            history.add(location)
        } else {
            history[index] = location
            ((index+1)..history.lastIndex).forEach {
                history.removeAt(it)
            }
        }
        return history[index]
    }

    fun replace(location: String): String {
        if (index < 0) {
            return push(location)
        }

        history[index] = location
        return history[index]
    }

    fun go(number: Int): String {
        var nextIndex = index + number
        if (nextIndex < 0) nextIndex = 0
        if (nextIndex > history.lastIndex) nextIndex = history.lastIndex
        index = nextIndex
        return history[index]
    }

    fun back(): String = go(-1)
    fun forward(): String = go(1)

    fun hasBack() = 0 < index
    fun hasForward() = history.lastIndex > index
}
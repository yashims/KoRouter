package me.yashims85.korouter

class History {

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
            ((index + 1)..history.lastIndex).forEach {
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
        val nextIndex = index + number
        if (nextIndex < 0 || nextIndex > history.lastIndex) {
            throw OutOfHistoryRangeException()
        }
        index = nextIndex
        return history[index]
    }

    fun back(number: Int = -1): String = go(number)

    fun forward(number: Int = 1): String = go(number)

    fun hasBack() = 0 < index
    fun hasForward() = history.lastIndex > index
}
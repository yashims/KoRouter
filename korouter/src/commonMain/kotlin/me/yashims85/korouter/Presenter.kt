package me.yashims85.korouter

interface Presenter {
    fun onSwapInChild(name: String, child: Presenter, args:Map<String, String>)
    fun onSwapOutChild(name: String, child: Presenter)
}

package kotlin.playingFun

fun main(args: Array<String>) {

    fun double(i: Int): Int {
        return 2 * i
    }

    presentGently(null)
    // Prints: Hello. I would like to present you: null
    presentGently(1)
    // Prints: Hello. I would like to present you: 1
    presentGently("Str")
    // Prints: Hello. I would like to present you: Str

}

fun presentGently(v: Any?) {
    println("Hello. I would like to present you: $v")
}
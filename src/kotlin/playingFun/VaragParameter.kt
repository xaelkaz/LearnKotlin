package kotlin.playingFun

fun printSum(vararg numbers: Int) {
    val sum = numbers.sum()
    print(sum)
}

printSum(1,2,3,4,5) // Prints: 15
printSum()          // Prints: 0


fun printAll(vararg texts: String) {
    //Inferred type of texts is Array<String>
    val allTexts = texts.joinToString(",")
    println("Texts are $allTexts")
}

printAll("A", "B", "C") // Prints: Texts are A,B,C


/* Varag with spread operator */

fun printAll(vararg texts: Any) {
    val allTexts = texts.joinToString(",") // 1
    println(allTexts)
}

// Usage
printAll("A", 1, 'c') // Prints: A,1,c

val texts = arrayOf("B", "C", "D")
printAll(*texts) // Prints: Texts are: B,C,D
printAll("A", *texts, "E") // Prints: Texts are: A,B,C,D,E


override fun onOptionsItemSelected(item: MenuItem): Boolean = when
{
    item.itemId == android.R.id.home -> {
        onBackPressed()
        true
    }
    else -> super.onOptionsItemSelected(item)
}
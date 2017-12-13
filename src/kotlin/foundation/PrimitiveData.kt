package kotlin.foundation

// Array

val array1 = arrayOf(1,2,3)   // inferred type Array<Int>
val array2: Array<Short> = arrayOf(1,2,3)
val array3: Array<Long> = arrayOf(1,2,3)

val array1x =  shortArrayOf(1, 2, 3)
val array2x =  intArrayOf(1, 2, 3)
val array3x =  longArrayOf(1, 2, 3)

val array = arrayOfNulls<String>(3) // Prints: [null, null, null]
val arraySize = Array (5) { it * 2 }


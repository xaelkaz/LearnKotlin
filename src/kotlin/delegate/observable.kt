package kotlin.delegate

var list: MutableList<Int> by observable(mutableListOf())
{ _, old, new ->
    println("List changed from $old to $new")
}

// Usage
list.add(1)  // 1
list =  mutableListOf(2, 3)
// 2, prints: List changed from [1] to [2, 3]
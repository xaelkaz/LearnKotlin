/*       db.beginTransaction()
       val id = try {
           val returnValue = db.insert(HabitEntry.TABLE_NAME, null, values)
           db.setTransactionSuccessful()
           returnValue
       } finally {
           db.endTransaction()
       }
               db.close() */


val id: Long = db.transaction {
    insert(HabitEntry.TABLE_NAME, null, values)
}

private fun <T> SQLiteDatabase.transaction(function: SQLiteDatabase.() -> T): T {
    beginTransaction()
    val result = try {
        val returnValue = function()
        setTransactionSuccessful()
        returnValue
    } finally {
        endTransaction()
    }
    close()
    return result
}

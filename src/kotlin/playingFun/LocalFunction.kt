package kotlin.playingFun

fun makeStudentList(): List<Student> {
    var students: List<Student> = emptyList()
    fun addStudent(name: String, state: Student.State =
    Student.State.New) {
        students += Student(name, state, courses = emptyList())
    }
    // ...
    addStudent("Adam Smith")
    addStudent("Donald Duck")
    // ...
    return students
}
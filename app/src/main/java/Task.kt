import java.time.LocalDate


data class Task(
    var title: String,
    var description: String,
    var category: String? = null,
    var priority: Int? = null,
    var dueDate: java.time.LocalDate? = null
)

class TodoList {
    val tasks = mutableListOf<Task>()

    fun addTask(title: String, description: String, category: String? = null, priority: Int? = null, dueDate: LocalDate? = null) {
        val task = Task(title, description, category, priority, dueDate)
        tasks.add(task)
    }

    fun editTask(index: Int, title: String, description: String, category: String? = null, priority: Int? = null, dueDate: LocalDate? = null) {
        val task = tasks[index]
        task.title = title
        task.description = description
        task.category = category
        task.priority = priority
        task.dueDate = dueDate
    }
}

fun main() {
    val todoList = TodoList()
    todoList.addTask("Zakupy spożywcze", "Kupić chleb, mleko i jajka", "Zakupy", 1, LocalDate.now().plusDays(1))
    todoList.addTask("Przygotowanie prezentacji", "Przygotować prezentację na spotkanie", "Praca", 2, LocalDate.of(2024, 4, 20))

    // Wyświetlenie listy zadań przed edycją
    println("Lista zadań przed edycją:")
    todoList.tasks.forEachIndexed { index, task ->
        println("$index. ${task.title}")
    }

    // Edycja pierwszego zadania
    todoList.editTask(0, "Nowe zakupy spożywcze", "Kupić chleb, mleko, jajka i masło")

    // Wyświetlenie listy zadań po edycji
    println("\nLista zadań po edycji:")
    todoList.tasks.forEachIndexed { index, task ->
        println("$index. ${task.title}")
    }
}

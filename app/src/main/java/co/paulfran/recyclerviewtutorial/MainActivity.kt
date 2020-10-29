package co.paulfran.recyclerviewtutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create TodoList
        var todoList = mutableListOf(
            Todo("Have breakfast", false),
            Todo("Read Book", false),
            Todo("Walk dog", false),
            Todo("Work on algorythms", false),
            Todo("Call Ruben", false),
            Todo("Check email", false)
        )

        // Create Adapter
        val adapter = TodoAdapter(todoList)

        // Set adapter to RecyclerView
        rvTodo.adapter = adapter

        // Set LayoutManager to RecyclerView
        rvTodo.layoutManager = LinearLayoutManager(this)

        addItemBtn.setOnClickListener {
            val title = etTodo.text.toString()
            val todo = Todo(title, false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size - 1)
        }
    }
}
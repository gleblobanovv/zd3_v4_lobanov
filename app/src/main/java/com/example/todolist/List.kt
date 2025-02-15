package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView

class List : AppCompatActivity() {
    private lateinit var listContainer: LinearLayout
    private val items = ArrayList<String>() // Список для хранения элементов
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        listContainer = findViewById(R.id.listContainer)

        // Получаем текст из Intent
        val itemText = intent.getStringExtra("ITEM_TEXT")

        // Если текст не пустой, добавляем его в список
        itemText?.let {
            items.add(0, it) // Добавляем новый элемент в начало списка
            updateList()
        }
    }

    private fun updateList() {
        listContainer.removeAllViews() // Очищаем контейнер перед обновлением
        for (item in items) {
            val textView = TextView(this)
            textView.text = item
            textView.setTextColor(resources.getColor(android.R.color.white))
            textView.textSize = 18f
            listContainer.addView(textView)
        }
    }
}
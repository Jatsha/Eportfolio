package com.example.livedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var listAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listAdapter = ListAdapter(mutableListOf())

        rvList.adapter = listAdapter
        rvList.layoutManager = LinearLayoutManager(this)

        btnAdd.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.dialogaddnew, null)
            val editText = dialogLayout.findViewById<EditText>(R.id.etDialog)
            with (builder) {
                setTitle("Enter Text!")
                val positiveButton = setPositiveButton("Ok") { dialog, which ->
                    val itemname = editText.text.toString()
                    val item = Item(itemname)
                    listAdapter.addItem(item)
                }

                setView(dialogLayout)
                show()
            }
        }

        btnDelete.setOnClickListener {
            listAdapter.deleteFinishedItem()
        }
    }
}
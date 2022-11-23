package com.example.planner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_create_card.*
import kotlinx.android.synthetic.main.activity_create_card.create_priority
import kotlinx.android.synthetic.main.activity_create_card.create_title
import kotlinx.android.synthetic.main.activity_update_card.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UpdateCard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val database: myDatabase by lazy{
            myDatabase.getDatabase(this)
        }
        setContentView(R.layout.activity_update_card)

        val pos = intent.getIntExtra("id",-1)
        if(pos!=-1){
            val title = DataObject.getItem(pos).title
            val priority = DataObject.getItem(pos).priority
            create_title.setText(title)
            create_priority.setText(priority)

            delete_button.setOnClickListener {
                DataObject.deleteItem(pos)
                GlobalScope.launch {
                    database.dao().deleteTask(Entity(pos+1,create_title.text.toString(),create_priority.text.toString()))
                }
                myIntent()
            }

            update_button.setOnClickListener {
                DataObject.updateItem(pos,create_title.text.toString(),create_priority.text.toString())
                Toast.makeText(this,"Task Updated!",
                Toast.LENGTH_LONG).show()
                GlobalScope.launch {
                    database.dao().updateTask(Entity(pos+1,create_title.text.toString(),create_priority.text.toString()))
                }
                myIntent()
            }
        }
    }
    fun myIntent(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}


package com.example.planner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_create_card.*
import kotlinx.android.synthetic.main.activity_update_card.*
import kotlinx.android.synthetic.main.activity_update_card.create_priority
import kotlinx.android.synthetic.main.activity_update_card.create_title
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CreateCard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_card)

        //database object

        val database: myDatabase by lazy{
            myDatabase.getDatabase(this)
        }

        save_button.setOnClickListener {
            if(create_title.text.toString().trim{it <= ' '}.isNotEmpty() &&
                    create_priority.text.toString().trim { it <= ' ' }.isNotEmpty()){
                var title = create_title.text.toString()
                var priority = create_priority.text.toString()
                DataObject.setData(title,priority)
                GlobalScope.launch {
                    database.dao().inserttask(Entity(0,title, priority))
                }
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else{
                Toast.makeText(this,"Fill all fields",Toast.LENGTH_LONG).show()
            }
        }
    }
}
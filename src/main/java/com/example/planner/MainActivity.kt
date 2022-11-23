package com.example.planner

import android.content.Intent
import android.os.Bundle
import android.widget.Adapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        add.setOnClickListener{
            val intent = Intent(this,CreateCard::class.java)
            startActivity(intent)
        }

        deleteAll.setOnClickListener{
            if(DataObject.size()!=0){
                DataObject.deleteAll()
                setRecyclerView()
            } else{
                Toast.makeText(this, "Nothing to delete",Toast.LENGTH_LONG).show()
            }

        }

        setRecyclerView()

    }
    fun setRecyclerView(){
        recycler_view.adapter = ItemAdapter(DataObject.getAllData())
        recycler_view.layoutManager = LinearLayoutManager(this)
    }
}
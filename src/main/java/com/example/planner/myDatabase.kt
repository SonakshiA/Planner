package com.example.planner

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Entity::class], version = 1)
abstract class myDatabase: RoomDatabase() {
    abstract fun dao():DAO

    //singleton
    companion object{
        private var INSTANCE: myDatabase? = null
        fun getDatabase(context: Context) : myDatabase{
            return INSTANCE?: synchronized(this){
                val instance =  Room.databaseBuilder(context.applicationContext,myDatabase::class.java,"To_Do").fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
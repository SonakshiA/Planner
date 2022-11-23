package com.example.planner

import androidx.room.*

@Dao
interface DAO {
    @Insert
    suspend fun inserttask(entity: Entity)

    @Update
    suspend fun updateTask(entity: Entity)

    @Delete
    suspend fun deleteTask(entity: Entity)

    @Query("Delete from to_do")
    suspend fun deleteAll()

    @Query("Select title, priority from to_do")
    suspend fun getTasks():List<CardInfo>
}
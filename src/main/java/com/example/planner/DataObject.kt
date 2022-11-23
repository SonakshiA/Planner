package com.example.planner

object DataObject {
    var listdata = mutableListOf<CardInfo>()

    fun setData(title: String, priority: String){
        listdata.add(CardInfo(title,priority))
    }

    fun getAllData():List<CardInfo>{
        return listdata
    }

    fun deleteAll(){
        listdata.clear()
    }

    fun getItem(pos:Int) : CardInfo{
        return listdata[pos]
    }

    fun deleteItem(pos:Int){
        listdata.removeAt(pos)
    }

    fun updateItem(pos: Int, title: String, priority: String){
        listdata[pos].title = title
        listdata[pos].priority = priority
    }

    fun size():Int{
        return listdata.size
    }
}
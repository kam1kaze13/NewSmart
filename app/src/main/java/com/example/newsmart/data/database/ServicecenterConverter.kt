package com.example.newsmart.data.database

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.newsmart.domain.model.Review
import com.example.newsmart.domain.model.ServiceCenter

@ProvidedTypeConverter
class ServicecenterConverter {

    @TypeConverter
    fun servicecenterToString(list: List<ServiceCenter>): String{
        var str= ""
        for (value in list)
        {
            str+= value.address.toString()+","+value.workTime+"///"
        }
        return str
    }

    @TypeConverter
    fun StringToServicecenter(value: String): List<ServiceCenter>{
        val arr = value.split("///")
        val list = mutableListOf<ServiceCenter>()
        for (elem in arr){
            val array = elem.split(",")
            list.add(ServiceCenter(address = array[0], workTime = array[1]))
        }
        return list
    }
}
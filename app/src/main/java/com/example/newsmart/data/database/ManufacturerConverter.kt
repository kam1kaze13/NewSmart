package com.example.newsmart.data.database

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.newsmart.domain.model.Manufacturer

@ProvidedTypeConverter
class ManufacturerConverter {

    @TypeConverter
    fun manufacturerToString(value: Manufacturer): String {
        return value.name+","+value.fullName+","+value.address+","+value.coverResId.toString()
    }

    @TypeConverter
    fun StringToManufacturer(value: String): Manufacturer{
        val array = value.split(",")
        return Manufacturer(name = array[0],fullName = array[1], address = array[2],coverResId = array[3].toInt())
    }
}
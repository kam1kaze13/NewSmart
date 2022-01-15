package com.example.newsmart.data.database

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.newsmart.domain.model.Specification

@ProvidedTypeConverter
class SpecificationConverter {

    @TypeConverter
    fun specificationToString(value: Specification): String {
        return value.warranty+","+value.color+","+value.operationSystem+","+value.display+","+value.processor+","+value.camera
    }

    @TypeConverter
    fun StringToSpecification(value: String): Specification {
        val array = value.split(",")
        return Specification(warranty = array[0],color = array[1], operationSystem = array[2],display = array[3],processor = array[4],camera = array[5])
    }
}
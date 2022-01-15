package com.example.newsmart.data.database

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.newsmart.domain.model.User
@ProvidedTypeConverter
class UserConverter {

    @TypeConverter
    fun userToString(value: User): String {
        return value.name+","+value.lastName+","+value.phone+","+value.email+","+value.address+","+value.coverResId.toString()
    }

    @TypeConverter
    fun StringToUser(value: String): User{
        val array = value.split(",")
        return User(name = array[0],lastName = array[1], phone = array[3], email = array[4],address = array[5], coverResId = array[6].toInt())
    }
}
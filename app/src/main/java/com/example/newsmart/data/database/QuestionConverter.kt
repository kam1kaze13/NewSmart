package com.example.newsmart.data.database

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.newsmart.domain.model.Question
import com.example.newsmart.domain.model.Review
import com.example.newsmart.domain.model.User

@ProvidedTypeConverter
class QuestionConverter {

    @TypeConverter
    fun questionToString(list: List<Question>): String{
        var str= ""
        for (value in list)
        {
            str+= userToString(value.user)+","+value.date+","+value.question+","+value.coverResId.toString()+"///"
        }
        return str
    }

    private fun userToString(value: User): String {
        return value.name+","+value.lastName+","+value.phone+","+value.email+","+value.address+","+value.coverResId.toString()
    }

    @TypeConverter
    fun StringToQuestion(value: String): List<Question>{
        val arr = value.split("///")
        val list = mutableListOf<Question>()
        for (elem in arr){
            val array = elem.split(",")
            list.add(Question(user = stringToUser(array[0]),date = array[1], question = array[2],coverResId = array[3].toInt()))
        }
        return list
    }

    private fun stringToUser(s: String): User {
        val array = s.split(",")
        return User(name = array[0],lastName = array[1], phone = array[3], email = array[4],address = array[5], coverResId = array[6].toInt())
    }
}
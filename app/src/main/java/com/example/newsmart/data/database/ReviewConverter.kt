package com.example.newsmart.data.database

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.newsmart.domain.model.Review
import com.example.newsmart.domain.model.User

@ProvidedTypeConverter
class ReviewConverter {

    @TypeConverter
    fun reviewToString(list: List<Review>): String{
        var str= ""
        for (value in list)
        {
            str+= value.rating.toString()+","+value.date+","+userToString(value.user)+","+value.advantages+","+value.limitations+"///"
        }
        return str
    }

    private fun userToString(value: User): String {
        return value.name+","+value.lastName+","+value.phone+","+value.email+","+value.address+","+value.coverResId.toString()
    }

    @TypeConverter
    fun StringToReview(value: String): List<Review>{
        val arr = value.split("///")
        val list = mutableListOf<Review>()
        for (elem in arr){
            val array = elem.split(",")
            list.add(Review(rating = array[0].toDouble(), date = array[1], user = stringToUser(array[2]),advantages = array[3], limitations = array[4]))
        }
        return list
    }

    private fun stringToUser(s: String): User {
        val array = s.split(",")
        return User(name = array[0],lastName = array[1], phone = array[3], email = array[4],address = array[5], coverResId = array[6].toInt())
    }

}
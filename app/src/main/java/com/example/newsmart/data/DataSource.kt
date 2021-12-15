package com.example.newsmart.data

import android.provider.ContactsContract
import com.example.newsmart.model.*

object DataSource {
    val manufacturers = listOf(
    Manufacturer("Samsung", "Samsung", "China",1),
    Manufacturer("Apple", "Apple", "USA",2),
    Manufacturer("Xiaomi", "Xiaomi", "China",3),
    Manufacturer("Honor", "Honor", "China",4),
    Manufacturer("Huawei", "Huawei", "China",5)
    )

    val specification1 = Specification("1 year", "black", "Android", "IPS", "A15","50 mp")

    val user1 = User("Ivan", "Ivanov", "1111", "email@email.com", "234",1)

    val reviews = listOf(
        Review(5.0, "01.09.2021", user1, "+", "-"),
        Review(4.5, "01.09.2021", user1, "+", "-")
    )

    val serviceCenters = listOf(
        ServiceCenter("123", "5+546"),
        ServiceCenter("232", "5+asdaf")
    )

    val questions = listOf(
        Question(user1, "01.10.2021", "sdasda", user1.coverResId),
        Question(user1, "01.10.2021", "sdasdaasda",user1.coverResId)
    )

    val phones = listOf(
        Smartphone(manufacturers[1],"S20 Ultra",20000.0, specification1, reviews, serviceCenters, questions,1),
        Smartphone(manufacturers[2],"12",100000.0, specification1, reviews, serviceCenters, questions,2),
        Smartphone(manufacturers[2],"13",80000.0, specification1, reviews, serviceCenters, questions,3),
        Smartphone(manufacturers[3],"Note 9",40000.0, specification1, reviews, serviceCenters, questions,4),
        Smartphone(manufacturers[3],"Note 8",30000.0, specification1, reviews, serviceCenters, questions,5),
        Smartphone(manufacturers[4],"10",40000.0, specification1, reviews, serviceCenters, questions,6),
        Smartphone(manufacturers[4],"8",35000.0, specification1, reviews, serviceCenters, questions,7),
        Smartphone(manufacturers[5],"p20",20000.0, specification1, reviews, serviceCenters, questions,8),
        Smartphone(manufacturers[2],"p40",30000.0, specification1, reviews, serviceCenters, questions,9),
        Smartphone(manufacturers[3],"Note 10",50000.0, specification1, reviews, serviceCenters, questions,10)
    )
}
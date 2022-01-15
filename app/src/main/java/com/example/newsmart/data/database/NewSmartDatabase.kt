package com.example.newsmart.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.newsmart.domain.model.*

@Database(
    entities = [Smartphone::class, Manufacturer::class, Question::class, Review::class, ServiceCenter::class, Specification::class, User::class],
    version = 1
)
@TypeConverters(UserConverter::class, ReviewConverter::class, ManufacturerConverter::class,SpecificationConverter::class,ServicecenterConverter::class,QuestionConverter::class)
abstract class NewSmartDatabase : RoomDatabase() {
    abstract fun phoneDao() : PhoneDao
    abstract fun manufacturerDao(): ManufacturerDao
    abstract fun questionDao(): QuestionDao
    abstract fun reviewDao(): ReviewDao
    abstract fun serviceCenterDao(): ServiceCentresDao
    abstract fun specificationDao(): SpecificationDao
    abstract fun userDao(): UserDao
}
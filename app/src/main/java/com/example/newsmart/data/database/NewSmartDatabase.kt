package com.example.newsmart.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newsmart.domain.model.Smartphone

@Database(
    entities = [Smartphone::class],
    version = 1
)
abstract class NewSmartDatabase : RoomDatabase() {
    abstract fun phoneDao() : PhoneDao
    abstract fun manufacturerDao(): ManufacturerDao
    abstract fun questionDao(): QuestionDao
    abstract fun reviewDao(): ReviewDao
    abstract fun serviceCenterDao(): ServiceCentresDao
    abstract fun specificationDao(): SpecificationDao
    abstract fun userDao(): UserDao
}
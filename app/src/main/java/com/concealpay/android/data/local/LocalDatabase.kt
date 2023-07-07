package com.concealpay.android.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.concealpay.android.data.local.model.UserTable

@Database(entities = [UserTable::class], version = 11)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        val DATABASE_NAME: String = "conceal_pay_db"
    }

}
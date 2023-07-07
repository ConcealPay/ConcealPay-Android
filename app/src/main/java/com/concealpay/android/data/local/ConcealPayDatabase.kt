package com.concealpay.android.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.concealpay.android.data.local.model.UserTable


@Database(entities = [UserTable::class,], version = 1)
abstract class ConcealPayDatabase : RoomDatabase() {

    abstract fun userModelDao(): UserDao

}
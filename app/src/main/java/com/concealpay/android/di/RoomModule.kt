package com.concealpay.android.di

import android.content.Context
import androidx.room.Room
import com.concealpay.android.data.local.LocalDatabase
import com.concealpay.android.data.local.UserDao
import com.concealpay.android.util.SharedPrefFunctions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideLocalDatabase(@ApplicationContext context: Context): LocalDatabase =
        Room.databaseBuilder(
            context,
            LocalDatabase::class.java,
            LocalDatabase.DATABASE_NAME
        ).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideLocalDao(localDatabase: LocalDatabase): UserDao =
        localDatabase.userDao()

    @Singleton
    @Provides
    fun providesUserFunctions(@ApplicationContext context: Context): SharedPrefFunctions {
        return SharedPrefFunctions(context)
    }
}
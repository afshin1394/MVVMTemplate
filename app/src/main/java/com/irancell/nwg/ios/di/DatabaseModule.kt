package com.irancell.nwg.ios.di

import android.content.Context
import androidx.room.Room

import com.irancell.nwg.ios.database.DataBase
import com.irancell.nwg.ios.database.dao.AuditDao
import com.irancell.nwg.ios.database.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): DataBase {
        return Room.databaseBuilder(
            appContext,
            DataBase::class.java,
            "IOS"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideChannelDao(usersDatabase: DataBase): UserDao {
        return usersDatabase.usersDao
    }

    @Provides
    fun provideAuditDao(auditDatabase: DataBase): AuditDao {
        return auditDatabase.auditDao
    }

}
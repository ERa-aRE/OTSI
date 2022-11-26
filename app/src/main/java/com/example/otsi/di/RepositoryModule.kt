package com.example.otsi.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.example.otsi.data.repository.DataStoreOperationsImpl
import com.example.otsi.data.repository.RepositoryImpl
import com.example.otsi.domain.repository.DataStoreOperations
import com.example.otsi.domain.repository.Repository
import com.example.otsi.util.Constants.PREFERENCES_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Provides
    @Singleton
    fun provideDataStorePreference(
        @ApplicationContext context:Context
    ):DataStore<Preferences>{
        return PreferenceDataStoreFactory.create (
            produceFile = {context.preferencesDataStoreFile(PREFERENCES_NAME)}
                )
    }

    @Provides
    @Singleton
    fun provideDataStoreOperations(
        dataStore: DataStore<Preferences>
    ):DataStoreOperations{
        return DataStoreOperationsImpl(dataStore=dataStore)
    }

    @Provides
    @Singleton
    fun provideRepository(
        dataStoreOperations: DataStoreOperations
    ):Repository{
        return RepositoryImpl(dataStoreOperations =dataStoreOperations )
    }



}
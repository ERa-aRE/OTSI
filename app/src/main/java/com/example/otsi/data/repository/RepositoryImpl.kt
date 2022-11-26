package com.example.otsi.data.repository

import com.example.otsi.domain.repository.DataStoreOperations
import com.example.otsi.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val dataStoreOperations : DataStoreOperations
):Repository {
    override suspend fun savedSignedInState(signIn: Boolean) {
        return dataStoreOperations.saveSignedInState(signedIn = signIn)
    }

    override fun readSignedInState(): Flow<Boolean> {
        return dataStoreOperations.readSignedInState()
    }
}
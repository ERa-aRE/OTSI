package com.example.otsi.domain.repository

import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun savedSignedInState(signIn:Boolean)
    fun readSignedInState():Flow<Boolean>
}
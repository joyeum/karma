package com.oyoyoy.domain.repository

import kotlinx.coroutines.flow.Flow

interface CursePeopleRepository {
    suspend fun emitSample(request : String) : Flow<Result<String>>
}
package com.oyoyoy.domain.usecase

import com.oyoyoy.domain.repository.CursePeopleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetCursePeopleUseCase(private val cursePeopleRepository : CursePeopleRepository)
    : UseCase<GetCursePeopleUseCase.Input, GetCursePeopleUseCase.Output>() {
    class Input(val request : String):UseCase.Input {

    }

    class Output(val input : String):UseCase.Output {

    }

    override suspend fun invoke(data: GetCursePeopleUseCase.Input)
    : Flow<Result<GetCursePeopleUseCase.Output>> {
        return cursePeopleRepository.emitSample("test").map{ it.map { test -> Output(test)}}
    }

}
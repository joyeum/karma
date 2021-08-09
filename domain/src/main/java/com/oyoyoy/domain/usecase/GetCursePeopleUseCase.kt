package com.oyoyoy.domain.usecase

import com.oyoyoy.domain.repository.GetCursePeopleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
/*
class GetCursePeopleUseCase(private val getCursePeopleRepository : GetCursePeopleRepository)
    : UseCase<GetCursePeopleUseCase.Input, GetCursePeopleUseCase.Output>() {
    class Input(val request : String):UseCase.Input {

    }

    class Output(val input : String) : UseCase.Output {

    }

    override suspend fun invoke(data: GetCursePeopleUseCase.Input)
    : Flow<Result<GetCursePeopleUseCase.Output>> {
        return getCursePeopleRepository().allPeople().map{ it.map { test -> Output(test)}}
    }

}
*/
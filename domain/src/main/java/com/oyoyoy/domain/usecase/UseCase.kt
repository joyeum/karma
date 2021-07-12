package com.oyoyoy.domain.usecase


import kotlinx.coroutines.flow.Flow

abstract class UseCase<P: UseCase.Input, R: UseCase.Output> {
    protected val TAG = javaClass.name

    abstract suspend operator fun invoke(data: P): Flow<Result<R>>

    interface Input{

    }

    interface Output{

    }
}
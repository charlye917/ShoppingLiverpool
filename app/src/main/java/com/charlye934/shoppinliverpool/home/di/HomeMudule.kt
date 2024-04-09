package com.charlye934.shoppinliverpool.home.di

import com.charlye934.shoppinliverpool.home.data.repository.HomeRepository
import com.charlye934.shoppinliverpool.home.data.repository.HomeRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeMudule {

    @Binds
    abstract fun HomeRepositoryModule(homeRepositoryImp: HomeRepositoryImp): HomeRepository
}
package com.charlye934.shoppinliverpool.home.data.repository

import com.charlye934.shoppinliverpool.home.data.model.response.DataShoppingResponse
import com.charlye934.shoppinliverpool.network.Resources
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getShoppingInfo(
        page: Int?,
        search: String?,
        order: String?,
        forzarPlp: Boolean,
        numberProducts: Int,
        clearName: Boolean
    ): Flow<Resources<DataShoppingResponse>>
}
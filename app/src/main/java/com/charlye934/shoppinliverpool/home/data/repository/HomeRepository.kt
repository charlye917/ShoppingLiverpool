package com.charlye934.shoppinliverpool.home.data.repository

import com.charlye934.shoppinliverpool.home.data.model.response.DataShoppingResponse
import com.charlye934.shoppinliverpool.network.Resources
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getShoppingInfo(
        page: Int? = 0,
        search: String = "",
        order: String = "",
        forzarPlp: Boolean = false,
        numberProducts: Int = 40,
        clearName: String? = ""
    ): Flow<Resources<DataShoppingResponse>>
}
package com.charlye934.shoppinliverpool.home.data.service

import com.charlye934.shoppinliverpool.home.data.model.response.DataShoppingResponse
import com.charlye934.shoppinliverpool.util.constants.ConstantsServices.SERVICE_GET_PRODUCTS
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeService {

    @GET(SERVICE_GET_PRODUCTS)
    suspend fun getProducctsShopping(
        @Query("page-number") page: Int?,
        @Query("search-string") search: String?,
        @Query("sort-option") order: String?,
        @Query("force-plp") forzarPlp: Boolean = false,
        @Query("number-of-items-per-page") numberProducts: Int?,
        @Query("cleanProductName")  clearName: String?
    ): Response<DataShoppingResponse>
}
package com.charlye934.shoppinliverpool.home.presenter.viewmodel.dataproducts

import androidx.lifecycle.LiveData
import com.charlye934.shoppinliverpool.home.domain.model.ProductCardUI

interface DataProductsViewModelDelegate {
    val loading: LiveData<Boolean>
    val isErrorData: LiveData<Boolean>
    val numPage: LiveData<Int>
    val listDataProducts: LiveData<List<ProductCardUI>>

    suspend fun getListProductsDelegate(
        page: Int?,
        search: String?,
        order: String?,
        forzarPlp: Boolean,
        numberProducts: Int,
        clearName: Boolean,
        clearData: Boolean = false
    )

    suspend fun updateCounter(needUpdate: Boolean = true)
}
package com.charlye934.shoppinliverpool.home.presenter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.charlye934.shoppinliverpool.home.presenter.viewmodel.dataproducts.DataProductsViewModelDelegate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dataProductsViewModelDelegate: DataProductsViewModelDelegate
) : ViewModel(),
    DataProductsViewModelDelegate by dataProductsViewModelDelegate {

    fun getDataProducts(
        page: Int?,
        search: String? = null,
        order: String? = null,
        forzarPlp: Boolean = false,
        numberProducts: Int = 40,
        clearName: Boolean = false,
        clearData: Boolean = false
    ){
        viewModelScope.launch {
            getListProductsDelegate(
                page,
                search,
                order,
                forzarPlp,
                numberProducts,
                clearName,
                clearData
            )
        }
    }

    fun updatePage(needUpdate: Boolean){
        viewModelScope.launch {
            updateCounter(needUpdate)
        }
    }
}
package com.charlye934.shoppinliverpool.home.domain.usecae

import com.charlye934.shoppinliverpool.home.data.repository.HomeRepository
import com.charlye934.shoppinliverpool.home.domain.mapper.responseDataAsProductUI
import com.charlye934.shoppinliverpool.home.domain.model.ProductCardUI
import com.charlye934.shoppinliverpool.network.BaseError
import com.charlye934.shoppinliverpool.network.Resources
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductInfoUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    suspend operator fun invoke(
        page: Int?,
        search: String?,
        order: String?,
        forzarPlp: Boolean,
        numberProducts: Int,
        clearName: Boolean
    ) : Flow<Resources<List<ProductCardUI>>> = flow {
        homeRepository.getShoppingInfo(page, search, order, forzarPlp, numberProducts, clearName)
            .catch { e -> e.printStackTrace() }
            .collect{ state ->
                when(state) {
                    is Resources.Loading -> {
                        emit(Resources.Loading)
                    }

                    is Resources.Success -> {
                        emit(Resources.Success(data = responseDataAsProductUI(state.data)))
                    }

                    else -> {
                        val error = state as Resources.Error
                        emit(Resources.Error(BaseError(message = error.error.message)))
                    }
                }
            }
    }
}
package com.apps.therapassignment.ui.productlist

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.apps.therapassignment.database.ProductDao
import com.apps.therapassignment.database.ProductDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductListPagingSource(

    private val dao: ProductDao) : PagingSource<Int, ProductDatabaseModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ProductDatabaseModel> {
        val page = params.key ?: 0

        return try {
            withContext(Dispatchers.IO){
                val entities = dao.getUsers(params.loadSize, page * params.loadSize)
                LoadResult.Page(
                    data = entities,
                    prevKey = if (page == 0) null else page - 1,
                    nextKey = if (entities.isEmpty()) null else page + 1
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ProductDatabaseModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    companion object{
        const val PAGE_SIZE = 5
        const val INITIAL_LOAD_SIZE = 5 * 2
    }
}

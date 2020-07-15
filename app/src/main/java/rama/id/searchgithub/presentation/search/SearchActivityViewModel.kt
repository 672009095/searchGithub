package rama.id.searchgithub.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import rama.id.searchgithub.domain.common.UseCaseConstant
import rama.id.searchgithub.domain.common.entity.Either
import rama.id.searchgithub.domain.common.entity.Pagination
import rama.id.searchgithub.domain.search.Search
import rama.id.searchgithub.domain.search.usecase.GetListOfSearchUseCase
import rama.id.searchgithub.domain.search.usecase.GetListOfSearchWithPageUseCase
import rama.id.searchgithub.presentation.common.ResultData
import rama.id.searchgithub.presentation.common.base.BaseViewModel
import rama.id.searchgithub.presentation.common.widget.paged.PagedFactory
import rama.id.searchgithub.presentation.common.widget.paged.PagedState

class SearchActivityViewModel(
    private val q:String?,
    private val getListOfSearchUseCase: GetListOfSearchUseCase,
    private val getListOfSearchWithPageUseCase: GetListOfSearchWithPageUseCase
) : BaseViewModel(){

    private val itemsMutable = MutableLiveData<ResultData<List<Search>>>()
    val items: LiveData<ResultData<List<Search>>> = itemsMutable

    private val factory = PagedFactory(::getLisOfSearchWithPage)
    private val pagedListConfig = PagedList.Config.Builder()
        .setEnablePlaceholders(false)
        .setInitialLoadSizeHint(1)
        .setPageSize(10)
        .build()

    val searches = (LivePagedListBuilder(factory,pagedListConfig)).build()
    val searchesState: LiveData<PagedState> = factory.pagedState

    suspend fun getListOfSearch(q: String?){
        val params = mapOf(
            UseCaseConstant.q to q
        )
        getListOfSearchUseCase.addParams(params)
            .invoke()
            .toResult()
            .run(itemsMutable::postValue)
    }

    suspend fun getLisOfSearchWithPage(page: Int?):
            Either<Throwable, List<Search>>{
        val params = mapOf(
            UseCaseConstant.q to "pikachu",
            UseCaseConstant.PAGINATION to Pagination(10,page?:1)
        )
        return getListOfSearchWithPageUseCase.addParams(params)
            .invoke(viewModelScope.coroutineContext)
    }
}
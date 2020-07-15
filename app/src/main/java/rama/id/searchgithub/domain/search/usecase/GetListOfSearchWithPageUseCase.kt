package rama.id.searchgithub.domain.search.usecase

import rama.id.searchgithub.domain.common.UseCaseConstant
import rama.id.searchgithub.domain.common.base.BaseUseCase
import rama.id.searchgithub.domain.common.entity.Pagination
import rama.id.searchgithub.domain.search.Search
import rama.id.searchgithub.domain.search.SearchRepository

/**
 * use case with pagination
 */
class GetListOfSearchWithPageUseCase(private val repository: SearchRepository) :
    BaseUseCase<List<Search>>(){

    override suspend fun build(params: Map<String, Any?>) = repository.getListOfSearchWithPage(
        params[UseCaseConstant.q] as String?,
        params[UseCaseConstant.PAGINATION] as Pagination
    )

}
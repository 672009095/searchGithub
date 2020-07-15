package rama.id.searchgithub.domain.search.usecase

import rama.id.searchgithub.domain.common.UseCaseConstant
import rama.id.searchgithub.domain.common.base.BaseUseCase
import rama.id.searchgithub.domain.search.Search
import rama.id.searchgithub.domain.search.SearchRepository

/**
 * search without limit pagination use case
 */
class GetListOfSearchUseCase(private val repository: SearchRepository) :
    BaseUseCase<List<Search>>(){

    override suspend fun build(params: Map<String, Any?>) = repository.getListOfSearch(
        params[UseCaseConstant.q] as String?
    )

}
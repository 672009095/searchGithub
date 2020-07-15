package rama.id.searchgithub.data.search

import rama.id.searchgithub.data.search.cloud.SearchApi
import rama.id.searchgithub.domain.common.entity.Pagination
import rama.id.searchgithub.domain.search.Search
import rama.id.searchgithub.domain.search.SearchRepository

class SearchDataRepository (private val searchApi: SearchApi) : SearchRepository {
    override suspend fun getListOfSearch(q:String?): List<Search> =
        searchApi.getListOfSearch(q).getOrThrow().map(::transform)

    override suspend fun getListOfSearchWithPage(
        q:String?,
        pagination: Pagination
    ):List<Search> = searchApi.getListOfSearchWithPage(
        q,
        pagination.page,
        pagination.per_page).getOrThrow().map (::transform)
}
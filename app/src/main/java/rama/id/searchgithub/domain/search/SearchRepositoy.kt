package rama.id.searchgithub.domain.search

import rama.id.searchgithub.domain.common.entity.Pagination

interface SearchRepository {
    suspend fun getListOfSearch(q: String?): List<Search>
    suspend fun getListOfSearchWithPage(q: String?, pagination: Pagination): List<Search>
}
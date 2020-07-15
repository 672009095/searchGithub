package rama.id.searchgithub.data.search

import rama.id.searchgithub.data.search.cloud.response.SearchResponse
import rama.id.searchgithub.domain.search.Search

/**
 * transform mapper u can sorting wich u wont to use from response model
 * and use the only what u want to use
 */
fun transform (value: SearchResponse) = Search(
    value.login ?:throw NoSuchElementException("Require value login"),
    value.id ?:throw NoSuchElementException("Require value id"),
    value.avatar_url ?:throw NoSuchElementException("Require value avatar_url")
)
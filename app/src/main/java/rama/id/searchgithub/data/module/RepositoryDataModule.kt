package rama.id.searchgithub.data.module

import rama.id.searchgithub.data.search.SearchDataRepository
import rama.id.searchgithub.domain.search.SearchRepository
import org.koin.dsl.module
import org.koin.experimental.builder.factoryBy

/**
 * module for grouping data repository
 */
val repositoryDataModule = module {
    factoryBy<SearchRepository,SearchDataRepository>()
}
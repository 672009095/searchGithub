package rama.id.searchgithub.domain.module

import rama.id.searchgithub.domain.search.usecase.GetListOfSearchUseCase
import rama.id.searchgithub.domain.search.usecase.GetListOfSearchWithPageUseCase
import org.koin.dsl.module
import org.koin.experimental.builder.factory

/**
 * modul for grouping use case
 */
val useCaseModule = module {
    factory<GetListOfSearchUseCase>()
    factory<GetListOfSearchWithPageUseCase>()
}
package rama.id.searchgithub.presentation.module

import rama.id.searchgithub.domain.common.UseCaseConstant.q
import rama.id.searchgithub.presentation.main.MainActivityViewModel
import rama.id.searchgithub.presentation.search.SearchActivityViewModel
import rama.id.searchgithub.presentation.search.list.SearchListViewModel
import org.koin.androidx.experimental.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel<MainActivityViewModel>()
    //viewModel<SearchActivityViewModel>()
    viewModel{(q:String) -> SearchActivityViewModel(q,get(),get())}
    viewModel{(q:String) -> SearchListViewModel(q,get(),get())}
}
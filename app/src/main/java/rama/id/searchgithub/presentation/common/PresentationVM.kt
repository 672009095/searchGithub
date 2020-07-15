package rama.id.searchgithub.presentation.common

import rama.id.searchgithub.presentation.common.base.BaseViewModel

interface PresentationVM<VM : BaseViewModel> {
    val viewModel: VM
}
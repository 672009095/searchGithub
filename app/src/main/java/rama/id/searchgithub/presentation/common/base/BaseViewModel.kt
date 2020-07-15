package rama.id.searchgithub.presentation.common.base

import androidx.lifecycle.ViewModel
import rama.id.searchgithub.domain.common.entity.Either
import rama.id.searchgithub.presentation.common.ResultData
import org.koin.core.KoinComponent

/**
 * base for view model
 */
abstract class BaseViewModel : ViewModel(), KoinComponent {
    protected fun <T> Either<Throwable, T>.toResult() = when (this) {
        is Either.Error -> ResultData.Failure(this.error)
        is Either.Value -> ResultData.Success(this.value)
    }
}
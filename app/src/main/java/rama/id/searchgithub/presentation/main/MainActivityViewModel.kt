package rama.id.searchgithub.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import rama.id.searchgithub.presentation.common.base.BaseViewModel
import rama.id.searchgithub.presentation.search.SearchActivity
import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit

class MainActivityViewModel: BaseViewModel() {
    private val nextClassToLaunchMutable = MutableLiveData<Class<*>>()
    val nextClassToLaunch: LiveData<Class<*>> = nextClassToLaunchMutable

    suspend fun delayToNextScreen() {
        delay(TimeUnit.SECONDS.toMillis(1))
        toSearchPage()
    }

    private suspend fun toSearchPage() {
        nextClassToLaunchMutable.postValue(SearchActivity::class.java)
    }
}
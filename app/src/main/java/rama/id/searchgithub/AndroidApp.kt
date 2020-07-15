package rama.id.searchgithub

import androidx.multidex.MultiDexApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import rama.id.searchgithub.data.module.apiModule
import rama.id.searchgithub.data.module.networkModule
import rama.id.searchgithub.data.module.repositoryDataModule
import rama.id.searchgithub.domain.module.useCaseModule
import rama.id.searchgithub.presentation.module.viewModelModule

@Suppress("unused")
class AndroidApp : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidLogger()
            androidContext(this@AndroidApp)
            modules(
                listOf(
                    apiModule,
                    useCaseModule,
                    networkModule,
                    repositoryDataModule,
                    viewModelModule
                )
            )
        }
    }
}
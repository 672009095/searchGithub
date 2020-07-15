package rama.id.searchgithub.presentation.main

import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import rama.id.searchgithub.R
import rama.id.searchgithub.presentation.common.base.BaseActivity
import rama.id.searchgithub.shared.extensions.startActivityClearTask
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {
    override val resourceLayout: Int? =
        R.layout.activity_main
    private val viewModel: MainActivityViewModel by viewModel()

    init {
        lifecycleScope.launchWhenStarted {
            viewModel.delayToNextScreen()
        }
    }

    override fun onInitObservers() {
        viewModel.nextClassToLaunch.observe(this, Observer {
            startActivityClearTask(Intent(this, it))
        })
    }
}
package rama.id.searchgithub.presentation.common.widget.recycler

import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import rama.id.searchgithub.R
import rama.id.searchgithub.presentation.common.widget.paged.PagedState
import rama.id.searchgithub.shared.extensions.inflate
import kotlinx.android.synthetic.main.item_loading.view.*

class DefaultFooterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val progressBar = itemView.progressBar


    fun onBind(item: PagedState) {
        when (item) {
            is PagedState.Loading -> {
                progressBar.isVisible = true
            }
            is PagedState.Failure -> {
                progressBar.isVisible = false
            }
        }
    }

    companion object {
        fun newInstance(parent: ViewGroup) =
            DefaultFooterHolder(
                parent.inflate(
                    R.layout.item_loading
                )
            )
    }
}
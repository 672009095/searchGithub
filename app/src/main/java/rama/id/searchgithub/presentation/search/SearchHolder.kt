package rama.id.searchgithub.presentation.search

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import rama.id.searchgithub.R
import rama.id.searchgithub.domain.search.Search
import rama.id.searchgithub.shared.extensions.inflate
import kotlinx.android.synthetic.main.search_item.view.*

class SearchHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private var item: Search? = null

    private val image = itemView.thumbnailImageView
    private val login = itemView.loginTextView

    private val options = RequestOptions()
        .placeholder(R.drawable.ic_launcher_foreground)
        .transform(CenterCrop(), RoundedCorners(16))

    fun onCreate(onItemClicked: (Search) -> Unit){
        itemView.setOnClickListener{item?.run(onItemClicked)}
    }

    fun onBind(item: Search) {
        this.item = item
        Glide.with(itemView)
            .load(item.avatar_url)
            .apply(options)
            .into(image)
        login.text = item.login
    }

    companion object {
        fun newInstance(parent: ViewGroup, onItemClicked: (Search) -> Unit) =
            SearchHolder(parent.inflate(R.layout.search_item)).apply {
                onCreate(onItemClicked)
            }
    }
}
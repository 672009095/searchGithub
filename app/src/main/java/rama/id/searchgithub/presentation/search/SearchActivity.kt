package rama.id.searchgithub.presentation.search

import android.widget.Toast
import androidx.fragment.app.replace
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import rama.id.searchgithub.R
import rama.id.searchgithub.domain.common.UseCaseConstant.q
import rama.id.searchgithub.presentation.common.ResultData
import rama.id.searchgithub.presentation.common.base.BaseActivity
import rama.id.searchgithub.presentation.search.list.SearchListAdapterPaged
import rama.id.searchgithub.presentation.search.list.SearchListFragment
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class SearchActivity : BaseActivity(){
    override val resourceLayout: Int = R.layout.activity_search
    private val viewModel: SearchActivityViewModel by inject { parametersOf(q)}
    private val searchListAdapter = SearchListAdapter(
        onItemClicked = {}
    )

    override fun onInitViews() {
        //super.onInitViews()
        with(recycleListSearch){
            layoutManager = LinearLayoutManager(context)
            adapter = searchListAdapter
        }
        searchView.onActionViewExpanded()
        searchView.clearFocus()
        searchView.setOnQueryTextListener(object:androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                //Toast.makeText(applicationContext, query, Toast.LENGTH_SHORT).show()
                lifecycleScope.launch{
                    //viewModel.getListOfSearch(query)
                    //viewModel.getLisOfSearchWithPage(1)
                    val manager = supportFragmentManager
                    val transaction = manager.beginTransaction()
                    if (query != null) {
                        transaction.replace(container.id,SearchListFragment.newInstance(query))
                        transaction.addToBackStack(null)
                        transaction.commit()
                    }else{
                        transaction.replace(container.id,SearchListFragment.newInstance(""))
                        transaction.addToBackStack(null)
                        transaction.commit()
                    }
                }
                return false
            }
        })
    }

    override fun onInitObservers() {
        viewModel.items.observe(this, Observer {
            when(it){
                is ResultData.Success -> it.data.run(searchListAdapter::addItems)
            }
        })
    }
}
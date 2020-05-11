package com.cr.myapplication.activity.newslist

import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.cr.myapplication.R
import com.cr.myapplication.adapter.NewsListAdatper
import com.cr.myapplication.base.BaseMVVMActivity
import com.cr.myapplication.databinding.ActivityNewsListBinding
import com.cr.myapplication.extension.viewModel
import com.cr.myapplication.route.RoutePath.Companion.newListAC
import com.cr.myapplication.vo.NewsListItemVO

@Route(path = newListAC)
class NewsListActivity : BaseMVVMActivity<ActivityNewsListBinding, NewsListVM>() {

    var adapter = NewsListAdatper()
    val vm by viewModel<NewsListVM>()
    override val layoutId: Int
        get() = R.layout.activity_news_list

    override fun initData() {
        binding.newslistVM = vm
        initRecyclerList()
    }

    fun initRecyclerList() {
        binding.recyclerView.also {
            it.adapter = adapter
            it.layoutManager = LinearLayoutManager(this)
        }
        var list = arrayListOf<NewsListItemVO>()
        list.add(NewsListItemVO("t", "1"))
        list.add(NewsListItemVO("ti", "2"))
        list.add(NewsListItemVO("tit", "3"))
        list.add(NewsListItemVO("tile4", "4"))
        adapter.addAll(list, true)
    }
}

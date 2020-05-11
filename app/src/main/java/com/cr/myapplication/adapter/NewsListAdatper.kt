package com.cr.myapplication.adapter

import com.cr.myapplication.R
import com.cr.myapplication.adapter.base.DataBoundBaseAdapter
import com.cr.myapplication.databinding.ItemNewsListBinding
import com.cr.myapplication.vo.NewsListItemVO

class NewsListAdatper : DataBoundBaseAdapter<NewsListItemVO, ItemNewsListBinding>() {
    override val layoutId: Int
        get() = R.layout.item_news_list

    override fun initView(binding: ItemNewsListBinding, item: NewsListItemVO) {
        binding.newsItemVm = item

    }
}
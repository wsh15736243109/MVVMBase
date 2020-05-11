package com.cr.myapplication.vo

data class NewsListItemVO(var title: String, var content: String) {
    fun getTheTitle(): String {
        return when (title.length) {
            1 -> "第一"
            2 -> "第二"
            3 -> "第三"
            4 -> "第四"
            else -> "未知"
        }
    }

    fun getTheContent(): String {
        return when (content) {
            "1" -> {
                "嗯"
            }
            else -> {
                "额"
            }
        }
    }
}
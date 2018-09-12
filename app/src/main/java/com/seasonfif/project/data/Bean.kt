package com.seasonfif.project.data


data class Bean(
        val date : String,
        val stories : List<Story>
)

data class Story (
        val id : String,
        val type : Int,
        val images : List<String>,
        val title : String
)

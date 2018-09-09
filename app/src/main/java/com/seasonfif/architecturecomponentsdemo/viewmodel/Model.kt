package com.seasonfif.architecturecomponentsdemo.viewmodel

data class Model(
    val error: Boolean,
    val results: List<Result>
)

data class Result(
    val _id: String,
    val en_name: String,
    val name: String,
    val rank: Int
)
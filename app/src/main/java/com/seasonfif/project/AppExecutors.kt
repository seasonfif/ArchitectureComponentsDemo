package com.seasonfif.project

import java.util.concurrent.Executors

private val IO_EXECUTOR = Executors.newSingleThreadExecutor()

fun runOnIoThread(task : ()-> Unit){
    IO_EXECUTOR.execute(task)
}
package com.seasonfif.project.data

import android.arch.persistence.room.*
import com.seasonfif.project.room.RoomConst
import com.seasonfif.project.room.StringListConvert

@Entity(tableName = RoomConst.TABLE_NAME)
@TypeConverters(StringListConvert::class)
data class Story(
        @PrimaryKey
        @ColumnInfo(name = "id") var id : String = "",

        @Ignore
        var type : Int = 0,

        @ColumnInfo(name = "images")
        var images : List<String> = ArrayList(),

        @ColumnInfo(name = "title")
        var title : String = "",

        @ColumnInfo(name = "date")
        var date : String = ""
)
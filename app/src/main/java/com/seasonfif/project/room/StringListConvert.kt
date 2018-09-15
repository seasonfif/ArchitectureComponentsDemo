package com.seasonfif.project.room

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class StringListConvert {

    @TypeConverter
    open fun fromList(list: List<String>) : String{
        return Gson().toJson(list)
    }

    @TypeConverter
    open fun fromString(json : String) : List<String>{
        val listType : Type = object : TypeToken<List<String>>(){}.type
        return Gson().fromJson(json, listType)
    }
}
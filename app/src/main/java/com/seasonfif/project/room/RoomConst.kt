package com.seasonfif.project.room

object RoomConst {

    const val DB_NAME : String = "story.db"

    const val DATABASE_VERSION = 1

    const val TABLE_NAME : String = "tb_story"

    const val QUERY : String = "SELECT * FROM $TABLE_NAME WHERE date = :date"

}
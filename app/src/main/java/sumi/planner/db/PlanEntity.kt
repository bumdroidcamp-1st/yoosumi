package sumi.planner.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plan_table")
data class PlanEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "planId")
    var planId: Int = 0,

    @ColumnInfo(name = "planContents")
    val planContents: String
)
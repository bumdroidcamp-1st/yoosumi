package sumi.planner.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PlanDao {
    @Insert
    fun insert(PlanEntity: PlanEntity)

    @Query("SELECT * FROM plan_table")
    fun getAllPlans(): LiveData<List<PlanEntity>>

}
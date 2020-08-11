package sumi.planner.db

import android.content.Context
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PlanEntity::class], version = 1)
abstract class PlanDatabase : RoomDatabase() {
    abstract val dao: PlanDao

    companion object {
        private var INSTANCE: PlanDatabase? = null
        fun getInstance(context: Context): PlanDatabase {

            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        PlanDatabase::class.java,
                        "plan_database")
                        .build()
                }
                return INSTANCE as PlanDatabase
            }
        }
    }
}
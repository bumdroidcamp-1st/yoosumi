package sumi.planner.calendar

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import sumi.planner.db.PlanDao
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(private val planDao: PlanDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        Log.i("ViewModel","Button Click")
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(planDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
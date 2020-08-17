package sumi.planner.calendar

import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sumi.planner.db.PlanDao
import sumi.planner.db.PlanEntity

class MainViewModel(private val dao: PlanDao) : ViewModel() {
    val planModel = MutableLiveData<Plan>()

    private val planListFromDB: LiveData<List<PlanEntity>> = dao.getAllPlans()

    // Transformations.map 은 어떤 LiveData 가 변했을 때, 가공하고 싶을 때 사용합니다.
    // 가령, DB에 값이 변하면 위의 dbData 에는 새로운 List<DrinkEntity> 값이 할당되는데요
    // 이 List의 값은 바로 textView에 표현할 수 없기 때문에 아래와 같이 들어온 값을, drinkListToDrinkText 함수를 타서 가공합니다.
    val dbDataText: LiveData<String> = Transformations.map(planListFromDB,::planListToPlanText)

    private fun planListToPlanText(planEntityList: List<PlanEntity>): String {
        var text = ""

        for (planEntity in planEntityList) {
            text += "id : ${planEntity.planId} / name: ${planEntity.planContents}\n"
        }

        return text
    }

    fun submitDB(editText: EditText) {
        // db에 drink entity를 저장한다.
        Log.i("ViewModel","Button Click")
        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(PlanEntity(planContents = editText.text.toString()))
        }
        editText.text=null
    }
}
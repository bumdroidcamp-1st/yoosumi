package sumi.planner.calendar

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import sumi.planner.databinding.FragmentRecordBinding
import sumi.planner.db.PlanDatabase


class RecordFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding=FragmentRecordBinding.inflate(inflater,container,false)

        // 생성자에 변수가 포함된 viewModel을 생성할 때는 Factory를 통해 주입해줘야 한다.


        //이 부분에서 안되는 것 같아요..ㅜ 프래그먼트라 this 대신 requireContext()를 넣었는데 이게 문제인건가요??
        ////////////////////////////////////////////////////////////////////////////////////////////
        val viewModelFactory = MainViewModelFactory(PlanDatabase.getInstance(activity).dao)
        ////////////////////////////////////////////////////////////////////////////////////////////

        Log.i("ViewModel","Button Click")
        // 위에서 만든 Factory를 넣어줘서 뷰모델을 생성
        val viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this



        return binding.root




    }
}
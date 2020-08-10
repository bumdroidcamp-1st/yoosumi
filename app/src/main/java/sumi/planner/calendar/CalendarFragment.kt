package sumi.planner.calendar


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.airbnb.lottie.LottieAnimationView
import sumi.planner.R
import sumi.planner.databinding.FragmentCalendarBinding


class CalendarFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding= FragmentCalendarBinding.inflate(inflater,container,false)


        // By ID we can use each component
        // which id is assign in xml file
        // use findViewById() to get the
        // CalendarView and TextView
        // By ID we can use each component
        // which id is assign in xml file
        // use findViewById() to get the
        // CalendarView and TextView
        val calender = binding.calender as CalendarView
        val date_view = binding.dateView as TextView

        // Add Listener in calendar

        // Add Listener in calendar
        calender
            .setOnDateChangeListener(
                CalendarView.OnDateChangeListener { view, year, month, dayOfMonth ->

                })



        val allIcon=binding.allIcon as LottieAnimationView
        allIcon.progress= 0.2F


        val addIcon=binding.addIcon as LottieAnimationView
        addIcon.progress=1F
        addIcon.setOnClickListener { view:View->
            view.findNavController().navigate(R.id.action_calendarFragment_to_recordFragment)
        }
        /*val myCharacter = binding.myCharacter as LottieAnimationView
        myCharacter.playAnimation()
        myCharacter.loop(true)

        val progressBar = binding.progressBar as LottieAnimationView
        progressBar.playAnimation()
        progressBar.loop(true)*/

        return binding.root
    }

}
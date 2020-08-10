package sumi.planner.password

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import sumi.planner.R
import sumi.planner.databinding.FragmentPasswordBinding


class PasswordFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding=FragmentPasswordBinding.inflate(inflater,container,false)
        return binding.root
    }

}
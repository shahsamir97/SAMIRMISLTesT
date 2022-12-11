package com.apps.samirmisltest.ui.splashscreen

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.apps.samirmisltest.R
import com.apps.samirmisltest.databinding.FragmentSplashScreenBinding
import com.apps.samirmisltest.utils.HearBeatAnimation


class SplashScreenFragment : Fragment() {

    private lateinit var binding: FragmentSplashScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashScreenBinding.inflate(inflater, container, false)
            return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        HearBeatAnimation.animateHeartBeat(binding.imageView)

         Handler(Looper.getMainLooper()).postDelayed(Runnable {
           findNavController().navigate(R.id.action_splashScreenFragment_to_repoListFragment)
        }, 5000)


    }
}

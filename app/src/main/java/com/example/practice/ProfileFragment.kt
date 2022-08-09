package com.example.practice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.example.practice.databinding.FragmentProfileBinding

class ProfileFragment: Fragment() {
    lateinit var binding:FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.userNameTv.text="User Name :  Sample User"
        binding.fadeInBtn.setOnClickListener {
            val animFadeIn:Animation=AnimationUtils.loadAnimation(context,R.anim.fade_in)
            binding.imageVW.startAnimation(animFadeIn)
        }
        binding.fadeOutBtn.setOnClickListener {
            val animFadeOut:Animation=AnimationUtils.loadAnimation(context,R.anim.fade_out)
            binding.imageVW.startAnimation(animFadeOut)
        }

    }


}
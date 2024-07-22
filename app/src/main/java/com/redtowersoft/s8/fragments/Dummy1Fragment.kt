package com.redtowersoft.s8.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.redtowersoft.s8.R

class Dummy1Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragView = inflater.inflate(
            R.layout.fragment_dummy1,
            container,
            false)


        return fragView

    }
}
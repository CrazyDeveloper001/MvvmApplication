package com.io.practicemvvm.presentation.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.io.practicemvvm.R
import com.io.practicemvvm.databinding.FragmentFirstBinding
import com.io.practicemvvm.presentation.view.base.BaseFragment
import com.io.practicemvvm.presentation.view.viewmodel.MyFirstViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class FirstFragment : BaseFragment<FragmentFirstBinding>() {

    override var getLayout= R.layout.fragment_first

    val vmodel : MyFirstViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeData()
        dataBinding.buttonFirst.setOnClickListener {
            Log.e("First Fragment","Started Service")
            vmodel.getPostFromRepository()
        }
    }

    private fun subscribeData() {
        vmodel._dataReceived.observe(viewLifecycleOwner, Observer {
            if(it!=null && it.size > 0){
              Toast.makeText(requireContext(),"Found Data ${it.size}",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(requireContext(),"No Data Found",Toast.LENGTH_SHORT).show()
            }
        })
    }
}
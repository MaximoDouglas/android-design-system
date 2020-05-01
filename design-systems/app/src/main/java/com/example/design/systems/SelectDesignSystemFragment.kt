package com.example.design.systems

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.design.systems.databinding.SelectDesignSystemFragmentBinding

class SelectDesignSystemFragment : Fragment() {

    private var mBinding: SelectDesignSystemFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.select_design_system_fragment,
            container,
            false
        )

        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        mBinding?.selectDesignSystemAsphaltButton?.setOnClickListener {
            Toast.makeText(context, "Asphalt", Toast.LENGTH_SHORT).show()
        }
    }


}

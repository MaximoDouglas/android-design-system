package br.com.argmax.design_systems.app.modules.asphalt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import br.com.argmax.design_systems.R
import br.com.argmax.design_systems.databinding.AsphaltDesignSystemFragmentBinding

class AsphaltDesignSystemFragment : Fragment() {

    private var mBinding: AsphaltDesignSystemFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.asphalt_design_system_fragment,
            container,
            false
        )

        return mBinding?.root
    }


}
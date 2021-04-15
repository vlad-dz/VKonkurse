package ru.iddqdpwn.vkonkurse.ui.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner

abstract class BaseFragment : Fragment() {

//    private var lastToolbarStateIsExpanded = true
//    private var toolbarIsAnimated = false
//
//    val mainActivity: MainActivity by lazy { activity as MainActivity }
//    private val viewModelFactory: ViewModelFactory by lazy { mainActivity.viewModelFactory }
//    val linksViewModel by activityViewModels<LinkViewModel> { viewModelFactory }
//    val authViewModel by activityViewModels<AuthViewModel> { viewModelFactory }
//    val profileViewModel by activityViewModels<ProfileViewModel> { viewModelFactory }

    open fun setObservers(lifeOwner: LifecycleOwner) {}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers(viewLifecycleOwner)
    }

}
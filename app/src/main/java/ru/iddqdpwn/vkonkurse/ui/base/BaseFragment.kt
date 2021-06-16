package ru.iddqdpwn.vkonkurse.ui.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import ru.iddqdpwn.vkonkurse.ui.activity.MainActivity
import ru.iddqdpwn.vkonkurse.ui.viewmodel.GiveawaysViewModel
import ru.iddqdpwn.vkonkurse.ui.viewmodel.ViewModelFactory

abstract class BaseFragment : Fragment() {

//    private var lastToolbarStateIsExpanded = true
//    private var toolbarIsAnimated = false
//
//    val mainActivity: MainActivity by lazy { activity as MainActivity }
//    private val viewModelFactory: ViewModelFactory by lazy { mainActivity.viewModelFactory }
//    val linksViewModel by activityViewModels<LinkViewModel> { viewModelFactory }
//    val authViewModel by activityViewModels<AuthViewModel> { viewModelFactory }
//    val profileViewModel by activityViewModels<ProfileViewModel> { viewModelFactory }

    private val mainActivity: MainActivity by lazy { activity as MainActivity }
    private val viewModelFactory: ViewModelFactory by lazy { mainActivity.viewModelFactory }

    val giveawaysViewModel: GiveawaysViewModel by activityViewModels<GiveawaysViewModel> { viewModelFactory }

    open fun initViews(): ViewBinding? = null

    open fun postInitViews(): ViewBinding? = null

    open fun setObservers(lifecycleOwner: LifecycleOwner) {}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        postInitViews()
        setObservers(viewLifecycleOwner)
    }

}
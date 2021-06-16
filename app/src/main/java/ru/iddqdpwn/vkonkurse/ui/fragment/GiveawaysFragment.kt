package ru.iddqdpwn.vkonkurse.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import ru.iddqdpwn.vkonkurse.databinding.FragmentGiveawaysBinding
import ru.iddqdpwn.vkonkurse.extension.fragmentBinding
import ru.iddqdpwn.vkonkurse.ui.adapter.GiveawayAdapter
import ru.iddqdpwn.vkonkurse.ui.base.BaseFragment
import ru.iddqdpwn.vkonkurse.ui.viewmodel.livedata.GiveawaysState

class GiveawaysFragment: BaseFragment() {
    //val binding: FragmentGiveawaysBinding by fragmentBinding()

    val giveawayAdapter: GiveawayAdapter by lazy {
        GiveawayAdapter()
    }

    override fun setObservers(lifecycleOwner: LifecycleOwner) {
        //giveawaysViewModel.giveaways.observe(lifecycleOwner) { handleGiveaways(it) }
    }

    private fun handleGiveaways(giveawaysState: GiveawaysState) {
        when (giveawaysState) {
            is GiveawaysState.Loading -> {
                Log.d("GivFr", " Loading")
            }
            is GiveawaysState.LoadedSuccessfully -> {
                Log.d("GivFr", " LoadedSuccessfully")

                giveawayAdapter.setList(giveawaysState.giveaways)
            }
            is GiveawaysState.Error -> {
                Log.d("GivFr", " Error")

            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentGiveawaysBinding.inflate(inflater, container, false).root// binding.root// super.onCreateView(inflater, container, savedInstanceState)
    }

//    override fun initViews() = binding.apply {
//        rvGiveaway.adapter = giveawayAdapter
//    }
//
//    override fun postInitViews() = binding.apply {
//        giveawaysViewModel.fetchAllGiveaways()
//    }
}
package ru.iddqdpwn.vkonkurse.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.iddqdpwn.vkonkurse.core.domain.Giveaway
import ru.iddqdpwn.vkonkurse.databinding.ActivityUrlProcessingBinding
import ru.iddqdpwn.vkonkurse.ui.viewmodel.GiveawaysViewModel
import ru.iddqdpwn.vkonkurse.ui.viewmodel.UrlProcessingViewModel
import ru.iddqdpwn.vkonkurse.ui.viewmodel.ViewModelFactory


class UrlProcessingActivity : AppCompatActivity() {
    val binding: ActivityUrlProcessingBinding by lazy {
        ActivityUrlProcessingBinding.inflate(LayoutInflater.from(this))
    }
    val urlProcessingViewModel: UrlProcessingViewModel by viewModels { viewModelFactory }

    val viewModelFactory: ViewModelFactory by lazy {
        ViewModelFactory(this)
    }

    var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        url = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            intent
                .getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT).toString()
        } else {
            null
        }
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() = binding.apply {
        url?.let { etLink.setText(it) }

        btnAdd.setOnClickListener {
            GlobalScope.launch {
                Log.e("hui","pizda")
                urlProcessingViewModel.interactorProvider.urlProcessingInteractor.saveGiveaway(
                    Giveaway(tvTitle.text.toString(), tvLink.text.toString(), System.currentTimeMillis(), null)
                )
            }
        }
    }

}
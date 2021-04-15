package ru.iddqdpwn.vkonkurse.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import ru.iddqdpwn.vkonkurse.databinding.ActivityUrlProcessingBinding


class UrlProcessingActivity: AppCompatActivity() {
    val binding: ActivityUrlProcessingBinding by lazy {
        ActivityUrlProcessingBinding.inflate(LayoutInflater.from(this))
    }
    var url: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        url = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            intent
                .getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT).toString()
        } else {
            "VERSION.SDK_INT < M"
        }
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        binding.apply {
            url?.let { etLink.setText(it) }
        }
    }

}
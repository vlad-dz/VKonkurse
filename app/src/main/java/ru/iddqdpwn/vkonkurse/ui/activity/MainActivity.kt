package ru.iddqdpwn.vkonkurse.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.iddqdpwn.vkonkurse.databinding.ActivityMainBinding
import ru.iddqdpwn.vkonkurse.ui.adapter.GiveawayAdapter
import ru.iddqdpwn.vkonkurse.ui.model.Giveaway

class MainActivity: AppCompatActivity() {

    val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    val giveawayAdapter: GiveawayAdapter by lazy {
        GiveawayAdapter()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        binding.apply {
            rvGiveaway.adapter = giveawayAdapter
        }
    }

    override fun onResume() {
        super.onResume()
        giveawayAdapter.setList(
            listOf(
                Giveaway(0,"test 0", 0),
                Giveaway(1,"test 1", 0),
                Giveaway(2,"test 2", 0),
                Giveaway(3,"test 2", 0),
                Giveaway(4,"test 2", 0),
                Giveaway(5,"test 2", 0),
                Giveaway(6,"test 3", 0)
            )
        )
    }
}
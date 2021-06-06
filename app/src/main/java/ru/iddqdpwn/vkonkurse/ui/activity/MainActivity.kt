package ru.iddqdpwn.vkonkurse.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.iddqdpwn.vkonkurse.databinding.ActivityMainBinding
import ru.iddqdpwn.vkonkurse.local.db.GiveawayDatabase
import ru.iddqdpwn.vkonkurse.ui.adapter.GiveawayAdapter
import ru.iddqdpwn.vkonkurse.local.db.model.Giveaway
import kotlin.coroutines.CoroutineContext
import kotlin.random.Random

class MainActivity: AppCompatActivity() {

    val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    val giveawayAdapter: GiveawayAdapter by lazy {
        GiveawayAdapter()
    }
    val db by lazy {
        GiveawayDatabase(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        binding.apply {
            rvGiveaway.adapter = giveawayAdapter

            buttonAdd.setOnClickListener {
                GlobalScope.launch {
                    db.giveawayDao().insert(
                        Giveaway(
                            "title${Random.nextInt(0,1000)}",
                            "link${Random.nextInt(0,1000)}",
                            0L
                        )
                    )
                    val giveaways = db.giveawayDao().getAllGiveaways()
                    giveaways.let {
                        runOnUiThread {
                            giveawayAdapter.setList(it)
                        }
                    }
                }
            }
            buttonGetAll.setOnClickListener {
                GlobalScope.launch {
                    val giveaways = db.giveawayDao().getAllGiveaways()
                    giveaways.let {
                        runOnUiThread {
                            giveawayAdapter.setList(it)
                        }
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
    }
}
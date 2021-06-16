package ru.iddqdpwn.vkonkurse.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import ru.iddqdpwn.vkonkurse.R
import ru.iddqdpwn.vkonkurse.databinding.ActivityMainBinding
import ru.iddqdpwn.vkonkurse.ui.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {

    val viewModelFactory: ViewModelFactory by lazy {
        ViewModelFactory(this)
    }

    private val mainNavController: NavController by lazy {
        findNavController(R.id.host_container)
    }

    //val binding: ActivityMainBinding by activityBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        mainNavController.navigate(R.id.action_global_giveawayFr)

        //Log.d("TAHG", "${findChildController()}")
    }

//    private fun findChildController(): NavController? {
//        val nestedNavHostFragment =
//            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as? NavHostFragment
//        return nestedNavHostFragment?.navController
//    }
}
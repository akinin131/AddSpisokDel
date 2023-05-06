package quiz.example.weather

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import quiz.example.weather.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var bindig: ActivityMainBinding
    lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindig = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindig.root)
        val actionBar = supportActionBar
        actionBar?.title = "Список дел"

        APP = this
        navController = Navigation.findNavController(this, R.id.nav_fragment)
        bindig.navView.setupWithNavController(navController)
        bindig.navView.itemIconTintList = null
    }

}
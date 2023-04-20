package quiz.example.weather

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import quiz.example.weather.databinding.ActivityMainBinding
import quiz.example.weather.screens.tasks.Tasks.MyClass.Companion.value


class MainActivity : AppCompatActivity() {
    private lateinit var bindig: ActivityMainBinding
    lateinit var navController: NavController
    var preferences : SharedPreferences?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindig = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindig.root)
        val actionBar = supportActionBar
        actionBar?.setTitle("Список дел")
        preferences = getSharedPreferences("TABLE", Context.MODE_PRIVATE)
        value=preferences?.getInt("counter",0)!!
        APP = this
        navController = Navigation.findNavController(this, R.id.nav_fragment)
        bindig.navView.setupWithNavController(navController)
        bindig.navView.itemIconTintList = null

    }

    @SuppressLint("CommitPrefEdits")
    fun saveData(res:Int){
        val editor = preferences?.edit()
        editor?.putInt("counter",res)
        editor?.apply()
    }

}
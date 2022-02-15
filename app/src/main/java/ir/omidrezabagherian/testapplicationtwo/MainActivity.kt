package ir.omidrezabagherian.testapplicationtwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import ir.omidrezabagherian.testapplicationtwo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)

        fragmentIsRun(OneFragment())

        mainBinding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.fragment1 -> {
                    fragmentIsRun(OneFragment())
                    true
                }
                R.id.fragment2 -> {
                    fragmentIsRun(TwoFragment())
                    true
                }
                R.id.fragment3 -> {
                    fragmentIsRun(ThreeFragment())
                    true
                }
                else -> {
                    false
                }
            }
        }

        setContentView(mainBinding.root)
    }

    private fun fragmentIsRun(fragment: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.fragment_container, fragment)
            setReorderingAllowed(true)
        }
    }

}
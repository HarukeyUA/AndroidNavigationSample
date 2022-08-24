package com.harukey.nav

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commitNow
import com.harukey.nav.ui.mainNavHost.MainNavHostFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            initMainNavHost()
        }
    }

    private fun initMainNavHost() {
        supportFragmentManager.commitNow {
            val fragment = MainNavHostFragment()
            replace(R.id.fragmentContainer, fragment)
            setPrimaryNavigationFragment(fragment)
        }
    }
}

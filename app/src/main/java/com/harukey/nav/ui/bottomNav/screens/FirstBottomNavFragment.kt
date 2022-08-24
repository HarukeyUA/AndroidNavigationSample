package com.harukey.nav.ui.bottomNav.screens

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.harukey.nav.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstBottomNavFragment : Fragment(
    R.layout.generic_bottom_nav_fragment
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.screenText).text = javaClass.simpleName
        view.findViewById<Button>(R.id.navigateButton).isVisible = false
    }
}

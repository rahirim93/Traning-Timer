package com.example.traningtimer.ui.launch

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.traningtimer.R

public class LaunchFragmentDirections private constructor() {
  public companion object {
    public fun tosettingsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.tosettingsFragment)
  }
}

package com.example.traningtimer.ui.settings

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.traningtimer.R

public class SettingsFragmentDirections private constructor() {
  public companion object {
    public fun toMainFragment(): NavDirections = ActionOnlyNavDirections(R.id.toMainFragment)

    public fun toListFragment(): NavDirections = ActionOnlyNavDirections(R.id.toListFragment)
  }
}

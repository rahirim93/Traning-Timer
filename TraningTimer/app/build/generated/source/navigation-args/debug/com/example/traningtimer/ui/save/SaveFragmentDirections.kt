package com.example.traningtimer.ui.save

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.traningtimer.R

public class SaveFragmentDirections private constructor() {
  public companion object {
    public fun toListFragment(): NavDirections = ActionOnlyNavDirections(R.id.toListFragment)
  }
}

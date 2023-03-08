package com.example.traningtimer.ui.main

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.traningtimer.R

public class MainFragmentDirections private constructor() {
  public companion object {
    public fun toSecondFragment(): NavDirections = ActionOnlyNavDirections(R.id.toSecondFragment)
  }
}

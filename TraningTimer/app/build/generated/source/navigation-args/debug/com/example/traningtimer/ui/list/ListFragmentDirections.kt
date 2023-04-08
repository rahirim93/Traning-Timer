package com.example.traningtimer.ui.list

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.traningtimer.R

public class ListFragmentDirections private constructor() {
  public companion object {
    public fun toEditFragment(): NavDirections = ActionOnlyNavDirections(R.id.toEditFragment)
  }
}

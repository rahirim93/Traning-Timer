// Generated by view binder compiler. Do not edit!
package com.example.traningtimer.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.traningtimer.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMain2Binding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button button21;

  @NonNull
  public final Button button210;

  @NonNull
  public final Button button211;

  @NonNull
  public final Button button212;

  @NonNull
  public final Button button22;

  @NonNull
  public final Button button23;

  @NonNull
  public final Button button24;

  @NonNull
  public final Button button25;

  @NonNull
  public final Button button26;

  @NonNull
  public final Button button27;

  @NonNull
  public final Button button28;

  @NonNull
  public final Button button29;

  @NonNull
  public final GridLayout gridLayout;

  @NonNull
  public final SeekBar seekBar;

  private ActivityMain2Binding(@NonNull ConstraintLayout rootView, @NonNull Button button21,
      @NonNull Button button210, @NonNull Button button211, @NonNull Button button212,
      @NonNull Button button22, @NonNull Button button23, @NonNull Button button24,
      @NonNull Button button25, @NonNull Button button26, @NonNull Button button27,
      @NonNull Button button28, @NonNull Button button29, @NonNull GridLayout gridLayout,
      @NonNull SeekBar seekBar) {
    this.rootView = rootView;
    this.button21 = button21;
    this.button210 = button210;
    this.button211 = button211;
    this.button212 = button212;
    this.button22 = button22;
    this.button23 = button23;
    this.button24 = button24;
    this.button25 = button25;
    this.button26 = button26;
    this.button27 = button27;
    this.button28 = button28;
    this.button29 = button29;
    this.gridLayout = gridLayout;
    this.seekBar = seekBar;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMain2Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMain2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main2, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMain2Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button21;
      Button button21 = ViewBindings.findChildViewById(rootView, id);
      if (button21 == null) {
        break missingId;
      }

      id = R.id.button210;
      Button button210 = ViewBindings.findChildViewById(rootView, id);
      if (button210 == null) {
        break missingId;
      }

      id = R.id.button211;
      Button button211 = ViewBindings.findChildViewById(rootView, id);
      if (button211 == null) {
        break missingId;
      }

      id = R.id.button212;
      Button button212 = ViewBindings.findChildViewById(rootView, id);
      if (button212 == null) {
        break missingId;
      }

      id = R.id.button22;
      Button button22 = ViewBindings.findChildViewById(rootView, id);
      if (button22 == null) {
        break missingId;
      }

      id = R.id.button23;
      Button button23 = ViewBindings.findChildViewById(rootView, id);
      if (button23 == null) {
        break missingId;
      }

      id = R.id.button24;
      Button button24 = ViewBindings.findChildViewById(rootView, id);
      if (button24 == null) {
        break missingId;
      }

      id = R.id.button25;
      Button button25 = ViewBindings.findChildViewById(rootView, id);
      if (button25 == null) {
        break missingId;
      }

      id = R.id.button26;
      Button button26 = ViewBindings.findChildViewById(rootView, id);
      if (button26 == null) {
        break missingId;
      }

      id = R.id.button27;
      Button button27 = ViewBindings.findChildViewById(rootView, id);
      if (button27 == null) {
        break missingId;
      }

      id = R.id.button28;
      Button button28 = ViewBindings.findChildViewById(rootView, id);
      if (button28 == null) {
        break missingId;
      }

      id = R.id.button29;
      Button button29 = ViewBindings.findChildViewById(rootView, id);
      if (button29 == null) {
        break missingId;
      }

      id = R.id.gridLayout;
      GridLayout gridLayout = ViewBindings.findChildViewById(rootView, id);
      if (gridLayout == null) {
        break missingId;
      }

      id = R.id.seekBar;
      SeekBar seekBar = ViewBindings.findChildViewById(rootView, id);
      if (seekBar == null) {
        break missingId;
      }

      return new ActivityMain2Binding((ConstraintLayout) rootView, button21, button210, button211,
          button212, button22, button23, button24, button25, button26, button27, button28, button29,
          gridLayout, seekBar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
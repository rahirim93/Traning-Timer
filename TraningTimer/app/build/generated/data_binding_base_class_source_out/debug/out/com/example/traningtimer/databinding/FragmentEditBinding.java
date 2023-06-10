// Generated by view binder compiler. Do not edit!
package com.example.traningtimer.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.traningtimer.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentEditBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button buttonCheck;

  @NonNull
  public final Button buttonDate;

  @NonNull
  public final Button buttonDelete;

  @NonNull
  public final Button buttonFill;

  @NonNull
  public final Button buttonSave;

  @NonNull
  public final Button buttonType1;

  @NonNull
  public final Button buttonType2;

  @NonNull
  public final Button buttonType3;

  @NonNull
  public final Button buttonType4;

  @NonNull
  public final Button buttonWeight0;

  @NonNull
  public final Button buttonWeight16;

  @NonNull
  public final Button buttonWeight24;

  @NonNull
  public final Button buttonWeight32;

  @NonNull
  public final ConstraintLayout date;

  @NonNull
  public final EditText editText1;

  @NonNull
  public final EditText editText10;

  @NonNull
  public final EditText editText2;

  @NonNull
  public final EditText editText3;

  @NonNull
  public final EditText editText4;

  @NonNull
  public final EditText editText5;

  @NonNull
  public final EditText editText6;

  @NonNull
  public final EditText editText7;

  @NonNull
  public final EditText editText8;

  @NonNull
  public final EditText editText9;

  @NonNull
  public final LinearLayout linearLayout3;

  @NonNull
  public final LinearLayout linearLayout4;

  @NonNull
  public final TextView textView10;

  @NonNull
  public final TextView textView11;

  @NonNull
  public final TextView textView12;

  @NonNull
  public final TextView textView13;

  @NonNull
  public final TextView textView14;

  @NonNull
  public final TextView textView15;

  @NonNull
  public final TextView textView16;

  @NonNull
  public final TextView textView5;

  @NonNull
  public final TextView textView6;

  @NonNull
  public final TextView textView7;

  @NonNull
  public final TextView textView8;

  @NonNull
  public final TextView textView9;

  private FragmentEditBinding(@NonNull ConstraintLayout rootView, @NonNull Button buttonCheck,
      @NonNull Button buttonDate, @NonNull Button buttonDelete, @NonNull Button buttonFill,
      @NonNull Button buttonSave, @NonNull Button buttonType1, @NonNull Button buttonType2,
      @NonNull Button buttonType3, @NonNull Button buttonType4, @NonNull Button buttonWeight0,
      @NonNull Button buttonWeight16, @NonNull Button buttonWeight24,
      @NonNull Button buttonWeight32, @NonNull ConstraintLayout date, @NonNull EditText editText1,
      @NonNull EditText editText10, @NonNull EditText editText2, @NonNull EditText editText3,
      @NonNull EditText editText4, @NonNull EditText editText5, @NonNull EditText editText6,
      @NonNull EditText editText7, @NonNull EditText editText8, @NonNull EditText editText9,
      @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4,
      @NonNull TextView textView10, @NonNull TextView textView11, @NonNull TextView textView12,
      @NonNull TextView textView13, @NonNull TextView textView14, @NonNull TextView textView15,
      @NonNull TextView textView16, @NonNull TextView textView5, @NonNull TextView textView6,
      @NonNull TextView textView7, @NonNull TextView textView8, @NonNull TextView textView9) {
    this.rootView = rootView;
    this.buttonCheck = buttonCheck;
    this.buttonDate = buttonDate;
    this.buttonDelete = buttonDelete;
    this.buttonFill = buttonFill;
    this.buttonSave = buttonSave;
    this.buttonType1 = buttonType1;
    this.buttonType2 = buttonType2;
    this.buttonType3 = buttonType3;
    this.buttonType4 = buttonType4;
    this.buttonWeight0 = buttonWeight0;
    this.buttonWeight16 = buttonWeight16;
    this.buttonWeight24 = buttonWeight24;
    this.buttonWeight32 = buttonWeight32;
    this.date = date;
    this.editText1 = editText1;
    this.editText10 = editText10;
    this.editText2 = editText2;
    this.editText3 = editText3;
    this.editText4 = editText4;
    this.editText5 = editText5;
    this.editText6 = editText6;
    this.editText7 = editText7;
    this.editText8 = editText8;
    this.editText9 = editText9;
    this.linearLayout3 = linearLayout3;
    this.linearLayout4 = linearLayout4;
    this.textView10 = textView10;
    this.textView11 = textView11;
    this.textView12 = textView12;
    this.textView13 = textView13;
    this.textView14 = textView14;
    this.textView15 = textView15;
    this.textView16 = textView16;
    this.textView5 = textView5;
    this.textView6 = textView6;
    this.textView7 = textView7;
    this.textView8 = textView8;
    this.textView9 = textView9;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentEditBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentEditBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_edit, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentEditBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttonCheck;
      Button buttonCheck = ViewBindings.findChildViewById(rootView, id);
      if (buttonCheck == null) {
        break missingId;
      }

      id = R.id.buttonDate;
      Button buttonDate = ViewBindings.findChildViewById(rootView, id);
      if (buttonDate == null) {
        break missingId;
      }

      id = R.id.buttonDelete;
      Button buttonDelete = ViewBindings.findChildViewById(rootView, id);
      if (buttonDelete == null) {
        break missingId;
      }

      id = R.id.buttonFill;
      Button buttonFill = ViewBindings.findChildViewById(rootView, id);
      if (buttonFill == null) {
        break missingId;
      }

      id = R.id.buttonSave;
      Button buttonSave = ViewBindings.findChildViewById(rootView, id);
      if (buttonSave == null) {
        break missingId;
      }

      id = R.id.buttonType1;
      Button buttonType1 = ViewBindings.findChildViewById(rootView, id);
      if (buttonType1 == null) {
        break missingId;
      }

      id = R.id.buttonType2;
      Button buttonType2 = ViewBindings.findChildViewById(rootView, id);
      if (buttonType2 == null) {
        break missingId;
      }

      id = R.id.buttonType3;
      Button buttonType3 = ViewBindings.findChildViewById(rootView, id);
      if (buttonType3 == null) {
        break missingId;
      }

      id = R.id.buttonType4;
      Button buttonType4 = ViewBindings.findChildViewById(rootView, id);
      if (buttonType4 == null) {
        break missingId;
      }

      id = R.id.buttonWeight0;
      Button buttonWeight0 = ViewBindings.findChildViewById(rootView, id);
      if (buttonWeight0 == null) {
        break missingId;
      }

      id = R.id.buttonWeight16;
      Button buttonWeight16 = ViewBindings.findChildViewById(rootView, id);
      if (buttonWeight16 == null) {
        break missingId;
      }

      id = R.id.buttonWeight24;
      Button buttonWeight24 = ViewBindings.findChildViewById(rootView, id);
      if (buttonWeight24 == null) {
        break missingId;
      }

      id = R.id.buttonWeight32;
      Button buttonWeight32 = ViewBindings.findChildViewById(rootView, id);
      if (buttonWeight32 == null) {
        break missingId;
      }

      ConstraintLayout date = (ConstraintLayout) rootView;

      id = R.id.editText1;
      EditText editText1 = ViewBindings.findChildViewById(rootView, id);
      if (editText1 == null) {
        break missingId;
      }

      id = R.id.editText10;
      EditText editText10 = ViewBindings.findChildViewById(rootView, id);
      if (editText10 == null) {
        break missingId;
      }

      id = R.id.editText2;
      EditText editText2 = ViewBindings.findChildViewById(rootView, id);
      if (editText2 == null) {
        break missingId;
      }

      id = R.id.editText3;
      EditText editText3 = ViewBindings.findChildViewById(rootView, id);
      if (editText3 == null) {
        break missingId;
      }

      id = R.id.editText4;
      EditText editText4 = ViewBindings.findChildViewById(rootView, id);
      if (editText4 == null) {
        break missingId;
      }

      id = R.id.editText5;
      EditText editText5 = ViewBindings.findChildViewById(rootView, id);
      if (editText5 == null) {
        break missingId;
      }

      id = R.id.editText6;
      EditText editText6 = ViewBindings.findChildViewById(rootView, id);
      if (editText6 == null) {
        break missingId;
      }

      id = R.id.editText7;
      EditText editText7 = ViewBindings.findChildViewById(rootView, id);
      if (editText7 == null) {
        break missingId;
      }

      id = R.id.editText8;
      EditText editText8 = ViewBindings.findChildViewById(rootView, id);
      if (editText8 == null) {
        break missingId;
      }

      id = R.id.editText9;
      EditText editText9 = ViewBindings.findChildViewById(rootView, id);
      if (editText9 == null) {
        break missingId;
      }

      id = R.id.linearLayout3;
      LinearLayout linearLayout3 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout3 == null) {
        break missingId;
      }

      id = R.id.linearLayout4;
      LinearLayout linearLayout4 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout4 == null) {
        break missingId;
      }

      id = R.id.textView10;
      TextView textView10 = ViewBindings.findChildViewById(rootView, id);
      if (textView10 == null) {
        break missingId;
      }

      id = R.id.textView11;
      TextView textView11 = ViewBindings.findChildViewById(rootView, id);
      if (textView11 == null) {
        break missingId;
      }

      id = R.id.textView12;
      TextView textView12 = ViewBindings.findChildViewById(rootView, id);
      if (textView12 == null) {
        break missingId;
      }

      id = R.id.textView13;
      TextView textView13 = ViewBindings.findChildViewById(rootView, id);
      if (textView13 == null) {
        break missingId;
      }

      id = R.id.textView14;
      TextView textView14 = ViewBindings.findChildViewById(rootView, id);
      if (textView14 == null) {
        break missingId;
      }

      id = R.id.textView15;
      TextView textView15 = ViewBindings.findChildViewById(rootView, id);
      if (textView15 == null) {
        break missingId;
      }

      id = R.id.textView16;
      TextView textView16 = ViewBindings.findChildViewById(rootView, id);
      if (textView16 == null) {
        break missingId;
      }

      id = R.id.textView5;
      TextView textView5 = ViewBindings.findChildViewById(rootView, id);
      if (textView5 == null) {
        break missingId;
      }

      id = R.id.textView6;
      TextView textView6 = ViewBindings.findChildViewById(rootView, id);
      if (textView6 == null) {
        break missingId;
      }

      id = R.id.textView7;
      TextView textView7 = ViewBindings.findChildViewById(rootView, id);
      if (textView7 == null) {
        break missingId;
      }

      id = R.id.textView8;
      TextView textView8 = ViewBindings.findChildViewById(rootView, id);
      if (textView8 == null) {
        break missingId;
      }

      id = R.id.textView9;
      TextView textView9 = ViewBindings.findChildViewById(rootView, id);
      if (textView9 == null) {
        break missingId;
      }

      return new FragmentEditBinding((ConstraintLayout) rootView, buttonCheck, buttonDate,
          buttonDelete, buttonFill, buttonSave, buttonType1, buttonType2, buttonType3, buttonType4,
          buttonWeight0, buttonWeight16, buttonWeight24, buttonWeight32, date, editText1,
          editText10, editText2, editText3, editText4, editText5, editText6, editText7, editText8,
          editText9, linearLayout3, linearLayout4, textView10, textView11, textView12, textView13,
          textView14, textView15, textView16, textView5, textView6, textView7, textView8,
          textView9);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}

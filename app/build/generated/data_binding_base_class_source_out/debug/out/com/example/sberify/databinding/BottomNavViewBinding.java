// Generated by view binder compiler. Do not edit!
package com.example.sberify.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.example.sberify.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.lang.NullPointerException;
import java.lang.Override;

public final class BottomNavViewBinding implements ViewBinding {
  @NonNull
  private final BottomNavigationView rootView;

  @NonNull
  public final BottomNavigationView bottomNavView;

  private BottomNavViewBinding(@NonNull BottomNavigationView rootView,
      @NonNull BottomNavigationView bottomNavView) {
    this.rootView = rootView;
    this.bottomNavView = bottomNavView;
  }

  @Override
  @NonNull
  public BottomNavigationView getRoot() {
    return rootView;
  }

  @NonNull
  public static BottomNavViewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static BottomNavViewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.bottom_nav_view, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static BottomNavViewBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    BottomNavigationView bottomNavView = (BottomNavigationView) rootView;

    return new BottomNavViewBinding((BottomNavigationView) rootView, bottomNavView);
  }
}

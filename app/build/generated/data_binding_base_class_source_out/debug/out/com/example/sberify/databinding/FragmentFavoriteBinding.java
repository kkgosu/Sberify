// Generated by view binder compiler. Do not edit!
package com.example.sberify.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.example.sberify.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentFavoriteBinding implements ViewBinding {
  @NonNull
  private final NestedScrollView rootView;

  @NonNull
  public final TextView favoriteAlbumsLabel;

  @NonNull
  public final RecyclerView favoriteAlbumsRecycler;

  @NonNull
  public final TextView favoriteTracksLabel;

  @NonNull
  public final RecyclerView favoriteTracksRecycler;

  @NonNull
  public final NestedScrollView nestedScroll;

  private FragmentFavoriteBinding(@NonNull NestedScrollView rootView,
      @NonNull TextView favoriteAlbumsLabel, @NonNull RecyclerView favoriteAlbumsRecycler,
      @NonNull TextView favoriteTracksLabel, @NonNull RecyclerView favoriteTracksRecycler,
      @NonNull NestedScrollView nestedScroll) {
    this.rootView = rootView;
    this.favoriteAlbumsLabel = favoriteAlbumsLabel;
    this.favoriteAlbumsRecycler = favoriteAlbumsRecycler;
    this.favoriteTracksLabel = favoriteTracksLabel;
    this.favoriteTracksRecycler = favoriteTracksRecycler;
    this.nestedScroll = nestedScroll;
  }

  @Override
  @NonNull
  public NestedScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentFavoriteBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentFavoriteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_favorite, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentFavoriteBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.favorite_albums_label;
      TextView favoriteAlbumsLabel = rootView.findViewById(id);
      if (favoriteAlbumsLabel == null) {
        break missingId;
      }

      id = R.id.favorite_albums_recycler;
      RecyclerView favoriteAlbumsRecycler = rootView.findViewById(id);
      if (favoriteAlbumsRecycler == null) {
        break missingId;
      }

      id = R.id.favorite_tracks_label;
      TextView favoriteTracksLabel = rootView.findViewById(id);
      if (favoriteTracksLabel == null) {
        break missingId;
      }

      id = R.id.favorite_tracks_recycler;
      RecyclerView favoriteTracksRecycler = rootView.findViewById(id);
      if (favoriteTracksRecycler == null) {
        break missingId;
      }

      NestedScrollView nestedScroll = (NestedScrollView) rootView;

      return new FragmentFavoriteBinding((NestedScrollView) rootView, favoriteAlbumsLabel,
          favoriteAlbumsRecycler, favoriteTracksLabel, favoriteTracksRecycler, nestedScroll);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}

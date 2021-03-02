// Generated by view binder compiler. Do not edit!
package com.kvlg.search.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.kvlg.search.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentSearchBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final RecyclerView albumsResults;

  @NonNull
  public final TextView albumsTitleTextView;

  @NonNull
  public final TextView artistTitleTextView;

  @NonNull
  public final RecyclerView artistsResults;

  @NonNull
  public final ImageButton filterButton;

  @NonNull
  public final NestedScrollView nestedScroll;

  @NonNull
  public final SearchView searchView;

  @NonNull
  public final RecyclerView suggestionRecycler;

  @NonNull
  public final Toolbar toolbar;

  @NonNull
  public final RecyclerView tracksResults;

  @NonNull
  public final TextView tracksTitleTextView;

  private FragmentSearchBinding(@NonNull LinearLayout rootView, @NonNull RecyclerView albumsResults,
      @NonNull TextView albumsTitleTextView, @NonNull TextView artistTitleTextView,
      @NonNull RecyclerView artistsResults, @NonNull ImageButton filterButton,
      @NonNull NestedScrollView nestedScroll, @NonNull SearchView searchView,
      @NonNull RecyclerView suggestionRecycler, @NonNull Toolbar toolbar,
      @NonNull RecyclerView tracksResults, @NonNull TextView tracksTitleTextView) {
    this.rootView = rootView;
    this.albumsResults = albumsResults;
    this.albumsTitleTextView = albumsTitleTextView;
    this.artistTitleTextView = artistTitleTextView;
    this.artistsResults = artistsResults;
    this.filterButton = filterButton;
    this.nestedScroll = nestedScroll;
    this.searchView = searchView;
    this.suggestionRecycler = suggestionRecycler;
    this.toolbar = toolbar;
    this.tracksResults = tracksResults;
    this.tracksTitleTextView = tracksTitleTextView;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentSearchBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentSearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_search, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentSearchBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.albums_results;
      RecyclerView albumsResults = rootView.findViewById(id);
      if (albumsResults == null) {
        break missingId;
      }

      id = R.id.albums_title_text_view;
      TextView albumsTitleTextView = rootView.findViewById(id);
      if (albumsTitleTextView == null) {
        break missingId;
      }

      id = R.id.artist_title_text_view;
      TextView artistTitleTextView = rootView.findViewById(id);
      if (artistTitleTextView == null) {
        break missingId;
      }

      id = R.id.artists_results;
      RecyclerView artistsResults = rootView.findViewById(id);
      if (artistsResults == null) {
        break missingId;
      }

      id = R.id.filter_button;
      ImageButton filterButton = rootView.findViewById(id);
      if (filterButton == null) {
        break missingId;
      }

      id = R.id.nested_scroll;
      NestedScrollView nestedScroll = rootView.findViewById(id);
      if (nestedScroll == null) {
        break missingId;
      }

      id = R.id.search_view;
      SearchView searchView = rootView.findViewById(id);
      if (searchView == null) {
        break missingId;
      }

      id = R.id.suggestion_recycler;
      RecyclerView suggestionRecycler = rootView.findViewById(id);
      if (suggestionRecycler == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = rootView.findViewById(id);
      if (toolbar == null) {
        break missingId;
      }

      id = R.id.tracks_results;
      RecyclerView tracksResults = rootView.findViewById(id);
      if (tracksResults == null) {
        break missingId;
      }

      id = R.id.tracks_title_text_view;
      TextView tracksTitleTextView = rootView.findViewById(id);
      if (tracksTitleTextView == null) {
        break missingId;
      }

      return new FragmentSearchBinding((LinearLayout) rootView, albumsResults, albumsTitleTextView,
          artistTitleTextView, artistsResults, filterButton, nestedScroll, searchView,
          suggestionRecycler, toolbar, tracksResults, tracksTitleTextView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}

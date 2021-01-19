// Generated by view binder compiler. Do not edit!
package com.example.sberify.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.example.sberify.R;
import com.example.sberify.presentation.ui.utils.SquareImageView;
import com.google.android.material.card.MaterialCardView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemAlbumBinding implements ViewBinding {
  @NonNull
  private final MaterialCardView rootView;

  @NonNull
  public final TextView artistName;

  @NonNull
  public final MaterialCardView cardView;

  @NonNull
  public final LinearLayout itemAlbumPalette;

  @NonNull
  public final SquareImageView releaseCover;

  @NonNull
  public final TextView releaseName;

  private ItemAlbumBinding(@NonNull MaterialCardView rootView, @NonNull TextView artistName,
      @NonNull MaterialCardView cardView, @NonNull LinearLayout itemAlbumPalette,
      @NonNull SquareImageView releaseCover, @NonNull TextView releaseName) {
    this.rootView = rootView;
    this.artistName = artistName;
    this.cardView = cardView;
    this.itemAlbumPalette = itemAlbumPalette;
    this.releaseCover = releaseCover;
    this.releaseName = releaseName;
  }

  @Override
  @NonNull
  public MaterialCardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemAlbumBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemAlbumBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_album, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemAlbumBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.artist_name;
      TextView artistName = rootView.findViewById(id);
      if (artistName == null) {
        break missingId;
      }

      MaterialCardView cardView = (MaterialCardView) rootView;

      id = R.id.item_album_palette;
      LinearLayout itemAlbumPalette = rootView.findViewById(id);
      if (itemAlbumPalette == null) {
        break missingId;
      }

      id = R.id.release_cover;
      SquareImageView releaseCover = rootView.findViewById(id);
      if (releaseCover == null) {
        break missingId;
      }

      id = R.id.release_name;
      TextView releaseName = rootView.findViewById(id);
      if (releaseName == null) {
        break missingId;
      }

      return new ItemAlbumBinding((MaterialCardView) rootView, artistName, cardView,
          itemAlbumPalette, releaseCover, releaseName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}

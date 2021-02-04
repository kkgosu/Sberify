// Generated by view binder compiler. Do not edit!
package com.example.sberify.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.example.sberify.R;
import com.kvlg.core.SquareImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemSearchBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final CardView itemContainer;

  @NonNull
  public final LinearLayout itemSearchPalette;

  @NonNull
  public final SquareImageView searchImage;

  @NonNull
  public final TextView searchName;

  private ItemSearchBinding(@NonNull CardView rootView, @NonNull CardView itemContainer,
      @NonNull LinearLayout itemSearchPalette, @NonNull SquareImageView searchImage,
      @NonNull TextView searchName) {
    this.rootView = rootView;
    this.itemContainer = itemContainer;
    this.itemSearchPalette = itemSearchPalette;
    this.searchImage = searchImage;
    this.searchName = searchName;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemSearchBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemSearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_search, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemSearchBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      CardView itemContainer = (CardView) rootView;

      id = R.id.item_search_palette;
      LinearLayout itemSearchPalette = rootView.findViewById(id);
      if (itemSearchPalette == null) {
        break missingId;
      }

      id = R.id.search_image;
      SquareImageView searchImage = rootView.findViewById(id);
      if (searchImage == null) {
        break missingId;
      }

      id = R.id.search_name;
      TextView searchName = rootView.findViewById(id);
      if (searchName == null) {
        break missingId;
      }

      return new ItemSearchBinding((CardView) rootView, itemContainer, itemSearchPalette,
          searchImage, searchName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}

package com.example.sberify.base;

import java.lang.System;

/**
 * BaseViewHolder is an abstract class for structuring the base view holder class.
 */
@kotlin.Suppress(names = {"unused", "LeakingThis"})
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\u0004\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/example/sberify/base/BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "bindData", "", "data", "", "context", "Landroid/content/Context;", "app_debug"})
public abstract class BaseViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder implements android.view.View.OnClickListener, android.view.View.OnLongClickListener {
    private final android.view.View view = null;
    
    /**
     * binds data to the view holder class.
     */
    public abstract void bindData(@org.jetbrains.annotations.NotNull()
    java.lang.Object data) throws java.lang.Exception;
    
    /**
     * gets the view of the [RecyclerView.ViewHolder].
     */
    @org.jetbrains.annotations.NotNull()
    public final android.view.View view() {
        return null;
    }
    
    /**
     * gets the context.
     */
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context context() {
        return null;
    }
    
    public BaseViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
        super(null);
    }
}
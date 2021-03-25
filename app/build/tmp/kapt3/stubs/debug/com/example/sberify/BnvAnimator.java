package com.example.sberify;

import java.lang.System;

/**
 * @author Konstantin Koval
 * @since 18.02.2021
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\fH\u0002J\b\u0010\u0012\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/sberify/BnvAnimator;", "", "bnv", "Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "(Lcom/google/android/material/bottomnavigation/BottomNavigationView;)V", "bnvHeight", "", "heightAnimator", "Landroid/animation/ValueAnimator;", "state", "Lcom/example/sberify/BnvAnimator$BnvState;", "animateBar", "", "destinationId", "createAnimator", "from", "to", "hide", "show", "BnvState", "app_debug"})
public final class BnvAnimator {
    private final int bnvHeight = 0;
    private android.animation.ValueAnimator heightAnimator;
    private com.example.sberify.BnvAnimator.BnvState state = com.example.sberify.BnvAnimator.BnvState.VISIBLE;
    private final com.google.android.material.bottomnavigation.BottomNavigationView bnv = null;
    
    public final void animateBar(int destinationId) {
    }
    
    private final void hide() {
    }
    
    private final void show() {
    }
    
    private final void createAnimator(int from, int to) {
    }
    
    public BnvAnimator(@org.jetbrains.annotations.NotNull()
    com.google.android.material.bottomnavigation.BottomNavigationView bnv) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/example/sberify/BnvAnimator$BnvState;", "", "(Ljava/lang/String;I)V", "VISIBLE", "INVISIBLE", "app_debug"})
    static enum BnvState {
        /*public static final*/ VISIBLE /* = new VISIBLE() */,
        /*public static final*/ INVISIBLE /* = new INVISIBLE() */;
        
        BnvState() {
        }
    }
}
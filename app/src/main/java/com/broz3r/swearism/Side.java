package com.broz3r.swearism;

import android.view.Gravity;
import android.view.View;

/**
 * Created by Paul Mougin on 16/01/2017.
 */

public enum Side {
    LEFT(Gravity.END, View.VISIBLE, View.GONE),
    RIGHT(Gravity.START, View.GONE, View.VISIBLE);

    private int gravity;
    private int leftVisibility;
    private int rightVisibility;

    Side(int gravity, int leftVisibility, int rightVisibility) {
        this.gravity = gravity;
        this.leftVisibility = leftVisibility;
        this.rightVisibility = rightVisibility;
    }

    public int getGravity() {
        return gravity;
    }

    public int getLeftVisibility() {
        return leftVisibility;
    }

    public int getRightVisibility() {
        return rightVisibility;
    }
}

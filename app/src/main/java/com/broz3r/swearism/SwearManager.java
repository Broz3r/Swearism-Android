package com.broz3r.swearism;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by Paul Mougin on 16/01/2017.
 */

public class SwearManager {

    private boolean changeIsEnable = true;

    private SwearView swearView;
    private String[] swears;

    private int swearIndex = 0;
    private int imageIndex = 0;

    public SwearManager(@NonNull Context context, SwearView swearView) {
        this.swearView = swearView;
        this.swears = context.getResources().getStringArray(R.array.swears);
    }

    public void changeSwear() {
        if (changeIsEnable) {
            changeIsEnable = false;
            swearIndex = getNewRandomIndex(swearIndex, swears.length);
            imageIndex = getNewRandomIndex(imageIndex, SwearImage.list.size());

            swearView.fadeOut(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    swearView.setSwear(SwearImage.list.get(imageIndex), swears[swearIndex]);
                    swearView.fadeIn(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            changeIsEnable = true;
                        }
                    });
                }
            });
        }
    }

    private int getNewRandomIndex(int previousIndex, int max) {
        int result;
        do {
            result = (int) (Math.random() * max);
        } while (result == previousIndex);
        return result;
    }
}

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

    private int previousSwearIndex = 0;
    private int previousImageIndex = 0;

    public SwearManager(@NonNull Context context, SwearView swearView) {
        this.swearView = swearView;
        this.swears = context.getResources().getStringArray(R.array.swears);
    }

    public void changeSwear() {
        if (changeIsEnable) {
            changeIsEnable = false;
            previousSwearIndex = getNewRandomIndex(previousSwearIndex, swears.length);
            previousImageIndex = getNewRandomIndex(previousImageIndex, SwearImage.list.size());

            swearView.fadeOut(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    swearView.setSwear(SwearImage.list.get(previousImageIndex), swears[previousSwearIndex]);
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

package com.broz3r.swearism;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by Paul Mougin on 16/01/2017.
 */

public class SwearManager {

    private SwearView swearView;
    private String[] swears;

    public SwearManager(@NonNull Context context, SwearView swearView) {
        this.swearView = swearView;
        this.swears = context.getResources().getStringArray(R.array.swears);
    }

    public void changeSwear() {
        final int swearRandomIndex = (int) (Math.random() * swears.length);
        final int imageRandomIndex = (int) (Math.random() * SwearImage.list.size());

        swearView.fadeOut(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                swearView.setSwear(SwearImage.list.get(imageRandomIndex), swears[swearRandomIndex]);
                swearView.fadeIn(null);
            }
        });
    }
}

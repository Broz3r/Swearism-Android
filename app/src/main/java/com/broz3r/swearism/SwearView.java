package com.broz3r.swearism;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Paul Mougin on 13/01/2017.
 */

public class SwearView extends LinearLayout {

    public enum Side {
        LEFT(Gravity.END, VISIBLE, GONE),
        RIGHT(Gravity.START, GONE, VISIBLE);

        private int gravity;
        private int leftVisibility;
        private int rightVisibility;

        Side(int gravity, int leftVisibility, int rightVisibility) {
            this.gravity = gravity;
            this.leftVisibility = leftVisibility;
            this.rightVisibility = rightVisibility;
        }
    }


    @BindView(R.id.image_left) protected ImageView imageLeft;
    @BindView(R.id.image_right) protected ImageView imageRight;

    private Side side = Side.LEFT;

    public SwearView(Context context) {
        super(context);
        init();
    }

    public SwearView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SwearView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_swear, this);
        ButterKnife.bind(this);

        setWeightSum(5);
        
        setSide(Side.LEFT);
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;

        setGravity(side.gravity);
        imageLeft.setVisibility(side.leftVisibility);
        imageRight.setVisibility(side.rightVisibility);
    }
}

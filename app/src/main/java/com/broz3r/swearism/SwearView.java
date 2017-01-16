package com.broz3r.swearism;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Paul Mougin on 13/01/2017.
 */

public class SwearView extends LinearLayout {

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

        setGravity(side.getGravity());
        imageLeft.setVisibility(side.getLeftVisibility());
        imageRight.setVisibility(side.getRightVisibility());
    }
}

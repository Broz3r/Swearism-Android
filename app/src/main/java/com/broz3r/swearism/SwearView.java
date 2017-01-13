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

    public enum Side {
        LEFT(R.layout.view_swear_left),
        RIGHT(R.layout.view_swear_right);

        private int layoutId;

        Side(int layoutId) {
            this.layoutId = layoutId;
        }

        public int getLayoutId() {
            return layoutId;
        }
    }

    @BindView(R.id.image)
    protected ImageView imageView;

    private Side side;

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
        inflate(getContext(), side.getLayoutId(), this);
        ButterKnife.bind(this);
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
        invalidate();
    }
}

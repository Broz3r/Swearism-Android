package com.broz3r.swearism;

/**
 * Created by Paul Mougin on 16/01/2017.
 */

public class SwearImage {

    private Side side;
    private int imageId;

    public SwearImage(int imageId, Side side) {
        this.imageId = imageId;
        this.side = side;
    }

    public int getImageId() {
        return imageId;
    }

    public Side getSide() {
        return side;
    }
}

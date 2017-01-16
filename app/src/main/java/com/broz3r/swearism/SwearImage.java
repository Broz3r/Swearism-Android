package com.broz3r.swearism;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Paul Mougin on 16/01/2017.
 */

public class SwearImage {

    private static SwearImage swearImage1 = new SwearImage(R.drawable.swear_image_1, Side.RIGHT);
    private static SwearImage swearImage2 = new SwearImage(R.drawable.swear_image_2, Side.LEFT);
    private static SwearImage swearImage3 = new SwearImage(R.drawable.swear_image_3, Side.LEFT);

    public static List<SwearImage> list = Arrays.asList(swearImage1, swearImage2, swearImage3);

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

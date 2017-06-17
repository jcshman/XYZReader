package com.example.xyzreader.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.android.volley.toolbox.NetworkImageView;

public class DynamicHeightNetworkImageView extends NetworkImageView {
    private int bitmapWidth = 100;
    private int bitmapHeight = 100;

    public DynamicHeightNetworkImageView(Context context) {
        super(context);
    }

    public DynamicHeightNetworkImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DynamicHeightNetworkImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setBitmapDimensions(int width, int height)
    {
       bitmapWidth = width;
       bitmapHeight = height;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = View.MeasureSpec.getSize(widthMeasureSpec);
        int height = View.MeasureSpec.getSize(heightMeasureSpec);

        int widthScaled = (int)(bitmapWidth * ((float)height / bitmapHeight));
        int heightScaled = (int)(bitmapHeight * ((float)width / bitmapWidth));

        if (widthScaled < width)
           setMeasuredDimension(width, heightScaled);
        else
           setMeasuredDimension(widthScaled, height);
    }
}

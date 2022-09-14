package com.moudy.awqat.ViewPagerTransformer;

import android.view.View;

import androidx.viewpager.widget.ViewPager;

public class RotateUpPageTransformer implements ViewPager.PageTransformer {
    private static final float ROTATION = -15f;

    @Override
    public void transformPage(View page, float pos ) {
        final float width = page.getWidth();
        final float height = page.getHeight();
        final float rotation = ROTATION * pos * -1.25f;

        page.setPivotX( width * 0.5f );
        page.setPivotY( height );
        page.setRotation( rotation );

    }
}
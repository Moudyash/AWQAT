package com.moudy.awqat.ViewPagerTransformer;

import android.view.View;

import androidx.viewpager.widget.ViewPager;

public class CubeOutPageTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position ) {
        // Rotate the fragment on the left or right edge
        page.setPivotX( position > 0 ? 0 : page.getWidth() );
        page.setPivotY( 0 );
        page.setRotationY( -90f * position );
    }
}
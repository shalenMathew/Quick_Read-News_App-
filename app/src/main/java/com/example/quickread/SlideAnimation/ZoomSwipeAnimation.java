package com.example.quickread.SlideAnimation;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

public class ZoomSwipeAnimation implements ViewPager.PageTransformer {

    // zoom ui

    final float minScale = 0.70f;
    final float minAlpha = 0.5f;

    @Override
    public void transformPage(@NonNull View view, float position) {
        int pageWidth =view.getWidth();
        int pageHeight = view.getHeight();
        if(position < -1){
            view.setAlpha(0f);
        }else if(position <= 1){

            float scaleFactor = Math.max(minScale, 1- Math.abs(position));
            float vertMargin = pageHeight  * (1 - scaleFactor)/2;
            float horzMargin = pageWidth  * (1 - scaleFactor)/2;

            if(position<0){
                view.setTranslationX(horzMargin - vertMargin /2);
            }else{
                view.setTranslationX(horzMargin + vertMargin /2);
            }

            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

            view.setAlpha(minAlpha + (scaleFactor - minScale)/(1-minScale) * (1-minAlpha));

        }else{
            view.setAlpha(0f);
        }


    }

}

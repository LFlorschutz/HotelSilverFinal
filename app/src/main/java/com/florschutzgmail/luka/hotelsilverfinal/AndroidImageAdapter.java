package com.florschutzgmail.luka.hotelsilverfinal;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class AndroidImageAdapter extends PagerAdapter {
    Context mContext;

    AndroidImageAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return sliderImagesId.length;
    }

    private int[] sliderImagesId = new int[]{
            R.drawable.soba5, R.drawable.soba6, R.drawable.soba7,
            R.drawable.soba8, R.drawable.soba9,R.drawable.soba4,
            R.drawable.prva, R.drawable.druga, R.drawable.treca,
            R.drawable.cetvrta, R.drawable.peta, R.drawable.sesta,
            R.drawable.osma, R.drawable.deveta, R.drawable.deseta,
            R.drawable.jedanaest, R.drawable.dvanaest, R.drawable.trinaest,
            R.drawable.cetrnaest, R.drawable.petnaest, R.drawable.sesnaest,
            R.drawable.sedamnaest,R.drawable.wc,R.drawable.soba,
            R.drawable.soba2,R.drawable.soba3,R.drawable.rec1,
            R.drawable.rec2
    };

    @Override
    public boolean isViewFromObject(View v, Object obj) {
        return v == ((ImageView) obj);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int i) {
        ImageView mImageView = new ImageView(mContext);
        mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        mImageView.setImageResource(sliderImagesId[i]);
        ((ViewPager) container).addView(mImageView, 0);
        return mImageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int i, Object obj) {
        ((ViewPager) container).removeView((ImageView) obj);
    }
}
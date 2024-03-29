package com.ads.sdk.dsdsd1s513;


import static com.ads.sdk.ds4d5.customAdData;
import static com.ads.sdk.ds4d5.getRandomNum;
import static com.ads.sdk.fdf4d46.ddddd44.getPlayStoreUrl;
import static com.ads.sdk.fdf4d46.ddddd44.openChromeCustomTabUrl;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.ads.sdk.R;
import com.ads.sdk.fdf4d46.dw4sd5sd4;
import com.ads.sdk.ds4d5;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class sdfdsf5454 {

    public static Activity activity;
    private static sdfdsf5454 mInstance;
    ImageView iv_banner;

    public sdfdsf5454(Activity activity) {
        sdfdsf5454.activity = activity;
    }

    public static sdfdsf5454 getInstance(Activity activity) {
        sdfdsf5454.activity = activity;
        if (mInstance == null) {
            mInstance = new sdfdsf5454(activity);
        }
        return mInstance;
    }

    public void showMyCustomNative(final Activity activity, ViewGroup nativeAdContainer, int type) {
        if (new dw4sd5sd4(activity).getCustomAdshowStatus().equals("0") || new dw4sd5sd4(activity).getCustomNative().equals("0")) {
            return;
        }
        gfd1g21 appModal = ds4d5.getMyCustomAd();
        int pos = getRandomNum();
        if (appModal != null) {
            View inflate = getCustomView(activity, nativeAdContainer, type);
            iv_banner = (ImageView) inflate.findViewById(R.id.iv_banner);
            Animation anim = new AlphaAnimation(0.0f, 1.0f);
            anim.setDuration(500); //You can manage the blinking time with this parameter
            anim.setStartOffset(20);
            anim.setRepeatMode(Animation.REVERSE);
            anim.setRepeatCount(Animation.INFINITE);
            try {
                Glide.with(activity).load(customAdData.get(pos).getUrl()).diskCacheStrategy(DiskCacheStrategy.ALL).listener(new RequestListener<Drawable>() {
                            @Override
                            public boolean onLoadFailed(GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                                return false;
                            }
                            @Override
                            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                return false;
                            }
                        })
                        .into(iv_banner);
                if (type == 1) {
                    Glide.with(activity).load(customAdData.get(pos).getNativeImage()).diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.drawable.img_big_native).into(iv_banner);
                } else {
                    Glide.with(activity).load(customAdData.get(pos).getSmallNativeImage()).diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.drawable.img_small_native).into(iv_banner);
                }
            } catch (Exception e) {
            }
            iv_banner.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    String action_str = customAdData.get(pos).getUrl();
                    if(action_str.startsWith("https")){
                        activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getPlayStoreUrl(action_str))));
                    } else {
                        openChromeCustomTabUrl(activity,action_str);
                    }
                }
            });
            nativeAdContainer.removeAllViews();
            nativeAdContainer.addView(inflate);
        } else {
            nativeAdContainer.setVisibility(View.GONE);
        }
    }

    private View getCustomView(Activity activity, ViewGroup nativead, int type) {
        View adView;
        switch (type) {
            case 1:
                adView = activity.getLayoutInflater().inflate(R.layout.kjjkj, null);
                break;
            case 2:
                adView = activity.getLayoutInflater().inflate(R.layout.ds1d5s, null);
                break;
            default:
                adView = activity.getLayoutInflater().inflate(R.layout.kjjkj, null);
                break;
        }
        return adView;
    }
}

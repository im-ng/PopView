/*
 *
 * Created by Ng on 24/7/19 1:26 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 24/7/19 1:26 PM
 *
 */

package com.ng28.popview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ng28.popview.databinding.ImageDialogBinding;

public class PopView extends AppCompatImageView {
    private static final String TAG = "PopView";
    private Context context;
    private String pathUrl;
    private boolean fullScreen = true;

    private ImageDialogBinding binding;
    private PopupWindow contentWindow;

    private PopView() {
        super(null);
    }

    protected PopView(Context context) {
        super(context);
        this.context = context;
        this.prepareDialog();
    }

    public PopView(PopViewBuilder builder) {
        super(builder.context);
        this.context = builder.context;
        this.pathUrl = builder.pathUrl;
        this.setFullScreen(builder.isFullScreen);
        this.prepareDialog();
    }

    public PopView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.prepareDialog();
    }

    private void prepareDialog() {
        LayoutInflater inflater = LayoutInflater.from(context);
        binding = DataBindingUtil.inflate(inflater, R.layout.image_dialog, (ViewGroup) findViewById(R.id.rootLayout), false);
        //
        binding.closeBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                contentWindow.dismiss();
            }
        });
        //
        binding.backBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                contentWindow.dismiss();
            }
        });
        //
        binding.imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                contentWindow.dismiss();
            }
        });
        //
        try {
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.drawable.ic_image);
            Glide.with(context)
                    .load(pathUrl)
                    .apply(requestOptions)
                    .into(binding.imageView);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public PopView setFullScreen(boolean flag) {
        this.fullScreen = flag;
        return this;
    }

    private PopView prepare(String pathUrl) {
        try {
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.drawable.ic_image);
            Glide.with(context)
                    .load(pathUrl)
                    .apply(requestOptions)
                    .into(binding.imageView);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        return this;
    }

    public void show() {
        DisplayMetrics metrics = new DisplayMetrics();
        ((AppCompatActivity) context).getWindowManager().getDefaultDisplay().getMetrics(metrics);
        if(fullScreen) {
            contentWindow = new PopupWindow(binding.rootLayout, metrics.widthPixels, metrics.heightPixels, true);
            contentWindow.showAtLocation(binding.rootLayout, Gravity.CENTER, 0, 0);
        } else {
            contentWindow = new PopupWindow(binding.rootLayout, metrics.widthPixels / 2, metrics.heightPixels / 2, true);
            contentWindow.showAtLocation(binding.rootLayout, Gravity.CENTER, 0, 0);
        }
    }

    private void show(String pathUrl) {
        this.prepare(pathUrl);
        this.show();
    }
}

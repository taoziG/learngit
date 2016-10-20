package com.baobaole.holder;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by sumpay on 16/7/22.
 */
public class NetworkImageHolderView implements Holder<String> {
    private  SimpleDraweeView simpleDraweeView;
    @Override
    public View createView(Context context) {
        simpleDraweeView = new SimpleDraweeView(context);
        simpleDraweeView.setScaleType(ImageView.ScaleType.FIT_XY);
        return simpleDraweeView;
    }

    @Override
    public void UpdateUI(Context context, int position, String data) {
        Uri uri = Uri.parse(data);
        simpleDraweeView.setImageURI(uri);
    }
}

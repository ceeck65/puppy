package io.github.ceeck65.android.puppy.Picasso;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by mariofernandez on 8/8/16.
 */

public class PicassoClient {

    public static void loadPicasso(Context context, String url, ImageView imageView)
    {
        if (url != null && url.length() > 0)
        {
            Picasso.with(context).load(url).placeholder(android.R.drawable.btn_plus).into(imageView);

        } else
        {
            Picasso.with(context).load(url).into(imageView);
        }

    }

}

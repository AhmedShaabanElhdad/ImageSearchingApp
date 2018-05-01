package algawhar.com.imagesearchingapp;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class PicassoLoader {

    public static void LoadPhoto(final Context context, final String url, final ImageView img_product_photo) {

        Picasso.with(context)
                .load(url)
                .centerCrop()
                .fit()
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(img_product_photo, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {
                        //Try again online if cache failed
                        Log.e("url",url);
                        Picasso.with(context)
                                .load(url)
                                .error(R.drawable.loading_error)
                                .into(img_product_photo, new Callback() {
                                    @Override
                                    public void onSuccess() {

                                    }

                                    @Override
                                    public void onError() {
                                        Log.v("Picasso","Could not fetch image");
                                    }
                                });
                    }
                });
    }

    public static void LoadPhoto(final Context context, final String url, final ImageView img_product_photo, final int width , final int height) {

        Picasso.with(context)
                .load(url)
                .resize(width,height)
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(img_product_photo, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {
                        //Try again online if cache failed
                        Picasso.with(context)
                                .load(url)
                                .error(R.drawable.loading_error)
                                .resize(width,height)
                                .into(img_product_photo, new Callback() {
                                    @Override
                                    public void onSuccess() {

                                    }

                                    @Override
                                    public void onError() {
                                        Log.v("Picasso","Could not fetch image");
                                    }
                                });
                    }
                });
    }

}

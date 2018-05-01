package algawhar.com.imagesearchingapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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
                        Log.e("url", url);
                        Picasso.with(context)
                                .load(url)
                                .error(R.drawable.loading_error)
                                .into(img_product_photo, new Callback() {
                                    @Override
                                    public void onSuccess() {

                                    }

                                    @Override
                                    public void onError() {
                                        Log.v("Picasso", "Could not fetch image");
                                    }
                                });
                    }
                });
    }

    public static void LoadPhoto(final Context context, final String url, final ImageView img_product_photo, final int width, final int height) {

        Picasso.with(context)
                .load(url)
                .resize(width, height)
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
                                .resize(width, height)
                                .into(img_product_photo, new Callback() {
                                    @Override
                                    public void onSuccess() {

                                    }

                                    @Override
                                    public void onError() {
                                        Log.v("Picasso", "Could not fetch image");
                                    }
                                });
                    }
                });
    }


    //save image
    public static void imageDownload(Context ctx, String downloadurl, String url){
        Picasso.with(ctx)
                .load(downloadurl)
                .into(getTarget(url));
    }

    //target to save
    private static Target getTarget(final String file_name){
        Target target = new Target(){

            @Override
            public void onBitmapLoaded(final Bitmap bitmap, Picasso.LoadedFrom from) {
                new Thread(new Runnable() {

                    @Override
                    public void run() {

                        File file = new File(Environment.getExternalStorageDirectory().getPath() + "/" + file_name);
                        try {
                            file.createNewFile();
                            FileOutputStream ostream = new FileOutputStream(file);
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, ostream);
                            ostream.flush();
                            ostream.close();
                        } catch (IOException e) {
                            Log.e("IOException", e.getLocalizedMessage());
                        }
                    }
                }).start();

            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        };
        return target;
    }

}

package algawhar.com.imagesearchingapp.viewsHolder;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import algawhar.com.imagesearchingapp.Constants;
import algawhar.com.imagesearchingapp.Model.Image;
import algawhar.com.imagesearchingapp.PicassoLoader;
import algawhar.com.imagesearchingapp.R;


public class ImageHolder extends RecyclerView.ViewHolder {
    private ImageView mImageView,img_download;
    private ProgressBar mProgressBar;
    private Activity mContext;
    private LinearLayout linear_img_data;
    private TextView txt_num_likes;
    private TextView txt_desc;
    View itemView;

    public ImageHolder(View itemView, Activity context) {
        super(itemView);
        mImageView= (ImageView) itemView.findViewById(R.id.order_image);
        img_download= (ImageView) itemView.findViewById(R.id.img_download);
        mProgressBar= (ProgressBar) itemView.findViewById(R.id.progressBar_image);

        linear_img_data = (LinearLayout)itemView.findViewById(R.id.linear_img_data);
        txt_num_likes = (TextView)itemView.findViewById(R.id.txt_likes);
        txt_desc = (TextView)itemView.findViewById(R.id.txt_desc);
        mContext=context;
        this.itemView=itemView;

    }

    public void bind(final Image image ) {
        if (!image.getUrls().equals(null)) {
            PicassoLoader.LoadPhoto(mContext,image.getUrls(),mImageView);
        }

        img_download.bringToFront();

        txt_num_likes.setText(String.valueOf(image.getLikes()));
        txt_desc.setText(image.getDescription());

        itemView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        linear_img_data.setVisibility(View.VISIBLE);
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        linear_img_data.setVisibility(View.GONE);
                        break;
                    case MotionEvent.ACTION_UP:
                        linear_img_data.setVisibility(View.GONE);
                        break;
                }
                return true;
            }
        });

        img_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu=new PopupMenu(mContext,v);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId())
                        {
                            case R.id.download:
                                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                                    PicassoLoader.imageDownload(mContext,image.getUrls(),image.getId());
                                } else {
                                    askForPermission(mContext,Manifest.permission.WRITE_EXTERNAL_STORAGE, 101,image);
                                }

                        }
                        return true;
                    }
                });
                popupMenu.show();

            }
        });


    }

    private void askForPermission(Activity activity, String permission, int requestCode,Image image) {
        if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {

                //This is called if user has denied the permission before
                //In this case I am just asking the permission again
                ActivityCompat.requestPermissions(activity, new String[]{permission}, requestCode);

            } else {
                ActivityCompat.requestPermissions(activity, new String[]{permission}, requestCode);
            }
        } else {
            PicassoLoader.imageDownload(mContext,image.getUrls(),image.getId());
            Toast.makeText(activity, "" + permission + " is already granted.", Toast.LENGTH_SHORT).show();
        }
    }




}

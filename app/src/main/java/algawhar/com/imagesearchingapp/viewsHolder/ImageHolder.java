package algawhar.com.imagesearchingapp.viewsHolder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import algawhar.com.imagesearchingapp.Model.Image;
import algawhar.com.imagesearchingapp.PicassoLoader;
import algawhar.com.imagesearchingapp.R;


public class ImageHolder extends RecyclerView.ViewHolder {
    private ImageView mImageView;
    private ProgressBar mProgressBar;
    private Context mContext;
    private LinearLayout linear_img_data;
    private TextView txt_num_likes;
    private TextView txt_desc;
    View itemView;

    public ImageHolder(View itemView, Context context) {
        super(itemView);
        mImageView= (ImageView) itemView.findViewById(R.id.order_image);
        mProgressBar= (ProgressBar) itemView.findViewById(R.id.progressBar_image);

        linear_img_data = (LinearLayout)itemView.findViewById(R.id.linear_img_data);
        txt_num_likes = (TextView)itemView.findViewById(R.id.txt_likes);
        txt_desc = (TextView)itemView.findViewById(R.id.txt_desc);
        mContext=context;
        this.itemView=itemView;

    }

    public void bind(Image image ) {
        if (!image.getUrls().equals(null)) {
            PicassoLoader.LoadPhoto(mContext,image.getUrls(),mImageView);
        }

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
    }
}

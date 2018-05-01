package algawhar.com.imagesearchingapp.Adpters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import algawhar.com.imagesearchingapp.Model.Image;
import algawhar.com.imagesearchingapp.R;
import algawhar.com.imagesearchingapp.viewsHolder.ImageHolder;


public class ImagesAdpter extends RecyclerView.Adapter<ImageHolder> {
    private List<Image> images=new ArrayList<>();
    private Activity mContext;


    public ImagesAdpter(List<Image> images, Activity context){
        this.images=images;
        mContext=context;
    }


    @Override
    public ImageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.image_view,parent,false);
        return new ImageHolder(view,mContext);
     }

    @Override
    public void onBindViewHolder(ImageHolder holder, int position) {
     holder.bind(images.get(position));
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public void setImages(List<Image> images) {
        for(Image image:images) {
            this.images.add(image);
        }
    }
}

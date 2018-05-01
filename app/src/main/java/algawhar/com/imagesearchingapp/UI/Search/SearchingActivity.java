package algawhar.com.imagesearchingapp.UI.Search;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import algawhar.com.imagesearchingapp.Adpters.ImagesAdpter;
import algawhar.com.imagesearchingapp.Model.Image;
import algawhar.com.imagesearchingapp.PicassoLoader;
import algawhar.com.imagesearchingapp.R;

/**
 * Created by mohamed on 30/04/2018.
 */

public class SearchingActivity extends AppCompatActivity implements SearchingView {

    ProgressDialog progressDialog;
    RecyclerView recyclerView;
    ImagesAdpter adpter;
    List<Image> images;
    String query;
    boolean isLoading = false, isLastPage = false;
    int pageNum = 1;


    SearchingPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        query = getIntent().getExtras().getString("query", "");

        initview();

        presenter = new SearchingPresenterImpl(this, new SearchingModelInteractorImpl());
    }

    private void initview() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading");

        recyclerView = (RecyclerView) findViewById(R.id.recycler_images);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false));
        images = new ArrayList<>();
        adpter = new ImagesAdpter(images, this);
        recyclerView.setAdapter(adpter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                LinearLayoutManager layoutManager = LinearLayoutManager.class.cast(recyclerView.getLayoutManager());


                int totalItemCount = layoutManager.getItemCount();
                int lastVisible = layoutManager.findLastVisibleItemPosition();
                int visibleItemCount = layoutManager.getChildCount();
                int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();


                Log.e("isLoading", isLoading + "");
                Log.e("isLastPage", isLastPage + "");
                Log.e("isLastPage", isLastPage + "");
                Log.e("isLastPage", ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount) + "");
                Log.e("isLastPage", (firstVisibleItemPosition >= 0) + "");

                if (!isLoading && !isLastPage) {
                    if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount && firstVisibleItemPosition >= 0) {
                        presenter.search(query, pageNum);
                    }
                }
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.onResume();
        presenter.search(query, pageNum);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void showProgress() {
        //progressDialog.show();
    }

    @Override
    public void hideProgress() {
        //progressDialog.dismiss();
    }

    @Override
    public void getImage(List<Image> images) {
        adpter.setImages(images);
//        adpter = new ImagesAdpter(images, SearchingActivity.this);
//        recyclerView.setAdapter(adpter);
        adpter.notifyDataSetChanged();
        recyclerView.setAdapter(adpter);

        pageNum++;
        isLoading =false;
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}

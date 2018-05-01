package algawhar.com.imagesearchingapp.UI.Search;

import android.util.Log;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import algawhar.com.imagesearchingapp.Constants;
import algawhar.com.imagesearchingapp.Model.Image;
import algawhar.com.imagesearchingapp.Model.Result;
import algawhar.com.imagesearchingapp.Retrofit.KUMInterface;
import algawhar.com.imagesearchingapp.Retrofit.ResultImageModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchingModelInteractorImpl implements SearchingModelInteractor {

    @Override
    public void search(final OnFinishedListener listener, String query) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.DOMAIN)
                .build();

        KUMInterface kumInterface = retrofit.create(KUMInterface.class);
        Call<ResultImageModel> connection = kumInterface.Search(query,Constants.accessKey);
        Log.e("connection",connection.request().url().toString());
        connection.enqueue(new Callback<ResultImageModel>() {
            @Override
            public void onResponse(Call<ResultImageModel> call, retrofit2.Response<ResultImageModel> response) {

                Log.e("response",new GsonBuilder().setPrettyPrinting().create().toJson(response));
                Log.e("url",response.raw().request().url()+"");

                List<Image> images=new ArrayList<Image>();

                for (Result result : response.body().getResults()) {
                    String id = result.getId();
                    String small = result.getUrls().getSmall();
                    int likes=result.getLikes();
                    String description=result.getDescription();
                    if (description==null)
                        description="Not Description Found";
                    images.add(new Image(small,id,description,likes));
                }

                listener.onFinished(images);

            }

            @Override
            public void onFailure(Call<ResultImageModel> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }
}

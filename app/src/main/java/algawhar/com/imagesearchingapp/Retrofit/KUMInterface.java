package algawhar.com.imagesearchingapp.Retrofit;


import algawhar.com.imagesearchingapp.Constants;
import algawhar.com.imagesearchingapp.Model.Result;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ahmed Shaban on 30/04/2018.
 */

public interface KUMInterface {


    @GET(Constants.Search)
    Call<ResultImageModel> Search(
            @Query("query") String query,
            @Query("client_id") String client_id
    );


}

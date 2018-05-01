package algawhar.com.imagesearchingapp.UI.Search;

import java.util.List;

import algawhar.com.imagesearchingapp.Model.Image;


public interface SearchingModelInteractor {

    interface OnFinishedListener {

        void onFinished(List<Image> images);

        void onError(String msg);
    }

    void search(OnFinishedListener listener, String query);
}

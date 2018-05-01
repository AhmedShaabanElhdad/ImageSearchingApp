package algawhar.com.imagesearchingapp.UI.Search;

import java.util.List;

import algawhar.com.imagesearchingapp.Model.Image;

public interface SearchingView {

    void showProgress();

    void hideProgress();

    void getImage(List<Image> images);

    void showMessage(String msg);


}

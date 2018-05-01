
package algawhar.com.imagesearchingapp.UI.Search;

import java.util.List;

import algawhar.com.imagesearchingapp.Model.Image;

public class SearchingPresenterImpl implements SearchingPresenter, SearchingModelInteractor.OnFinishedListener {

    private SearchingView mainView;
    private SearchingModelInteractor findItemsInteractor;

    public SearchingPresenterImpl(SearchingView mainView, SearchingModelInteractor findItemsInteractor) {
        this.mainView = mainView;
        this.findItemsInteractor = findItemsInteractor;
    }

    @Override public void onResume() {
        if (mainView != null) {
            mainView.showProgress();
        }
    }




    @Override public void onDestroy() {
        mainView = null;
    }

    @Override
    public void search(String query) {
        findItemsInteractor.search(this,query);
    }

    @Override
    public void onFinished(List<Image> images) {
        if (mainView != null) {
            mainView.getImage(images);
            mainView.hideProgress();
        }

    }

    @Override
    public void onError(String msg) {
        mainView.showMessage(msg);
    }
}

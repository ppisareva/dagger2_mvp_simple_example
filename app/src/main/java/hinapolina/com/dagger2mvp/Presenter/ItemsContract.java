package hinapolina.com.dagger2mvp.Presenter;

import java.util.List;

import hinapolina.com.dagger2mvp.Data.Item;
import hinapolina.com.dagger2mvp.View.BasicView;

/**
 * Created by polina on 4/15/18.
 */

public interface ItemsContract {
     interface View extends BasicView<Presenter>
    {
        void showItems(List<Item> itemList);
        void showLoadingItemsError();

    }


    interface Presenter extends BasePresenter {

        void loadItems();
        void takeView(ItemsContract.View view);

        void dropView();

    }
}

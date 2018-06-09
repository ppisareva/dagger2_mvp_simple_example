package hinapolina.com.dagger2mvp.Data;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by polina on 4/15/18.
 */

public interface ItemDataSource {

    interface LoadItemsCallback {

        void onItemLoaded(List<Item> itemList);

        void onDataNotAvailable();
    }


    void getItems(@NonNull LoadItemsCallback callback);
    void deleteAllItems();
    void saveItems(List <Item> items);

}

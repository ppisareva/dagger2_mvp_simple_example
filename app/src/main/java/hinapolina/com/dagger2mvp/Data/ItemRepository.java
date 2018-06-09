package hinapolina.com.dagger2mvp.Data;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ItemRepository implements ItemDataSource {

    private static ItemRepository INSTANCE = null;
    ItemDataSource itemLocalDataSource;
    ItemDataSource itemRemoteDataSource;
    boolean firstLoad = true;
@Inject
    public ItemRepository(@Local ItemDataSource itemLocalDS,
                            @Remote ItemDataSource itemRemoteDS) {
        itemLocalDataSource = itemLocalDS;
        itemRemoteDataSource = itemRemoteDS;
          }



    @Override
    public void getItems(@NonNull LoadItemsCallback callback) {

      if(firstLoad)getItemsFromLocalDataSource(callback);
      else getItemsFromRemoteDataSource(callback);

    }



    @Override
    public void deleteAllItems() {
        itemLocalDataSource.deleteAllItems();
        itemRemoteDataSource.deleteAllItems();
    }

    @Override
    public void saveItems(List<Item> items) {
        itemRemoteDataSource.saveItems(items);
        itemLocalDataSource.saveItems(items);

    }

    private void getItemsFromLocalDataSource(final LoadItemsCallback callback) {
        itemLocalDataSource.getItems(new LoadItemsCallback() {
            @Override
            public void onItemLoaded(List<Item> itemList) {
                callback.onItemLoaded(new ArrayList<>(itemList));
            }

            @Override
            public void onDataNotAvailable() {
               getItemsFromRemoteDataSource(callback);
            }
        });

    }

    private void getItemsFromRemoteDataSource(final LoadItemsCallback callback) {
        itemRemoteDataSource.getItems(new LoadItemsCallback() {
            @Override
            public void onItemLoaded(List<Item> itemList) {
                refreshLocalDataSource(itemList);
                callback.onItemLoaded(new ArrayList<>(itemList));
                firstLoad = false;
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();

            }
        });
    }

    private void refreshLocalDataSource(List<Item> itemList) {
        itemLocalDataSource.deleteAllItems();
        itemLocalDataSource.saveItems(itemList);
    }


}

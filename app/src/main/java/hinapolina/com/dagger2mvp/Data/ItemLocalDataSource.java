package hinapolina.com.dagger2mvp.Data;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import hinapolina.com.dagger2mvp.Utils.AppExecutors;


/**
 * Created by polina on 4/15/18.
 */
@Singleton
public class ItemLocalDataSource implements ItemDataSource {


    private AppExecutors mAppExecutors;



    @Inject
    public ItemLocalDataSource(@NonNull AppExecutors executors) {

        mAppExecutors = executors;
    }

    @Override
    public void getItems(@NonNull final LoadItemsCallback callback) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // suger orm
                final List<Item> items = Item.listAll(Item.class);
                mAppExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        if (items.isEmpty()) {
                            // This will be called if the table is new or just empty.
                            callback.onDataNotAvailable();
                        } else {
                            callback.onItemLoaded(items);
                        }
                    }
                });
            }
        };

        mAppExecutors.diskIO().execute(runnable);

    }

    @Override
    public void deleteAllItems() {
        Runnable deleteRunnable = new Runnable() {
            @Override
            public void run() {
                // suger orm
                Item.deleteAll(Item.class);

            }
        };

        mAppExecutors.diskIO().execute(deleteRunnable);
    }

    @Override
    public void saveItems(final List<Item> items) {
        Runnable saveRunnable = new Runnable() {
            @Override
            public void run() {
                // suger orm
                Item.saveInTx(items);
            }
        };

        mAppExecutors.diskIO().execute(saveRunnable);
    }
}

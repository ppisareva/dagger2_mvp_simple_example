package hinapolina.com.dagger2mvp.Presenter;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

import hinapolina.com.dagger2mvp.Data.Item;
import hinapolina.com.dagger2mvp.Data.ItemDataSource;
import hinapolina.com.dagger2mvp.Data.ItemRepository;

/**
 * Created by polina on 4/15/18.
 */

public class ItemPresenter implements ItemsContract.Presenter {
@Nullable
    ItemsContract.View itemView;
    ItemRepository itemRepository;
   @Inject
   ItemPresenter(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void start() {
        loadItems();
    }


    @Override
    public void loadItems() {
        itemRepository.getItems(new ItemDataSource.LoadItemsCallback() {
            @Override
            public void onItemLoaded(List<Item> itemList) {
                if(itemView!=null)itemView.showItems(itemList);
            }

            @Override
            public void onDataNotAvailable() {
              if(itemView!=null) itemView.showLoadingItemsError();
            }
        });

    }

    @Override
    public void takeView(ItemsContract.View view) {
        this.itemView = view;

    }

    @Override
    public void dropView() {
       itemView=null;
    }
}

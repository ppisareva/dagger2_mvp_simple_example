package hinapolina.com.dagger2mvp.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import hinapolina.com.dagger2mvp.Data.Item;
import hinapolina.com.dagger2mvp.Presenter.ItemPresenter;
import hinapolina.com.dagger2mvp.Presenter.ItemsContract;
import hinapolina.com.dagger2mvp.R;

public class MainActivity extends AppCompatActivity implements ItemsContract.View {
    @BindView(R.id.item_RV)
    RecyclerView rvItems;
    ArrayList<Item> items = new ArrayList<>();
    @Inject
    ItemsContract.Presenter presenter;
    @Inject
    ItemPresenter itemPresenter;
    ItemsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // set up adapter
        adapter = new ItemsAdapter(items, this);
        rvItems.setAdapter(adapter);
        rvItems.setLayoutManager(new LinearLayoutManager(this));
        presenter.loadItems();


    }



    @Override
    public void onDestroy() {
        super.onDestroy();
          //prevent leaking activity in
        // case presenter is orchestrating a long running task
        presenter.dropView();
    }

    @Override
    public void setPresenter(ItemsContract.Presenter presenter) {
        if(presenter!=null) this.presenter = presenter;
    }

    @Override
    public void showItems(List<Item> itemList) {
        items.clear();
        items.addAll(itemList);
        adapter.notifyDataSetChanged();


    }

    @Override
    public void showLoadingItemsError() {
        Toast.makeText(this, R.string.error, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.takeView(this);
        presenter.start();
    }
}

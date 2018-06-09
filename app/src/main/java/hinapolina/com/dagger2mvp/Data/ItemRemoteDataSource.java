package hinapolina.com.dagger2mvp.Data;

import android.os.Handler;
import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import hinapolina.com.dagger2mvp.Utils.Utils;

/**
 * Created by polina on 4/15/18.
 */

// todo fetch real data
    @Singleton
public class ItemRemoteDataSource implements ItemDataSource {

    public static final String BASE_API_URL = "https://api.themoviedb.org/3/";
    private static final String QUERY_PARAM_KEY = "api_key";
    private static final long SERVICE_LATENCY_IN_MILLIS = 5000;
    private static ItemRemoteDataSource INSTANCE;
    APIService apiService;



@Inject
    public ItemRemoteDataSource() {
       // this.apiService = apiService;
    }



    @Override
    public void getItems(@NonNull final LoadItemsCallback callback) {
        // todo
        Map<String, String> queryMap = new HashMap<>();
//        retrofit2.Call<Response> call =
//                apiService.allItems("a07e22bc18f5cb106bfe4cc1f83ad8ed");

        // Simulate network by delaying the execution.
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.onItemLoaded(Utils.getList());
            }
        }, SERVICE_LATENCY_IN_MILLIS);
    }

    @Override
    public void deleteAllItems() {

    }

    @Override
    public void saveItems(List<Item> items) {

    }


}

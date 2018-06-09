package hinapolina.com.dagger2mvp.Data;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by polina on 4/15/18.
 */

public interface APIService {

    @GET("movie/now_playing")
    Call<Response> allItems(@Query("api_key") String key);

}

package developer.nitish.com.test;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by lenovo on 11/30/2016.
 */

public interface ApiInterface {
    @GET("/posts/")
    Call<List<DataModel>> getData();
}

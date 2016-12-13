package developer.nitish.com.test;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lenovo on 11/30/2016.
 */
//
//public class ApiClient {
//
//    public static final String BASE_URL = "http://jsonplaceholder.typicode.com/posts/";
//    private static Retrofit retrofit = null;
//
//
//    public static Retrofit getClient() {
//        if (retrofit==null) {
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//        }
//        return retrofit;
//    }
//}

public class ApiClient {
    public final static String domain = "http://jsonplaceholder.typicode.com";
//    public final static String path = ":3000/";
    public static OkHttpClient okClient = new OkHttpClient.Builder()

            .addInterceptor(
                    new Interceptor() {
                        @Override
                        public Response intercept(Interceptor.Chain chain) throws IOException {
                            Request original = chain.request();

                            // Request customization: add request headers
                            Request.Builder requestBuilder = original.newBuilder().method(original.method(), original.body());

                            Request request = requestBuilder.build();
//                            PrintO.log("GET CALLS : "+chain.request().url().toString());
//                            PrintO.log("Request__: "+request.headers().toString()+" : "+request.body().toString()+" : " +chain.request().headers().toString()+" : "+chain.request().body().toString());
                            return chain.proceed(request);
                        }
                    })
            .build();

    public static Retrofit builder = new Retrofit.Builder().
            baseUrl(domain).addConverterFactory(GsonConverterFactory.create()).client(okClient).build();
    public static ApiInterface createService(){
        return builder.create(ApiInterface.class);
    }

}
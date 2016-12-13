package developer.nitish.com.test;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();

        listView = (ListView) findViewById(R.id.listview);

        getData();
    }

    public void getData(){
//        ApiInterface apiservice = (ApiInterface) ApiClient.createService();

        Call<List<DataModel>> call = ((ApiInterface) ApiClient.createService()).getData();
        call.enqueue(new Callback<List<DataModel>>() {
            @Override
            public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response) {
                List<DataModel> dataModel = response.body();
                System.out.println("Response : "+dataModel.get(0).getBody());
                ListAdapter listAdapter = new ListAdapter(context,dataModel);
                listView.setAdapter(listAdapter);

            }

            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t) {
                System.out.println("Failed"+t.getLocalizedMessage());
                Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

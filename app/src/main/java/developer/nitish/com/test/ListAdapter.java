package developer.nitish.com.test;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lenovo on 11/30/2016.
 */

public class ListAdapter extends BaseAdapter{
    private Context mContext;
    private LayoutInflater mInflater;
    List<DataModel> data;

    public ListAdapter(Context context, List<DataModel> dataModel) {
        mContext = context;
        data = dataModel;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        TextView title,body,id;
        LinearLayout itemlay;

        View rowView = mInflater.inflate(R.layout.listitem, viewGroup, false);

        title = (TextView) rowView.findViewById(R.id.titleTxt);
        body = (TextView) rowView.findViewById(R.id.bodyTxt);
        id = (TextView) rowView.findViewById(R.id.idTxt);
        itemlay = (LinearLayout) rowView.findViewById(R.id.itemlay);

        try {
            System.out.println("Response A: "+data.get(i).getTitle());
            title.setText(data.get(i).getTitle());
            body.setText(data.get(i).getBody());
            id.setText(""+data.get(i).getId());
        }
        catch (Exception e){
            e.getLocalizedMessage();
        }

        itemlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,DetailsActivity.class);
                intent.putExtra("title",data.get(i).getTitle());
                intent.putExtra("body",data.get(i).getBody());
                intent.putExtra("id",data.get(i).getId().toString());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });

        return rowView;
    }


}

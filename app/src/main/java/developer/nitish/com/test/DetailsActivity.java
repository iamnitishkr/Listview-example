package developer.nitish.com.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    TextView title,body,id;
    EditText titleEt,bodyEt,idEt;
    String titleStr,bodyStr,idStr;
    ImageView titleEditIcon,bodyEditIcon,idEditIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        title = (TextView) findViewById(R.id.titleTxt);
        body = (TextView) findViewById(R.id.bodyTxt);
        id = (TextView) findViewById(R.id.idTxt);
        titleEt = (EditText) findViewById(R.id.titleEt);
        bodyEt = (EditText) findViewById(R.id.bodyEt);
        idEt = (EditText) findViewById(R.id.idEt);
        titleEditIcon = (ImageView) findViewById(R.id.titleIcon);
        bodyEditIcon = (ImageView) findViewById(R.id.bodyIcon);
        idEditIcon = (ImageView) findViewById(R.id.idIcon);

        titleStr = getIntent().getStringExtra("title");
        bodyStr = getIntent().getStringExtra("body");
        idStr = getIntent().getStringExtra("id");

        setData();

        titleEditIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titleEt.setEnabled(true);
                titleEt.requestFocus();
            }
        });
        bodyEditIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bodyEt.setEnabled(true);
                bodyEt.requestFocus();
            }
        });
        idEditIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idEt.setEnabled(true);
                idEt.requestFocus();
            }
        });
    }

    public void setData(){
        title.setText(titleStr);
        body.setText(bodyStr);
        id.setText(""+idStr);

        titleEt.setText(titleStr);
        bodyEt.setText(bodyStr);
        idEt.setText(""+idStr);
    }
}

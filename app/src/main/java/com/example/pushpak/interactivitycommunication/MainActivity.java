package com.example.pushpak.interactivitycommunication;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private View view;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        
        ((TextView)findViewById(R.id.txtDate)).setText(new SimpleDateFormat("dd MMM yyyy").format(new Date()));
    }

    public void goNext(View view){
        Class cls=NextActivity.class;
        Bundle bundle=new Bundle();
        bundle.putString("interactkeydate",((TextView)findViewById(R.id.txtDate)).getText().toString());
        

        Intent intent=new Intent(this,cls);
        intent.putExtras(bundle);
        startActivity(intent);
        startActivityForResult(intent,1007);


        
    }



    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
              super.onActivityResult(requestCode, resultCode, data);

                        if(requestCode == 1007) {
                        if(resultCode == RESULT_OK) {

                                      if(data != null) {

                                             Bundle bundle=data.getExtras();
                                        int img = bundle.getInt("keyImg");
                                        ((ImageView)findViewById(R.id.imagePhone)).setImageResource(img);
                                    }
                          }
                   }
    }
}

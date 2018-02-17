package com.a5.ngenemichael.quotes;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class SingleView extends AppCompatActivity implements View.OnClickListener{
    TextView tv , author , nom;    AllQuotes aq; ImageView bf,ff,nextrandom,share;int p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_view);
        aq = new AllQuotes();
        tv = (TextView)findViewById(R.id.singleq);
        nom = (TextView)findViewById(R.id.no);
        author = (TextView)findViewById(R.id.author);
       // CardView cv = (CardView)findViewById(R.id.card_view);

       // assert cv != null;
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String text = aq.greatness[p]+" -" + aq.names[p];
                setClipborad(v.getContext(),text);
                return false;
            }
        });

        bf = (ImageView) findViewById(R.id.bf);
        ff = (ImageView) findViewById(R.id.ff);
        nextrandom = (ImageView) findViewById(R.id.random);
        share = (ImageView) findViewById(R.id.share);

        ff.setOnClickListener(this);
        bf.setOnClickListener(this);
        nextrandom.setOnClickListener(this);
        share.setOnClickListener(this);



        Intent i = getIntent();

        p = i.getIntExtra("key",0);
        tv.setText(aq.greatness[p]);
        author.setText(aq.names[p]);
        nom.setText(String.valueOf(p+1));


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bf:
                p--;
                if (p<=-1){
                    p = aq.greatness.length-1;
                }
               // Toast.makeText(SingleView.this, String.valueOf(p), Toast.LENGTH_SHORT).show();
                tv.setText(aq.greatness[p]);
                author.setText(aq.names[p]);
                nom.setText(String.valueOf(p+1));
                break;
            case R.id.ff:
                p++;
                if (p>=aq.greatness.length-1){
                    p = 0;
                }
                //Toast.makeText(SingleView.this, String.valueOf(p), Toast.LENGTH_SHORT).show();
                tv.setText(aq.greatness[p]);
                author.setText(aq.names[p]);
                nom.setText(String.valueOf(p+1));
                break;
            case R.id.random:
                p = new Random().nextInt(aq.greatness.length);
                tv.setText(aq.greatness[p]);
                author.setText(aq.names[p]);
                nom.setText(String.valueOf(p+1));
                break;
            case R.id.share:

                Intent share= new Intent();
                share.setAction(Intent.ACTION_SEND);
                share.putExtra(Intent.EXTRA_TEXT,aq.greatness[p]+" -"+ aq.names[p]);
                share.setType("text/plain");
                startActivity(share);
                break;
        }
    }

    private  void setClipborad(Context c, String text){
        if(Build.VERSION.SDK_INT< Build.VERSION_CODES.HONEYCOMB){
            android.text.ClipboardManager clipboard = (android.text.ClipboardManager)c.getSystemService(c.CLIPBOARD_SERVICE);
            clipboard.setText(text);
        }else{
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager)c.getSystemService(c.CLIPBOARD_SERVICE);
            android.content.ClipData clip = android.content.ClipData.newPlainText("text",text);
            clipboard.setPrimaryClip(clip);
        }
        Toast.makeText(SingleView.this, "Copied to ClipBoard", Toast.LENGTH_SHORT).show();
    }
}

package com.a5.ngenemichael.quotes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycler;
    private List<Quotes> mList= new ArrayList<>();
    private RecyclerViewAd myAdapter;
    ArrayAdapter<String> mAdapter;
   // ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myAdapter = new RecyclerViewAd(mList);
        recycler = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager manager =new LinearLayoutManager(getApplicationContext());
        recycler.setLayoutManager(manager);
        recycler.setAdapter(myAdapter);
        recycler.setItemAnimator(new DefaultItemAnimator());


       // lv = (ListView)findViewById(R.id.listView);
        AllQuotes alq= new AllQuotes();
        ArrayList<String>  searchQuotes = new ArrayList<>();
        searchQuotes.addAll(Arrays.asList(alq.getGreatness()));
        mAdapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,searchQuotes);

        //lv.setAdapter(mAdapter);
      //  lv.setVisibility(View.GONE);

        prepareloading();
    }

    private void prepareloading() {
            AllQuotes alq= new AllQuotes();
        Quotes quotes;

        for (int i = 0; i <alq.names.length; i++) {
                quotes = new Quotes(alq.greatness[i],alq.names[i],String.valueOf(i+1),R.drawable.abc_btn_rating_star_off_mtrl_alpha);
            mList.add(quotes);
        }
        myAdapter.notifyDataSetChanged();
    }


    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search,menu);
        MenuItem item = menu.findItem(R.id.serviceSearch);
        SearchView searchView = (SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;

            }

            @Override
            public boolean onQueryTextChange(String newText) {
               // lv.setVisibility(View.VISIBLE);
               // mAdapter.getFilter().filter(newText);

                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public MenuInflater getMenuInflater() {
        return super.getMenuInflater();
    }

   public void search(){
       SearchView searchView = (SearchView)findViewById(R.id.view3);
       assert searchView != null;
       searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
           @Override
           public boolean onQueryTextSubmit(String query) {
               return false;
           }

           @Override
           public boolean onQueryTextChange(String newText) {

               return false;
           }
       });


   }


*/
}

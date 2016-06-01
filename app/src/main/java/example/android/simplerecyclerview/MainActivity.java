package example.android.simplerecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  public GridLayoutManager gManager;
  public MainGridAdapter mAdapter;
  RecyclerView mView;
  ArrayList<mObject> mArray;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mView = (RecyclerView) findViewById(R.id.main_recyclerView);
    mArray = new ArrayList<>();

    addElementsToArray();

    int gridRows = getApplicationContext().getResources().getInteger(R.integer.grid_columns);

    gManager = new GridLayoutManager(getApplicationContext(), gridRows);

    mView.setLayoutManager(gManager);

    mAdapter = new MainGridAdapter(this, getApplicationContext());

    mAdapter.addItems(mArray);

    mView.setAdapter(mAdapter);




  }

  public void addElementsToArray() {
    mArray.clear();
    mArray.add(new mObject("Cute Kitty", "http://www.wallhd4.com/wp-content/uploads/2016/03/cute-kitty-37.jpeg"));
    mArray.add(new mObject("Cute",
        "http://deskbg.com/s3/wpp/18/18180/sad-cute-kitty-desktop-background.jpg"));
    mArray.add(new mObject("Aw",
        "http://www.petsftw.com/wp-content/uploads/2016/03/cutecat.jpg"));
    mArray.add(new mObject("hawt",
        "https://s-media-cache-ak0.pinimg.com/736x/f0/26/05/f0260599e1251c67eefca31c02a19a81.jpg"));
    mArray.add(new mObject(":o",
        "http://www.borongaja.com/data_images/out/7/600947-cute-cat.jpg"));
    mArray.add(new mObject(":3",
        "http://cdn.cutestpaw.com/wp-content/uploads/2013/01/l-Heres-a-cute-cat-for-you.jpg"));

  }



}

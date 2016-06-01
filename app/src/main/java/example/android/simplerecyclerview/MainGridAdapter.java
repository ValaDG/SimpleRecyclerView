package example.android.simplerecyclerview;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Valerio on 01/06/2016.
 */
public class MainGridAdapter extends RecyclerView.Adapter<MainGridAdapter.RecyclerViewHolder> {

  private static LayoutInflater inflater = null;
  public ArrayList<mObject> mArray;
  Context context;


  public MainGridAdapter(Activity activity, Context context) {

    this.mArray = new ArrayList<>();
    this.context = context;
    inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  }


  @Override
  public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    View view = inflater.inflate(R.layout.single_item, parent, false);

    return new RecyclerViewHolder(view);
  }

  @Override
  public void onBindViewHolder(RecyclerViewHolder holder, int position) {

    holder.rvText.setText(mArray.get(position).getCatDescription());
    Picasso.with(context).load(mArray.get(position).getCatUrl()).fit().into(holder.rvImage);

  }


  @Override
  public int getItemCount() {
    return mArray.size();
  }

  // helper method to manipulate the internal Array from the Main Activity
  public void addItems(ArrayList<mObject> cats) {
    mArray.addAll(cats);
    notifyDataSetChanged();
  }



  //ViewHolder class
  public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

    // Declare the Views
    ImageView rvImage;
    TextView rvText;

    // In the constructor for the ViewHolder class, we pass in a view, and send it to our superclass.
    public RecyclerViewHolder(View view) {
      super(view);

      //We  hook our views objects with their counterparts in the layout.
      rvImage = (ImageView) view.findViewById(R.id.rv_image);
      rvText = (TextView) view.findViewById(R.id.rv_text);
    }


  }
}
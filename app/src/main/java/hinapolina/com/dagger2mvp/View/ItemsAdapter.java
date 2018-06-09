package hinapolina.com.dagger2mvp.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import hinapolina.com.dagger2mvp.Data.Item;
import hinapolina.com.dagger2mvp.R;

/**
 * Created by polina on 4/15/18.
 */

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    private static final String IMAGE_PASS = "https://image.tmdb.org/t/p/w500/";
    ArrayList<Item> items = new ArrayList<>();
    Context context;

    public ItemsAdapter(ArrayList<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.item, parent, false);
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = items.get(position);
        holder.title.setText(item.getTitle());
        holder.text.setText(item.getOverview());
        Picasso.get().load(IMAGE_PASS+item.getImage()).into(holder.image);


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
      @BindView(R.id.item_image)  ImageView image;
      @BindView(R.id.item_title)  TextView title;
      @BindView(R.id.item_text)  TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

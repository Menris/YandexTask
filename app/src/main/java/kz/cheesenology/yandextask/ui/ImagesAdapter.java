package kz.cheesenology.yandextask.ui;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import kz.cheesenology.yandextask.R;
import kz.cheesenology.yandextask.model.AdapterModel;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ImagesViewHolder> {

    private List<AdapterModel> imageList;

    @Nullable
    private Callback callback;

    public ImagesAdapter() {
        this.imageList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ImagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        return new ImagesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImagesViewHolder holder, int position) {
        AdapterModel image = imageList.get(position);

        Log.e("lee", image.getPrewiewURL());


        Picasso.get()
                .load(image.getPrewiewURL())
                .resize(1080/3,300)
                .centerCrop()
                .into(holder.imageView);

        holder.itemView.setOnClickListener(v -> {
            if (callback != null) {
                callback.onClick(image);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public void setData(List<AdapterModel> list) {
        imageList.clear();
        imageList.addAll(list);
        notifyDataSetChanged();
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public interface Callback {
        void onClick(AdapterModel model);
    }

    public class ImagesViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public ImagesViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_item);
        }
    }
}

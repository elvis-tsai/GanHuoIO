package ren.solid.ganhuoio.module.home.provider;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import me.drakeet.multitype.ItemViewProvider;
import ren.solid.ganhuoio.R;
import ren.solid.ganhuoio.model.Daily;
import ren.solid.ganhuoio.module.home.activity.DailyActivity;
import ren.solid.library.imageloader.ImageLoader;

/**
 * Created by _SOLID
 * GitHub:https://github.com/burgessjp
 * Date:2017/3/12
 * Time:16:00
 * Desc:
 */
public class DailyViewProvider
        extends ItemViewProvider<Daily, DailyViewProvider.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(
            @NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_daily, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull final ViewHolder holder, @NonNull final Daily daily) {
        ImageLoader.displayImage(holder.iv_img, daily.getImgUrl());
        holder.iv_img.setColorFilter(Color.parseColor("#5e000000"));
        holder.tv_date.setText(daily.getDate());
        holder.tv_desc.setText(daily.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DailyActivity.start(v.getContext(), daily.getTitle(), daily.getDate());
            }
        });
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_img;
        TextView tv_date;
        TextView tv_desc;

        ViewHolder(View itemView) {
            super(itemView);
            iv_img = (ImageView) itemView.findViewById(R.id.iv_img);
            tv_date = (TextView) itemView.findViewById(R.id.tv_date);
            tv_desc = (TextView) itemView.findViewById(R.id.tv_desc);

        }
    }
}
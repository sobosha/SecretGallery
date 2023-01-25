package com.example.gallerysecret.Setting.CustomClasses;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;

public class CustomAdapter<T, P> extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    List<T> list;
    int Size = -1 ;

    public CustomAdapter(List<T> list , int Size) {
        this.list = list;
        this.Size = Size ;
    }

    IRel iRel;

    public CustomAdapter<T, P> setView(IRel iRel) {
        this.iRel = iRel;
        return this;
    }

    IAdapter<T, P> iAdapter;

    public CustomAdapter<T, P> onBind(IAdapter<T, P> iAdapter) {
        this.iAdapter = iAdapter;
        return this;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(iRel.getView());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        P p = (P) holder.itemView;
        iAdapter.onBind(position, list, (P) p, selectedItem , this);
    }

    @Override
    public int getItemCount() {
        return Size!=-1 && list == null ? Size : list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


    public static final class RecyclerBuilder<Model, View> {
        public CustomAdapter<Model, View> customAdapter;
        Context context;
        RecyclerView recyclerView;
        List<Model> list;

        public RecyclerBuilder(Context context , RecyclerView recyclerView , List<Model> list) {
            this.context = context;
            this.list = list ;
            this.recyclerView = recyclerView ;
        }

        int spanCount = -1;
        public RecyclerBuilder<Model, View> grid(int spanCount) {
            this.spanCount = spanCount;
            return this;
        }

        IRel iRel;
        public RecyclerBuilder<Model, View> setView(IRel iRel) {
            this.iRel = iRel;
            return this;
        }

        IAdapter<Model, View> iAdapter;
        public RecyclerBuilder<Model, View> setBind(IAdapter<Model, View> iAdapter) {
            this.iAdapter = iAdapter;
            return this;
        }

        int size = -1 ;
        public RecyclerBuilder<Model, View> setSizeWithOutList (int size) {
            this.size = size ;
            return this ;
        }

        boolean rtl = false ;
        public RecyclerBuilder<Model , View> enabledRtlGrid (int spanCount) {
            rtl = true ;
            this.spanCount = spanCount ;
            return this ;
        }

        boolean reverse = false ;
        public RecyclerBuilder<Model , View> reverse () {
            reverse = true ;
            return this ;
        }

        int orientation = -1 ;
        public RecyclerBuilder<Model , View> orientation (int orientation) {
            this.orientation = orientation;
            return this ;
        }

        GridLayoutManager gridLayoutManager ;
        public RecyclerBuilder<Model , View> spanSize (boolean rtl , int spanCount , ISpanSizeLookup iSpanSizeLookup) {
            gridLayoutManager = rtl ? new RtlGridLayoutManager(context , spanCount) : new GridLayoutManager(context , spanCount);
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return iSpanSizeLookup.getSpan(position);
                }
            });
            return this ;
        }

        @SuppressLint("WrongConstant")
        public CustomAdapter<Model, View> build() {
            if (!rtl && gridLayoutManager == null)
                recyclerView.setLayoutManager(spanCount == -1 ? new LinearLayoutManager(context , orientation == -1 ? RecyclerView.VERTICAL : orientation , reverse) : new GridLayoutManager(context, spanCount));
            else if (gridLayoutManager == null)
                recyclerView.setLayoutManager(new RtlGridLayoutManager(context , spanCount));
            else
                recyclerView.setLayoutManager(gridLayoutManager);
            customAdapter = new CustomAdapter<Model, View>(list , size).setView(iRel).onBind(iAdapter);
            recyclerView.setAdapter(customAdapter);
            return customAdapter;
        }
    }

    public void notifyMyItemChanged(int pos) {
        notifyItemChanged(pos);
    }

    public void notifyMyDataSetChanged() {
        notifyDataSetChanged();
    }

    int selectedItem = -1;

    public void notifyDataWithSelectedItem(int selectedItem) {
        this.selectedItem = selectedItem;
    }

    String colorTitle = "";

    public String getColorTitle() {
        return colorTitle;
    }

    public void searchOfflineOnItem (List<T> list) {
        this.list = list ;
        notifyDataSetChanged();
    }
}

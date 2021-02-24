package com.wpg.mobile.common.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @Author: xuwei
 * @Date: 2021/2/23 9:34
 * @Description:
 */
public abstract class BaseAdapter<VB extends ViewBinding, T> extends RecyclerView.Adapter<BaseViewHolder> {
    private Context mContext;
    private List<T> listData;
    private OnItemClickListener itemClickListener;
    private OnItemLongClickListener itemLongClickListener;

    public BaseAdapter(Context context, List<T> listData) {
        this.mContext = context;
        this.listData = listData;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Type type = getClass().getGenericSuperclass();
        ViewBinding viewBinding = null;
        if (type instanceof ParameterizedType) {
            try {
                Class<VB> clazz = (Class<VB>) ((ParameterizedType) type).getActualTypeArguments()[0];
                Method method = clazz.getMethod("inflate", LayoutInflater.class);
                viewBinding = (ViewBinding) method.invoke(null, LayoutInflater.from(mContext));
                viewBinding.getRoot().setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new BaseViewHolder(viewBinding, viewBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.itemView.setOnClickListener(v -> {
            if (itemClickListener != null) {
                itemClickListener.onItemClick(position);
            }
        });

        holder.itemView.setOnLongClickListener(v -> {
            if (itemLongClickListener != null) {
                itemLongClickListener.onItemLongClick(position);
            }
            return true;
        });
        convert((VB) holder.viewBinding, listData.get(position), position);
    }


    public abstract void convert(VB v, T t, int position);

    @Override
    public int getItemCount() {
        return listData == null ? 0 : listData.size();
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setItemLongClickListener(OnItemLongClickListener itemLongClickListener) {
        this.itemLongClickListener = itemLongClickListener;
    }

    interface OnItemClickListener {
        void onItemClick(int position);
    }

    interface OnItemLongClickListener {
        void onItemLongClick(int position);
    }
}

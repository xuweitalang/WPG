package com.wpg.mobile.common.base;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/**
 * @Author: xuwei
 * @Date: 2021/2/23 9:53
 * @Description:
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {
    public ViewBinding viewBinding;

    public BaseViewHolder(ViewBinding viewBinding, @NonNull View itemView) {
        super(itemView);
        this.viewBinding = viewBinding;
    }
}

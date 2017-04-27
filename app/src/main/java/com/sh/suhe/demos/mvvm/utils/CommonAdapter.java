package com.sh.suhe.demos.mvvm.utils;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.sh.suhe.demos.R;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by suhe on 2017/2/27.
 * com.sh.suhe.demos.mvvm.utils
 */

public class CommonAdapter extends BaseAdapter {
    private List datas = new ArrayList<>();
    private int layoutId ;
    private int variableId;


    public CommonAdapter(List list, int layoutId, int variableId){
        this.datas = list;
        this.layoutId = layoutId;
        this.variableId = variableId;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewDataBinding binding;
        if (convertView == null){
            binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), layoutId,parent,false);
        }else{
            binding = DataBindingUtil.getBinding(convertView);
        }
        binding.setVariable(variableId,getItem(position));

        return binding.getRoot();
    }
}

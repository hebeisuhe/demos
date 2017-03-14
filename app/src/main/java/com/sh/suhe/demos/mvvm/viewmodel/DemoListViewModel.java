package com.sh.suhe.demos.mvvm.viewmodel;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Toast;

import com.sh.suhe.demos.BR;
import com.sh.suhe.demos.R;
import com.sh.suhe.demos.databinding.ActivityDemoListBinding;
import com.sh.suhe.demos.mvvm.model.ListItemData;
import com.sh.suhe.demos.mvvm.utils.CommonAdapter;
import com.sh.suhe.demos.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suhe on 2017/2/28.
 * com.sh.suhe.demos.mvvm.viewmodel
 */

public class DemoListViewModel implements AdapterView.OnItemClickListener{
    List<ListItemData> list = new ArrayList<>();
    CommonAdapter adapter;
    public DemoListViewModel(ActivityDemoListBinding binding){


        ListItemData itemData1 = new ListItemData("标题1",1,"");
        list.add(itemData1);

         adapter = new CommonAdapter(list, R.layout.item_list_demo, BR.listitem);
        binding.setAdapter(adapter);
        binding.activityDemoListListview.setOnItemClickListener(this);
    }

    public void add(View view){
        int random = (int)(Math.random()*100) ;
        ListItemData itemData1 = new ListItemData("标题"+ random,1,"");
        list.add(itemData1);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ToastUtils.showShort(parent.getContext(),"position"+position);
    }
}

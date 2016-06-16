package com.yanwanfu.jikeutils.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yanwanfu.jikeutils.R;
import com.yanwanfu.jikeutils.domain.Child;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by yanwanfu on 16/6/17.
 *
 * ViewHolder 注入
 */
public class ChildAdapter extends BaseAdapter {

    private List<Child> children;
    private LayoutInflater inflater;

    public ChildAdapter(Context c, List<Child> children) {
        this.children = children;
        inflater = LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return children.size();
    }

    @Override
    public Child getItem(int position) {
        return children.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.child_item,null);
            viewHolder = new ViewHolder();
            x.view().inject(viewHolder,convertView);
            convertView.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Child child = children.get(position);//获取当前条目
        viewHolder.childName.setText(child.getName());

        return convertView;
    }

    class ViewHolder{

        @ViewInject(R.id.tv_child_name)
        TextView childName;
    }
}

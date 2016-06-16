package com.yanwanfu.jikeutils.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.yanwanfu.jikeutils.R;
import com.yanwanfu.jikeutils.adapter.ChildAdapter;
import com.yanwanfu.jikeutils.domain.Child;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanwanfu on 16/6/17.
 *
 * Fragmnet 注入方式
 * ListView 注入方式
 */

@ContentView(R.layout.inject_view)
public class InjectFragment extends Fragment {

    @ViewInject(R.id.listview)
    ListView listView;
    List<Child> children = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 测试数据
        for (int i = 0; i < 100; i++) {
            children.add(new Child("万福"+i));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return x.view().inject(this,inflater,container);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView.setAdapter(new ChildAdapter(getContext(),children));
    }
}

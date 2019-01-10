package module.learn.wanandroid.ui.main.adapter;

import android.content.Context;

import org.byteam.superadapter.SuperViewHolder;

import java.util.List;

import module.learn.common.base.adapter.BaseListAdapter;
import module.learn.common.bean.Template;
import module.learn.common.listener.OnListItemClickListener;
import module.learn.wanandroid.R;

/**
 * Describe：首页适配器
 * Created by 吴天强 on 2018/10/18.
 */

public class HomeRcyAdapter extends BaseListAdapter<Template> {


    public HomeRcyAdapter(Context context, List<Template> items, int layoutResId, OnListItemClickListener listener) {
        super(context, items, layoutResId, listener);
    }

    @Override
    public void onBindData(SuperViewHolder holder, int viewType, int layoutPosition, Template data) {
        holder.setText(R.id.tv_text, data.getTitle());
        holder.setBackgroundResource(R.id.iv_icon, data.getRes());
    }
}

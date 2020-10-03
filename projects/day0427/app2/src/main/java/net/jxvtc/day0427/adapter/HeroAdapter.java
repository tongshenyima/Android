package net.jxvtc.day0427.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.jxvtc.day0427.Item;
import net.jxvtc.day0427.R;
import net.jxvtc.day0427.model.Hero;

import java.util.List;

public class HeroAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    LayoutInflater mLayoutInflater;//布局加载器，用于把布局XML文件加载到内存，布局中的组件就可在JAVA中访问了
    List<Hero> heros;//国家列表

    //创建构建方法，在创建适配器时，生成布局加载器和传递列表数据 alt+inert

    public HeroAdapter(Context context, List<Hero> heros) {
        this.mLayoutInflater = LayoutInflater.from(context);
        this.countrys = countrys;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_layout,
                parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
      ItemViewHolder itemViewHolder= (ItemViewHolder) holder;
          itemViewHolder.textView.setText(countrys.get(position).getName());
        itemViewHolder.imageView.setImageResource(countrys.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return countrys!=null?countrys.size():0;
    }

    //下面在重写onBindViewHolder及onCreateViewHolder方法前，需要我们根据列表的具体布局，创建
    //相应的ViewHolder，但该ViewHolder必须继承RecyclerView.ViewHolder类.
    //在它当中，定义一些组件（哪些组件，取决于你的列表项）
    //本示例只要一项：TextView
    public class ItemViewHolder extends RecyclerView.ViewHolder{
        public TextView textView; //textView=null;
        public ImageView imageView;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.text1);
            imageView=itemView.findViewById(R.id.imageView);
        }
    }



    //前面的步骤：1、在项目的build.gradle中添加recyclerview的依赖
    //            2、在布局中使用recyclerview组件，注意一定要有id,需在java代码中访问，
    //                并为它指定适配器和布局管理器
    //            3、创建一个名为adapter的包，用于存放项目中各类适配器
    //            4、自定义适配器，创建一个名为CountryAdapter,
    //                    继承自RecyclerView.Adapter<RecyclerView.ViewHolder>的Java类
    //            5、重写三个方法getItemCount():有多少个项
    //                           onBindViewHolder:绑定数据与组件
    //                           onCreateViewHolder:创建ViewHolder   （空实现）
    //           6、创建构建方法和相应的字段（布局加载器对象，列表数据（类型：取决于你的列表布局）
    //               在构建方法中完成初始化（传递列表数据，利用Context，创建布局加载器xml-->Java）
    //           7、重写getItemCount()方法，返回列表的大小即可。
    //           8、创建自定义ViewHolder  (主要作用于存放列表项中的每一个组件的引用）
    //           9、重写onCreateViewHolder:  通过布局加载器加载列表项布局xml--->我们定义的ViewHolder


}

package net.jxvtc.day0427.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.jxvtc.day0427.R;
import net.jxvtc.day0427.model.Country;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    //把数据传递到单前的Adapter中  构造方法：传递   Setter方法：传递
    List<Country> countries;
    public CountryAdapter(List<Country> countries){
        this.countries=countries;
    }

    //定义视图持有者(内部应该写些什么）（取决于列表项的布局视图，有哪些组件）
    public class ItemViewHolder extends RecyclerView.ViewHolder{
        public TextView  tvName;//用于显示国家名称的文本显示视图  vtName=null;
        public ImageView  image;//用于显示国旗的图像组件  image=null;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tvName);//获取了对象
            image=itemView.findViewById(R.id.image);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //从子项布局中加载生成的视图持有者
        //通过布局加载器，加载xml布局，生成Java  Veiw对象，然后就可以访问内类的组件了
        View view= LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_layout,parent,false);//就表示子项的布局对象
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
       ItemViewHolder mHolder= (ItemViewHolder) holder;
       mHolder.tvName.setText(countries.get(position).getName());
       mHolder.image.setImageResource(countries.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        //java： List   size()
        return countries!=null?countries.size():0;
    }
}

package net.jxvtc.fragment001;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TITLE = "title";
    public static final String CONTENT = "content";
    private List<News> datas;
    private Context ctx;
    public NewsAdapter(List<News> datas,Context ctx) {
        this.datas = datas;
        this.ctx=ctx;
    }

    public  class ItemViewHolder extends  RecyclerView.ViewHolder{

        public TextView tvTitle;


        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle=itemView.findViewById(R.id.text1);
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       final Context context = parent.getContext();


        View view = LayoutInflater.from(context)
                .inflate(R.layout.news_item, parent, false);
        final ItemViewHolder vh=new ItemViewHolder(view);

        vh.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取数据
                int pos = vh.getAdapterPosition();
                String title=datas.get(pos).getTitle();
                String content=datas.get(pos).getContent();
                if(isTowPanel())
                {
                    ContentFragment frg_content = (ContentFragment) ((MainActivity) ctx).getSupportFragmentManager().findFragmentById(R.id.frg_content);
                   frg_content.refreshData(title,content);
                }
                else
                {

                    Intent intent=new Intent(context,ContentActivity.class);
                    intent.putExtra(TITLE,title);
                    intent.putExtra(CONTENT,content);
                    context.startActivity(intent);
                }


            }
        });
        return vh;
    }

    private boolean isTowPanel() {

        View view = ((MainActivity) ctx).findViewById(R.id.frg_content);
        return view!=null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemViewHolder vh= (ItemViewHolder) holder;
        vh.tvTitle.setText(datas.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return datas!=null?datas.size():0;
    }
}

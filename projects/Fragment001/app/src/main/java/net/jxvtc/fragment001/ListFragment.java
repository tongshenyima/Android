package net.jxvtc.fragment001;


import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    RecyclerView rv;
    List<News> datas;
    private Resources resources;

    public ListFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        rv = view.findViewById(R.id.rv);
        resources = getActivity().getResources();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDatas();
        NewsAdapter adapter=new NewsAdapter(datas,getActivity());
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));

    }

    private void initDatas() {
        datas = new ArrayList<>();
        String[] titles = resources.getStringArray(R.array.titles);
        String[] contents = resources.getStringArray(R.array.contents);
        News news=null;
        for (int i = 0; i < titles.length; i++) {
            news=new News(titles[i],contents[i]);
            datas.add(news);
        }

    }
}

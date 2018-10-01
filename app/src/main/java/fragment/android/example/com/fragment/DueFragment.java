package fragment.android.example.com.fragment;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class DueFragment extends Fragment {

    View v;
    RecyclerView myRecyclerView;
    RecyclerViewAdapter adapter;
    List<Elenco> Elenchi;


    public DueFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_container, container, false);
        myRecyclerView = v.findViewById(R.id.recycler_id);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        // myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerViewAdapter(getActivity(),Elenchi);
        myRecyclerView.setAdapter(adapter);

        return v;
        }

    @Override
    public void onCreate (@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        Elenchi = new ArrayList<>();
        Elenchi.add(new Elenco("Due", "Fragment", R.drawable.mucca));
        Elenchi.add(new Elenco("Due", "Fragment", R.drawable.mucca));
        Elenchi.add(new Elenco("Due", "Fragment", R.drawable.mucca));
        Elenchi.add(new Elenco("Due", "Fragment", R.drawable.mucca));
        Elenchi.add(new Elenco("Due", "Fragment", R.drawable.mucca));
        Elenchi.add(new Elenco("Due", "Fragment", R.drawable.mucca));
        Elenchi.add(new Elenco("Due", "Fragment", R.drawable.mucca));
        Elenchi.add(new Elenco("Due", "Fragment", R.drawable.mucca));
        Elenchi.add(new Elenco("Due", "Fragment", R.drawable.mucca));
        Elenchi.add(new Elenco("Due", "Fragment", R.drawable.mucca));
        Elenchi.add(new Elenco("Due", "Fragment", R.drawable.mucca));
        Elenchi.add(new Elenco("Due", "Fragment", R.drawable.mucca));
        Elenchi.add(new Elenco("Due", "Fragment", R.drawable.mucca));
        Elenchi.add(new Elenco("Due", "Fragment", R.drawable.mucca));
        Elenchi.add(new Elenco("Due", "Fragment", R.drawable.mucca));
    }
}
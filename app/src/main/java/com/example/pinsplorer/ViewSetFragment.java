package com.example.pinsplorer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewSetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewSetFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    protected static RecyclerView pinRecycler;
    protected static PinSet set;
    protected static ArrayList<Pin> PinList;
//    protected static ArrayList<Pin> PinList =
//            new ArrayList<>(
//                    Arrays.asList(new Pin("Inner Harbor", "Visited 3/13/20", "Historic harbor of Baltimore", R.drawable.innerharbor),
//                            new Pin("Farmer's Market", "Not Visited", "Great spot for fresh, locally sourced produce", R.drawable.market),
//                            new Pin("Miracle on 34th", "Visited 12/21/19", "Holiday decorations, unique sculptures, and flashy lights", R.drawable.miracle)));

    public ViewSetFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ViewSetFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ViewSetFragment newInstance(String param1, String param2) {
        ViewSetFragment fragment = new ViewSetFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            set = getArguments().getParcelable("item_selected_key");
            PinList = set.getPinList();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_set, container, false);
        FloatingActionButton createPinBtn = view.findViewById(R.id.createPinBtn);
        createPinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.MAINACTIVITY.switchFragment(new CreatePinFragment());
            }
        });
        return view;
    }

    @Override
    public void onStart(){
        super.onStart();
        pinRecycler = getView().findViewById(R.id.pinRecyclerView);
        pinRecycler.setAdapter(new PinRecyclerAdapter(PinList));
        pinRecycler.setLayoutManager(new LinearLayoutManager(this.getContext()));
    }
}

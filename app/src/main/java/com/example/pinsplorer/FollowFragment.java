package com.example.pinsplorer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FollowFragment#newInstance} factory method to
 * create an instance of this fragment_view_followed_set.
 */
public class FollowFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment_view_followed_set initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    protected static RecyclerView PinSetRecycler;

    protected static ArrayList<Pin> CampusPins = new ArrayList<>(Arrays.asList(
            new Pin("Gilman", false,
                    "A place to study", R.drawable.gilman, new LatLng(39.3289, -76.6216)),
            new Pin("Malone", true,
                    "The JHU Computer Science Building", R.drawable.malone, new LatLng(39.3262, -76.6209))));
    protected static ArrayList<Pin> DefaultPins = new ArrayList<>(Arrays.asList(
            new Pin("Inner Harbor", false,
                    "A place with lots of boats to look at", R.drawable.innerharbor, new LatLng(39.2858, -76.6131)),
            new Pin("Market", true,
                    "This market has really cool stuff!", R.drawable.market, new LatLng(39.2838, -76.6351)),
            new Pin("Museum", false,
                    "This museum changes their exhibits once every season, so its a" +
                            "great place to go often!", R.drawable.museum, new LatLng(39.2878, -76.6161))));

    protected static ArrayList<PinSet> PinSetFollowedList =
            new ArrayList<>(
                    Arrays.asList(
                            new PinSet("Campus Buildings", CampusPins.size(), 360, "Johns Hopkins",
                                    R.drawable.gilman, CampusPins, false),
                            new PinSet("Baltimore Tourist Attractions", DefaultPins.size(), 71, "Me",
                                    R.drawable.tourists, DefaultPins, false)));


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FollowFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment_view_followed_set using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment_view_followed_set FollowFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FollowFragment newInstance(String param1, String param2) {
        FollowFragment fragment = new FollowFragment();
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
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment_view_followed_set
        return inflater.inflate(R.layout.fragment_follow, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        PinSetRecycler = getView().findViewById(R.id.followedRecyclerView);
        PinSetRecycler.setAdapter(new FollowRecyclerAdapter(PinSetFollowedList));
        PinSetRecycler.setLayoutManager(new LinearLayoutManager(this.getContext()));
    }
}

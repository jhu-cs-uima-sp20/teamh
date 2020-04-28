package com.example.pinsplorer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SavedFragment#newInstance} factory method to
 * create an instance of this fragment_view_followed_set.
 */
public class SavedFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment_view_followed_set initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

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
    protected static ArrayList<PinSet> PinSetList =
            new ArrayList<>(
                    Arrays.asList(
                            new PinSet("Baltimore Eats", 17, 32, "Me",
                                    R.drawable.restaurant, DefaultPins, true),
                            new PinSet("Campus Buildings", CampusPins.size(), 360, "Me",
                                    R.drawable.gilman, CampusPins, false),
                            new PinSet("Great Sidewalks <3", 9, 14, "Me",
                                    R.drawable.sidewalk, DefaultPins, true)));


    public SavedFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment_view_followed_set using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment_view_followed_set SavedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SavedFragment newInstance(String param1, String param2) {
        SavedFragment fragment = new SavedFragment();
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
        final View view = inflater.inflate(R.layout.fragment_saved, container, false);
        FloatingActionButton addPinSetBtn = view.findViewById(R.id.button_to_add_pinset);
            addPinSetBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   MainActivity.MAINACTIVITY.switchFragment(new CreatePinSetFragment());
                }
            });
        return view;
    }

    // Called at the start of the visible lifetime.
    @Override
    public void onStart(){
        super.onStart();
        PinSetRecycler = getView().findViewById(R.id.pinSetRecyclerView);
        ItemTouchHelper deleteSwipe = new ItemTouchHelper(new DeleteSwipeController(PinSetList, PinSetRecycler));
        deleteSwipe.attachToRecyclerView(PinSetRecycler);
        PinSetRecycler.setAdapter(new PinSetRecyclerAdapter(PinSetList));
        PinSetRecycler.setLayoutManager(new LinearLayoutManager(this.getContext()));
    }
}

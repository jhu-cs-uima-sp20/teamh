package com.example.pinsplorer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SavedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SavedFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    protected static RecyclerView PinSetRecycler;
    protected static ArrayList<Pin> CodedPins = new ArrayList<>(Arrays.asList(new Pin("Gilman", false,
            "A place to study", R.drawable.gilman)));
    protected static ArrayList<PinSet> PinSetList =
            new ArrayList<>(
                    Arrays.asList(new PinSet("Baltimore Eats", 17, 32, "Brian",
                                    R.drawable.restaurant, CodedPins),
                            new PinSet("Campus Buildings", 1, 360, "Johns Hopkins",
                                    R.drawable.gilman, CodedPins),
                            new PinSet("Great Sidewalks <3", 9, 14, "Me",
                                    R.drawable.sidewalk, CodedPins),
                            new PinSet("Tourist Attractions", 5, 71, "Me",
                                    R.drawable.tourists, CodedPins),
                            new PinSet("Cool Museums", 8, 27, "Me",
                                    R.drawable.museum, CodedPins)));

    public SavedFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SavedFragment.
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_saved, container, false);
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
        PinSetRecycler.setAdapter(new PinSetRecyclerAdapter(PinSetList));
        PinSetRecycler.setLayoutManager(new LinearLayoutManager(this.getContext()));
    }
}

package com.example.pinsplorer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewPinFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewPinFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    Pin pin;

    public ViewPinFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ViewPinFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ViewPinFragment newInstance(String param1, String param2) {
        ViewPinFragment fragment = new ViewPinFragment();
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
            pin = getArguments().getParcelable("item_selected_key");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_pin, container, false);
        TextView name = view.findViewById(R.id.pinNameTextView);
        name.setText(pin.getName());
        TextView description = view.findViewById(R.id.pinDescriptionTextView);
        description.setText(pin.getDescription());
        TextView visited = view.findViewById(R.id.pinVisitView);
        if (pin.getVisited()) {
            visited.setText("Visited");
        }
        else {
            visited.setText("Unvisited");
        }
        ImageView image = view.findViewById(R.id.pinImageView);
        image.setImageResource(pin.getImage());
        return view;
    }
}

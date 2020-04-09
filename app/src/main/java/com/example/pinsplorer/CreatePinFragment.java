package com.example.pinsplorer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreatePinFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreatePinFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CreatePinFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CreatePinFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CreatePinFragment newInstance(String param1, String param2) {
        CreatePinFragment fragment = new CreatePinFragment();
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
        final View view = inflater.inflate(R.layout.fragment_create_pin, container, false);
        FloatingActionButton addPinBtn = view.findViewById(R.id.addPinButton);
        addPinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText setNameEdit = view.findViewById(R.id.pinNameText);
                EditText setDescriptionEdit = view.findViewById(R.id.pinDescriptionText);
                ViewSetFragment.PinList.add(new Pin(setNameEdit.getText().toString(), setDescriptionEdit.getText().toString()));
                ViewSetFragment.pinRecycler.getAdapter().notifyDataSetChanged();
                MainActivity.MAINACTIVITY.switchFragment(new ViewSetFragment());
            }
        });

        return view;
    }
}

package com.example.pinsplorer;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreatePinSetFragment#newInstance} factory method to
 * create an instance of this fragment_view_followed_set.
 */
public class CreatePinSetFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment_view_followed_set initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ImageButton mImagebtn;
    private static int RESULT_LOAD_IMAGE = 1;
    private static int RESULT_OK = 1;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CreatePinSetFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment_view_followed_set using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment_view_followed_set CreatePinSetFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CreatePinSetFragment newInstance(String param1, String param2) {
        CreatePinSetFragment fragment = new CreatePinSetFragment();
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
        final View view = inflater.inflate(R.layout.fragment_create_pin_set, container, false);

        mImagebtn = (ImageButton) view.findViewById(R.id.imageButton);

        mImagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(cameraIntent, RESULT_LOAD_IMAGE);
            }
        });

        FloatingActionButton addPinSetBtn = view.findViewById(R.id.addPinsetButton);
            addPinSetBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO still need to figure out how to upload image from user's photo gallery here
                    EditText setNameEdit = view.findViewById(R.id.setPinSetNameText);
                    SavedFragment.PinSetList.add(new PinSet(setNameEdit.getText().toString()));
                    SavedFragment.PinSetRecycler.getAdapter().notifyDataSetChanged();
                    MainActivity.MAINACTIVITY.switchFragment(new SavedFragment());
                }
            });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            assert selectedImage != null;
            Cursor cursor = getActivity().getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            assert cursor != null;
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            // String picturePath contains the path of selected Image
        }
    }
}

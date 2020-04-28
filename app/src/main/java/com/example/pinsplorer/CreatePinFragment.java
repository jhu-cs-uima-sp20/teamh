package com.example.pinsplorer;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreatePinFragment#newInstance} factory method to
 * create an instance of this fragment_view_followed_set.
 */
public class CreatePinFragment extends Fragment {
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

    public CreatePinFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment_view_followed_set using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment_view_followed_set CreatePinFragment.
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
        // Inflate the layout for this fragment_view_followed_set
        final View view = inflater.inflate(R.layout.fragment_create_pin, container, false);

        // Initialize the SDK
        Places.initialize(getActivity().getApplicationContext(), getString(R.string.API_KEY));
        // Create a new Places client instance
        PlacesClient placesClient = Places.createClient(getContext());

        mImagebtn = (ImageButton) view.findViewById(R.id.imageButton2);

        mImagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(cameraIntent, RESULT_LOAD_IMAGE);
            }
        });

        // Initialize the AutocompleteSupportFragment.
        final AutocompleteSupportFragment autocompleteFragment = (AutocompleteSupportFragment)
                getChildFragmentManager().findFragmentById(R.id.autocomplete_fragment);

// Specify the types of place data to return.
        autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.LAT_LNG));

        final LatLng[] newCoords = {new LatLng(0, 0)};

// Set up a PlaceSelectionListener to handle the response.
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                Log.i("TAG", "Place: " + place.getName() + ", " + place.getId());
                newCoords[0] = place.getLatLng();
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.i("TAG", "An error occurred: " + status);
            }
        });

        FloatingActionButton addPinBtn = view.findViewById(R.id.addPinButton);
        addPinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //autocompleteFragment.
                EditText setNameEdit = view.findViewById(R.id.pinNameText);
                EditText setDescriptionEdit = view.findViewById(R.id.pinDescriptionText);
                Pin newPin = new Pin(setNameEdit.getText().toString(), setDescriptionEdit.getText().toString(), newCoords[0]);
                ViewSetFragment.PinList.add(newPin);
                ViewSetFragment.pinRecycler.getAdapter().notifyDataSetChanged();
                MainActivity.MAINACTIVITY.switchFragment(new ViewSetFragment());
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

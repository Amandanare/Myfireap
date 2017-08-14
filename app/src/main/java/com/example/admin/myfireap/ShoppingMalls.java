package com.example.admin.myfireap;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 8/3/2017.
 */

public class ShoppingMalls extends Fragment {

    private ListView mSoshanguveListView;
    private tourAdapter mTourAdapter;
    private DatabaseReference mDatabaseReference;
    private FirebaseDatabase tfirebadatabase;
    private ChildEventListener mChildEventListener;
    FirebaseStorage tFirebaseStorage;

    private String value;

    private ArrayList<String> list = new ArrayList<>();
    private ListView listView;

    ArrayAdapter<String> adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_list, container, false);

        tfirebadatabase = FirebaseDatabase.getInstance();
        tFirebaseStorage = FirebaseStorage.getInstance();

        mDatabaseReference = tfirebadatabase.getReference().child("shoppingmalls");

        mSoshanguveListView=(ListView) rootView.findViewById(R.id.list);
        final List<Tours> tours = new ArrayList<>();
        mTourAdapter= new tourAdapter(getActivity(),R.layout.activity_list,tours);
        mSoshanguveListView.setAdapter(mTourAdapter);

        mChildEventListener=new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Tours tour = dataSnapshot.getValue(Tours.class);
                mTourAdapter.add(tour);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        mDatabaseReference.addChildEventListener(mChildEventListener);

        return rootView;
    }
}

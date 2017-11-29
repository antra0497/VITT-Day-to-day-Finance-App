package com.finance.personal.vitt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 *{@link TakeNotes OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TakeNotes# newInstance} factory method to
 * create an instance of this fragment.
 */
public class TakeNotes extends Fragment {


    ListView lv;
    EditText notes;
    Button btn;
    ArrayList <String> list = new ArrayList<String>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_take_notes,null);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lv=(ListView)getActivity().findViewById(R.id.listView);
        notes = (EditText)view.findViewById(R.id.notetext);
        btn= (Button)view.findViewById(R.id.notesbt);


            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String str=notes.getText().toString();
                    list.add(str);
                    }
                });


        ArrayAdapter <String> lvAdapter = new ArrayAdapter<String>(
                getActivity(),android.R.layout.simple_list_item_1,list );

        lv.setAdapter(lvAdapter);

        }
}

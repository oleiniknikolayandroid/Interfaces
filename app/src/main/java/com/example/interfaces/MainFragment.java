package com.example.interfaces;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends Fragment {
//вызываем листенер
    private MainContract.Listener mListener;

    public MainFragment() {
        // Required empty public constructor
    }
//прописываем обработку изменений
    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //указываем фаил разметки
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        //прописываем кнопку
        Button btn = (Button) getView().findViewById(R.id.btn_main_open_second);
        //цепляем листенер
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //проверяем не пустой ли он
                if (mListener != null)
                    //отткрываем секонд активити
                    mListener.openSecondActivity();
            }
        });
        //возвраш/щаем разметку
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainContract.Listener) {
            //проверяем листенер на наличие контекста
            mListener = (MainContract.Listener) context;
        } else {
            //кидаем ексепшн если он не содержит его
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //убиваем листенер
        mListener = null;
    }
}

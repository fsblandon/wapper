package com.fsblandon.wapper.vista;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.fsblandon.wapper.R;

public class Invoices extends Fragment {

    private int pos = 0;

    public static String [] lsEmpresas={
            "Energia","Energia","Energia","Energia","Energia","Energia","Energia","Energia","Energia","Energia"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pos = getArguments().getInt(Home.key);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.activity_invoices,container,false);
        Context contexto = null;


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,lsEmpresas);
        ListView miLista = (ListView) view.findViewById(R.id.lista_invoices);
        miLista.setAdapter(arrayAdapter);
        return view;
    }

}

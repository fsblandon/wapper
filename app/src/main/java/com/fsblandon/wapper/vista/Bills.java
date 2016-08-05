package com.fsblandon.wapper.vista;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.fsblandon.wapper.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Bills extends ListFragment {

    //private int pos = 0;
    private facturasAdapter adapter;


    public static String[] lsEmpresas = {
            "Energia", "Agua", "Gas", "Energia", "Agua", "Gas", "Energia", "Agua", "Gas", "Energia"};

    public static int[] lsIconos =
            {R.drawable.icono, R.drawable.icono, R.drawable.icono, R.drawable.icono, R.drawable.icono, R.drawable.icono,
                    R.drawable.icono, R.drawable.icono, R.drawable.icono, R.drawable.icono};

    public static String[] lsNroFacturas = {
            "12345", "12345", "12345", "12345", "12345", "12345", "12345", "12345", "12345", "12345"
    };

    public static String[] lsFechas = {
            "10/05/2016", "10/05/2016", "10/05/2016", "10/05/2016", "10/05/2016",
            "10/05/2016", "10/05/2016", "10/05/2016", "10/05/2016", "10/05/2016"
    };
    static int img = R.drawable.icono;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //List<HashMap<String,String>> lista = new ArrayList<HashMap<String,String>>();

        //setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, lsEmpresas));
        setHasOptionsMenu(true);
    }

    //@Override
    //public boolean onCreateOptionsMenu(Menu menu) {
        /*getMenuInflater().inflate(R.menu.menu_home, menu);

        final SearchManager manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        final SearchView search = (SearchView) menu.findItem(R.id.menu_search).getActionView();

        search.setSearchableInfo(manager.getSearchableInfo(getComponentName()));
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.Filter(s);
                return true;
            }
        });

        search.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                adapter.Filter("");
                adapter.notifyDataSetChanged();
                return true;
            }
        });
        return true;*/

    //}


    //@Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //adapter = new facturasAdapter(getActivity(),lsIconos,lsEmpresas,lsNroFacturas,lsFechas);
        //setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        // Mostramos un mensaje con el elemento pulsado
        Toast.makeText(getActivity(), "Solicitar factura de: " + lsEmpresas[position],
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        //getActivity().getMenuInflater().inflate(R.menu.menu_home,menu);


    }

    //@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.activity_bills, container, false);
        adapter = new facturasAdapter(getActivity(),lsIconos,lsEmpresas,lsNroFacturas,lsFechas);
        //ListView myList = (ListView) v.findViewById(R.id.lista_bills);
        setListAdapter(adapter);
        //myList.setAdapter(adapter);
        return v;

    }


    public class facturasAdapter extends BaseAdapter {
        String[] empresas;
        Context contexto;
        int[] iconos;
        String[] nFactura;
        String[] fechas;

        //private LayoutInflater inflater;

        public facturasAdapter(Context context, int[] iconos, String[] empresas, String[] nFactura, String[] fechas) {
            //super(context,android.R.layout.simple_list_item_2);
            //inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            //super(contexto,R.layout.activity_bills,data);
            this.contexto = context;
            this.empresas = empresas;
            this.iconos = iconos;
            this.nFactura = nFactura;
            this.fechas = fechas;

        }

        @Override
        public int getCount() {
            return empresas.length;
        }

        @Override
        public Object getItem(int posicion) {
            return posicion;
        }

        @Override
        public long getItemId(int posicion) {
            return posicion;
        }

        public class Holder {
            TextView empresas;
            TextView fechas;
            TextView nFactura;
            ImageView img;
        }

        @Override
        public View getView(final int posicion, View view, ViewGroup viewGroup) {

            Holder holder = null;
            LayoutInflater inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);

            View rowView;
            if (view == null) {
                rowView = inflater.inflate(R.layout.item_bills, null);
                holder = new Holder();

                holder.empresas = (TextView) rowView.findViewById(R.id.nom_empresa_list);
                holder.img = (ImageView) rowView.findViewById(R.id.icono_list);
                holder.nFactura = (TextView) rowView.findViewById(R.id.nro_factura_list);
                holder.fechas = (TextView) rowView.findViewById(R.id.fecha_list);


                holder.img.setImageResource(iconos[posicion]);
                holder.empresas.setText(empresas[posicion]);
                holder.nFactura.setText(nFactura[posicion]);
                holder.fechas.setText(fechas[posicion]);

                rowView.setTag(holder);

            } else {
                rowView = view;
                holder = (Holder)  rowView.getTag();
            }

            return rowView;

        }

        /*public void Filter(String search) {
            search = search.toLowerCase(Locale.getDefault());
            empresas.clear();
            if (search.length() == 0) {
                result.addAll(items);
            } else {
                for (Restaurante wp : items) {
                    if (wp.NAME.toLowerCase(Locale.getDefault())
                            .contains(search)) {
                        result.add(wp);
                    }
                }
            }
            notifyDataSetChanged();
        }*/

    }

}

package com.example.myappsql.asyncTasks;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myappsql.R;
import com.example.myappsql.adapter.EventsAdapter;
import com.example.myappsql.entities.Evento;

import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;


public class ObtenerTodosAsyncTask extends AsyncTask<String, Integer, ArrayList<Evento>> {

    private String urldb, userdb,passdb;
    Activity mWeakActivity;


    public ObtenerTodosAsyncTask(String url, String user, String pass, Activity activity){
        this.urldb=url;
        this.userdb=user;
        this.passdb=pass;
        this.mWeakActivity =activity;
    }

    @Override
    protected void onPreExecute() {
        Log.i("onPreExecute", "Iniciando");
        Toast toast1 =
                Toast.makeText(mWeakActivity,
                        "Buscando datos", Toast.LENGTH_LONG);

    }
    @Override
    protected ArrayList doInBackground(String... strings) {
        String url="jdbc:mysql://"+this.urldb+"/eventosescom";


        ResultSet rs;
        ArrayList<Evento> listaEventos=new ArrayList<Evento>();
        //String mysql_user = Resources.getSystem().getString(R.string.userDB);
        //String mysql_pass = Resources.getSystem().getString(R.string.passDB);



        try{
            System.out.println("Actualizar abierto s 3");
            Log.i("doInBackground", "Intentando cargar driver de MySQL");
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn= DriverManager.getConnection(url, userdb, passdb);
            Log.i("doInBackground", "Conexión exitosa");


            PreparedStatement preparedStatement=conn.prepareStatement(strings[0]);

            //preparedStatement.setString(1, strings[1]);

            rs=preparedStatement.executeQuery();
            Evento tmpEvto=new Evento();

            while (rs.next()) {
                System.out.println("Del resultSet: "+rs.getString(1));
                //Toast toast1 =
                //      Toast.makeText(mWeakActivity,
                //            "Se encontraron datos", Toast.LENGTH_LONG);

                //toast1.show();

                Integer id = rs.getInt(1);
                String nombre = rs.getString(2);
                Date inicio = rs.getDate(3);
                Date fin = rs.getDate(4);
                String observaciones = rs.getString(5);

                tmpEvto=new Evento(id, nombre, inicio, fin);
                tmpEvto.setObservaciones(observaciones);

                listaEventos.add(tmpEvto);

                /*EditText idTxt=(EditText) mWeakActivity.findViewById(R.id.idNuevoEventoUpdate);
                EditText nombreTxt=(EditText) mWeakActivity.findViewById(R.id.nombreNuevoEventoUpdate);
                EditText inicioTxt=(EditText) mWeakActivity.findViewById(R.id.inicioNuevoEventoUpdate);
                EditText finTxt=(EditText) mWeakActivity.findViewById(R.id.finNuevoEventoUpdate);
                EditText observsTxt=(EditText) mWeakActivity.findViewById(R.id.observacionesNuevoEventoUpdate);*/

                Log.i("onPostExcecute", nombre);
                //nombreTxt.setText(nombre);
                //observsTxt.setText(observaciones);
            }

        }catch(Exception ex)
        {
            ex.printStackTrace();
            Log.d("doInBackground", ex.toString());
            return null;
        }
        System.out.println("Eventos: "+listaEventos.get(0).toString());
        return listaEventos;
    }
    @Override
    protected void onPostExecute(ArrayList<Evento> listaEvts) {

        try {
            System.out.println("Eventos: " + listaEvts.get(0).toString());

            /*EditText idTxt = (EditText) mWeakActivity.findViewById(R.id.idNuevoEventoUpdate);
            EditText nombreTxt = (EditText) mWeakActivity.findViewById(R.id.nombreNuevoEventoUpdate);
            EditText inicioTxt = (EditText) mWeakActivity.findViewById(R.id.inicioNuevoEventoUpdate);
            EditText finTxt = (EditText) mWeakActivity.findViewById(R.id.finNuevoEventoUpdate);
            EditText observsTxt = (EditText) mWeakActivity.findViewById(R.id.observacionesNuevoEventoUpdate);

            Log.i("onPostExcecute", listaEvts.get(0).getNombreEvento());

            idTxt.setText(listaEvts.get(0).getIdEvento().toString());
            nombreTxt.setText(listaEvts.get(0).getNombreEvento());
            observsTxt.setText(listaEvts.get(0).getObservaciones());

            inicioTxt.setText(listaEvts.get(0).getInicio().toString());
            finTxt.setText(listaEvts.get(0).getFin().toString());

            // try {
            //   Log.i("onPostExcecute", "se terminó busqueda");
            //rs.first();
            /*while (rs.next()) {
                System.out.println("Del resultSet: "+rs.getString(1));
                Toast toast1 =
                        Toast.makeText(mWeakActivity,
                                "Se encontraron datos", Toast.LENGTH_LONG);

                toast1.show();

                String id = rs.getString(1);
                String nombre = rs.getString(2);
                String inicio = rs.getString(3);
                String fin = rs.getString(4);
                String observaciones = rs.getString(5);

                EditText idTxt=(EditText) mWeakActivity.findViewById(R.id.idNuevoEventoUpdate);
                EditText nombreTxt=(EditText) mWeakActivity.findViewById(R.id.nombreNuevoEventoUpdate);
                EditText inicioTxt=(EditText) mWeakActivity.findViewById(R.id.inicioNuevoEventoUpdate);
                EditText finTxt=(EditText) mWeakActivity.findViewById(R.id.finNuevoEventoUpdate);
                EditText observsTxt=(EditText) mWeakActivity.findViewById(R.id.observacionesNuevoEventoUpdate);

                Log.i("onPostExcecute", nombre);
                nombreTxt.setText(nombre);
                observsTxt.setText(observaciones);
            }
            if(rs.getFetchSize()==0)
            {
                Toast toast1 =
                        Toast.makeText(mWeakActivity,
                                "NO se encontraron datos", Toast.LENGTH_LONG);

                toast1.show();

            }
        }
        catch(Exception e)
        {
            Log.i("onPostExcecute", e.toString());
*/

            //      }

            RecyclerView personsRecyclerView = mWeakActivity.findViewById(R.id.events_recycler_view);
            //List<Evento> inMemoryData = EventoFactory.createInMemoryData();

            EventsAdapter personsAdapter = new EventsAdapter(listaEvts);

            System.out.println("Es nulo: "+personsAdapter.toString());
            System.out.println("Es nulo: "+personsRecyclerView.toString());
            personsRecyclerView.setAdapter(personsAdapter);
            personsRecyclerView.setLayoutManager(new LinearLayoutManager(mWeakActivity));
            personsRecyclerView.addItemDecoration(new DividerItemDecoration(mWeakActivity, DividerItemDecoration.VERTICAL));

            super.onPostExecute(listaEvts);
        }catch(Exception e)
        {
            e.printStackTrace();
            Log.e("onPostExcecute", e.toString());
        }

    }
}
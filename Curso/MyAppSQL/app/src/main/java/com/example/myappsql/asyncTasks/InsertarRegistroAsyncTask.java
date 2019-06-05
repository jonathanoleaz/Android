package com.example.myappsql.asyncTasks;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Calendar;


public class InsertarRegistroAsyncTask extends AsyncTask<String, Integer, String> {

    private String userdb,passdb,urldb;
    Activity mWeakActivity;


    public InsertarRegistroAsyncTask(String url, String user, String pass, Activity activity){
        this.urldb=url;
        this.userdb=user;
        this.passdb=pass;
        this.mWeakActivity =activity;
    }

        @Override
        protected void onPreExecute() {

        }
        @Override
        protected String doInBackground(String... strings) {

            String url="jdbc:mysql://"+this.urldb+"/eventosescom";

            //String mysql_user = Resources.getSystem().getString(R.string.userDB);
            //String mysql_pass = Resources.getSystem().getString(R.string.passDB);



            try{
                System.out.println("Agregar abierto s 3");
                Log.i("doInBackground", "Intentando cargar driver de MySQL");
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn= DriverManager.getConnection(url, userdb, passdb);
                Log.i("doInBackground", "Conexión exitosa");


                PreparedStatement preparedStatement=conn.prepareStatement(strings[0]);

                preparedStatement.setString(1, strings[1]);

                java.util.Calendar cal = Calendar.getInstance();
                java.util.Date utilDate = new java.util.Date(strings[2]); // your util date
                cal.setTime(utilDate);
                preparedStatement.setDate(2, new java.sql.Date(cal.getTime().getTime()));

                cal = Calendar.getInstance();
                utilDate = new java.util.Date(strings[3]); // your util date
                cal.setTime(utilDate);
                preparedStatement.setDate(3, new java.sql.Date(cal.getTime().getTime()));

                preparedStatement.setString(4, strings[4]);



                preparedStatement.executeUpdate();
            }catch(Exception ex)
            {
                Log.d("doInBackground", ex.toString());
                return ex.toString();
            }
            return "Ejecución exitosa";
        }
        @Override
        protected void onPostExecute(String finalMessage) {
            Toast toast1 =
                    Toast.makeText(mWeakActivity,
                            finalMessage, Toast.LENGTH_LONG);
            toast1.show();
            super.onPostExecute(finalMessage);

        }
}
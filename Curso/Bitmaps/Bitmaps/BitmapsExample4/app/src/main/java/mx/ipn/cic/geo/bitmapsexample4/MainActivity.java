package mx.ipn.cic.geo.bitmapsexample4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    Button buttonDrawBitmap;
    Button buttonConvertBitmap;
    Button buttonFourier;
    ImageView imageViewSourceBitmap;
    ImageView imageViewResultBitmap;
    ProgressBar progressBar;

    SharedPreferences shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.shared=PreferenceManager.getDefaultSharedPreferences(this);

        this.buttonDrawBitmap = findViewById(R.id.buttonDrawBitmap);
        this.buttonConvertBitmap = findViewById(R.id.buttonConvertBitmap);
        this.buttonFourier = findViewById(R.id.buttonFourier);
        this.imageViewSourceBitmap = this.findViewById(R.id.imageViewSourceBitmap);
        this.imageViewResultBitmap = this.findViewById(R.id.imageViewResultBitmap);
        this.progressBar = this.findViewById(R.id.progressBar);
        this.buttonDrawBitmap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LoadImagesIntoImageView();
            }
        });

        this.buttonConvertBitmap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                String channel = (shared.getString("pref_tamVent", null));
                System.out.println("Tamaño de ventana: "+channel);

                progressBar.setProgress(0);
                Bitmap sourceBitmap = ((BitmapDrawable)imageViewSourceBitmap.getDrawable()).getBitmap();
                progressBar.setMax(imageViewSourceBitmap.getHeight() + 1);
                GrayScale algorithm = new GrayScale(progressBar, sourceBitmap);
                algorithm.execute(imageViewResultBitmap);
            }
        });

        this.buttonFourier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setProgress(0);
                Bitmap sourceBitmap = ((BitmapDrawable)imageViewSourceBitmap.getDrawable()).getBitmap();
                progressBar.setMax(imageViewSourceBitmap.getHeight() + 1);
                Fourier algorithm = new Fourier(progressBar, sourceBitmap);
                algorithm.execute(imageViewResultBitmap);
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.itemMenuLoadBitmap:
                LoadImagesIntoImageView();
                return true;
            case R.id.itemMenuExitApp:
                this.finish();
                System.exit(RESULT_OK);
                return true;
            case R.id.itemMenuAjustes:
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void LoadImagesIntoImageView()
    {
        // Compute a random number to determine the image.
        int randomNumber = (int)(Math.ceil(Math.random() * 9.0));
        BitmapWorkerTask taskSource = new BitmapWorkerTask(imageViewSourceBitmap, getApplicationContext(),
                imageViewSourceBitmap.getWidth(), imageViewResultBitmap.getHeight());
        BitmapWorkerTask taskResult = new BitmapWorkerTask(imageViewResultBitmap,  getApplicationContext(),
                imageViewResultBitmap.getWidth(), imageViewResultBitmap.getHeight());
        switch(randomNumber)
        {
            case 0: taskSource.execute(R.drawable.imagen0); taskResult.execute(R.drawable.imagen0); break;
            case 1: taskSource.execute(R.drawable.imagen1); taskResult.execute(R.drawable.imagen1); break;
            case 2: taskSource.execute(R.drawable.imagen2); taskResult.execute(R.drawable.imagen2); break;
            case 3: taskSource.execute(R.drawable.imagen3); taskResult.execute(R.drawable.imagen3); break;
            case 4: taskSource.execute(R.drawable.imagen4); taskResult.execute(R.drawable.imagen4); break;
            case 5: taskSource.execute(R.drawable.imagen5); taskResult.execute(R.drawable.imagen5); break;
            case 6: taskSource.execute(R.drawable.imagen6); taskResult.execute(R.drawable.imagen6); break;
            case 7: taskSource.execute(R.drawable.imagen7); taskResult.execute(R.drawable.imagen7); break;
            case 8: taskSource.execute(R.drawable.imagen8); taskResult.execute(R.drawable.imagen8); break;
            case 9: taskSource.execute(R.drawable.imagen9); taskResult.execute(R.drawable.imagen9); break;
        }
    }
}

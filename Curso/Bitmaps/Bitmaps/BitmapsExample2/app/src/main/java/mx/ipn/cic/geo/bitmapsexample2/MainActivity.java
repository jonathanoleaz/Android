package mx.ipn.cic.geo.bitmapsexample2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button buttonDrawBitmap;
    ImageView imageViewBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.buttonDrawBitmap = findViewById(R.id.buttonDrawBitmap);
        this.imageViewBitmap = this.findViewById(R.id.imageViewBitmap);
        this.buttonDrawBitmap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                BitmapWorkerTask task = new BitmapWorkerTask(imageViewBitmap);
                task.execute(R.drawable.forest_restoration_map);
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
                BitmapWorkerTask task = new BitmapWorkerTask(imageViewBitmap);
                task.execute(R.drawable.forest_restoration_map);
                return true;
            case R.id.itemMenuExitApp:
                this.finish();
                System.exit(RESULT_OK);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

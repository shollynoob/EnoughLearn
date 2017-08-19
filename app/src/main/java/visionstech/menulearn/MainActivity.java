package visionstech.menulearn;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Boolean isFabOpen = false;

    @Bind(R.id.but3) Button but3;
    @Bind(R.id.but2) Button but2;
    @Bind(R.id.restbut) Button restbut;
    @Bind(R.id.edPhoneNum) EditText edPhoneNum;
    @Bind(R.id.edName) EditText edName;
    @Bind(R.id.fab) FloatingActionButton fab;
    @Bind(R.id.fab1) FloatingActionButton fab1;
    @Bind(R.id.fab2) FloatingActionButton fab2;

    private Animation fab_open,fab_close,rotate_forward,rotate_backward;
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        rotate_forward = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_forward);
        rotate_backward = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_backward);
        fab.setOnClickListener(this);
        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);
        but3.setOnClickListener(this);
        but2.setOnClickListener(this);
        restbut.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.fab:
                animateFAB();
                break;
            case R.id.fab1:
                Toast.makeText(MainActivity.this, "The FAB One", Toast.LENGTH_LONG).show();
                break;
            case R.id.fab2:
                Toast.makeText(MainActivity.this, "The FAB Two", Toast.LENGTH_LONG).show();
                break;
            case R.id.but2:
                Intent intent = new Intent(MainActivity.this, PageTwo.class);
                startActivity(intent);
                break;
            case R.id.but3:
                String sPhoneNum = edPhoneNum.getText().toString();
                Log.d (TAG, sPhoneNum);
                Intent intentPageThree = new Intent(MainActivity.this, PageThree.class);
                intentPageThree.putExtra("sPhoneNum",sPhoneNum);
                startActivity(intentPageThree);
                break;
            case R.id.restbut:
                String sName = edName.getText().toString();
                Log.d (TAG, sName);
                Intent restbutInt = new Intent(MainActivity.this, RestaurantsActivity.class);
                restbutInt.putExtra("sName", sName);
                startActivity(restbutInt);
                break;
        }
    }


    public void animateFAB(){
        if(isFabOpen){

            fab.startAnimation(rotate_backward);
            fab1.startAnimation(fab_close);
            fab2.startAnimation(fab_close);
            fab1.setClickable(false);
            fab2.setClickable(false);
            isFabOpen = false;

        } else {

            fab.startAnimation(rotate_forward);
            fab1.startAnimation(fab_open);
            fab2.startAnimation(fab_open);
            fab1.setClickable(true);
            fab2.setClickable(true);
            isFabOpen = true;

        }
    }

}

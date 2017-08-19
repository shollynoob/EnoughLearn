package visionstech.menulearn;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RestaurantsActivity extends AppCompatActivity {
    @Bind(R.id.location)TextView location;
    @Bind(R.id.listView)ListView listView;

    private String[] restaurants = new String[] {"Sweet Hereafter", "Cricket", "Hawthorne Fish House", "Viking Soul Food", "Red Square", "Horse Brass", "Dick's Kitchen", "Taco Bell", "Me Kha Noodle Bar", "La Bonita Taqueria", "Smokehouse Tavern", "Pembiche", "Kay's Bar", "Gnarly Grey", "Slappy Cakes", "Mi Mero Mole" };
    private String[] cuisines = new String[] {"Vegan Food", "Breakfast", "Fishs Dishs", "Scandinavian", "Coffee", "English Food", "Burgers", "Fast Food", "Noodle Soups", "Mexican", "BBQ", "Cuban", "Bar Food", "Sports Bar", "Breakfast", "Mexican" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        ButterKnife.bind(this);

        //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, restaurants);
       // listView.setAdapter(adapter);

        MyRestaurantsActivity adapter = new MyRestaurantsActivity(this, android.R.layout.simple_expandable_list_item_1, restaurants, cuisines);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String onTop = ((TextView)view).getText().toString();
                Toast.makeText(RestaurantsActivity.this, onTop,Toast.LENGTH_LONG).show();
            }
        });

        Typeface Teaspoon = Typeface.createFromAsset(getAssets(), "fonts/teaspoon.otf");
        Intent getlocation =getIntent();
        String outPlace = getlocation.getStringExtra("sName");
        location.setTypeface(Teaspoon);
        location.setText("The Location is " + outPlace);
    }
}

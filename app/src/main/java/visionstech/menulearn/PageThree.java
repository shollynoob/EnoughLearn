package visionstech.menulearn;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PageThree extends AppCompatActivity {
    private TextView thenum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_three);
        thenum = (TextView)findViewById(R.id.thenum);
        Typeface Teaspoon = Typeface.createFromAsset(getAssets(), "fonts/teaspoon.otf");
        Intent getTheNumber = getIntent();
        String numOut = getTheNumber.getStringExtra("sPhoneNum");
        thenum.setTypeface(Teaspoon);
        thenum.setText("The Phone Number that was Entered is " + numOut);

    }
}

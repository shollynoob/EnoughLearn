package visionstech.menulearn;

import android.content.Context;
import android.widget.ArrayAdapter;



public class MyRestaurantsActivity extends ArrayAdapter{
    private Context mContext;
    private String [] mRestaurants;
    private String [] mCuisines;

    public MyRestaurantsActivity(Context context, int resource, String [] mRestaurants, String [] mCuisines) {
        super(context, resource);
        this.mContext = mContext;
        this.mRestaurants = mRestaurants;
        this.mCuisines = mCuisines;
    }

    @Override
    public Object getItem(int position) {
        String restaurants = mRestaurants[position];
        String cuisines = mCuisines[position];
        return String.format("%s \nServes great: %s ", restaurants, cuisines);
    }

    @Override
    public int getCount() {
        return mRestaurants.length;
    }

}

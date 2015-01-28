package w2k15.com.moonlit.com.worldcup2015;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;

/**
 * Created by Sundeep on 1/28/2015.
 */
public class ScheduleActivity extends FragmentActivity {
    private FragmentTabHost mTabHost;
    private static final String ARG_PARAM1 = "SetNo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ScheduleActivity", "A oncreate");
        setContentView(R.layout.schedule);
        Log.d("ScheduleActivity", "2");

        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        Log.d("ScheduleActivity", "2");

        mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        Log.d("ScheduleActivity", "3");


        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, "set1");
        Log.d("ScheduleActivity", "4");

        mTabHost.addTab(
                mTabHost.newTabSpec("tab1").setIndicator("Set1", null),
                MatchSchedulesListFragment.class, args);
        Log.d("ScheduleActivity", "5");

        args.clear();
        args.clear();
        args.putString(ARG_PARAM1, "set2");
       mTabHost.addTab(
                mTabHost.newTabSpec("tab2").setIndicator("Set2", null),
               MatchSchedulesListFragment.class, args);


    }
}



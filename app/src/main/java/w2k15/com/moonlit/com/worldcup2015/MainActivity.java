package w2k15.com.moonlit.com.worldcup2015;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.content.res.Configuration;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener, PlayersFragment.OnFragmentInteractionListener {

    private ActionBarDrawerToggle mDrawerToggle;
    private ListView listView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        drawerLayout = (DrawerLayout) findViewById((R.id.drawerLayout));

        listView.setOnItemClickListener(this);

        mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, new Toolbar(getApplicationContext())
                , R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        drawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerToggle.setHomeAsUpIndicator(R.drawable.ic_drawer);
        mDrawerToggle.setDrawerIndicatorEnabled(true);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        //match fixtures
        if (id == 0) {
            fragmentManager.beginTransaction()
                    .replace(R.id.mainContent, MatchSchedulesListFragment.newInstance())
                    .commit();

        }
        if (id == 1)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.mainContent, PlayersFragment.newInstance())
                    .commit();
        }
        if (listView !=null)
        listView.setItemChecked(position, true);
        if(drawerLayout != null)
        drawerLayout.closeDrawer(listView);
    }

    @Override
    public void onFragmentInteraction(String id) {

    }
}

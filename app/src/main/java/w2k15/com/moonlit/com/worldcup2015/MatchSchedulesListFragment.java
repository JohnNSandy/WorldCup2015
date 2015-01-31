package w2k15.com.moonlit.com.worldcup2015;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MatchSchedulesListFragment extends ListFragment {

    public static MatchSchedulesListFragment newInstance() {
        MatchSchedulesListFragment fragment = new MatchSchedulesListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ScheduleListItem(getActivity(),
                android.R.layout.simple_list_item_1, (java.util.ArrayList<ScheduleData>) new Schedule().scheduleDataArray));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.matchlistlayout, container, false);
        Toast toast = Toast.makeText(getActivity().getApplicationContext(), "hi in match schedule fragment", Toast.LENGTH_LONG);
        return v;
    }
}
package w2k15.com.moonlit.com.worldcup2015;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ScheduleListItem extends ArrayAdapter<ScheduleData> {

    // declaring our ArrayList of items
    private ArrayList<ScheduleData> objects;

    /* here we must override the constructor for ArrayAdapter
    * the only variable we care about now is ArrayList<Item> objects,
    * because it is the list of objects we want to display.
    */
    public ScheduleListItem(Context context, int textViewResourceId, ArrayList<ScheduleData> objects) {
        super(context, textViewResourceId, objects);
        this.objects = objects;
    }

    /*
     * we are overriding the getView method here - this is what defines how each
     * list item will look.
     */
    public View getView(int position, View convertView, ViewGroup parent){

        // assign the view we are converting to a local variable
        View v = convertView;

        // first check to see if the view is null. if so, we have to inflate it.
        // to inflate it basically means to render, or show, the view.
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_item_schedule, null);
        }

		/*
		 * Recall that the variable position is sent in as an argument to this method.
		 * The variable simply refers to the position of the current object in the list. (The ArrayAdapter
		 * iterates through the list we sent it)
		 *
		 * Therefore, i refers to the current Item object.
		 */
        ScheduleData i = objects.get(position);

        if (i != null) {
            Schedule schedule = new Schedule();

            // This is how you obtain a reference to the TextViews.
            // These TextViews are created in the XML files we defined.

            TextView teams = (TextView) v.findViewById(R.id.teams);
            TextView place = (TextView) v.findViewById(R.id.place);
            TextView istTime = (TextView) v.findViewById(R.id.isttime);
            TextView gmtTime = (TextView) v.findViewById(R.id.gmttime);
            ImageView dayNite = (ImageView) v.findViewById(R.id.daynite);
            // check to see if each individual textview is null.
            // if not, assign some text!
            ScheduleData scheduleData = schedule.scheduleDataArray.get(position);

            if (teams != null){
                teams.setText(scheduleData.getTeams());
            }
            if (place != null){
                place.setText(scheduleData.getPlace());
            }
            if (istTime != null){
                istTime.setText(scheduleData.getIstTime());
            }
            if (gmtTime!= null){
                gmtTime.setText(scheduleData.getGmtTime());
            }
            if (dayNite!= null){
                if (scheduleData.getDayNite() =="day") {
                    dayNite.setImageResource(R.drawable.day1);
                }
                else
                {
                    dayNite.setImageResource(R.drawable.night1);
                }
            }
        }

        // the view must be returned to our activity
        return v;

    }

}



package de.fh_zwickau.timemanagement2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//https://www.journaldev.com/10416/android-listview-with-custom-adapter-example-tutorial
/**
 * Not final version
 */
public class TaskAdapter extends ArrayAdapter<Task> implements View.OnClickListener{
    private ArrayList<Task> tasks;
    Context mContext; //TODO WTF

    private static class ViewHolder{
        TextView txtText;
        TextView txtDate;
        ImageView imgUrgency;
    }

    public TaskAdapter(ArrayList<Task> tasks, @NonNull Context context) {
        super(context, R.layout.row_item, tasks);
        this.tasks = tasks;
        this.mContext = context;
    }

    @Override
    public void onClick(View v) {
        //TODO
    }

    private int lastPosition = -1;

    /**
     * TODO
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @NonNull
    @Override //TODO
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Task task = getItem(position);
        ViewHolder viewHolder;

        final View result;

        if(convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item, parent, false);
            viewHolder.txtText = convertView.findViewById(R.id.taskText);
            viewHolder.txtDate = convertView.findViewById(R.id.dateText);
            //viewHolder.imgUrgency = convertView.findViewById()
            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }
        Animation animation = AnimationUtils.loadAnimation(mContext,
                (position > lastPosition)? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.txtText.setText(task.getText());
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        String currentDate = df.format(task.getDate());
        viewHolder.txtDate.setText(currentDate);

        //viewHolder.imgUrgency.set
        //return super.getView(position, convertView, parent);
        return convertView;
    }
}

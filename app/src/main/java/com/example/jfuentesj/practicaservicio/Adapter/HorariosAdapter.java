package com.example.jfuentesj.practicaservicio.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jfuentesj.practicaservicio.Models.YelmocinesResponse;
import com.example.jfuentesj.practicaservicio.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.zip.Inflater;

/**
 * Created by josealbertofuentesjaramillo on 27/03/18.
 */

public class HorariosAdapter extends RecyclerView.Adapter<HorariosAdapter.ItemViewHolder> {
    private List<YelmocinesResponse.Schedules.Dates.Formats.Showtimes> schedulesList;

    public HorariosAdapter(List<YelmocinesResponse.Schedules.Dates.Formats.Showtimes> schedulesList){
        this.schedulesList = schedulesList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movies_horarios, parent, false);
        return new HorariosAdapter.ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        YelmocinesResponse.Schedules.Dates.Formats.Showtimes schedules = schedulesList.get(position);
        holder.tvShowHorario.setText(dateFormat(schedules.getDatetime()));
        holder.tvShowScreen.setText(String.valueOf(schedules.getScreen()));
    }

    @Override
    public int getItemCount() {
        return schedulesList.size();
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView tvShowHorario, tvShowScreen;


        public ItemViewHolder(View itemView) {
            super(itemView);
            tvShowHorario = (TextView) itemView.findViewById(R.id.tv_show_horario);
            tvShowScreen = (TextView) itemView.findViewById(R.id.tv_show_screen);
        }
    }

    private String dateFormat(String date){
        String formatedDate = "";
        try{
            SimpleDateFormat parse = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd h:mm a", Locale.ENGLISH);
            Date aux = parse.parse(date);
            formatedDate = formatter.format(aux);
        }catch (ParseException e) {
            e.printStackTrace();
        }
        return formatedDate;
    }
}

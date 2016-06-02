package com.wokkaflokka.calabashrecyclerviewtest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wokkaflokka.calabashrecyclerviewtest.R;
import com.wokkaflokka.calabashrecyclerviewtest.dtos.Issue707Model;

public class ConfigurationTogglingAdapter extends BaseAdapter {

    private final String title;
    private final String publishedPhotos;
    private final String archivedPhotos;
    private final LayoutInflater inflater;
    private Issue707Model model;

    public ConfigurationTogglingAdapter(Context context, Issue707Model model) {
        super();
        this.inflater = LayoutInflater.from(context);
        this.model = model;
        title = "Calabash Issue #707";
        publishedPhotos = "Published";
        archivedPhotos = "Archived";
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public String getItem(int position) {
        if (position == 0) {
            return publishedPhotos;
        }
        return archivedPhotos;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (convertView == null) {
            view = inflater.inflate(R.layout.list_item_spinner_actionbar, parent, false);
        }

        TextView textView = (TextView)view.findViewById(R.id.item_text);
        textView.setText(getItem(position));
        return view;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.view_titled_spinner_list_item, parent, false);
        }
        int items = position == 0 ? model.getPublishedPhotos().size() : model.getArchivedPhotos().size();
        String phrase = String.format("%s (%s)", getItem(position), items);

        TextView title = (TextView) convertView.findViewById(R.id.spinner_title);
        TextView subtitle = (TextView) convertView.findViewById(R.id.spinner_subtitle);

        title.setText(this.title);
        subtitle.setText(phrase);

        return convertView;
    }
}

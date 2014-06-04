package com.example.baseadapters;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Main extends Activity {

	ListView list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		list = (ListView) findViewById(R.id.listView1);
		list.setAdapter(new MyAdapter(this));

	}

	class SingleRow {
		String title;
		String description;
		int image;

		SingleRow(String title, String description, int image) {
			this.title = title;
			this.description = description;
			this.image = image;
		}

	}

	class MyAdapter extends BaseAdapter {
		ArrayList<SingleRow> list;
		Context context;

		MyAdapter(Context c) {
			context = c;
			list = new ArrayList<Main.SingleRow>();
			Resources res = c.getResources();
			String[] Countries = res.getStringArray(R.array.Countries);
			String[] descriptions = res.getStringArray(R.array.descriptions);
			int[] images = { R.drawable.ireland, R.drawable.italy,
					R.drawable.norway, R.drawable.portugal,
					R.drawable.scotland, R.drawable.spain, R.drawable.sweden,
					R.drawable.switzerland };
			for (int i = 0; i < 8; i++) {
				list.add(new SingleRow(Countries[i], descriptions[i], images[i]));
			}
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public Object getItem(int i) {
			// TODO Auto-generated method stub
			return list.get(i);
		}

		@Override
		public long getItemId(int i) {
			// TODO Auto-generated method stub
			return i;
		}

		@Override
		public View getView(int i, View view, ViewGroup viewGroup) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(LAYOUT_INFLATER_SERVICE);
			View row = inflater.inflate(R.layout.single_row, viewGroup, false);
			TextView title = (TextView) row.findViewById(R.id.textView1);
			TextView description = (TextView) row.findViewById(R.id.textView2);
			ImageView image = (ImageView) row.findViewById(R.id.imageView1);
			SingleRow temp = list.get(i);

			title.setText(temp.title);
			description.setText(temp.description);
			image.setImageResource(temp.image);
			return row;
		}

	}

}

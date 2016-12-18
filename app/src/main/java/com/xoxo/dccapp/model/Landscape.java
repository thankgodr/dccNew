package com.xoxo.dccapp.model;

import com.xoxo.dccapp.R;

import java.util.ArrayList;



public class Landscape {

	private int imageID;
	private String title;
	private String description;

	public int getImageID() {
		return imageID;
	}

	public void setImageID(int imageID) {
		this.imageID = imageID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static ArrayList<Landscape> getData() {

		ArrayList<Landscape> dataList = new ArrayList<>();

		int[] images = {
				R.drawable.logo, R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo
		};

		for (int i = 0; i <  5; i++) {

			Landscape landscape = new Landscape();
			landscape.setImageID(images[0]);
			landscape.setTitle("Testint " + i);

			dataList.add(landscape);
		}

		return dataList;
	}
}

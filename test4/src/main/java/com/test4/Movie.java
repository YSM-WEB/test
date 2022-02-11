package com.test4;

import java.util.Date;


public class Movie {
	private int display; 
	private Item[] items; 

	public int getDisplay() {
		return display;
	}

	public void setDisplay(int display) {
		this.display = display;
	}

	public Item[] getItems() {
		return items;
	}

	public void setItems(Item[] items) {
		this.items = items;
	}

	static class Item { 
		public String title; 
		public String link; 
		public String image; 
		public String subtitle; 
		public Date pubDate; 
		public String director; 
		public String actor; 
		public float userRating;
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getLink() {
			return link;
		}
		public void setLink(String link) {
			this.link = link;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public String getSubtitle() {
			return subtitle;
		}
		public void setSubtitle(String subtitle) {
			this.subtitle = subtitle;
		}
		public Date getPubDate() {
			return pubDate;
		}
		public void setPubDate(Date pubDate) {
			this.pubDate = pubDate;
		}
		public String getDirector() {
			return director;
		}
		public void setDirector(String director) {
			this.director = director;
		}
		public String getActor() {
			return actor;
		}
		public void setActor(String actor) {
			this.actor = actor;
		}
		public float getUserRating() {
			return userRating;
		}
		public void setUserRating(float userRating) {
			this.userRating = userRating;
		} 
		
	}

	
}

package com.app.criteria;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "newspaper_table")
public class NewsPaperDTO implements Serializable {

	@Column(name = "recentnews")
	private String recentNews;
	@Column(name = "newspaper_name")
	@Id
	private String newsPaperName;
	@Column(name = "no_of_pages")
	private int noOfPages;
	@Column(name = "language")
	private String language;

	public String getRecentNews() {
		return recentNews;
	}

	public void setRecentNews(String recentNews) {
		this.recentNews = recentNews;
	}

	public String getNewsPaperName() {
		return newsPaperName;
	}

	public void setNewsPaperName(String newsPaperName) {
		this.newsPaperName = newsPaperName;
	}

	public int getNoOfPages() {
		return noOfPages;
	}

	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}

package com.realTimeApp.Dictionary.Entities;

import java.util.Date;

public class Word {
	private Integer id;
	private String word;
	private String meaning;
	private String partOfSpeech;
	private String example;
	private Date creationTm;
	private Date lastModifiedTm;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public String getPartOfSpeech() {
		return partOfSpeech;
	}

	public void setPartOfSpeech(String partOfSpeech) {
		this.partOfSpeech = partOfSpeech;
	}

	public String getExample() {
		return example;
	}

	public void setExample(String example) {
		this.example = example;
	}

	public Date getCreationTm() {
		return creationTm;
	}

	public void setCreationTm(Date creationTm) {
		this.creationTm = creationTm;
	}

	public Date getLastModifiedTm() {
		return lastModifiedTm;
	}

	public void setLastModifiedTm(Date lastModifiedTm) {
		this.lastModifiedTm = lastModifiedTm;
	}
}

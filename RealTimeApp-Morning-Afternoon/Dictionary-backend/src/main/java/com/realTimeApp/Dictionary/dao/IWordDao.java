package com.realTimeApp.Dictionary.dao;

import java.util.List;

import com.realTimeApp.Dictionary.Entities.Word;

public interface IWordDao {
	public Word save(Word word);
	public List<Word> getAll();
	public int delete(int id);
	public int update(Word word);
	public List<Word> getByPattern(String pattern);
}

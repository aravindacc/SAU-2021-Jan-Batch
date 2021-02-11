package com.realTimeApp.Dictionary.Crud.Services;

import java.util.List;

import com.realTimeApp.Dictionary.Entities.Word;

public interface IWordService {
	public Word save(Word word);
	
	public List<Word> getAll();
	
	public boolean delete(int id);
	
	public boolean update(Word word);

	public List<Word> searchPattern(String pattern);
}

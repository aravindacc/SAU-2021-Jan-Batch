package com.realTimeApp.Dictionary.Crud.Services.Imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realTimeApp.Dictionary.Crud.Services.IWordService;
import com.realTimeApp.Dictionary.Entities.Word;
import com.realTimeApp.Dictionary.dao.IWordDao;

@Service
public class WordService implements IWordService{
	@Autowired
	IWordDao iWordDao;
	
	@Override
	public Word save(Word word) {
		return iWordDao.save(word);
	}

	@Override
	public List<Word> getAll() {
		// TODO Auto-generated method stub
		return iWordDao.getAll();
	}
	
	@Override
	public boolean delete(int id) {
		int rowsAffected = iWordDao.delete(id);
		if (rowsAffected == 1) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean update(Word word) {
		int rowsAffected = iWordDao.update(word);
		if (rowsAffected == 1) {
			return true;
		}
		return false;
	}

	@Override
	public List<Word> searchPattern(String pattern) {
		return iWordDao.getByPattern(pattern);
	}
}

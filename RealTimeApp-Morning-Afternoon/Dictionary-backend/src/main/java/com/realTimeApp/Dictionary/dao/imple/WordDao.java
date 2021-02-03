package com.realTimeApp.Dictionary.dao.imple;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.realTimeApp.Dictionary.Entities.Word;
import com.realTimeApp.Dictionary.dao.IWordDao;
import com.realTimeApp.Dictionary.queries.WordQueries;
import com.realTimeApp.Dictionary.table.constants.WordTableConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class WordDao implements IWordDao {
	
	private static Logger logger = LoggerFactory.getLogger(WordDao.class);
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Word save(Word word) {
		final KeyHolder holder = new GeneratedKeyHolder();
		String sql = "INSERT INTO WORDS ( WORD , MEANING , PART_OF_SPEECH , EXAMPLE , CREATION_TM , LAST_MODIFIED_TM ) "
				+ " VALUES ( :WORD , :MEANING , :PART_OF_SPEECH , :EXAMPLE , :CREATION_TM , :LAST_MODIFIED_TM )";
		MapSqlParameterSource srcMap = new MapSqlParameterSource();
		srcMap.addValue("WORD", word.getWord());
		srcMap.addValue("MEANING",word.getMeaning());
		srcMap.addValue("PART_OF_SPEECH",word.getPartOfSpeech());
		srcMap.addValue("EXAMPLE",word.getExample());
		srcMap.addValue("CREATION_TM",word.getCreationTm());
		srcMap.addValue("LAST_MODIFIED_TM",word.getLastModifiedTm());
		
		namedParameterJdbcTemplate.update(sql, srcMap,
		        holder, new String[] {"ID"});
		word.setId(holder.getKey().intValue());
		return word;
	}

	@Override
	public List<Word> getAll() {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM WORDS";
		return namedParameterJdbcTemplate.query(sql, (resultSet, rowNum)->{
			Word word = new Word();
			word.setId(resultSet.getInt("ID"));
			word.setWord(resultSet.getString("WORD"));
			word.setCreationTm(resultSet.getDate("CREATION_TM"));
			word.setExample(resultSet.getString("EXAMPLE"));
			word.setMeaning(resultSet.getString("MEANING"));
			word.setPartOfSpeech(resultSet.getString("PART_OF_SPEECH"));
			word.setLastModifiedTm(resultSet.getDate("LAST_MODIFIED_TM"));
			return word;
		});
	}

	@Override
	public int delete(int id) {
		logger.info(WordQueries.DELETE_QUERY);
		MapSqlParameterSource srcMap = new MapSqlParameterSource();
		srcMap.addValue(WordTableConstants.ID, id);
		return namedParameterJdbcTemplate.update(WordQueries.DELETE_QUERY, srcMap);
	}
	
	@Override
	public int update(Word word) {
		MapSqlParameterSource srcMap = new MapSqlParameterSource();
		String sql="UPDATE WORDS SET WORD =:WORD,MEANING =:MEANING," +
				"PART_OF_SPEECH =:PART_OF_SPEECH,EXAMPLE =:EXAMPLE,LAST_MODIFIED_TM =:LAST_MODIFIED_TM " +
				"  WHERE ID =:ID";
		Date last_modify=new Date(System.currentTimeMillis());
		srcMap.addValue("ID", word.getId());
		srcMap.addValue("WORD", word.getWord());
		srcMap.addValue("MEANING",word.getMeaning());
		srcMap.addValue("PART_OF_SPEECH",word.getPartOfSpeech());
		srcMap.addValue("EXAMPLE",word.getExample());
		srcMap.addValue("CREATION_TM",word.getCreationTm());
		srcMap.addValue("LAST_MODIFIED_TM",last_modify);
		return namedParameterJdbcTemplate.update(sql,srcMap);
	}
	
    @Override
    public List<Word> getByPattern(String pattern) {
        MapSqlParameterSource srcMap = new MapSqlParameterSource();
        srcMap.addValue(WordTableConstants.WORD, "%" + pattern + "%");
        String sql="SELECT * FROM  WORDS where WORD LIKE :WORD";
        return namedParameterJdbcTemplate.query(sql, srcMap, (resultSet, rowNum) -> {
            Word word = new Word();
            word.setId(resultSet.getInt(WordTableConstants.ID));
            word.setCreationTm(resultSet.getDate(WordTableConstants.CREATION_TM));
            word.setExample(resultSet.getString(WordTableConstants.EXAMPLE));
            word.setLastModifiedTm(resultSet.getDate(WordTableConstants.LAST_MODIFIED_TM));
            word.setMeaning(resultSet.getString(WordTableConstants.MEANING));
            word.setPartOfSpeech(resultSet.getString(WordTableConstants.POS));
            word.setWord(resultSet.getString(WordTableConstants.WORD));
            return word;
        });
    }
}

package com.realTimeApp.Dictionary.queries;

import com.realTimeApp.Dictionary.table.constants.WordTableConstants;

public class WordQueries {

	private WordQueries() {

	}

	public static final String DELETE_QUERY = "DELETE FROM " + WordTableConstants.TABLE_NAME + " WHERE "
			+ WordTableConstants.ID + " =:" + WordTableConstants.ID;
}

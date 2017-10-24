package com.flytxt.grapho.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author shiju.john
 *
 */
public abstract class FilterUtils {
	
	/**
	 * 
	 * @param fieldName
	 * @param operator
	 * @param value
	 * @return
	 */
	public static final List<FilterCriteria> getFilterCriteriaList(final String fieldName, final String operator,
			final String value) {
		
		FilterCriteria criteria =  new FilterCriteria();
		criteria.setKey(fieldName);
		criteria.setOperation(operator);
		criteria.setValue(value);
		List<FilterCriteria> criterias = new ArrayList<>();
		criterias.add(criteria);
		return criterias;

	}

}

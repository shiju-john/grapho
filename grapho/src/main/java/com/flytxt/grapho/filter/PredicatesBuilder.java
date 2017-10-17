package com.flytxt.grapho.filter;

import java.util.ArrayList;
import java.util.List;

import com.querydsl.core.types.dsl.BooleanExpression;
/**
 * 
 * @author shiju.john
 *
 * @param <T> 
 */
public class PredicatesBuilder<T> {
	  
	private List<FilterCriteria> params;
	  
    public PredicatesBuilder() {
        params = new ArrayList<>();
    }
	 
    public PredicatesBuilder<T> with(FilterCriteria criteria) {	   
        params.add(criteria);
        return this;
    }
	
	/***
	 * 
	 * @param entity
	 * @return
	 */
    @SuppressWarnings("rawtypes")
	public BooleanExpression build(Class  entity,String aliaceName) {
        if (params.size() == 0) {
            return null;
        }
 
        List<BooleanExpression> predicates = new ArrayList<>();
        FilterPredicate<T> predicate;
        for (FilterCriteria param : params) {
            predicate = new FilterPredicate<T>(param);
            BooleanExpression exp = predicate.getPredicate(entity,aliaceName);
            if (exp != null) {
                predicates.add(exp);
            }
        }
 
        BooleanExpression result = predicates.get(0);
        for (int i = 1; i < predicates.size(); i++) {
            result = result.and(predicates.get(i));
        }
        return result;
    }

}

package com.flytxt.grapho.filter;

import com.flytxt.grapho.entity.FlyEntity;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.types.dsl.StringPath;

/**
 * 
 * @author shiju.john
 *
 * @param <T>
 */
public class FilterPredicate<T>{
	
	private FilterCriteria  criteria ;
	
	
	public FilterPredicate(FilterCriteria criteria) {
		this.criteria = criteria;
	}

	
	/**
	 * 
	 * @param entity
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BooleanExpression getPredicate(Class entity,String aliaceName) {		
		PathBuilder<? extends FlyEntity> entityPath = new PathBuilder<>(entity, aliaceName);
         if (isNumeric(criteria.getValue())) {
            NumberPath<Integer> path = entityPath.getNumber(criteria.getKey(), Integer.class);
            int value = Integer.parseInt(criteria.getValue().toString());
            switch (criteria.getOperation()) {
                case "=":
                    return path.eq(value);
                case ">":
                    return path.goe(value);
                case "<":
                    return path.loe(value);
            }
        } 
        else {
            StringPath path = entityPath.getString(criteria.getKey());
            if (criteria.getOperation().equalsIgnoreCase("like")) { 
            	return path.contains(criteria.getValue().toString());
            }else if (criteria.getOperation().equalsIgnoreCase("=")){
            	return path.equalsIgnoreCase(criteria.getValue().toString());
            }
        }
        return null;
    }


	private boolean isNumeric(String value) {
		// TODO Auto-generated method stub
		return false;
	}

}

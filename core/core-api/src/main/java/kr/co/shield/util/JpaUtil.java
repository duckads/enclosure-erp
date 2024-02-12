package kr.co.shield.util;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.*;
import kr.co.shield.utility.NumberUtils;
import org.apache.commons.text.CaseUtils;
import org.hibernate.query.sql.internal.NativeQueryImpl;
import org.slf4j.Logger;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JpaUtil {
	
	public static Object paging(Map<String, Object> props) {
		Object rtnObj = null;
		
		String orderBy = (String)props.get("orderBy"); // reg_dt|reg_dt-A|reg_dt-D
		int pageIdx = NumberUtils.getNumber(props.get("pageIdx")); // 1
		int pageLen = NumberUtils.getNumber(props.get("pageLen")); // 10
		
		Sort sort = null;
		if (orderBy != null) {
			Direction direction = null;
			if (orderBy.endsWith("-D")) {
				direction = Direction.DESC;
			} else {
				direction = Direction.ASC;
			}
			orderBy = orderBy.replaceAll("\\-(A|D)$", "");
			sort = Sort.by(direction, CaseUtils.toCamelCase(orderBy, false, '_'));
		}
		PageRequest pageRequest = null;
		if (pageLen > 0) {
			pageRequest = PageRequest.of(pageIdx, pageLen, sort);
			if (sort != null) {
				pageRequest = pageRequest.withSort(sort);
			}
			rtnObj = pageRequest;
		} else if (sort != null) {
			rtnObj = sort;
		}
		
		return rtnObj;
	}
	
	@SuppressWarnings("rawtypes")
	public static void print(Logger log, Query query, CharSequence ... queries) {
		String queryStr = "";
		if (query instanceof NativeQueryImpl) {
			queryStr = ((NativeQueryImpl)query).getQueryString();
		} else if (queries.length > 0) {
			queryStr = String.valueOf(queries[0]);
		}
		log.info("Query# {}Param# {}", queryStr, query.getParameters().stream()
				.map(k -> String.join("=", k.getName(), query.getParameterValue(k.getName()).toString()))
				.collect(Collectors.joining(", ", "{ ", " }")));
	}
	
	public static <T> Specification<T> equal(Class<T> cls, String field, Object value) {
		return new Specification<T>() {
			private static final long serialVersionUID = 1L;
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.equal(path(root, field), value);
			}
		};
	}
	public static <T> Specification<T> notEqual(Class<T> cls, String field, Object value) {
		return new Specification<T>() {
			private static final long serialVersionUID = 1L;
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.notEqual(path(root, field), value);
			}
		};
	}
	public static <T> Specification<T> compare(Class<T> cls, String field, Operator operator, Object value) {
		return new Specification<T>() {
			private static final long serialVersionUID = 1L;
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				Predicate predicate = null;
				switch (operator) {
				case LT:
					if (value instanceof Integer)
						predicate = builder.lessThan(path(root, field), (Integer)value);
					else if (value instanceof Date)
						predicate = builder.lessThan(path(root, field), (Date)value);
					break;
				case LTE:
					if (value instanceof Integer)
						predicate = builder.lessThanOrEqualTo(path(root, field), (Integer)value);
					else if (value instanceof Date)
						predicate = builder.lessThanOrEqualTo(path(root, field), (Date)value);
					break;
				case GT:
					if (value instanceof Integer)
						predicate = builder.greaterThan(path(root, field), (Integer)value);
					else if (value instanceof Date)
						predicate = builder.greaterThan(path(root, field), (Date)value);
					break;
				case GTE:
					if (value instanceof Integer)
						predicate = builder.greaterThanOrEqualTo(path(root, field), (Integer)value);
					else if (value instanceof Date)
						predicate = builder.greaterThanOrEqualTo(path(root, field), (Date)value);
					break;
				}
				return predicate;
			}
		};
	}
	
	public static <T> Specification<T> like(Class<T> cls, String field, String value) {
		return new Specification<T>() {
			private static final long serialVersionUID = 1L;
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				if (path(root, field).getJavaType() == String.class) {
					return builder.like(path(root, field), "%" + value + "%");
				} else {
					return builder.equal(path(root, field), value);
				}
			}
		};
	}
	
	public static <T> Specification<T> between(Class<T> cls, String field, Date psDate, Date peDate) {
		return new Specification<T>() {
			private static final long serialVersionUID = 1L;
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.between(path(root, field), psDate, peDate);
			}
		};
	}
	
	public static <T> Specification<T> in(Class<T> cls, String field, List<?> values) {
		return new Specification<T>() {
			private static final long serialVersionUID = 1L;
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return path(root, field).in(values);
			}
		};
	}
	
	// values.size == 0일 때에는 사용 금지
	public static <T> Specification<T> notIn(Class<T> cls, String field, List<?> values) {
		return new Specification<T>() {
			private static final long serialVersionUID = 1L;
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return path(root, field).in(values).not();
			}
		};
	}
	
	public enum Operator {
		LT, LTE, GT, GTE;
	}
	
	private static <T, Y> Path<Y> path(Root<T> root, String field) {
		Path<Y> path = null;
		if (field.indexOf(".") > -1) {
			String[] args = field.split("\\.");
			path = root.get(args[0]).get(args[1]);
		} else {
			path = root.get(field);
		}
		return path;
	}
	
}

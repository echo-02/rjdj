package com.accp.domain;

import java.util.ArrayList;
import java.util.List;

public class JurisdictionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JurisdictionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andJsidIsNull() {
            addCriterion("jsid is null");
            return (Criteria) this;
        }

        public Criteria andJsidIsNotNull() {
            addCriterion("jsid is not null");
            return (Criteria) this;
        }

        public Criteria andJsidEqualTo(Integer value) {
            addCriterion("jsid =", value, "jsid");
            return (Criteria) this;
        }

        public Criteria andJsidNotEqualTo(Integer value) {
            addCriterion("jsid <>", value, "jsid");
            return (Criteria) this;
        }

        public Criteria andJsidGreaterThan(Integer value) {
            addCriterion("jsid >", value, "jsid");
            return (Criteria) this;
        }

        public Criteria andJsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("jsid >=", value, "jsid");
            return (Criteria) this;
        }

        public Criteria andJsidLessThan(Integer value) {
            addCriterion("jsid <", value, "jsid");
            return (Criteria) this;
        }

        public Criteria andJsidLessThanOrEqualTo(Integer value) {
            addCriterion("jsid <=", value, "jsid");
            return (Criteria) this;
        }

        public Criteria andJsidIn(List<Integer> values) {
            addCriterion("jsid in", values, "jsid");
            return (Criteria) this;
        }

        public Criteria andJsidNotIn(List<Integer> values) {
            addCriterion("jsid not in", values, "jsid");
            return (Criteria) this;
        }

        public Criteria andJsidBetween(Integer value1, Integer value2) {
            addCriterion("jsid between", value1, value2, "jsid");
            return (Criteria) this;
        }

        public Criteria andJsidNotBetween(Integer value1, Integer value2) {
            addCriterion("jsid not between", value1, value2, "jsid");
            return (Criteria) this;
        }

        public Criteria andParentidIsNull() {
            addCriterion("parentid is null");
            return (Criteria) this;
        }

        public Criteria andParentidIsNotNull() {
            addCriterion("parentid is not null");
            return (Criteria) this;
        }

        public Criteria andParentidEqualTo(Integer value) {
            addCriterion("parentid =", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotEqualTo(Integer value) {
            addCriterion("parentid <>", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThan(Integer value) {
            addCriterion("parentid >", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("parentid >=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThan(Integer value) {
            addCriterion("parentid <", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThanOrEqualTo(Integer value) {
            addCriterion("parentid <=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidIn(List<Integer> values) {
            addCriterion("parentid in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotIn(List<Integer> values) {
            addCriterion("parentid not in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidBetween(Integer value1, Integer value2) {
            addCriterion("parentid between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotBetween(Integer value1, Integer value2) {
            addCriterion("parentid not between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andJsnameIsNull() {
            addCriterion("jsname is null");
            return (Criteria) this;
        }

        public Criteria andJsnameIsNotNull() {
            addCriterion("jsname is not null");
            return (Criteria) this;
        }

        public Criteria andJsnameEqualTo(String value) {
            addCriterion("jsname =", value, "jsname");
            return (Criteria) this;
        }

        public Criteria andJsnameNotEqualTo(String value) {
            addCriterion("jsname <>", value, "jsname");
            return (Criteria) this;
        }

        public Criteria andJsnameGreaterThan(String value) {
            addCriterion("jsname >", value, "jsname");
            return (Criteria) this;
        }

        public Criteria andJsnameGreaterThanOrEqualTo(String value) {
            addCriterion("jsname >=", value, "jsname");
            return (Criteria) this;
        }

        public Criteria andJsnameLessThan(String value) {
            addCriterion("jsname <", value, "jsname");
            return (Criteria) this;
        }

        public Criteria andJsnameLessThanOrEqualTo(String value) {
            addCriterion("jsname <=", value, "jsname");
            return (Criteria) this;
        }

        public Criteria andJsnameLike(String value) {
            addCriterion("jsname like", value, "jsname");
            return (Criteria) this;
        }

        public Criteria andJsnameNotLike(String value) {
            addCriterion("jsname not like", value, "jsname");
            return (Criteria) this;
        }

        public Criteria andJsnameIn(List<String> values) {
            addCriterion("jsname in", values, "jsname");
            return (Criteria) this;
        }

        public Criteria andJsnameNotIn(List<String> values) {
            addCriterion("jsname not in", values, "jsname");
            return (Criteria) this;
        }

        public Criteria andJsnameBetween(String value1, String value2) {
            addCriterion("jsname between", value1, value2, "jsname");
            return (Criteria) this;
        }

        public Criteria andJsnameNotBetween(String value1, String value2) {
            addCriterion("jsname not between", value1, value2, "jsname");
            return (Criteria) this;
        }

        public Criteria andCatalogIsNull() {
            addCriterion("catalog is null");
            return (Criteria) this;
        }

        public Criteria andCatalogIsNotNull() {
            addCriterion("catalog is not null");
            return (Criteria) this;
        }

        public Criteria andCatalogEqualTo(Integer value) {
            addCriterion("catalog =", value, "catalog");
            return (Criteria) this;
        }

        public Criteria andCatalogNotEqualTo(Integer value) {
            addCriterion("catalog <>", value, "catalog");
            return (Criteria) this;
        }

        public Criteria andCatalogGreaterThan(Integer value) {
            addCriterion("catalog >", value, "catalog");
            return (Criteria) this;
        }

        public Criteria andCatalogGreaterThanOrEqualTo(Integer value) {
            addCriterion("catalog >=", value, "catalog");
            return (Criteria) this;
        }

        public Criteria andCatalogLessThan(Integer value) {
            addCriterion("catalog <", value, "catalog");
            return (Criteria) this;
        }

        public Criteria andCatalogLessThanOrEqualTo(Integer value) {
            addCriterion("catalog <=", value, "catalog");
            return (Criteria) this;
        }

        public Criteria andCatalogIn(List<Integer> values) {
            addCriterion("catalog in", values, "catalog");
            return (Criteria) this;
        }

        public Criteria andCatalogNotIn(List<Integer> values) {
            addCriterion("catalog not in", values, "catalog");
            return (Criteria) this;
        }

        public Criteria andCatalogBetween(Integer value1, Integer value2) {
            addCriterion("catalog between", value1, value2, "catalog");
            return (Criteria) this;
        }

        public Criteria andCatalogNotBetween(Integer value1, Integer value2) {
            addCriterion("catalog not between", value1, value2, "catalog");
            return (Criteria) this;
        }

        public Criteria andPathIsNull() {
            addCriterion("path is null");
            return (Criteria) this;
        }

        public Criteria andPathIsNotNull() {
            addCriterion("path is not null");
            return (Criteria) this;
        }

        public Criteria andPathEqualTo(String value) {
            addCriterion("path =", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotEqualTo(String value) {
            addCriterion("path <>", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThan(String value) {
            addCriterion("path >", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThanOrEqualTo(String value) {
            addCriterion("path >=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThan(String value) {
            addCriterion("path <", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThanOrEqualTo(String value) {
            addCriterion("path <=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLike(String value) {
            addCriterion("path like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotLike(String value) {
            addCriterion("path not like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathIn(List<String> values) {
            addCriterion("path in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotIn(List<String> values) {
            addCriterion("path not in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathBetween(String value1, String value2) {
            addCriterion("path between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotBetween(String value1, String value2) {
            addCriterion("path not between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andEnnameIsNull() {
            addCriterion("enname is null");
            return (Criteria) this;
        }

        public Criteria andEnnameIsNotNull() {
            addCriterion("enname is not null");
            return (Criteria) this;
        }

        public Criteria andEnnameEqualTo(String value) {
            addCriterion("enname =", value, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameNotEqualTo(String value) {
            addCriterion("enname <>", value, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameGreaterThan(String value) {
            addCriterion("enname >", value, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameGreaterThanOrEqualTo(String value) {
            addCriterion("enname >=", value, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameLessThan(String value) {
            addCriterion("enname <", value, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameLessThanOrEqualTo(String value) {
            addCriterion("enname <=", value, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameLike(String value) {
            addCriterion("enname like", value, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameNotLike(String value) {
            addCriterion("enname not like", value, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameIn(List<String> values) {
            addCriterion("enname in", values, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameNotIn(List<String> values) {
            addCriterion("enname not in", values, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameBetween(String value1, String value2) {
            addCriterion("enname between", value1, value2, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameNotBetween(String value1, String value2) {
            addCriterion("enname not between", value1, value2, "enname");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
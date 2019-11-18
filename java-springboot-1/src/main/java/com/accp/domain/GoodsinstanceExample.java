package com.accp.domain;

import java.util.ArrayList;
import java.util.List;

public class GoodsinstanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsinstanceExample() {
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

        public Criteria andGiidIsNull() {
            addCriterion("giid is null");
            return (Criteria) this;
        }

        public Criteria andGiidIsNotNull() {
            addCriterion("giid is not null");
            return (Criteria) this;
        }

        public Criteria andGiidEqualTo(Integer value) {
            addCriterion("giid =", value, "giid");
            return (Criteria) this;
        }

        public Criteria andGiidNotEqualTo(Integer value) {
            addCriterion("giid <>", value, "giid");
            return (Criteria) this;
        }

        public Criteria andGiidGreaterThan(Integer value) {
            addCriterion("giid >", value, "giid");
            return (Criteria) this;
        }

        public Criteria andGiidGreaterThanOrEqualTo(Integer value) {
            addCriterion("giid >=", value, "giid");
            return (Criteria) this;
        }

        public Criteria andGiidLessThan(Integer value) {
            addCriterion("giid <", value, "giid");
            return (Criteria) this;
        }

        public Criteria andGiidLessThanOrEqualTo(Integer value) {
            addCriterion("giid <=", value, "giid");
            return (Criteria) this;
        }

        public Criteria andGiidIn(List<Integer> values) {
            addCriterion("giid in", values, "giid");
            return (Criteria) this;
        }

        public Criteria andGiidNotIn(List<Integer> values) {
            addCriterion("giid not in", values, "giid");
            return (Criteria) this;
        }

        public Criteria andGiidBetween(Integer value1, Integer value2) {
            addCriterion("giid between", value1, value2, "giid");
            return (Criteria) this;
        }

        public Criteria andGiidNotBetween(Integer value1, Integer value2) {
            addCriterion("giid not between", value1, value2, "giid");
            return (Criteria) this;
        }

        public Criteria andGidIsNull() {
            addCriterion("gid is null");
            return (Criteria) this;
        }

        public Criteria andGidIsNotNull() {
            addCriterion("gid is not null");
            return (Criteria) this;
        }

        public Criteria andGidEqualTo(Integer value) {
            addCriterion("gid =", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotEqualTo(Integer value) {
            addCriterion("gid <>", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThan(Integer value) {
            addCriterion("gid >", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThanOrEqualTo(Integer value) {
            addCriterion("gid >=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThan(Integer value) {
            addCriterion("gid <", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThanOrEqualTo(Integer value) {
            addCriterion("gid <=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidIn(List<Integer> values) {
            addCriterion("gid in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotIn(List<Integer> values) {
            addCriterion("gid not in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidBetween(Integer value1, Integer value2) {
            addCriterion("gid between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotBetween(Integer value1, Integer value2) {
            addCriterion("gid not between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andBarcodeIsNull() {
            addCriterion("barcode is null");
            return (Criteria) this;
        }

        public Criteria andBarcodeIsNotNull() {
            addCriterion("barcode is not null");
            return (Criteria) this;
        }

        public Criteria andBarcodeEqualTo(String value) {
            addCriterion("barcode =", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeNotEqualTo(String value) {
            addCriterion("barcode <>", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeGreaterThan(String value) {
            addCriterion("barcode >", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeGreaterThanOrEqualTo(String value) {
            addCriterion("barcode >=", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeLessThan(String value) {
            addCriterion("barcode <", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeLessThanOrEqualTo(String value) {
            addCriterion("barcode <=", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeLike(String value) {
            addCriterion("barcode like", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeNotLike(String value) {
            addCriterion("barcode not like", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeIn(List<String> values) {
            addCriterion("barcode in", values, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeNotIn(List<String> values) {
            addCriterion("barcode not in", values, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeBetween(String value1, String value2) {
            addCriterion("barcode between", value1, value2, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeNotBetween(String value1, String value2) {
            addCriterion("barcode not between", value1, value2, "barcode");
            return (Criteria) this;
        }

        public Criteria andSfdidsIsNull() {
            addCriterion("sfdids is null");
            return (Criteria) this;
        }

        public Criteria andSfdidsIsNotNull() {
            addCriterion("sfdids is not null");
            return (Criteria) this;
        }

        public Criteria andSfdidsEqualTo(String value) {
            addCriterion("sfdids =", value, "sfdids");
            return (Criteria) this;
        }

        public Criteria andSfdidsNotEqualTo(String value) {
            addCriterion("sfdids <>", value, "sfdids");
            return (Criteria) this;
        }

        public Criteria andSfdidsGreaterThan(String value) {
            addCriterion("sfdids >", value, "sfdids");
            return (Criteria) this;
        }

        public Criteria andSfdidsGreaterThanOrEqualTo(String value) {
            addCriterion("sfdids >=", value, "sfdids");
            return (Criteria) this;
        }

        public Criteria andSfdidsLessThan(String value) {
            addCriterion("sfdids <", value, "sfdids");
            return (Criteria) this;
        }

        public Criteria andSfdidsLessThanOrEqualTo(String value) {
            addCriterion("sfdids <=", value, "sfdids");
            return (Criteria) this;
        }

        public Criteria andSfdidsLike(String value) {
            addCriterion("sfdids like", value, "sfdids");
            return (Criteria) this;
        }

        public Criteria andSfdidsNotLike(String value) {
            addCriterion("sfdids not like", value, "sfdids");
            return (Criteria) this;
        }

        public Criteria andSfdidsIn(List<String> values) {
            addCriterion("sfdids in", values, "sfdids");
            return (Criteria) this;
        }

        public Criteria andSfdidsNotIn(List<String> values) {
            addCriterion("sfdids not in", values, "sfdids");
            return (Criteria) this;
        }

        public Criteria andSfdidsBetween(String value1, String value2) {
            addCriterion("sfdids between", value1, value2, "sfdids");
            return (Criteria) this;
        }

        public Criteria andSfdidsNotBetween(String value1, String value2) {
            addCriterion("sfdids not between", value1, value2, "sfdids");
            return (Criteria) this;
        }

        public Criteria andCountsIsNull() {
            addCriterion("counts is null");
            return (Criteria) this;
        }

        public Criteria andCountsIsNotNull() {
            addCriterion("counts is not null");
            return (Criteria) this;
        }

        public Criteria andCountsEqualTo(Integer value) {
            addCriterion("counts =", value, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsNotEqualTo(Integer value) {
            addCriterion("counts <>", value, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsGreaterThan(Integer value) {
            addCriterion("counts >", value, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("counts >=", value, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsLessThan(Integer value) {
            addCriterion("counts <", value, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsLessThanOrEqualTo(Integer value) {
            addCriterion("counts <=", value, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsIn(List<Integer> values) {
            addCriterion("counts in", values, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsNotIn(List<Integer> values) {
            addCriterion("counts not in", values, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsBetween(Integer value1, Integer value2) {
            addCriterion("counts between", value1, value2, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("counts not between", value1, value2, "counts");
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
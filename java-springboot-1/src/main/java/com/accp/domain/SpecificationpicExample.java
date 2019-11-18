package com.accp.domain;

import java.util.ArrayList;
import java.util.List;

public class SpecificationpicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpecificationpicExample() {
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

        public Criteria andScpicidIsNull() {
            addCriterion("scpicid is null");
            return (Criteria) this;
        }

        public Criteria andScpicidIsNotNull() {
            addCriterion("scpicid is not null");
            return (Criteria) this;
        }

        public Criteria andScpicidEqualTo(Integer value) {
            addCriterion("scpicid =", value, "scpicid");
            return (Criteria) this;
        }

        public Criteria andScpicidNotEqualTo(Integer value) {
            addCriterion("scpicid <>", value, "scpicid");
            return (Criteria) this;
        }

        public Criteria andScpicidGreaterThan(Integer value) {
            addCriterion("scpicid >", value, "scpicid");
            return (Criteria) this;
        }

        public Criteria andScpicidGreaterThanOrEqualTo(Integer value) {
            addCriterion("scpicid >=", value, "scpicid");
            return (Criteria) this;
        }

        public Criteria andScpicidLessThan(Integer value) {
            addCriterion("scpicid <", value, "scpicid");
            return (Criteria) this;
        }

        public Criteria andScpicidLessThanOrEqualTo(Integer value) {
            addCriterion("scpicid <=", value, "scpicid");
            return (Criteria) this;
        }

        public Criteria andScpicidIn(List<Integer> values) {
            addCriterion("scpicid in", values, "scpicid");
            return (Criteria) this;
        }

        public Criteria andScpicidNotIn(List<Integer> values) {
            addCriterion("scpicid not in", values, "scpicid");
            return (Criteria) this;
        }

        public Criteria andScpicidBetween(Integer value1, Integer value2) {
            addCriterion("scpicid between", value1, value2, "scpicid");
            return (Criteria) this;
        }

        public Criteria andScpicidNotBetween(Integer value1, Integer value2) {
            addCriterion("scpicid not between", value1, value2, "scpicid");
            return (Criteria) this;
        }

        public Criteria andSfdidIsNull() {
            addCriterion("sfdid is null");
            return (Criteria) this;
        }

        public Criteria andSfdidIsNotNull() {
            addCriterion("sfdid is not null");
            return (Criteria) this;
        }

        public Criteria andSfdidEqualTo(Integer value) {
            addCriterion("sfdid =", value, "sfdid");
            return (Criteria) this;
        }

        public Criteria andSfdidNotEqualTo(Integer value) {
            addCriterion("sfdid <>", value, "sfdid");
            return (Criteria) this;
        }

        public Criteria andSfdidGreaterThan(Integer value) {
            addCriterion("sfdid >", value, "sfdid");
            return (Criteria) this;
        }

        public Criteria andSfdidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sfdid >=", value, "sfdid");
            return (Criteria) this;
        }

        public Criteria andSfdidLessThan(Integer value) {
            addCriterion("sfdid <", value, "sfdid");
            return (Criteria) this;
        }

        public Criteria andSfdidLessThanOrEqualTo(Integer value) {
            addCriterion("sfdid <=", value, "sfdid");
            return (Criteria) this;
        }

        public Criteria andSfdidIn(List<Integer> values) {
            addCriterion("sfdid in", values, "sfdid");
            return (Criteria) this;
        }

        public Criteria andSfdidNotIn(List<Integer> values) {
            addCriterion("sfdid not in", values, "sfdid");
            return (Criteria) this;
        }

        public Criteria andSfdidBetween(Integer value1, Integer value2) {
            addCriterion("sfdid between", value1, value2, "sfdid");
            return (Criteria) this;
        }

        public Criteria andSfdidNotBetween(Integer value1, Integer value2) {
            addCriterion("sfdid not between", value1, value2, "sfdid");
            return (Criteria) this;
        }

        public Criteria andScpicnameIsNull() {
            addCriterion("scpicname is null");
            return (Criteria) this;
        }

        public Criteria andScpicnameIsNotNull() {
            addCriterion("scpicname is not null");
            return (Criteria) this;
        }

        public Criteria andScpicnameEqualTo(String value) {
            addCriterion("scpicname =", value, "scpicname");
            return (Criteria) this;
        }

        public Criteria andScpicnameNotEqualTo(String value) {
            addCriterion("scpicname <>", value, "scpicname");
            return (Criteria) this;
        }

        public Criteria andScpicnameGreaterThan(String value) {
            addCriterion("scpicname >", value, "scpicname");
            return (Criteria) this;
        }

        public Criteria andScpicnameGreaterThanOrEqualTo(String value) {
            addCriterion("scpicname >=", value, "scpicname");
            return (Criteria) this;
        }

        public Criteria andScpicnameLessThan(String value) {
            addCriterion("scpicname <", value, "scpicname");
            return (Criteria) this;
        }

        public Criteria andScpicnameLessThanOrEqualTo(String value) {
            addCriterion("scpicname <=", value, "scpicname");
            return (Criteria) this;
        }

        public Criteria andScpicnameLike(String value) {
            addCriterion("scpicname like", value, "scpicname");
            return (Criteria) this;
        }

        public Criteria andScpicnameNotLike(String value) {
            addCriterion("scpicname not like", value, "scpicname");
            return (Criteria) this;
        }

        public Criteria andScpicnameIn(List<String> values) {
            addCriterion("scpicname in", values, "scpicname");
            return (Criteria) this;
        }

        public Criteria andScpicnameNotIn(List<String> values) {
            addCriterion("scpicname not in", values, "scpicname");
            return (Criteria) this;
        }

        public Criteria andScpicnameBetween(String value1, String value2) {
            addCriterion("scpicname between", value1, value2, "scpicname");
            return (Criteria) this;
        }

        public Criteria andScpicnameNotBetween(String value1, String value2) {
            addCriterion("scpicname not between", value1, value2, "scpicname");
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
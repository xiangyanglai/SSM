package com.cn.tju.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TemperatureLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TemperatureLogExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSensorIdIsNull() {
            addCriterion("sensor_id is null");
            return (Criteria) this;
        }

        public Criteria andSensorIdIsNotNull() {
            addCriterion("sensor_id is not null");
            return (Criteria) this;
        }

        public Criteria andSensorIdEqualTo(String value) {
            addCriterion("sensor_id =", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdNotEqualTo(String value) {
            addCriterion("sensor_id <>", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdGreaterThan(String value) {
            addCriterion("sensor_id >", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdGreaterThanOrEqualTo(String value) {
            addCriterion("sensor_id >=", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdLessThan(String value) {
            addCriterion("sensor_id <", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdLessThanOrEqualTo(String value) {
            addCriterion("sensor_id <=", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdLike(String value) {
            addCriterion("sensor_id like", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdNotLike(String value) {
            addCriterion("sensor_id not like", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdIn(List<String> values) {
            addCriterion("sensor_id in", values, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdNotIn(List<String> values) {
            addCriterion("sensor_id not in", values, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdBetween(String value1, String value2) {
            addCriterion("sensor_id between", value1, value2, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdNotBetween(String value1, String value2) {
            addCriterion("sensor_id not between", value1, value2, "sensorId");
            return (Criteria) this;
        }

        public Criteria andTempratureCurtemIsNull() {
            addCriterion("temprature_curTem is null");
            return (Criteria) this;
        }

        public Criteria andTempratureCurtemIsNotNull() {
            addCriterion("temprature_curTem is not null");
            return (Criteria) this;
        }

        public Criteria andTempratureCurtemEqualTo(Float value) {
            addCriterion("temprature_curTem =", value, "tempratureCurtem");
            return (Criteria) this;
        }

        public Criteria andTempratureCurtemNotEqualTo(Float value) {
            addCriterion("temprature_curTem <>", value, "tempratureCurtem");
            return (Criteria) this;
        }

        public Criteria andTempratureCurtemGreaterThan(Float value) {
            addCriterion("temprature_curTem >", value, "tempratureCurtem");
            return (Criteria) this;
        }

        public Criteria andTempratureCurtemGreaterThanOrEqualTo(Float value) {
            addCriterion("temprature_curTem >=", value, "tempratureCurtem");
            return (Criteria) this;
        }

        public Criteria andTempratureCurtemLessThan(Float value) {
            addCriterion("temprature_curTem <", value, "tempratureCurtem");
            return (Criteria) this;
        }

        public Criteria andTempratureCurtemLessThanOrEqualTo(Float value) {
            addCriterion("temprature_curTem <=", value, "tempratureCurtem");
            return (Criteria) this;
        }

        public Criteria andTempratureCurtemIn(List<Float> values) {
            addCriterion("temprature_curTem in", values, "tempratureCurtem");
            return (Criteria) this;
        }

        public Criteria andTempratureCurtemNotIn(List<Float> values) {
            addCriterion("temprature_curTem not in", values, "tempratureCurtem");
            return (Criteria) this;
        }

        public Criteria andTempratureCurtemBetween(Float value1, Float value2) {
            addCriterion("temprature_curTem between", value1, value2, "tempratureCurtem");
            return (Criteria) this;
        }

        public Criteria andTempratureCurtemNotBetween(Float value1, Float value2) {
            addCriterion("temprature_curTem not between", value1, value2, "tempratureCurtem");
            return (Criteria) this;
        }

        public Criteria andDatetimeIsNull() {
            addCriterion("datetime is null");
            return (Criteria) this;
        }

        public Criteria andDatetimeIsNotNull() {
            addCriterion("datetime is not null");
            return (Criteria) this;
        }

        public Criteria andDatetimeEqualTo(Date value) {
            addCriterion("datetime =", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotEqualTo(Date value) {
            addCriterion("datetime <>", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeGreaterThan(Date value) {
            addCriterion("datetime >", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("datetime >=", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeLessThan(Date value) {
            addCriterion("datetime <", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("datetime <=", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeIn(List<Date> values) {
            addCriterion("datetime in", values, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotIn(List<Date> values) {
            addCriterion("datetime not in", values, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeBetween(Date value1, Date value2) {
            addCriterion("datetime between", value1, value2, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("datetime not between", value1, value2, "datetime");
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
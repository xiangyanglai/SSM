package com.cn.tju.pojo;

import java.util.ArrayList;
import java.util.List;

public class AmmeterSettingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AmmeterSettingExample() {
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

        public Criteria andAmmeterIdIsNull() {
            addCriterion("ammeter_id is null");
            return (Criteria) this;
        }

        public Criteria andAmmeterIdIsNotNull() {
            addCriterion("ammeter_id is not null");
            return (Criteria) this;
        }

        public Criteria andAmmeterIdEqualTo(String value) {
            addCriterion("ammeter_id =", value, "ammeterId");
            return (Criteria) this;
        }

        public Criteria andAmmeterIdNotEqualTo(String value) {
            addCriterion("ammeter_id <>", value, "ammeterId");
            return (Criteria) this;
        }

        public Criteria andAmmeterIdGreaterThan(String value) {
            addCriterion("ammeter_id >", value, "ammeterId");
            return (Criteria) this;
        }

        public Criteria andAmmeterIdGreaterThanOrEqualTo(String value) {
            addCriterion("ammeter_id >=", value, "ammeterId");
            return (Criteria) this;
        }

        public Criteria andAmmeterIdLessThan(String value) {
            addCriterion("ammeter_id <", value, "ammeterId");
            return (Criteria) this;
        }

        public Criteria andAmmeterIdLessThanOrEqualTo(String value) {
            addCriterion("ammeter_id <=", value, "ammeterId");
            return (Criteria) this;
        }

        public Criteria andAmmeterIdLike(String value) {
            addCriterion("ammeter_id like", value, "ammeterId");
            return (Criteria) this;
        }

        public Criteria andAmmeterIdNotLike(String value) {
            addCriterion("ammeter_id not like", value, "ammeterId");
            return (Criteria) this;
        }

        public Criteria andAmmeterIdIn(List<String> values) {
            addCriterion("ammeter_id in", values, "ammeterId");
            return (Criteria) this;
        }

        public Criteria andAmmeterIdNotIn(List<String> values) {
            addCriterion("ammeter_id not in", values, "ammeterId");
            return (Criteria) this;
        }

        public Criteria andAmmeterIdBetween(String value1, String value2) {
            addCriterion("ammeter_id between", value1, value2, "ammeterId");
            return (Criteria) this;
        }

        public Criteria andAmmeterIdNotBetween(String value1, String value2) {
            addCriterion("ammeter_id not between", value1, value2, "ammeterId");
            return (Criteria) this;
        }

        public Criteria andAmmeterNameIsNull() {
            addCriterion("ammeter_name is null");
            return (Criteria) this;
        }

        public Criteria andAmmeterNameIsNotNull() {
            addCriterion("ammeter_name is not null");
            return (Criteria) this;
        }

        public Criteria andAmmeterNameEqualTo(String value) {
            addCriterion("ammeter_name =", value, "ammeterName");
            return (Criteria) this;
        }

        public Criteria andAmmeterNameNotEqualTo(String value) {
            addCriterion("ammeter_name <>", value, "ammeterName");
            return (Criteria) this;
        }

        public Criteria andAmmeterNameGreaterThan(String value) {
            addCriterion("ammeter_name >", value, "ammeterName");
            return (Criteria) this;
        }

        public Criteria andAmmeterNameGreaterThanOrEqualTo(String value) {
            addCriterion("ammeter_name >=", value, "ammeterName");
            return (Criteria) this;
        }

        public Criteria andAmmeterNameLessThan(String value) {
            addCriterion("ammeter_name <", value, "ammeterName");
            return (Criteria) this;
        }

        public Criteria andAmmeterNameLessThanOrEqualTo(String value) {
            addCriterion("ammeter_name <=", value, "ammeterName");
            return (Criteria) this;
        }

        public Criteria andAmmeterNameLike(String value) {
            addCriterion("ammeter_name like", value, "ammeterName");
            return (Criteria) this;
        }

        public Criteria andAmmeterNameNotLike(String value) {
            addCriterion("ammeter_name not like", value, "ammeterName");
            return (Criteria) this;
        }

        public Criteria andAmmeterNameIn(List<String> values) {
            addCriterion("ammeter_name in", values, "ammeterName");
            return (Criteria) this;
        }

        public Criteria andAmmeterNameNotIn(List<String> values) {
            addCriterion("ammeter_name not in", values, "ammeterName");
            return (Criteria) this;
        }

        public Criteria andAmmeterNameBetween(String value1, String value2) {
            addCriterion("ammeter_name between", value1, value2, "ammeterName");
            return (Criteria) this;
        }

        public Criteria andAmmeterNameNotBetween(String value1, String value2) {
            addCriterion("ammeter_name not between", value1, value2, "ammeterName");
            return (Criteria) this;
        }

        public Criteria andAmmeterIpIsNull() {
            addCriterion("ammeter_ip is null");
            return (Criteria) this;
        }

        public Criteria andAmmeterIpIsNotNull() {
            addCriterion("ammeter_ip is not null");
            return (Criteria) this;
        }

        public Criteria andAmmeterIpEqualTo(String value) {
            addCriterion("ammeter_ip =", value, "ammeterIp");
            return (Criteria) this;
        }

        public Criteria andAmmeterIpNotEqualTo(String value) {
            addCriterion("ammeter_ip <>", value, "ammeterIp");
            return (Criteria) this;
        }

        public Criteria andAmmeterIpGreaterThan(String value) {
            addCriterion("ammeter_ip >", value, "ammeterIp");
            return (Criteria) this;
        }

        public Criteria andAmmeterIpGreaterThanOrEqualTo(String value) {
            addCriterion("ammeter_ip >=", value, "ammeterIp");
            return (Criteria) this;
        }

        public Criteria andAmmeterIpLessThan(String value) {
            addCriterion("ammeter_ip <", value, "ammeterIp");
            return (Criteria) this;
        }

        public Criteria andAmmeterIpLessThanOrEqualTo(String value) {
            addCriterion("ammeter_ip <=", value, "ammeterIp");
            return (Criteria) this;
        }

        public Criteria andAmmeterIpLike(String value) {
            addCriterion("ammeter_ip like", value, "ammeterIp");
            return (Criteria) this;
        }

        public Criteria andAmmeterIpNotLike(String value) {
            addCriterion("ammeter_ip not like", value, "ammeterIp");
            return (Criteria) this;
        }

        public Criteria andAmmeterIpIn(List<String> values) {
            addCriterion("ammeter_ip in", values, "ammeterIp");
            return (Criteria) this;
        }

        public Criteria andAmmeterIpNotIn(List<String> values) {
            addCriterion("ammeter_ip not in", values, "ammeterIp");
            return (Criteria) this;
        }

        public Criteria andAmmeterIpBetween(String value1, String value2) {
            addCriterion("ammeter_ip between", value1, value2, "ammeterIp");
            return (Criteria) this;
        }

        public Criteria andAmmeterIpNotBetween(String value1, String value2) {
            addCriterion("ammeter_ip not between", value1, value2, "ammeterIp");
            return (Criteria) this;
        }

        public Criteria andAmmeterPortIsNull() {
            addCriterion("ammeter_port is null");
            return (Criteria) this;
        }

        public Criteria andAmmeterPortIsNotNull() {
            addCriterion("ammeter_port is not null");
            return (Criteria) this;
        }

        public Criteria andAmmeterPortEqualTo(Integer value) {
            addCriterion("ammeter_port =", value, "ammeterPort");
            return (Criteria) this;
        }

        public Criteria andAmmeterPortNotEqualTo(Integer value) {
            addCriterion("ammeter_port <>", value, "ammeterPort");
            return (Criteria) this;
        }

        public Criteria andAmmeterPortGreaterThan(Integer value) {
            addCriterion("ammeter_port >", value, "ammeterPort");
            return (Criteria) this;
        }

        public Criteria andAmmeterPortGreaterThanOrEqualTo(Integer value) {
            addCriterion("ammeter_port >=", value, "ammeterPort");
            return (Criteria) this;
        }

        public Criteria andAmmeterPortLessThan(Integer value) {
            addCriterion("ammeter_port <", value, "ammeterPort");
            return (Criteria) this;
        }

        public Criteria andAmmeterPortLessThanOrEqualTo(Integer value) {
            addCriterion("ammeter_port <=", value, "ammeterPort");
            return (Criteria) this;
        }

        public Criteria andAmmeterPortIn(List<Integer> values) {
            addCriterion("ammeter_port in", values, "ammeterPort");
            return (Criteria) this;
        }

        public Criteria andAmmeterPortNotIn(List<Integer> values) {
            addCriterion("ammeter_port not in", values, "ammeterPort");
            return (Criteria) this;
        }

        public Criteria andAmmeterPortBetween(Integer value1, Integer value2) {
            addCriterion("ammeter_port between", value1, value2, "ammeterPort");
            return (Criteria) this;
        }

        public Criteria andAmmeterPortNotBetween(Integer value1, Integer value2) {
            addCriterion("ammeter_port not between", value1, value2, "ammeterPort");
            return (Criteria) this;
        }

        public Criteria andAmmeterSlaveIsNull() {
            addCriterion("ammeter_slave is null");
            return (Criteria) this;
        }

        public Criteria andAmmeterSlaveIsNotNull() {
            addCriterion("ammeter_slave is not null");
            return (Criteria) this;
        }

        public Criteria andAmmeterSlaveEqualTo(Integer value) {
            addCriterion("ammeter_slave =", value, "ammeterSlave");
            return (Criteria) this;
        }

        public Criteria andAmmeterSlaveNotEqualTo(Integer value) {
            addCriterion("ammeter_slave <>", value, "ammeterSlave");
            return (Criteria) this;
        }

        public Criteria andAmmeterSlaveGreaterThan(Integer value) {
            addCriterion("ammeter_slave >", value, "ammeterSlave");
            return (Criteria) this;
        }

        public Criteria andAmmeterSlaveGreaterThanOrEqualTo(Integer value) {
            addCriterion("ammeter_slave >=", value, "ammeterSlave");
            return (Criteria) this;
        }

        public Criteria andAmmeterSlaveLessThan(Integer value) {
            addCriterion("ammeter_slave <", value, "ammeterSlave");
            return (Criteria) this;
        }

        public Criteria andAmmeterSlaveLessThanOrEqualTo(Integer value) {
            addCriterion("ammeter_slave <=", value, "ammeterSlave");
            return (Criteria) this;
        }

        public Criteria andAmmeterSlaveIn(List<Integer> values) {
            addCriterion("ammeter_slave in", values, "ammeterSlave");
            return (Criteria) this;
        }

        public Criteria andAmmeterSlaveNotIn(List<Integer> values) {
            addCriterion("ammeter_slave not in", values, "ammeterSlave");
            return (Criteria) this;
        }

        public Criteria andAmmeterSlaveBetween(Integer value1, Integer value2) {
            addCriterion("ammeter_slave between", value1, value2, "ammeterSlave");
            return (Criteria) this;
        }

        public Criteria andAmmeterSlaveNotBetween(Integer value1, Integer value2) {
            addCriterion("ammeter_slave not between", value1, value2, "ammeterSlave");
            return (Criteria) this;
        }

        public Criteria andAmmeterFirstIsNull() {
            addCriterion("ammeter_first is null");
            return (Criteria) this;
        }

        public Criteria andAmmeterFirstIsNotNull() {
            addCriterion("ammeter_first is not null");
            return (Criteria) this;
        }

        public Criteria andAmmeterFirstEqualTo(Integer value) {
            addCriterion("ammeter_first =", value, "ammeterFirst");
            return (Criteria) this;
        }

        public Criteria andAmmeterFirstNotEqualTo(Integer value) {
            addCriterion("ammeter_first <>", value, "ammeterFirst");
            return (Criteria) this;
        }

        public Criteria andAmmeterFirstGreaterThan(Integer value) {
            addCriterion("ammeter_first >", value, "ammeterFirst");
            return (Criteria) this;
        }

        public Criteria andAmmeterFirstGreaterThanOrEqualTo(Integer value) {
            addCriterion("ammeter_first >=", value, "ammeterFirst");
            return (Criteria) this;
        }

        public Criteria andAmmeterFirstLessThan(Integer value) {
            addCriterion("ammeter_first <", value, "ammeterFirst");
            return (Criteria) this;
        }

        public Criteria andAmmeterFirstLessThanOrEqualTo(Integer value) {
            addCriterion("ammeter_first <=", value, "ammeterFirst");
            return (Criteria) this;
        }

        public Criteria andAmmeterFirstIn(List<Integer> values) {
            addCriterion("ammeter_first in", values, "ammeterFirst");
            return (Criteria) this;
        }

        public Criteria andAmmeterFirstNotIn(List<Integer> values) {
            addCriterion("ammeter_first not in", values, "ammeterFirst");
            return (Criteria) this;
        }

        public Criteria andAmmeterFirstBetween(Integer value1, Integer value2) {
            addCriterion("ammeter_first between", value1, value2, "ammeterFirst");
            return (Criteria) this;
        }

        public Criteria andAmmeterFirstNotBetween(Integer value1, Integer value2) {
            addCriterion("ammeter_first not between", value1, value2, "ammeterFirst");
            return (Criteria) this;
        }

        public Criteria andAmmeterSecondIsNull() {
            addCriterion("ammeter_second is null");
            return (Criteria) this;
        }

        public Criteria andAmmeterSecondIsNotNull() {
            addCriterion("ammeter_second is not null");
            return (Criteria) this;
        }

        public Criteria andAmmeterSecondEqualTo(Integer value) {
            addCriterion("ammeter_second =", value, "ammeterSecond");
            return (Criteria) this;
        }

        public Criteria andAmmeterSecondNotEqualTo(Integer value) {
            addCriterion("ammeter_second <>", value, "ammeterSecond");
            return (Criteria) this;
        }

        public Criteria andAmmeterSecondGreaterThan(Integer value) {
            addCriterion("ammeter_second >", value, "ammeterSecond");
            return (Criteria) this;
        }

        public Criteria andAmmeterSecondGreaterThanOrEqualTo(Integer value) {
            addCriterion("ammeter_second >=", value, "ammeterSecond");
            return (Criteria) this;
        }

        public Criteria andAmmeterSecondLessThan(Integer value) {
            addCriterion("ammeter_second <", value, "ammeterSecond");
            return (Criteria) this;
        }

        public Criteria andAmmeterSecondLessThanOrEqualTo(Integer value) {
            addCriterion("ammeter_second <=", value, "ammeterSecond");
            return (Criteria) this;
        }

        public Criteria andAmmeterSecondIn(List<Integer> values) {
            addCriterion("ammeter_second in", values, "ammeterSecond");
            return (Criteria) this;
        }

        public Criteria andAmmeterSecondNotIn(List<Integer> values) {
            addCriterion("ammeter_second not in", values, "ammeterSecond");
            return (Criteria) this;
        }

        public Criteria andAmmeterSecondBetween(Integer value1, Integer value2) {
            addCriterion("ammeter_second between", value1, value2, "ammeterSecond");
            return (Criteria) this;
        }

        public Criteria andAmmeterSecondNotBetween(Integer value1, Integer value2) {
            addCriterion("ammeter_second not between", value1, value2, "ammeterSecond");
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
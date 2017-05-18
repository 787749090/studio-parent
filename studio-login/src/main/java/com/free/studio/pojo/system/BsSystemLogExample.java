package com.free.studio.pojo.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BsSystemLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BsSystemLogExample() {
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

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(String value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(String value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(String value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(String value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(String value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(String value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLike(String value) {
            addCriterion("pid like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotLike(String value) {
            addCriterion("pid not like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<String> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<String> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(String value1, String value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(String value1, String value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andOperateNameIsNull() {
            addCriterion("operate_name is null");
            return (Criteria) this;
        }

        public Criteria andOperateNameIsNotNull() {
            addCriterion("operate_name is not null");
            return (Criteria) this;
        }

        public Criteria andOperateNameEqualTo(String value) {
            addCriterion("operate_name =", value, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperateNameNotEqualTo(String value) {
            addCriterion("operate_name <>", value, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperateNameGreaterThan(String value) {
            addCriterion("operate_name >", value, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperateNameGreaterThanOrEqualTo(String value) {
            addCriterion("operate_name >=", value, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperateNameLessThan(String value) {
            addCriterion("operate_name <", value, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperateNameLessThanOrEqualTo(String value) {
            addCriterion("operate_name <=", value, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperateNameLike(String value) {
            addCriterion("operate_name like", value, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperateNameNotLike(String value) {
            addCriterion("operate_name not like", value, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperateNameIn(List<String> values) {
            addCriterion("operate_name in", values, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperateNameNotIn(List<String> values) {
            addCriterion("operate_name not in", values, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperateNameBetween(String value1, String value2) {
            addCriterion("operate_name between", value1, value2, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperateNameNotBetween(String value1, String value2) {
            addCriterion("operate_name not between", value1, value2, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperatePersonIsNull() {
            addCriterion("operate_person is null");
            return (Criteria) this;
        }

        public Criteria andOperatePersonIsNotNull() {
            addCriterion("operate_person is not null");
            return (Criteria) this;
        }

        public Criteria andOperatePersonEqualTo(String value) {
            addCriterion("operate_person =", value, "operatePerson");
            return (Criteria) this;
        }

        public Criteria andOperatePersonNotEqualTo(String value) {
            addCriterion("operate_person <>", value, "operatePerson");
            return (Criteria) this;
        }

        public Criteria andOperatePersonGreaterThan(String value) {
            addCriterion("operate_person >", value, "operatePerson");
            return (Criteria) this;
        }

        public Criteria andOperatePersonGreaterThanOrEqualTo(String value) {
            addCriterion("operate_person >=", value, "operatePerson");
            return (Criteria) this;
        }

        public Criteria andOperatePersonLessThan(String value) {
            addCriterion("operate_person <", value, "operatePerson");
            return (Criteria) this;
        }

        public Criteria andOperatePersonLessThanOrEqualTo(String value) {
            addCriterion("operate_person <=", value, "operatePerson");
            return (Criteria) this;
        }

        public Criteria andOperatePersonLike(String value) {
            addCriterion("operate_person like", value, "operatePerson");
            return (Criteria) this;
        }

        public Criteria andOperatePersonNotLike(String value) {
            addCriterion("operate_person not like", value, "operatePerson");
            return (Criteria) this;
        }

        public Criteria andOperatePersonIn(List<String> values) {
            addCriterion("operate_person in", values, "operatePerson");
            return (Criteria) this;
        }

        public Criteria andOperatePersonNotIn(List<String> values) {
            addCriterion("operate_person not in", values, "operatePerson");
            return (Criteria) this;
        }

        public Criteria andOperatePersonBetween(String value1, String value2) {
            addCriterion("operate_person between", value1, value2, "operatePerson");
            return (Criteria) this;
        }

        public Criteria andOperatePersonNotBetween(String value1, String value2) {
            addCriterion("operate_person not between", value1, value2, "operatePerson");
            return (Criteria) this;
        }

        public Criteria andOperateIpIsNull() {
            addCriterion("operate_ip is null");
            return (Criteria) this;
        }

        public Criteria andOperateIpIsNotNull() {
            addCriterion("operate_ip is not null");
            return (Criteria) this;
        }

        public Criteria andOperateIpEqualTo(String value) {
            addCriterion("operate_ip =", value, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpNotEqualTo(String value) {
            addCriterion("operate_ip <>", value, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpGreaterThan(String value) {
            addCriterion("operate_ip >", value, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpGreaterThanOrEqualTo(String value) {
            addCriterion("operate_ip >=", value, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpLessThan(String value) {
            addCriterion("operate_ip <", value, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpLessThanOrEqualTo(String value) {
            addCriterion("operate_ip <=", value, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpLike(String value) {
            addCriterion("operate_ip like", value, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpNotLike(String value) {
            addCriterion("operate_ip not like", value, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpIn(List<String> values) {
            addCriterion("operate_ip in", values, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpNotIn(List<String> values) {
            addCriterion("operate_ip not in", values, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpBetween(String value1, String value2) {
            addCriterion("operate_ip between", value1, value2, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateIpNotBetween(String value1, String value2) {
            addCriterion("operate_ip not between", value1, value2, "operateIp");
            return (Criteria) this;
        }

        public Criteria andOperateDescribeIsNull() {
            addCriterion("operate_describe is null");
            return (Criteria) this;
        }

        public Criteria andOperateDescribeIsNotNull() {
            addCriterion("operate_describe is not null");
            return (Criteria) this;
        }

        public Criteria andOperateDescribeEqualTo(String value) {
            addCriterion("operate_describe =", value, "operateDescribe");
            return (Criteria) this;
        }

        public Criteria andOperateDescribeNotEqualTo(String value) {
            addCriterion("operate_describe <>", value, "operateDescribe");
            return (Criteria) this;
        }

        public Criteria andOperateDescribeGreaterThan(String value) {
            addCriterion("operate_describe >", value, "operateDescribe");
            return (Criteria) this;
        }

        public Criteria andOperateDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("operate_describe >=", value, "operateDescribe");
            return (Criteria) this;
        }

        public Criteria andOperateDescribeLessThan(String value) {
            addCriterion("operate_describe <", value, "operateDescribe");
            return (Criteria) this;
        }

        public Criteria andOperateDescribeLessThanOrEqualTo(String value) {
            addCriterion("operate_describe <=", value, "operateDescribe");
            return (Criteria) this;
        }

        public Criteria andOperateDescribeLike(String value) {
            addCriterion("operate_describe like", value, "operateDescribe");
            return (Criteria) this;
        }

        public Criteria andOperateDescribeNotLike(String value) {
            addCriterion("operate_describe not like", value, "operateDescribe");
            return (Criteria) this;
        }

        public Criteria andOperateDescribeIn(List<String> values) {
            addCriterion("operate_describe in", values, "operateDescribe");
            return (Criteria) this;
        }

        public Criteria andOperateDescribeNotIn(List<String> values) {
            addCriterion("operate_describe not in", values, "operateDescribe");
            return (Criteria) this;
        }

        public Criteria andOperateDescribeBetween(String value1, String value2) {
            addCriterion("operate_describe between", value1, value2, "operateDescribe");
            return (Criteria) this;
        }

        public Criteria andOperateDescribeNotBetween(String value1, String value2) {
            addCriterion("operate_describe not between", value1, value2, "operateDescribe");
            return (Criteria) this;
        }

        public Criteria andCreateNameIsNull() {
            addCriterion("create_name is null");
            return (Criteria) this;
        }

        public Criteria andCreateNameIsNotNull() {
            addCriterion("create_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreateNameEqualTo(String value) {
            addCriterion("create_name =", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotEqualTo(String value) {
            addCriterion("create_name <>", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameGreaterThan(String value) {
            addCriterion("create_name >", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameGreaterThanOrEqualTo(String value) {
            addCriterion("create_name >=", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLessThan(String value) {
            addCriterion("create_name <", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLessThanOrEqualTo(String value) {
            addCriterion("create_name <=", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLike(String value) {
            addCriterion("create_name like", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotLike(String value) {
            addCriterion("create_name not like", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameIn(List<String> values) {
            addCriterion("create_name in", values, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotIn(List<String> values) {
            addCriterion("create_name not in", values, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameBetween(String value1, String value2) {
            addCriterion("create_name between", value1, value2, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotBetween(String value1, String value2) {
            addCriterion("create_name not between", value1, value2, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifyNameIsNull() {
            addCriterion("modify_name is null");
            return (Criteria) this;
        }

        public Criteria andModifyNameIsNotNull() {
            addCriterion("modify_name is not null");
            return (Criteria) this;
        }

        public Criteria andModifyNameEqualTo(String value) {
            addCriterion("modify_name =", value, "modifyName");
            return (Criteria) this;
        }

        public Criteria andModifyNameNotEqualTo(String value) {
            addCriterion("modify_name <>", value, "modifyName");
            return (Criteria) this;
        }

        public Criteria andModifyNameGreaterThan(String value) {
            addCriterion("modify_name >", value, "modifyName");
            return (Criteria) this;
        }

        public Criteria andModifyNameGreaterThanOrEqualTo(String value) {
            addCriterion("modify_name >=", value, "modifyName");
            return (Criteria) this;
        }

        public Criteria andModifyNameLessThan(String value) {
            addCriterion("modify_name <", value, "modifyName");
            return (Criteria) this;
        }

        public Criteria andModifyNameLessThanOrEqualTo(String value) {
            addCriterion("modify_name <=", value, "modifyName");
            return (Criteria) this;
        }

        public Criteria andModifyNameLike(String value) {
            addCriterion("modify_name like", value, "modifyName");
            return (Criteria) this;
        }

        public Criteria andModifyNameNotLike(String value) {
            addCriterion("modify_name not like", value, "modifyName");
            return (Criteria) this;
        }

        public Criteria andModifyNameIn(List<String> values) {
            addCriterion("modify_name in", values, "modifyName");
            return (Criteria) this;
        }

        public Criteria andModifyNameNotIn(List<String> values) {
            addCriterion("modify_name not in", values, "modifyName");
            return (Criteria) this;
        }

        public Criteria andModifyNameBetween(String value1, String value2) {
            addCriterion("modify_name between", value1, value2, "modifyName");
            return (Criteria) this;
        }

        public Criteria andModifyNameNotBetween(String value1, String value2) {
            addCriterion("modify_name not between", value1, value2, "modifyName");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andSystemIdIsNull() {
            addCriterion("system_id is null");
            return (Criteria) this;
        }

        public Criteria andSystemIdIsNotNull() {
            addCriterion("system_id is not null");
            return (Criteria) this;
        }

        public Criteria andSystemIdEqualTo(String value) {
            addCriterion("system_id =", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotEqualTo(String value) {
            addCriterion("system_id <>", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThan(String value) {
            addCriterion("system_id >", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThanOrEqualTo(String value) {
            addCriterion("system_id >=", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThan(String value) {
            addCriterion("system_id <", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThanOrEqualTo(String value) {
            addCriterion("system_id <=", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLike(String value) {
            addCriterion("system_id like", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotLike(String value) {
            addCriterion("system_id not like", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdIn(List<String> values) {
            addCriterion("system_id in", values, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotIn(List<String> values) {
            addCriterion("system_id not in", values, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdBetween(String value1, String value2) {
            addCriterion("system_id between", value1, value2, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotBetween(String value1, String value2) {
            addCriterion("system_id not between", value1, value2, "systemId");
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
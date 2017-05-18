package com.free.studio.pojo.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BsMenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BsMenuExample() {
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

        public Criteria andMenuIdIsNull() {
            addCriterion("menu_id is null");
            return (Criteria) this;
        }

        public Criteria andMenuIdIsNotNull() {
            addCriterion("menu_id is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIdEqualTo(String value) {
            addCriterion("menu_id =", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotEqualTo(String value) {
            addCriterion("menu_id <>", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThan(String value) {
            addCriterion("menu_id >", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThanOrEqualTo(String value) {
            addCriterion("menu_id >=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThan(String value) {
            addCriterion("menu_id <", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThanOrEqualTo(String value) {
            addCriterion("menu_id <=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLike(String value) {
            addCriterion("menu_id like", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotLike(String value) {
            addCriterion("menu_id not like", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdIn(List<String> values) {
            addCriterion("menu_id in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotIn(List<String> values) {
            addCriterion("menu_id not in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdBetween(String value1, String value2) {
            addCriterion("menu_id between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotBetween(String value1, String value2) {
            addCriterion("menu_id not between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andParentMenuIdIsNull() {
            addCriterion("parent_menu_id is null");
            return (Criteria) this;
        }

        public Criteria andParentMenuIdIsNotNull() {
            addCriterion("parent_menu_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentMenuIdEqualTo(String value) {
            addCriterion("parent_menu_id =", value, "parentMenuId");
            return (Criteria) this;
        }

        public Criteria andParentMenuIdNotEqualTo(String value) {
            addCriterion("parent_menu_id <>", value, "parentMenuId");
            return (Criteria) this;
        }

        public Criteria andParentMenuIdGreaterThan(String value) {
            addCriterion("parent_menu_id >", value, "parentMenuId");
            return (Criteria) this;
        }

        public Criteria andParentMenuIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_menu_id >=", value, "parentMenuId");
            return (Criteria) this;
        }

        public Criteria andParentMenuIdLessThan(String value) {
            addCriterion("parent_menu_id <", value, "parentMenuId");
            return (Criteria) this;
        }

        public Criteria andParentMenuIdLessThanOrEqualTo(String value) {
            addCriterion("parent_menu_id <=", value, "parentMenuId");
            return (Criteria) this;
        }

        public Criteria andParentMenuIdLike(String value) {
            addCriterion("parent_menu_id like", value, "parentMenuId");
            return (Criteria) this;
        }

        public Criteria andParentMenuIdNotLike(String value) {
            addCriterion("parent_menu_id not like", value, "parentMenuId");
            return (Criteria) this;
        }

        public Criteria andParentMenuIdIn(List<String> values) {
            addCriterion("parent_menu_id in", values, "parentMenuId");
            return (Criteria) this;
        }

        public Criteria andParentMenuIdNotIn(List<String> values) {
            addCriterion("parent_menu_id not in", values, "parentMenuId");
            return (Criteria) this;
        }

        public Criteria andParentMenuIdBetween(String value1, String value2) {
            addCriterion("parent_menu_id between", value1, value2, "parentMenuId");
            return (Criteria) this;
        }

        public Criteria andParentMenuIdNotBetween(String value1, String value2) {
            addCriterion("parent_menu_id not between", value1, value2, "parentMenuId");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNull() {
            addCriterion("menu_name is null");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNotNull() {
            addCriterion("menu_name is not null");
            return (Criteria) this;
        }

        public Criteria andMenuNameEqualTo(String value) {
            addCriterion("menu_name =", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotEqualTo(String value) {
            addCriterion("menu_name <>", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThan(String value) {
            addCriterion("menu_name >", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThanOrEqualTo(String value) {
            addCriterion("menu_name >=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThan(String value) {
            addCriterion("menu_name <", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThanOrEqualTo(String value) {
            addCriterion("menu_name <=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLike(String value) {
            addCriterion("menu_name like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotLike(String value) {
            addCriterion("menu_name not like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameIn(List<String> values) {
            addCriterion("menu_name in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotIn(List<String> values) {
            addCriterion("menu_name not in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameBetween(String value1, String value2) {
            addCriterion("menu_name between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotBetween(String value1, String value2) {
            addCriterion("menu_name not between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andIsLeafIsNull() {
            addCriterion("is_leaf is null");
            return (Criteria) this;
        }

        public Criteria andIsLeafIsNotNull() {
            addCriterion("is_leaf is not null");
            return (Criteria) this;
        }

        public Criteria andIsLeafEqualTo(String value) {
            addCriterion("is_leaf =", value, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafNotEqualTo(String value) {
            addCriterion("is_leaf <>", value, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafGreaterThan(String value) {
            addCriterion("is_leaf >", value, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafGreaterThanOrEqualTo(String value) {
            addCriterion("is_leaf >=", value, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafLessThan(String value) {
            addCriterion("is_leaf <", value, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafLessThanOrEqualTo(String value) {
            addCriterion("is_leaf <=", value, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafLike(String value) {
            addCriterion("is_leaf like", value, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafNotLike(String value) {
            addCriterion("is_leaf not like", value, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafIn(List<String> values) {
            addCriterion("is_leaf in", values, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafNotIn(List<String> values) {
            addCriterion("is_leaf not in", values, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafBetween(String value1, String value2) {
            addCriterion("is_leaf between", value1, value2, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafNotBetween(String value1, String value2) {
            addCriterion("is_leaf not between", value1, value2, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIsNull() {
            addCriterion("menu_url is null");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIsNotNull() {
            addCriterion("menu_url is not null");
            return (Criteria) this;
        }

        public Criteria andMenuUrlEqualTo(String value) {
            addCriterion("menu_url =", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotEqualTo(String value) {
            addCriterion("menu_url <>", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlGreaterThan(String value) {
            addCriterion("menu_url >", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlGreaterThanOrEqualTo(String value) {
            addCriterion("menu_url >=", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLessThan(String value) {
            addCriterion("menu_url <", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLessThanOrEqualTo(String value) {
            addCriterion("menu_url <=", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLike(String value) {
            addCriterion("menu_url like", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotLike(String value) {
            addCriterion("menu_url not like", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIn(List<String> values) {
            addCriterion("menu_url in", values, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotIn(List<String> values) {
            addCriterion("menu_url not in", values, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlBetween(String value1, String value2) {
            addCriterion("menu_url between", value1, value2, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotBetween(String value1, String value2) {
            addCriterion("menu_url not between", value1, value2, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuImageIsNull() {
            addCriterion("menu_image is null");
            return (Criteria) this;
        }

        public Criteria andMenuImageIsNotNull() {
            addCriterion("menu_image is not null");
            return (Criteria) this;
        }

        public Criteria andMenuImageEqualTo(String value) {
            addCriterion("menu_image =", value, "menuImage");
            return (Criteria) this;
        }

        public Criteria andMenuImageNotEqualTo(String value) {
            addCriterion("menu_image <>", value, "menuImage");
            return (Criteria) this;
        }

        public Criteria andMenuImageGreaterThan(String value) {
            addCriterion("menu_image >", value, "menuImage");
            return (Criteria) this;
        }

        public Criteria andMenuImageGreaterThanOrEqualTo(String value) {
            addCriterion("menu_image >=", value, "menuImage");
            return (Criteria) this;
        }

        public Criteria andMenuImageLessThan(String value) {
            addCriterion("menu_image <", value, "menuImage");
            return (Criteria) this;
        }

        public Criteria andMenuImageLessThanOrEqualTo(String value) {
            addCriterion("menu_image <=", value, "menuImage");
            return (Criteria) this;
        }

        public Criteria andMenuImageLike(String value) {
            addCriterion("menu_image like", value, "menuImage");
            return (Criteria) this;
        }

        public Criteria andMenuImageNotLike(String value) {
            addCriterion("menu_image not like", value, "menuImage");
            return (Criteria) this;
        }

        public Criteria andMenuImageIn(List<String> values) {
            addCriterion("menu_image in", values, "menuImage");
            return (Criteria) this;
        }

        public Criteria andMenuImageNotIn(List<String> values) {
            addCriterion("menu_image not in", values, "menuImage");
            return (Criteria) this;
        }

        public Criteria andMenuImageBetween(String value1, String value2) {
            addCriterion("menu_image between", value1, value2, "menuImage");
            return (Criteria) this;
        }

        public Criteria andMenuImageNotBetween(String value1, String value2) {
            addCriterion("menu_image not between", value1, value2, "menuImage");
            return (Criteria) this;
        }

        public Criteria andCssIsNull() {
            addCriterion("css is null");
            return (Criteria) this;
        }

        public Criteria andCssIsNotNull() {
            addCriterion("css is not null");
            return (Criteria) this;
        }

        public Criteria andCssEqualTo(String value) {
            addCriterion("css =", value, "css");
            return (Criteria) this;
        }

        public Criteria andCssNotEqualTo(String value) {
            addCriterion("css <>", value, "css");
            return (Criteria) this;
        }

        public Criteria andCssGreaterThan(String value) {
            addCriterion("css >", value, "css");
            return (Criteria) this;
        }

        public Criteria andCssGreaterThanOrEqualTo(String value) {
            addCriterion("css >=", value, "css");
            return (Criteria) this;
        }

        public Criteria andCssLessThan(String value) {
            addCriterion("css <", value, "css");
            return (Criteria) this;
        }

        public Criteria andCssLessThanOrEqualTo(String value) {
            addCriterion("css <=", value, "css");
            return (Criteria) this;
        }

        public Criteria andCssLike(String value) {
            addCriterion("css like", value, "css");
            return (Criteria) this;
        }

        public Criteria andCssNotLike(String value) {
            addCriterion("css not like", value, "css");
            return (Criteria) this;
        }

        public Criteria andCssIn(List<String> values) {
            addCriterion("css in", values, "css");
            return (Criteria) this;
        }

        public Criteria andCssNotIn(List<String> values) {
            addCriterion("css not in", values, "css");
            return (Criteria) this;
        }

        public Criteria andCssBetween(String value1, String value2) {
            addCriterion("css between", value1, value2, "css");
            return (Criteria) this;
        }

        public Criteria andCssNotBetween(String value1, String value2) {
            addCriterion("css not between", value1, value2, "css");
            return (Criteria) this;
        }

        public Criteria andMenuTipIsNull() {
            addCriterion("menu_tip is null");
            return (Criteria) this;
        }

        public Criteria andMenuTipIsNotNull() {
            addCriterion("menu_tip is not null");
            return (Criteria) this;
        }

        public Criteria andMenuTipEqualTo(String value) {
            addCriterion("menu_tip =", value, "menuTip");
            return (Criteria) this;
        }

        public Criteria andMenuTipNotEqualTo(String value) {
            addCriterion("menu_tip <>", value, "menuTip");
            return (Criteria) this;
        }

        public Criteria andMenuTipGreaterThan(String value) {
            addCriterion("menu_tip >", value, "menuTip");
            return (Criteria) this;
        }

        public Criteria andMenuTipGreaterThanOrEqualTo(String value) {
            addCriterion("menu_tip >=", value, "menuTip");
            return (Criteria) this;
        }

        public Criteria andMenuTipLessThan(String value) {
            addCriterion("menu_tip <", value, "menuTip");
            return (Criteria) this;
        }

        public Criteria andMenuTipLessThanOrEqualTo(String value) {
            addCriterion("menu_tip <=", value, "menuTip");
            return (Criteria) this;
        }

        public Criteria andMenuTipLike(String value) {
            addCriterion("menu_tip like", value, "menuTip");
            return (Criteria) this;
        }

        public Criteria andMenuTipNotLike(String value) {
            addCriterion("menu_tip not like", value, "menuTip");
            return (Criteria) this;
        }

        public Criteria andMenuTipIn(List<String> values) {
            addCriterion("menu_tip in", values, "menuTip");
            return (Criteria) this;
        }

        public Criteria andMenuTipNotIn(List<String> values) {
            addCriterion("menu_tip not in", values, "menuTip");
            return (Criteria) this;
        }

        public Criteria andMenuTipBetween(String value1, String value2) {
            addCriterion("menu_tip between", value1, value2, "menuTip");
            return (Criteria) this;
        }

        public Criteria andMenuTipNotBetween(String value1, String value2) {
            addCriterion("menu_tip not between", value1, value2, "menuTip");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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
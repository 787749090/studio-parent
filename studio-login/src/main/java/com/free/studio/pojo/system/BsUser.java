package com.free.studio.pojo.system;

import java.util.Date;

public class BsUser {
    private Integer id;

    private String userName;

    private String groupId;

    private String departmentId;

    private String password;

    private String trueName;

    private String nickName;

    private String sex;

    private String cardId;

    private String jobTitle;

    private String qq;

    private String wechat;

    private String skype;

    private String phone;

    private String telephone;

    private String email;

    private String userAddress;

    private String postCode;

    private String headImage;

    private String qrCode;

    private String status;

    private String emailIsVerif;

    private String userType;

    private Integer loginNumber;

    private Date lastLoginTime;

    private Date passwordModifyTime;

    private String passwordModifyMode;

    private Integer passwordErrorNumber;

    private Date userLockTime;

    private String createName;

    private Date createTime;

    private String modifyName;

    private Date modifyTime;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName == null ? null : trueName.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle == null ? null : jobTitle.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype == null ? null : skype.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage == null ? null : headImage.trim();
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode == null ? null : qrCode.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getEmailIsVerif() {
        return emailIsVerif;
    }

    public void setEmailIsVerif(String emailIsVerif) {
        this.emailIsVerif = emailIsVerif == null ? null : emailIsVerif.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public Integer getLoginNumber() {
        return loginNumber;
    }

    public void setLoginNumber(Integer loginNumber) {
        this.loginNumber = loginNumber;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getPasswordModifyTime() {
        return passwordModifyTime;
    }

    public void setPasswordModifyTime(Date passwordModifyTime) {
        this.passwordModifyTime = passwordModifyTime;
    }

    public String getPasswordModifyMode() {
        return passwordModifyMode;
    }

    public void setPasswordModifyMode(String passwordModifyMode) {
        this.passwordModifyMode = passwordModifyMode == null ? null : passwordModifyMode.trim();
    }

    public Integer getPasswordErrorNumber() {
        return passwordErrorNumber;
    }

    public void setPasswordErrorNumber(Integer passwordErrorNumber) {
        this.passwordErrorNumber = passwordErrorNumber;
    }

    public Date getUserLockTime() {
        return userLockTime;
    }

    public void setUserLockTime(Date userLockTime) {
        this.userLockTime = userLockTime;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifyName() {
        return modifyName;
    }

    public void setModifyName(String modifyName) {
        this.modifyName = modifyName == null ? null : modifyName.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
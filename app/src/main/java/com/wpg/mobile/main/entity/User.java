package com.wpg.mobile.main.entity;

import java.util.List;

/**
 * @Author: xuwei
 * @Date: 2021/2/22 14:58
 * @Description:
 */
public class User {
    private int id;
    private String token;
    private String userId;
    private String loginName;
    private String userName;
    private String password;
    private String phone;
    private String photo;
    private List<UserRole> roles;
    private String lastLoginTime;
    private String org;
    private String department;
    private List<AbodeAndPostBean> abodeAndPost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<AbodeAndPostBean> getAbodeAndPost() {
        return abodeAndPost;
    }

    public void setAbodeAndPost(List<AbodeAndPostBean> abodeAndPost) {
        this.abodeAndPost = abodeAndPost;
    }

    public static class AbodeAndPostBean {
        /**
         * abodeAndPostDTOS : [{"abodeName":"","post":"","userAbodeId":""}]
         * abodeName :
         */

        private String abodeName;
        private String abodeCode;
        private List<AppAbodeAndPostDTOSBean> appAbodeAndPostDTOS;

        public String getAbodeCode() {
            return abodeCode;
        }

        public void setAbodeCode(String abodeCode) {
            this.abodeCode = abodeCode;
        }

        public String getAbodeName() {
            return abodeName;
        }

        public void setAbodeName(String abodeName) {
            this.abodeName = abodeName;
        }

        public List<AppAbodeAndPostDTOSBean> getAppAbodeAndPostDTOS() {
            return appAbodeAndPostDTOS;
        }

        public void setAppAbodeAndPostDTOS(List<AppAbodeAndPostDTOSBean> appAbodeAndPostDTOS) {
            this.appAbodeAndPostDTOS = appAbodeAndPostDTOS;
        }

        public static class AppAbodeAndPostDTOSBean {
            /**
             * abodeName :
             * post :
             * userAbodeId :
             */

            private String abodeName;
            private String abodeCode;
            private String post;
            private String userAbodeId;

            public String getAbodeCode() {
                return abodeCode;
            }

            public void setAbodeCode(String abodeCode) {
                this.abodeCode = abodeCode;
            }

            public String getAbodeName() {
                return abodeName;
            }

            public void setAbodeName(String abodeName) {
                this.abodeName = abodeName;
            }

            public String getPost() {
                return post;
            }

            public void setPost(String post) {
                this.post = post;
            }

            public String getUserAbodeId() {
                return userAbodeId;
            }

            public void setUserAbodeId(String userAbodeId) {
                this.userAbodeId = userAbodeId;
            }
        }
    }
}

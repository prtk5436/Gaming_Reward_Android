package com.example.gamingrewardandroid.SmartcookieRegistration.SchoolidValidation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {
        @SerializedName("school_id")
        @Expose
        private String schoolId;
        @SerializedName("school_name")
        @Expose
        private String schoolName;

        public String getSchoolId() {
            return schoolId;
        }

        public void setSchoolId(String schoolId) {
            this.schoolId = schoolId;
        }

        public String getSchoolName() {
            return schoolName;
        }

        public void setSchoolName(String schoolName) {
            this.schoolName = schoolName;
        }

    }

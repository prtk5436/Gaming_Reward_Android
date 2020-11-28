package com.example.gamingrewardandroid.SmartcookieRegistration.SchoolidValidation;

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class SchoolidInput {
    @SerializedName("school_id")
    @Expose
    private String schoolId;

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }
}

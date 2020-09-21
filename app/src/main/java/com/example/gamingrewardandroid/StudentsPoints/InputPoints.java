package com.example.gamingrewardandroid.StudentsPoints;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InputPoints {

    @SerializedName("student_id")
    @Expose
    private int studentId;
    @SerializedName("student_PRN")
    @Expose
    private String studentPRN;
    @SerializedName("school_id")
    @Expose
    private String schoolId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentPRN() {
        return studentPRN;
    }

    public void setStudentPRN(String studentPRN) {
        this.studentPRN = studentPRN;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }
}

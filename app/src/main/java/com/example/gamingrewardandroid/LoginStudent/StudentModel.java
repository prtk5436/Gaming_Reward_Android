package com.example.gamingrewardandroid.LoginStudent;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudentModel{

    private int userid;

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("Stud_Member_Id")
    @Expose
    private String MemberId;

    @SerializedName("Roll_no")
    @Expose
    private String rollNo;
    @SerializedName("std_PRN")
    @Expose
    private String S_PRN;
    @SerializedName("std_complete_name")
    @Expose
    private String Name;
    @SerializedName("std_name")
    @Expose
    private String FName;
    @SerializedName("std_lastname")
    @Expose
    private String LName;
    @SerializedName("std_Father_name")
    @Expose
    private String MName;
    @SerializedName("std_complete_father_name")
    @Expose
    private Object stdCompleteFatherName;
    @SerializedName("std_dob")
    @Expose
    private String dob;
    @SerializedName("old_std_dob")
    @Expose
    private String oldStdDob;
    @SerializedName("std_age")
    @Expose
    private String age;
    @SerializedName("std_school_name")
    @Expose
    private String Schoolname;
    @SerializedName("school_id")
    @Expose
    private String SchoolId;
    @SerializedName("sc_staff_id")
    @Expose
    private Object scStaffId;
    @SerializedName("std_branch")
    @Expose
    private String Branch;
    @SerializedName("std_dept")
    @Expose
    private String Dept;
    @SerializedName("std_year")
    @Expose
    private String YEAR;
    @SerializedName("std_semester")
    @Expose
    private String Semester;
    @SerializedName("std_class")
    @Expose
    private String ClassName;
    @SerializedName("Specialization")
    @Expose
    private String specialization;
    @SerializedName("std_address")
    @Expose
    private String address;
    @SerializedName("std_city")
    @Expose
    private String City;
    @SerializedName("std_country")
    @Expose
    private String country;
    @SerializedName("country_code")
    @Expose
    private String country_code;
    @SerializedName("std_gender")
    @Expose
    private String gender;
    @SerializedName("std_div")
    @Expose
    private String DivName;
    @SerializedName("std_hobbies")
    @Expose
    private String User_Hobbies;
    @SerializedName("std_classteacher_name")
    @Expose
    private String stdClassteacherName;
    @SerializedName("std_img_path")
    @Expose
    private String Imagepath;
    @SerializedName("std_email")
    @Expose
    private String emailid;
    @SerializedName("std_username")
    @Expose
    private String User_Name;
    @SerializedName("std_password")
    @Expose
    private String Password;
    @SerializedName("std_date")
    @Expose
    private String stdDate;
    @SerializedName("old_std_date")
    @Expose
    private String oldStdDate;
    @SerializedName("parent_id")
    @Expose
    private String parentId;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("std_phone")
    @Expose
    private String phone;
    @SerializedName("std_state")
    @Expose
    private String State;
    @SerializedName("used_blue_points")
    @Expose
    private String usedBluePoints;
    @SerializedName("balance_bluestud_points")
    @Expose
    private String balanceBluestudPoints;
    @SerializedName("balance_water_points")
    @Expose
    private String balanceWaterPoints;
    @SerializedName("batch_id")
    @Expose
    private Object batchId;
    @SerializedName("error_records")
    @Expose
    private Object errorRecords;
    @SerializedName("send_unsend_status")
    @Expose
    private String sendUnsendStatus;
    @SerializedName("email_status")
    @Expose
    private String emailStatus;
    @SerializedName("Temp_address")
    @Expose
    private String tempAddress;
    @SerializedName("permanent_address")
    @Expose
    private String permanentAddress;
    @SerializedName("Permanent_village")
    @Expose
    private String permanentVillage;
    @SerializedName("Permanent_taluka")
    @Expose
    private String permanentTaluka;
    @SerializedName("Permanent_district")
    @Expose
    private String permanentDistrict;
    @SerializedName("Permanent_pincode")
    @Expose
    private String permanentPincode;
    @SerializedName("Email_Internal")
    @Expose
    private String emailInternal;
    @SerializedName("Admission_year_id")
    @Expose
    private Object admissionYearId;
    @SerializedName("Academic_Year")
    @Expose
    private String academicYear;
    @SerializedName("Course_level")
    @Expose
    private String Courcelevel;
    @SerializedName("Iscoordinator")
    @Expose
    private String Iscoordinator = "N";
    @SerializedName("Gcm_id")
    @Expose
    private Object gcmId;
    @SerializedName("college_mnemonic")
    @Expose
    private String collegeMnemonic;
    @SerializedName("ExtBranchId")
    @Expose
    private Object extBranchId;
    @SerializedName("ExtDeptId")
    @Expose
    private Object extDeptId;
    @SerializedName("ExtSemesterId")
    @Expose
    private Object extSemesterId;
    @SerializedName("validity")
    @Expose
    private Object validity;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("uploaded_by")
    @Expose
    private String uploadedBy;
    @SerializedName("upload_date")
    @Expose
    private String uploadDate;
    @SerializedName("fb_id")
    @Expose
    private Object fbId;
    @SerializedName("gplus_id")
    @Expose
    private Object gplusId;
    @SerializedName("linkedin_id")
    @Expose
    private Object linkedinId;
    @SerializedName("RegistrationSource")
    @Expose
    private String registrationSource;
    @SerializedName("email_time_log")
    @Expose
    private String emailTimeLog;
    @SerializedName("sms_time_log")
    @Expose
    private String smsTimeLog;
    @SerializedName("group_status")
    @Expose
    private String groupStatus;
    @SerializedName("sms_response")
    @Expose
    private String smsResponse;
    @SerializedName("group_member_id")
    @Expose
    private String groupMemberId;

    @SerializedName("green")
    @Expose
    private String green;

    @SerializedName("is_accept_terms")
    @Expose
    private String is_accept_terms;


    @SerializedName("tnc_link")
    @Expose
    private String tnc_link;


    public StudentModel(int userid, int id, String memberId, String rollNo, String s_PRN, String name, String FName, String LName, String MName, Object stdCompleteFatherName, String dob, String oldStdDob, String age, String schoolname, String schoolId, Object scStaffId, String branch, String dept, String YEAR, String semester, String className, String specialization, String address, String city, String country, String country_code, String gender, String divName, String user_Hobbies, String stdClassteacherName, String imagepath, String emailid, String user_Name, String password, String stdDate, String oldStdDate, String parentId, String latitude, String longitude, String phone, String state, String usedBluePoints, String balanceBluestudPoints, String balanceWaterPoints, Object batchId, Object errorRecords, String sendUnsendStatus, String emailStatus, String tempAddress, String permanentAddress, String permanentVillage, String permanentTaluka, String permanentDistrict, String permanentPincode, String emailInternal, Object admissionYearId, String academicYear, String courcelevel, String iscoordinator, Object gcmId, String collegeMnemonic, Object extBranchId, Object extDeptId, Object extSemesterId, Object validity, String status, String uploadedBy, String uploadDate, Object fbId, Object gplusId, Object linkedinId, String registrationSource, String emailTimeLog, String smsTimeLog, String groupStatus, String smsResponse, String groupMemberId, String green, String is_accept_terms, String tnc_link) {
        this.userid = userid;
        this.id = id;
        MemberId = memberId;
        this.rollNo = rollNo;
        S_PRN = s_PRN;
        Name = name;
        this.FName = FName;
        this.LName = LName;
        this.MName = MName;
        this.stdCompleteFatherName = stdCompleteFatherName;
        this.dob = dob;
        this.oldStdDob = oldStdDob;
        this.age = age;
        Schoolname = schoolname;
        SchoolId = schoolId;
        this.scStaffId = scStaffId;
        Branch = branch;
        Dept = dept;
        this.YEAR = YEAR;
        Semester = semester;
        ClassName = className;
        this.specialization = specialization;
        this.address = address;
        City = city;
        this.country = country;
        this.country_code = country_code;
        this.gender = gender;
        DivName = divName;
        User_Hobbies = user_Hobbies;
        this.stdClassteacherName = stdClassteacherName;
        Imagepath = imagepath;
        this.emailid = emailid;
        User_Name = user_Name;
        Password = password;
        this.stdDate = stdDate;
        this.oldStdDate = oldStdDate;
        this.parentId = parentId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.phone = phone;
        State = state;
        this.usedBluePoints = usedBluePoints;
        this.balanceBluestudPoints = balanceBluestudPoints;
        this.balanceWaterPoints = balanceWaterPoints;
        this.batchId = batchId;
        this.errorRecords = errorRecords;
        this.sendUnsendStatus = sendUnsendStatus;
        this.emailStatus = emailStatus;
        this.tempAddress = tempAddress;
        this.permanentAddress = permanentAddress;
        this.permanentVillage = permanentVillage;
        this.permanentTaluka = permanentTaluka;
        this.permanentDistrict = permanentDistrict;
        this.permanentPincode = permanentPincode;
        this.emailInternal = emailInternal;
        this.admissionYearId = admissionYearId;
        this.academicYear = academicYear;
        Courcelevel = courcelevel;
        Iscoordinator = iscoordinator;
        this.gcmId = gcmId;
        this.collegeMnemonic = collegeMnemonic;
        this.extBranchId = extBranchId;
        this.extDeptId = extDeptId;
        this.extSemesterId = extSemesterId;
        this.validity = validity;
        this.status = status;
        this.uploadedBy = uploadedBy;
        this.uploadDate = uploadDate;
        this.fbId = fbId;
        this.gplusId = gplusId;
        this.linkedinId = linkedinId;
        this.registrationSource = registrationSource;
        this.emailTimeLog = emailTimeLog;
        this.smsTimeLog = smsTimeLog;
        this.groupStatus = groupStatus;
        this.smsResponse = smsResponse;
        this.groupMemberId = groupMemberId;
        this.green = green;
        this.is_accept_terms = is_accept_terms;
        this.tnc_link = tnc_link;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMemberId() {
        return MemberId;
    }

    public void setMemberId(String memberId) {
        MemberId = memberId;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getS_PRN() {
        return S_PRN;
    }

    public void setS_PRN(String s_PRN) {
        S_PRN = s_PRN;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public String getMName() {
        return MName;
    }

    public void setMName(String MName) {
        this.MName = MName;
    }

    public Object getStdCompleteFatherName() {
        return stdCompleteFatherName;
    }

    public void setStdCompleteFatherName(Object stdCompleteFatherName) {
        this.stdCompleteFatherName = stdCompleteFatherName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getOldStdDob() {
        return oldStdDob;
    }

    public void setOldStdDob(String oldStdDob) {
        this.oldStdDob = oldStdDob;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSchoolname() {
        return Schoolname;
    }

    public void setSchoolname(String schoolname) {
        Schoolname = schoolname;
    }

    public String getSchoolId() {
        return SchoolId;
    }

    public void setSchoolId(String schoolId) {
        SchoolId = schoolId;
    }

    public Object getScStaffId() {
        return scStaffId;
    }

    public void setScStaffId(Object scStaffId) {
        this.scStaffId = scStaffId;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }

    public String getDept() {
        return Dept;
    }

    public void setDept(String dept) {
        Dept = dept;
    }

    public String getYEAR() {
        return YEAR;
    }

    public void setYEAR(String YEAR) {
        this.YEAR = YEAR;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDivName() {
        return DivName;
    }

    public void setDivName(String divName) {
        DivName = divName;
    }

    public String getUser_Hobbies() {
        return User_Hobbies;
    }

    public void setUser_Hobbies(String user_Hobbies) {
        User_Hobbies = user_Hobbies;
    }

    public String getStdClassteacherName() {
        return stdClassteacherName;
    }

    public void setStdClassteacherName(String stdClassteacherName) {
        this.stdClassteacherName = stdClassteacherName;
    }

    public String getImagepath() {
        return Imagepath;
    }

    public void setImagepath(String imagepath) {
        Imagepath = imagepath;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getStdDate() {
        return stdDate;
    }

    public void setStdDate(String stdDate) {
        this.stdDate = stdDate;
    }

    public String getOldStdDate() {
        return oldStdDate;
    }

    public void setOldStdDate(String oldStdDate) {
        this.oldStdDate = oldStdDate;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getUsedBluePoints() {
        return usedBluePoints;
    }

    public void setUsedBluePoints(String usedBluePoints) {
        this.usedBluePoints = usedBluePoints;
    }

    public String getBalanceBluestudPoints() {
        return balanceBluestudPoints;
    }

    public void setBalanceBluestudPoints(String balanceBluestudPoints) {
        this.balanceBluestudPoints = balanceBluestudPoints;
    }

    public String getBalanceWaterPoints() {
        return balanceWaterPoints;
    }

    public void setBalanceWaterPoints(String balanceWaterPoints) {
        this.balanceWaterPoints = balanceWaterPoints;
    }

    public Object getBatchId() {
        return batchId;
    }

    public void setBatchId(Object batchId) {
        this.batchId = batchId;
    }

    public Object getErrorRecords() {
        return errorRecords;
    }

    public void setErrorRecords(Object errorRecords) {
        this.errorRecords = errorRecords;
    }

    public String getSendUnsendStatus() {
        return sendUnsendStatus;
    }

    public void setSendUnsendStatus(String sendUnsendStatus) {
        this.sendUnsendStatus = sendUnsendStatus;
    }

    public String getEmailStatus() {
        return emailStatus;
    }

    public void setEmailStatus(String emailStatus) {
        this.emailStatus = emailStatus;
    }

    public String getTempAddress() {
        return tempAddress;
    }

    public void setTempAddress(String tempAddress) {
        this.tempAddress = tempAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getPermanentVillage() {
        return permanentVillage;
    }

    public void setPermanentVillage(String permanentVillage) {
        this.permanentVillage = permanentVillage;
    }

    public String getPermanentTaluka() {
        return permanentTaluka;
    }

    public void setPermanentTaluka(String permanentTaluka) {
        this.permanentTaluka = permanentTaluka;
    }

    public String getPermanentDistrict() {
        return permanentDistrict;
    }

    public void setPermanentDistrict(String permanentDistrict) {
        this.permanentDistrict = permanentDistrict;
    }

    public String getPermanentPincode() {
        return permanentPincode;
    }

    public void setPermanentPincode(String permanentPincode) {
        this.permanentPincode = permanentPincode;
    }

    public String getEmailInternal() {
        return emailInternal;
    }

    public void setEmailInternal(String emailInternal) {
        this.emailInternal = emailInternal;
    }

    public Object getAdmissionYearId() {
        return admissionYearId;
    }

    public void setAdmissionYearId(Object admissionYearId) {
        this.admissionYearId = admissionYearId;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getCourcelevel() {
        return Courcelevel;
    }

    public void setCourcelevel(String courcelevel) {
        Courcelevel = courcelevel;
    }

    public String getIscoordinator() {
        return Iscoordinator;
    }

    public void setIscoordinator(String iscoordinator) {
        Iscoordinator = iscoordinator;
    }

    public Object getGcmId() {
        return gcmId;
    }

    public void setGcmId(Object gcmId) {
        this.gcmId = gcmId;
    }

    public String getCollegeMnemonic() {
        return collegeMnemonic;
    }

    public void setCollegeMnemonic(String collegeMnemonic) {
        this.collegeMnemonic = collegeMnemonic;
    }

    public Object getExtBranchId() {
        return extBranchId;
    }

    public void setExtBranchId(Object extBranchId) {
        this.extBranchId = extBranchId;
    }

    public Object getExtDeptId() {
        return extDeptId;
    }

    public void setExtDeptId(Object extDeptId) {
        this.extDeptId = extDeptId;
    }

    public Object getExtSemesterId() {
        return extSemesterId;
    }

    public void setExtSemesterId(Object extSemesterId) {
        this.extSemesterId = extSemesterId;
    }

    public Object getValidity() {
        return validity;
    }

    public void setValidity(Object validity) {
        this.validity = validity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Object getFbId() {
        return fbId;
    }

    public void setFbId(Object fbId) {
        this.fbId = fbId;
    }

    public Object getGplusId() {
        return gplusId;
    }

    public void setGplusId(Object gplusId) {
        this.gplusId = gplusId;
    }

    public Object getLinkedinId() {
        return linkedinId;
    }

    public void setLinkedinId(Object linkedinId) {
        this.linkedinId = linkedinId;
    }

    public String getRegistrationSource() {
        return registrationSource;
    }

    public void setRegistrationSource(String registrationSource) {
        this.registrationSource = registrationSource;
    }

    public String getEmailTimeLog() {
        return emailTimeLog;
    }

    public void setEmailTimeLog(String emailTimeLog) {
        this.emailTimeLog = emailTimeLog;
    }

    public String getSmsTimeLog() {
        return smsTimeLog;
    }

    public void setSmsTimeLog(String smsTimeLog) {
        this.smsTimeLog = smsTimeLog;
    }

    public String getGroupStatus() {
        return groupStatus;
    }

    public void setGroupStatus(String groupStatus) {
        this.groupStatus = groupStatus;
    }

    public String getSmsResponse() {
        return smsResponse;
    }

    public void setSmsResponse(String smsResponse) {
        this.smsResponse = smsResponse;
    }

    public String getGroupMemberId() {
        return groupMemberId;
    }

    public void setGroupMemberId(String groupMemberId) {
        this.groupMemberId = groupMemberId;
    }

    public String getGreen() {
        return green;
    }

    public void setGreen(String green) {
        this.green = green;
    }

    public String getIs_accept_terms() {
        return is_accept_terms;
    }

    public void setIs_accept_terms(String is_accept_terms) {
        this.is_accept_terms = is_accept_terms;
    }

    public String getTnc_link() {
        return tnc_link;
    }

    public void setTnc_link(String tnc_link) {
        this.tnc_link = tnc_link;
    }
}

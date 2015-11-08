package com.alpha.schoolmate.entity;

/**
 * Created by SongJian on 2015/11/8.
 * <p/>
 * 邮箱：1129574214@qq.com
 */
public class SchoolMate {
    /**
     * Address :
     * Birthday :
     * ClassName : 1班
     * Email :
     * Graduation : 2009
     * Handset :
     * HeadPicture : ../images/likeness/men_tiny.gif
     * QQ :
     * RealName : 熊伟
     * Sex : 男
     * SpecialityName : 测绘工程
     * UserID : 151079
     * WorkPlace : null
     */

    private String Address;
    private String Birthday;
    private String ClassName;
    private String Email;
    private String Graduation;
    private String Handset;
    private String HeadPicture;
    private String QQ;
    private String RealName;
    private String Sex;
    private String SpecialityName;
    private int UserID;
    private String WorkPlace;

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setBirthday(String Birthday) {
        this.Birthday = Birthday;
    }

    public void setClassName(String ClassName) {
        this.ClassName = ClassName;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setGraduation(String Graduation) {
        this.Graduation = Graduation;
    }

    public void setHandset(String Handset) {
        this.Handset = Handset;
    }

    public void setHeadPicture(String HeadPicture) {
        this.HeadPicture = HeadPicture;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public void setRealName(String RealName) {
        this.RealName = RealName;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public void setSpecialityName(String SpecialityName) {
        this.SpecialityName = SpecialityName;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public void setWorkPlace(String WorkPlace) {
        this.WorkPlace = WorkPlace;
    }

    public String getAddress() {
        return Address;
    }

    public String getBirthday() {
        return Birthday;
    }

    public String getClassName() {
        return ClassName;
    }

    public String getEmail() {
        return Email;
    }

    public String getGraduation() {
        return Graduation;
    }

    public String getHandset() {
        return Handset;
    }

    public String getHeadPicture() {
        return HeadPicture;
    }

    public String getQQ() {
        return QQ;
    }

    public String getRealName() {
        return RealName;
    }

    public String getSex() {
        return Sex;
    }

    public String getSpecialityName() {
        return SpecialityName;
    }

    public int getUserID() {
        return UserID;
    }

    public String getWorkPlace() {
        return WorkPlace;
    }

    @Override
    public String toString() {
        return "SchoolMate{" +
                "Address='" + Address + '\'' +
                ", Birthday='" + Birthday + '\'' +
                ", ClassName='" + ClassName + '\'' +
                ", Email='" + Email + '\'' +
                ", Graduation='" + Graduation + '\'' +
                ", Handset='" + Handset + '\'' +
                ", HeadPicture='" + HeadPicture + '\'' +
                ", QQ='" + QQ + '\'' +
                ", RealName='" + RealName + '\'' +
                ", Sex='" + Sex + '\'' +
                ", SpecialityName='" + SpecialityName + '\'' +
                ", UserID=" + UserID +
                ", WorkPlace=" + WorkPlace +
                '}';
    }

}

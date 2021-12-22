package models;

import java.io.Serializable;


public class Employee implements Serializable{
    private String idNV, nameNV, emailNV, pathAvt, Gender;
    private double salary;
    private int ageNV;
    private PEmployee pEmployee;

    public Employee() {
        
    }
    
    public Employee(String idNV, String nameNV, String emailNV, String pathAvt, double salary, int ageNV) {
        this.idNV = idNV;
        this.nameNV = nameNV;
        this.emailNV = emailNV;
        this.pathAvt = pathAvt;
        this.salary = salary;
        this.ageNV = ageNV;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public PEmployee getpEmployee() {
        return pEmployee;
    }

    public void setpEmployee(PEmployee pEmployee) {
        this.pEmployee = pEmployee;
    }
    
    public String getIdNV() {
        return idNV;
    }

    public String getPathAvt() {
        return pathAvt;
    }

    public void setPathAvt(String pathAvt) {
        this.pathAvt = pathAvt;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public String getNameNV() {
        return nameNV;
    }

    public void setNameNV(String nameNV) {
        this.nameNV = nameNV;
    }

    public int getAgeNV() {
        return ageNV;
    }

    public void setAgeNV(int ageNV) {
        this.ageNV = ageNV;
    }

    public String getEmailNV() {
        return emailNV;
    }

    public void setEmailNV(String emailNV) {
        this.emailNV = emailNV;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    
}

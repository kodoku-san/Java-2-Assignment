/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import database.XFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import models.Employee;

/**
 *
 * @author Asus
 */
public class EmployeeDAO implements LEmployeeDAO {

    private ArrayList<Employee> list;
    private int current;

    public EmployeeDAO() {
        list = new ArrayList<>();
        current = 0;
    }

    @Override
    @Deprecated
    public ArrayList<Employee> get() throws Exception {
        return list;
    }
    
    public <T> T getGeneric() throws Exception {
        return (T) list;
    }

    @Override
    public Employee get(String manv) throws Exception {
        Employee epl = null;
        for (int i = 0; i < list.size(); i++) {
            Employee employee = list.get(i);
            if (employee.getIdNV().equals(manv)) {
                epl = employee;
                break;
            }
        }
        return epl;
    }
    
    public <T> T getGeneric(String manv) throws Exception {
        T epl = null;
        for (int i = 0; i < list.size(); i++) {
            Employee employee = list.get(i);
            if (employee.getIdNV().equals(manv)) {
                epl = (T) employee;
                break;
            }
        }
        return epl;
    }

    @Override
    public void update(Employee epl) throws Exception {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            Employee employee = list.get(i);
            if (employee.getIdNV().equals(epl.getIdNV())) {
                index = i;
                break;
            }
        }
        if (index > -1) {
            Employee employee = list.get(index);
            employee.setAgeNV(epl.getAgeNV());
            employee.setNameNV(epl.getNameNV());
            employee.setEmailNV(epl.getEmailNV());
            employee.setSalary(epl.getSalary());
            employee.setGender(epl.getGender());
            employee.setpEmployee(epl.getpEmployee());
            employee.setPathAvt(epl.getPathAvt());
        } else {
            Employee employee = list.get(current);
            employee.setAgeNV(epl.getAgeNV());
            employee.setNameNV(epl.getNameNV());
            employee.setEmailNV(epl.getEmailNV());
            employee.setIdNV(epl.getIdNV());
            employee.setSalary(epl.getSalary());
            employee.setPathAvt(epl.getPathAvt());
        }
    }

    @Override
    public void delete(String manv) throws Exception {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            Employee employee = list.get(i);
            if (employee.getIdNV().equals(manv)) {
                index = i;
                break;
            }
        }
        if (index > -1) {
            list.remove(index);
        }
    }

    @Override
    public void insert(Employee epl) throws Exception {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            Employee employee = list.get(i);
            if (employee.getIdNV().equals(epl.getIdNV())) {
                index = i;
                break;
            }
        }
        if (index > -1) {
            throw new Exception("Mã sinh viên đã tồn tại");
        } else {
            list.add(epl);
        }
    }

    @Override
    public int search(String string) throws Exception {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            Employee employee = list.get(i);
            if (employee.getIdNV().equals(string)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void sort(String t) {
        if (t != null) {
            Comparator<Employee> comp = new Comparator<>() {
                @Override
                public int compare(Employee epl1, Employee epl2) {
                    if (t.equals("1")) {
                        return epl1.getIdNV().compareTo(epl2.getIdNV());
                    } else if (t.equals("2")) {
                        return epl1.getNameNV().compareTo(epl2.getNameNV());
                    } else {
                        double p = epl1.getSalary() - epl2.getSalary();
                        if (p > 0) {
                            return -1;
                        } else if (p < 0) {
                            return 1;
                        }
                        return 0;
                    }
                }
            };
            Collections.sort(list, comp);
        }
    }

    public int next() {
        if (current < list.size() - 1) {
            current++;
        } else {
            current = 0;
        }
        return current;
    }

    public int last() {
        current = list.size() - 1;
        return current;
    }

    public int previous() {
        if (current > 0) {
            current--;
        } else {
            current = list.size() - 1;
        }
        return current;
    }

    public int first() {
        current = 0;
        return current;
    }

    public void writeToFile() throws Exception {
        XFile.write(list, "employee.dat");
    }

    @Deprecated
    /*
    * Hàm này cũ rồi
    */
    public ArrayList<Employee> readFromFile() throws Exception {
        list = XFile.read("employee.dat");
        return list;
    }

    public <T> T readFromFileGeneric() throws Exception {
        list = XFile.read("employee.dat");
        return (T) list;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

}

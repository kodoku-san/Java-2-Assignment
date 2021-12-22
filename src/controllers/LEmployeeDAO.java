/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import models.Employee;

/**
 *
 * @author Asus
 */
public interface LEmployeeDAO {
    ArrayList<Employee> get() throws Exception;
    Employee get(String ma) throws Exception;
    void update(Employee dt) throws Exception;
    void delete(String ma) throws Exception;
    void insert(Employee dt) throws Exception;
    int search(String dt) throws Exception;
}

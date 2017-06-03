/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.webservice;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.util.*;
import java.util.List;
import java.util.Arrays;

/**
 *
 * @author kondrashyn
 */
@WebService(serviceName = "Service2")
public class Service2 {
    
    //find the greatest common divisor
    //Euclid's method
    //https://en.wikipedia.org/wiki/Euclidean_algorithm
    private static int gcd(int a, int b) {
    int t;
    while(b != 0){
        t = a;
        a = b;
        b = t%b;
    }
    return a;
}

    /**
     * Web service operation
     */
    @WebMethod(operationName = "parse_list")
    public String parse_list(@WebParam(name = "list") String list) {
        List<String> items = Arrays.asList(list.split(" "));
        boolean IsFirst = true;
        String result="";
        for(int i = 0; i < items.size(); i++) {
            for(int j = 0; j < items.size(); j++) {
                if (i==0 && j==0)
                    continue;
                if (gcd(Integer.parseInt(items.get(i)), Integer.parseInt(items.get(j))) == 1) {
                    result+="(" + items.get(i) + "," + items.get(j) + ")";
                }
            }
        }
        return result;
    }
}

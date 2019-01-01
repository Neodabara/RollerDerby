/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rollerderby;


import java.io.*;
import java.util.*;

/**
 *
 * @author student
 */
public class RollerDerbyPlayer implements Serializable
{
    private String firstName;
    private String lastName;
    private String ageYears;
    private String heightFeet;
    private String heightInches;
    private String approxWeight;
    
    public RollerDerbyPlayer(String firstName, String lastName, String ageYears,
            String heightFeet, String heightInches, String approxWeight)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ageYears = ageYears;
        this.heightFeet = heightFeet;
        this.heightInches = heightInches;
        this.approxWeight = approxWeight;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    public String getAgeYears()
    {
        return ageYears;
    }
    
    public void setAgeYears(String ageYears)
    {
        this.ageYears = ageYears;
    }
    
    public String getHeightFeet()
    {
        return heightFeet;
    }
    
    public void setHeightFeet(String heightFeet)
    {
        this.heightFeet = heightFeet;
    }
    
    public String getHeightInches()
    {
        return heightInches;
    }
    
    public void setHeightInches(String heightInches)
    {
        this.heightInches = heightInches;
    }
    
    public String getApproxWeight()
    {
        return approxWeight;
    }
    
    public void setApproxWeight(String approxWeight)
    {
        this.approxWeight = approxWeight;
    }
    
    public String toCSV()
    {
        return firstName + ", " + lastName + ", " + ageYears + ", " 
                + heightFeet + ", " + heightInches + ", " + approxWeight;
    }
    
    @Override
    public String toString()
    {
        return firstName + " " + lastName + " " + ageYears + " " + heightFeet +
                " " + heightInches + " " + approxWeight;
    }
}

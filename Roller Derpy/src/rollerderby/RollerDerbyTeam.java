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
public class RollerDerbyTeam implements Serializable 
{
    private static ArrayList<RollerDerbyPlayer> players;
    private static ArrayList<RollerDerbyPlayer> deserializedTeam;
    String filename;
    private static Scanner scan;
    
    public RollerDerbyTeam()
    {
        players = new ArrayList<>();
    }
    
    //Code to load the file
    public static void loadTeam(String filename)
    {        
        String firstName, lastName, ageYears, heightFeet, heightInches, approxWeight;
        
        try
        {
            
            //So the example file wasn't reading everything. I came to the 
            //conclusion that the Delimiter was causing this for some reason.
            //As to why, I am not sure, but I found that there is another way 
            //to remove the commas is with the '.replace' function.
            
            scan = new Scanner(new File(filename));
            while(scan.hasNext())
            {
                firstName = scan.next();
                firstName = firstName.replace(",", "");
                
                lastName = scan.next();
                lastName = lastName.replace(",", "");
                
                ageYears = scan.next();
                ageYears = ageYears.replace(",", "");
                
                heightFeet = scan.next();
                heightFeet = heightFeet.replace(",", "");
                
                heightInches = scan.next();
                heightInches = heightInches.replace(",", "");
                
                approxWeight = scan.next();
                approxWeight = approxWeight.replace(",", "");

                
               System.out.println(firstName + ", " + lastName + ", " + ageYears
                + ", " + heightFeet + ", " + heightInches + ", " + approxWeight);
                
                players.add(new RollerDerbyPlayer(firstName, lastName, ageYears, heightFeet, heightInches, approxWeight));
            }
        }
        catch (NoSuchElementException e)
        {
            System.err.println("NoSuchElementException " + e.getMessage()); 
        }
        catch (IOException  e) 
        {
            System.err.println("IOException " + e.getMessage());
        }
        finally
        {
            if(scan != null)
                scan.close();
        }
    }
    
    //The code to serialize the file
    public void serializeTeam(String filename)
    {
        ObjectOutputStream oos = null;
        
        try
        {
            oos = new ObjectOutputStream(
                    new FileOutputStream(filename));
            
            oos.writeObject(players);
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if (oos != null)
                {
                    oos.close();
                }
            }
            catch (IOException e)
            {
                System.err.println("The File Will Not Close" + e.getMessage());   
            }
        }
    }
    
    //Code to deserialize the file
    
    public static void deSerializedTeam(String filename)
    {
        ObjectInputStream ois = null;
        
        deserializedTeam = new ArrayList<>();
        
        try
        {
            ois = new ObjectInputStream(new FileInputStream(filename));
            
            deserializedTeam = (ArrayList<RollerDerbyPlayer>) ois.readObject();
        }
        catch (IOException e)
        {
            System.err.println( e.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            System.err.println("There was a problem reading this object: " 
                    + e.getMessage());
        }
        finally
        {
            try
            {
                if (ois != null)
                    ois.close();
            }
            catch (IOException e)
            {
                System.err.println("This file failed to close: " 
                        + e.getMessage());
            }
        }
    }
    
    //Code to turn objects into CSV
    
    public void writeTeam(String filename)
    {
        PrintWriter pw = null;
        
        try
        {
          pw = new PrintWriter(new File("roller_derby_team_2.csv"));
          
          for (RollerDerbyPlayer  RollerDerbyPlayer : deserializedTeam)
              pw.println(RollerDerbyPlayer.toCSV());
        }
        catch (IOException e)
        {
            System.err.println("Failed to write to file: " + e.getMessage());
        }
        finally
        {
            if (pw != null)
                pw.close();
        }
    }
    
    @Override
    public String toString()
    {
        String teamString = "";
        for (int i = 0; i < players.size(); i++)
        {
            teamString += players.get(i);
            if (i != (players.size() - 1))
                teamString += "\n";
        }
        return teamString;
    }
}

package rollerderby;

/**
 * Project 4
 * Class: CS-225
 * @author Marcus Brock
 */

public class RollerDerby {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        RollerDerbyPlayer p = new RollerDerbyPlayer("J'Conquis", "Jerson",
//                "12", "8", "13", "235");
//        System.out.println("∫ but also " + p);
        RollerDerbyTeam t = new RollerDerbyTeam();
        RollerDerbyTeam.loadTeam("roller_derby_team.csv");
        t.serializeTeam("roller_derby_objects.object");
        RollerDerbyTeam.deSerializedTeam("roller_derby_objects.object");
        t.writeTeam("roller_derby_objects.object");
       
    }
    
}
 // Do I get bonus points for knowing that this is a Key and Peele Reference?
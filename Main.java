import java.util.Scanner;
import java.util.*;
import java.io.*;		//Using IO Class
public class Main
{
  double adult;			//number of adult tickets
  double child;			//number of child tickets
  double childAboveTwo;
  double points = 0;
  double netAmount = 0;
  double childTotal;
  double childAboveTwoTotal;
  double fareOfChildBetweenZeroToEight;
  double fareOfChildBetweenNineToSixteen;
  String clubLevel = "";
  Integer route = 0;
  Integer club = 0;
  String departTiming;
  Integer ticketCharges = 0;
  Integer departTimingInt;
  Integer childBetweenZeroToEight = 0;
  Integer childBetweenNineToSixteen = 0;
  String clubKey = "";
  Scanner scanner = new Scanner (System.in);
  BufferedReader br = new BufferedReader (new InputStreamReader (System.in));	//Buffered Reader Class
  //Main Method 
  public static void main (String[]args) throws IOException
  {
    Main m1 = new Main ();
      m1.flightFare ();
  }
  public void flightFare () throws IOException
  {
    HashMap < String, Integer > departSydneyToMelbourne =
      new HashMap < String, Integer > ();
    departSydneyToMelbourne.put ("06:05", 75);
    departSydneyToMelbourne.put ("06:40", 74);
    departSydneyToMelbourne.put ("07:00", 79);
    departSydneyToMelbourne.put ("10:00", 131);

    HashMap < String, Integer > departMelbourneToSydney = new HashMap < String, Integer > ();
    departMelbourneToSydney.put ("06:15", 79);
    departMelbourneToSydney.put ("06:50", 76);
    departMelbourneToSydney.put ("07:30", 89);
    departMelbourneToSydney.put ("10:15", 99);
    //Hashmap for points and club level
    HashMap < String, Integer > mapForLevelAndPoints = new HashMap < String, Integer > ();
    mapForLevelAndPoints.put ("Bronze", 15);
    mapForLevelAndPoints.put ("Silver", 12);
    mapForLevelAndPoints.put ("Gold", 10);
    System.out.print ("Enter Name: ");
    String name = scanner.nextLine ();
    while (name.isEmpty ())
      if (name == "" || name.length () == 0)
	{			//validation for name.
	  System.out.println ("Must type a NAME!");
	  System.exit (0);
	}
    System.out.println ("Please select the route of flight");
      System.out.println(" 0 - for SydneyToMelbourne\n 1 - for MelbourneToSydney\n");
      route = Integer.parseInt (br.readLine ());
    if (route == 0 || route == 1)
      {				//validation for route selection.
	System.out.println ("Your selected route of flight : " + route);
      }
    else{
	System.out.println ("Your have selected Wrong choice");
	System.exit (0);	//exit after wrong route
      }
    //Get the number of Adults and childrens details.
    System.out.println("How many adult tickets do you wish to purchase? (ages 18-64): ");
    adult = scanner.nextInt ();
    if (adult < 0)
      {				//validation for positive number.
	System.out.println ("you have entered wrong choice");
	System.exit (0);
      }
    System.out.println("How many child tickets do you wish to purchase? (ages 0-2): ");
    child = scanner.nextInt ();
    if (child < 0){				//validation for positive number. 
	System.out.print ("you have entered wrong choice");
	System.exit (0);
      }
    System.out.println("How many child tickets do you wish to purchase? (ages 3-16): ");
    childAboveTwo = scanner.nextInt ();
    if (childAboveTwo < 0)
      {				//validation for positive number. 
	System.out.print ("you have entered wrong choice");
	System.exit (0);
      }
    //Get the Time slot of flight 
    if (route == 1) {
	System.out.println ("Enter Depart timing in (HH:mm Format) for get charges of MelbourneToSydney from mensioned list " +departMelbourneToSydney.keySet ());
	System.out.println("\n1 - for 06:15 \n 2 - for 06:50\n 3 - 07:30\n 4 - for 10:15\n");
	departTimingInt = Integer.parseInt (br.readLine ());
	departTiming =departTimingInt == 1 ? "06:15" : (departTimingInt ==2 ? "06:50" :departTimingInt ==3 ? "07:30" : departTimingInt ==4 ? "10:00" :"Please select proper time slot");
	if (departMelbourneToSydney.containsKey (departTiming))
	  {			//validation for Time slot. 
	    System.out.println ("You have selected time slot" + departTiming);
	  }
	else
	  {
	    System.out.print ("Please select proper time slot");
	    System.exit (0);
	  }
      }
    else
      {
	System.out.println ("Enter Depart timing in (HH:mm Format) for get charges of SydneyToMelbourne from mensioned list " +departSydneyToMelbourne.keySet ());
	System.out.println("\n1 - for 06:05 \n 2 - for 06:40\n 3 - for 07:00\n 4 - for 10:00\n");
	departTimingInt = Integer.parseInt (br.readLine ());
	departTiming =departTimingInt == 1 ? "06:05" : (departTimingInt ==2 ? "06:40" :departTimingInt ==3 ? "07:00" : departTimingInt ==4 ? "10:00" :"Please select proper time slot");
	if (departSydneyToMelbourne.containsKey (departTiming))
	  {			//validation for Time slot.
	    System.out.println ("You have selected time slot" + departTiming);
	  }
	else
	  {
	    System.out.print ("Please select proper time slot");
	    System.exit (0);
	  }
      }
    //calculate tickit charge based on depart time.
    if (route == 0)
      {
	ticketCharges = departSydneyToMelbourne.get (departTiming);
	System.out.println ("Ticket Charges" + ticketCharges);
      }
    else if (route == 1)
      {
	ticketCharges = departMelbourneToSydney.get (departTiming);
	System.out.println ("Ticket Charges" + ticketCharges);
      }
    else
      {
	System.out.println("Please choose correct time slot in proper format (HH:mm Format) from mensioned list");
      }
    //Get the clublevel 
    System.out.println ("Enter your club level (Bronze,Silver,Gold,NA)");
    System.out.println("1 - for Bronze\n 2 - for Silver\n 3 - for Gold\n 4 - for NA\n");
    club = Integer.parseInt (br.readLine ());
    if (club < 0)
      {				//validation for clubLevel.
	System.out.println ("Must enter a clubLevel (1,2,3,4)!");
	System.exit (0);
      }
    // apply membership points 
    clubKey =club == 1 ? "Bronze" : (club == 2 ? "Silver" : club ==3 ? "Gold" : "NA");
    if (club == 3)
      {
	System.out.println("How many child tickets do you wish to purchase? (ages 0-8): ");
	childBetweenZeroToEight = scanner.nextInt ();
	fareOfChildBetweenZeroToEight = 0;
	System.out.println("How many child tickets do you wish to purchase? (ages 9-16): ");
	childBetweenNineToSixteen = scanner.nextInt ();
	fareOfChildBetweenNineToSixteen = (0.75 * (ticketCharges));	//75% Tikit charge for above 9years child for single tickit.
      }
    if (mapForLevelAndPoints.containsKey (clubKey))
      {
	points = mapForLevelAndPoints.get (clubKey);
	childTotal = 0;
	if (clubKey != " NA" || club != 4)
	  {
	    childAboveTwoTotal = (0.75 * (ticketCharges));	//75% Tikit charge for above 2years child for single tickit.
	    }
      }
    else
      {
	points = 0;
	}
    if (clubKey == "Gold")
      {
	System.out.println ("flight fare of child between age 0-8:" + "$" +(fareOfChildBetweenZeroToEight * childBetweenZeroToEight) +"\nchild between age 9-16:" + "$" +(fareOfChildBetweenNineToSixteen * childBetweenNineToSixteen));
      }
    else
      {
	System.out.println ("flight fare of child between age 0-2:" + "$" + (childTotal * child) + "\nchild between age 3-16:" + "$" + (childAboveTwoTotal * childAboveTwo));
      }
    System.out.println ("clublevel:" + clubKey +"\nPoints you have gained: $*" + points);
    System.out.println ("--- TICKET DETAILS---");
    System.out.println ("Ticket Charges For Adult for selected route:$" +(ticketCharges * adult));
    Main m2 = new Main ();
    m2.displayFareAmount (clubKey, ticketCharges, adult, child,childAboveTwo,childTotal,childAboveTwoTotal,fareOfChildBetweenZeroToEight,fareOfChildBetweenNineToSixteen,childBetweenZeroToEight, childBetweenNineToSixteen);
    System.out.println("----------------------------------------------------------------------------------------------------------------");
    if (clubKey == "Gold")
      {
	System.out.printf ("%5s %10s %10s %10s %10s %10s %10s %10s %10s",
			   "NAME", "DEPARTTIMING", "ADULT", "CHILDAGE(0-8)",
			   "CHILDAGE(9-16)", "TICKITCHARGE",
			   "TOTALCOST", "CLUBLEVEL", "POINTS");
      }
    else
      {
	System.out.printf ("%5s %10s %10s %10s %10s %10s %10s %10s %10s",
			   "NAME", "DEPARTTIMING", "ADULT", "CHILDAGE(0-2)",
			   "CHILDAGE(3-16)", "TICKITCHARGE",
			   "TOTALCOST", "CLUBLEVEL", "POINTS");
      }
    System.out.println ();
    System.out.println("----------------------------------------------------------------------------------------------------------------");
    if (clubKey == "Gold")
      {
	System.out.format ("%5s %10s %10s %10s %10s %15s %15s %10s %10s",name, departTiming,adult, child, childAboveTwo,ticketCharges,((ticketCharges * adult) +(fareOfChildBetweenZeroToEight *childBetweenZeroToEight) +(fareOfChildBetweenNineToSixteen *childBetweenNineToSixteen)),clubKey, "$*" + points);
      }
    else
      {
	System.out.format ("%5s %10s %10s %10s %10s %15s %15s %10s %10s",name, departTiming, adult,child, childAboveTwo,ticketCharges,((ticketCharges * adult) + (childTotal * child) +(childAboveTwoTotal * childAboveTwo)), clubKey, "$*" + points);
      }
    System.out.println ();
    System.out.println("----------------------------------------------------------------------------------------------------------------");
    }

    //method to calculate total flight fare
    void displayFareAmount (String clubKey, int ticketCharges, double adult,
			    double child,
			    double childAboveTwo,
			    double childTotal,
			    double childAboveTwoTotal,
			    double fareOfChildBetweenZeroToEight,
			    double
			    fareOfChildBetweenNineToSixteen,
			    int childBetweenZeroToEight,
			    int childBetweenNineToSixteen)
    {

      if (clubKey == "Gold")
	{

	  netAmount =
	    ((ticketCharges * adult) +
	     (fareOfChildBetweenZeroToEight * childBetweenZeroToEight) +
	     (fareOfChildBetweenNineToSixteen * childBetweenNineToSixteen));

	}
      else
	{

	  netAmount =
	    ((ticketCharges * adult) + (childTotal * child) +
	     (childAboveTwoTotal * childAboveTwo));

	}

      System.out.println ("Total Flight Fair " + "$" + netAmount);

    }

    }

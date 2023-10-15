//4(L3).Write a simple ticket booking system using polymorphism 

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


interface BusInterface
{
	public String getBusName();
	public int getNoOfSeatsAvailable();
	public String getStartLocation();
	public String getStopLocation();
	public String getStartTime();
	public String getStopTime();
}
class Bus implements BusInterface
{
	int noOfSeatsAvailable;
	String busName;
	int seats;
	String startLocation;
	String stopLocation;
	String startTime;
	String stopTime;
	double fare;
	String dateOfJourney;
	String ticketVal;
	Bus(){}
	Bus(String busName,int noOfSeatsAvailable,String startLocation,String stopLocation,int fare,String startTime,String stopTime,String ticketVal,String dateOfJourney){
		this.startTime=startTime;
		this.stopTime=stopTime;
		this.busName=busName;
		this.noOfSeatsAvailable=noOfSeatsAvailable;
		this.startLocation=startLocation;
		this.stopLocation=stopLocation;
		this.fare=fare;
		this.seats=noOfSeatsAvailable;
		this.ticketVal=ticketVal;
		this.dateOfJourney=dateOfJourney;
	}
	public String getBusName(){
		return busName;
	}
	public int getNoOfSeatsAvailable(){
		return noOfSeatsAvailable;
	}		
	public String getStartLocation(){
		return startLocation;
	}
	public String getStopLocation(){
		return stopLocation;
	}
	public String getStartTime(){
		return startTime;
	}
	public String getStopTime(){
		return stopTime;
	}
		
}

class Ticket
{	
	String name,ticket;
	Ticket(String name,String ticket){
		this.ticket=ticket;
		this.name=name;
	}
}

class Passenger
{
	String name;
	int age;
	String gender;
	String startLocation;
	String endLocation;
	String address;
	String phoneNumber;
	String dateOfJourney;
	int numberOfTickets;
	Passenger(){}
	Passenger(String name,int age,String gender,String phoneNumber,String address,String dateOfJourney,int numberOfTickets,String startLocation,String endLocation){
		this.name=name;
		this.gender=gender;
		this.phoneNumber=phoneNumber;
		this.startLocation=startLocation;
		this.endLocation=endLocation;
		this.address=address;
		this.age=age;
		this.dateOfJourney=dateOfJourney;
		this.numberOfTickets=numberOfTickets;
	}	
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}		
	public String getGender(){
		return gender;
	}
	public String getPhoneNumber(){
		return phoneNumber;
	}
	public String getAddress(){
		return address;
	}
	public String getDateOfJourney(){
		return dateOfJourney;
	}	
}

class TicketBooking
{
	List<Bus> bus=new ArrayList<Bus>();
	List<Passenger> passenger=new ArrayList<Passenger>();
	List<Ticket> ticket =new ArrayList<Ticket>();
	Scanner sc=new Scanner(System.in);
	public void addPassenger(Passenger passengerObj){
		passenger.add(passengerObj);
	}
	public void addBus(Bus busObj){
		bus.add(busObj);
	}
	public void getBusDetails(){
		for(Bus busKey:bus){	
			System.out.println("Bus Operator Name: "+busKey.busName+", Number of Available Seats: "+busKey.noOfSeatsAvailable+", Start Point: "+busKey.startLocation+", End Point: "+busKey.stopLocation+", Start Time: "+busKey.startTime+" ,End Time: "+busKey.stopTime);		}
	}
	public void getPassengerDetails(){
		//System.out.println(passenger(0).name);
		for(Passenger passengerKey:passenger){
			System.out.println("Passenger Name: "+passengerKey.name+", Age "+passengerKey.age+", Gender "+passengerKey.gender+", Phone Number: "+passengerKey.phoneNumber+", Address: "+passengerKey.address);
		}
	}
	public String getTicket(String passengerName){
		String flag="Ticket not found...";
		for(Ticket ticketNumber:ticket){
			if(passengerName.equals(ticketNumber.name)){
				flag=ticketNumber.ticket;
				break;
			}
		}	
		return flag;

	}
	public void bookTicket(int numberOfSeats,String Name,String startLocation,String endLocation)
	{
		Bus busObj=bus.get(0);
		int fla=0;
		if(numberOfSeats<=busObj.noOfSeatsAvailable && busObj.seats>0){
					
			for(int i=1;i<=numberOfSeats;i++){
				if((busObj.startLocation).equals(startLocation) && (busObj.stopLocation).equals(endLocation)){	
					busObj.noOfSeatsAvailable-=numberOfSeats;	
					System.out.println("Bus Name: "+busObj.busName+"Fare: "+busObj.fare);
					String val=Integer.toString(i);	
					String ticket1=(busObj.ticketVal)+val;
					ticket.add(new Ticket(Name,ticket1));
					fla=1;					System.out.println("Ticket(Ticket ID: "+ticket1+" Booked Successfully from "+startLocation+" to "+endLocation);
					break;				}
		
			}
			if(fla==0){
				System.out.println("Bus not Found... Try with different location....");
			}
		}	
		else{
			System.out.println("Seat Full...");
		}
	}
	public void cancelTicket(String passName,int numberOfTickets){
		//Bus busObj=bus.get(0);
	
		//Passenger passObj5=new Passenger();
		for(int i=1;i<passenger.size();i++){
			if(((passenger.get(i)).name).equals(passName) && numberOfTickets<=(bus.get(i)).noOfSeatsAvailable){
				bus.remove(bus.get(i));
				passenger.remove(passenger.get(i));
				bus.get(i).noOfSeatsAvailable+=numberOfTickets;
				System.out.println("Ticket cancelled Successfully...");
				break;
			}	
		}
	}
	public String ticketSummary(String nameOfPass, int ageOfPass,String genderOfPass,int numberOfTick){
		String ticketSum="";
		for(int i=0;i<passenger.size();i++){
			if((((passenger.get(i)).name).equals(nameOfPass)) && (((passenger.get(i)).age)==ageOfPass)){
				Bus busObj1=bus.get(i);
				Ticket ticketObj1=ticket.get(i);
				ticketSum="Ticket Number: "+(ticketObj1).ticket+"Name: "+(passenger.get(i)).name+", Bus Name: "+(busObj1).busName+", Age: "+(passenger.get(i)).age+", PhoneNumber: "+(passenger.get(i)).phoneNumber+", Gender: "+(passenger.get(i)).gender+", Address: "+(passenger.get(i)).address+", Date of Journey: "+(passenger.get(i)).dateOfJourney+", Seat Numer:"+(busObj1).noOfSeatsAvailable+", Boarding Point: "+(busObj1).startLocation+", Dropping Point: "+(busObj1).stopLocation+"Boarding Time: "+(busObj1).startTime+", Dropping Time: "+(busObj1).stopTime;

				break;
			}	
		}
		if(ticketSum.length()<5){
			ticketSum+="No Ticket Found...";
		}
		return ticketSum;
		
	}
}

//Main Class
public class TicketBookingSystem
{	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);	
		
		TicketBooking t=new TicketBooking();
		Date d=new Date();
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");  
       		String strDate1= formatter1.format(d);  
		Bus bz1=new Bus("APRTY",35,"Chennai","Mumbai",3000,"27/08/2023. 06:00","28/08/2023. 12:00","APR","27/08/2023");
		t.addBus(bz1);
		Bus bz2=new Bus("SATTP",30,"Chennai","Mumbai",2000,"27/08/2023. 04:30","28/08/2023. 10:00","SAT","27/08/2023");
		t.addBus(bz2);
		Bus bz3=new Bus("PPTYR",33,"Tenkasi","Chennai",3500,"27/08/2023. 06:30","28/08/2023. 07:30","PPT","27/08/2023");
		t.addBus(bz3);
		Bus bz4=new Bus("YAPTA",39,"Tirunelveli","Mumbai",5000,"27/08/2023. 06:00","28/08/2023. 18:00","YAP","27/08/2023");
		t.addBus(bz4);
		Bus bz5=new Bus("UMLT",32,"Chennai","Delhi",2500,"27/08/2023. 06:00","28/08/2023. 23:50","APR","27/08/2023");
		t.addBus(bz5);
		Passenger ps1=new Passenger("Name",20,"m","8825919231","Address123","27/08/2023",2,"Chennai","Mumbai");
		t.addPassenger(ps1);
		while(true){
			System.out.println("\n1. Bus Operator");
			System.out.println("2. Passenger");
			System.out.println("3. Exit");
			int choice=sc.nextInt();
			switch(choice){
				case 1:
					System.out.println("\n1. Add Bus Details");
					System.out.println("2. View Bus Details");
					System.out.println("3. Find Ticket");
					System.out.println("4. View Passenger Details");
					System.out.println("5. Exit");
					
					int choice2=sc.nextInt();
					switch(choice2){
						case 1:
							System.out.print("Enter Bus Name: ");
							String busName1=sc.next();
							String ticketVal1=busName1.substring(0,3);
							int noOfSeatsAvailable1=0;
							boolean flag=true;
								while(flag){
									System.out.print("Enter Number of Seats Available: ");
									int noOfSeats1=sc.nextInt();
									if(noOfSeats1<=35){
										noOfSeatsAvailable1=noOfSeats1;
										flag=false;
									}		
									else{
										System.out.println("Enter valid number of Seats...");
									}
								}
								System.out.print("Enter starting Location: ");
								String startLocation1=sc.next();
								System.out.print("Enter ending Location: ");
								String endLocation1=sc.next();
								System.out.print("Enter starting time: ");
								String startTime1=sc.next();
								System.out.print("Enter end time: ");
								String stopTime1=sc.next();
								System.out.print("Enter fare: ");
								int fare1=sc.nextInt();
								Date d1 = new Date();
        							SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
       				 				String strDate= formatter.format(d1);  
								int month=Integer.parseInt(strDate.substring(3,5));
								Bus b=new Bus(busName1,noOfSeatsAvailable1,startLocation1,endLocation1,fare1,startTime1,stopTime1,ticketVal1,strDate);
								
								t.addBus(b);
								break;
						case 2:
							t.getBusDetails();
							break;
						case 3:
							String ticketName=sc.nextLine();
							t.getTicket(ticketName);
							break;
						case 4:
							t.getPassengerDetails();
							break;
						case 5:
							System.out.println("Exiting...");
							break;
						default:
							System.out.println("Enter Valid Input!");
					}
					break;
					
					case 2:
						System.out.println("\n1. Book Ticket");
						System.out.println("2. Cancel Ticket");
						System.out.println("3. Ticket Summary");
						System.out.println("4. Exit");	
						String passName,gender1,address,dateOfJourney;
						int age1,numberOfTickets;
						int choice1=sc.nextInt();
						switch(choice1){
							case 1:
								
								System.out.print("Enter your name: ");
								passName=sc.next();
								System.out.print("Enter Age: ");
								age1=sc.nextInt();
								
								System.out.print("Enter your gender: ");
								gender1=sc.next();
								boolean flag=true;	
								String phone="";
								System.out.print("Enter your phone number: ");	
								while(flag){
									String phoneNum=sc.next();
									if(phoneNum.length()==10){
										phone=phoneNum;
										flag=false;
									}
									else{
										System.out.println("Reenter 10 digit phone number...");
									}	
								}
								System.out.print("Enter your Address: ");
								address=sc.next();
								System.out.print("Enter starting Location: ");
								String startLocation2=sc.next();
								System.out.print("Enter ending Location: ");
								String endLocation2=sc.next();
								boolean flag1=true;
								dateOfJourney="";

								while(flag1){
									String date1=sc.next();
									if(Integer.parseInt(date1.substring(3,5))<=12){
										dateOfJourney=date1;
										flag1=false;
									}
									else{
										System.out.println("Enter the date in correct order...");
									}	
								}
								System.out.print("Enter number of Tickets: ");
								numberOfTickets=sc.nextInt();
								Passenger p=new Passenger(passName,age1,gender1,phone,address,dateOfJourney,numberOfTickets,startLocation2,endLocation2);
								t.bookTicket(numberOfTickets,passName,startLocation2,endLocation2);
								break;
							case 2:
								System.out.print("Enter your name: ");
								passName=sc.next();
								System.out.print("Enter number of Tickets: ");
								numberOfTickets=sc.nextInt();
								t.cancelTicket(passName,numberOfTickets);
								break;
							case 3:
								System.out.print("Enter your name: ");
								passName=sc.next();
								System.out.print("Enter number of Tickets: ");
								numberOfTickets=sc.nextInt();
								System.out.print("Enter Age: ");
								age1=sc.nextInt();
								System.out.print("Enter your gender: ");
								gender1=sc.next();
								System.out.print(t.ticketSummary(passName,age1,gender1,numberOfTickets));
								break;
							default:
								System.out.println("Enter valid input...");
								
					}
					break;
			case 3:
				System.out.println("Exiting...");
				System.exit(0);
			
			default:
				System.out.println("Enter valid input...");
			}
		}
	}	
}
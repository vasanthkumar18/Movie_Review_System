import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Comparator;

public class Main
{
    
    /*public static TreeMap<String, Float> sortMapByValue(HashMap<String, Float> map){
		Comparator<String> comparator = new ValueComparator(map);
		//TreeMap is a map sorted by its keys. 
		//The comparator is used to sort the TreeMap by keys. 
		TreeMap<String, Float> result = new TreeMap<String, Float>(comparator);
		result.putAll(map);
		return result;
	}*/
    
   public static HashMap<String, Float> sortByValue(HashMap<String, Float> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Float> > list =
               new LinkedList<Map.Entry<String, Float> >(hm.entrySet());
  
        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Float> >() {
            public int compare(Map.Entry<String, Float> o1, 
                               Map.Entry<String, Float> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
          
        // put data from sorted list to hashmap 
        HashMap<String, Float> temp = new LinkedHashMap<String, Float>();
        for (Map.Entry<String, Float> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
  
  // to get key from a value in a HASHMAP  
  public static <K, V> K getKey(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
    
	public static void main(String[] args) {
		System.out.println("Welcome to *****Movie Review Service*****\n");
		
		HashMap<String,Integer> movies= new HashMap<>(); //movie and count of review
		HashMap<String,Float> rev=new HashMap<>();       // movie and review
		HashMap<String,Integer> users=new HashMap<>();   // users and their count of reviews
		HashMap<String,Integer> movieyear= new HashMap<>(); // movie and their year
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println(">>>Enter one of the following");
		System.out.println(">New User: new");
		System.out.println(">Exisisting User: user");
		System.out.println(">Average Review of Movie: avg");
		System.out.println(">Avergae Review of an year: year");
		System.out.println(">Top n Movies: top n");
		System.out.println(">Quit");
		
		    
		while(true)
		{
		    
		    System.out.println();
		    System.out.println(">>ENTER");
		    String in=sc.nextLine();
		    
		    
		    //new user
		    if(in.equals("new"))
		    {
		    	// Taking details
		        System.out.println(">>Enter your name");
		        String newuser=sc.nextLine();
		        users.put(newuser,1);
		        System.out.println(">>Hello "+newuser+"..!\n>>>>Enter the movie name, year and review score");
		        String mvname=sc.nextLine();
		        int year=sc.nextInt();
		        int score=sc.nextInt();
		        String extra=sc.nextLine();		//buffer
		        
		        //checking year
		        if(year>2020)
		        {
		     		System.out.println(">>Non released movies cannot be reviewed");
		     		continue;
		     	}
		     	
		     	
		        // adding review and movie name to the internal database
		        float p=score;
		        if(movies.containsKey(mvname))
		        {
		            int num=movies.get(mvname);
		            float k=((float)rev.get(mvname)*num)+(float)score;
		            k=k/(num+1);
		            movies.put(mvname,num+1);
		            rev.put(mvname,k);
		        }
		        else
		        {
		            movies.put(mvname,1);
		            rev.put(mvname,p);
		            
		        }
		        movieyear.put(mvname,year);
		        
		    }
		    else if(in.equals("user"))  //exisiting user
		    {
		    
		    	// Taking details
		    	System.out.println(">>Enter your name");
		        String exisuser=sc.nextLine();
		        
		        if(!users.containsKey(exisuser))
		        {
		        	System.out.println(">>You are not an exisisting user, please use new option and give review");
		        	continue;
		        }
		        
		        
		        System.out.println(">>Hello "+exisuser+"..!\n>>>>Enter the movie name, year and review score");
		        String mvname=sc.nextLine();
		        int year=sc.nextInt();
		        int score=sc.nextInt();
		        String extra=sc.nextLine();	//buffer
		        
		        
		        //checking year
		        if(year>2020)
		        {
		     		System.out.println(">>Non released movies cannot be reviewed");
		     		continue;
		     	}
		        
		        users.put(exisuser,users.get(exisuser)+1);
		        if(users.get(exisuser)==3)
		        {
		            System.out.println(">>You have been promoted to Critic now since you have published 3 reviews");
		        }
		        
		        // adding review and movie name to the internal database
		        if(users.get(exisuser)>3)
		        score=2*score;
		        
		        
		        float p=score;
		        if(movies.containsKey(mvname))
		        {
		            int num=movies.get(mvname);
		            float k=((float)rev.get(mvname)*num)+(float)score;
		            k=k/(num+1);
		            movies.put(mvname,num+1);
		            rev.put(mvname,k);
		        }
		        else
		        {
		            movies.put(mvname,1);
		            rev.put(mvname,p);
		            
		        }
		        movieyear.put(mvname,year);
		    
		    }
		    else if(in.equals("avg"))		// average  review of movie
		    {
		        String mvname=sc.nextLine();
		        if(movies.containsKey(mvname))
		        {
		            System.out.print(">>Movie Review ");
		            System.out.println(rev.get(mvname));
		            
		        }
		        else
		        {
		            System.out.println(">>Sorry, this movie has no review");
		        }
		    }
		    else if(in.equals("year"))		// average by year
		    {
		    	int year=sc.nextInt();
		    	String extra=sc.nextLine(); 	//buffer
		    	if(movieyear.containsValue(year))
		    	{
		    		float avg=rev.get(getKey(movieyear,year));
		    		System.out.println(">>Average of that year is "+avg);
		    	}
		    	else
		    	{
		    	System.out.println(">>No movies in that year");
		    	}
		    	
		    }
		    else if(in.equals("top n"))
		    {
		    
		    	// to sort the hashmap based on reviews
		    	
		    	
		    	Map<String,Float> x=sortByValue(rev);
		        int count=0;
		        System.out.println("Give the value of n");
		        int n=sc.nextInt();
		        for (Map.Entry<String, Float> en : x.entrySet()) 
		        {
		            	if(count==n)
		            	break;
                		System.out.println(">>Movie = " + en.getKey() + ", Review = " + en.getValue());
                		count+=1;
                          
		        }
		        String extra=sc.nextLine(); 	//buffer
		        
		    }
		    else if(in.equals("Quit"))
		    {
		    	System.out.println("\n*************** DATA just to show you **************\n");
		        System.out.println(users);
		        System.out.println(movies);
		        System.out.println(rev);
		        System.out.println(movieyear);
		        break;
		    }
		    else
		    {
		        System.out.println(">>Check properly and choose from the options");
		    }
		    
		}
		System.out.println("******** THANK YOU ********");
		
		
	}
}


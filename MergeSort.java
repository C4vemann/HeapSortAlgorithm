import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;

class AssignmentA3_1{
	
	class Person{
		String name;
		Integer length;

		Person(String s){
			name = s;
			length = s.length();
		}
	}

	private List<Person> list = new ArrayList<Person>();
	public boolean isRunning = false; 

    public AssignmentA3_1(String fileName){
    	File file = new File(fileName);

    	try{
    		isRunning = true;
    		Scanner scan = new Scanner(file);
    		while(scan.hasNext()){
    			list.add(new Person(scan.nextLine()));
    		}
    		mergesort(list);
    	} catch(FileNotFoundException e){
    		isRunning = false;
    		System.out.println("File Not Found: Please enter a valid file name");
    		System.out.println("Exiting...");
    	}

    }

	private List<Person> mergesort(List<Person> a){
		int aLen = a.size();
		List<Person> b = a.subList(0,aLen/2);
		List<Person> c = a.subList(aLen/2,aLen);

		if(aLen == 1){
			return a;
		}

		b = mergesort(b);
		c = mergesort(c);

		return merge(b,c);
	}

	private List<Person> merge(List<Person> b, List<Person> c){
		int bLen = b.size();
		int bCount = 0;
		int cLen = c.size();
		int cCount = 0;

		List<Person> d = new ArrayList<Person>();
		int dCount = 0;

		while(bCount != bLen && cCount != cLen){
		 	if(b.get(bCount).length < c.get(cCount).length){
		 		d.add(b.get(bCount));
		 		bCount++;
			} else{
				d.add(c.get(cCount));
				cCount++;
			}
			dCount++;
		}

		while(bCount != bLen){
			d.add(b.get(bCount));
			bCount++;
			dCount++;
		}

		while(cCount != cLen){
			d.add(c.get(cCount));
			cCount++;
			dCount++;
		}

		return d;
	}

    public void printByNumChars(){
    	HashMap<Integer, List<String>> map = new HashMap<>();

    	for(Person p : list){
			if(map.get(p.length) == null){
	    		map.put(p.length, new ArrayList<String>());
	    		map.get(p.length).add(p.name);
	    	} else{
	    		map.get(p.length).add(p.name);
	    	}
	    }

	    System.out.println(map.toString());
    }

	public static void main(String[] args){
		AssignmentA3_1 a = new AssignmentA3_1(args[0]);
		if(a.isRunning){
			a.printByNumChars();
		}
	}
}
import java.util.Scanner;

// class 1
class Video{
	String videoName;
	boolean checkout = false;
	int rating;
	Video(String name){
		videoName = name;
	}
	String getName(){
		return videoName;
	}
	void doCheckout(){
		if(checkout==true){
			System.out.println("Video "+"\""+getName()+"\""+" checked out successfully");
		}
	}
	void doReturn(){
		if(checkout==false){
			System.out.println("Video "+"\""+getName()+"\""+" Returned successfully");
		}
	}
	int getRating(){
		return rating;
	}
	
} 


//class 2
class VideoStore {
	int i=0;
	Video[] store=new Video[10];
	void addVideo(String name){
		if(name!=null&&i<10){
			store[i] = new Video(name);
			//store[i].videoName = name;
			System.out.println("Video "+"\""+store[i].getName()+"\""+" added successfully");
			i++;
		}
		
	}
	void doCheckout(String name){
		for(int i=0;i<store.length-1;i++){
			if(store[i]!=null){
				if(store[i].getName().equals(name)){
					store[i].checkout=true;
					store[i].doCheckout();
				}
			}
		}
	}
	void doReturn(String name){
		for(int i=0;i<store.length-1;i++){
			if(store[i]!=null){
				if(store[i].getName().equals(name)){
					store[i].checkout=false;
					store[i].doReturn();
				}
			}
		}
	}
	void receiveRating(String name,int rating){
		for(int i=0;i<store.length-1;i++){
			if(store[i]!=null){
				if(store[i].getName().equals(name)){
					store[i].rating=rating;
					store[i].getRating();
					System.out.println("Rating "+"\""+store[i].rating+"\""+" has been mapped to the Video "+"\""+store[i].getName()+"\"");
				}
			}
		}
	}
	void listInventory(){
		for(int i=0;i<store.length-1;i++){
			if(store[i]!=null){
				System.out.println(store[i].getName()+"\t\t|\t "+store[i].checkout+" \t\t |\t "+store[i].rating +" ");
			}
		}
	}
}



//Main class
public class VideoStoreLauncher{

	public static void main(String[] args) {
		VideoStore v1 = new VideoStore();
		Scanner stringsc = new Scanner(System.in);
		Scanner intsc = new Scanner(System.in);
		int no;
		do{
			System.out.println("MAIN MENU");
			System.out.println("=========");
			System.out.print("1.Add Videos\n2.Check Out Video\n3.Return Video\n4.Receive Rating\n5.List Inventory\n6.Exit\n");
			System.out.print("Enter your choice(1..6): ");
			no = intsc.nextInt();
			switch(no){
			case 1:
				System.out.print("Enter the name of the video you want to add: ");
				String str = stringsc.nextLine();
				v1.addVideo(str);
				System.out.println();
				break;
			case 2:
				System.out.print("Enter the name of the video you want to checkout: ");
				str = stringsc.nextLine();
				v1.doCheckout(str);
				System.out.println();
				break;
			case 3:
				System.out.print("Enter the name of the video you want to Return: ");
				str = stringsc.nextLine();
				v1.doReturn(str);
				System.out.println();
				break;
			case 4:
				System.out.print("Enter the name of the video you want to Rate: ");
				str = stringsc.nextLine();
				System.out.print("Enter the Rating for this video: ");
				int rating = intsc.nextInt();
				v1.receiveRating(str,rating);
				System.out.println();
				break;
			case 5:
				System.out.println("--------------------------------------------------------");
				System.out.println("Video Name\t|\t Checkout Status |\t Rating ");
				v1.listInventory();
				System.out.println("--------------------------------------------------------");
				System.out.println();
				break;
			case 6:
				System.out.println("Exiting...!! Thanks for using the application.");
				System.exit(0);
			}
			
		}while(no!=6);
		
		stringsc.close();
		intsc.close();
	}

}

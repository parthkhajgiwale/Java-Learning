import java.util.ArrayList;
import java.util.Scanner;

class MemoryBlock{
	private int id;
	private int size;
	private boolean allocated;
	
	public MemoryBlock(int id,int size){
		this.id=id;
		this.size=size;
		this.allocated=false;
	}
	
	public int getID(){
		return id;
	}
	
	public int getSize(){
		return size;
	}
	
	public void allocate(){
		allocated=true;
	}
	
	public void deallocate(){
		allocated=false;
	}
	
	public boolean isAllocated(){
		return allocated;
	}
	
	@Override
	public String toString(){
		return "Block ID: " + id + " Size: " + size + "KB Allocated: " + (allocated? "Yes" : "No");
	}	
}

class MemoryManager{
	private ArrayList<MemoryBlock> memoryBlocks;
	
	public MemoryManager(){
		memoryBlocks = new ArrayList<>();
	}
	
	public void addmemoryBlock(int id, int size){
		MemoryBlock block = new MemoryBlock(id,size);
		memoryBlocks.add(block);
	}
	
	public void deallocate(int blockid){
		for(MemoryBlock block : memoryBlocks){
			if(block.getID() == blockid){
				block.deallocate();
				System.out.println("BlockID: " + blockid + "deallocated");
				return;
			}
		}
	}
	
	public void displayStatus(){
		for(MemoryBlock block : memoryBlocks){
			System.out.println(block);
		}
		System.out.println();
	}
	
	public void FirstFit(int processSize){
		for(MemoryBlock block : memoryBlocks){
			if(!block.isAllocated() && block.getSize()>=processSize){
				block.allocate();
				System.out.println("Block ID: " + block.getID() + "KB is Allocated for Process Size: " + processSize + "KB");
			}
		}
		
	}
}
public class spos{
	public static void main(String[] args){
		MemoryManager memorymanager = new MemoryManager();
		Scanner scanner = new Scanner(System.in);
		while(true){
		System.out.println("Memory Allocation System");
		System.out.println("1. Add Memory Block");
		System.out.println("2. Display Memory Status");
		System.out.println("3. Allocate Using First Fit");
		System.out.println("4. Deallocate");
		System.out.println("5. Exit");
		System.out.print("Enter Choice: ");
		int choice = scanner.nextInt();
		switch(choice){
			case 1:
				System.out.print("Enter BlockID: ");
				int bid = scanner.nextInt();
				System.out.print("Enter Block Size: ");
				int bsize = scanner.nextInt();
				memorymanager.addmemoryBlock(bid,bsize);
				System.out.println("Memory Block Added");
				break;
				
			case 2:
				memorymanager.displayStatus();
				break;
			case 3:
				System.out.print("Enter Process Size: ");
				int processSize = scanner.nextInt();
				memorymanager.FirstFit(processSize);
				break;
			case 4:
				System.out.print("Enter Block ID: ");
				int blockid = scanner.nextInt();
				memorymanager.deallocate(blockid);
				break;
			case 5:
				 System.out.println("Exiting Memory Allocation System.");
                 scanner.close();
                 System.exit(0);

      default:
				 System.out.println("Invalid choice. Please try again.");
				
		}
		}
	}
}

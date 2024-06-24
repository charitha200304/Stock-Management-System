import java.util.*;
public class Demo{
	
	 static Scanner input=new Scanner(System.in);
	 static String DefaultUserName="charitha";
     static String DefaultPassword="6969";
     static String[][] supplier=new String[0][2];
     static String [] category=new String[0];
    static String [][] item=new String[0][6];
	
	

	
	
	public static void LoginPage(){
		Scanner input=new Scanner(System.in);
		
		   System.out.println("+----------------------------------------------------------------------+");
		System.out.println("|                              LOGIN PAGE                              |");
		System.out.println("+----------------------------------------------------------------------+\n");
		System.out.println();
		
		do{
			System.out.print("User Name : ");
			String username=input.next();
			
			if(username.equals (DefaultUserName)){
				
				do{
					System.out.println();
					System.out.print("Password : ");
					String password=input.next();
					
					if(password.equals (DefaultPassword)){
						return;
						}else{
							System.out.println("password is incorrect. Please try again!");
							System.out.println();
							}
					}while(true);
				
				}else{
					System.out.println("user name is invalid.please try again!");
					System.out.println();
					}
			}while(true);
			
		}
		
	public static void HomePage(){
		clearConsole();
	  System.out.println("\n+---------------------------------------------------------------------+");
		System.out.println("|               WELCOME TO IJSE STOCK MANAGEMENT SYSTEM               |");
		System.out.println("+---------------------------------------------------------------------+\n");
		System.out.println();
		
		System.out.print("[1] Change the Crendentials");
		System.out.println("\t[2] Supplier Manage");
		System.out.print("[3] stock Manage");
		System.out.println("\t\t[4] Log Out");
		System.out.println("[5] Exit the system");
		System.out.println();
		
		Scanner input=new Scanner(System.in);
		System.out.print("Enter an option to continue > ");
		int option=input.nextInt();
		
		switch (option){
			case 1:
				clearConsole();
				ChangeCredentials();
				break;
			case 2:
				clearConsole();
				SupplierManage();
				break;
			case 3:
				
				clearConsole();
				StockManage();
				break;
			case 4:
				clearConsole();
				LoginPage();
				clearConsole();
				HomePage();
				break;
			case 5:
				clearConsole();
				return;
			default:
				System.out.println("Invalid option.please try again!");
				clearConsole();
				HomePage();
				break;
			}
		
	}
	
	public static void ChangeCredentials(){
		
		System.out.println("\n+---------------------------------------------------------------------+");
		System.out.println("|                          CREDENTIAL MANAGE                          |");
		System.out.println("+---------------------------------------------------------------------+\n");
		System.out.println();
		
		String currentUserName;
		String currentPassword;
		
		do{
			
			System.out.print("Please enter the user name to verify it's you: ");
			currentUserName=input.next();
			
			if(!currentUserName.equals(DefaultUserName)){
				System.out.println("invlid user name.try again!");
				System.out.println();
				}
			}while(!currentUserName.equals(DefaultUserName));
			System.out.println("Hey "+DefaultUserName);
			
			do{
				
				System.out.print("Enter your current password: ");
				currentPassword=input.next();
				
				if(!currentPassword.equals(DefaultPassword)){
					System.out.println("incorrect password.try again!");
					System.out.println();
					}
				}while(!currentPassword.equals(DefaultPassword));
				System.out.print("Enter your new password: ");
				String newPassword=input.next();
				DefaultPassword=newPassword;
				System.out.println();
				System.out.print("Password changed succesfully!");
				System.out.print("Do you want to go home page (Y/N): ");
	
				
			char choice = input.next().charAt(0);
							switch(choice){
								case 'Y' | 'y' :
									HomePage();
									break;
								case 'N' | 'n' :
									LoginPage();
									break;
								default:
									System.out.print("invalid input! please enter 'Y' or 'N'\n");
								break;
								}
		}
		
	public static void SupplierManage(){
			clearConsole();
			System.out.println("\n+---------------------------------------------------------------------+");
		System.out.println("|                           SUPPLIER MANAGE                           |");
		System.out.println("+---------------------------------------------------------------------+\n");
			System.out.println();
			
			System.out.print("[1] Add Supplier");
			System.out.println("\t\t[2] Update Supplier");
			System.out.print("[3] Delete Supplier");
			System.out.println("\t\t[4] View Supplier");
			System.out.print("[5] Search Supplier");
			System.out.println("\t\t[6] Home Page");
			System.out.println();
			
			System.out.print("Enter an option to continue > ");
			int option=input.nextInt();
			
			switch (option){
				case 1:
				clearConsole();
				AddSupplier();
				break;
				
				case 2:
				clearConsole();
				UpdateSupplier();
				break;
				
				case 3:
				clearConsole();
				DeleteSupplier();
				break;
				
				case 4:
				clearConsole();
				ViewSupplier();
				break;
				
				case 5:
				clearConsole();
				SearchSupplier();
				break;
				
				case 6:
				HomePage();
				break;
				
				default:
				System.out.println("Invalid choice.Please try again!");
				SupplierManage();
				break;
				}
		}
		
	public static void AddSupplier(){
			System.out.println("\n+---------------------------------------------------------------------+");
		System.out.println("|                            ADD SUPPLIER                             |");
		System.out.println("+---------------------------------------------------------------------+\n");
			System.out.println();
			
			String id;
			boolean isDuplicate=false;
			
			do{
				System.out.print("Supplier ID : ");
				id=input.next();
				isDuplicate=isDuplicate(id);
				if(isDuplicate){
					System.out.println("already exists. try another id!");
					System.out.println();
					}
				}while(isDuplicate);
				
				System.out.print("Supplier Name :");
				String name=input.next();
				
				GrowSupplier();
				supplier[supplier.length-1][0]=id;
				supplier[supplier.length-1][1]=name;
				System.out.println();
				System.out.print("added successfully!");
				System.out.print("Do you want to add another supplier(Y/N)?");
				char choice = input.next().charAt(0);
						System.out.println();
							switch(choice){
								case 'Y' | 'y' :
									clearConsole();
									AddSupplier();
									break;
								case 'N' | 'n' :
									SupplierManage();
									break;
								default:
									System.out.println("invalid input! pleace enter 'Y' or 'N'");
									break;
					}
			
		}
		
		public static void GrowSupplier(){
			String[][] temp=new String [supplier.length+1][2];
			for(int i=0;i<supplier.length;i++){
				temp[i][0]=supplier[i][0];
				temp[i][1]=supplier[i][1];
				}
				supplier=temp;
			}
		
	public static boolean isDuplicate(String id){
		for(int i=0;i<supplier.length;i++){
			if(supplier[i][0].equals(id)){
				return true;
				}
			}
			return false;
		}
		
	
	
	public static void UpdateSupplier(){
			clearConsole();
			System.out.println("\n+---------------------------------------------------------------------+");
		System.out.println("|                           UPDATE SUPPLIER                           |");
		System.out.println("+---------------------------------------------------------------------+\n");
			System.out.println();
			
			while(true){
				System.out.print("Supplier ID :");
				String supplierId=input.next();
			
				int supplierIndex=findSupplierIndex(supplierId);
				if(supplierIndex==-1){
					System.out.println("can't find supplier id.try again!");
					continue;
					}
				String currentSupplierName=supplier[supplierIndex][1];
				System.out.println("Supplier name :"+currentSupplierName);
				System.out.println();
			
				System.out.print("Enter the new supplier name :");
				String newSupplierName=input.next();
			
				supplier[supplierIndex][1]=newSupplierName;
				System.out.print("Update successfully!");
				System.out.print("Do you want to update another supplier(Y/N)?");
			
						char choice = input.next().charAt(0);
						System.out.println();
							switch(choice){
								case 'Y' | 'y' :
									clearConsole();
									UpdateSupplier();
									break;
								case 'N' | 'n' :
									SupplierManage();
									break;
								default:
									System.out.println("invalid input! pleace enter 'Y' or 'N'");
								break;
							}
						
				}
			}
		
	public static int findSupplierIndex(String id){
		for(int i=0;i<supplier.length;i++){
			if(supplier[i][0].equals(id)){
				return i;
				}
			}
			return -1;
		}
		
	public static void DeleteSupplier(){
  Scanner input = new Scanner(System.in);
  clearConsole();
 
  System.out.println("\n+---------------------------------------------------------------------+");
		System.out.println("|                           DELETE SUPPLIER                           |");
		System.out.println("+---------------------------------------------------------------------+\n");
  
  while (true) {
        System.out.print("Supplier ID     : ");
        String id = input.next();
     
            boolean have=true;
             for(int i=0; i<supplier.length;i++){
                 if(supplier[i][0].equals(id)){
                    have=false;
                     
        for(int j=i; j<supplier.length-1;j++){
            supplier[j]=supplier[j+1];
        }
             String[][] temp = new String[supplier.length-1][2];
    
        for(int k=0;k<temp.length;k++){
            temp[k]=supplier[k];
        }
   
		supplier = temp;
		System.out.print("deleted successfuly! do you want to delete another?(Y/N)> ");
          char choice = input.next().charAt(0);
					switch(choice){
						case 'Y' | 'y' :
						DeleteSupplier();
							break;
						case 'N' | 'n' :
							SupplierManage();
							break;
						default:
							System.out.println("invalid input! pleace enter 'Y' or 'N'\n");
							break;
					}
			}
		}
  
            if(have){
                System.out.println("can't find supplier id. try again!");

				}
			}
  
		}
	
		
	public static void ViewSupplier(){
		
		System.out.println("+-------------------------------------------------------+");
		System.out.println("|\t\t\tVIEW SUPPLIER\t\t\t|");
		System.out.println("+-------------------------------------------------------+");
		System.out.println();
		
		System.out.println("+-----------------------------------------------+");
		System.out.println("|\tSUPPLIER ID\t|\tSUPPLIER NAME\t|");
		System.out.println("+-----------------------------------------------+");
		
		
		
		if(supplier.length==0){
			System.out.println("no suppliers to display!");
			}else{
				for(int i=0;i<supplier.length;i++){
					
					System.out.println("|\t"+supplier[i][0]+"\t\t|\t"+supplier[i][1]+"\t\t|");
					}
					System.out.println("+-----------------------------------------------+");
				}
				System.out.println();
				System.out.print("Do you want to go supplier manage page(Y/N)?");
				
				                char choice = input.next().charAt(0);
					switch(choice){
						case 'Y' | 'y' :
							SupplierManage();
							break;
						case 'N' | 'n' :
							System.exit(0);
							break;
						default:
							System.out.println("invalid input! pleace enter 'Y' or 'N'\n");
							break;
					}
				
		
		}
		
	public static void SearchSupplier(){
		System.out.println("\n+---------------------------------------------------------------------+");
		System.out.println("|                           SEARCH SUPPLIER                           |");
		System.out.println("+---------------------------------------------------------------------+\n");
		System.out.println();
		
		do{
			System.out.print("Supplier ID : ");
			String supplierId=input.next();
			int supplierIndex=findSupplierIndex(supplierId);
			if(supplierIndex==-1){
				System.out.println("can't find supplier id. try again! ");
				continue;
				}else{
					String supplierName=supplier[supplierIndex][1];
					System.out.println("Supplier name : "+supplierName);
					System.out.print("Added successfully!");
					System.out.print("Do you want to add another find(Y/N)?");
			
					char choice = input.next().charAt(0);
						System.out.println();
							switch(choice){
								case 'Y' | 'y' :
									clearConsole();
									SearchSupplier();
									break;
								case 'N' | 'n' :
									SupplierManage();
									break;
								default:
									System.out.println("invalid input! pleace enter 'Y' or 'N'");
								break;
								}
					}
			}while(true);
		}
		
	public static void StockManage(){
System.out.println("\n+---------------------------------------------------------------------+");
		System.out.println("|                           STOCK MANAGEMENT                          |");
		System.out.println("+---------------------------------------------------------------------+\n");
		System.out.println();
		
		System.out.print("[1] Manage Item Categories");
		System.out.println("\t\t[2] Add Item ");
		System.out.print("[3] Get Item Supplier wise ");
		System.out.println("\t\t[4] View Items ");
		System.out.print("[5] Rank Items Per Unit Price ");
		System.out.println("\t\t[6] Home page ");
		System.out.println();
		
		System.out.print("\nEnter an option to continue > ");
		int option =input.nextInt();
		
		switch (option){
			case 1:
			clearConsole();
			ManageItemCategories();
			break;
			
			case 2:
			clearConsole();
			AddItem();
			break;
			
			case 3:
			clearConsole();
			GetItemSupplierWise();
			break;
			
			case 4:
			clearConsole();
			ViewItems();
			break;
			
			case 5:
			clearConsole();
			RankItemsPerUnitPrice();
			break;
			
			case 6:
			clearConsole();
			HomePage();
			break;
			
			default:
			clearConsole();
			
			}
		}
		
	public static void ManageItemCategories(){
		clearConsole();
		System.out.println("\n+---------------------------------------------------------------------+");
		System.out.println("|                        MANAGE ITEM CATEGORY                         |");
		System.out.println("+---------------------------------------------------------------------+\n");
		System.out.println();
		
		System.out.print("[1] Add New Item Category ");
		System.out.println("\t\t[2] Delete Item Category ");
		System.out.print("[3] Update Item Category ");
		System.out.println("\t\t[4] Stock Management ");
		
		System.out.println();
		System.out.print("Enter an option to continue > ");
		int option=input.nextInt();
		
		switch (option){
			case 1:
			clearConsole();
			AddNewItemCategory();
			break;
			
			case 2:
			clearConsole();
			DeleteItemCategory();
			break;
			
			case 3:
			clearConsole();
			UpdateItemCategory();
			break;
			
			case 4:
			clearConsole();
			StockManage();
			break;
			
			default:
			clearConsole();
			System.out.println("Invalid option.Please try again!");
			}
		}
		
	public static void AddNewItemCategory(){
		clearConsole();
		System.out.println("\n+---------------------------------------------------------------------+");
		System.out.println("|                          ADD ITEM CATEGORY                          |");
		System.out.println("+---------------------------------------------------------------------+\n");
		System.out.println();
		
		L1:while(true){
		System.out.print("Enter the new item category \t:  ");
			String item = input.next();
			boolean flag = ScheckDuplicate(item);
            if(flag==true){
                System.out.println(" already exists. try another category !");
                continue L1;
            }else{
                GrowItemCategory();
                category[category.length-1]=item;
				System.out.println();
    
				System.out.print("added successfully! do you want to add another category(Y/N) ?   ");
				String repeat = input.next();
				char choice = input.next(). charAt(0);
				System.out.println();
					switch(choice){
						case 'Y' | 'y' :
							AddNewItemCategory();		
							break;
						case 'N' | 'n' :
							ManageItemCategories();		
							break;
						default:
							System.out.println("invalid input! pleace enter 'Y' or 'N'");
							break;
					}
				}
			}
		
		}
		
	public static boolean ScheckDuplicate(String item){
        for(int i=0; i< category.length ; i++){
            if(category[i].equals(item)){
                return true;
            }
        }
        return false;
    }
		
	public static void GrowItemCategory(){
		String temp[]=new String[category.length+1];
		for(int i=0;i<category.length;i++){
			temp[i]=category[i];
			}
			category=temp;
		}
		
	public static void DeleteItemCategory(){
		clearConsole();
		System.out.println("\n+---------------------------------------------------------------------+");
		System.out.println("|                        DELETE ITEM CATEGORY                         |");
		System.out.println("+---------------------------------------------------------------------+\n");
		System.out.println();
		
		while(true){
			System.out.print("Enter the item category : ");
			String item=input.next();
			boolean flag = checkDuplicate(item);
			
			if(flag==false){
				System.out.print("Can't find category item.try again! ");
				System.out.println();
				}else{
					for(int i=0; i<category.length;i++){
						if(category[i].equals(item)){
							String[] temp = new String[category.length-1];
    
							for(int k=0;k<temp.length;k++){
								temp[k]=category[k];
								}
   
							category = temp;
							System.out.print("deleted successfuly! do you want to delete another?(Y/N)> ");
							char choise= input.next().charAt(0);
							switch (choise){
								case 'Y' |'y':
									clearConsole();
									DeleteItemCategory();
							
								case 'N' | 'n':
									clearConsole();
									ManageItemCategories();
							
								default :
									System.out.println("Invalid choise.please try again!");
									break;
								}
							}
						}
					
					}
			}
		
		}
		
	public static boolean checkDuplicate(String item){
		for(int i=0;i<category.length;i++){
			if(category[i].equals(item)){
				return true;
				}
			}
			return false;
		}
		
	public static void UpdateItemCategory(){
		clearConsole();
		System.out.println("\n+--------------------------------------------------------------------------+");
		System.out.println("|                           UPDATE ITEM CATEGORY                           |");
		System.out.println("+--------------------------------------------------------------------------+\n");
		System.out.println();
		
		while(true){
			System.out.print("Enter the item category : ");
			String item=input.next();
			
			if(!checkDuplicate(item)){
				System.out.println("can't find item category.please try again!");
				System.out.println();
				
				}else{
					for(int i=0;i<category.length;i++){
						if(category[i].equals(item)){
							System.out.println();
							System.out.print("Enter the new category item : ");
							String newItem=input.next();
							category[i]=newItem;
							System.out.print("Update successfully! Do you want to update another category(Y/N)?");
							
							char choise =input.next().charAt(0);
							switch (choise){
								case 'Y' |'y':
									clearConsole();
									UpdateItemCategory();
							
								case 'N' | 'n':
									clearConsole();
									ManageItemCategories();
							
								default :
									System.out.println("Invalid choise.please try again!");
								break;
								}
							}
						}
					}
			}
		}
		
	
	public static void AddItem(){
		clearConsole();
	System.out.println("\n+---------------------------------------------------------------------+");
		System.out.println("|                               ADD ITEM                              |");
		System.out.println("+---------------------------------------------------------------------+\n");
		System.out.println();
		
		if(category.length<1){
			
			L1:while(true){
				System.out.println("OOPS! It seems that you don't have any item categories in the system.");
				System.out.print("Do you want to add a new item category?(Y/N) >");
				char choice = input.next().charAt(0);
					System.out.println();
					
					switch(choice){
						case 'Y' | 'y' :
							AddNewItemCategory();
							break;
						case 'N' | 'n' :
							StockManage();
							break;
						default:
							System.out.println("invalid input! pleace enter 'Y' or 'N'");
							break;
					}
					}
			}
			
			if(supplier.length<1){
			
			L1:while(true){
				System.out.println("OOPS! It seems that you don't have any suppliers in the system.");
				System.out.print("Do you want to add a new supplier?(Y/N) >");
				char choice = input.next().charAt(0);
					System.out.println();
					
					switch(choice){
						case 'Y' | 'y' :
							AddSupplier();
							break;
						case 'N' | 'n' :
							StockManage();
							break;
						default:
							System.out.println("invalid input! pleace enter 'Y' or 'N'");
							break;
					}
					}
			}
			
			boolean flag=false;
			growItemArr();
			L5:while (flag!=true){
				System.out.print("Item Code : ");
				String itemCode=input.next();
				
				for(int i=0;i<item.length;i++){
					if(itemCode.equals(item[i][0])){
						System.out.println("Item code is already added.please try again! ");
						continue L5;
						}
					}
				if(flag==false){
					item[item.length-1][0]=itemCode;
					flag=true;
					System.out.println("Supplier List : ");
					supplierList();
					System.out.print("Enter the supplier number > ");
					int x=input.nextInt();
					item[item.length-1][1]=supplier[x-1][0];
					System.out.println();
					
					System.out.println("Item Categories: ");
					ItemCategories();
					
					System.out.print("Enter the category number > ");
					int cn=input.nextInt();
					item[item.length-1][2]=category[cn-1];
					System.out.print("Description : ");
					String description=input.next();
					item[item.length-1][3]=description;
					System.out.print("Unit price : ");
					String price=input.next();
					item[item.length-1][4]=price;
					System.out.print("Qty on hand : ");
					String qty=input.next();
					item[item.length-1][5]=qty;
					
					while(true){
						System.out.print("added successfully! Do you want to add another Item(Y/N)?");
						char choise=input.next().charAt(0);
						
						switch (choise){
							case 'Y' |'y':
							clearConsole();
							AddItem();
							
							case 'N' | 'n':
							clearConsole();
							StockManage();
							
							default :
							System.out.println("Invalid choise.please try again!");
							break;
							}
						}
					
					}
				}
		}
		
	public static void growItemArr(){
		String [][]temp=new String[item.length+1][6];
		for(int i=0; i< item.length; i++){
            for(int j=0; j< item[i].length; j++){
                temp[i][j] = item[i][j];
				}
			}
			item= temp;
		}
	
	
	public static void ItemCategories(){
		System.out.println("+----------+---------------------------------------------+");
		System.out.println("|    #     |               CATEGORY NAME                 |");
		System.out.println("+----------+---------------------------------------------+");
		for(int i=0;i<category.length;i++){
			System.out.println("|    "+(i+1)+"     |                  "+category[i]+"                       |");
			System.out.println("+----------+---------------------------------------------+");
			}
		}
		
	public static void supplierList(){
		System.out.println("+----------+---------------------------+----------------------------------------+");
		System.out.println("|    #     |       SUPPLIER ID         |            SUPPLIER NAME               |");
		System.out.println("+----------+---------------------------+----------------------------------------+");
			for(int i=0;i<supplier.length;i++){
				System.out.println("|    "+(i+1)+"     |         "+supplier[i][0]+"              |               "+supplier[i][1]+"                       |");
				System.out.println("+----------+---------------------------+----------------------------------------+");
			}
		}
		
		
	
		
	public static void GetItemSupplierWise(){
		clearConsole();
		System.out.println("\n+---------------------------------------------------------------------------------+");
		System.out.println("|                                   SEARCH SUPPLIER                               |");
		System.out.println("+---------------------------------------------------------------------------------+\n");
		System.out.println();
		
		System.out.print("Enter Supplier Id : ");
		String id=input.next();
		for(int i=0;i<supplier.length;i++){
			if(id.equals(supplier[i][0])){
				System.out.println("Supplier Name: " + supplier[i][1]);
				
				
				System.out.printf("+------------------------+------------------------+--------------------+--------------------+--------------------+%n");
				System.out.printf("|       ITEM CODE        |       DESCRIPTION      |     UNIT PRICE     |    QTY ON HAND     |      CATEGORY      |%n");
				System.out.printf("+------------------------+------------------------+--------------------+--------------------+--------------------+%n");
				for (int j=0; j < item.length; j++) {
					if (id.equals(item[j][1])) {
					System.out.printf("|      %-13s     |       %-12s     |      %-11s    |    %-11s     |   %-13s    |\n",item[j][0],item[j][3],item[j][4],item[j][5],item[j][2]);
						}
					}
				System.out.println("+------------------------+------------------------+--------------------+--------------------+--------------------+");
				System.out.println();
				
				while(true){
						System.out.print("Search successfully! Do you want to another search (Y/N)?");
						char choise=input.next().charAt(0);
						
						switch (choise){
							case 'Y' |'y':
							GetItemSupplierWise();
							AddItem();
							
							case 'N' | 'n':
							clearConsole();
							StockManage();
							
							default :
							System.out.println("Invalid choise.please try again!");
							break;
							}
						}
				}
			}
		
		}
		
	public static void ViewItems(){
		clearConsole();
		System.out.println("\n+---------------------------------------------------------------------------------+");
		System.out.println("|                                     VIEW ITEMS                                  |");
		System.out.println("+---------------------------------------------------------------------------------+\n");
		System.out.println();
		
		if(category.length==0){
			System.out.println("No items found,please try again !");
			clearConsole();
			ViewItems();
			}else{
				for(int i=0;i<category.length;i++){
					System.out.println(category[i]+":");
					System.out.printf("+------------------------+------------------------+--------------------+--------------------+--------------------+%n");
					System.out.printf("|          SID           |           CODE         |        DESC        |       PRICE        |         QTY        |%n");
					System.out.printf("+------------------------+------------------------+--------------------+--------------------+--------------------+%n");
					
					for(int j=0;j<item.length;j++){
						if(item[j][2]==category[i]){
							System.out.printf("|     %-15s|       %-14s|     %-13s|   %-12s|     %-13s|\n",item[j][0],item[j][1],item[j][3],item[j][4],item[j][5]);
							}
						}
						System.out.println("+------------------------+------------------------+--------------------+--------------------+--------------------+");
					}
				}
				while(true){
						System.out.print("Do you want to go back to stock management page? (Y/N): ");
						char choise=input.next().charAt(0);
						
						switch (choise){
							case 'Y' |'y':
							clearConsole();
							StockManage();
							
							case 'N' | 'n':
							clearConsole();
							HomePage();
							
							default :
							System.out.println("Invalid choise.please try again!");
							break;
							}
						}
		}
		
	
		
	public static void RankItemsPerUnitPrice(){
			System.out.println("\n+---------------------------------------------------------------------------------+");
		System.out.println("|                                  RANKED UNIT PRICE                              |");
		System.out.println("+---------------------------------------------------------------------------------+\n");
		System.out.println();
		
		 int []unitPrice = new int[item.length];
    
		for(int i=0;i<item.length;i++){
			int con = Integer.parseInt(item[i][4]);
			unitPrice[i]=con;
		}
		sort(unitPrice);

		System.out.printf("+-------------------------+-------------------------+-------------------------+-------------------------+-------------------------+-------------------------+%n");
		System.out.printf("| %14S %-8s | %14S %-8s | %14S %-8s | %14S %-8s | %14S %-8s | %14S %-8s |%n","sid"," ","code"," ","desc"," ","price"," ","qty"," ","cat"," ");
		System.out.printf("+-------------------------+-------------------------+-------------------------+-------------------------+-------------------------+-------------------------+%n");
			for (int j=0; j<item.length;j++){
				System.out.printf("| %-7s %-15s | %7s %-15s | %-7s %-15s | %15s %-7s | %-7s %-15s | %-7s %-15s |%n"," ",item[j][1]," ",item[j][0]," ",item[j][3],item[j][4],".00"," ",item[j][5]," ",item[j][2]);
				}
            System.out.printf("+-------------------------+-------------------------+-------------------------+-------------------------+-------------------------+-------------------------+%n");
            System.out.println();

		while(true){
			System.out.print("Do you want to go stock management page(Y/N)? ");
                char choice = input.next().charAt(0);
			switch(choice){
				case 'y' | 'Y' :
					clearConsole();
				StockManage();
					break;
				case 'N' | 'n' :
					clearConsole();
					HomePage();
					break;
				default:
					System.out.println("invalid input! pleace enter 'Y' or 'N'\n");
					break;
					}
				}
 
			}
 
	public static void sort(int[]unitPrice) {
		for(int j=0;j<item.length-1;j++){
			for(int i=0;i<item.length-1;i++){
       
				if(unitPrice[i]>unitPrice[i+1]){
					int temp=unitPrice[i];
					unitPrice[i]=unitPrice[i+1];
					unitPrice[i+1]=temp;

					String []temp1=item[i];
					item[i]=item[i+1];
					item[i+1]=temp1;
					}
				}
			}
		}
	
		public static void main(String args[]){
		
		LoginPage();
		clearConsole();
		HomePage();
		
		}
		
		private final static void clearConsole() {
	final String os = System.getProperty("os.name");
		try {
			if (os.equals("Linux")) {
			System.out.print("\033\143");
			} else if (os.equals("Windows")) {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
			System.out.print("\033[H\033[2J");
			System.out.flush();
			}
			} catch (final Exception e) {
			//handle the exception
			System.err.println(e.getMessage());
			}
		}
	}

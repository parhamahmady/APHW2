
import java.util.*;


/**
 * Library
 */
public class LibMang
{

    static ArrayList <Lib> myLibs=new ArrayList<Lib>();
     
    public static void main(final String[] args)
    {
        int i;
        Scanner fscan=new Scanner(System.in);
        while (true) {
            System.out.println("1)Add Library\n2)Remove library\n3)PrintAllLibraries");
            i=fscan.nextInt();
            switch (i) {
                case 1:
                    add_library();
                    break;
                case 2:
                    remove_library();
                    break;
                case 3:
                    printAllLibraries();
                    break;
            }
        }

        
    }
    public static void add_library()

    {
        Scanner fscan=new Scanner(System.in);
        System.out.println("enter the name:");
        String name=fscan.nextLine();
        System.out.println("enter the address");
        String address=fscan.nextLine();
        boolean pos_add=true;
        for (Lib templib : myLibs)//check if it was exist;
        {
            if (templib.equals(name,address)==true)
            {
                System.out.println("This library is already exist");
                pos_add=false;
            }    
            
        }
        if (pos_add)
        {
            myLibs.add(new Lib(name,address)); 
            System.out.println("added");
        }
    }

    public static void printAllLibraries()//print all libs;
    {
        System.out.print("\033[H\033[2J");//clear the terminal;
        for (Lib templib : myLibs)
        {
            templib.print();
        }    
    }

    public static void remove_library()
    {
        Scanner fscan=new Scanner(System.in);
        System.out.println("enter the name:");
        String name=fscan.nextLine();
        System.out.println("enter the address");
        String address=fscan.nextLine();
        int i=0;
        boolean pos_rem=false;
        for (Lib templib : myLibs) 
        {
            if (templib.equals(name, address)==true)
            {
                pos_rem=true;
                break;
            }    
            i++;
        }
        if (pos_rem) 
        {
            myLibs.remove(i);    
        }    
        
    }
}


class Lib
{
    static ArrayList <Book> books=new ArrayList<Book>();
    static ArrayList <User> users=new ArrayList<User>();
    private String name;
    private String address;
    public Lib(String name,String address)
    {
     this.name=name;
     this.address=address;   
    }
    public boolean equals(String na,String add) ///check if it was existed
    {
        if (name.equals(na) && address.equals(add))
        {
            // System.out.println("This library is already exist");
            return true;    
        }
        return false;    
    }

    static public void add_user() 
    {
       Scanner fscan=new Scanner(System.in);
       System.out.println("enter firstname");
       String firstname=fscan.nextLine();
       System.out.println("enter lastname");
       String lastname=fscan.nextLine();
       System.out.println("enter idNum");
       String id=fscan.nextLine();
       boolean pos_add=true;
       for (User tempuser : users)
        {
            if (tempuser.equals(id)==true)
            {
                pos_add=false;    
            }
        }
        if (pos_add)
        {
            users.add(new User(firstname,lastname,id));
            System.out.println("added");    
            return;
        }
        System.out.println("This user is already exist");
    }

    public static void print_users()
    {
        System.out.print("\033[H\033[2J");//clear the terminal;
        for (User tempuser : users)
        {
            tempuser.print();    
        }    
    }

    public static void remove_user()//first enter the id of the user then search for the index of that user then check if it is browwer
                                    // of not then remove it;
    {
        Scanner fscan=new Scanner(System.in);
        System.out.println("enter the id of user ");
        String id=fscan.nextLine();
        boolean pos_rem=false;
        int i=0;
        for (User tempuser : users)
        {
            if (tempuser.equals(id)==true)
            {
                if (tempuser.borrower==true)
                {
                    System.out.println("That user is a borrower do you want to delete?(Yes=1 , No=0)");
                    if(fscan.nextInt()==0)
                    {
                        return;
                    }    
                }
                pos_rem=true;
                break;
                
            }   
            i++; 
        }
        if (pos_rem)
        {
            users.remove(i);  
            return;  
        }
        System.out.println("No such user in this Lib");
    }

    public void print()
    {
        System.out.println("LibName:"+name+" | "+"LibAddress:"+address);    
    }

    public static void print_books()
    {
        System.out.print("\033[H\033[2J");//clear the terminal;
        for (Book tempbook : books)
        {
            tempbook.print();    
        }    
    }

    static public void add_book() 
    {
       Scanner fscan=new Scanner(System.in);
       System.out.println("enter title:");
       String title=fscan.nextLine();
       System.out.println("enter author:");
       String author=fscan.nextLine();
       boolean pos_add=true;
       for (Book tempbook : books)
        {
            if (tempbook.equals(title,author)==true)
            {
                pos_add=false;    
            }
        }
        if (pos_add)
        {
            books.add(new Book(title,author));
            System.out.println("added");    
            return;
        }
        System.out.println("This Book is already exist");
    }

    public static void remove_book()
    {
        Scanner fscan=new Scanner(System.in);
        System.out.println("enter title:");
        String title=fscan.nextLine();
        System.out.println("enter author:");
        String author=fscan.nextLine();
        boolean pos_rem=false;
        int i=0;
        for (Book tempbook : books)
        {
            if (tempbook.equals(title,author)==true)
            {
                pos_rem=true;
                break;
            }   
            i++; 
        }
        if (pos_rem)
        {
            books.remove(i);    
            return;
        }
        System.out.println("No such book in lib");
    }

    public static void main(String[] args)
    {
        int i;
        Scanner fscan=new Scanner(System.in);
        while (true)
        {
            System.out.println("1)addUseer\n2)removeUser\n3)addBook\n4)removeBook\n");
            i=fscan.nextInt();
            switch (i) {
                case 1:
                    add_user();
                    break;
                case 2:
                    remove_user();
                    break;
                case 3:
                    add_book();
                    break;
                case 4:
                    remove_book();
                    break;
            }
        }
    }
}

class Book
{
    String title;
    String author;
    public Book(final String ti,final String au)
    {
        title=ti;
        author=au;
    }
    public boolean equals (final String na,String au)//check if it was existed before;
    {
        if (title.equals(na) && au.equals(author)) 
        {
            
            return true;    
        }
        return false;
    }
    public void print()
    {
     System.out.println("Title:"+title+" | "+ "Author:"+author); 
    }
    
}

/**
 * User
 */
class User 

{
    private String firstname;
    private String lastname;
    private String idNum=new String(new char[10]);
     boolean borrower=false;
    public User(final String fn,final String ln,final String id)//counstructor;
    {
        firstname=fn;
        lastname=ln;
        idNum=id;
    }
    /////////////////Setters
    public void fistname_setter(String fn)
    {
     firstname=fn;   
    }
    public void lastname_setter(String ln)
    {
     lastname=ln;   
    }
    public void id_setter(String id)
    {
     idNum=id;   
    }
    /////////////////Getters 
    public String firstname_get()
    {
     return firstname;   
    }
    public String lastname_get()
    {
     return lastname;   
    }
    public String id_get()
    {
     return idNum;   
    }
    //////check if the user was existed before ;    
    public boolean equals(String id)
    {
        System.out.println(idNum);
        if (idNum.equals(id))
            {
                return true;
            }   
            return false;
    }
    //////////////////printer 
    public void print() 
    {
        System.out.println("Fullname: "+firstname+" "+lastname+" | "+ "ID: "+idNum);    
    }
}


class Borrow 
{
    User borrower;
    Book book;
    Date issuedDate;
    Date deadlineDate;
    public Borrow (User borrower,Book book ,Date issuedDate,Date deadlineDate)
    {
        this.borrower=borrower;
        this.book=book;
        this.issuedDate=issuedDate;
        this.deadlineDate=deadlineDate;
    }
    public Book get_book()
    {
        return book;    
    }
    public User get_borrower()
    {
        return borrower;    
    }
    public Date get_issuedDate()
    {
        return issuedDate;    
    }
    public Date get_deadlineDate()
    {
        return deadlineDate;    
    }
    public void set_book(Book book)
    {
        this.book=book;
    }
    public void set_borrower(User borrower)
    {
        this.borrower=borrower;    
    }
    public void set_issuedDate(Date issuedDate) 
    {
        this.issuedDate=issuedDate;    
    }
    public void set_deadlineDate(Date deadlineDate)
    {
        if(deadlineDate.before(issuedDate))//check if the deadlineDate was before issuedDate;
        {
            System.out.println("Please enter a suitable Date");
            return;
        }
        this.deadlineDate=deadlineDate;
    }
    // public void print() {
        
    // }
    
}
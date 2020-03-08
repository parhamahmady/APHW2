
import java.util.*;

import jdk.nashorn.internal.ir.ReturnNode;


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
    static ArrayList <Borrow> borrows=new ArrayList<Borrow>();
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

    public static void borrow_book()
    {
        Scanner fscan=new Scanner(System.in);
        boolean id_check=false;//to check the id ;
        boolean book_chek=false;//to check the book;
        Date currentDate=new Date();
        int year,month,day;
        System.out.println("enter your id:");    
        String id=fscan.nextLine();
        for (User temp : users) // check the entered id to check if it wasnt exited;
        {
            String temp_id=temp.id_get();
            if (temp_id.equals(id))
            {
                id_check=true;
                break;    
            }    
        }
        if (!id_check)
        {
            System.out.println("No such that id");
            return;    
        }
        System.out.println("enter the title of the book you want");
        String book_name=fscan.nextLine();
        System.out.println("enter the author of the book you want");
        String book_author=fscan.nextLine();
        for (Book temp : books) //check if there wasnt such that book
        {
            if (temp.equals(book_name,book_author)==true)
            {
                book_chek=true;
                break;    
            }   
        }
        if (!book_chek)
        {
            System.out.println("there isnt such that book");    
        }
        System.out.println("enter the deadlin : year month day");
        year=fscan.nextInt();
        month=fscan.nextInt();
        day=fscan.nextInt();
        Date deadlineDate=new Date(year-1900, month-1, day);
        if (deadlineDate.before(currentDate)) //check if the deadline was before current time;
        {
            System.out.println("Please enter a suitable Date");
            return;   
        }
        
        //////////////////
        for (User temp : users)//count to reach the user who wants to borrow;
        {
            if (temp.equals(id))
            {  
                temp.borrower=true;
                int i=0;
                for (Book tempBook : books) 
                {   
                    if (tempBook.equals(book_name,book_author))
                    {
                        borrows.add(new Borrow(temp,tempBook,currentDate,deadlineDate));    
                        books.remove(i);
                        System.out.println("borrowed");
                        return;
                    }   
                    i++;
                }  
            }    
        }
       
    }

    public static void borrow_back()
    {
        Scanner fscan=new Scanner(System.in);
        String id;
        int i=0;
        int checker=0;
        Borrow borrower;
        boolean id_check=false;//to check the id ;
        System.out.println("please enter your id:");    
        id=fscan.nextLine();
        for (Borrow temp : borrows)//check if the id wasnt exist in borrowers; and also find out the index of borrower in borrowers list
        {
            if (temp.borrower.equals(id))
            {
                id_check=true;
                break;    
            }
            i++;    
        }
        if (!id_check)
        {
            System.out.println("There isnt such that user in borrowers list");
            return;
        }
        borrower=borrows.get(i);
        System.out.println("Do you want to borrowback this Book?(Yes=1,No=0)");//make sure user whant to borrow back
        borrower.book.print();
        checker=fscan.nextInt();
        if (checker==0)
        {
            return;    
        }
        borrows.remove(i);
        books.add(borrower.get_book());
        System.out.println("Borrowed Back");
    }
    
    public static void print_past_deadline()
    {
        boolean check_deadline=false;//check if the wasnt passed deadline (for suitable message);
        if (borrows.isEmpty())
        {
            System.out.println("there  no borrowers ");    
            return;
        }
        for (Borrow temp: borrows)
        {
            Date deadlineDate,currentDate;
            deadlineDate=temp.get_deadlineDate();
            currentDate=new Date();
            if (deadlineDate.before(currentDate))
            {
                check_deadline=true;
                temp.print();
            }   
        }    
        if (!check_deadline) 
        {
            System.out.println("There No Passed Deadline");    
        }
    }
    public static void main(String[] args)
    {
        int i;
        Scanner fscan=new Scanner(System.in);
        while (true)
        {
            System.out.println("1)addUseer\n2)removeUser\n3)addBook\n4)removeBook\n5)BorrowBook\n6)BorrowBack\n7)printPassedDeadlineBorrows");
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
                case 5: 
                    borrow_book();
                break;
                case 6:
                    borrow_back();
                    break;
                case 7:
                    print_past_deadline();
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
        // System.out.println(idNum);
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
    public void print() 
    {
        System.out.println("Borrower =>Full Name"+borrower.firstname_get()+borrower.lastname_get()+" | "+"ID:"
        + borrower.id_get());    
        System.out.printf("Book =>");
        book.print();
        System.out.println("IssuedDate =>"+issuedDate);
        System.out.println("Deadline =>"+deadlineDate);
        int hour= issuedDate.getHours()-deadlineDate.getHours();
        int day=issuedDate.getDay()-deadlineDate.getDay();
        int month=issuedDate.getMonth()-deadlineDate.getMonth();
        int year=issuedDate.getYear()-deadlineDate.getYear();
        System.out.println("Remaining =>"+"/"+year+"/"+month+"/"+day+" : "+hour);
    }
    
}
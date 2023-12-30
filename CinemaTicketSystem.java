package com.mycompany.cinematicketsystem;
import java.util.*;
public class CinemaTicketSystem {
    static Scanner sc = new Scanner(System.in);
    static String [][] Movies ={
        {"'The Godfather'", "'Manila Kingpin'", "'Goodfellas'", "'The Departed'"},
        {"'Inception'", "'Interstellar'", "'The Matrix'", "'Blade Runner'"},
        {"'The Shawshank Redemption'", "'Forrest Gump'", "'Schindler's List'", "'The Green Mile'"},
        {"'The Dark Knight'", "'Avengers: Endgame'", "'Iron Man'", "'Guardians of the Galaxy'"}
    };
    static int choice(){
        int choice2 = 0;
        boolean choice = true;
        while(choice){
            choice2 = sc.nextInt();
        if(choice2 >= 1 && choice2 <= 4){
            choice = false;
    }else{
          System.out.println("Invalid choice, try again");
        }
    }
        return choice2;
    }
    
    static double twod = 250;
    static double threed = 400;
    static String visual(){
        String x = sc.nextLine();
        boolean x2 = true;
        while(x2){
            if(x.equalsIgnoreCase("2d")){
                System.out.println("That would be "+twod+" pesos.");
                break;
            }else if(x.equalsIgnoreCase("3d")){
                System.out.println("That would be "+threed+" pesos.");
                break;
            }else{
                System.out.println("Invalid choice");
                break;
        }
    }
        return x;
    }
    
    static double pay2d(){
        double x = sc.nextDouble();
        boolean x2 = true;
        while(x2){
            if(x > twod){
                System.out.println("I recieve " + x + " pesos");
                x2 = false;
            }else if(x == twod){
                System.out.println("I recieve " + x + " pesos");
                x2 = false;
            }else if(x < twod){
                System.out.println("You do not have enough money, come back again");
                x2 = false;
            }
        }
        return x;
    }
    static double pay3d(){
        double x = sc.nextDouble();
        boolean x2 = true;
        while(x2){
            if(x > threed){
                System.out.println("I recieve " + x + " pesos");
                x2 = false;
            }else if(x == threed){
                System.out.println("I recieve " + x + " pesos");
                x2 = false;
            }else if(x < threed){
                System.out.println("You do not have enough money, come back again");
                x2 = false;
            }
        }
        return x;
    }

    
    

    public static void main(String[] args) {
        System.out.println("Welcome to the Cinema!");
        System.out.println("Our films showing for today are: ");
        movielist();
    }
    
    public static void movielist(){
        System.out.println("=====================================================================================");
        for(int row = 0; row < Movies.length; row++){
            for(int col = 0; col < Movies[row].length; col++){              
                System.out.print(Movies[row][col]+"   ");
            }
            System.out.println();
            System.out.println("=====================================================================================");
        }
        System.out.println("Genre of movies from top row to bottom row:");
        System.out.println("Crime");
        System.out.print("");
        System.out.println("SciFi");
        System.out.println("Drama");
        System.out.println("Superhero");
        ticketbooth();
    }
    
    public static void ticketbooth(){
        System.out.println("Are you here to watch a movie?");
        boolean x = true;
        while(x){
        String yesno = sc.nextLine();
        if(yesno.equalsIgnoreCase("yes")){
            x = false;
            boolean cinema = true;
            while(cinema){
            System.out.println("What genre of movie would you like to watch?");
            String genre = sc.nextLine().toLowerCase();
            switch(genre){
                case "crime":
                    cinema = false;
                    boolean crime = true;
                    while(crime){
                    System.out.println("Select a movie based on its position on the column: ");
                    int choice2 = choice();
                    String wtf = sc.nextLine();
                    if(choice2 >= 1 && choice2 <= 4){
                        System.out.println("So you have chosen to watch " + Movies[0][choice2 - 1]);
                        boolean cvisual = true;
                        while(cvisual){
                        crime = false;
                        System.out.println("Would you like to watch it in 2D or 3D?");
                        String visual = visual();
                        if(visual.equalsIgnoreCase("2d")){
                            cvisual = false;
                            boolean p = true;
                            while(p){
                            System.out.println("Would you like to proceed with the payment?");
                            String yesno2 = sc.nextLine().toLowerCase();
                            switch(yesno2){
                                case "yes":
                                System.out.println("Proceeding to paymemt...");
                                payment2d();
                                cvisual = false;
                                p = false;
                                break;
                                case "no":
                                System.out.println("Would you like to pick a different movie or different quality?");
                                boolean change = true;
                                while(change){
                                String change2 = sc.nextLine();
                                if(change2.equalsIgnoreCase("different movie")){
                                    System.out.println("Same genre or different genre?");
                                    String change3 = sc.nextLine();
                                    if(change3.equalsIgnoreCase("same genre") || (change3.equalsIgnoreCase("same"))){
                                        p = false;
                                        change = false;
                                        cvisual = false;
                                        crime = true;
                                    }else if(change3.equalsIgnoreCase("different genre") || (change3.equalsIgnoreCase("different"))){
                                       p = false;
                                       change = false;
                                       cvisual = false;
                                       crime = false;
                                       cinema = true;
                                    }else{
                                        System.out.println("Invalid option, select same genre or different genre only");
                                    }
                                }else if(change2.equalsIgnoreCase("different quality")){
                                    p = false;
                                    change = false;
                                    cvisual = true;
                                }else if(change2.equalsIgnoreCase("different")){
                                    System.out.println("Different what?");                            
                                }else{
                                    System.out.println("Invalid option, select different movie or different quality only");
                                }
                                }
                                break;
                                default:
                                    System.out.println("Invalid response, answer with yes or no only");
                            }
                            }
                        }else if(visual.equalsIgnoreCase("3d")){
                            cvisual = false;
                            boolean p = true;
                            while(p){
                            System.out.println("Would you like to proceed with the payment?");
                            String yesno2 = sc.nextLine().toLowerCase();
                            switch(yesno2){
                                case "yes":
                                System.out.println("Proceeding to paymemt...");
                                payment3d();
                                cvisual = false;
                                p = false;
                                break;
                                case "no":
                                System.out.println("Would you like to pick a different movie or different quality?");
                                boolean change = true;
                                while(change){
                                String change2 = sc.nextLine();
                                if(change2.equalsIgnoreCase("different movie")){
                                    System.out.println("Same genre or different genre?");
                                    String change3 = sc.nextLine();
                                    if(change3.equalsIgnoreCase("same genre") || (change3.equalsIgnoreCase("same"))){
                                        p = false;
                                        change = false;
                                        cvisual = false;
                                        crime = true;
                                    }else if(change3.equalsIgnoreCase("different genre") || (change3.equalsIgnoreCase("different"))){
                                       p = false;
                                       change = false;
                                       cvisual = false;
                                       crime = false;
                                       cinema = true;
                                    }else{
                                        System.out.println("Invalid option, select same genre or different genre only");
                                    }
                                }else if(change2.equalsIgnoreCase("different quality")){
                                    p = false;
                                    change = false;
                                    cvisual = true;
                                }else if(change2.equalsIgnoreCase("different")){
                                    System.out.println("Different what?");                            
                                }else{
                                    System.out.println("Invalid option, select different movie or different quality only");
                                }
                                }
                                break;
                                default:
                                    System.out.println("Invalid response, answer with yes or no only");
                            }
                            }
                            }
                    }      
            }
        }
                    break;
                    case"scifi":
                    cinema = false;
                    boolean scifi = true;
                    while(scifi){
                    System.out.println("Select a movie based on its position on the column: ");
                    int choice2 = choice();
                    String wtf = sc.nextLine();
                    if(choice2 >= 1 && choice2 <= 4){
                        System.out.println("So you have chosen to watch " + Movies[1][choice2 - 1]);
                        boolean sfvisual = true;
                        while(sfvisual){
                        scifi = false;
                        System.out.println("Would you like to watch it in 2D or 3D?");
                        String visual = visual();
                        if(visual.equalsIgnoreCase("2d")){
                            sfvisual = false;
                            boolean p = true;
                            while(p){
                            System.out.println("Would you like to proceed with the payment?");
                            String yesno2 = sc.nextLine().toLowerCase();
                            switch(yesno2){
                                case "yes":
                                System.out.println("Proceeding to paymemt...");
                                payment2d();
                                sfvisual = false;
                                p = false;
                                break;
                                case "no":
                                System.out.println("Would you like to pick a different movie or different quality?");
                                boolean change = true;
                                while(change){
                                String change2 = sc.nextLine();
                                if(change2.equalsIgnoreCase("different movie")){
                                    System.out.println("Same genre or different genre?");
                                    String change3 = sc.nextLine();
                                    if(change3.equalsIgnoreCase("same genre") || (change3.equalsIgnoreCase("same"))){
                                        p = false;
                                        change = false;
                                        sfvisual = false;
                                        scifi = true;
                                    }else if(change3.equalsIgnoreCase("different genre") || (change3.equalsIgnoreCase("different"))){
                                       p = false;
                                       change = false;
                                       sfvisual = false;
                                       scifi = false;
                                       cinema = true;
                                    }else{
                                        System.out.println("Invalid option, select same genre or different genre only");
                                    }
                                }else if(change2.equalsIgnoreCase("different quality")){
                                    p = false;
                                    change = false;
                                    sfvisual = true;
                                }else if(change2.equalsIgnoreCase("different")){
                                    System.out.println("Different what?");                            
                                }else{
                                    System.out.println("Invalid option, select different movie or different quality only");
                                }
                                }
                                break;
                                default:
                                    System.out.println("Invalid response, answer with yes or no only");
                            }
                            }
                        }else if(visual.equalsIgnoreCase("3d")){
                            sfvisual = false;
                            boolean p = true;
                            while(p){
                            System.out.println("Would you like to proceed with the payment?");
                            String yesno2 = sc.nextLine().toLowerCase();
                            switch(yesno2){
                                case "yes":
                                System.out.println("Proceeding to paymemt...");
                                payment3d();
                                sfvisual = false;
                                p = false;
                                break;
                                case "no":
                                System.out.println("Would you like to pick a different movie or different quality?");
                                boolean change = true;
                                while(change){
                                String change2 = sc.nextLine();
                                if(change2.equalsIgnoreCase("different movie")){
                                    System.out.println("Same genre or different genre?");
                                    String change3 = sc.nextLine();
                                    if(change3.equalsIgnoreCase("same genre") || (change3.equalsIgnoreCase("same"))){
                                        p = false;
                                        change = false;
                                        sfvisual = false;
                                        scifi = true;
                                    }else if(change3.equalsIgnoreCase("different genre") || (change3.equalsIgnoreCase("different"))){
                                       p = false;
                                       change = false;
                                       sfvisual = false;
                                       scifi = false;
                                       cinema = true;
                                    }else{
                                        System.out.println("Invalid option, select same genre or different genre only");
                                    }
                                }else if(change2.equalsIgnoreCase("different quality")){
                                    p = false;
                                    change = false;
                                    sfvisual = true;
                                }else if(change2.equalsIgnoreCase("different")){
                                    System.out.println("Different what?");                            
                                }else{
                                    System.out.println("Invalid option, select different movie or different quality only");
                                }
                                }
                                break;
                                default:
                                    System.out.println("Invalid response, answer with yes or no only");
                            }
                            }
                            }
                    }      
            }
    }
                    break;
                    case "drama":
                    cinema = false;
                    boolean drama = true;
                    while (drama) {
                        System.out.println("Select a movie based on its position on the column: ");
                        int choice2 = choice();
                        String wtf = sc.nextLine();
                        if (choice2 >= 1 && choice2 <= 4) {
                            System.out.println("So you have chosen to watch " + Movies[2][choice2 - 1]);
                            boolean dvisual = true;
                            while (dvisual) {
                                drama = false;
                                System.out.println("Would you like to watch it in 2D or 3D?");
                                String visual = visual();
                                if (visual.equalsIgnoreCase("2d")) {
                                    dvisual = false;
                                    boolean p = true;
                                    while (p) {
                                        System.out.println("Would you like to proceed with the payment?");
                                        String yesno2 = sc.nextLine().toLowerCase();
                                        switch (yesno2) {
                                            case "yes":
                                                System.out.println("Proceeding to payment...");
                                                payment2d();
                                                dvisual = false;
                                                p = false;
                                                break;
                                            case "no":
                                                System.out.println("Would you like to pick a different movie or different quality?");
                                                boolean change = true;
                                                while (change) {
                                                    String change2 = sc.nextLine();
                                                    if (change2.equalsIgnoreCase("different movie")) {
                                                        System.out.println("Same genre or different genre?");
                                                        String change3 = sc.nextLine();
                                                        if (change3.equalsIgnoreCase("same genre") || (change3.equalsIgnoreCase("same"))) {
                                                            p = false;
                                                            change = false;
                                                            dvisual = false;
                                                            drama = true;
                                                        } else if (change3.equalsIgnoreCase("different genre") || (change3.equalsIgnoreCase("different"))) {
                                                            p = false;
                                                            change = false;
                                                            dvisual = false;
                                                            drama = false;
                                                            cinema = true;
                                                        } else {
                                                            System.out.println("Invalid option, select same genre or different genre only");
                                                        }
                                                    } else if (change2.equalsIgnoreCase("different quality")) {
                                                        p = false;
                                                        change = false;
                                                        dvisual = true;
                                                    } else if (change2.equalsIgnoreCase("different")) {
                                                        System.out.println("Different what?");
                                                    } else {
                                                        System.out.println("Invalid option, select different movie or different quality only");
                                                    }
                                                }
                                                break;
                                            default:
                                                System.out.println("Invalid response, answer with yes or no only");
                                        }
                                    }
                                } else if (visual.equalsIgnoreCase("3d")) {
                                    dvisual = false;
                                    boolean p = true;
                                    while (p) {
                                        System.out.println("Would you like to proceed with the payment?");
                                        String yesno2 = sc.nextLine().toLowerCase();
                                        switch (yesno2) {
                                            case "yes":
                                                System.out.println("Proceeding to payment...");
                                                payment3d();
                                                dvisual = false;
                                                p = false;
                                                break;
                                            case "no":
                                                System.out.println("Would you like to pick a different movie or different quality?");
                                                boolean change = true;
                                                while (change) {
                                                    String change2 = sc.nextLine();
                                                    if (change2.equalsIgnoreCase("different movie")) {
                                                        System.out.println("Same genre or different genre?");
                                                        String change3 = sc.nextLine();
                                                        if (change3.equalsIgnoreCase("same genre") || (change3.equalsIgnoreCase("same"))) {
                                                            p = false;
                                                            change = false;
                                                            dvisual = false;
                                                            drama = true;
                                                        } else if (change3.equalsIgnoreCase("different genre") || (change3.equalsIgnoreCase("different"))) {
                                                            p = false;
                                                            change = false;
                                                            dvisual = false;
                                                            drama = false;
                                                            cinema = true;
                                                        } else {
                                                            System.out.println("Invalid option, select same genre or different genre only");
                                                        }
                                                    } else if (change2.equalsIgnoreCase("different quality")) {
                                                        p = false;
                                                        change = false;
                                                        dvisual = true;
                                                    } else if (change2.equalsIgnoreCase("different")) {
                                                        System.out.println("Different what?");
                                                    } else {
                                                        System.out.println("Invalid option, select different movie or different quality only");
                                                    }
                                                }
                                                break;
                                            default:
                                                System.out.println("Invalid response, answer with yes or no only");
                        }                                       
                    }
                }
            }
        }
    }
                    break;
                        case "superhero":
                        cinema = false;
                        boolean superheroes = true;
                        while (superheroes) {
                            System.out.println("Select a movie based on its position on the column: ");
                            int choice2 = choice();
                            String wtf = sc.nextLine();
                            if (choice2 >= 1 && choice2 <= 4) {
                                System.out.println("So you have chosen to watch " + Movies[3][choice2 - 1]);
                                boolean shvisual = true;
                                while (shvisual) {
                                    superheroes = false;
                                    System.out.println("Would you like to watch it in 2D or 3D?");
                                    String visual = visual();
                                    if (visual.equalsIgnoreCase("2d")) {
                                        shvisual = false;
                                        boolean p = true;
                                        while (p) {
                                            System.out.println("Would you like to proceed with the payment?");
                                            String yesno2 = sc.nextLine().toLowerCase();
                                            switch (yesno2) {
                                                case "yes":
                                                    System.out.println("Proceeding to payment...");
                                                    payment2d();
                                                    shvisual = false;
                                                    p = false;
                                                    break;
                                                case "no":
                                                    System.out.println("Would you like to pick a different movie or different quality?");
                                                    boolean change = true;
                                                    while (change) {
                                                        String change2 = sc.nextLine();
                                                        if (change2.equalsIgnoreCase("different movie")) {
                                                            System.out.println("Same genre or different genre?");
                                                            String change3 = sc.nextLine();
                                                            if (change3.equalsIgnoreCase("same genre") || (change3.equalsIgnoreCase("same"))) {
                                                                p = false;
                                                                change = false;
                                                                shvisual = false;
                                                                superheroes = true;
                                                            } else if (change3.equalsIgnoreCase("different genre") || (change3.equalsIgnoreCase("different"))) {
                                                                p = false;
                                                                change = false;
                                                                shvisual = false;
                                                                superheroes = false;
                                                                cinema = true;
                                                            } else {
                                                                System.out.println("Invalid option, select same genre or different genre only");
                                                            }
                                                        } else if (change2.equalsIgnoreCase("different quality")) {
                                                            p = false;
                                                            change = false;
                                                            shvisual = true;
                                                        } else if (change2.equalsIgnoreCase("different")) {
                                                            System.out.println("Different what?");
                                                        } else {
                                                            System.out.println("Invalid option, select different movie or different quality only");
                                                        }
                                                    }
                                                    break;
                                                default:
                                                    System.out.println("Invalid response, answer with yes or no only");
                                            }
                                        }
                                    } else if (visual.equalsIgnoreCase("3d")) {
                                        shvisual = false;
                                        boolean p = true;
                                        while (p) {
                                            System.out.println("Would you like to proceed with the payment?");
                                            String yesno2 = sc.nextLine().toLowerCase();
                                            switch (yesno2) {
                                                case "yes":
                                                    System.out.println("Proceeding to payment...");
                                                    payment3d();
                                                    shvisual = false;
                                                    p = false;
                                                    break;
                                                case "no":
                                                    System.out.println("Would you like to pick a different movie or different quality?");
                                                    boolean change = true;
                                                    while (change) {
                                                        String change2 = sc.nextLine();
                                                        if (change2.equalsIgnoreCase("different movie")) {
                                                            System.out.println("Same genre or different genre?");
                                                            String change3 = sc.nextLine();
                                                            if (change3.equalsIgnoreCase("same genre") || (change3.equalsIgnoreCase("same"))) {
                                                                p = false;
                                                                change = false;
                                                                shvisual = false;
                                                                superheroes = true;
                                                            } else if (change3.equalsIgnoreCase("different genre") || (change3.equalsIgnoreCase("different"))) {
                                                                p = false;
                                                                change = false;
                                                                shvisual = false;
                                                                superheroes = false;
                                                                cinema = true;
                                                            } else {
                                                                System.out.println("Invalid option, select same genre or different genre only");
                                                            }
                                                        } else if (change2.equalsIgnoreCase("different quality")) {
                                                            p = false;
                                                            change = false;
                                                            shvisual = true;
                                                        } else if (change2.equalsIgnoreCase("different")) {
                                                            System.out.println("Different what?");
                                                        } else {
                                                            System.out.println("Invalid option, select different movie or different quality only");
                                                        }
                                                    }
                                                    break;
                                                default:
                                                    System.out.println("Invalid response, answer with yes or no only");
                        }
                    }
                }
            }
        }
    }
                        break;
                        
                        default:
                            System.out.println("Invalid choice");
}
        }
    }else if(yesno.equalsIgnoreCase("no")){
        System.out.println("What are you doing here then? Get out");
        break;
    }else{
        System.out.println("Just answer yes or no only please");
    }
    }
    }
    public static void payment2d(){
        boolean p = true;
        while(p){
        System.out.println("Please pay here: ");
        double pay = pay2d();
        double twodchange = pay - twod;
        if(pay > twod){
            System.out.println("Your change is "+twodchange+" pesos. Enjoy the movie!");
            break;
        }else if(pay == twod){
            System.out.println("Enjoy the movie!");
            break;
        }else{
        break;
    }
}
    }
    public static void payment3d(){
        boolean p = true;
        while(p){
        System.out.println("Please pay here: ");
        double pay = pay3d();
        double twodchange = pay - threed;
        if(pay > threed){
            System.out.println("Your change is "+twodchange+" pesos. Enjoy the movie!");
            break;
        }else if(pay == threed){
            System.out.println("Enjoy the movie!");
            break;
        }else{
        break;
    }
}
    }
}

import javax.swing.*;
import javax.swing.table.TableModel;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.io.*;


class Teams
{
    int TeamID;
    String TeamName;
    int teamBudget;
    public Teams(int TeamID,String TeamName,int teamBudget)
    {
            this.TeamID=TeamID;
            this.TeamName=TeamName;
            this.teamBudget=teamBudget;
    }
    public void display()
    {
        System.out.println("Team Id ="+TeamID);
        System.out.println("Team Name ="+TeamName);
        System.out.println("Total Budget of Team ="+teamBudget);
    }
}

class Auction
{
    String date,time,place;
    public Auction()
    {
        date="10/7/2021";
        time="7:00pm";
        place="Indoor Stadium";
    }
    public void display()
    {
        System.out.println("Date ="+date);
        System.out.println("Time ="+time);
        System.out.println("Place for auction ="+place);
    }
}

class variables
{
    int totalBudget=70000;
    int teambudget1=70000;
    int teambudget2=70000;
    int teambudget3=70000;
    int teambudget4=70000;

    ArrayList<String> goalkeeper=new ArrayList<String>() ;
    ArrayList<String> defender=new ArrayList<String>() ;
    ArrayList<String> midfielder=new ArrayList<String>() ;
    ArrayList<String> forward=new ArrayList<String>() ;

    ArrayList<Integer> price1=new ArrayList<Integer>();

    ArrayList<String> al1=new ArrayList<String>();
    ArrayList<String> al2=new ArrayList<String>();
    ArrayList<String> al3=new ArrayList<String>();
    ArrayList<String> al4=new ArrayList<String>();
}

class Calculations
{
    public void calculate(int team_id[],String s[])
    {
        Scanner sc=new Scanner(System.in);

        variables varr=new variables();

        try
        {
            File file1 = new File("gk.txt");
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            String st1;
            while ((st1 = br1.readLine()) != null)
                varr.goalkeeper.add(st1);

            File file = new File("def.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null)
                varr.defender.add(st);

            File file2 = new File("mid.txt");
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            String st2;
            while ((st2 = br2.readLine()) != null)
                varr.midfielder.add(st2);

            File file3 = new File("str.txt");
            BufferedReader br3 = new BufferedReader(new FileReader(file3));
            String st3;
            while ((st3 = br3.readLine()) != null)
                varr.forward.add(st3);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        System.out.println("Bidding for Goalkeepers\n");
        int count=1;
        int low=4000;
        int high=6000;
        int diff=high-low;
        for(String x: varr.goalkeeper)
        {
            int e=randomgeerator(diff,low);
            System.out.println(count+" "+x+" - "+e);
            varr.price1.add(e);
            count++;
        }
        HashSet<Integer> hs=new HashSet<Integer>();
        boolean flag1=false,flag2=false,flag3=false,flag4=false;

        System.out.println("Enter 1 if u want to bid and any number if u want to randomly allocate player to team");
        int v2=sc.nextInt();
        if(v2==1)
        {
            for(int x=1;x<=4;x++)
            {
                System.out.println("\nEnter player on which u want to bid");
                int p=sc.nextInt();
                if(hs.contains(p))
                {
                    System.out.println(" This Player has already been alloten . Choose Another Player other than "+hs);
                    p=sc.nextInt();
                }

                hs.add(p);
                System.out.println(varr.goalkeeper.get(p-1)+" - Base Value - "+varr.price1.get(p-1));
                int index=-1;
                count=-1;
                int y=0;
                while(count!=1)
                {
                    count=0;
                    if(flag1==false)
                    {
                        if(index!=0) {
                            System.out.println("Team 1 wants to bid or not Y/N");
                            char ch = sc.next().charAt(0);
                            if (ch == 'Y')
                            {
                                count++;
                                System.out.println("Enter new bidding amount");
                                int z = sc.nextInt();
                                if (z >= varr.price1.get(p - 1))
                                {
                                    y = z;
                                    index = 0;
                                    varr.price1.set(p - 1, z);
                                }
                                else
                                {
                                    System.out.println("Value should be greater than the last bidding value");
                                }
                            }

                        }
                        else {
                            count++;
                        }
                    }

                    if(flag2==false)
                    {
                        if(index!=1)
                        {
                            System.out.println("Team 2 wants to bid or not Y/N");
                            char ch=sc.next().charAt(0);
                            if(ch=='Y')
                            {
                                count++;
                                System.out.println("Enter new bidding amount");
                                int z=sc.nextInt();
                                if(z>=varr.price1.get(p-1))
                                {
                                    y=z;
                                    index=1;
                                    varr.price1.set(p-1,z);
                                }
                                else
                                {
                                    System.out.println("Value should be greater than the last bidding value");
                                }
                            }

                        }
                        else
                        {
                            count++;
                        }

                    }

                    if(flag3==false)
                    {
                        if(index!=2) {
                            System.out.println("Team 3 wants to bid or not Y/N");
                            char ch = sc.next().charAt(0);
                            if (ch == 'Y') {
                                count++;
                                System.out.println("Enter new bidding amount");
                                int z = sc.nextInt();
                                if (z >= varr.price1.get(p - 1)) {
                                    y = z;
                                    index = 2;
                                    varr.price1.set(p - 1, z);
                                } else {
                                    System.out.println("Value should be greater than the last bidding value");
                                }
                            }

                        }
                        else
                        {
                            count++;
                        }
                    }

                    if(flag4==false)
                    {
                        if(index!=3)
                        {
                            System.out.println("Team 4 wants to bid or not Y/N");
                            char ch=sc.next().charAt(0);
                            if(ch=='Y')
                            {
                                count++;
                                System.out.println("Enter new bidding amount");
                                int z=sc.nextInt();
                                if(z>=varr.price1.get(p-1))
                                {
                                    y=z;
                                    index=3;
                                    varr.price1.set(p-1,z);
                                }
                                else
                                {
                                    System.out.println("Value should be greater than the last bidding value");

                                }
                            }

                        }
                        else
                        {
                            count++;
                        }

                    }

                }
                if(index==0)
                {
                    flag1=true;
                    varr.al1.add(varr.goalkeeper.get(p-1)+" - (G) ");
                    varr.teambudget1-=varr.price1.get(p-1);
                    System.out.println("Goalkeeper has been alloted to Team 1");
                }
                else if(index==1)
                {
                    flag2=true;
                    varr.al2.add(varr.goalkeeper.get(p-1)+" - (G) ");
                    varr.teambudget2-=varr.price1.get(p-1);
                    System.out.println("Goalkeeper has been alloted to Team 2");
                }
                else if(index==2)
                {
                    flag3=true;
                    varr.al3.add(varr.goalkeeper.get(p-1)+" - (G) ");
                    varr.teambudget3-=varr.price1.get(p-1);
                    System.out.println("Goalkeeper has been alloted to Team 3");
                }
                else if(index==3)
                {
                    flag4=true;
                    varr.al4.add(varr.goalkeeper.get(p-1)+" - (G) ");
                    varr.teambudget4-=varr.price1.get(p-1);
                    System.out.println("Goalkeeper has been alloted to Team 4");
                }

            }
        }
        else
        {
            int a=0,b=0,c=0,d=0;
            HashSet<Integer> hs1=new HashSet<Integer>();
            int max=4;
            int min=1;
            for(int x=1;x<=4;x++)
            {
                Random rand = new Random();
                int randomNum = rand.nextInt((max - min) + 1) + min;
                while(hs1.contains(randomNum))
                {
                    randomNum = rand.nextInt((max - min) + 1) + min;
                }
                hs1.add(randomNum);
                if(a<1)
                {
                    a++;
                    varr.al1.add(varr.goalkeeper.get(randomNum-1)+" - (G) ");
                    varr.teambudget1-=varr.price1.get(randomNum-1);
                }
                else if(b<1)
                {
                    b++;
                    varr.al2.add(varr.goalkeeper.get(randomNum-1)+" - (G) ");
                    varr.teambudget2-=varr.price1.get(randomNum-1);
                }
                else if(c<1)
                {
                    c++;
                    varr.al3.add(varr.goalkeeper.get(randomNum-1)+" - (G) ");
                    varr.teambudget3-=varr.price1.get(randomNum-1);
                }
                else
                {
                    d++;
                    varr.al4.add(varr.goalkeeper.get(randomNum-1)+" - (G) ");
                    varr.teambudget4-=varr.price1.get(randomNum-1);
                }
            }
        }


        System.out.println(varr.al1);
        System.out.println(varr.al2);
        System.out.println(varr.al3);
        System.out.println(varr.al4);
        System.out.println("Budget left for team 1 = "+varr.teambudget1);
        System.out.println("Budget left for team 2 = "+varr.teambudget2);
        System.out.println("Budget left for team 3 = "+varr.teambudget3);
        System.out.println("Budget left for team 4 = "+varr.teambudget4);

        hs.clear();
        varr.price1.clear();


        flag1=false;
        flag2=false;
        flag3=false;
        flag4=false;
        System.out.println();
        System.out.println("Bidding for Defenders\n");
        count=1;
        low=5000;
        high=7000;
        diff=high-low;
        for(String x: varr.defender)
        {
            int e=randomgeerator(diff,low);
            System.out.println(count+" "+x+" - "+e);
            varr.price1.add(e);
            count++;
        }

        int a=0,b=0,c=0,d=0;
        System.out.println("Enter 1 if u want to bid and any number if u want to randomly allocate player to team");
        int v=sc.nextInt();

        if(v==1)
        {
            for(int x=1;x<=8;x++)
            {
                System.out.println("\nEnter player on which u want to bid");
                int p=sc.nextInt();
                if(hs.contains(p))
                {
                    System.out.println(" This Player has already been alloten . Choose Another Player other than "+hs);
                    p=sc.nextInt();
                }

                hs.add(p);
                System.out.println(varr.goalkeeper.get(p-1)+" - Base Value - "+varr.price1.get(p-1));
                int index=-1;
                count=-1;
                int y=0;
                while(count!=1)
                {
                    count=0;
                    if(flag1==false)
                    {
                        if(index!=0) {
                            System.out.println("Team 1 wants to bid or not Y/N");
                            char ch = sc.next().charAt(0);
                            if (ch == 'Y')
                            {
                                count++;
                                System.out.println("Enter new bidding amount");
                                int z = sc.nextInt();
                                if (z >= varr.price1.get(p - 1))
                                {
                                    y = z;
                                    index = 0;
                                    varr.price1.set(p - 1, z);
                                }
                                else
                                {
                                    System.out.println("Value should be greater than the last bidding value");
                                }
                            }

                        }
                        else {
                            count++;
                        }
                    }

                    if(flag2==false)
                    {
                        if(index!=1)
                        {
                            System.out.println("Team 2 wants to bid or not Y/N");
                            char ch=sc.next().charAt(0);
                            if(ch=='Y')
                            {
                                count++;
                                System.out.println("Enter new bidding amount");
                                int z=sc.nextInt();
                                if(z>=varr.price1.get(p-1))
                                {
                                    y=z;
                                    index=1;
                                    varr.price1.set(p-1,z);
                                }
                                else
                                {
                                    System.out.println("Value should be greater than the last bidding value");
                                }
                            }

                        }
                        else
                        {
                            count++;
                        }

                    }

                    if(flag3==false)
                    {
                        if(index!=2) {
                            System.out.println("Team 3 wants to bid or not Y/N");
                            char ch = sc.next().charAt(0);
                            if (ch == 'Y') {
                                count++;
                                System.out.println("Enter new bidding amount");
                                int z = sc.nextInt();
                                if (z >= varr.price1.get(p - 1)) {
                                    y = z;
                                    index = 2;
                                    varr.price1.set(p - 1, z);
                                } else {
                                    System.out.println("Value should be greater than the last bidding value");
                                }
                            }

                        }
                        else
                        {
                            count++;
                        }
                    }

                    if(flag4==false)
                    {
                        if(index!=3)
                        {
                            System.out.println("Team 4 wants to bid or not Y/N");
                            char ch=sc.next().charAt(0);
                            if(ch=='Y')
                            {
                                count++;
                                System.out.println("Enter new bidding amount");
                                int z=sc.nextInt();
                                if(z>=varr.price1.get(p-1))
                                {
                                    y=z;
                                    index=3;
                                    varr.price1.set(p-1,z);
                                }
                                else
                                {
                                    System.out.println("Value should be greater than the last bidding value");

                                }
                            }

                        }
                        else
                        {
                            count++;
                        }

                    }

                }
                if(index==0)
                {
                    a++;
                    if(a==2)
                    {
                        flag1=true;
                    }

                    varr.al1.add(varr.defender.get(p-1)+" - (D) ");
                    varr.teambudget1-=varr.price1.get(p-1);
                    System.out.println("Defender has been alloted to Team 1");
                }
                else if(index==1)
                {
                    b++;
                    if(b==2)
                    {
                        flag2=true;
                    }

                    varr.al2.add(varr.defender.get(p-1)+" - (D) ");
                    varr.teambudget2-=varr.price1.get(p-1);
                    System.out.println("Defender has been alloted to Team 2");
                }
                else if(index==2)
                {
                    c++;
                    if(c==2)
                    {
                        flag3=true;
                    }

                    varr.al3.add(varr.defender.get(p-1)+" - (D) ");
                    varr.teambudget3-=varr.price1.get(p-1);
                    System.out.println("Defender has been alloted to Team 3");
                }
                else if(index==3)
                {
                    d++;
                    if(d==2)
                    {
                        flag4=true;
                    }
                    varr.al4.add(varr.defender.get(p-1)+" - (D) ");
                    varr.teambudget4-=varr.price1.get(p-1);
                    System.out.println("Defender has been alloted to Team 4");
                }

            }
        }
        else
        {
            a=0;
            b=0;
            c=0;
            d=0;
            HashSet<Integer> hs1=new HashSet<Integer>();
            int max=8;
            int min=1;
            for(int x=1;x<=8;x++)
            {
                Random rand = new Random();
                int randomNum = rand.nextInt((max - min) + 1) + min;
                while(hs1.contains(randomNum))
                {
                    randomNum = rand.nextInt((max - min) + 1) + min;
                }
                hs1.add(randomNum);
                if(a<2)
                {
                    a++;
                    varr.al1.add(varr.defender.get(randomNum-1)+" - (D) ");
                    varr.teambudget1-=varr.price1.get(randomNum-1);
                }
                else if(b<2)
                {
                    b++;
                    varr.al2.add(varr.defender.get(randomNum-1)+" - (D) ");
                    varr.teambudget2-=varr.price1.get(randomNum-1);
                }
                else if(c<2)
                {
                    c++;
                    varr.al3.add(varr.defender.get(randomNum-1)+" - (D) ");
                    varr.teambudget3-=varr.price1.get(randomNum-1);
                }
                else
                {
                    d++;
                    varr. al4.add(varr.defender.get(randomNum-1)+" - (D) ");
                    varr.teambudget4-=varr.price1.get(randomNum-1);
                }
            }

        }


        System.out.println(varr.al1);
        System.out.println(varr.al2);
        System.out.println(varr.al3);
        System.out.println(varr.al4);
        System.out.println("Budget left for team 1 = "+varr.teambudget1);
        System.out.println("Budget left for team 2 = "+varr.teambudget2);
        System.out.println("Budget left for team 3 = "+varr.teambudget3);
        System.out.println("Budget left for team 4 = "+varr.teambudget4);


        hs.clear();
        varr.price1.clear();


        flag1=false;
        flag2=false;
        flag3=false;
        flag4=false;
        System.out.println();
        System.out.println("Bidding for MidFielders\n");
        count=1;
        low=7000;
        high=9000;
        diff=high-low;
        for(String x: varr.midfielder)
        {
            int e=randomgeerator(diff,low);
            System.out.println(count+" "+x+" - "+e);
            varr. price1.add(e);
            count++;
        }

        a=0;
        b=0;
        c=0;
        d=0;
        System.out.println("Enter 1 if u want to bid and any number if u want to randomly allocate player to team");
        int v1=sc.nextInt();
        if(v1==1)
        {
            for(int x=1;x<=12;x++)
            {
                System.out.println("\nEnter player on which u want to bid");
                int p=sc.nextInt();
                if(hs.contains(p))
                {
                    System.out.println(" This Player has already been alloten . Choose Another Player other than "+hs);
                    p=sc.nextInt();
                }

                hs.add(p);
                System.out.println(varr.goalkeeper.get(p-1)+" - Base Value - "+varr.price1.get(p-1));
                int index=-1;
                count=-1;
                int y=0;
                while(count!=1)
                {
                    count=0;
                    if(flag1==false)
                    {
                        if(index!=0) {
                            System.out.println("Team 1 wants to bid or not Y/N");
                            char ch = sc.next().charAt(0);
                            if (ch == 'Y')
                            {
                                count++;
                                System.out.println("Enter new bidding amount");
                                int z = sc.nextInt();
                                if (z >= varr.price1.get(p - 1))
                                {
                                    y = z;
                                    index = 0;
                                    varr.price1.set(p - 1, z);
                                }
                                else
                                {
                                    System.out.println("Value should be greater than the last bidding value");
                                }
                            }

                        }
                        else {
                            count++;
                        }
                    }

                    if(flag2==false)
                    {
                        if(index!=1)
                        {
                            System.out.println("Team 2 wants to bid or not Y/N");
                            char ch=sc.next().charAt(0);
                            if(ch=='Y')
                            {
                                count++;
                                System.out.println("Enter new bidding amount");
                                int z=sc.nextInt();
                                if(z>=varr.price1.get(p-1))
                                {
                                    y=z;
                                    index=1;
                                    varr.price1.set(p-1,z);
                                }
                                else
                                {
                                    System.out.println("Value should be greater than the last bidding value");
                                }
                            }

                        }
                        else
                        {
                            count++;
                        }

                    }

                    if(flag3==false)
                    {
                        if(index!=2) {
                            System.out.println("Team 3 wants to bid or not Y/N");
                            char ch = sc.next().charAt(0);
                            if (ch == 'Y') {
                                count++;
                                System.out.println("Enter new bidding amount");
                                int z = sc.nextInt();
                                if (z >= varr.price1.get(p - 1)) {
                                    y = z;
                                    index = 2;
                                    varr.price1.set(p - 1, z);
                                } else {
                                    System.out.println("Value should be greater than the last bidding value");
                                }
                            }

                        }
                        else
                        {
                            count++;
                        }
                    }

                    if(flag4==false)
                    {
                        if(index!=3)
                        {
                            System.out.println("Team 4 wants to bid or not Y/N");
                            char ch=sc.next().charAt(0);
                            if(ch=='Y')
                            {
                                count++;
                                System.out.println("Enter new bidding amount");
                                int z=sc.nextInt();
                                if(z>=varr.price1.get(p-1))
                                {
                                    y=z;
                                    index=3;
                                    varr.price1.set(p-1,z);
                                }
                                else
                                {
                                    System.out.println("Value should be greater than the last bidding value");

                                }
                            }

                        }
                        else
                        {
                            count++;
                        }

                    }

                }
                if(index==0)
                {
                    a++;
                    if(a==3)
                    {
                        flag1=true;
                    }

                    varr.al1.add(varr.defender.get(p-1)+" - (M) ");
                    varr.teambudget1-=varr.price1.get(p-1);
                    System.out.println("MidFielder has been alloted to Team 1");
                }
                else if(index==1)
                {
                    b++;
                    if(b==3)
                    {
                        flag2=true;
                    }

                    varr.al2.add(varr.defender.get(p-1)+" - (M) ");
                    varr.teambudget2-=varr.price1.get(p-1);
                    System.out.println("MidFielder has been alloted to Team 2");
                }
                else if(index==2)
                {
                    c++;
                    if(c==3)
                    {
                        flag3=true;
                    }

                    varr.al3.add(varr.defender.get(p-1)+" - (M) ");
                    varr.teambudget3-=varr.price1.get(p-1);
                    System.out.println("MidFielder has been alloted to Team 3");
                }
                else if(index==3)
                {
                    d++;
                    if(d==3)
                    {
                        flag4=true;
                    }
                    varr.al4.add(varr.defender.get(p-1)+" - (M) ");
                    varr.teambudget4-=varr.price1.get(p-1);
                    System.out.println("MidFielder has been alloted to Team 4");
                }

            }
        }
        else
        {
            a=0;
            b=0;
            c=0;
            d=0;
            HashSet<Integer> hs1=new HashSet<Integer>();
            int max=12;
            int min=1;
            for(int x=1;x<=12;x++)
            {
                Random rand = new Random();
                int randomNum = rand.nextInt((max - min) + 1) + min;
                while(hs1.contains(randomNum))
                {
                    randomNum = rand.nextInt((max - min) + 1) + min;
                }
                hs1.add(randomNum);
                if(a<3)
                {
                    a++;
                    varr.al1.add(varr.midfielder.get(randomNum-1)+" - (M) ");
                    varr.teambudget1-=varr.price1.get(randomNum-1);
                }
                else if(b<3)
                {
                    b++;
                    varr.al2.add(varr.midfielder.get(randomNum-1)+" - (M) ");
                    varr.teambudget2-=varr.price1.get(randomNum-1);
                }
                else if(c<3)
                {
                    c++;
                    varr.al3.add(varr.midfielder.get(randomNum-1)+" - (M) ");
                    varr.teambudget3-=varr.price1.get(randomNum-1);
                }
                else
                {
                    d++;
                    varr.al4.add(varr.midfielder.get(randomNum-1)+" - (M) ");
                    varr.teambudget4-=varr.price1.get(randomNum-1);
                }
            }

        }

        System.out.println(varr.al1);
        System.out.println(varr.al2);
        System.out.println(varr.al3);
        System.out.println(varr.al4);
        System.out.println("Budget left for team 1 = "+varr.teambudget1);
        System.out.println("Budget left for team 2 = "+varr.teambudget2);
        System.out.println("Budget left for team 3 = "+varr.teambudget3);
        System.out.println("Budget left for team 4 = "+varr.teambudget4);


        //Forwards
        //Positions-Display Time
        //Swing -details print

        hs.clear();
        varr.price1.clear();


        flag1=false;
        flag2=false;
        flag3=false;
        flag4=false;
        System.out.println();
        System.out.println("Bidding for forwards\n");
        count=1;
        low=9000;
        high=11000;
        diff=high-low;
        for(String x: varr.forward)
        {
            int e=randomgeerator(diff,low);
            System.out.println(count+" "+x+" - "+e);
            varr.price1.add(e);
            count++;
        }

        a=0;b=0;c=0;d=0;
        System.out.println("Enter 1 if u want to bid and any number if u want to randomly allocate player to team");
        v=sc.nextInt();
        if(v==1)
        {
            for(int x=1;x<=8;x++)
            {
                System.out.println("\nEnter player on which u want to bid");
                int p=sc.nextInt();
                if(hs.contains(p))
                {
                    System.out.println(" This Player has already been alloten . Choose Another Player other than "+hs);
                    p=sc.nextInt();
                }

                hs.add(p);
                System.out.println(varr.goalkeeper.get(p-1)+" - Base Value - "+varr.price1.get(p-1));
                int index=-1;
                count=-1;
                int y=0;
                while(count!=1)
                {
                    count=0;
                    if(flag1==false)
                    {
                        if(index!=0) {
                            System.out.println("Team 1 wants to bid or not Y/N");
                            char ch = sc.next().charAt(0);
                            if (ch == 'Y')
                            {
                                count++;
                                System.out.println("Enter new bidding amount");
                                int z = sc.nextInt();
                                if (z >= varr.price1.get(p - 1))
                                {
                                    y = z;
                                    index = 0;
                                    varr.price1.set(p - 1, z);
                                }
                                else
                                {
                                    System.out.println("Value should be greater than the last bidding value");
                                }
                            }

                        }
                        else {
                            count++;
                        }
                    }

                    if(flag2==false)
                    {
                        if(index!=1)
                        {
                            System.out.println("Team 2 wants to bid or not Y/N");
                            char ch=sc.next().charAt(0);
                            if(ch=='Y')
                            {
                                count++;
                                System.out.println("Enter new bidding amount");
                                int z=sc.nextInt();
                                if(z>=varr.price1.get(p-1))
                                {
                                    y=z;
                                    index=1;
                                    varr.price1.set(p-1,z);
                                }
                                else
                                {
                                    System.out.println("Value should be greater than the last bidding value");
                                }
                            }

                        }
                        else
                        {
                            count++;
                        }

                    }

                    if(flag3==false)
                    {
                        if(index!=2) {
                            System.out.println("Team 3 wants to bid or not Y/N");
                            char ch = sc.next().charAt(0);
                            if (ch == 'Y') {
                                count++;
                                System.out.println("Enter new bidding amount");
                                int z = sc.nextInt();
                                if (z >= varr.price1.get(p - 1)) {
                                    y = z;
                                    index = 2;
                                    varr.price1.set(p - 1, z);
                                } else {
                                    System.out.println("Value should be greater than the last bidding value");
                                }
                            }

                        }
                        else
                        {
                            count++;
                        }
                    }

                    if(flag4==false)
                    {
                        if(index!=3)
                        {
                            System.out.println("Team 4 wants to bid or not Y/N");
                            char ch=sc.next().charAt(0);
                            if(ch=='Y')
                            {
                                count++;
                                System.out.println("Enter new bidding amount");
                                int z=sc.nextInt();
                                if(z>=varr.price1.get(p-1))
                                {
                                    y=z;
                                    index=3;
                                    varr.price1.set(p-1,z);
                                }
                                else
                                {
                                    System.out.println("Value should be greater than the last bidding value");

                                }
                            }

                        }
                        else
                        {
                            count++;
                        }

                    }

                }
                if(index==0)
                {
                    a++;
                    if(a==2)
                    {
                        flag1=true;
                    }

                    varr. al1.add(varr.defender.get(p-1)+" - (F) ");
                    varr.teambudget1-=varr.price1.get(p-1);
                    System.out.println("Striker has been alloted to Team 1");
                }
                else if(index==1)
                {
                    b++;
                    if(b==2)
                    {
                        flag2=true;
                    }

                    varr.al2.add(varr.defender.get(p-1)+" - (F) ");
                    varr.teambudget2-=varr.price1.get(p-1);
                    System.out.println("Striker has been alloted to Team 2");
                }
                else if(index==2)
                {
                    c++;
                    if(c==2)
                    {
                        flag3=true;
                    }

                    varr.al3.add(varr.defender.get(p-1)+" - (F) ");
                    varr.teambudget3-=varr.price1.get(p-1);
                    System.out.println("Striker has been alloted to Team 3");
                }
                else if(index==3)
                {
                    d++;
                    if(d==2)
                    {
                        flag4=true;
                    }
                    varr.al4.add(varr.defender.get(p-1)+" - (F) ");
                    varr.teambudget4-=varr.price1.get(p-1);
                    System.out.println("Striker has been alloted to Team 4");
                }

            }
        }
        else
        {
            a=0;
            b=0;
            c=0;
            d=0;
            HashSet<Integer> hs1=new HashSet<Integer>();
            int max=8;
            int min=1;
            for(int x=1;x<=8;x++)
            {
                Random rand = new Random();
                int randomNum = rand.nextInt((max - min) + 1) + min;
                while(hs1.contains(randomNum))
                {
                    randomNum = rand.nextInt((max - min) + 1) + min;
                }
                hs1.add(randomNum);
                if(a<2)
                {
                    a++;
                    varr.al1.add(varr.defender.get(randomNum-1)+" - (F) ");
                    varr.teambudget1-=varr.price1.get(randomNum-1);
                }
                else if(b<2)
                {
                    b++;
                    varr.al2.add(varr.defender.get(randomNum-1)+" - (F) ");
                    varr.teambudget2-=varr.price1.get(randomNum-1);
                }
                else if(c<2)
                {
                    c++;
                    varr. al3.add(varr.defender.get(randomNum-1)+" - (F) ");
                    varr.teambudget3-=varr.price1.get(randomNum-1);
                }
                else
                {
                    d++;
                    varr.al4.add(varr.defender.get(randomNum-1)+" - (F) ");
                    varr.teambudget4-=varr.price1.get(randomNum-1);
                }
            }
        }
        System.out.println(varr.al1);
        System.out.println(varr.al2);
        System.out.println(varr.al3);
        System.out.println(varr.al4);
        System.out.println("Budget left for team 1 = "+varr.teambudget1);
        System.out.println("Budget left for team 2 = "+varr.teambudget2);
        System.out.println("Budget left for team 3 = "+varr.teambudget3);
        System.out.println("Budget left for team 4 = "+varr.teambudget4);




        Listing l=new Listing(  varr.al1,varr.teambudget1,s[0],team_id[0]);
        Listing l1=new Listing(varr.al2,varr.teambudget2,s[1],team_id[1]);
        Listing l2=new Listing(varr.al3,varr.teambudget3,s[2],team_id[2]);
        Listing l3=new Listing(varr.al4,varr.teambudget4,s[3],team_id[3]);

   }
    public int randomgeerator(int d,int low)
    {
        Random r=new Random();
        int result=r.nextInt(d)+low;
        while(result%100!=0)
        {
            result++;
        }
        return result;

    }
}

public class proj {

    public static void main(String[] args)
    {
        System.out.println();
        Scanner sc=new Scanner(System.in);
        Auction au=new Auction();
        au.display();
        System.out.println();
        int team_id[]=new int[4];
        String s[]=new String[4];
        String s1[]=new String[4];
        for(int x=0;x<=3;x++)
        {
            System.out.println("Enter team ID for team "+(x+1));
            team_id[x]=sc.nextInt();
            System.out.println("Enter Name for team "+(x+1));
            s[x]=sc.next();
            System.out.println();

        }

        Teams A =new Teams(team_id[0],s[0],70000);
        Teams B =new Teams(team_id[1],s[1],70000);
        Teams C =new Teams(team_id[2],s[2],70000);
        Teams D =new Teams(team_id[3],s[3],70000);


        Calculations c=new Calculations();
        c.calculate(team_id,s);


    }

}

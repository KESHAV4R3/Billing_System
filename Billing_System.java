/*
this programm is about to calculate the bill of the restaurat 
variable and methods used in the programm :- 
1. foodList[] --> int array ti store order data 
2. name --> String to store name of customer
3. time --> String to store time of customer
4. temp1 , temp2 are temporary variables to Store the temporary data 
5. dishNum --> int to store total number of dish 
6. amount --> temporary float to calculate the total payable amount by the customer 
7. billCalculation --> method to calculate the bill
9. attempts --> variable to restrict the number of attempts to input wrong time 
 */

// testig for fork working message

import java.util.*;

class Billing_System {
    public static void billCalculation(int dishNum, int foodList[]) {
        float amount = 0;
        for (int i = 0; i < dishNum; i++) {
            switch (foodList[i]) {
                case 1:
                    amount = amount + 199;
                    break;
                case 2:k
                    amount = amount + 699;
                    break;
                case 3:
                    amount = amount + 229;
                    break;
                case 4:
                    amount = amount + 499;
                    break;
                case 5:
                    amount = amount + 149;
                    break;
                case 6:
                    amount = amount + 109;
                    break;
                case 7:
                    amount = amount + 105;
                    break;
                case 8:
                    amount = amount + 299;
                    break;
                default:
            }
        }
        if (amount > 1000 && amount <= 1500) {
            System.out.println("AMOUNT :- " + amount);
            System.out.println("DISCOPUNT = 5% ");
            System.out.println("FINAL AMOUNT :- " + amount);
        }
        else if (amount > 1500 && amount <= 2500) {
            System.out.println("AMOUNT :- " + amount);
            System.out.println("DISCOPUNT = 10% ");
            System.out.println("FINAL AMOUNT :- " + (amount - amount / 20));
        }
        else {
            System.out.println("AMOUNT :- " + amount);
            System.out.println("DISCOPUNT = 15% ");
            System.out.println("FINAL AMOUNT :- " + (amount - amount / 10));
        }
    }
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        while (true) {
            int temp1 = 0, temp2 = 0; // these are temporary variables
            int attempts = 0; // variable to restrict the wrong input of time
            int dishNum; // to store total dish to be ordered
            String name, time;
            System.out.print("ENTER YOUR NAME :- ");
            s.next();
            name = s.nextLine();
            System.out.print("ENTER THE TIME (HH:MM):- ");
            time = s.next();
            temp1 = Integer.parseInt(time.substring(0, time.indexOf(":")));
            temp2 = Integer.parseInt(time.substring(time.indexOf(":") + 1));
            while (temp1 < 0 || temp1 > 23 || temp2 < 0 || temp2 > 59) {
                attempts++;
                if (attempts >= 5) {
                    System.out.println("MAXIMUM LIMIT EXCEEDS ! TRY AGAIN ");
                    break;
                }
                System.out.print("ENTER THE TIME (HH:MM):- ");
                time = s.next();
                temp1 = Integer.parseInt(time.substring(0, time.indexOf(":")));
                temp2 = Integer.parseInt(time.substring(time.indexOf(":") + 1));
            }
            // if conditions are used to check whether the restaurants are open or not
            // and if it is open then place the order
            if (temp1 >= 8 && temp1 < 22 && temp2 > 0 && temp2 < 59) {
                // menu card to show
                System.out.println("OUTLET IS OPEN YOU CAN PLACE THE ORDER ! ");
                System.out.println("         XYZ CAFE");
                System.out.println("1. CHICKEN ROLLS :   " + 199);
                System.out.println("2. CHICKEN BUCKETS : " + 699);
                System.out.println("3. BIRYANI BUCKETS : " + 229);
                System.out.println("4. BOX MEALS :       " + 499);
                System.out.println("5. BURGERS :         " + 149);
                System.out.println("6. SNACKS :          " + 109);
                System.out.println("7. BEVERAGE :        " + 105);
                System.out.println("8. SPECIAL MEAL :    " + 299);
                System.out.print("ENTER THE TOTAL NUMBER OF DISH THAT YOU WANT TO ORDER :- ");
                dishNum = s.nextInt();
                System.out.println("ENTER THE DISH ONE BY ONE :- ");
                int foodList[] = new int[dishNum];// to store the orders
                for (int i = 0; i < dishNum; i++) {
                    System.out.print((i + 1) + " . :- ");
                    foodList[i] = s.nextInt();
                }
                // final display of bill
                System.out.println("NAME :-   " + name.toUpperCase());
                System.out.println("TIME :-   " + time);
                System.out.println("SGST : " + " 2.5 %");
                System.out.println("CGST : " + " 2.5 %");
                billCalculation(dishNum, foodList);
                System.out.println("THANK YOU VISIT AGAIN !! ");
                
            } else if (((temp1 >= 0 && temp1 < 8) || (temp1 >= 22 && temp1 < 24)) && temp2 > 0 && temp2 < 59) {
                System.out.println("OUTLET IS CLOSED !! ");
            }

        }
    }
}

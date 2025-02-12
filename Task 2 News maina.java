import java.util.*;

class news_mania {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> title = new ArrayList<>();
        ArrayList<String> description = new ArrayList<>();
        ArrayList<String> image = new ArrayList<>();
        title.add("keral");
        description.add("keral the untold story");
        image.add("keral.jpg");

        System.out.println("Enter 1 for Add news details : ");
        System.out.println("Enter 2 List news : ");
        System.out.println("Enter 3 for exit app : ");
        boolean bool = true;

        while (true) {
            System.out.print("Enter Choice : ");
            int choice = sc.nextInt();

            if (choice == 3) {
                System.out.println("Exit News App");
                break;
            } else if (choice == 1) {
                sc.nextLine();
                System.out.print("Enter News Title : ");
                String str = sc.nextLine();
                title.add(str);

                sc.nextLine();
                System.out.print("Enter News details: ");
                String str1 = sc.nextLine();
                description.add(str1);

                System.out.print("Enter News Photo Url : ");
                String str2 = sc.nextLine();
                image.add(str2);

            } else if (choice == 2) {
                System.out.println("----------List of news-------------");
                for (int i = 0; i < title.size(); i++) {

                    System.out.println("News Number : " + (i + 1));
                    System.out.println("News Title : " + title.get(i));
                    System.out.println("News details : " + description.get(i));
                    System.out.println("News Image : " + image.get(i));
                    System.out.println("-----------------------------------");

                }
            } else {
                System.out.println("you enter wrong choice");

            }

        } // end while loop

    }// end main funstion
}// end class

import java.util.Scanner;

//O(n) - complexity
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RealEstate realEstate = new RealEstate();
        int userChoice = Constant.INITIAL_VALUE_ZERO;
        while (userChoice!=Constant.FINISH_THE_PROGRAM) {
            do {
                System.out.println("Choose your desired option: between 1-3 ");
                System.out.println(Constant.MAIN_MENU);
                userChoice = scanner.nextInt();
            }while (userChoice>Constant.MAIN_MENU_MAXIMUM_RANG||userChoice<Constant.MAIN_MENU_MINIMUM_RANG);
            switch (userChoice) {
                case Constant.CREATE_USER-> realEstate.createUser();
                case Constant.LOG_IN_INTO_EXISTED_ACCOUNT-> {
                    User user = realEstate.login();
                    if (user!=null){
                        while (userChoice!=Constant.LOG_OUT_AND_RETURN_TO_THE_MAIN_MENU){
                        do {
                            System.out.println("Choose your desired option: between 1-6 ");
                            System.out.println(Constant.INTERNAL_MENU);
                            userChoice = scanner.nextInt();
                        }while (userChoice>Constant.INTERNAL_MENU_MAXIMUM_RANG||userChoice<Constant.INTERNAL_MENU_MINIMUM_RANG);
                        switch (userChoice){
                            case Constant.POST_NEW_PROPERTY-> {
                               if (realEstate.postNewProperty(user)){
                                   System.out.println("The property has been saved successfully");
                               }else {
                                   System.out.println("The property is not saved");
                               }
                            }
                            case Constant.REMOVE_PROPERTY_POST -> realEstate.removeProperty(user);
                            case Constant.VIEW_ALL_THE_PROPERTIES -> realEstate.printAllProperties();
                            case Constant.VIEW_ALL_THE_USERS_PROPERTIES -> realEstate.printProperties(user);
                            case Constant.SEARCH_PROPERTIES_WITH_FILTER ->{
                                Property [] filterPropertyArray = realEstate.search();
                                if (filterPropertyArray.length>0) {
                                    System.out.println("The properties according to your request:");
                                    for (int i = 0; i < filterPropertyArray.length; i++) {
                                        System.out.println(filterPropertyArray[i]);
                                    }
                                }else {
                                    System.out.println("No result found. ");
                                }
                            }
                        }
                    }}else {
                        System.out.println("User doesn't exist!\n You are taken to the main menu");
                        userChoice = Constant.LOG_OUT_AND_RETURN_TO_THE_MAIN_MENU;
                    }

                }
    }}}
}

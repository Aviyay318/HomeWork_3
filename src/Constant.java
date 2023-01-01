public class Constant {
    public static final  int CREATE_USER=1;
    public static final  int LOG_IN_INTO_EXISTED_ACCOUNT=2;
    public static final  int FINISH_THE_PROGRAM=3;

    public static final  int POST_NEW_PROPERTY=1;
    public static final  int REMOVE_PROPERTY_POST=2;
    public static final  int VIEW_ALL_THE_PROPERTIES=3;
    public static final  int VIEW_ALL_THE_USERS_PROPERTIES=4;
    public static final  int SEARCH_PROPERTIES_WITH_FILTER=5;
    public static final  int LOG_OUT_AND_RETURN_TO_THE_MAIN_MENU=6;

    public static final int APARTMENT = 1;
    public static final int PENTHOUSE = 2;
    public static final int HOUSE = 3;

    public static final int FOR_SALE = 1;
    public static final int FOR_RENT = 2;
    public static final int SKIP_SELECTION =-999;
    public static final int POST_LIMIT_REGULAR_ACCOUNT = 2;
    public static final int POST_LIMIT_BROKER_ACCOUNT = 5;

    public static final  int MAIN_MENU_MINIMUM_RANG=1;
    public static final  int MAIN_MENU_MAXIMUM_RANG=3;
    public static final  int INTERNAL_MENU_MINIMUM_RANG=1;
    public static final  int INTERNAL_MENU_MAXIMUM_RANG=6;
    public static final int BROKER = 1;
    public static final int REGULAR = 2;
    public static final int VALIDATION_ZERO_VALUE = 0;
    public static final int VALIDATION_ONE_VALUE = 1;
    public static  final int PASSWORD_VALIDATION_MINIMUM = 5 ;
    public static  final int PHONE_NUMBER_VALIDATION = 10;
    public static  final int PREFIX_START = 0;
    public static  final int PREFIX_END = 2;
    public static final String MAIN_MENU = "1: Create a new account\n" +
            "2: Login into an existing\n" +
            "3: Exit the program";
    public static final String INTERNAL_MENU = "1: Publish a new property\n" +
            "2: Remove a property\n" +
            "3: Show all properties\n" +
            "4: Show my properties\n" +
            "5: Search for property\n" +
            "6: Log out";

    public static final  int INITIAL_VALUE_ZERO=0;
    public static final  int INITIAL_VALUE_ONE=1;
    public static final String FOR_SALE_OR_RENT = """
                                    Please enter 
                                     1 for: Sale\s
                                     2 for: Rent\s""";
    public static final String PROPERTY_TYPE = "1 for: apartment\n" +
            "2 for: penthouse\n" + "3 for: house";
    public static final String FLOOR = "floor number";
    public static final String ROOMS = "rooms number";
    public static final String PROPERTY_PRICE = "property price";
    public static final int CITY_DOES_NOT_EXIST = -1;

}

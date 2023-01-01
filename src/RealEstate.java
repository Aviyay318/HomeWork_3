import java.util.Scanner;

public class RealEstate {
    private User[] users;
    private Property[] properties;
    private City[] cities;
    //O(1) - complexity
    public RealEstate() {
        this.cities = new City[10];
        this.cities[0] = new City("Eilat", "Negev-District", new String[]{"HaTmarim", "Shachamon", "Nirit"});
        this.cities[1] = new City("Beer-Sheva", "Negev-District",new String[]{"Bialik", "Rambam", "Hatzvi"});
        this.cities[2] = new City("Kiryat-Gat", "HaDarom-District",new String[]{"Hashoftim", "Tzaal", "Lachish"});
        this.cities[3] = new City("Ashkelon", "HaDarom-District",new String[]{"Neve-Shalom", "Rabin", "Bialik"});
        this.cities[4] = new City("Tel-Aviv", "Central-District", new String[]{"Morozov", "Dizingof", "Avital"});
        this.cities[5] = new City("Ramat-Gan", "Central-District", new String[]{"Avigail", "Einstein ", "Alonim"});
        this.cities[6] = new City("Hertzelia", "HaSharon-District",new String[]{"Marina", "Kaplan", "Beeri"});
        this.cities[7] = new City("Netanya", "HaSharon-District", new String[]{"Sokolov", "Herzel", "Remez"});
        this.cities[8] = new City("Harish", "Northen-District", new String[]{"Gefen", "Alon", "Rimon"});
        this.cities[9] = new City("Haifa", "Northen-District",new String[]{"Oren", "Hilel", "Nesher"});
        this.users = new User[Constant.INITIAL_VALUE_ZERO];
        this.properties = new Property[Constant.INITIAL_VALUE_ZERO];
    }
    //O(n) - complexity
    public void createUser() {
        Scanner scanner = new Scanner(System.in);
        Scanner scannerText = new Scanner(System.in);
        boolean isExist = false;
        boolean isBroker = false;
        int typeUser;
        String userName;
        String userPassword;
        String userPhoneNumber;
        int i;
        do {
            if (isExist) {
                System.out.println("This username is unavailable");
            }
            System.out.println("Please enter your username");
            userName = scannerText.nextLine();
            if (users != null) {
                for (i = 0; i < users.length; i++) {
                    if (userName.equals(users[i].getName())) {
                        isExist = true;
                        break;
                    }
                }
                if (i == users.length) {
                    isExist = false;
                }
            }
        } while (isExist);
        System.out.println("""
                Please enter a password according to these security rules:\s
                1. At least 5 characters.
                2. At least 1 digit
                3. At least 1 special characters from the following ($,%,_)""");
        userPassword = scannerText.nextLine();
        System.out.println("Please enter your phone number");
        userPhoneNumber = scannerText.nextLine();
        do {
            System.out.println("Are you a broker? choose: \n 1 for yes \n 2 for no");
            typeUser = scanner.nextInt();
            if (typeUser == Constant.BROKER) {
                isBroker = true;
            }
        } while (typeUser > Constant.REGULAR || typeUser < Constant.BROKER);
        User user = new User(userName, userPassword, userPhoneNumber, isBroker);
        while (user.getPassword() == null) {
            System.out.println("Invalid password!");
            userPassword = scannerText.nextLine();
            user.setPassword(userPassword);
        }
        while (user.getPhoneNumber() == null) {
            System.out.println("Invalid phone number!");
            userPhoneNumber = scannerText.nextLine();
            user.setPhoneNumber(userPhoneNumber);
        }
        this.users = addUserToArray(user);
    }

    //O(n) - complexity
    private User[] addUserToArray(User userToAdd) {
        User[] newUsers;
        if (this.users.length > Constant.INITIAL_VALUE_ZERO) {
            newUsers = new User[this.users.length + 1];
            for (int i = 0; i < this.users.length; i++) {
                newUsers[i] = this.users[i];
            }
        } else {
            newUsers = new User[Constant.INITIAL_VALUE_ONE];
        }
        newUsers[newUsers.length - 1] = userToAdd;
        return newUsers;
    }
    //O(n) - complexity
    public User login() {
        Scanner scanner = new Scanner(System.in);
        User newUser = null;
        if (this.users.length > Constant.INITIAL_VALUE_ZERO) {
            System.out.println("Enter your UserName");
            String username = scanner.nextLine();
            System.out.println("Enter your Password");
            String password = scanner.nextLine();
            for (int i = 0; i < this.users.length; i++) {
                if (this.users[i].getName().equals(username)) {
                    if (this.users[i].getPassword().equals(password)) {
                        newUser = this.users[i];
                        break;
                    }
                }
            }
        }
        return newUser;
    }
    //O(n) - complexity
    public boolean postNewProperty(User user) {
        Scanner scanner = new Scanner(System.in);
        boolean isPropertyPublished = true;
        int counterOfUserProperty = Constant.INITIAL_VALUE_ZERO;
        String cityName;
        String streetName;
        int propertyType;
        int floorNumber = Constant.INITIAL_VALUE_ZERO;
        int roomsNumber;
        int propertyNumber;
        int userInputStatus;
        boolean isForSale;
        double propertyPrice;
        boolean isValidInput = true;
        int indexOfCity = Constant.INITIAL_VALUE_ZERO;
        if (this.properties.length > Constant.INITIAL_VALUE_ZERO) {
            for (int i = 0; i < this.properties.length; i++) {
                if (user.getName().equals(this.properties[i].getUserProperty().getName())) {
                    counterOfUserProperty++;
                }
            }
            if (user.getIsBroker()) {
                if (counterOfUserProperty == Constant.POST_LIMIT_BROKER_ACCOUNT) {
                    System.out.println("You have reached the quota of assets to advertise");
                    isPropertyPublished = false;
                }
            } else {
                if (counterOfUserProperty == Constant.POST_LIMIT_REGULAR_ACCOUNT) {
                    System.out.println("You have reached the quota of assets to advertise");
                    isPropertyPublished = false;
                }
            }
        }
        if (isPropertyPublished) {
            isPropertyPublished = false;
            System.out.println("In which city do you want to advertise your property?");
            for (int i = 0; i < this.cities.length; i++) {
                System.out.println(this.cities[i].getName() + ",  " + this.cities[i].getGeographicDistrict());
            }
            System.out.println("Enter city Name");
            cityName = scanner.nextLine();
            for (int i = 0; i < this.cities.length; i++) {
                if (this.cities[i].getName().equals(cityName)) {
                    isPropertyPublished = true;
                    indexOfCity = i;
                }
            }
            if (!isPropertyPublished) {
                System.out.println("inValid city name");
            } else {
                isPropertyPublished = false;
                System.out.println("In which street do you want to advertise the property?");
                for (int i = 0; i < this.cities[indexOfCity].getStreets().length; i++) {
                    System.out.println(this.cities[indexOfCity].getStreets()[i]);
                }
                System.out.println("Enter street Name");
                streetName = scanner.nextLine();
                for (int i = 0; i < this.cities[indexOfCity].getStreets().length; i++) {
                    if (this.cities[indexOfCity].getStreets()[i].equals(streetName)) {
                        isPropertyPublished = true;
                    }
                }
                if (!isPropertyPublished) {
                    System.out.println("inValid street name");
                } else {
                    System.out.println("Enter the type of the property: \n" + Constant.PROPERTY_TYPE );
                    propertyType = scanner.nextInt();
                    if (propertyType < Constant.APARTMENT || propertyType > Constant.HOUSE) {
                        System.out.println("Invalid property type.");
                        isPropertyPublished = false;
                    } else {
                        if (propertyType == Constant.APARTMENT) {
                            do {
                                if (!isValidInput) {
                                    System.out.println("Incorrect floor number try again");
                                }
                                System.out.println("Please enter a number greater than zero for a floor number");
                                floorNumber = scanner.nextInt();
                                isValidInput = false;
                            } while (!greaterThanZeroValidation(floorNumber));
                        } isValidInput = true;
                        do {
                            if (!isValidInput) {
                                System.out.println("Incorrect rooms number try again");
                            }
                            System.out.println("Please enter a number greater than zero for a rooms number" );
                            roomsNumber = scanner.nextInt();
                            isValidInput = false;
                        } while (!greaterThanZeroValidation(roomsNumber));
                        isValidInput = true;
                        do {
                            if (!isValidInput) {
                                System.out.println("Incorrect property type try again");
                            }
                            System.out.println("Please enter a number greater than zero for a property number" );
                            propertyNumber = scanner.nextInt();
                            isValidInput = false;
                        } while (!greaterThanZeroValidation(propertyNumber));
                        isValidInput =true;
                        do {
                            if (!isValidInput) {
                                System.out.println("Incorrect try again");
                            }
                            System.out.println(Constant.FOR_SALE_OR_RENT);
                            userInputStatus = scanner.nextInt();
                            isValidInput = false;
                        } while (userInputStatus < Constant.FOR_SALE || userInputStatus > Constant.FOR_RENT);
                        if (userInputStatus == Constant.FOR_SALE) {
                            isForSale = true;
                        } else {
                            isForSale = false;
                        }
                        isValidInput = true;
                        do {
                            if (!isValidInput) {
                                System.out.println("Incorrect try again");
                            }
                            System.out.println("Please enter a number greater than zero for a property price");
                            propertyPrice = scanner.nextDouble();
                            isValidInput = false;
                        } while ((propertyPrice <= Constant.VALIDATION_ZERO_VALUE) || (propertyPrice % Constant.VALIDATION_ONE_VALUE != Constant.VALIDATION_ZERO_VALUE));
                        Property newProperty = new Property(cityName, streetName, roomsNumber, propertyPrice, propertyType, isForSale, propertyNumber, floorNumber, user);
                        this.properties = addPropertyToArray(newProperty);
                    }
                }
            }
        }
        return isPropertyPublished;

    }
    //O(n) - complexity
    private Property[] addPropertyToArray(Property propertyToAdd) {
        Property[] newProperty;
        if (this.properties.length > Constant.INITIAL_VALUE_ZERO) {
            newProperty = new Property[this.properties.length + Constant.INITIAL_VALUE_ONE];
            for (int i = 0; i < this.properties.length; i++) {
                newProperty[i] = this.properties[i];
            }
        } else {
            newProperty = new Property[Constant.INITIAL_VALUE_ONE];
        }
        newProperty[newProperty.length - 1] = propertyToAdd;
        return newProperty;
    }
    //O(n) - complexity
    public void removeProperty(User user) {
        Scanner scanner = new Scanner(System.in);
        boolean isPublishUserProperty = false;
        if (this.properties.length > Constant.INITIAL_VALUE_ZERO) {
            for (int i = 0; i < this.properties.length; i++) {
                if (user.getName().equals(this.properties[i].getUserProperty().getName())) {
                    isPublishUserProperty = true;
                    break;
                }
            }
            if (!isPublishUserProperty) {
                System.out.println("You have not published any property");
            } else {
                System.out.println("The property you have posted:");
                int[] indexUserPropertyArray;
                int indexOfUserPropertyArray = Constant.INITIAL_VALUE_ZERO;
                if (user.getIsBroker()) {
                    indexUserPropertyArray = new int[Constant.POST_LIMIT_BROKER_ACCOUNT];
                } else {
                    indexUserPropertyArray = new int[Constant.POST_LIMIT_REGULAR_ACCOUNT];
                }
                for (int i = 0; i < this.properties.length; i++) {
                    if (user.getName().equals(this.properties[i].getUserProperty().getName())) {
                        System.out.println(i + 1 + ":" + this.properties[i]);
                        indexUserPropertyArray[indexOfUserPropertyArray] = i;
                        indexOfUserPropertyArray++;
                    }
                }
                int userChoice;
                boolean isUserChoiceValid = true;
                do {
                    if (!isUserChoiceValid) {
                        System.out.println("Incorrect try again");
                    } else {
                        isUserChoiceValid = false;
                    }
                    System.out.println("Please choose the number of the property you want to removed");
                    userChoice = scanner.nextInt();
                    for (int i = 0; i <indexUserPropertyArray.length; i++) {
                        if ((i) == userChoice-1) {
                            isUserChoiceValid = true;
                            break;
                        }
                    }
                } while (!isUserChoiceValid);
                Property[] newProperties = new Property[this.properties.length - Constant.INITIAL_VALUE_ONE];
                int indexOfNewPropertiesArray = Constant.INITIAL_VALUE_ZERO;
                for (int i = 0; i < this.properties.length; i++) {
                    if (i != indexUserPropertyArray[userChoice - 1]) {
                        newProperties[indexOfNewPropertiesArray] = this.properties[i];
                        indexOfNewPropertiesArray++;
                    }
                }
                this.properties = newProperties;
                System.out.println("The property was removed successfully");
            }
        }
    }
    //O(n) - complexity
    public void printAllProperties() {
        if (this.properties.length > Constant.INITIAL_VALUE_ZERO) {
            for (int i = 0; i < this.properties.length; i++) {
                System.out.println(this.properties[i]);
            }
        } else {
            System.out.println("There are no properties to display");
        }
    }
    //O(n) - complexity
    public void printProperties(User user) {
        if (this.properties.length > Constant.VALIDATION_ZERO_VALUE) {
            System.out.println("Your properties:");
            for (int i = 0; i < this.properties.length; i++) {
                if (user.getName().equals(this.properties[i].getUserProperty().getName())) {
                    System.out.println(this.properties[i]);
                }
            }
        } else {
            System.out.println("You have no properties to display");
        }
    }
    //O(n) - complexity
    public Property[] search() {
        Scanner scanner = new Scanner(System.in);
        Property[] filterPropertyArray = new Property[]{};
        Integer propertyType;
        int roomsNumber;
        int userInputStatus;
        boolean isForSale;
        double minimumPrice;
        double maximumPrice;
        boolean isValidInput = true;
        if (this.properties.length > Constant.INITIAL_VALUE_ZERO) {
            System.out.println("Lets start:\n Please enter values as asked, if you want to skip any question insert '-999'");
            do {
                if (!isValidInput) {
                    System.out.println("Incorrect try again");
                }
                System.out.println("Is the property you're looking for is for Rent or Sale? Please enter:"
                        + Constant.FOR_SALE_OR_RENT);
                userInputStatus = scanner.nextInt();
                isValidInput = false;
            } while ((userInputStatus < Constant.FOR_SALE || userInputStatus > Constant.FOR_RENT) && userInputStatus != Constant.DEFAULT_SELECTION);
            if (userInputStatus == Constant.FOR_SALE) {
                isForSale = true;
            } else {
                isForSale = false;
            }
            isValidInput = true;
            do {
                if (!isValidInput) {
                    System.out.println("Incorrect try again");
                }
                System.out.println("Please provide the type of the property you're looking for: \n" + Constant.PROPERTY_TYPE);
                propertyType = scanner.nextInt();
                isValidInput = false;
            } while ((propertyType < Constant.APARTMENT || propertyType > Constant.HOUSE) && propertyType != Constant.DEFAULT_SELECTION);
            isValidInput = true;
            do {
                if (!isValidInput) {
                    System.out.println("Incorrect try again, Please enter a number greater than zero for a rooms number");
                }
                System.out.println("How many rooms in the property?");
                roomsNumber = scanner.nextInt();
                isValidInput = false;
            } while ((!greaterThanZeroValidation( roomsNumber)) && roomsNumber != Constant.DEFAULT_SELECTION);
            isValidInput = true;
            System.out.println("What is the desired price range?");
            do {
                if (!isValidInput) {
                    System.out.println("Incorrect try again,Please enter a number greater than zero for a minimum price");
                }
                System.out.println("Price from?");
                minimumPrice = scanner.nextDouble();
                isValidInput = false;
            } while ((minimumPrice < Constant.VALIDATION_ZERO_VALUE || minimumPrice % Constant.VALIDATION_ONE_VALUE != Constant.VALIDATION_ZERO_VALUE) && minimumPrice != Constant.DEFAULT_SELECTION);
            isValidInput = true;
            do {
                if (!isValidInput) {
                    System.out.println("Incorrect try again,Please enter a number greater than zero for a maximum price");
                }
                System.out.println("price to?");
                maximumPrice = scanner.nextDouble();
                isValidInput = false;
            } while ((maximumPrice < Constant.VALIDATION_ZERO_VALUE || maximumPrice % Constant.VALIDATION_ONE_VALUE != Constant.VALIDATION_ZERO_VALUE) && maximumPrice != Constant.DEFAULT_SELECTION);
            int counterOfFilterConditions = Constant.INITIAL_VALUE_ZERO;
            for (int i = 0; i < this.properties.length; i++) {
                if (isMeetsTheFilterConditions(userInputStatus, isForSale, propertyType, roomsNumber,
                        minimumPrice, maximumPrice, i)) {
                    counterOfFilterConditions++;
                }
            }
            filterPropertyArray = new Property[counterOfFilterConditions];
            int indexOfFilterPropertyArray = Constant.INITIAL_VALUE_ZERO;
            for (int i = 0; i < this.properties.length; i++) {
                if (isMeetsTheFilterConditions(userInputStatus, isForSale, propertyType, roomsNumber,
                        minimumPrice, maximumPrice, i)) {
                    filterPropertyArray[indexOfFilterPropertyArray] = this.properties[i];
                }
            }
        } else {
            System.out.println("There are no property to search");
        }
        return filterPropertyArray;
    }
    //O(1) - complexity
    private boolean isMeetsTheFilterConditions(int userInputStatus, boolean isForSale, int propertyType, int roomsNumber, double minimumPrice, double maximumPrice, int indexProperty) {
        boolean isMeetsTheFilterConditions = true;
        if (userInputStatus != Constant.DEFAULT_SELECTION) {
            if (isForSale != this.properties[indexProperty].isForSale()) {
                isMeetsTheFilterConditions = false;
            }
        }
        if (isMeetsTheFilterConditions) {
            if (propertyType != Constant.DEFAULT_SELECTION) {
                if (propertyType != this.properties[indexProperty].getType()) {
                    isMeetsTheFilterConditions = false;
                }
            }
        }
        if (isMeetsTheFilterConditions) {
            if (roomsNumber != Constant.DEFAULT_SELECTION) {
                if (roomsNumber != this.properties[indexProperty].getRoomNumbers()) {
                    isMeetsTheFilterConditions = false;
                }
            }
        }
        if (isMeetsTheFilterConditions) {
            if (minimumPrice != Constant.DEFAULT_SELECTION) {
                if (minimumPrice > this.properties[indexProperty].getPrice()) {
                    isMeetsTheFilterConditions = false;
                }
            }
        }
        if (isMeetsTheFilterConditions) {
            if (maximumPrice != Constant.DEFAULT_SELECTION) {
                if (maximumPrice < this.properties[indexProperty].getPrice()) {
                    isMeetsTheFilterConditions = false;
                }
            }
        }
        return isMeetsTheFilterConditions;
    }
    //O(1) - complexity
    private boolean greaterThanZeroValidation(int userInput) {
        boolean isValidInput = true;
        if (userInput <=  Constant.VALIDATION_ZERO_VALUE) {
            isValidInput = false;
        }
        return isValidInput;
    }
}

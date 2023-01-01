public class Property {
    private String cityName;
    private String street;
    private int roomNumbers;
    private double price;
    private Integer type;
    private boolean isForSale;
    private int houseNumber;
    private int floorNumber;
    private User userProperty;

    //O(1) - complexity
    public Property(String cityName, String street, int roomNumbers, double price, Integer type, boolean isForSale, int houseNumber, int floorNumber, User userProperty) {
        this.cityName = cityName;
        this.street = street;
        this.roomNumbers = roomNumbers;
        this.price = price;
        if (validationPropertyType(type)){
            this.type = type;
        }else {
            this.type = null;
        }
        this.isForSale = isForSale;
        this.houseNumber = houseNumber;
        this.floorNumber = floorNumber;
        this.userProperty = userProperty;
    }
    //O(1) - complexity
    public String toString() {
        String cityOutput="";
        cityOutput+= this.cityName + " - " +
                this.street +" " + this.houseNumber
                 +"\n"+ getPrintPropertyType() +
                " - " + getPrintStatus()+
                this.roomNumbers +" rooms ," + getPrintFloor() +
                "\n" + "Price: "+ this.price+
                "$" + "\n" +
                "Contact info:" + this.userProperty ;
        return cityOutput;
    }
    //O(1) - complexity
    private boolean validationPropertyType(Integer type){
        boolean isValid = true;
        if (type<Constant.APARTMENT||type>Constant.HOUSE){
            isValid = false;
        }
        return isValid;
    }
    //O(1) - complexity
    private String getPrintPropertyType(){
        String propertyType="";
        switch (this.type){
            case Constant.APARTMENT -> propertyType = "Regular apartment";
            case Constant.PENTHOUSE -> propertyType = "Penthouse";
            case Constant.HOUSE -> propertyType = "House";
        }
        return propertyType;
    }
    //O(1) - complexity
    private String getPrintStatus(){
        String status = "";
        if (isForSale){
            status = "for sale";
        }else {
            status = "for rent";
        }
        return status;
    }
    //O(1) - complexity
    private String getPrintFloor(){
        String floor = "";
        if (this.type != Constant.APARTMENT){
            floor = "floor " + this.floorNumber;
        }
        return floor;
    }
    //O(1) - complexity
    public User getUserProperty() {
        return userProperty;
    }
    //O(1) - complexity
    public boolean isForSale() {
        return isForSale;
    }
    //O(1) - complexity
    public int getRoomNumbers() {
        return roomNumbers;
    }
    //O(1) - complexity
    public double getPrice() {
        return price;
    }
    //O(1) - complexity
    public Integer getType() {
        return type;
    }

}

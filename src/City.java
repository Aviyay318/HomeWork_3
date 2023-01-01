public class City {
    private String name;
    private String geographicDistrict;
    private String [] streets;
    //O(1) - complexity
    public City(String name, String geographicDistrict, String [] streets) {
        this.name = name;
        this.geographicDistrict = geographicDistrict;
        this.streets = streets;
    }
    //O(1) - complexity
    public String toString() {
        String cityOutput;
        cityOutput= "The name of the city: " + this.name  +
                ", The geographic district: " + this.geographicDistrict  +
                ", List of streets: " + getPrintStreetsList()  ;
        return cityOutput;
    }
    //O(1) - complexity
    public String getName() {
        return name;
    }
    //O(1) - complexity
    public String getGeographicDistrict() {
        return geographicDistrict;
    }

    //O(1) - complexity
    public String[] getStreets() {
        return streets;
    }
    //O(n) - complexity
    private String getPrintStreetsList (){
        String listOfCityStreets="";
        for (int i=0;i<this.streets.length;i++){
            listOfCityStreets+=this.streets[i];
        }
        return listOfCityStreets;
    }
}

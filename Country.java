/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a_pe_csd_de1;



public class Country implements Comparable<Country> {
    public String CountryCode;
    public int Rank;
    public String Name;
    public double GPA;

    public Country(String countryCode, int rank, String name, String gpa) {
        CountryCode = countryCode;
        Rank = rank;
        Name = name;
        this.GPA = parseGPA(gpa);
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public int getRank() {
        return Rank;
    }

    public void setRank(int rank) {
        Rank = rank;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Country{" +
                "CountryCode='" + CountryCode + '\'' +
                ", Rank=" + Rank +
                ", Name='" + Name + '\'' +
                ", GPA=" + GPA +
                '}';
    }
    private double parseGPA(String gpa){
        try{
            return Double.parseDouble(gpa.replace(",","").replaceAll("\"",""));
        }catch (Exception e) {
            return 0.0;
        }
    }
    //A.compareTo(B) => A.countryCode so sánh với thằng other.CountryCode => 1/-1
    @Override
    public int compareTo(Country other) {
        return this.CountryCode.compareTo(other.CountryCode);
    }
}


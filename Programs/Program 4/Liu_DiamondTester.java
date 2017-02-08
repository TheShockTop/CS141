/***************************************************************
 * file: Liu_DiamondTester.java
 * author: T. Diaz
 * class: CS 141 - Programming and Problem Solving
 *
 * assignment: program 4
 * date last modified: 04 - February - 2017
 *
 * purpose: this program will sort diamonds and arrange them by quality
 * best quality to worst by the preassigned array.
 *
 ****************************************************************/
import java.util.Arrays;

class Liu_DiamondTester{
    // method: main
    // purpose: assigns value of diamonds and prints to console in order of quality
    public static void main ( String[] args ){
        Liu_Diamond[] stones = new Liu_Diamond[16];

        stones[0] = new Liu_Diamond( "A1023", 1.0, "VS1",  'F', "brilliant");
        stones[1] = new Liu_Diamond( "A5911", 1.1, "VVS2", 'G', "rose");
        stones[2] = new Liu_Diamond( "C5427", 1.0, "VS1",  'D', "princess");
        stones[3] = new Liu_Diamond( "D8307", 1.6, "SI1",  'H', "brilliant");
        stones[4] = new Liu_Diamond( "B4825", 0.3, "I1",   'D', "rose");
        stones[5] = new Liu_Diamond( "A1844", 2.1, "VS2",  'D', "lozenge");
        stones[6] = new Liu_Diamond( "A3747", 3.1, "SI2",  'W', "baguette");
        stones[7] = new Liu_Diamond( "E6393", 2.3, "VS2",  'I', "brilliant");
        stones[8] = new Liu_Diamond( "C5619", 2.8, "VVS1", 'E', "pear");
        stones[9] = new Liu_Diamond( "E8348", 1.4, "VS2",  'G', "brilliant");
        stones[10] = new Liu_Diamond( "D2381", 1.7, "I3",   'G', "brilliant");
        stones[11] = new Liu_Diamond( "C9253", 1.3, "VS2",  'H', "baguette");
        stones[12] = new Liu_Diamond( "G3459", 2.1, "VS2",  'H', "rose");
        stones[13] = new Liu_Diamond( "B3598", 2.4, "VVS2", 'D', "pear");
        stones[14] = new Liu_Diamond( "D9836", 2.8, "IF",   'E', "princess");
        stones[15] = new Liu_Diamond( "E1046", 2.2, "FL",   'E', "rose");

        Arrays.sort( stones );

        for ( int j=0; j<stones.length; j++ )
            System.out.println( stones[j].toString() );
    }

}

class Liu_Diamond implements Comparable<Liu_Diamond> {

    private String stockNumber;
    private double carot;
    private String clarity;
    private char color;
    private String cut;

    // Default case
    // method: Liu_Diamond
    // purpose: the default case for the method when called. assigns a default value.
    public Liu_Diamond(){

        stockNumber = "A0000";
        carot = 0.0;
        clarity = "FL";
        color = 'D';
        cut = "default";
    }

    // method: Liu_Diamond
    // purpose: assigns the primitive variables to the method called
    public Liu_Diamond(String diamondStockNumber, double diamondCarot, String diamondClarity, char diamondColor, String diamondCut){

        super();
        this.stockNumber = diamondStockNumber;
        this.carot = diamondCarot;
        this.clarity = diamondClarity;
        this.color = diamondColor;
        this.cut = diamondCut;
    }

    // method: getStock
    // purpose: returns stock number
    private String getStock(){
        return stockNumber;
    }

    // method: getCarot
    // purpose: returns Carot
    private double getCarot(){
        return carot;
    }

    // method: getClarity
    // purpose: returns clarity
    private String getClarity(){
        return clarity;
    }

    // method: getColor
    // purpose: returns color
    private char getColor(){
        return color;
    }

    // method: getCut
    // purpose: returns cut
    private String getCut(){
        return cut;
    }

    // method: toString
    // purpose: overrides the default print object and returns the overridden string
    @Override
    public String toString(){
        return "Stock No: " + this.getStock() + "\tCarat: " + this.getCarot() + "\tClarity: " +
                this.getClarity() + "\tColor: " + this.getColor() + "\tCut: " + this.getCut();
    }

    // method: compareTo
    // purpose: this method compares the diamond's properties by carot, then clarity, then color
    public int compareTo(Liu_Diamond other){

        int thisClarityComparison, otherClarityComparison;

        switch (this.getClarity()){
            case "FL": thisClarityComparison = -1;
                break;
            case "IF": thisClarityComparison = 0;
                break;
            case "VVS1": thisClarityComparison = 1;
                break;
            case "VVS2": thisClarityComparison = 2;
                break;
            case "VS1": thisClarityComparison = 3;
                break;
            case "VS2": thisClarityComparison = 4;
                break;
            case "SI1": thisClarityComparison = 5;
                break;
            case "SI2": thisClarityComparison = 6;
                break;
            case "I1": thisClarityComparison = 7;
                break;
            case "I2": thisClarityComparison = 8;
                break;
            case "I3": thisClarityComparison = 9;
                break;
            default: thisClarityComparison = 10;
                break;
        }

        switch (other.getClarity()){
            case "FL": otherClarityComparison = -1;
                break;
            case "IF": otherClarityComparison = 0;
                break;
            case "VVS1": otherClarityComparison = 1;
                break;
            case "VVS2": otherClarityComparison = 2;
                break;
            case "VS1": otherClarityComparison = 3;
                break;
            case "VS2": otherClarityComparison = 4;
                break;
            case "SI1": otherClarityComparison = 5;
                break;
            case "SI2": otherClarityComparison = 6;
                break;
            case "I1": otherClarityComparison = 7;
                break;
            case "I2": otherClarityComparison = 8;
                break;
            case "I3": otherClarityComparison = 9;
                break;
            default: otherClarityComparison = 11;
                break;
        }

        if (this.getCarot() > other.getCarot()){
            return Integer.MIN_VALUE;
        } else if (this.getCarot() < other.getCarot()){
            return Integer.MAX_VALUE;
        } else if (this.getCarot() == other.getCarot()){
            if (thisClarityComparison < otherClarityComparison){
                return Integer.MIN_VALUE;
            } else if (thisClarityComparison > otherClarityComparison){
                return Integer.MAX_VALUE;
            } else if (thisClarityComparison == otherClarityComparison){
                if (this.getColor() < other.getColor()){
                    return Integer.MIN_VALUE;
                } else if (this.getColor() > other.getColor()){
                    return Integer.MAX_VALUE;
                } else{
                    return Integer.MAX_VALUE;
                }
            } else{
                return Integer.MAX_VALUE;
            }
        } else{
            return Integer.MAX_VALUE;
        }
    }
}

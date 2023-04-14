public class MethodsPractice {

    public static void main(String[] args) {

        getConsumptionLevel('a');
        printCarDescription("Opel", 1999, "good");
    }

    static void getConsumptionLevel(char efficiencyCategory) {
        switch (Character.toUpperCase(efficiencyCategory)) {
            case 'A':
                System.out.println("Consumption level - very low");
                break;
            case 'B':
                System.out.println("Consumption level - low");
                break;
            case 'C':
                System.out.println("Consumption level - normal");
                break;
            case 'D':
                System.out.println("Consumption level - above normal");
                break;
            case 'E':
                System.out.println("Consumption level - high");
                break;
            case 'F':
                System.out.println("Consumption level - very high");
                break;
            case 'G':
                System.out.println("Consumption level - extremely high");
                break;
            default:
                System.out.println("Consumption level - not defined");
        }
    }

    static void printCarDescription(String carModel, int productionYear, String condition) {
        System.out.println("Car model: " + carModel);
        System.out.println("Production year: " + productionYear);
        System.out.println("Car condition: " + condition);
    }
}

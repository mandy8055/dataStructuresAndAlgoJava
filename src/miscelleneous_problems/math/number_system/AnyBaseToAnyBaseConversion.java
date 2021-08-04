package miscelleneous_problems.math.number_system;

public class AnyBaseToAnyBaseConversion {
    public static int getAnyToAnyBase(int n, int sourceBase, int destBase){
        int anyBaseToDecimal = AnyBaseToDecimalConversion.getValueInDecimal(n, sourceBase);
        return DecimalToAnyBaseConversion.getValueInAnyBase(anyBaseToDecimal, destBase);
    }
}

package programowanieof.laby.lab2;

public class Cylinder {
    
    private double baseRadius;
    private double height;

    public Cylinder(double height, double baseRadius) {
        this.baseRadius = baseRadius;
        this.height = height;
    }

    public Cylinder() {

    }

    double setBaseRadius(double baseRadiusToSet) {
        this.baseRadius = baseRadiusToSet;
        return this.baseRadius;
    }

    double setHeight(double heightToSet) {
        this.height = heightToSet;
        return this.height;
    }

    double getBaseRadius() {
        return this.baseRadius;
    }

    double getHeight() {
        return this.height;
    }

    double calculateBaseSurfaceArea() {
        return roundOff(Math.pow(baseRadius,2) * Math.PI);
    }

    double calculateLateralSufaceArea() {
        return roundOff(2 * Math.PI * baseRadius * height);
    }

    double calculateTotalSurfaceArea() {
        return roundOff(2 * calculateBaseSurfaceArea() + calculateLateralSufaceArea());
    }

    double calculateVolume() {
        return roundOff(calculateBaseSurfaceArea() * height);
    }

    boolean checkIfValuesArePositive() {
        if (baseRadius > 0 && height > 0) {
            return true;
        }
        return false;
    }

    double roundOff(double val) {
        return Math.round(val * 100.0) / 100.0;
    }
}

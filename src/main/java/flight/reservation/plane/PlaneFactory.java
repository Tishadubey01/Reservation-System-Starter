public class PlaneFactory {

    public PassengerPlane createPlane(String model) {
        switch (model) {
            case "A380":
                return new A380();
            case "A350":
                return new A350();
            case "Embraer 190":
                return new Embraer190();
            case "Antonov AN2":
                return new AntonovAN2();
            default:
                throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }
}

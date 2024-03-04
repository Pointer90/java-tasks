package train;

public class Train 
{
    private String destination;
    private int trainNumber;
    private String departureTime;
    private enum NumberOfSeats
    {
        GENERAL(100), COUPE(100), LUXURY(100), LOW_COST(100);
        private int countSeats;

        NumberOfSeats(){};
        NumberOfSeats(int value){countSeats = value;}

        public int getFreeSeats()
        {
            return countSeats;
        }

        public void setFreeSeats(int value)
        {
            countSeats = value;
        }
    }

    public Train(String destination, int trainNumber, String departureTime)
    {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
    }

    public void setNumberOfSeat(int value, String name)
    {
        NumberOfSeats ns = NumberOfSeats.valueOf(NumberOfSeats.class, name);
        ns.setFreeSeats(value);
    }

    @Override
    public String toString()
    {
        String seatsNum = "";
        for (NumberOfSeats seat : Nu)

        return String.format("\tDestination\tTrain number\tDeparture time\t\n\n\t%.14s\t%14d\t\t%.14s\n", destination, trainNumber, departureTime);
    }
}

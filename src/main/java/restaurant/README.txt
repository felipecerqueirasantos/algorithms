Employee
    EmployeeType (HOST|ATTENDANT)

Guest
    name
    id

PartyType
    LUNCH
    DINNER

Party
    date;
    guest;
    partyType;
    totalOfGuests;

Reservation
    List<Tables>
    Date expiration
    Party

Table
    int number
    int chairs

Availability
    List<Table>
    getTables(int numberOfGuests)

RestaurantResources
    List<Tables>

Restaurant
    Map<Date, Availability> availability

    boolean checkAvailability(Party)
    Reserve createReservation(Party)
    Reservation findReservation(Guest)
    confirm(Employee, Reservation)
    cancel(Employee, Reservation)


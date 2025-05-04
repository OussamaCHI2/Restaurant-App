/***********************************************************************
 * Module:  Reservation.java
 * Author:  AdMin
 * Purpose: Defines the Class Reservation
 ***********************************************************************/

import java.time.LocalDateTime;
/** @pdOid c1986334-5c29-4d22-87c8-afe76e3c7bbc */
public class Reservation {
    /** @pdOid 9b66cd6c-b8cd-42bf-b8b3-b2087eb3b4d7 */
    private int id;
    /** @pdOid ca857f64-4e15-4253-bc3c-cfebbf9137e9 */
    private int tableId;
    /** @pdOid e576d23d-deca-4603-b5c8-d1abec6ae440 */
    private int serveurId;
    /** @pdOid b56b6cbf-42cc-419f-9fa5-083cd3afe9f6 */
    private String clientName;
    /** @pdOid edc2021d-58b2-4194-8874-68e48d709e94 */
    private LocalDateTime reservationTime;

    // Constructor
    public Reservation(int id, int tableId, int serveurId, String clientName, LocalDateTime reservationTime) {
        this.id = id;
        this.tableId = tableId;
        this.serveurId = serveurId;
        this.clientName = clientName;
        this.reservationTime = reservationTime;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getServeurId() {
        return serveurId;
    }

    public void setServeurId(int serveurId) {
        this.serveurId = serveurId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }
}
package accommodation;

public class PaymentCompleted extends AbstractEvent{
    private int ReserveNo;
    private int PaymentId;
    private int ReservePrice;
    private String ReservationStatus;

    public String getReservationStatus() {
        return ReservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        ReservationStatus = reservationStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        PaymentStatus = paymentStatus;
    }

    private String PaymentStatus;

    public PaymentCompleted(){
        super();
    }

    public int getReservationNo() {
        return ReserveNo;
    }

    public void setReservationNo(int reservationNo) {
        this.ReserveNo = reservationNo;
    }

    public int getPaymentId() {
        return PaymentId;
    }

    public void setPaymentId(int paymentId) {
        this.PaymentId = paymentId;
    }

    public int getPaymentPrice() {
        return ReservePrice;
    }

    public void setPaymentPrice(int reservePrice) {
        this.ReservePrice = reservePrice;
    }

}

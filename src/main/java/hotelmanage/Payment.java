package hotelmanage;


import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Entity
@Table(name="Payment_table")
public class Payment {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int PaymentId; // 생성
    private int ReserveNo; // 받아야 되고
    private int ReservePrice; // 받아야되고
    private String ReserveStatus; //받아야되고
    private String PaymentStatus;//결재될떄 "Y" 로 셋팅

    @PrePersist
    public void onPrePersist() {
        if ("reserve".equals(ReserveStatus) ) {
            System.out.println("=============결재 승인 처리중=============");
            PaymentCompleted paymentCompleted = new PaymentCompleted();

            setPaymentStatus("Y");
            paymentCompleted.setPaymentId(PaymentId);
            System.out.printf("PaymentId : %d\n",PaymentId);
            paymentCompleted.setReservationNo(ReserveNo);
            System.out.printf("ReservationNumber : %d\n",ReserveNo);
            paymentCompleted.setPaymentPrice(ReservePrice);
            System.out.printf("PaymentPrice : %d\n",ReservePrice);
            paymentCompleted.setReservationStatus(ReserveStatus);
            System.out.printf("ReservationStatus : %s\n",ReserveStatus);
            paymentCompleted.setPaymentStatus(PaymentStatus);
            System.out.printf("PaymentStatus : %s\n",PaymentStatus);
            BeanUtils.copyProperties(this, paymentCompleted);
            paymentCompleted.publishAfterCommit();

            try {
                Thread.currentThread().sleep((long) (400 + Math.random() * 220));
                System.out.println("=============결재 승인 완료=============");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public int getPaymentId() {
        return PaymentId;
    }

    public void setPaymentId(int paymentId) {
        PaymentId = paymentId;
    }

    public int getReservationNumber() {
        return ReserveNo;
    }

    public void setReservationNo(int reservationNo) {
        ReserveNo = reservationNo;
    }

    public int getPaymentPrice() {
        return ReservePrice;
    }

    public void setPaymentPrice(int paymentPrice) {
        ReservePrice = paymentPrice;
    }

    public String getReservationStatus() {
        return ReserveStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        ReserveStatus = reservationStatus;
    }

    public String getPaymentStatus() {
        return PaymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        PaymentStatus = paymentStatus;
    }
}



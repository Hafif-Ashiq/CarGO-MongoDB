package Backend;

public class Payment {
    private int payment_id, CVV, card_no;
    private Date payment_date;

    public Payment(int payment_id, int CVV, int card_no, Date payment_date){
        this.payment_id = payment_id;
        this.CVV = CVV;
        this.card_no = card_no;

        if (payment_date != null){
            this.payment_date = payment_date;
        }
    }
    // setters
    public void setCard_no(int card_no) {
        this.card_no = card_no;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    // getters
    public Date getPayment_date() {
        return payment_date;
    }

    public int getCard_no() {
        return card_no;
    }

    public int getCVV() {
        return CVV;
    }

    public int getPayment_id() {
        return payment_id;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "payment_id=" + payment_id +
                ", CVV=" + CVV +
                ", card_no=" + card_no +
                ", payment_date=" + payment_date +
                '}';
    }
}


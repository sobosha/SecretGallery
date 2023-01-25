package com.example.gallerysecret;



public interface PurchaseEvent {
    void NormalPay();
    void SuccessPay(MarketResult result);
    void ErrorPay();
}

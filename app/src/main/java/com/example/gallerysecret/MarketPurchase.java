package com.example.gallerysecret;


import com.example.gallerysecret.Core.IView;
import com.example.gallerysecret.MainActivity;
import com.example.gallerysecret.Setting.ReqMarket;
import com.example.gallerysecret.Setting.nValue;
import com.example.gallerysecret.util.IabHelper;
import com.example.gallerysecret.util.IabResult;
import com.example.gallerysecret.util.Purchase;
import com.example.gallerysecret.Setting.Presenter;

public class MarketPurchase {


    public static void BuyMarket(final String sku, String bz, String takhfifCode, final PurchaseEvent event) {

        if (Integer.parseInt(bz) != 1) {
            event.NormalPay();
            return;
        }
        if (!MainActivity.getGlobal().ismIsMarketStore())
        {
            event.NormalPay();
            return;
        }

        MainActivity.getGlobal().getmHelper().launchPurchaseFlow(MainActivity.getGlobal(), sku, 999, new IabHelper.OnIabPurchaseFinishedListener() {
            @Override
            public void onIabPurchaseFinished(IabResult result, Purchase info) {
                if (result.isSuccess())
                    SetCoinCafeBazar(info,event);
                else {
                    event.ErrorPay();
                    Presenter.get_global().PostAction(new IView<MarketResult>() {
                        @Override
                        public void SendRequest() {

                        }

                        @Override
                        public void OnSucceed(MarketResult object) {
                        }

                        @Override
                        public void OnError(String error, int statusCode) {
                            int a = 0;
                        }
                    }, "market", "validate", "", new ReqMarket(sku, "FAILED",nValue.getValidateMarket()), MarketResult.class);
                }
            }
        }, takhfifCode);
    }

    private static void SetCoinCafeBazar(final Purchase info, final PurchaseEvent event) {
        MainActivity.getGlobal().getmHelper().consumeAsync(info,
                (purchase, result) -> {
                    if (result.isSuccess()) {
                        GetCoinCafeBazar(purchase,event);
                    } else
                        SetCoinCafeBazar(info,event);
                });
    }

    private static void GetCoinCafeBazar(final Purchase purchase, final PurchaseEvent event) {
        Presenter.get_global().PostAction(new IView<MarketResult>() {
            @Override
            public void SendRequest() {

            }

            @Override
            public void OnSucceed(MarketResult object) {
                if (object.isSuccess()) {
                    event.SuccessPay(object);
                } else
                    GetCoinCafeBazar(purchase,event);
            }

            @Override
            public void OnError(String error, int statusCode) {
                GetCoinCafeBazar(purchase,event);
            }
        }, "market", "validate", "", new ReqMarket(purchase.getSku(), purchase.getToken(), nValue.getValidateMarket()), MarketResult.class);
    }



}

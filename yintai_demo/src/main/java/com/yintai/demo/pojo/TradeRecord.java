package com.yintai.demo.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TradeRecord {
    /** 交易 ID. */
    private int tradeId;
    /** 创建时间. */
    private String createTime;
    /** 交易状态. */
    private boolean tradeStatus;// true , false
    /** 交易类型. */
    private int tradeType;// 1 支付 , 2 退款
    /** 交易金额. */
    private double tradeAmount;
    /** 交易币种. */
    private int tradeCurrency;// 1 人民币 , 2 美元
    /** 客户信息. */
    private User user;

    public TradeRecord(int tradeId, String createTime, boolean tradeStatus, int tradeType, double tradeAmount,
            int tradeCurrency, User user) {
        super();
        this.tradeId = tradeId;
        this.createTime = createTime;
        this.tradeStatus = tradeStatus;
        this.tradeType = tradeType;
        this.tradeAmount = tradeAmount;
        this.tradeCurrency = tradeCurrency;
        this.user = user;
    }

    public TradeRecord() {
    }

    public int getTradeId() {
        return tradeId;
    }

    public void setTradeId(int tradeId) {
        this.tradeId = tradeId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public boolean isTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(boolean tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public int getTradeType() {
        return tradeType;
    }

    public void setTradeType(int tradeType) {
        this.tradeType = tradeType;
    }

    public double getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(double tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public int getTradeCurrency() {
        return tradeCurrency;
    }

    public void setTradeCurrency(int tradeCurrency) {
        this.tradeCurrency = tradeCurrency;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
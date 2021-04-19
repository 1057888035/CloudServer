package com.cloud.springcloud.entities;

import lombok.Data;

@Data
public class PayOrder {
    String out_trade_no;

    String subject;

    String total_amount;

    String body;

    String timeout=100000+"";

    String product_code;
}

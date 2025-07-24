package com.controller;
// 支付宝要求回调域名必须是已备案的域名，不能使用localhost或IP地址。 只能尝试沙箱支付替代
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.utils.R;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RestController
@RequestMapping("/api/alipay")
public class AlipayController {
    // 沙箱支付 测试工具及其配置 https://open.alipay.com/develop/sandbox/app
    private static final String GATEWAY_URL = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";
    private static final String APP_ID = "9021000142654690";
    private static final String PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDLAESe2ei4aFtsZJh6gNH+lkKOiBolAtwvHP5kKDD6fKTVZByS2p9hQG2dnep/oYTaofCfsUp+MBckMykM6ADi60vYFnjlBJFD77iO9Mhl9fp6CElHpgGmT/kJKzvmQ9RfUtyHS0NbwN9fto2wZ2z0jrQSEbQf7ORqMe0UZ+npMkYR1THkJp059jZGrEn8OwT4vyig0mim8bXLs1rX7O70vixFA6QM2ocz22QNG6Ptt+T0mIJd/ZmUMxnFDx7SuimvwVA4GJAQs/XHLKg+gS4bu7wkhschqyI1HO5/pzQyn+3MnO0spoBGG+wK80hzdpJqx0S//1JRk7rgVFohIF6HAgMBAAECggEAGiYssLGtMqPusuW6Zn1Vj4/Xfvi1NXNK3Z7Efi5XMM0BhqNgsuIKicJ83ELNRCeQL4GQt2FlESAsuvMEJK91/cUFfg5XAFk4RSIKChAqCEhJPZL3rY0KxVuj3rR9AMpX/vdzhNIDGTydCX1AfyqzdEU1mOZC56HiQnOv8GL6VJl0XstuUEbHP0jJBiYVVodPFNzyYH7slJ31C/P3lKoUBr0a8raofi/1bUwYjEvEzc1/b9ebYSQbmSmZ0G+ar2wFkDHZ8o/dA/OzSf5IeFqK4iWv86nPYdSAXcvmLMDyNYdl+yp7A2hHoEnFHQFXspQHOXhAyCrsWBeNBr6W1opf8QKBgQD1Ehd8BvXDFJfr31bbblde1Fv3G93OvBiCRWnxD2kKMOiruN3+cJSnIiC3fOqDVEnYKG4Xm9TwWIpJnL2qEZepvYqXHyu3bpqDs9ySyLG6kEFgAYxosKtly0cMsF0vRgbbDKQQbKF44ON9Jiggw42vOrG9gW0ECkEP4ztNY8GTrQKBgQDUDeDacb+DanJbLNWZWp8BiQDne9GS9OZfUOKBellMBpMKSYFu4RiVAhif0Kb+87owDf++XvPQMSF5q7Osdbn4sSetgDdlll9WIB9t3gkXVlT/PenXNGn8wMxcbCeKlJuipzaZAiYNI8xf488yfC8vj3C8qd5nqOkawY1TqjqhgwKBgGpcRrr6XlEjL+gbzxt+4QZ0DdHKU1K1CcIIFDmd4Y2dum1E13vlKm76/c4Etdb3jvD0Ywt2A02ob6QRFbOo3PS7IVoDGjsLEp5UQkemOJRqpSTgpyqMema8eYKFTHwG3VTWQKIsM0w99h1LoSDPHj/NrnQ7pq+ZL7GQgh1NTSclAoGAYge8cB/vsjgOf7ndURTEtzf31Au4meBfc6b333WJPI05gqLylCi5bYFXkuIpoWlZJIgEN6S7v/5GhHHtEQgnniF/v0Sr12nJzw3wmaDwwPonNwwPQ262pKMYlo1lRjpnLK1ynw+QObjX7WhqS+N/CNSeAInjCDbc9IKP7CKhEjMCgYAuGeaCYs/+f8iKhGToBasUap0gpWudGvrecxKb+usyJUYA2wMvDQSf4xOLGvx/DGjMyWuiANjCVL6LeNb1KXgCXhZbzbmvYwjmaaQ5s73/HELaCJgwHLQBq2NXj6AArCeWpEutBZBbQtpK7wh/4PmjpFQvLaejZM88BMvqjvuovQ==";
    private static final String PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqA+MFVOpNIq6njXhPpJ5/iZGaMbtq/gUFuuF3fP/dRmsUY9pDq56wQ6emolC0sd5ol0UrVAy6R3tLwFpz4g0zHorKqXPOJ5JeBcQLkLTnWiQkkxmQW1djIxJMQnyXzeSrQEGngTXx+HbgIyEJkIJk6KpGLPSMbaS0CQkTbaypAuBVGVes7ep/7I9R/Pi6QejUO+pRxYQqcf9UHfkClmd48xr/bHfY5ox72yR7heb0LPp6/s64InBXJw7kuqfP+Ew/E4M6D21LmHqB9zwMDU4oDMLMrYFpNElHafNwFc/B5a1WqsrjRzuNMj8Fyk+3zDffQPkfgxBQ0bjLSrWg3SZgwIDAQAB";
    private static final String NOTIFY_URL = "http://localhost:8080/springboottvfo8kua/api/alipay/notify";
    private static final String RETURN_URL = "http://localhost:8082/#/index/center";
    
    @PostMapping("/create")
    public R createOrder(@RequestBody Map<String, Object> params) {
        try {
            AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, APP_ID, PRIVATE_KEY, "json", "UTF-8", PUBLIC_KEY, "RSA2");
            AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
            request.setReturnUrl(RETURN_URL);
            request.setNotifyUrl(NOTIFY_URL);
            
            Map<String, Object> bizContent = new HashMap<>();
            bizContent.put("out_trade_no", params.get("orderId"));
            bizContent.put("total_amount", params.get("amount"));
            bizContent.put("subject", params.get("subject"));
            bizContent.put("product_code", "FAST_INSTANT_TRADE_PAY");
            
            request.setBizContent(com.alibaba.fastjson.JSON.toJSONString(bizContent));
            
            String form = alipayClient.pageExecute(request).getBody();
            return R.ok().put("data", form);
        } catch (AlipayApiException e) {
            return R.error("创建支付订单失败");
        }
    }

    @PostMapping("/createQrCodeOrder")
    public R createQrCodeOrder(@RequestBody Map<String, Object> params) {
        try {
            AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, APP_ID, PRIVATE_KEY, "json", "UTF-8", PUBLIC_KEY, "RSA2");
            AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
            request.setNotifyUrl(NOTIFY_URL);
            request.setReturnUrl(RETURN_URL);
            
            Map<String, Object> bizContent = new HashMap<>();
            bizContent.put("out_trade_no", params.get("orderId"));
            bizContent.put("total_amount", params.get("amount"));
            bizContent.put("subject", params.get("subject"));
            
            request.setBizContent(com.alibaba.fastjson.JSON.toJSONString(bizContent));
            
            com.alipay.api.response.AlipayTradePrecreateResponse response = alipayClient.execute(request);
            if(response.isSuccess()){
                // 直接返回二维码链接
                String qrCode = response.getQrCode();
                if(qrCode != null && !qrCode.isEmpty()) {
                    return R.ok().put("data", qrCode);
                } else {
                    return R.error("生成二维码失败：二维码数据为空");
                }
            } else {
                return R.error("生成二维码失败：" + response.getMsg());
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
            return R.error("创建支付订单失败：" + e.getMessage());
        }
    }

    @GetMapping("/checkPayStatus/{orderId}")
    public R checkPayStatus(@PathVariable("orderId") String orderId) {
        try {
            AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, APP_ID, PRIVATE_KEY, "json", "UTF-8", PUBLIC_KEY, "RSA2");
            AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
            
            Map<String, Object> bizContent = new HashMap<>();
            bizContent.put("out_trade_no", orderId);
            
            request.setBizContent(com.alibaba.fastjson.JSON.toJSONString(bizContent));
            
            AlipayTradeQueryResponse response = alipayClient.execute(request);
            if(response.isSuccess()){
                Map<String, String> result = new HashMap<>();
                result.put("status", response.getTradeStatus());
                result.put("tradeNo", response.getTradeNo());
                return R.ok().put("data", result);
            } else {
                return R.error("查询支付状态失败：" + response.getMsg());
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
            return R.error("查询支付状态失败：" + e.getMessage());
        }
    }
    
    @PostMapping("/notify")
    public String notify(HttpServletRequest request) {
        Map<String, String> params = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = iter.next();
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        
        try {
            boolean signVerified = AlipaySignature.rsaCheckV1(params, PUBLIC_KEY, "UTF-8", "RSA2");
            if (signVerified) {
                String tradeStatus = params.get("trade_status");
                if ("TRADE_SUCCESS".equals(tradeStatus) || "TRADE_FINISHED".equals(tradeStatus)) {
                    // 更新订单状态
                    String orderId = params.get("out_trade_no");
                    // TODO: 调用订单服务更新订单状态
                    return "success";
                }
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return "fail";
    }
} 
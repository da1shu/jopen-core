package io.jopen.core.common.net.http;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务器预算
 *
 * @author maxuefeng
 */
public class ServerTest {




    /*每台应用类型服务器（8GB内存）大约容纳用户5000人*/

    /*OCR服务器  */

    public static void main(String[] args) {

        List<D1> r = new ArrayList<>();

        // 每台应用型服务器5000人
        int peopleNum = 5000;

        double serverPrice = 2437.80D;

        for (int i = 5000; i < 100000; ) {

            // 输出服务器台数
            int serverNumber = i / peopleNum;

            double totalPrice = serverNumber * serverPrice;

            D1 d1 = new D1();
            d1.peopleNum = i;
            d1.serverNum = serverNumber;
            d1.totalPrice = totalPrice;
            r.add(d1);

            i += 5000;
        }
        System.out.println(JSON.toJSONString(r));
    }


    static class D1 {
        public int peopleNum;
        public int serverNum;
        public double totalPrice;

        public int getPeopleNum() {
            return peopleNum;
        }

        public void setPeopleNum(int peopleNum) {
            this.peopleNum = peopleNum;
        }

        public int getServerNum() {
            return serverNum;
        }

        public void setServerNum(int serverNum) {
            this.serverNum = serverNum;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(int totalPrice) {
            this.totalPrice = totalPrice;
        }
    }
}

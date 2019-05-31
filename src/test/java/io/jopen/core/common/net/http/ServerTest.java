package io.jopen.core.common.net.http;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务器预算
 *
 * @author maxuefeng
 */
public class ServerTest {


    public List<D1> calculate(double serverPrice, int serverPeoNum, int offset, int start, int end) {
        List<D1> r = new ArrayList<>();

        for (int i = start; i < end; ) {

            // 输出服务器台数
            int serverNumber = i / serverPeoNum;

            double totalPrice = serverNumber * serverPrice;

            D1 d1 = new D1();
            d1.peopleNum = i;
            d1.serverNum = serverNumber;
            d1.totalPrice = totalPrice;
            r.add(d1);

            i += offset;
        }

        return r;
    }


    @Test
    public void test1() {

        int peopleNum = 5000;
        double serverPrice = 2437.80D;

        /*[5000,100000] 间隔为5000*/
        List<D1> R1 = calculate(serverPrice, peopleNum, 5000, 5000, 100000);

        /*[100000,1000000] 间隔为10万*/
        List<D1> R2 = calculate(serverPrice, peopleNum, 100000, 100000, 1000000);

        /*[1000000,10000000]  间隔为100万*/
        List<D1> R3 = calculate(serverPrice, peopleNum, 1000000, 1000000, 10000000);

        /*[10000000,100000000] 间隔为1000万*/
        List<D1> R4 = calculate(serverPrice, peopleNum, 10000000, 10000000, 100000000);

        /*[100000000,500000000] 间隔为1个亿*/
        List<D1> R5 = calculate(serverPrice, peopleNum, 10000000, 100000000, 500000000);

        System.err.println(R1);

        System.err.println(R2);
        System.err.println(R3);
        System.err.println(R4);
        System.err.println(R5);
    }

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

        @Override
        public String toString() {
            return "D1{" +
                    "peopleNum=" + peopleNum +
                    ", serverNum=" + serverNum +
                    ", totalPrice=" + totalPrice +
                    '}';
        }
    }
}

package io.jopen.core.common.json;

import org.json.JSONObject;
import org.junit.Test;

import java.io.Serializable;

/**
 * @author maxuefeng
 */
public class JsonTest {


    class People implements Serializable, Cloneable {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "People{" +
                    "name='" + name + '\'' +
                    '}';
//            Optional
        }
    }


    /**
     * 获取一个JSONObject的最外层的Key
     */
    @Test
    public void testGetKeys() {

        String jsonString = "{\"code\":{\"k\":\"v\"}}";
        JSONObject var = Json.of(jsonString);
        var.keySet().forEach(System.out::println);

    }

    /**
     * BUG
     */
    @Test
    public void testSimpleAPI() {

        People people = new People();

        people.setName("Jack");

        JSONObject jsonObject = Json.of(people);

        System.err.println(jsonObject.toString());

        //
        System.err.println("name:" + jsonObject.optString("name"));
    }


}

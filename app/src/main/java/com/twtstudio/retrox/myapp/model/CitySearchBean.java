package com.twtstudio.retrox.myapp.model;

import java.util.List;

/**
 * Created by retrox on 19/05/2017.
 */

public class CitySearchBean {


    public List<HeWeather5Bean> HeWeather5;

    public static class HeWeather5Bean {
        /**
         * basic : {"city":"朝阳","cnty":"中国","id":"CN101060110","lat":"43.86491013","lon":"125.31803894","prov":"吉林"}
         * status : ok
         */

        public BasicBean basic;
        public String status;

        public static class BasicBean {
            /**
             * city : 朝阳
             * cnty : 中国
             * id : CN101060110
             * lat : 43.86491013
             * lon : 125.31803894
             * prov : 吉林
             */

            public String city;
            public String cnty;
            public String id;
            public String lat;
            public String lon;
            public String prov;
        }
    }
}

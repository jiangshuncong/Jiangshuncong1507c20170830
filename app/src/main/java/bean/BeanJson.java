package bean;

import java.util.List;

/**
 * Created by 蒋順聪 on 2017/8/30.
 */

public class BeanJson {
    public Result result;
    public class Result{
        public List<Data> data;
        public class Data{
            public String title;
            public String date;
            public String author_name;
            public String thumbnail_pic_s;
        }
    }
}

package mdar.com.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.ui.ModelMap;

public class Util {

    private static volatile Util util;
    private Util(){}
    public static Util getInstance(){
        if(util == null) {
            synchronized(Util.class) {
                if(util == null) {
                   util = new Util();
                }
            }
        }
        return util;

    }

    public ModelMapper getMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        return modelMapper;
    }

}

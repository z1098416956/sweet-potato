package sweet.poato.config;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;

import java.io.IOException;
import java.lang.reflect.Type;


public class LongToStringFastJsonSerializer implements ObjectSerializer {


    public static final long MAX_LONG_TO_STRING = (long) Math.pow(10, 15);

    public static final LongToStringFastJsonSerializer instance = new LongToStringFastJsonSerializer();


    @Override
    public void write(JSONSerializer serializer,
                      Object object, Object fieldName, Type fieldType, int features)
            throws IOException {

        SerializeWriter out = serializer.out;
        if (object == null) {
            out.writeNull();
            return;
        }

        if(fieldType == null) {
        	out.writeString(object.toString());
        }else {
        	if (Long.class.getTypeName().equals(fieldType.getTypeName())
        			|| Long.TYPE.getTypeName().equals(fieldType.getTypeName())) {

        		long val = (Long) object;
        		if (val > MAX_LONG_TO_STRING) {
        			out.writeString(Long.toString(val));
        		} else {
        			out.writeLong(val);
        		}
        	} else {
        		out.writeString(object.toString());
        	}
        }
    }
}

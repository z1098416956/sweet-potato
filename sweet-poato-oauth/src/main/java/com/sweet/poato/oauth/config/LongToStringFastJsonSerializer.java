package com.sweet.poato.oauth.config;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @Author: TheSunshine
 * @Date: 2022/12/22 19:06
 * @Version 1.0
 */
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

        if (fieldType.getTypeName().equals(Long.class.getTypeName())
                || fieldType.getTypeName().equals(Long.TYPE.getTypeName())) {

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

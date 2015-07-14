package com.c24.rs.common;

import android.content.Context;
import android.content.SharedPreferences;

import org.androidannotations.annotations.EBean;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

@EBean
public class ComplexPreferences {

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    
    public ComplexPreferences (Context context) {
        preferences = context.getSharedPreferences("complex_preferences", Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void putObject(String key, Object object) throws IOException {
        if(object == null){
            throw new IllegalArgumentException("object is null");
        }

        if(key.equals("") || key == null){
            throw new IllegalArgumentException("key is empty or null");
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(object);
        oos.close();
        String str = new String(baos.toByteArray(), "ISO-8859-1");

        editor.putString(key, str);
    }

    public void commit() {
        editor.commit();
    }

    public <T> T getObject(String key, Class<T> cls) {

        String str = preferences.getString(key, null);
        if (str == null) {
            return null;
        } else {
            try{
                byte b[] = str.getBytes("ISO-8859-1");
                ByteArrayInputStream bi = new ByteArrayInputStream(b);
                ObjectInputStream si = new ObjectInputStream(bi);
                return cls.cast(si.readObject());
            } catch (Exception e) {
                throw new IllegalArgumentException("Object storaged with key " + key + " is instanceof other class");
            }
        }
    }

//    public static <T> T deserialize(String str, Class<T> cls) {
//        // deserialize the object
//        try {
//            // This encoding induces a bijection between byte[] and String (unlike UTF-8)
//            byte b[] = str.getBytes("ISO-8859-1");
//            ByteArrayInputStream bi = new ByteArrayInputStream(b);
//            ObjectInputStream si = new ObjectInputStream(bi);
//            return cls.cast(si.readObject());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}

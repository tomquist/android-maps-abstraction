package de.quist.app.maps.utils;

import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import de.quist.app.maps.MapsBinding;

public class MapsBindingResolver {

    private static final String TAG = MapsBindingResolver.class.getSimpleName();

    public static MapsBinding resolve(String bindingName) {
        try {
            Class bindingClass = MapsBindingResolver.class.getClassLoader().loadClass(bindingName);
            if (MapsBinding.class.isAssignableFrom(bindingClass)) {
                return (MapsBinding) bindingClass.newInstance();
            }
        } catch (ClassNotFoundException e) {
            int index = bindingName.lastIndexOf('.');
            if (index >= 0) {
                String fieldName = bindingName.substring(index + 1);
                String staticFieldContainerClassName = bindingName.substring(0, index);

                try {
                    Class bindingClass = MapsBindingResolver.class.getClassLoader().loadClass(staticFieldContainerClassName);
                    Field field = bindingClass.getField(fieldName);
                    if (!Modifier.isStatic(field.getModifiers()))  {
                        Log.e(TAG, "Field " + fieldName + " in " + staticFieldContainerClassName + " is not static");
                    } else if (!MapsBinding.class.isAssignableFrom(field.getType())) {
                        Log.e(TAG, "Field " + fieldName + " in " + staticFieldContainerClassName + " does not implement " + MapsBinding.class.getName());
                    } else {
                        if (!field.isAccessible()) {
                            field.setAccessible(true);
                        }
                        return (MapsBinding) field.get(null);
                    }
                } catch (ClassNotFoundException | NoSuchFieldException e1) {
                    Log.e(TAG, "Could not find " + bindingName);
                } catch (IllegalAccessException e1) {
                    Log.e(TAG, "Could not access " + bindingName, e1);
                }
            }
        } catch (InstantiationException e) {
            Log.e(TAG, "Could create an instance of" + bindingName, e);
        } catch (IllegalAccessException e) {
            Log.e(TAG, "Could not access " + bindingName, e);
        }
        return null;
    }

}

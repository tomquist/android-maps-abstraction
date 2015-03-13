package de.quist.app.maps.utils;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public abstract class Wrapper<T> {

    public static interface Mapper<InterfaceType, WrapperType extends InterfaceType, WrappedType> {
        WrappedType unwrap(InterfaceType wrapper);
        WrapperType wrap(WrappedType original);
    }
    protected static abstract class DefaultMapper<InterfaceType, WrapperType extends InterfaceType, WrappedType> implements Mapper<InterfaceType, WrapperType, WrappedType> {

        private final Map<WrappedType, WeakReference<WrapperType>> instances = new WeakHashMap<>();

        @Override
        public WrappedType unwrap(InterfaceType wrapper) {
            return Wrapper.unwrap(wrapper);
        }

        protected abstract WrapperType createWrapper(WrappedType original);

        public final WrapperType wrap(WrappedType original) {
            if (original == null) {
                return null;
            }
            WrapperType wrapper;
            synchronized (instances) {
                WeakReference<WrapperType> wrapperRef = instances.get(original);
                if (wrapperRef == null || (wrapper = wrapperRef.get()) == null) {
                    wrapper = createWrapper(original);
                    instances.put(original, new WeakReference<>(wrapper));
                }
            }
            return wrapper;
        }
    }

    protected static <T> T unwrap(Object wrapper) {
        return wrapper != null ? ((Wrapper<T>) wrapper).original : null;
    }

    protected final T original;

    public Wrapper(T original) {
        this.original = original;
    }

    @Override
    public int hashCode() {
        return original.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Wrapper) {
            Wrapper other = (Wrapper) o;
            return original.equals(other.original);
        }
        return original.equals(o);
    }

    @Override
    public String toString() {
        return original.toString();
    }

}

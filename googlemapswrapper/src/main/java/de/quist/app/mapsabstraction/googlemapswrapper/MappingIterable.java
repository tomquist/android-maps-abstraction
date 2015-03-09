package de.quist.app.mapsabstraction.googlemapswrapper;

import java.util.Iterator;

class MappingIterable<T, E> implements Iterable<E> {

    private final Iterable<T> original;
    private final IMapper<T, E> mapper;

    MappingIterable(Iterable<T> original, IMapper<T, E> mapper) {
        this.original = original;
        this.mapper = mapper;
    }

    public interface IMapper<T, E> {
        E map(T item);
    }

    private class MappingIterator<T, E> implements Iterator<E> {

        private final Iterator<T> original;
        private final IMapper<T, E> mapper;

        public MappingIterator(Iterator<T> original, IMapper<T, E> mapper) {
            this.original = original;
            this.mapper = mapper;
        }

        @Override
        public boolean hasNext() {
            return original.hasNext();
        }

        @Override
        public E next() {
            return mapper.map(original.next());
        }

        @Override
        public void remove() {
            original.remove();
        }

    }

    @Override
    public Iterator<E> iterator() {
        return new MappingIterator<>(original.iterator(), mapper);
    }
}

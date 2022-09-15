package kg.megacom.finalprodeject.mappers.base;

import java.util.List;

public interface CrudMapper<E,D> {
    E toEntity(D d);
    D toDto(E e);
    List<E> toEntityList(List<D> dList);
    List<D> toDtoList(List<E> eList);
}

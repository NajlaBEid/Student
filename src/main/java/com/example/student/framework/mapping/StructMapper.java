package com.example.student.framework.mapping;

import com.example.student.framework.model.DtoMeta;
import com.example.student.framework.model.EntityMeta;
import com.example.student.framework.model.ModelMeta;
import org.mapstruct.IterableMapping;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.Named;


import java.util.List;

/**
 * REST endpoint receives Model -> manipulates Entity
 * REST endpoint returns Dto -> from Entity
 *
 * REST request receives Model -> mapped to Entity and reflect to database -> mapped to Dto and send back as REST response
 *
 * @param <E> represent Entity class : mirroring database tables.
 * @param <M> represent Model class : used as rest requests.
 * @param <D> represent Dto class : used as rest response.
 */
@MapperConfig
public interface StructMapper<E extends EntityMeta, M extends ModelMeta, D extends DtoMeta>{

    /**
     * map Model to Entity
     */
    @Named("entity")
    E entity(final M model);
    @Named("entityIterable")
    @IterableMapping(qualifiedByName = "entity")
    List<E> entity(final List<M> model);

    @Named("forCreate")
    @Mapping(target = "deleted", constant = "false")
    @Mapping(target = "enabled", constant = "true")
    @Mapping(target = "lastModifiedByUsername", ignore = true)
    E forCreate(final M model);
    @Named("forCreateIterable")
    @IterableMapping(qualifiedByName = "forCreate")
    List<E> forCreate(final List<M> model);

    @Named("forUpdate")
    @Mapping(target = "deleted", constant = "false")
    @Mapping(target = "createdByUsername", ignore = true)
    E forUpdate(final M model);
    @Named("forUpdateIterable")
    @IterableMapping(qualifiedByName = "forUpdate")
    List<E> forUpdate(final List<M> model);

    /**
     * map Entity to Dto
     */
    @Named("dto")
    D dto(final E entity);
    @IterableMapping(qualifiedByName = "dto")
    List<D> dto(final List<E> entity);

}

package sistemaAlerta.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sistemaAlerta.entity.Parametro;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-15T13:07:43")
@StaticMetamodel(Sensor.class)
public class Sensor_ { 

    public static volatile SingularAttribute<Sensor, Double> longitud;
    public static volatile SingularAttribute<Sensor, Double> latitud;
    public static volatile SingularAttribute<Sensor, Integer> numeroDeSerie;
    public static volatile SingularAttribute<Sensor, Long> id;
    public static volatile SingularAttribute<Sensor, Parametro> ultimaMedicion;
    public static volatile SingularAttribute<Sensor, String> zonaGeografica;

}
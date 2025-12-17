package megacloud.vapeshopapi.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "vaper_desechables")
public class VaperDesechable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer anio;
    private Integer mililitros;
    private String estado;
    private String imagenProducto;

    @ManyToOne
    private Modelo modelo;

    @ManyToOne
    private Marca marca;

    @ManyToOne
    private PaisOrigen paisOrigen;

    @ManyToOne
    private TipoVaporizadores tipoVaporizadores;

    @ManyToOne
    private Sucursal sucursal;

    @ManyToOne
    private Sabor sabor;
}
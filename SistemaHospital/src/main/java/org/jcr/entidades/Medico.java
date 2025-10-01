package org.jcr.entidades;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true, exclude = {"departamento", "citas"})
@ToString(callSuper = true, exclude = {"departamento", "citas"})
public class Medico extends Persona {
    private final Matricula matricula;
    private final EspecialidadMedica especialidad;
    private Departamento departamento;
    private final List<Cita> citas = new ArrayList<>();

    public Medico(String nombre, String apellido, String dni, java.time.LocalDate fechaNacimiento,
                  TipoSangre tipoSangre, String numeroMatricula, EspecialidadMedica especialidad) {
        super(nombre, apellido, dni, fechaNacimiento, tipoSangre);
        this.matricula = new Matricula(numeroMatricula);
        this.especialidad = Objects.requireNonNull(especialidad, "La especialidad no puede ser nula");
    }

    // Getters generados por Lombok
    /*
    public Matricula getMatricula() {
        return matricula;
    }

    public EspecialidadMedica getEspecialidad() {
        return especialidad;
    }

    public Departamento getDepartamento() {
        return departamento;
    }
    */

    public void setDepartamento(Departamento departamento) {
        if (this.departamento != departamento) {
            this.departamento = departamento;
        }
    }

    public void addCita(Cita cita) {
        this.citas.add(cita);
    }

    public List<Cita> getCitas() {
        return Collections.unmodifiableList(new ArrayList<>(citas));
    }

    // toString generado por Lombok
    /*
    @Override
    public String toString() {
        return "Medico{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", especialidad=" + especialidad.getDescripcion() +
                ", matricula=" + matricula.getNumero() +
                '}';
    }
    */
}

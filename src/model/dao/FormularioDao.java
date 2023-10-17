package model.dao;



import model.dao.entites.Formulario;


public class FormularioDao {
    public interface FormularioDao {

        void insert(FormularioDao obj);
        void update(FormularioDao obj);
        void deleteById(Integer id);
        Formulario findById(Integer id);
        List<Formulario> findAll();
        List<Formulario> findByDepartment(Department department);
    }
}

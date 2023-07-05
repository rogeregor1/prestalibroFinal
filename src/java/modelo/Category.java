
package modelo;

/**
 *
 * @author familiahurtado
 */
public class Category {
    private int categoria_id;
    private String categoria;

    public Category() {
    }

    public Category(String categoria) {
        this.categoria = categoria;
    }

    public Category(int categoria_id) {
        this.categoria_id = categoria_id;
    }
    
    public Category(int categoria_id, String categoria) {
        this.categoria_id = categoria_id;
        this.categoria = categoria;
    }
    
    public int getCategoria_id() {
        return categoria_id;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "Categoria{" + "categoria_id=" + categoria_id + ", categoria=" + categoria + '}';
    }
    
    
            
    
}

/**
 * @author Lazaar El Mahdi
 * @version Fevrier 2023
 **/
public class Elements{
    protected double contenu;
    protected int cle;

    // Constructeur

    /*
     * Constructeur créant un élément de cle et contenu null
     */
    public Elements(){
        cle = 0;
        contenu = 0.0;
    }
    /**
     * Constructeur créant un élément avec a et b representant
     * respectivement la cle et le contenu
     * @param a la clé
     * @param b le contenu
     * */ 
    public Elements(int a, double b){
        this.cle = a;
        this.contenu = b;
    }
    // accesseur

    /**
     * accesseur au contenu de l'élément
     * @return contenu
     * */
    public double getContenu(){
        return contenu;
    }

    /**
     * Accesseur à la clé de l'élément
     * @return cle
     * */
    public int getCle(){
        return cle;
    }

    // modificateur

    /**
     * modificateur du contenu
     * @param _contenu le nouveau contenu
     * */
    public void setContenu(double _contenu){
        this.contenu = _contenu;
    }

    /**
     * modificateur de la cle
     * @param _cle la nouvelle cle
     **/
    public void setCle(int _cle){
        this.cle = _cle;
    }

    /*
     * repésentation de l'élément en chaîne de caractères
     */
    @Override
    public String toString(){
        String resultat = new String();
        resultat = resultat + "[ La cle est : " + getCle() + " " + "Le contenu est : " + getContenu() + " ]";
        return resultat;
    }
    public static void main(String[] args) {
        Elements e1 = new Elements();
        e1.setCle(20);
        e1.setContenu(19.75);
        System.out.println(e1);
    }
}